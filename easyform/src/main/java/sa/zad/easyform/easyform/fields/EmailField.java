package sa.zad.easyform.easyform.fields;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.annotation.NonNull;


import sa.zad.easyform.easyform.base.NonEmptyString;

public class EmailField extends NonEmptyString {

  public EmailField(@NonNull String fieldId) {
    this(fieldId, null);
  }

  public EmailField(@NonNull String fieldId, @Nullable String ogField) {
    this(fieldId, ogField, false);
  }

  public EmailField(@NonNull String fieldId, @Nullable String ogField, boolean isMandatory) {
    super(fieldId, ogField, isMandatory);
  }

  @Override
  protected boolean isValid() {
    return FieldsValidatorsKt.isEmailValid(getField());
  }

  @Override
  public void validate() throws Exception {
    FieldsValidatorsKt.validateEmail(getField());
  }
}
