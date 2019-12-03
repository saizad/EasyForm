package sa.zad.easyform.easyform.fields.time;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class EndDateField extends DateField {

  private DateTimeField startDateField;

  public EndDateField(@NonNull String fieldId) {
    super(fieldId);
  }

  public EndDateField(@NonNull String fieldId, boolean isMandatory) {
    super(fieldId, isMandatory);
  }

  public EndDateField(@NonNull String fieldId, @Nullable String ogField) {
    super(fieldId, ogField);
  }

  public EndDateField(@NonNull String fieldId, @Nullable String ogField, boolean isMandatory) {
    super(fieldId, ogField, isMandatory);
  }

  @Override
  public void validate() throws Exception {
    if(dateTime().isBefore(startDateField.dateTime()))
    startDateField.dateTime()
  }

  public void setStartDateField(@NonNull DateTimeField startDateField) {
    this.startDateField = startDateField;
    startDateField.observable().subscribe(__ -> publish());
  }
}
