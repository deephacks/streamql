package deephacks.streamql;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * NOTE: every enum is comparable according to ordinal, which is the same order as
 * they are defined in source code. In the case of TimeUnit, each enum is defined from
 * smallest to largest unit which makes sense when ordering them.
 */
public class EnumTest {
  private static final List<Type> list = new ArrayList<>();

  @BeforeClass
  public static void before() {
    list.add(new Type(TimeUnit.NANOSECONDS));
    list.add(new Type(TimeUnit.MICROSECONDS));
    list.add(new Type(TimeUnit.MILLISECONDS));
    list.add(new Type(TimeUnit.SECONDS));
    list.add(new Type(TimeUnit.MINUTES));
    list.add(new Type(TimeUnit.HOURS));
    list.add(new Type(TimeUnit.DAYS));
    list.add(new Type((TimeUnit)null));

    Collections.shuffle(list);
  }

  @Test
  public void test_equals() {
    List<Type> result = execute("filter enum == 'SECONDS' && enum != null");
    assertThat(result.size(), is(1));
    assertThat(result.get(0).getEnum(), is(TimeUnit.SECONDS));
  }

  @Test
  public void test_not_equals() {
    List<Type> result = execute("filter enum != null && enum != 'MINUTES' ordered enum");
    assertThat(result.size(), is(6));
    assertThat(result.get(0).getEnum(), is(TimeUnit.NANOSECONDS));
    assertThat(result.get(1).getEnum(), is(TimeUnit.MICROSECONDS));
    assertThat(result.get(2).getEnum(), is(TimeUnit.MILLISECONDS));
    assertThat(result.get(3).getEnum(), is(TimeUnit.SECONDS));
    assertThat(result.get(4).getEnum(), is(TimeUnit.HOURS));
    assertThat(result.get(5).getEnum(), is(TimeUnit.DAYS));
  }

  @Test
  public void test_lesserThan() {
    List<Type> result = execute("filter enum < 'SECONDS' && enum != null ordered enum");
    assertThat(result.size(), is(3));
    assertThat(result.get(0).getEnum(), is(TimeUnit.NANOSECONDS));
    assertThat(result.get(1).getEnum(), is(TimeUnit.MICROSECONDS));
    assertThat(result.get(2).getEnum(), is(TimeUnit.MILLISECONDS));
  }

  @Test
  public void test_lesser_equal() {
    List<Type> result = execute("filter enum <= 'MINUTES' && enum != null ordered enum");
    assertThat(result.size(), is(5));
    assertThat(result.get(0).getEnum(), is(TimeUnit.NANOSECONDS));
    assertThat(result.get(1).getEnum(), is(TimeUnit.MICROSECONDS));
    assertThat(result.get(2).getEnum(), is(TimeUnit.MILLISECONDS));
    assertThat(result.get(3).getEnum(), is(TimeUnit.SECONDS));
    assertThat(result.get(4).getEnum(), is(TimeUnit.MINUTES));

  }

  @Test
  public void test_biggerThan() {
    List<Type> result = execute("filter enum > 'SECONDS' && enum != null reversed enum");
    assertThat(result.size(), is(3));
    assertThat(result.get(0).getEnum(), is(TimeUnit.DAYS));
    assertThat(result.get(1).getEnum(), is(TimeUnit.HOURS));
    assertThat(result.get(2).getEnum(), is(TimeUnit.MINUTES));
  }

  @Test
  public void test_bigger_equal() {
    List<Type> result = execute("filter enum >= 'SECONDS' && enum != null ordered enum");
    assertThat(result.size(), is(4));
    assertThat(result.get(0).getEnum(), is(TimeUnit.SECONDS));
    assertThat(result.get(1).getEnum(), is(TimeUnit.MINUTES));
    assertThat(result.get(2).getEnum(), is(TimeUnit.HOURS));
    assertThat(result.get(3).getEnum(), is(TimeUnit.DAYS));

  }

  @SuppressWarnings("unchecked")
  private List<Type> execute(String query) {
    List<Type> result = Query.collect(query, Type.class, list.stream());
    assertFalse(result.isEmpty());
    return result;
  }

}
