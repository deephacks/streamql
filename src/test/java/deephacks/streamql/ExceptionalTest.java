package deephacks.streamql;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class ExceptionalTest {

  @Test
  public void test_illegal_id() {
    try {
      Query.collect("filter test > 0", Type.class, Arrays.asList(new Type(1)).stream());
      fail();
    } catch (IllegalQueryException e) {
      assertThat(e.getMessage(), containsString("No id named [test]"));
    }
  }

  @Test
  public void test_not_comparable() {
    try {
      Query.collect("ordered", Type.class, Arrays.asList(new Type(1), new Type(2)).stream());
      fail();
    } catch (IllegalQueryException e) {
      assertThat(e.getMessage(), containsString("Cannot order on class"));
    }
  }
}
