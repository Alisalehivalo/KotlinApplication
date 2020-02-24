package ir.airport.kotlinapplication.RxJava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import ir.airport.kotlinapplication.R
import kotlin.random.Random

class TestRxJavaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_rx_java)

        //Build Observable
 //       Observable
            //for emit items(int 1 .. 5)
 //           .just(1, 2, 3, 4, 5)
            //for subscribe observers and emit items
            //have 4 methods onNext(yeki yeki item pass bede),onError(agar errori etefagh oftad),onComplete(agar emit tamoom shod),onScribe(etela az scribe shodan)
 //           .subscribe(
 //               {
 //                   Log.d("onNext", it.toString())
        //              },
   //             {
     //               Log.d("onError", it.message)
       //         }
         //   )
        //getObservable()
          //  .subscribe(
            //    {
              //     Log.d("onNext", it.toString())
                //},
                //{
                  //  Log.d("onError", it.message)
                 //}
            //)
        //instant of testrxclass
        val trc=TestRxClass()
        trc.getObservable()
            .map{it*10}
            .filter{it <100}
            .skip(1)
            .sorted()
            .subscribe(
                {
                    Log.d("onNext", it.toString())
                },
                {
                  Log.d("onError", it.message)
                }
                )
        //Ijad ye observable baraye entekhab ye esm besoorat random ba ghayed zir
        Observable
            .just("Ali","Saeed","Abolfazl","Tarannom","Kaveh")
                //for select first character from items
            .map { it.first() }
                //for chasbandan avalin character be ye adad randomi az 0 ta 100 mesal: A10
            .map { it to Random.nextInt(100) }
                //sort shodan bar asas bakhsh dovom har item yani dar C10 compare bar asas 10 , va intor sort beshvad
            .sorted { o1, o2 -> o1.second.compareTo(o2.second) }
                //characyer aval select beshe
            .map { it.first }
                //agar ta ghabl az in hichi peyda nakard ooni ra entekhab kon ke ba A shoroo shode
            .first('A')
            .subscribe(
                {
                    Log.d("onNext1", it.toString())
                },
                {
                    Log.d("onError1", it.message)
                }
            )


        }
    //fun for return observable and pass items
    fun getObservable() : Observable<Int>{
        return Observable.just(1,2,3,4,5)
    }
}
