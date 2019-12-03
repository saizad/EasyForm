package sa.zad.easyform.easyform.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import sa.zad.easyform.easyform.ObjectUtils;

public abstract class StringBaseField extends BaseField<String> {

    public StringBaseField(@NonNull String fieldId) {
        super(fieldId);
    }

    public StringBaseField(@NonNull String fieldId, boolean isMandatory) {
        super(fieldId, isMandatory);
    }

    public StringBaseField(@NonNull String fieldId, @Nullable String ogField) {
        super(fieldId, ogField);
    }

    public StringBaseField(@NonNull String fieldId, @Nullable String ogField, boolean isMandatory) {
        super(fieldId, ogField, isMandatory);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof String) {
            return obj.equals(getField());
        } else {
            return ObjectUtils.isSameObject(obj, getField());
        }
    }
}
