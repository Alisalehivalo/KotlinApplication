package ir.airport.kotlinapplication.DependencyInjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.airport.kotlinapplication.R

class DIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_di)
        /*
        val e=ClassE()
        val d=ClassD(e)
        val c= ClassC()
        val b= ClassB(c,d)
        val a= ClassA(b)
                 */
        //sakht instance Class A ba Dagger2
        val a=DaggerTestComponent.create().provideA()



    }
}
