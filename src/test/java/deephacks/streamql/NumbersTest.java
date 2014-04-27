package deephacks.streamql;

import deephacks.streamql.Numbers.Digit;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NumbersTest {
  private static final int first = -10;
  private static final int last = 10;
  private static final int max = 21;
  private static Numbers numbers = new Numbers(first, last);

  @Test
  public void test_filter_equal() {
    numbers.verify("filter d == 4", result -> {
      assertThat(result.size(), is(1));
      assertTrue(result.get(0).eq(4));
    });

    numbers.verify("filter d == 3 || d == 8", result -> {
      for (Digit d : result) {
        if (d.not(3) && d.not(8)) {
          throw new IllegalStateException(d.toString());
        }
      }
    });
  }
  @Test
  public void test_filter_not_equal() {
    numbers.verify("filter d != 3 && d != 1 && d != 4", result -> {
      for (Digit d : result) {
        if (d.eq(3) || d.eq(1) || d.eq(4)) {
          throw new IllegalStateException(d.toString());
        }
      }
    });
  }

  @Test
  public void test_filter_less_than() {
    numbers.verify("filter d < 5", result -> {
      for (Digit d : result) {
        if (d.gt(4)) {
          throw new IllegalStateException(d.toString());
        }
      }
    });
  }

  @Test
  public void test_filter_less_equal() {
    numbers.verify("filter d <= 2", result -> {
      for (Digit d : result) {
        if (d.gt(2)) {
          throw new IllegalStateException(d.toString());
        }
      }
    });
  }

  @Test
  public void test_filter_greater_than() {
    numbers.verify("filter d > 2", result -> {
      for (Digit d : result) {
        if (d.lt(3)) {
          throw new IllegalStateException(d.toString());
        }
      }
    });
  }


  @Test
  public void test_filter_greater_equal() {
    numbers.verify("filter d >= 2", result -> {
      for (Digit d : result) {
        if (d.lt(2)) {
          throw new IllegalStateException(d.toString());
        }
      }
    });
  }

  @Test
  public void test_filter_limit_order_skip() {
    numbers.verify("filter d > 3 && d < 8 limit 2 skip 1 ordered d", result -> {
      assertThat(result.size(), is(2));
      assertTrue(result.get(0).eq(5));
      assertTrue(result.get(1).eq(6));
    });

    numbers.verify("filter d > 3 && d < 8 reversed d limit 2 skip 1", result -> {
      assertThat(result.size(), is(2));
      assertTrue(result.get(0).eq(6));
      assertTrue(result.get(1).eq(5));
    });
  }

  @Test
  public void test_filter_two_ranges() {
    numbers.verify("filter ( d > 1 && d < 3 ) || ( d == 7 || d == 8 || d == 9 ) ordered d", result -> {
      assertThat(result.size(), is(4));
      assertTrue(result.get(0).eq(2));
      assertTrue(result.get(1).eq(7));
      assertTrue(result.get(2).eq(8));
      assertTrue(result.get(3).eq(9));
    });
  }

  @Test
  public void test_order() {
    numbers.verify("ordered d", result -> {
      assertThat(result.size(), is(max));
      assertTrue(result.get(0).eq(-10));
      assertTrue(result.get(1).eq(-9));
      assertTrue(result.get(max - 1).eq(10));
    });
  }

  @Test
  public void test_ordered_limit() {
    numbers.verify("ordered d limit 3", result -> {
      assertThat(result.size(), is(3));
      assertTrue(result.get(0).eq(-10));
      assertTrue(result.get(1).eq(-9));
      assertTrue(result.get(2).eq(-8));
    });
  }

  @Test
  public void test_reversed() {
    numbers.verify("reversed d", result -> {
      assertThat(result.size(), is(max));
      assertTrue(result.get(0).eq(10));
      assertTrue(result.get(1).eq(9));
      assertTrue(result.get(max - 1).eq(-10));
    });
  }


  @Test
  public void test_reversed_limit() throws IOException {
    numbers.verify("reversed d limit 3", result -> {
      assertThat(result.size(), is(3));
      assertTrue(result.get(0).eq(10));
      assertTrue(result.get(1).eq(9));
      assertTrue(result.get(2).eq(8));
    });
  }
}
