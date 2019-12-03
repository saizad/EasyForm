package sa.zad.easyform.easyform.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BooleanField extends BaseField<Boolean> {

    public BooleanField(@NonNull String fieldId, @Nullable Boolean ogField, boolean isMandatory) {
        super(fieldId, ogField, isMandatory);
    }

    public BooleanField(@NonNull String fieldId) {
        super(fieldId);
    }

    public BooleanField(@NonNull String fieldId, boolean isMandatory) {
        super(fieldId, isMandatory);
    }

    public BooleanField(@NonNull String fieldId, @Nullable Boolean ogField) {
        super(fieldId, ogField);
    }

    @Override
    protected boolean isValid() {
        return true;
    }

    @NonNull
    @Override
    public Boolean getField() {
        final Boolean field = super.getField();
        return field == null ? false: field;
    }

    @Override
    public void validate() throws Exception {

    }
}
