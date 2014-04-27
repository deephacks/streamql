package deephacks.streamql;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ZoneOffsetTest {
  private static final List<Type> list = new ArrayList<>();

  static ZoneOffset t1 = ZoneOffset.of("-1");
  static ZoneOffset t2 = ZoneOffset.of("+0");
  static ZoneOffset t3 = ZoneOffset.of("+1");
  static ZoneOffset t4 = ZoneOffset.of("+2");
  static ZoneOffset t5 = ZoneOffset.of("+3");

  @BeforeClass
  public static void before() {
    list.add(new Type(t1));
    list.add(new Type(t2));
    list.add(new Type(t3));
    list.add(new Type(t4));
    list.add(new Type(t5));
    list.add(new Type((ZoneOffset)null));
    Collections.shuffle(list);
  }

  @Test
  public void test_equals() {
    List<Type> result = execute("filter zoneOffset == '+1' && zoneOffset != null");
    assertThat(result.size(), is(1));
    assertThat(result.get(0).getZoneOffset(), is(t3));
  }

  @Test
  public void test_not_equals() {
    List<Type> result = execute("filter zoneOffset != null && zoneOffset != '+2' ordered zoneOffset");
    assertThat(result.size(), is(4));
    assertThat(result.get(0).getZoneOffset(), is(t5));
    assertThat(result.get(1).getZoneOffset(), is(t3));
    assertThat(result.get(2).getZoneOffset(), is(t2));
    assertThat(result.get(3).getZoneOffset(), is(t1));
  }


  @Test
  public void test_lesserThan() {
    List<Type> result = execute("filter zoneOffset != null && zoneOffset < '-1' ordered zoneOffset");
    assertThat(result.size(), is(4));
    assertThat(result.get(0).getZoneOffset(), is(t5));
    assertThat(result.get(1).getZoneOffset(), is(t4));
    assertThat(result.get(2).getZoneOffset(), is(t3));
    assertThat(result.get(3).getZoneOffset(), is(t2));
  }

  @Test
  public void test_lesser_equal() {
    List<Type> result = execute("filter zoneOffset != null && zoneOffset <= '+0' ordered zoneOffset");
    System.out.println(result.get(0).getZoneOffset());
    assertThat(result.size(), is(4));
    assertThat(result.get(0).getZoneOffset(), is(t5));
    assertThat(result.get(1).getZoneOffset(), is(t4));
    assertThat(result.get(2).getZoneOffset(), is(t3));
    assertThat(result.get(3).getZoneOffset(), is(t2));
  }

  @Test
  public void test_biggerThan() {
    List<Type> result = execute("filter zoneOffset != null && zoneOffset > '+1' ordered zoneOffset");
    assertThat(result.size(), is(2));
    assertThat(result.get(0).getZoneOffset(), is(t2));
    assertThat(result.get(1).getZoneOffset(), is(t1));

  }

  @Test
  public void test_bigger_equal() {
    List<Type> result = execute("filter zoneOffset != null && zoneOffset >= '+1' ordered zoneOffset");
    assertThat(result.size(), is(3));
    assertThat(result.get(0).getZoneOffset(), is(t3));
    assertThat(result.get(1).getZoneOffset(), is(t2));
    assertThat(result.get(2).getZoneOffset(), is(t1));
  }

  @SuppressWarnings("unchecked")
  private List<Type> execute(String query) {
    List<Type> result = Query.collect(query, Type.class, list.stream());
    assertFalse(result.isEmpty());
    return result;
  }
}
