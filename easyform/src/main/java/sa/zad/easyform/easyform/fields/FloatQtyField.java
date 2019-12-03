package sa.zad.easyform.easyform.fields;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import sa.zad.easyform.easyform.base.BaseField;

public class FloatQtyField extends BaseField<Float> {


    public FloatQtyField(@NonNull String fieldId) {
        this(fieldId, false);
    }

    public FloatQtyField(@NonNull String fieldId, boolean isMandatory) {
        this(fieldId, null, isMandatory);
    }

    public FloatQtyField(@NonNull String fieldId, @Nullable Float ogField) {
        this(fieldId, ogField, false);
    }

    public FloatQtyField(@NonNull String fieldId, @Nullable Float ogField, boolean isMandatory) {
        super(fieldId, ogField, isMandatory);
    }

    @Override
    public void validate() throws Exception {
        if (isSet() && getField() < 0) {
            throw new Exception("Number should be greater than or equals to 0");
        }
    }

    @Override
    protected boolean isValid() {
        try {
            validate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
