package sa.zad.easyform.easyform.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import sa.zad.easyform.easyform.StringUtils;

public class NonEmptyMandatoryStringField extends NonEmptyString {

    public NonEmptyMandatoryStringField(@NonNull String fieldId, @Nullable String ogField) {
        super(fieldId, ogField, true);
    }

    @Override
    protected boolean isValid() {
        return !StringUtils.isNullOrEmpty(getField());
    }

    @Override
    public void validate() throws Exception {
        if (!isValid()) {
            throw new Exception(getFieldId() + " is required");
        }
    }
}
