package sa.zad.easyform.easyform.fields;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class NonEmptyListField<T> extends ListField<T> {


    public NonEmptyListField(@NonNull String fieldId) {
        super(fieldId);
    }

    public NonEmptyListField(@NonNull String fieldId, boolean isMandatory) {
        super(fieldId, isMandatory);
    }

    public NonEmptyListField(@NonNull String fieldId, @Nullable List<T> ogField) {
        super(fieldId, ogField);
    }

    public NonEmptyListField(@NonNull String fieldId, @Nullable List<T> ogField, boolean isMandatory) {
        super(fieldId, ogField, isMandatory);
    }

    @Override
    protected boolean isValid() {
        return isSet() && !getField().isEmpty();
    }
}
