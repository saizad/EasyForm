package sa.zad.easyform.easyform.fields.time;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class PastDateTimeField extends DateTimeField {


  public PastDateTimeField(@NonNull String fieldId) {
    super(fieldId);
  }

  public PastDateTimeField(@NonNull String fieldId, boolean isMandatory) {
    super(fieldId, isMandatory);
  }

  public PastDateTimeField(@NonNull String fieldId, @Nullable String ogField) {
    super(fieldId, ogField);
  }

  public PastDateTimeField(@NonNull String fieldId, @Nullable String ogField, boolean isMandatory) {
    super(fieldId, ogField, isMandatory);
  }

  @Override
  public void validate() throws Exception {
    if(!dateTime().isBeforeNow()){
      throw new Exception("Date time can't be set after current date time");
    }
  }
}
