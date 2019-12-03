package sa.zad.easyform.easyform.fields.time;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class EndDateTimeField extends DateTimeField {

    private StartDateTimeField startTimeField;

    public EndDateTimeField(@NonNull String fieldId) {
        super(fieldId);
    }

    public EndDateTimeField(@NonNull String fieldId, @Nullable String ogField) {
        super(fieldId, ogField, false);
    }

    public EndDateTimeField(@NonNull String fieldId, @Nullable String ogField, boolean isMandatory) {
        super(fieldId, ogField, isMandatory);
    }


    @Override
    public void validate() throws Exception {
        FieldValidator.validateEndTime(startTimeField.dateTime(), dateTime());
    }

    public void setStartTimeField(@NonNull StartDateTimeField startTimeField) {
        this.startTimeField = startTimeField;
        startTimeField.observable().subscribe(__ -> publish());
    }
}
