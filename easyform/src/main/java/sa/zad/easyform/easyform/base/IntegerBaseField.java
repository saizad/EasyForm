package sa.zad.easyform.easyform.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class IntegerBaseField extends BaseField<Integer> {

  public IntegerBaseField(@NonNull String fieldId) {
    super(fieldId);
  }

  public IntegerBaseField(@NonNull String fieldId, boolean isMandatory) {
    super(fieldId, isMandatory);
  }

  public IntegerBaseField(@NonNull String fieldId, @Nullable Integer ogField) {
    super(fieldId, ogField);
  }

  public IntegerBaseField(@NonNull String fieldId, @Nullable Integer ogField, boolean isMandatory) {
    super(fieldId, ogField, isMandatory);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Integer) {
      return obj.equals(getField());
    }
    return super.equals(obj);
  }

}
