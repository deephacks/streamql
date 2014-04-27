package deephacks.streamql;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringTest {
  private static final int num = 10;
  private static final List<String> list = new ArrayList<>();

  @BeforeClass
  public static void before() {
    for (int i = 0; i < num; i++) {
      for (int j = 0; j < num; j++) {
        for (int k = 0; k < num; k++) {
          String value = Character.toString((char) (97 + i)) + Character.toString((char) (97 + j)) + Character.toString((char) (97 + k));
          list.add(value);
        }
      }
    }
    Collections.shuffle(list);
  }

  @Test
  public void test_filter_equal() {
    List<String> result = execute("filter == 'bbb'");
    assertThat(result.size(), is(1));
    assertThat(result.get(0), is("bbb"));

    result = execute("filter == 'aaa' || == 'bbb'");
    for (String p : result) {
      if (!p.equals("aaa") && !p.equals("bbb")) {
        throw new IllegalStateException(p);
      }
    }
  }

  @Test
  public void test_filter_not_equal() {
    List<String> result = execute("filter != 'aaa' && != 'bbb' && != 'ccc'");
    for (String p : result) {
      if (p.equals("aaa") || p.equals("bbb") || p.equals("ccc")) {
        throw new IllegalStateException(p);
      }
    }
  }

  @Test
  public void test_filter_less_than() {
    List<String> result = execute("filter < 'bbb'");
    for (String p : result) {
      if (p.compareTo("bbb") > 0) {
        throw new IllegalStateException(p);
      }
    }
  }

  @Test
  public void test_filter_less_equal() {
    List<String> result = execute("filter < 'bbb'");
    for (String p : result) {
      if (p.compareTo("bbb") >= 0) {
        throw new IllegalStateException(p);
      }
    }
  }

  @Test
  public void test_filter_greater_than() {
    List<String> result = execute("filter > 'ccc'");
    for (String p : result) {
      if (p.compareTo("ccc") <= 0) {
        throw new IllegalStateException(p);
      }
    }
  }

  @Test
  public void test_filter_greater_equal() {
    List<String> result = execute("filter >= 'ccc'");
    for (String p : result) {
      if (p.compareTo("ccc") < 0) {
        throw new IllegalStateException(p);
      }
    }
  }

  @Test
  public void test_filter_like() {
    List<String> result = execute("filter contains 'aa'");
    for (String p : result) {
      if (!p.contains("aa")) {
        throw new IllegalStateException(p);
      }
    }
  }

  @Test
  public void test_filter_startsWith() {
    List<String> result = execute("filter startsWith 'a'");
    for (String p : result) {
      if (!p.startsWith("a")) {
        throw new IllegalStateException(p);
      }
    }
  }

  @Test
  public void test_filter_endsWith() {
    List<String> result = execute("filter endsWith 'b'");
    for (String p : result) {
      if (!p.endsWith("b")) {
        throw new IllegalStateException(p);
      }
    }
  }

  @Test
  public void test_filter_start_and_endsWith() {
    List<String> result = execute("filter startsWith 'a' && endsWith 'b'");
    for (String p : result) {
      if (!p.startsWith("a") && !p.endsWith("b")) {
        throw new IllegalStateException(p);
      }
    }
  }

  @Test
  public void test_filter_regexp() {
    List<String> result = execute("filter regExp '^.a.$'");
    for (String p : result) {
      if (p.charAt(1) != 'a') {
        throw new IllegalStateException(p);
      }
    }
  }

  @Test
  public void test_filter_limit_order_skip() {
    List<String> result = execute("filter > 'aaa' && < 'bbb' limit 2 skip 1 ordered");
    assertThat(result.size(), is(2));
    assertThat(result.get(0), is("aac"));
    assertThat(result.get(1), is("aad"));

    result = execute("filter > 'aaa' && < 'bbb' reversed limit 2 skip 1");
    assertThat(result.size(), is(2));
    assertThat(result.get(0), is("baj"));
    assertThat(result.get(1), is("bai"));
  }


  @Test
  public void test_filter_two_ranges() {
    List<String> result = execute("filter (> 'aaa' && < 'bbb') || (== 'ddd' || == 'eee' || == 'fff') ordered");
    for (String p : result) {
      if ((p.compareTo("aaa") < 0 && p.compareTo("bbb") > 0) && (!p.equals("ddd") && !p.equals("eee") && !p.equals("fff"))) {
        throw new IllegalStateException(p);
      }
    }
  }


  @Test
  public void test_order() {
    List<String> result = execute("ordered");
    assertThat(result.size(), is(list.size()));
    assertThat(result.get(0), is("aaa"));
    assertThat(result.get(1), is("aab"));
    assertThat(result.get(list.size() - 1), is("jjj"));
  }

  @Test
  public void test_ordered_limit() {
    List<String> result = execute("ordered limit 3");
    assertThat(result.size(), is(3));
    assertThat(result.get(0), is("aaa"));
    assertThat(result.get(1), is("aab"));
    assertThat(result.get(2), is("aac"));
  }

  @Test
  public void test_reversed() {
    List<String> result = execute("reversed");
    assertThat(result.size(), is(list.size()));
    assertThat(result.get(0), is("jjj"));
    assertThat(result.get(1), is("jji"));
    assertThat(result.get(list.size() - 1), is("aaa"));
  }

  @Test
  public void test_reversed_limit() throws IOException {
    List<String> result = execute("reversed limit 3");
    assertThat(result.size(), is(3));
    assertThat(result.get(0), is("jjj"));
    assertThat(result.get(1), is("jji"));
    assertThat(result.get(2), is("jjh"));
  }

  @SuppressWarnings("unchecked")
  private List<String> execute(String query) {
    List<String> result = Query.collect(query, String.class, list.stream());
    assertFalse(result.isEmpty());
    return result;
  }
}
