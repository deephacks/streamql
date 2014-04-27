package deephacks.streamql;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ZonedDateTimeTest {
  private static final List<Type> list = new ArrayList<>();

  static ZonedDateTime t1 = ZonedDateTime.parse("2013-01-01T01:00+01:00");
  static ZonedDateTime t2 = ZonedDateTime.parse("2013-01-02T01:00+01:00");
  static ZonedDateTime t3 = ZonedDateTime.parse("2013-01-03T01:00+01:00");
  static ZonedDateTime t4 = ZonedDateTime.parse("2013-01-04T01:00+01:00");
  static ZonedDateTime t5 = ZonedDateTime.parse("2013-01-05T01:00+01:00");

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
    List<Type> result = execute("filter zonedDateTime == '2013-01-02T01:00+01:00' && zonedDateTime!= null");
    assertThat(result.size(), is(1));
    assertThat(result.get(0).getZonedDateTime(), is(t2));
  }

  @Test
  public void test_not_equals() {
    List<Type> result = execute("filter zonedDateTime != null && zonedDateTime!= '2013-01-02T01:00+01:00' ordered zonedDateTime");
    assertThat(result.size(), is(4));
    assertThat(result.get(0).getZonedDateTime(), is(t1));
    assertThat(result.get(1).getZonedDateTime(), is(t3));
    assertThat(result.get(2).getZonedDateTime(), is(t4));
    assertThat(result.get(3).getZonedDateTime(), is(t5));
  }


  @Test
  public void test_lesserThan() {
    List<Type> result = execute("filter zonedDateTime!= null && zonedDateTime< '2013-01-02T01:00+01:00' ordered zonedDateTime");
    assertThat(result.size(), is(1));
    assertThat(result.get(0).getZonedDateTime(), is(t1));
  }

  @Test
  public void test_lesser_equal() {
    List<Type> result = execute("filter zonedDateTime!= null && zonedDateTime<= '2013-01-02T01:00+01:00' ordered zonedDateTime");
    assertThat(result.size(), is(2));
    assertThat(result.get(0).getZonedDateTime(), is(t1));
    assertThat(result.get(1).getZonedDateTime(), is(t2));
  }

  @Test
  public void test_biggerThan() {
    List<Type> result = execute("filter zonedDateTime!= null && zonedDateTime> '2013-01-02T01:00+01:00' ordered zonedDateTime");
    assertThat(result.size(), is(3));
    assertThat(result.get(0).getZonedDateTime(), is(t3));
    assertThat(result.get(1).getZonedDateTime(), is(t4));
    assertThat(result.get(2).getZonedDateTime(), is(t5));
  }

  @Test
  public void test_bigger_equal() {
    List<Type> result = execute("filter zonedDateTime!= null && zonedDateTime>= '2013-01-02T01:00+01:00' ordered zonedDateTime");
    assertThat(result.size(), is(4));
    assertThat(result.get(0).getZonedDateTime(), is(t2));
    assertThat(result.get(1).getZonedDateTime(), is(t3));
    assertThat(result.get(2).getZonedDateTime(), is(t4));
    assertThat(result.get(3).getZonedDateTime(), is(t5));
  }

  @SuppressWarnings("unchecked")
  private List<Type> execute(String query) {
    List<Type> result = Query.collect(query, Type.class, list.stream());
    assertFalse(result.isEmpty());
    return result;
  }
}
