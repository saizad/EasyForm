package sa.zad.easyform.easyform.fields;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import sa.zad.easyform.easyform.base.StringBaseField;

public class StringField extends StringBaseField {

    public StringField(@NonNull String fieldId, @Nullable String ogField, boolean isMandatory) {
        super(fieldId, ogField, isMandatory);
    }

    @Override
    protected boolean isValid() {
        return true;
    }

    @Override
    public void validate() throws Exception {

    }
}
