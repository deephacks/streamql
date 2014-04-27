package deephacks.streamql;

import java.util.Optional;

public class GrammarValue {
  private static final Conversion CONVERSION = Conversion.get();
  private Optional<Object> value;

  public GrammarValue(Object grammarValue, ValueAccessor valueAccessor) {
    this.value = Optional.ofNullable(convert(grammarValue, valueAccessor.getType()));
  }

  public Optional<Object> getValue() {
    return value;
  }

  private Object convert(Object grammarValue, Class<?> targetClass) {
    if (grammarValue == null) {
      return null;
    }
    Class<?> grammarValueClass = grammarValue.getClass();
    if (!targetClass.equals(grammarValueClass)) {
      return CONVERSION.convert(grammarValue, targetClass);
    }
    return grammarValue;
  }

}
