streamql
========

Predicate and ordering for java.util.stream.Stream using a minimal query language.

### Basic types

```java
List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
// [1, 5]
Query.collect("filter == 1 || == 5", Integer.class, integers.stream());
// [1, 2, 3]
Query.collect("filter != 4 && != 5", Integer.class, integers.stream());
```

```java
List<String> strings = Arrays.asList("a", "b", "c", "d", "e");
// [b, c, d]
Query.collect("filter >= 'b' && < 'e'", String.class, strings.stream());
// [b, d]
Query.collect("filter (> 'a' && < 'c') || (> 'c' && < 'e')", String.class, strings.stream());
```

### String matching

```java
List<String> strings = Arrays.asList("abc", "bca", "cab");
// [abc]
Query.collect("filter startsWith 'a'", String.class, strings.stream());
// [bca]
Query.collect("filter endsWith 'a'", String.class, strings.stream());
// [abc, bca, cab]
Query.collect("filter contains 'a'", String.class, strings.stream());
// [cab]
Query.collect("filter regExp '^.a.$'", String.class, strings.stream());
```

### Ordering

```java
List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
Collections.shuffle(integers);
// [1, 2, 3]
Query.collect("filter <= 3 ordered", Integer.class, integers.stream());
// [e, d, c, b, a]
List<String> strings = Arrays.asList("a", "b", "c", "d", "e");
Query.collect("reversed", String.class, strings.stream());
```


### Limit and skip

```java
List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
Collections.shuffle(integers);
// [4, 5]
Query.collect("filter > 2 limit 2 skip 1 ordered", Integer.class, integers.stream());
// [5]
Query.collect("limit 1 reversed", Integer.class, integers.stream());
```

### Object types


```java
public class Person {
  private String fname;
  private String sname;
  private int age;

  public Person(String fname, String sname, int age) {
    this.fname = fname;
    this.sname = sname;
    this.age = age;
  }

  public String getFname() { return fname; }
  public String getSname() { return sname; }
  public Integer getAge() { return age; }
}

List<Person> list = new ArrayList<>();
list.add(new Person("James", "Smith", 40));
list.add(new Person("James", "Moore", 25));
list.add(new Person("Olivia", "Smith", 41));
list.add(new Person("Thomas", "Smith", 45));
list.add(new Person("John", "Andersson", 25));
list.add(new Person("Emma", "Moore", 21));
```

```java
// [James Moore 25, John Moore 21, James Smith 40]
Query.collect("filter fname startsWith 'J' ordered sname", Person.class, list.stream());
// [Thomas Smith 45, Olivia Smith 41]
Query.collect("filter sname == 'Smith' && age > 40 reversed age", Person.class, list.stream())
// [John Andersson 25]
Query.collect("ordered sname, fname, age limit 1", Person.class, list.stream())

```
