package deephacks.streamql;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FileTest {
  private static final List<Type> list = new ArrayList<>();

  static File t1 = new File("/tmp/d1");
  static File t2 = new File("/tmp/d2");
  static File t3 = new File("/tmp/d3");
  static File t4 = new File("/tmp/d4");
  static File t5 = new File("/tmp/d5");

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
    List<Type> result = execute("filter file.absolutePath == '/tmp/d3' && file != null");
    assertThat(result.size(), is(1));
    assertThat(result.get(0).getFile(), is(t3));
  }

  @Test
  public void test_not_equals() {
    List<Type> result = execute("filter file != null && file.absolutePath != '/tmp/d3' ordered file.absolutePath");
    assertThat(result.size(), is(4));
    assertThat(result.get(0).getFile(), is(t1));
    assertThat(result.get(1).getFile(), is(t2));
    assertThat(result.get(2).getFile(), is(t4));
    assertThat(result.get(3).getFile(), is(t5));
  }


  @Test
  public void test_lesserThan() {
    List<Type> result = execute("filter file != null && file < '/tmp/d3' ordered file.absolutePath");
    assertThat(result.size(), is(2));
    assertThat(result.get(0).getFile(), is(t1));
    assertThat(result.get(1).getFile(), is(t2));
  }

  @Test
  public void test_lesser_equal() {
    List<Type> result = execute("filter file != null && file.absolutePath <= '/tmp/d3' ordered file.absolutePath");
    assertThat(result.size(), is(3));
    assertThat(result.get(0).getFile(), is(t1));
    assertThat(result.get(1).getFile(), is(t2));
    assertThat(result.get(2).getFile(), is(t3));
  }

  @Test
  public void test_biggerThan() {
    List<Type> result = execute("filter file != null && file.absolutePath > '/tmp/d3' ordered file");
    assertThat(result.size(), is(2));
    assertThat(result.get(0).getFile(), is(t4));
    assertThat(result.get(1).getFile(), is(t5));
  }

  @Test
  public void test_bigger_equal() {
    List<Type> result = execute("filter file != null && file.absolutePath >= '/tmp/d3' reversed file.absolutePath");
    assertThat(result.size(), is(3));
    assertThat(result.get(0).getFile(), is(t5));
    assertThat(result.get(1).getFile(), is(t4));
    assertThat(result.get(2).getFile(), is(t3));
  }

  @SuppressWarnings("unchecked")
  private List<Type> execute(String query) {
    List<Type> result = Query.collect(query, Type.class, list.stream());
    assertFalse(result.isEmpty());
    return result;
  }
}
