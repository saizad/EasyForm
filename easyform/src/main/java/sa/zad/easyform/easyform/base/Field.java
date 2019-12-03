package sa.zad.easyform.easyform.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Field<F> extends BaseField<F> {

    public Field(@NonNull String fieldId, @Nullable F ogField, boolean isMandatory) {
        super(fieldId, ogField, isMandatory);
    }

    public Field(@NonNull String fieldId, F ogField) {
        super(fieldId, ogField, true);
    }

    @Override
    protected boolean isValid() {
        return true;
    }

    @Override
    public void validate() throws Exception {

    }
}
