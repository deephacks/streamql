package deephacks.streamql;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LocalDateTimeTest {
  private static final List<Type> list = new ArrayList<>();

  static LocalDateTime t1 = LocalDateTime.parse("2013-01-01T01:00");
  static LocalDateTime t2 = LocalDateTime.parse("2013-01-02T01:00");
  static LocalDateTime t3 = LocalDateTime.parse("2013-01-03T01:00");
  static LocalDateTime t4 = LocalDateTime.parse("2013-01-04T01:00");
  static LocalDateTime t5 = LocalDateTime.parse("2013-01-05T01:00");

  @BeforeClass
  public static void before() {
    list.add(new Type(t1));
    list.add(new Type(t2));
    list.add(new Type(t3));
    list.add(new Type(t4));
    list.add(new Type(t5));

    Collections.shuffle(list);
  }

  @Test
  public void test_equals() {
    List<Type> result = execute("filter localDateTime== '2013-01-02T01:00' && localDateTime!= null");
    assertThat(result.size(), is(1));
    assertThat(result.get(0).getLocalDateTime(), is(t2));
  }

  @Test
  public void test_not_equals() {
    List<Type> result = execute("filter localDateTime!= null && localDateTime!= '2013-01-02T01:00' ordered localDateTime");
    assertThat(result.size(), is(4));
    assertThat(result.get(0).getLocalDateTime(), is(t1));
    assertThat(result.get(1).getLocalDateTime(), is(t3));
    assertThat(result.get(2).getLocalDateTime(), is(t4));
    assertThat(result.get(3).getLocalDateTime(), is(t5));
  }


  @Test
  public void test_lesserThan() {
    List<Type> result = execute("filter localDateTime!= null && localDateTime< '2013-01-02T01:00' ordered localDateTime");
    assertThat(result.size(), is(1));
    assertThat(result.get(0).getLocalDateTime(), is(t1));
  }

  @Test
  public void test_lesser_equal() {
    List<Type> result = execute("filter localDateTime!= null && localDateTime<= '2013-01-02T01:00' ordered localDateTime");
    assertThat(result.size(), is(2));
    assertThat(result.get(0).getLocalDateTime(), is(t1));
    assertThat(result.get(1).getLocalDateTime(), is(t2));
  }

  @Test
  public void test_biggerThan() {
    List<Type> result = execute("filter localDateTime!= null && localDateTime> '2013-01-02T01:00' ordered localDateTime");
    assertThat(result.size(), is(3));
    assertThat(result.get(0).getLocalDateTime(), is(t3));
    assertThat(result.get(1).getLocalDateTime(), is(t4));
    assertThat(result.get(2).getLocalDateTime(), is(t5));
  }

  @Test
  public void test_bigger_equal() {
    List<Type> result = execute("filter localDateTime!= null && localDateTime>= '2013-01-02T01:00' ordered localDateTime");
    assertThat(result.size(), is(4));
    assertThat(result.get(0).getLocalDateTime(), is(t2));
    assertThat(result.get(1).getLocalDateTime(), is(t3));
    assertThat(result.get(2).getLocalDateTime(), is(t4));
    assertThat(result.get(3).getLocalDateTime(), is(t5));
  }

  @SuppressWarnings("unchecked")
  private List<Type> execute(String query) {
    List<Type> result = Query.collect(query, Type.class, list.stream());
    assertFalse(result.isEmpty());
    return result;
  }
}
