package sa.zad.easyform.easyform.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import sa.zad.easyform.easyform.ObjectUtils;

public abstract class StringBaseField extends BaseField<String> {

  public StringBaseField(@NonNull String fieldId) {
    this(fieldId, null, false);
  }

  public StringBaseField(@NonNull String fieldId, boolean isMandatory) {
    this(fieldId, null, isMandatory);
  }

  public StringBaseField(@NonNull String fieldId, @Nullable String ogField) {
    this(fieldId, ogField, false);
  }

  public StringBaseField(@NonNull String fieldId, @Nullable String ogField, boolean isMandatory) {
    super(fieldId, ogField, isMandatory);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof String) {
      return obj.equals(getField());
    }
    else{
      return ObjectUtils.isSameObject(obj, getField());
    }
  }
}
