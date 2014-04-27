package deephacks.streamql;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class Comparators {

  @SuppressWarnings("unchecked")
  public static Comparator<Object> comparableComparator(ValueAccessor value) {
    return (a, b) -> {
      Object v = value.getValue(a);
      if (v == null && value.getId().isPresent()) {
        throw new IllegalArgumentException("Cannot compare null values, id [" + value.getId().get() + "] on [" + value.getType().getName() + "].");
      }
      if (v instanceof Comparable) {
        return ((Comparable) v).compareTo(value.getValue(b));
      } else if (v instanceof AtomicInteger) {
        Integer aIntValue = ((AtomicInteger) v).intValue();
        Integer bIntValue = ((AtomicInteger) value.getValue(b)).intValue();
        return aIntValue.compareTo(bIntValue);
      } else if (v instanceof AtomicLong) {
        Long aLongValue = ((AtomicLong) v).longValue();
        Long bLongValue = ((AtomicLong) value.getValue(b)).longValue();
        return aLongValue.compareTo(bLongValue);
      } else {
        throw new IllegalArgumentException(v.getClass() + " does not implement not java.lang.Comparable.");
      }
    };
  }

  @SuppressWarnings("unchecked")
  public static Comparator<Object> comparableComparator() {
    return (a, b) -> ((Comparable) a).compareTo(b);
  }

  public static Comparator<Object> getComparator(ValueAccessor value) {
    return comparableComparator(value);
  }

  public static int compare(Object left, Object right) {
    if (left == null) {
      throw new NullPointerException("left is null");
    }
    if (right == null) {
      throw new NullPointerException("right is null");
    }
    if (left instanceof Comparable) {
      return Comparators.comparableComparator().compare((Comparable) left, (Comparable) right);
    } else if (left instanceof AtomicInteger) {
      Integer aIntValue = ((AtomicInteger) left).intValue();
      Integer bIntValue = ((AtomicInteger) right).intValue();
      return aIntValue.compareTo(bIntValue);
    } else if (left instanceof AtomicLong) {
      Integer aIntValue = ((AtomicLong) left).intValue();
      Integer bIntValue = ((AtomicLong) right).intValue();
      return aIntValue.compareTo(bIntValue);
    }
    throw new IllegalArgumentException("cannot compare " + left + " and " + right);
  }

  public static boolean lessThan(Object left, Object right) {
    return compare(left, right) < 0;
  }

  public static boolean lessEqual(Object left, Object right) {
    return compare(left, right) <= 0;
  }

  public static boolean greaterThan(Object left, Object right) {
    return compare(left, right) > 0;
  }

  public static boolean greaterEqual(Object left, Object right) {
    return compare(left, right) >= 0;
  }

}
