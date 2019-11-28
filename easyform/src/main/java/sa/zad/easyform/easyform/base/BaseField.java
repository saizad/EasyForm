package sa.zad.easyform.easyform.base;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import sa.zad.easyform.easyform.ObjectUtils;

import static sa.zad.easyform.easyform.ObjectUtils.isNotNull;

public abstract class BaseField<T> {

  private final boolean mIsMandatory;
  @NonNull private final String fieldId;
  private final @Nullable
  T ogField;
  protected transient Object emptyObject = new Object();
  private transient BehaviorSubject<Object> subject = BehaviorSubject.create();
  private transient Observable<Object> observable = subject;
  private transient BehaviorSubject<String> networkErrorSubject = BehaviorSubject.create();
  private transient Observable<String> networkError = networkErrorSubject;
  private @Nullable
  T field;
  private final static String EMPTY_NETWORK_ERROR_MESSAGE = "--empty---";
  private boolean __isValid = false;

  public BaseField(@NonNull String fieldId) {
    this(fieldId, null, false);
  }

  public BaseField(@NonNull String fieldId, boolean isMandatory) {
    this(fieldId, null, isMandatory);
  }

  public BaseField(@NonNull String fieldId, @Nullable T ogField) {
    this(fieldId, ogField, false);
  }

  public BaseField(@NonNull String fieldId, @Nullable T ogField, boolean isMandatory) {
    this.fieldId = fieldId;
    this.ogField = ogField;
    setField(ogField);
    mIsMandatory = isMandatory;
    subject.onNext(emptyObject);
  }

  public Observable<Object> observable() {
    return observable;
  }

  public Observable<T> setObservable() {
    return observable().filter(o -> isNotNull(field)).map(o -> field);
  }

  public Observable<Boolean> validObservable(){
    return observable().map(o -> __isValid);
  }

  public Observable<Pair<String, T>> nonEmptyInvalidObservable() {
    return setObservable().filter(o -> !__isValid).map(o -> {
      try {
        validate();
        return new Pair<>("--- some thing is broken :( ---", getField());
      } catch (Exception e) {
        return new Pair<>(e.getMessage(), field);
      }
    });
  }

  public Observable<Pair<String, T>> invalidObservable() {
    return observable().filter(o -> !__isValid).map(o -> {
      try {
        validate();
        return new Pair<>("--- some thing is broken :( ---", getField());
      } catch (Exception e) {
        return new Pair<>(e.getMessage(), field);
      }
    });
  }

  public Observable<T> notEmptyValidObservable() {
    return setObservable().filter(o -> __isValid).map(o -> field);
  }

  public Observable<Object> fieldUnsetObservable() {
    return observable().filter(o -> ObjectUtils.isNull(field));
  }

  public Observable<Pair<Boolean, String>> runTimeErrorState() {
    return observable().map(o -> new Pair<>(__isValid || isRuntimeValid(), getFieldId()));
  }

  public Observable<Pair<Boolean, String>> errorState() {
    return observable().map(o -> new Pair<>(__isValid, getFieldId()));
  }

  public Observable<Boolean> modified() {
    return observable().map(o -> isModified());
  }

  public boolean isModified() {
    return !equals(ogField);
  }

  public boolean isRuntimeValid() {
    return ObjectUtils.isNull(field);
  }

  public boolean isSet() {
    return isNotNull(field);
  }

  @Nullable
  public T getField() {
    return field;
  }

  @CallSuper
  public void setField(@Nullable T value) {
    field = value;
    __isValid = __isValid();
    publish();
  }

  @Nullable
  public T getOgField() {
    return ogField;
  }

  public void publish() {
    subject.onNext(emptyObject);
    networkErrorSubject.onNext(EMPTY_NETWORK_ERROR_MESSAGE);
  }

  public void networkErrorPublish(String error){
    networkErrorSubject.onNext(error);
  }

  public Observable<String> networkError(){
    return networkError.filter(s -> !s.equals(EMPTY_NETWORK_ERROR_MESSAGE));
  }

  @NonNull
  public final String getFieldId() {
    return fieldId;
  }

  public boolean isMandatory() {
    return mIsMandatory;
  }

  private boolean __isValid(){
    if(!mIsMandatory){
      __isValid = ObjectUtils.isNull(field) || isValid();
      return __isValid;
    }
    __isValid = isValid();
    return __isValid;
  }

  public boolean isValid(){
    return __isValid;
  }

  public abstract void validate() throws Exception;
}
