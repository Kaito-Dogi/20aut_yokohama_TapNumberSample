package app.ikeya.ryo.tapnumber

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //残り時間
    var second = 10

    //スコア
    var tapCount = 0

    //ランダムな数を用意するためのリスト。
    val ranNum: MutableList<Int> = mutableListOf()

    //タイマー
    private val timer: CountDownTimer = object : CountDownTimer(10000, 1000) {

        //時間切れの処理
        override fun onFinish() {
           startButton.isVisible = true
            //ボタンの色をグレーにする。
            tapButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
            tapButton2.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
            tapButton3.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
            tapButton4.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
            tapButton5.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
            tapButton6.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
            tapButton7.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
            tapButton8.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
            tapButton9.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
            tapButton0.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))

            //ボタンを押せなくする。
            tapButton.isEnabled = false
            tapButton2.isEnabled = false
            tapButton3.isEnabled = false
            tapButton4.isEnabled = false
            tapButton5.isEnabled = false
            tapButton6.isEnabled = false
            tapButton7.isEnabled = false
            tapButton8.isEnabled = false
            tapButton9.isEnabled = false
            tapButton0.isEnabled = false

            //スタートボタンを赤色にする。
            startButton.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#bf2707"))
            startButton.isEnabled = true

            //残り時間をリセット。
            second = 10

            //問題をリセット。
            ranNum.retainAll { it == 10 }
        }

        //毎秒呼ばれる
        override fun onTick(millisUntilFinished: Long) {

            //残り時間を1減らす。
            second = second - 1
            secondText.text = second.toString()

            textNumber.text = ranNum.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ボタンの色をグレーにする。
        tapButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
        tapButton2.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
        tapButton3.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
        tapButton4.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
        tapButton5.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
        tapButton6.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
        tapButton7.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
        tapButton8.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
        tapButton9.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))
        tapButton0.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))

        //ボタンを押せなくする。
        tapButton.isEnabled = false
        tapButton2.isEnabled = false
        tapButton3.isEnabled = false
        tapButton4.isEnabled = false
        tapButton5.isEnabled = false
        tapButton6.isEnabled = false
        tapButton7.isEnabled = false
        tapButton8.isEnabled = false
        tapButton9.isEnabled = false
        tapButton0.isEnabled = false

        startButton.setOnClickListener {

            //問題を生成。
            ranNum.add((0 until 10).random())
            ranNum.add((0 until 10).random())
            ranNum.add((0 until 10).random())
            ranNum.add((0 until 10).random())

            //ボタンを押せるようにする。
            tapButton.isEnabled = true
            tapButton2.isEnabled = true
            tapButton3.isEnabled = true
            tapButton4.isEnabled = true
            tapButton5.isEnabled = true
            tapButton6.isEnabled = true
            tapButton7.isEnabled = true
            tapButton8.isEnabled = true
            tapButton9.isEnabled = true
            tapButton0.isEnabled = true

            //ボタンの色を赤にする。
            tapButton.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#bf2707"))
            tapButton2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#bf2707"))
            tapButton3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#bf2707"))
            tapButton4.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#bf2707"))
            tapButton5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#bf2707"))
            tapButton6.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#bf2707"))
            tapButton7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#bf2707"))
            tapButton8.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#bf2707"))
            tapButton9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#bf2707"))
            tapButton0.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#bf2707"))

            //ボタンの色を赤にする。
            tapButton.setBackgroundResource(R.drawable.background_button_circle)
            tapButton2.setBackgroundResource(R.drawable.background_button_circle)
            tapButton3.setBackgroundResource(R.drawable.background_button_circle)
            tapButton4.setBackgroundResource(R.drawable.background_button_circle)
            tapButton5.setBackgroundResource(R.drawable.background_button_circle)
            tapButton6.setBackgroundResource(R.drawable.background_button_circle)
            tapButton7.setBackgroundResource(R.drawable.background_button_circle)
            tapButton8.setBackgroundResource(R.drawable.background_button_circle)
            tapButton9.setBackgroundResource(R.drawable.background_button_circle)

            //残り時間をTextViewに表示。
            secondText.text = second.toString()

            //スコアをリセット。
            tapCount = 0
            totalscoreText.text = tapCount.toString()

            //スタートボタンを押せなくする。
            startButton.isEnabled = false
            startButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(110,110,110))

            //問題を表示。
            textNumber.text = ranNum.toString()

            //タイマーをスタート。
            timer.start()
        }

        tapButton.setOnClickListener {
            //最も左の数が1の時の処理。
            if (ranNum[0] == 1) {
                //得点を1増加。
                tapCount = tapCount + 1
                totalscoreText.text = tapCount.toString()
                //最も左の数を削除。
                ranNum.removeAt(0)
            }
            //ranNumが空の時の処理。
            if (ranNum.size == 0){
                restart(ranNum)
            }
            //ranNumをTextViewに表示。
            textNumber.text = ranNum.toString()
        }

        tapButton2.setOnClickListener {
            //最も左の数が1の時の処理。
            if (ranNum[0] == 2) {
                //得点を1増加。
                tapCount = tapCount + 1
                totalscoreText.text = tapCount.toString()
                //最も左の数を削除。
                ranNum.removeAt(0)
            }
            //ranNumが空の時の処理。
            if (ranNum.size == 0){
                restart(ranNum)
            }
            //ranNumをTextViewに表示。
            textNumber.text = ranNum.toString()
        }

        tapButton3.setOnClickListener {
            //最も左の数が1の時の処理。
            if (ranNum[0] == 3) {
                //得点を1増加。
                tapCount = tapCount + 1
                totalscoreText.text = tapCount.toString()
                //最も左の数を削除。
                ranNum.removeAt(0)
            }
            //ranNumが空の時の処理。
            if (ranNum.size == 0){
                restart(ranNum)
            }
            //ranNumをTextViewに表示。
            textNumber.text = ranNum.toString()
        }

        tapButton4.setOnClickListener {
            //最も左の数が1の時の処理。
            if (ranNum[0] == 4) {
                //得点を1増加。
                tapCount = tapCount + 1
                totalscoreText.text = tapCount.toString()
                //最も左の数を削除。
                ranNum.removeAt(0)
            }
            //ranNumが空の時の処理。
            if (ranNum.size == 0){
                restart(ranNum)
            }
            //ranNumをTextViewに表示。
            textNumber.text = ranNum.toString()
        }

        tapButton5.setOnClickListener {
            //最も左の数が1の時の処理。
            if (ranNum[0] == 5) {
                //得点を1増加。
                tapCount = tapCount + 1
                totalscoreText.text = tapCount.toString()
                //最も左の数を削除。
                ranNum.removeAt(0)
            }
            //ranNumが空の時の処理。
            if (ranNum.size == 0){
                restart(ranNum)
            }
            //ranNumをTextViewに表示。
            textNumber.text = ranNum.toString()
        }

        tapButton6.setOnClickListener {
            //最も左の数が1の時の処理。
            if (ranNum[0] == 6) {
                //得点を1増加。
                tapCount = tapCount + 1
                totalscoreText.text = tapCount.toString()
                //最も左の数を削除。
                ranNum.removeAt(0)
            }
            //ranNumが空の時の処理。
            if (ranNum.size == 0){
                restart(ranNum)
            }
            //ranNumをTextViewに表示。
            textNumber.text = ranNum.toString()
        }

        tapButton7.setOnClickListener {
            //最も左の数が1の時の処理。
            if (ranNum[0] == 7) {
                //得点を1増加。
                tapCount = tapCount + 1
                totalscoreText.text = tapCount.toString()
                //最も左の数を削除。
                ranNum.removeAt(0)
            }
            //ranNumが空の時の処理。
            if (ranNum.size == 0){
                restart(ranNum)
            }
            //ranNumをTextViewに表示。
            textNumber.text = ranNum.toString()
        }

        tapButton8.setOnClickListener {
            //最も左の数が1の時の処理。
            if (ranNum[0] == 8) {
                //得点を1増加。
                tapCount = tapCount + 1
                totalscoreText.text = tapCount.toString()
                //最も左の数を削除。
                ranNum.removeAt(0)
            }
            //ranNumが空の時の処理。
            if (ranNum.size == 0){
                restart(ranNum)
            }
            //ranNumをTextViewに表示。
            textNumber.text = ranNum.toString()
        }

        tapButton9.setOnClickListener {
            //最も左の数が1の時の処理。
            if (ranNum[0] == 9) {
                //得点を1増加。
                tapCount = tapCount + 1
                totalscoreText.text = tapCount.toString()
                //最も左の数を削除。
                ranNum.removeAt(0)
            }
            //ranNumが空の時の処理。
            if (ranNum.size == 0){
                restart(ranNum)
            }
            //ranNumをTextViewに表示。
            textNumber.text = ranNum.toString()
        }

        tapButton0.setOnClickListener {
            //最も左の数が1の時の処理。
            if (ranNum[0] == 0) {
                //得点を1増加。
                tapCount = tapCount + 1
                totalscoreText.text = tapCount.toString()
                //最も左の数を削除。
                ranNum.removeAt(0)
            }
            //ranNumが空の時の処理。
            if (ranNum.size == 0){
                restart(ranNum)
            }
            //ranNumをTextViewに表示。
            textNumber.text = ranNum.toString()
        }
    }

    fun restart(ranNum: MutableList<Int>): MutableList<Int> {
        ranNum.add((0 until 10).random())
        ranNum.add((0 until 10).random())
        ranNum.add((0 until 10).random())
        ranNum.add((0 until 10).random())
        return ranNum
    }
}
