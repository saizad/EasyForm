package sa.zad.easyform.easyform.fields;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import sa.zad.easyform.easyform.StringUtils;
import sa.zad.easyform.easyform.base.NonEmptyString;

public class NameField extends NonEmptyString {

  public NameField(@NonNull String fieldId, @NonNull String firstName, @NonNull String lastName) {
    this(fieldId, firstName + " " + lastName);
  }

  public NameField(@NonNull String fieldId, @Nullable String ogField) {
    this(fieldId, ogField, true);
  }

  public NameField(@NonNull String fieldId, @Nullable String ogField, boolean isMandatory) {
    super(fieldId, ogField, isMandatory);
  }

  public NameField(@NonNull String fieldId) {
    super(fieldId, null, true);
  }

  @Nullable
  public String getFirstName(){
    return getName(0);
  }

  @Nullable
  public String getLastName(){
    return getName(1);
  }

  @Nullable
  private String getName(int index){
    if(isValid()) {
      final String[] split = StringUtils.stripTrailingLeadingNewLines(getField()).split(" ");
      return split[index];
    }
    return null;
  }

  @Override
  protected boolean isValid() {
    return UserProfileFieldsValidatorsKt.isNameValid(getField());
  }

  @Override
  public void validate() throws Exception {
    UserProfileFieldsValidatorsKt.validateName(getField());
  }
}
