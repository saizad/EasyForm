package sa.zad.easyform.easyform.fields;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.annotation.NonNull;


import sa.zad.easyform.easyform.base.NonEmptyString;

public class GenderField extends NonEmptyString {

  public GenderField(@NonNull String fieldId) {
    this(fieldId, null);
  }

  public GenderField(@NonNull String fieldId, @Nullable String ogField) {
    super(fieldId, ogField);
  }

  public GenderField(@NonNull String fieldId, @Nullable String ogField, boolean isMandatory) {
    super(fieldId, ogField, isMandatory);
  }

  @Override
  protected boolean isValid() {
    return FieldValidator.isGenderFieldValid(getField());
  }

  @Override
  public void validate() throws Exception {
    FieldValidator.validateGenderField(getField());
  }
}
