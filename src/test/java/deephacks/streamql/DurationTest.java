package deephacks.streamql;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DurationTest {
  private static final List<Type> list = new ArrayList<>();

  static Duration t1 = Duration.parse("PT15M");
  static Duration t2 = Duration.parse("PT16M");
  static Duration t3 = Duration.parse("PT17M");
  static Duration t4 = Duration.parse("PT18M");
  static Duration t5 = Duration.parse("PT19M");

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
    List<Type> result = execute("filter duration == 'PT15M' && duration != null");
    assertThat(result.size(), is(1));
    assertThat(result.get(0).getDuration(), is(t1));
  }

  @Test
  public void test_not_equals() {
    List<Type> result = execute("filter duration != null && duration != 'PT15M' ordered duration");
    assertThat(result.size(), is(4));
    assertThat(result.get(0).getDuration(), is(t2));
    assertThat(result.get(1).getDuration(), is(t3));
    assertThat(result.get(2).getDuration(), is(t4));
    assertThat(result.get(3).getDuration(), is(t5));

  }

  @Test
  public void test_lesserThan() {
    List<Type> result = execute("filter duration != null && duration < 'PT16M' ordered duration");
    assertThat(result.size(), is(1));
    assertThat(result.get(0).getDuration(), is(t1));
  }

  @Test
  public void test_lesser_equal() {
    List<Type> result = execute("filter duration != null && duration <= 'PT16M' ordered duration");
    assertThat(result.size(), is(2));
    assertThat(result.get(0).getDuration(), is(t1));
    assertThat(result.get(1).getDuration(), is(t2));
  }

  @Test
  public void test_biggerThan() {
    List<Type> result = execute("filter duration!= null && duration > 'PT15M' ordered duration");
    assertThat(result.size(), is(4));
    assertThat(result.get(0).getDuration(), is(t2));
    assertThat(result.get(1).getDuration(), is(t3));
    assertThat(result.get(2).getDuration(), is(t4));
    assertThat(result.get(3).getDuration(), is(t5));
  }

  @Test
  public void test_bigger_equal() {
    List<Type> result = execute("filter duration != null && duration >= 'PT16M' ordered duration");
    assertThat(result.size(), is(4));
    assertThat(result.get(0).getDuration(), is(t2));
    assertThat(result.get(1).getDuration(), is(t3));
    assertThat(result.get(2).getDuration(), is(t4));
    assertThat(result.get(3).getDuration(), is(t5));
  }

  @SuppressWarnings("unchecked")
  private List<Type> execute(String query) {
    List<Type> result = Query.collect(query, Type.class, list.stream());
    assertFalse(result.isEmpty());
    return result;
  }
}
