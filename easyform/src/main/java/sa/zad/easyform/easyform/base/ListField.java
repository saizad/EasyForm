package sa.zad.easyform.easyform.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import io.reactivex.Observable;
import sa.zad.easyform.easyform.ListUtils;
import sa.zad.easyform.easyform.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class ListField<T> extends BaseField<List<T>> {

  public ListField(@NonNull String fieldId) {
    this(fieldId, null);
  }

  public ListField(@NonNull String fieldId, boolean isMandatory) {
    this(fieldId,null, isMandatory);
  }

  public ListField(@NonNull String fieldId, @Nullable List<T> ogField) {
    super(fieldId, ogField);
    setField(null);
  }

  public ListField(@NonNull String fieldId, @Nullable List<T> ogField, boolean isMandatory) {
    super(fieldId, ogField, isMandatory);
    setField(null);
  }

  @Override
  public boolean isModified() {
    if(ObjectUtils.isNull(getOgField()))
      return !getField().isEmpty();

    for (T ogListValue : getOgField()) {
      if(!ListUtils.contains(getField(), ogListValue)){
        return true;
      }
    }

    return super.isModified();
  }

  @Override
  public boolean isValid() {
    return true;
  }

  @Override
  public void validate() throws Exception {

  }

  @Override
  public void setField(@Nullable List<T> value) {

    if(ObjectUtils.isNull(value))
      value = new ArrayList<>();

    final List<T> list = getField();
    list.clear();
    list.addAll(value);
    super.setField(list);
  }

  @NonNull
  @Override
  public List<T> getField() {
    return ObjectUtils.coalesce(super.getField(), new ArrayList<>());
  }

  public Observable<List<T>> emptyListObservable(){
    return notEmptyValidObservable()
        .filter(List::isEmpty);
  }

  @Override
  public Observable<Object> fieldUnsetObservable() {
    return Observable.merge(emptyListObservable(), super.fieldUnsetObservable()).map(o -> emptyObject);
  }
}
