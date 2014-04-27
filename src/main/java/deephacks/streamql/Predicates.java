package deephacks.streamql;

import java.io.Serializable;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Predicates {
  public static abstract class AbstractPredicate<T> implements Predicate<T>, Serializable {
    protected final ValueAccessor valueAccessor;
    protected final GrammarValue grammarValue;

    public AbstractPredicate(ValueAccessor valueAccessor, GrammarValue grammarValue) {
      this.valueAccessor = valueAccessor;
      this.grammarValue = grammarValue;
    }
  }

  public static class Eq<T> extends AbstractPredicate<T> {

    public Eq(ValueAccessor valueAccessor, GrammarValue grammarValue) {
      super(valueAccessor, grammarValue);
    }

    @Override
    public boolean test(T target) {
      Object targetValue = valueAccessor.getValue(target);
      Optional<Object> value = grammarValue.getValue();
      if (!value.isPresent() && targetValue == null) {
        return true;
      } else if (!value.isPresent()) {
        return false;
      } else if (targetValue == null) {
        return false;
      }
      return value.get().equals(targetValue);
    }
  }

  public static class NotEq<T> extends AbstractPredicate<T> {

    public NotEq(ValueAccessor valueAccessor, GrammarValue grammarValue) {
      super(valueAccessor, grammarValue);
    }

    @Override
    public boolean test(T target) {
      Object targetValue = valueAccessor.getValue(target);
      Optional<Object> value = grammarValue.getValue();
      if (!value.isPresent() && targetValue == null) {
        return false;
      } else if (!value.isPresent()) {
        return true;
      } else if (targetValue == null) {
        return true;
      }
      return !value.get().equals(targetValue);
    }
  }

  public static class Gt<T> extends AbstractPredicate<T> {

    public Gt(ValueAccessor valueAccessor, GrammarValue grammarValue) {
      super(valueAccessor, grammarValue);
    }

    @Override
    public boolean test(T target) {
      Object targetValue = valueAccessor.getValue(target);
      Optional<Object> value = grammarValue.getValue();
      return Comparators.greaterThan(targetValue, value.get());
    }
  }

  public static class GtEq<T> extends AbstractPredicate<T> {

    public GtEq(ValueAccessor valueAccessor, GrammarValue grammarValue) {
      super(valueAccessor, grammarValue);
    }

    @Override
    public boolean test(T target) {
      Object targetValue = valueAccessor.getValue(target);
      Optional<Object> value = grammarValue.getValue();
      return Comparators.greaterEqual(targetValue, value.get());
    }
  }

  public static class Lt<T> extends AbstractPredicate<T> {
    public Lt(ValueAccessor valueAccessor, GrammarValue grammarValue) {
      super(valueAccessor, grammarValue);
    }

    @Override
    public boolean test(T target) {
      Object targetValue = valueAccessor.getValue(target);
      Optional<Object> value = grammarValue.getValue();
      return Comparators.lessThan(targetValue, value.get());
    }
  }
  public static class LtEq<T> extends AbstractPredicate<T> {

    public LtEq(ValueAccessor valueAccessor, GrammarValue grammarValue) {
      super(valueAccessor, grammarValue);
    }

    @Override
    public boolean test(T target) {
      Object targetValue = valueAccessor.getValue(target);
      Optional<Object> value = grammarValue.getValue();
      return Comparators.lessEqual(targetValue, value.get());
    }
  }
  public static class Contains<T> extends AbstractPredicate<T> {

    public Contains(ValueAccessor valueAccessor, GrammarValue grammarValue) {
      super(valueAccessor, grammarValue);
    }

    @Override
    public boolean test(T target) {
      String str = grammarValue.getValue().get().toString();
      return valueAccessor.getValue(target).toString().contains(str);
    }
  }
  public static class StartsWith<T> extends AbstractPredicate<T> {

    public StartsWith(ValueAccessor valueAccessor, GrammarValue grammarValue) {
      super(valueAccessor, grammarValue);
    }

    @Override
    public boolean test(T target) {
      String str = grammarValue.getValue().get().toString();
      return valueAccessor.getValue(target).toString().startsWith(str);
    }
  }
  public static class EndsWith<T> extends AbstractPredicate<T> {

    public EndsWith(ValueAccessor valueAccessor, GrammarValue grammarValue) {
      super(valueAccessor, grammarValue);
    }

    @Override
    public boolean test(T target) {
      String str = grammarValue.getValue().get().toString();
      return valueAccessor.getValue(target).toString().endsWith(str);
    }
  }
  public static class RegExp<T> extends AbstractPredicate<T> {
    private Pattern pattern;
    public RegExp(ValueAccessor valueAccessor, GrammarValue grammarValue) {
      super(valueAccessor, grammarValue);
      String str = grammarValue.getValue().get().toString();
      pattern = Pattern.compile(str);
    }

    @Override
    public boolean test(T target) {
      return pattern.matcher(valueAccessor.getValue(target).toString()).matches();
    }
  }
}
