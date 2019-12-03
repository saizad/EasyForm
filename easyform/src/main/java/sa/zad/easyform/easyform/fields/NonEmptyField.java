package sa.zad.easyform.easyform.fields;

import androidx.annotation.NonNull;

import sa.zad.easyform.easyform.ObjectUtils;
import sa.zad.easyform.easyform.base.BaseField;

public class NonEmptyField<F> extends BaseField<F> {

    public NonEmptyField(@NonNull String fieldId, F ogField) {
        super(fieldId, ogField, true);
    }

    @Override
    protected boolean isValid() {
        return ObjectUtils.isNotNull(getField());
    }

    @Override
    public void validate() throws Exception {
        if (ObjectUtils.isNull(getField())) {
            throw new Exception("Field is mandatory");
        }
    }
}
