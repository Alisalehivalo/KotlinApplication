package ir.airport.kotlinapplication.MVP

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.airport.kotlinapplication.R
import kotlinx.android.synthetic.main.activity_mvp.*

class MVPActivity(private val presenter: Contract.Presenter,private val model: Model) : AppCompatActivity(), Contract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)

        currentTime1.text=model.ShowCurrentTime()


    }
}
