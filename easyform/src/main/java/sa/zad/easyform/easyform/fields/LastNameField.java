package sa.zad.easyform.easyform.fields;

import androidx.annotation.Nullable;

import androidx.annotation.NonNull;


import sa.zad.easyform.easyform.base.NonEmptyString;

public class LastNameField extends NonEmptyString {

  public static final String NAME = "last_name";

  public LastNameField(@NonNull String fieldId, @Nullable String ogField) {
    super(fieldId, ogField);
  }

  @Override
  protected boolean isValid() {
    return UserProfileFieldsValidatorsKt.isLastNameValid(getField());
  }

  @Override
  public void validate() throws Exception {
    UserProfileFieldsValidatorsKt.validateLastName(getField());
  }
}
