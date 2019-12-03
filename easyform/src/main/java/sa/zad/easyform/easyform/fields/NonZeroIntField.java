package sa.zad.easyform.easyform.fields;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import sa.zad.easyform.easyform.ObjectUtils;

public class NonZeroIntField extends NonEmptyIntegerField {


    public NonZeroIntField(@NonNull String fieldId) {
        this(fieldId, false);
    }

    public NonZeroIntField(@NonNull String fieldId, boolean isMandatory) {
        this(fieldId, null, isMandatory);
    }

    public NonZeroIntField(@NonNull String fieldId, @Nullable Integer ogField) {
        this(fieldId, ogField, false);
    }

    public NonZeroIntField(@NonNull String fieldId, @Nullable Integer ogField, boolean isMandatory) {
        super(fieldId, ogField, isMandatory);
        setField(ogField);
    }

    @Override
    public void validate() throws Exception {
        if (isSet() && getField() <= 0) {
            throw new Exception("Number should be greater than 0");
        }
        super.validate();
    }

    @Override
    public void setField(@Nullable Integer value) {
        if(ObjectUtils.isNotNull(value) && value <= 0){
            value = null;
        }
        super.setField(value);
    }
}
