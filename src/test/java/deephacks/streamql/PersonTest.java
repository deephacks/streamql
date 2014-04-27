package deephacks.streamql;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class PersonTest {
  private static final int num = 10;
  private static final List<Person> list = new ArrayList<>();

  @BeforeClass
  public static void before() {
    for (int i = 0; i < num; i++) {
      for (int j = 0; j < num; j++) {
        for (int k = 0; k < num; k++) {
          list.add(new Person(Character.toString((char) (65 + i)), Character.toString((char) (65 + j)), k));
        }
      }
    }
    Collections.shuffle(list);
  }

  @Test
  public void test_filter_equal() {
    List<Person> result = execute("filter sname == 'D' && age == 6 && fname == 'A'");
    assertThat(result.size(), is(1));
    assertThat(result.get(0), is(new Person("A", "D", 6)));

    result = execute("filter sname == 'D' || age == 6");
    for (Person p : result) {
      if (!p.getSname().equals("D") && !p.getAge().equals(6)) {
        throw new IllegalStateException(p.toString());
      }
    }
  }

  @Test
  public void test_filter_not_equal() {
    List<Person> result = execute("filter sname != 'B' && age != 0 && fname != 'A'");
    for (Person p : result) {
      assertThat(p.getAge(), is(not(0)));
      assertThat(p.getSname(), is(not("B")));
      assertThat(p.getFname(), is(not("A")));
    }

    result = execute("filter sname == 'B' && age == 1");
    for (Person p : result) {
      assertThat(p.getAge(), is(1));
      assertThat(p.getSname(), is("B"));
    }
  }

  @Test
  public void test_filter_less_than() {
    List<Person> result = execute("filter sname < 'B' && age < 1");
    for (Person p : result) {
      if (p.getSname().compareTo("B") > 1 && p.getAge() < 1) {
        throw new IllegalStateException(p.toString());
      }
    }

    result = execute("filter sname < 'B' || age < 1");
    for (Person p : result) {
      if (p.getSname().compareTo("A") > 0 && p.getAge() > 0) {
        throw new IllegalStateException(p.toString());
      }
    }
  }

  @Test
  public void test_filter_less_equal() {
    List<Person> result = execute("filter sname <= 'B' && age <= 1");
    for (Person p : result) {
      if (p.getSname().compareTo("B") >= 1 && p.getAge() <= 1) {
        throw new IllegalStateException(p.toString());
      }
    }

    result = execute("filter sname <= 'B' || age <= 1");
    for (Person p : result) {
      if (p.getSname().compareTo("B") > 0 && p.getAge() > 1) {
        throw new IllegalStateException(p.toString());
      }
    }
  }

  @Test
  public void test_filter_greater_than() {
    List<Person> result = execute("filter sname > 'B' && age > 1");
    for (Person p : result) {
      if (p.getSname().compareTo("B") > 0 && p.getAge() <= 1) {
        throw new IllegalStateException(p.toString());
      }
    }

    result = execute("filter sname > 'B' || age > 1");
    for (Person p : result) {
      if (p.getSname().compareTo("A") <= 0 && p.getAge() <= 1) {
        throw new IllegalStateException(p.toString());
      }
    }
  }

  @Test
  public void test_filter_greater_equal() {
    List<Person> result = execute("filter sname >= 'B' && age >= 1");
    for (Person p : result) {
      if (p.getSname().compareTo("B") >= 0 && p.getAge() < 1) {
        throw new IllegalStateException(p.toString());
      }
    }
    result = execute("filter sname >= 'B' || age >= 1");
    for (Person p : result) {
      if (p.getSname().compareTo("A") < 0 && p.getAge() < 1) {
        throw new IllegalStateException(p.toString());
      }
    }
  }

  @Test
  public void test_filter_contains() {
    List<Person> result = execute("filter sname ~ 'B' && fname ~ 'A'");
    assertFalse(result.isEmpty());
    for (Person p : result) {
      if (!p.getSname().equals("B") && !p.getFname().equals("A")) {
        throw new IllegalStateException(p.toString());
      }
    }

    result = execute("filter sname >= 'B' || age >= 1");
    for (Person p : result) {
      if (p.getSname().compareTo("A") < 0 && p.getAge() < 1) {
        throw new IllegalStateException(p.toString());
      }
    }
  }

  @Test
  public void test_filter_startWith() {
    List<Person> result = execute("filter sname ^ 'A'");
    assertFalse(result.isEmpty());
    for (Person p : result) {
      if (!p.getSname().startsWith("A")) {
        throw new IllegalStateException(p.toString());
      }
    }
  }

  @Test
  public void test_filter_endsWith() {
    List<Person> result = execute("filter sname $ 'A'");
    assertFalse(result.isEmpty());
    for (Person p : result) {
      if (!p.getSname().endsWith("A")) {
        throw new IllegalStateException(p.toString());
      }
    }
  }

  @Test
  public void test_filter_regexp() {
    List<Person> result = execute("filter fname * '^A$' && age > 8");
    for (Person p : result) {
      if (p.getFname().charAt(0) != 'A' || p.getAge() < 9) {
        throw new IllegalStateException(p.toString());
      }
    }
  }

  @Test
  public void test_filter_limit_order_skip() {
    List<Person> result = execute("filter (sname >= 'D' && age >= 6) limit 5 skip 1 ordered sname, fname, age");
    assertThat(result.size(), is(5));

    assertThat(result.get(0), is(new Person("A", "D", 7)));
    assertThat(result.get(1), is(new Person("A", "D", 8)));
    assertThat(result.get(2), is(new Person("A", "D", 9)));
    assertThat(result.get(3), is(new Person("B", "D", 6)));
    assertThat(result.get(4), is(new Person("B", "D", 7)));

    result = execute("filter (sname >= 'D' && age >= 6) reversed sname, fname, age limit 5 skip 1");
    assertThat(result.size(), is(5));

    assertThat(result.get(0), is(new Person("J", "J", 8)));
    assertThat(result.get(1), is(new Person("J", "J", 7)));
    assertThat(result.get(2), is(new Person("J", "J", 6)));
    assertThat(result.get(3), is(new Person("I", "J", 9)));
    assertThat(result.get(4), is(new Person("I", "J", 8)));
  }

  @Test
  public void test_order() {
    List<Person> result = execute("ordered sname, fname, age");
    assertThat(result.size(), is(list.size()));

    assertThat(result.get(0), is(new Person("A", "A", 0)));
    assertThat(result.get(1), is(new Person("A", "A", 1)));
    assertThat(result.get(num), is(new Person("B", "A", 0)));
    assertThat(result.get(list.size() - 1), is(new Person("J", "J", 9)));
  }


  @Test
  public void test_ordered_limit() {
    List<Person> result = execute("ordered sname, fname, age limit 1");
    assertThat(result.size(), is(1));
    assertThat(result.get(0), is(new Person("A", "A", 0)));
  }

  @Test
  public void test_reversed() {
    List<Person> result = execute("reversed sname, fname, age");
    assertThat(result.size(), is(list.size()));

    assertThat(result.get(0), is(new Person("J", "J", 9)));
    assertThat(result.get(1), is(new Person("J", "J", 8)));
    assertThat(result.get(num), is(new Person("I", "J", 9)));
    assertThat(result.get(list.size() - 1), is(new Person("A", "A", 0)));
  }

  @Test
  public void test_reversed_limit() throws IOException {
    List<Person> result = execute("reversed sname, fname, age limit 1");
    assertThat(result.size(), is(1));
    assertThat(result.get(0), is(new Person("J", "J", 9)));
  }

  @SuppressWarnings("unchecked")
  private List<Person> execute(String query) {
    List<Person> result = Query.collect(query, Person.class, list.stream());
    assertFalse(result.isEmpty());
    return result;
  }

}
