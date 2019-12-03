package sa.zad.easyform.easyform.base;


import androidx.annotation.NonNull;

import sa.zad.easyform.easyform.StringUtils;

public class ConfirmPasswordField extends BasePasswordField {

    private BasePasswordField basePasswordField;

    public ConfirmPasswordField(@NonNull String fieldId) {
        super(fieldId);
    }

    public void setRelated(BasePasswordField basePasswordField) {
        this.basePasswordField = basePasswordField;
        basePasswordField.observable().subscribe(__ -> publish());
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
        if(!StringUtils.isNullOrEmpty(getField()) && !StringUtils.isNullOrEmpty(basePasswordField.getField())){
            if(!basePasswordField.getField().equals(getField())){
                throw new Exception("Password doesn't match");
            }
        }
    }
}
