package sa.zad.easyform.easyform.fields;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import sa.zad.easyform.easyform.ObjectUtils;
import sa.zad.easyform.easyform.base.IntegerBaseField;

public class NonEmptyIntegerField extends IntegerBaseField {


  public NonEmptyIntegerField(@NonNull String fieldId) {
    super(fieldId);
  }

  public NonEmptyIntegerField(@NonNull String fieldId, boolean isMandatory) {
    super(fieldId, isMandatory);
  }

  public NonEmptyIntegerField(@NonNull String fieldId, @Nullable Integer ogField) {
    super(fieldId, ogField);
  }

  public NonEmptyIntegerField(@NonNull String fieldId, @Nullable Integer ogField, boolean isMandatory) {
    super(fieldId, ogField, isMandatory);
  }

  @Override
  protected boolean isValid() {
    try {
      validate();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public void validate() throws Exception {
    if(ObjectUtils.isNull(getField())){
      throw new Exception("Invalid field value");
    }
  }
}
