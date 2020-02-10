package ir.airport.kotlinapplication

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class FontTextview : AppCompatTextView {
    constructor(context: Context?) : super(context) {}
    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs) {
        val IranSans = Typeface.createFromAsset(context.assets, "IranSans.ttf")
        this.typeface = IranSans
    }
}