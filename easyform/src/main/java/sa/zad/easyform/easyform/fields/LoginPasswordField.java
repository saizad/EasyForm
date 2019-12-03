package sa.zad.easyform.easyform.fields;

import androidx.annotation.NonNull;

import sa.zad.easyform.easyform.base.BasePasswordField;


public class LoginPasswordField extends BasePasswordField {

  public LoginPasswordField(@NonNull String fieldId) {
    super(fieldId);
  }

  @Override
  protected boolean isValid() {
    return true;
  }

  @Override
  public void validate() {

  }
}
