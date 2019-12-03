package sa.zad.easyform.easyform.base;

import androidx.annotation.NonNull;

import java.util.Arrays;

public class FormModelHelper extends FormModel<Object> {

  public FormModelHelper(BaseField... list) {
    super(Arrays.asList(list));
  }

  @NonNull
  @Override
  protected Object buildForm() {
    return null;
  }
}
