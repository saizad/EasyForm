package sa.zad.easyform.easyform.fields;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import sa.zad.easyform.easyform.base.IntegerBaseField;

public class IntegerField extends IntegerBaseField {


  public IntegerField(@NonNull String fieldId) {
    super(fieldId);
  }

  public IntegerField(@NonNull String fieldId, boolean isMandatory) {
    super(fieldId, isMandatory);
  }

  public IntegerField(@NonNull String fieldId, @Nullable Integer ogField) {
    super(fieldId, ogField);
  }

  public IntegerField(@NonNull String fieldId, @Nullable Integer ogField, boolean isMandatory) {
    super(fieldId, ogField, isMandatory);
  }

  @Override
  protected boolean isValid() {
    return true;
  }

  @Override
  public void validate() throws Exception {

  }
}
