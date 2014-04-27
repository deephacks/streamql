package deephacks.streamql;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BooleanTest {
  private static final List<Type> list = new ArrayList<>();

  static Boolean t1 = Boolean.TRUE;
  static Boolean t2 = Boolean.FALSE;
  static Boolean t3 = Boolean.TRUE;

  @BeforeClass
  public static void before() {
    list.add(new Type(t1));
    list.add(new Type(t2));
    list.add(new Type(t3));

    Collections.shuffle(list);
  }

  @Test
  public void test_equals() {
    List<Type> result = execute("filter boolean == true && boolean != null");
    assertThat(result.size(), is(2));
    assertThat(result.get(0).getBoolean(), is(Boolean.TRUE));
    assertThat(result.get(1).getBoolean(), is(Boolean.TRUE));
  }

  @Test
  public void test_not_equals() {
    List<Type> result = execute("filter boolean != null && boolean != false ordered boolean");
    assertThat(result.size(), is(2));
    assertThat(result.get(0).getBoolean(), is(Boolean.TRUE));
    assertThat(result.get(1).getBoolean(), is(Boolean.TRUE));

  }

  @SuppressWarnings("unchecked")
  private List<Type> execute(String query) {
    List<Type> result = Query.collect(query, Type.class, list.stream());
    assertFalse(result.isEmpty());
    return result;
  }
}
