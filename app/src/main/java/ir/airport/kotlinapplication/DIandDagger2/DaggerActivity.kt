package ir.airport.kotlinapplication.DIandDagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.reactivex.disposables.CompositeDisposable

import ir.airport.kotlinapplication.R
import kotlinx.android.synthetic.main.activity_dagger.*

class DaggerActivity : AppCompatActivity() {
    lateinit var viewModel: DaggerViewModel
    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)
        val factory = DaggerFactoryComponent.create().provideVMFactory()
        viewModel = ViewModelProvider(this, factory).get(DaggerViewModel::class.java)
        viewModel.getName()
        btnC.setOnClickListener() {
            viewModel.getLiveData().observe(this, Observer {
                txtEdit.text = it
            })
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}
