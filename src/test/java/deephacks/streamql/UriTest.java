package deephacks.streamql;

import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UriTest {
  private static final List<Type> list = new ArrayList<>();

  static URI t1;
  static URI t2;
  static URI t3;

  @BeforeClass
  public static void before() throws Exception {
    t1 = new URI("http://www.google.com/plus");
    t2 = new URI("http://www.google.com/gmail");
    t3 = new URI("http://www.yahoo.com");
    list.add(new Type(t1));
    list.add(new Type(t2));
    list.add(new Type(t3));
    Collections.shuffle(list);
  }

  @Test
  public void test_equals() {
    List<Type> result = execute("filter uri == 'http://www.google.com/plus' ordered uri");
    assertThat(result.size(), is(1));
    assertThat(result.get(0).getUri(), is(t1));
  }

  @Test
  public void test_not_equals() {
    List<Type> result = execute("filter uri != 'http://www.google.com/gmail' ordered uri");
    assertThat(result.size(), is(2));
    assertThat(result.get(0).getUri(), is(t1));
    assertThat(result.get(1).getUri(), is(t3));
  }

  @SuppressWarnings("unchecked")
  private List<Type> execute(String query) {
    List<Type> result = Query.collect(query, Type.class, list.stream());
    assertFalse(result.isEmpty());
    return result;
  }

}
