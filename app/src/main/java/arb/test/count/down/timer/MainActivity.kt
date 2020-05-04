package arb.test.count.down.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val start = 600_000L
    var timer = start
    lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//      yhe first value
        setTextTimer()

    }

    fun on(view: View) {
        when(view.id){
            R.id.btn_main_start -> startTimer()
            R.id.btn_main_pause -> pauseTimer()
            R.id.btn_main_rest -> restTimer()
        }
    }

//    btn start
    private fun startTimer() {
        countDownTimer = object : CountDownTimer(timer,1000){
//            end of timer
            override fun onFinish() {
                Toast.makeText(this@MainActivity,"end timer",Toast.LENGTH_SHORT).show()
            }

            override fun onTick(millisUntilFinished: Long) {
                timer = millisUntilFinished
                setTextTimer()
            }

        }.start()
    }

//    btn pause
    private fun pauseTimer() {
        countDownTimer.cancel()
    }

//    btn restart
    private fun restTimer() {
        countDownTimer.cancel()
        timer = start
        setTextTimer()
    }

//  timer format
    fun setTextTimer() {
        var m = (timer / 1000) / 60
        var s = (timer / 1000) % 60

        var format = String.format("%02d:%02d", m, s)

        tv_main_timer.setText(format)
    }
}
