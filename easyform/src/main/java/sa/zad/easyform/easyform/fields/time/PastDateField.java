package sa.zad.easyform.easyform.fields.time;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.joda.time.DateTime;

public class PastDateField extends DateField {


    public PastDateField(@NonNull String fieldId) {
        this(fieldId, null);
    }

    public PastDateField(@NonNull String fieldId, @Nullable String ogField) {
        super(fieldId, ogField);
    }

    public PastDateField(@NonNull String fieldId, @Nullable String ogField, boolean isMandatory) {
        super(fieldId, ogField, isMandatory);
    }

    @Override
    public void validate() throws Exception {
        if (!new DateTime().withTimeAtStartOfDay().isBefore(dateTime())) {
            throw new Exception("Date can't be set to past or current date");
        }
    }

}
