package sa.zad.easyform.easyform.base;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import sa.zad.easyform.easyform.ObjectUtils;
import sa.zad.easyform.easyform.StringUtils;

public class FileField extends BaseField<Uri> {

  public FileField(@NonNull String fieldId) {
    super(fieldId);
  }

  public FileField(@NonNull String fieldId, boolean isMandatory) {
    super(fieldId, isMandatory);
  }

  public FileField(@NonNull String fieldId, @Nullable Uri ogField) {
    super(fieldId, ogField);
  }

  public FileField(@NonNull String fieldId, @Nullable Uri ogField, boolean isMandatory) {
    super(fieldId, ogField, isMandatory);
  }

  @Override
  protected boolean isValid() {
    return true;
  }

  @Override
  public void validate() throws Exception {

  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Uri){
      return StringUtils.isSame(
          ObjectUtils.returnNonNull(getField(), Uri.parse("")).toString(),
          ObjectUtils.returnNonNull(obj, Uri.parse("")).toString());
    }else{
      return ObjectUtils.isSameObject(obj, getField());
    }
  }
}
