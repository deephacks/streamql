package deephacks.streamql;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Ordering requires values to be Comparable.
 */
public class Query<T> {
  private final Class<T> type;
  private final Optional<Predicate<T>> predicate;
  private final Optional<Long> skip;
  private final Optional<Long> limit;
  private final Optional<Comparator<Object>> comparator;


  private Query(QueryBuilder<T> builder) {
    this.type = builder.type;
    this.comparator = builder.comparator;
    if (builder.predicates.size() == 1) {
      this.predicate = Optional.of(builder.predicates.pollLast());
    } else {
      this.predicate = Optional.empty();
    }
    this.skip = builder.skip;
    this.limit = builder.limit;
  }

  public static <T> Query<T> parse(String query, Class<T> cls) throws IllegalQueryException {
    ParseTree tree = getParseTree(query);
    QueryBuilder<T> builder = new StreamQl<>(QueryBuilder.builder(cls)).visit(tree);
    return builder.build();
  }

  public static Query<Object> parse(String query) throws IllegalQueryException {
    ParseTree tree = getParseTree(query);
    QueryBuilder<Object> builder = new StreamQl<>(QueryBuilder.builder(Object.class)).visit(tree);
    return builder.build();
  }

  private static ParseTree getParseTree(String query) {
    ByteArrayInputStream is = new ByteArrayInputStream(query.getBytes());
    try {
      ANTLRInputStream input = new ANTLRInputStream(is);
      deephacks.streamql.StreamQlLexer lexer = new deephacks.streamql.StreamQlLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      deephacks.streamql.StreamQlParser parser = new deephacks.streamql.StreamQlParser(tokens);
      return parser.parse();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public Class<?> getType() {
    return type;
  }

  public Optional<Long> getSkip() {
    return skip;
  }

  public Optional<Long> getLimit() {
    return limit;
  }

  public Optional<Predicate<T>> getPredicate() {
    return predicate;
  }

  public static Object execute(String query, Stream<?> stream) throws IllegalQueryException {
    return null;
  }

  public List<T> collect(Stream<T> stream) throws IllegalQueryException {
    if (getPredicate().isPresent()) {
      stream = stream.filter(getPredicate().get());
    }
    if (comparator.isPresent()) {
      stream = stream.sorted(comparator.get());
    }
    if (getSkip().isPresent()) {
      stream = stream.skip(getSkip().get());
    }
    if (getLimit().isPresent()) {
      stream = stream.limit(getLimit().get());
    }
    return stream.collect(Collectors.toList());
  }

  public static <T> List<T> collect(String query, Class<T> cls, Stream<T> stream) throws IllegalQueryException {
    Query<T> q = parse(query, cls);
    return q.collect(stream);
  }

  static class QueryBuilder<T> {
    private Class<T> type;
    private LinkedList<Predicate<T>> predicates = new LinkedList<>();
    private Optional<Comparator<Object>> comparator = Optional.empty();
    private Optional<Long> skip = Optional.empty();
    private Optional<Long> limit = Optional.empty();

    private QueryBuilder(Class<T> type) {
      this.type = type;
    }

    public static <T> QueryBuilder<T> builder(Class<T> cls) {
      return new QueryBuilder<>(cls);
    }

    public static QueryBuilder<Object> builder() {
      return new QueryBuilder<>(null);
    }

    public Query<T> build() {
      return new Query<>(this);
    }

    public QueryBuilder<T> setType(String type) {
      try {
        //noinspection unchecked
        this.type = (Class<T>) Class.forName(type);
      } catch (ClassNotFoundException e) {
        throw new IllegalArgumentException(e);
      }
      return this;
    }

    public Class<T> getType() {
      return type;
    }

    public QueryBuilder<T> addPredicate(Predicate<T> predicate) {
      this.predicates.add(predicate);
      return this;
    }

    public QueryBuilder<T> or(int num) {
      Predicate<T> predicate = predicates.pollLast();
      for (int i = 1; i < num; i++) {
        predicate = predicate.or(predicates.pollLast());
      }
      predicates.add(predicate);
      return this;
    }

    public QueryBuilder<T> and(int num) {
      Predicate<T> predicate = predicates.pollLast();
      for (int i = 1; i < num; i++) {
        predicate = predicate.and(predicates.pollLast());
      }
      predicates.add(predicate);
      return this;
    }

    public QueryBuilder<T> negate() {
      if (predicates.size() == 1) {
        predicates.get(0).negate();
      }
      return this;
    }

    public QueryBuilder<T> setOrdered(List<String> byIds) {
      this.comparator = Optional.of(getComparator(byIds));
      return this;
    }

    public QueryBuilder<T> setOrdered() {
      this.comparator = Optional.of(getComparator(new ArrayList<>()));
      return this;
    }

    public QueryBuilder<T> setReversed(List<String> byIds) {
      this.comparator = Optional.of(getComparator(byIds).reversed());
      return this;
    }

    public QueryBuilder<T> setReversed() {
      this.comparator = Optional.of(getComparator(new ArrayList<>()).reversed());
      return this;
    }

    private Comparator<Object> getComparator(List<String> byIds) {
      if (byIds.isEmpty() && !Comparable.class.isAssignableFrom(type)) {
        throw new IllegalQueryException("Cannot order on class since its not java.lang.Comparable ["+type+"].");
      }
      Comparator<Object> comparator;
      if (byIds != null && byIds.size() > 0) {
        ListIterator<String> it = byIds.listIterator();
        ValueAccessor valueAccessor = new ValueAccessor(Optional.ofNullable(it.next()), type);
        comparator = Comparators.getComparator(valueAccessor);
        while (it.hasNext()) {
          valueAccessor = new ValueAccessor(Optional.ofNullable(it.next()), type);
          comparator = comparator.thenComparing(Comparators.getComparator(valueAccessor));
        }
        return comparator;
      }
      return Comparators.comparableComparator();
    }

    public QueryBuilder<T> setSkip(Long skip) {
      this.skip = Optional.of(skip);
      return this;
    }

    public QueryBuilder<T> setLimit(Long limit) {
      this.limit = Optional.of(limit);
      return this;
    }
  }
}
