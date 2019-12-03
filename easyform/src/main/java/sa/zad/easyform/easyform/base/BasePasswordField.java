package sa.zad.easyform.easyform.base;

import androidx.annotation.NonNull;


public class BasePasswordField extends NonEmptyMandatoryStringField {


  public BasePasswordField(@NonNull String fieldId) {
    super(fieldId, null);
  }

}
