package deephacks.streamql;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ComparatorsTest {

  @Test
  public void ints() {
    assertTrue(Comparators.lessEqual(1, 1));
    assertTrue(Comparators.lessEqual(1, 2));
    assertFalse(Comparators.lessEqual(1, -1));

    assertTrue(Comparators.lessThan(1, 2));
    assertFalse(Comparators.lessThan(1, 1));

    assertTrue(Comparators.greaterEqual(2, 1));
    assertTrue(Comparators.greaterEqual(1, 1));
    assertFalse(Comparators.greaterEqual(1, 2));

    assertTrue(Comparators.greaterThan(2, 1));
    assertFalse(Comparators.greaterThan(1, 1));
    assertFalse(Comparators.greaterThan(1, 2));
  }

  @Test
  public void longs() {
    assertTrue(Comparators.lessEqual(1L, 1L));
    assertTrue(Comparators.lessEqual(1L, 2L));
    assertFalse(Comparators.lessEqual(1L, -1L));

    assertTrue(Comparators.lessThan(1L, 2L));
    assertFalse(Comparators.lessThan(1L, 1L));

    assertTrue(Comparators.greaterEqual(2L, 1L));
    assertTrue(Comparators.greaterEqual(1L, 1L));
    assertFalse(Comparators.greaterEqual(1L, 2L));

    assertTrue(Comparators.greaterThan(2L, 1L));
    assertFalse(Comparators.greaterThan(1L, 1L));
    assertFalse(Comparators.greaterThan(1L, 2L));
  }

  @Test
  public void floats() {
    assertTrue(Comparators.lessEqual(1.0f, 1.0f));
    assertTrue(Comparators.lessEqual(1.0f, 2.0f));
    assertFalse(Comparators.lessEqual(1.0f, -1.0f));

    assertTrue(Comparators.lessThan(1.0f, 2.0f));
    assertFalse(Comparators.lessThan(1.0f, 1.0f));

    assertTrue(Comparators.greaterEqual(2.0f, 1.0f));
    assertTrue(Comparators.greaterEqual(1.0f, 1.0f));
    assertFalse(Comparators.greaterEqual(1.0f, 2.0f));

    assertTrue(Comparators.greaterThan(2.0f, 1.0f));
    assertFalse(Comparators.greaterThan(1.0f, 1.0f));
    assertFalse(Comparators.greaterThan(1.0f, 2.0f));
  }

  @Test
  public void doubles() {
    assertTrue(Comparators.lessEqual(1.0, 1.0));
    assertTrue(Comparators.lessEqual(1.0, 2.0));
    assertFalse(Comparators.lessEqual(1.0, -1.0));

    assertTrue(Comparators.lessThan(1.0, 2.0));
    assertFalse(Comparators.lessThan(1.0, 1.0));

    assertTrue(Comparators.greaterEqual(2.0, 1.0));
    assertTrue(Comparators.greaterEqual(1.0, 1.0));
    assertFalse(Comparators.greaterEqual(1.0, 2.0));

    assertTrue(Comparators.greaterThan(2.0, 1.0));
    assertFalse(Comparators.greaterThan(1.0, 1.0));
    assertFalse(Comparators.greaterThan(1.0, 2.0));
  }


  @Test
  public void comparable() {
    assertTrue(Comparators.lessEqual("abc", "abc"));
    assertTrue(Comparators.lessEqual("ab", "abc"));
    assertFalse(Comparators.lessEqual("ac", "ab"));

    assertTrue(Comparators.lessThan("abc", "b"));
    assertFalse(Comparators.lessThan("cd", "ab"));

    assertTrue(Comparators.greaterEqual("cde", "abc"));
    assertTrue(Comparators.greaterEqual("abc", "abc"));
    assertFalse(Comparators.greaterEqual("aaa", "bbb"));

    assertTrue(Comparators.greaterThan("bbb", "aaa"));
    assertFalse(Comparators.greaterThan("abc", "abc"));
    assertFalse(Comparators.greaterThan("a", "b"));
  }
}
