package sa.zad.easyform.easyform.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import sa.zad.easyform.easyform.ObjectUtils;

public abstract class LongBaseField extends BaseField<Long> {

  public LongBaseField(@NonNull String fieldId) {
    this(fieldId, false);
  }

  public LongBaseField(@NonNull String fieldId, boolean isMandatory) {
    this(fieldId, null, isMandatory);
  }

  public LongBaseField(@NonNull String fieldId, @Nullable Long ogField) {
    this(fieldId, ogField, false);
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
