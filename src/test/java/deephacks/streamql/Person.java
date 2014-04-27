package deephacks.streamql;

public class Person {
    private String fname;
    private String sname;
    private int age;

    public Person(String fname, String sname, int age) {
      this.fname = fname;
      this.sname = sname;
      this.age = age;
    }

    public String getFname() {
      return fname;
    }

    public String getSname() {
      return sname;
    }

    public Integer getAge() {
      return age;
    }

    @Override
    public String toString() {
      return "Person{" + fname + ", " + sname + ", " + age + '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Person person = (Person) o;

      if (age != person.age) return false;
      if (fname != null ? !fname.equals(person.fname) : person.fname != null) return false;
      if (sname != null ? !sname.equals(person.sname) : person.sname != null) return false;

      return true;
    }

    @Override
    public int hashCode() {
      int result = fname != null ? fname.hashCode() : 0;
      result = 31 * result + (sname != null ? sname.hashCode() : 0);
      result = 31 * result + age;
      return result;
    }
  }