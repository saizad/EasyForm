package sa.zad.easyform.easyform.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import sa.zad.easyform.easyform.StringUtils;

public abstract class NonEmptyString extends StringBaseField {

  public NonEmptyString(@NonNull String fieldId) {
    super(fieldId);
  }

  public NonEmptyString(@NonNull String fieldId, boolean isMandatory) {
    super(fieldId, isMandatory);
  }

  public NonEmptyString(@NonNull String fieldId, @Nullable String ogField) {
    super(fieldId, ogField);
  }

  public NonEmptyString(@NonNull String fieldId, @Nullable String ogField, boolean isMandatory) {
    super(fieldId, ogField, isMandatory);
  }

  @Override
  public void setField(@Nullable String value) {
    if (StringUtils.isNullOrEmpty(value)) {
      super.setField(null);
    } else {
      super.setField(value);
    }
  }
}
