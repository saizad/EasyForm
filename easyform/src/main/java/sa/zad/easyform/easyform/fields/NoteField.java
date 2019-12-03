package sa.zad.easyform.easyform.fields;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import sa.zad.easyform.easyform.ObjectUtils;

public class NoteField extends StringField {

    public NoteField(@NonNull String fieldId, @Nullable String ogField) {
        super(fieldId, ogField, false);
    }

    @Override
    protected boolean isValid() {
        return UserProfileFieldsValidatorsKt.isNoteValid(getField());
    }

    @Override
    public void validate() throws Exception {
        UserProfileFieldsValidatorsKt.validateNote(getField());
    }

    @Override
    public void setField(@Nullable String value) {
        if(ObjectUtils.isNotNull(value) && value.isEmpty()){
            value = null;
        }
        super.setField(value);
    }
}
