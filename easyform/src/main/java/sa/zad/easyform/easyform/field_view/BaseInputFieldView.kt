package sa.zad.easyform.easyform.field_view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.EditText
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import sa.zad.easyform.easyform.ObjectUtils
import java.util.concurrent.TimeUnit

abstract class BaseInputFieldView<F> @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    BaseFieldView<F>(
        context,
        attrs,
        defStyleAttr
    ) {

    private lateinit var disposable: Disposable

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (!isInEditMode) {
            disposable = RxTextView.textChanges(getEditText())
                .skipInitialValue()
                .debounce(100, TimeUnit.MILLISECONDS)
                .filter { ObjectUtils.coalesce(fieldItem.field, "") != it.toString() }
                .filter { !isSame(resolveTo(it), fieldItem.field) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { s ->
                    Log.d("fcm", s.toString())
                    updateValue(resolveTo(s))
                }
        }
    }

    override fun onDetachedFromWindow() {
        disposable.dispose()
        super.onDetachedFromWindow()
    }

    final override fun showValue(value: F?) {
        if (!getEditText().isFocused) {
            getEditText().setText(setText(value))
        }
    }

    abstract fun getEditText(): EditText
    abstract fun resolveTo(charSequence: CharSequence): F
    abstract fun setText(value: F?): CharSequence?
    abstract fun isSame(value: F?, prevValue: F?): Boolean
}
