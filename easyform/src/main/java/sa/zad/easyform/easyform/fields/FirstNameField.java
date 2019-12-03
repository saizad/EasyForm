package sa.zad.easyform.easyform.fields;

import androidx.annotation.Nullable;

import androidx.annotation.NonNull;


import sa.zad.easyform.easyform.base.NonEmptyString;

public class FirstNameField extends NonEmptyString {

  public FirstNameField(@NonNull String fieldId, @Nullable String ogField) {
    super(fieldId, ogField, true);
  }

  @Override
  protected boolean isValid() {
    return UserProfileFieldsValidatorsKt.isFirstNameValid(getField());
  }

  @Override
  public void validate() throws Exception {
    UserProfileFieldsValidatorsKt.validateFirstName(getField());
  }
}
