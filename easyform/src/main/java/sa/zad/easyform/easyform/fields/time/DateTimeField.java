package sa.zad.easyform.easyform.fields.time;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.joda.time.DateTime;

import sa.zad.easyform.easyform.base.StringBaseField;

public class DateTimeField extends StringBaseField {


    public DateTimeField(@NonNull String fieldId) {
        super(fieldId);
    }

    public DateTimeField(@NonNull String fieldId, boolean isMandatory) {
        super(fieldId, isMandatory);
    }

    public DateTimeField(@NonNull String fieldId, @Nullable String ogField) {
        super(fieldId, ogField);
    }

    public DateTimeField(@NonNull String fieldId, @Nullable String ogField, boolean isMandatory) {
        super(fieldId, ogField, isMandatory);
    }

    @Override
    public void validate() throws Exception {
        new DateTime(super.getField());
    }

    @Nullable
    public DateTime dateTime() {
        if (isSet()) {
            return new DateTime(super.getField());
        }
        return null;
    }
}
