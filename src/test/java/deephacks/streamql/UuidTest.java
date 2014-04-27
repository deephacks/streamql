package deephacks.streamql;


import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UuidTest {
  private static final List<Type> list = new ArrayList<>();

  static UUID t1 = UUID.randomUUID();
  static UUID t2 = UUID.randomUUID();
  static UUID t3 = UUID.randomUUID();
  static UUID t4 = UUID.randomUUID();
  static UUID t5 = UUID.randomUUID();

  @BeforeClass
  public static void before() throws Exception {
    list.add(new Type(t1));
    list.add(new Type(t2));
    list.add(new Type(t3));
    list.add(new Type(t4));
    list.add(new Type(t5));

    Collections.shuffle(list);
  }

  @Test
  public void test_equals() {
    List<Type> result = execute("filter uuid == '"+t1.toString()+"' ordered uuid");
    assertThat(result.size(), is(1));
    assertThat(result.get(0).getUuid(), is(t1));
  }

  @Test
  public void test_not_equals() {
    List<Type> result = execute("filter uuid != '"+t2.toString()+"' ordered uuid");
    assertThat(result.size(), is(4));
    for (Type t : result) {
      assertThat(t.getUuid(), is(not(t2)));
    }
  }

  @SuppressWarnings("unchecked")
  private List<Type> execute(String query) {
    List<Type> result = Query.collect(query, Type.class, list.stream());
    assertFalse(result.isEmpty());
    return result;
  }

}
