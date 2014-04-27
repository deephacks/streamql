package deephacks.streamql;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PeriodTest {
  private static final List<Type> list = new ArrayList<>();

  static Period t1 = Period.parse("P1Y1D");
  static Period t2 = Period.parse("P2Y1D");
  static Period t3 = Period.parse("P3Y1D");
  static Period t4 = Period.parse("P4Y1D");
  static Period t5 = Period.parse("P5Y1D");

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
    List<Type> result = execute("filter period == 'P1Y1D'");
    assertThat(result.size(), is(1));
    assertThat(result.get(0).getPeriod(), is(t1));
  }

  @Test
  public void test_not_equals() {
    List<Type> result = execute("filter period != null && period != 'P1Y1D'");
    assertThat(result.size(), is(4));
    for (Type t : result) {
      assertThat(t.getPeriod(), is(not(t1)));
    }
  }

  @SuppressWarnings("unchecked")
  private List<Type> execute(String query) {
    List<Type> result = Query.collect(query, Type.class, list.stream());
    assertFalse(result.isEmpty());
    return result;
  }
}
