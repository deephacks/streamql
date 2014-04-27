package deephacks.streamql;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class NullTest {
  private List<String> list =  Arrays.asList(null, "1", "2", null);

  @Test
  public void test_eq_null_string() {
    List<String> result = execute("java.lang.String filter == null");
    assertThat(result.size(), is(2));
    assertNull(result.get(0));
    assertNull(result.get(1));
  }

  @Test
  public void test_not_eq_null_string() {
    List<String> result = execute("java.lang.String filter != null");
    assertThat(result.size(), is(2));
    assertThat(result.get(0), is("1"));
    assertThat(result.get(1), is("2"));
  }

  @SuppressWarnings("unchecked")
  public List<String> execute(String query) {
    return Query.collect(query, String.class, list.stream());
  }
}
