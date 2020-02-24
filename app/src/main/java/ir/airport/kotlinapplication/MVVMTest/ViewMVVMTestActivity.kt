package ir.airport.kotlinapplication.MVVMTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ir.airport.kotlinapplication.R
import kotlinx.android.synthetic.main.activity_view_mvvmtest.*

class ViewMVVMTestActivity : AppCompatActivity() {
// baraye sakht instance az view model va meghdardehi an bayad:
// 1:ye instance azash besazi ke badan meghdar dehi koni baraye hamin az lateinit estefade konid
// 2: meghdardehi ba viewmodelprovider
    lateinit var viewmodel : ViewModelTest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_mvvmtest)
        // ba inkar hamishe dar soorat rotation change yek copy az class viewmodeltest baraye instance sakhte shode anjam mishavad
        viewmodel=ViewModelProvider(this).get(ViewModelTest::class.java)
        //baraye ijad enteghal data be komak livedata az Viewmodel be Activity
        //va observe kardan data az vm va toast  kon be observer ha
        viewmodel.userResponce.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_LONG).show()
        })
        viewmodel.userError.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_LONG).show()
        })
        //seda zadan method get user data ba id 1
        viewmodel.getUserData(1)

        btnSave.setOnClickListener(){
            //harchizi ke dar viewmodel tarif beshavad ba rotation gooshi distroy nemishavad
            viewmodel.userName="SAMAN"
        }
        txtName.text=viewmodel.userName
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}
