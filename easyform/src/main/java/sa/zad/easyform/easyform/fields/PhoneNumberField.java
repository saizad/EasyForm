package sa.zad.easyform.easyform.fields;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import sa.zad.easyform.easyform.ObjectUtils;
import sa.zad.easyform.easyform.base.NonEmptyString;

public class PhoneNumberField extends NonEmptyString {

    private final int length;

    public PhoneNumberField(@NonNull String fieldId, int length) {
        this(fieldId, false, length);
    }

    public PhoneNumberField(@NonNull String fieldId, boolean isMandatory, int length) {
        this(fieldId, null, isMandatory, length);
    }

    public PhoneNumberField(@NonNull String fieldId, @Nullable String ogField, int length) {
        this(fieldId, ogField, false, length);
    }

    public PhoneNumberField(@NonNull String fieldId, @Nullable String ogField, boolean isMandatory, int length) {
        super(fieldId, ogField, isMandatory);
        this.length = length;
    }

    @Override
    protected boolean isValid() {
        return ObjectUtils.isNotNull(getField()) && getField().length() == length;
    }

    @Override
    public void validate() throws Exception {
        if (!isValid()) {
            throw new Exception("Mobile number is required field and should be 10 digits longer");
        }
    }
}
