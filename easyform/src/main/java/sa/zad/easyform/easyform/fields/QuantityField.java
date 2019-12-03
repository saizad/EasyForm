package sa.zad.easyform.easyform.fields;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import sa.zad.easyform.easyform.ObjectUtils;

public class QuantityField extends NonEmptyIntegerField {


    public QuantityField(@NonNull String fieldId) {
        super(fieldId);
    }

    public QuantityField(@NonNull String fieldId, boolean isMandatory) {
        super(fieldId, isMandatory);
    }

    public QuantityField(@NonNull String fieldId, @Nullable Integer ogField) {
        super(fieldId, ogField);
    }

    public QuantityField(@NonNull String fieldId, @Nullable Integer ogField, boolean isMandatory) {
        super(fieldId, ogField, isMandatory);
    }

    @Override
    protected boolean isValid() {
        try {
            validate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void validate() throws Exception {
        if (getField() == 0) {
            throw new Exception("Quantity can not be greater than the order quantity");
        }
        super.validate();
    }

    public void add() {
        add(1);
    }

    public void add(Integer count) {
        setField(getField() + count);
    }

    public void remove() {
        remove(1, false);
    }

    public void remove(int count, boolean strict) {
        if (getField() >= count) {
            setField(getField() - count);
        } else if(!strict) {
            setField(0);
        }
    }

    @NonNull
    @Override
    public Integer getField() {
        if (ObjectUtils.isNotNull(super.getField())) {
            return super.getField();
        }
        return 0;
    }
}
