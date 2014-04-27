package deephacks.streamql;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Numbers {
  private static final List<Class<?>> TYPES = new ArrayList<>();
  private final Map<Class<?>, List<Digit>> digits = new HashMap<>();

  static {
    TYPES.add(Byte.class);
    TYPES.add(Short.class);
    TYPES.add(Integer.class);
    TYPES.add(Long.class);
    TYPES.add(Float.class);
    TYPES.add(Double.class);
    TYPES.add(BigDecimal.class);
    TYPES.add(BigInteger.class);
    // do not include AtomicInteger and AtomicLong since they are not Comparable
    // and generally a poor choice because atomic variables are expected to be mutated.
  }

  public Numbers(int min, int max) {
    for (Class<?> type : TYPES) {
      for (int i = min; i <= max; i++) {
        List<Digit> list = digits.get(type);
        if (list == null) {
          list = new ArrayList<>();
          digits.put(type, list);
        }
        list.add(new Digit(i, type));
      }
    }
    for (Class<?> type : TYPES) {
      for (int i = min; i <= max; i++) {
        List<Digit> list = digits.get(type);
        Collections.shuffle(list);
      }
    }
  }

  public void verify(String query, Consumer<List<Digit>> consumer) {
    for (Class<?> cls : TYPES) {
      verifyObject(query, consumer, cls);
    }
    for (Class<?> cls : TYPES) {
      verifyBasic(query, consumer, cls);
    }

  }

  @SuppressWarnings("unchecked")
  private void verifyBasic(String query, Consumer<List<Digit>> consumer, Class<?> cls) {
    String basicQuery = query.replaceAll(" d", " ");
    List<Object> numbers = digits.get(cls).stream().map(d -> d.getValue(cls)).collect(Collectors.toList());
    List<Object> numberResult = Query.collect(basicQuery, (Class) cls, ((List<Object>) numbers).stream());
    List<Digit> digitResult = numberResult.stream().map(t -> new Digit(t, cls)).collect(Collectors.toList());
    consumer.accept(digitResult);
  }

  private void verifyObject(String query, Consumer<List<Digit>> consumer, Class<?> cls) {
    String name = cls.getSimpleName();
    name = Character.toLowerCase(name.charAt(0)) + name.substring(1, name.length());
    String objectQuery = query.replaceAll(" d", " " + name);
    List<Digit> digitResult = Query.collect(objectQuery, Digit.class, digits.get(cls).stream());
    consumer.accept(digitResult);
  }


  public static class Digit {
    private Byte aByte;
    private Short aShort;
    private Integer aInt;
    private Long aLong;
    private Float aFloat;
    private Double aDouble;
    private BigInteger bigInteger;
    private BigDecimal bigDecimal;
    private Class<?> cls;

    public Digit(Object number, Class<?> cls) {
      this.cls = cls;
      if (Byte.class.isAssignableFrom(cls)) {
        aByte = (Byte) number;
      } else if (Short.class.isAssignableFrom(cls)) {
        aShort = (Short) number;
      } else if (Integer.class.isAssignableFrom(cls)) {
        aInt = (Integer) number;
      } else if (Long.class.isAssignableFrom(cls)) {
        aLong = (Long) number;
      } else if (Float.class.isAssignableFrom(cls)) {
        aFloat = (Float) number;
      } else if (Double.class.isAssignableFrom(cls)) {
        aDouble = (Double) number;
      } else if (BigDecimal.class.isAssignableFrom(cls)) {
        bigDecimal = (BigDecimal) number;
      } else if (BigInteger.class.isAssignableFrom(cls)) {
        bigInteger = (BigInteger) number;
      } else {
        throw new IllegalArgumentException(cls.getName());
      }
    }

    public Digit(Integer number, Class<?> cls) {
      this.cls = cls;
      if (Byte.class.isAssignableFrom(cls)) {
        aByte = number.byteValue();
      } else if (Short.class.isAssignableFrom(cls)) {
        aShort = number.shortValue();
      } else if (Integer.class.isAssignableFrom(cls)) {
        aInt = number;
      } else if (Long.class.isAssignableFrom(cls)) {
        aLong = number.longValue();
      } else if (Float.class.isAssignableFrom(cls)) {
        aFloat = number.floatValue();
      } else if (Double.class.isAssignableFrom(cls)) {
        aDouble = number.doubleValue();
      } else if (BigDecimal.class.isAssignableFrom(cls)) {
        bigDecimal = new BigDecimal(number);
      } else if (BigInteger.class.isAssignableFrom(cls)) {
        bigInteger = new BigInteger(number.toString());
      } else {
        throw new IllegalArgumentException(cls.getName());
      }
    }

    public Byte getByte() {
      return aByte;
    }

    public Short getShort() {
      return aShort;
    }

    public Integer getInteger() {
      return aInt;
    }

    public Long getLong() {
      return aLong;
    }

    public Float getFloat() {
      return aFloat;
    }

    public Double getDouble() {
      return aDouble;
    }

    public BigInteger getBigInteger() {
      return bigInteger;
    }

    public BigDecimal getBigDecimal() {
      return bigDecimal;
    }

    public boolean not(Integer i) {
      if (Byte.class.isAssignableFrom(cls)) {
        return aByte != i.byteValue();
      } else if (Short.class.isAssignableFrom(cls)) {
        return aShort != i.shortValue();
      } else if (Integer.class.isAssignableFrom(cls)) {
        return aInt != i.intValue();
      } else if (Long.class.isAssignableFrom(cls)) {
        return aLong != i.longValue();
      } else if (Float.class.isAssignableFrom(cls)) {
        return aFloat != i.floatValue();
      } else if (Double.class.isAssignableFrom(cls)) {
        return aDouble != i.doubleValue();
      } else if (BigDecimal.class.isAssignableFrom(cls)) {
        return bigDecimal.intValue() != i;
      } else if (BigInteger.class.isAssignableFrom(cls)) {
        return bigInteger.intValue() != i;
      } else {
        throw new IllegalArgumentException(cls.getName());
      }
    }

    public boolean eq(Integer i) {
      if (Byte.class.isAssignableFrom(cls)) {
        return aByte == i.byteValue();
      } else if (Short.class.isAssignableFrom(cls)) {
        return aShort == i.shortValue();
      } else if (Integer.class.isAssignableFrom(cls)) {
        return aInt == i.intValue();
      } else if (Long.class.isAssignableFrom(cls)) {
        return aLong == i.longValue();
      } else if (Float.class.isAssignableFrom(cls)) {
        return aFloat == i.floatValue();
      } else if (Double.class.isAssignableFrom(cls)) {
        return aDouble == i.doubleValue();
      } else if (BigDecimal.class.isAssignableFrom(cls)) {
        return bigDecimal.intValue() == i;
      } else if (BigInteger.class.isAssignableFrom(cls)) {
        return bigInteger.intValue() == i;
      } else {
        throw new IllegalArgumentException(cls.getName());
      }
    }

    public Object getValue(Class<?> cls) {
      if (Byte.class.isAssignableFrom(cls)) {
        return aByte;
      } else if (Short.class.isAssignableFrom(cls)) {
        return aShort;
      } else if (Integer.class.isAssignableFrom(cls)) {
        return aInt;
      } else if (Long.class.isAssignableFrom(cls)) {
        return aLong;
      } else if (Float.class.isAssignableFrom(cls)) {
        return aFloat;
      } else if (Double.class.isAssignableFrom(cls)) {
        return aDouble;
      } else if (BigDecimal.class.isAssignableFrom(cls)) {
        return bigDecimal;
      } else if (BigInteger.class.isAssignableFrom(cls)) {
        return bigInteger;
      } else {
        throw new IllegalArgumentException(cls.getName());
      }
    }

    public boolean gt(Integer i) {
      if (Byte.class.isAssignableFrom(cls)) {
        return aByte > i.byteValue();
      } else if (Short.class.isAssignableFrom(cls)) {
        return aShort > i.shortValue();
      } else if (Integer.class.isAssignableFrom(cls)) {
        return aInt > i;
      } else if (Long.class.isAssignableFrom(cls)) {
        return aLong > i.longValue();
      } else if (Float.class.isAssignableFrom(cls)) {
        return aFloat > i.floatValue();
      } else if (Double.class.isAssignableFrom(cls)) {
        return aDouble > i.doubleValue();
      } else if (BigDecimal.class.isAssignableFrom(cls)) {
        return bigDecimal.intValue() > i;
      } else if (BigInteger.class.isAssignableFrom(cls)) {
        return bigInteger.intValue() > i;
      } else {
        throw new IllegalArgumentException(cls.getName());
      }
    }

    public boolean lt(Integer i) {
      if (Byte.class.isAssignableFrom(cls)) {
        return aByte < i.byteValue();
      } else if (Short.class.isAssignableFrom(cls)) {
        return aShort < i.shortValue();
      } else if (Integer.class.isAssignableFrom(cls)) {
        return aInt < i;
      } else if (Long.class.isAssignableFrom(cls)) {
        return aLong < i.longValue();
      } else if (Float.class.isAssignableFrom(cls)) {
        return aFloat < i.floatValue();
      } else if (Double.class.isAssignableFrom(cls)) {
        return aDouble < i.doubleValue();
      } else if (BigDecimal.class.isAssignableFrom(cls)) {
        return bigDecimal.intValue() < i;
      } else if (BigInteger.class.isAssignableFrom(cls)) {
        return bigInteger.intValue() < i;
      } else {
        throw new IllegalArgumentException(cls.getName());
      }
    }
  }
}
