package deephacks.streamql;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ValueAccessor implements Serializable {

  private Optional<Method> method;
  private List<Method> nestedMethods = new ArrayList<>();
  private final Class<?> targetClass;
  private Optional<String> id;

  public ValueAccessor(Optional<String> id, Class<?> targetClass) {
    this.id = id;
    this.method = getMethod(id, targetClass);
    if (method.isPresent()) {
      if (nestedMethods.size() == 0) {
        this.targetClass = method.get().getReturnType();
      } else {
        this.targetClass = nestedMethods.get(nestedMethods.size() - 1).getReturnType();
      }
    } else {
      this.targetClass = targetClass;
    }
  }

  public Object getValue(Object object) {
    if (method.isPresent()) {
      try {
        Object result = method.get().invoke(object);
        for (Method next : nestedMethods) {
          result = next.invoke(result);
        }
        return result;
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    return object;
  }

  private Optional<Method> getMethod(Optional<String> id, Class<?> targetClass) {
    if (id.isPresent()) {
      try {
        Method method = null;
        Class<?> type = targetClass;
        for (String subId : id.get().split("\\.")) {
          String methodName = "get" + Character.toUpperCase(subId.charAt(0)) + subId.substring(1, subId.length());
          if (method == null) {
            method = type.getMethod(methodName);
            type = method.getReturnType();
          } else {
            Method nested = type.getMethod(methodName);
            type = nested.getReturnType();
            nestedMethods.add(nested);
          }
        }
        return Optional.of(method);
      } catch (NoSuchMethodException e) {
        throw new IllegalQueryException("No id named [" + id.get() + "] on " + targetClass + ".", e);
      }
    }
    return Optional.empty();
  }

  public Class<?> getType() {
    return targetClass;
  }

  public Optional<String> getId() {
    return id;
  }

}
