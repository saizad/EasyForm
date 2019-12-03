package sa.zad.easyform.easyform.fields.time;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DobField extends PastDateField {


  public DobField(@NonNull String fieldId) {
    super(fieldId);
  }

  public DobField(@NonNull String fieldId, @Nullable String ogField) {
    super(fieldId, ogField);
  }

  public DobField(@NonNull String fieldId, @Nullable String ogField, boolean isMandatory) {
    super(fieldId, ogField, isMandatory);
  }
}
