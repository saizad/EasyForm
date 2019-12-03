package sa.zad.easyform.easyform.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import sa.zad.easyform.easyform.ObjectUtils;

public abstract class LongBaseField extends BaseField<Long> {

  public LongBaseField(@NonNull String fieldId) {
    super(fieldId);
  }

  public LongBaseField(@NonNull String fieldId, boolean isMandatory) {
    super(fieldId, isMandatory);
  }

  public LongBaseField(@NonNull String fieldId, @Nullable Long ogField) {
    super(fieldId, ogField);
  }

  public LongBaseField(@NonNull String fieldId, @Nullable Long ogField, boolean isMandatory) {
    super(fieldId, ogField, isMandatory);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Long) {
      return obj.equals(getField());
    }else{
      return ObjectUtils.isSameObject(obj, getField());
    }
  }
}
