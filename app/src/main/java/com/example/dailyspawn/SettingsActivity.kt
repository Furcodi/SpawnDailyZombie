package com.example.dailyspawn

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val oneTime = findViewById<CheckBox>(R.id.oneTime)
        if (MainActivity.cbOneTime) { oneTime.isChecked = true }

        val WalkerText = findViewById<TextView>(R.id.SettingTextWalker)
        val WalkerSeek = findViewById<SeekBar>(R.id.seekBarWalker)
        WalkerSeek.setProgress(MainActivity.wahrWalker)
        WalkerText.text = getString(R.string.SettingTextWalker_text) + ": " + WalkerSeek.progress + "%"
        WalkerSeek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
                WalkerText.text = getString(R.string.SettingTextWalker_text) + ": " + WalkerSeek.progress + "%"
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                MainActivity.wahrWalker = WalkerSeek.progress
            }
        })

        val RunnerText = findViewById<TextView>(R.id.SettingTextRunner)
        val RunnerSeek = findViewById<SeekBar>(R.id.seekBarRunner)
        RunnerSeek.setProgress(MainActivity.wahrRunner)
        RunnerText.text = getString(R.string.SettingTextRunner_text) + ": " + RunnerSeek.progress + "%"
        RunnerSeek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
                RunnerText.text = getString(R.string.SettingTextRunner_text) + ": " + RunnerSeek.progress + "%"
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                MainActivity.wahrRunner = RunnerSeek.progress
            }
        })

        val FattyText = findViewById<TextView>(R.id.SettingTextFatty)
        val FattySeek = findViewById<SeekBar>(R.id.seekBarFatty)
        FattySeek.setProgress(MainActivity.wahrFatty)
        FattyText.text = getString(R.string.SettingTextFatty_text) + ": " + FattySeek.progress + "%"
        FattySeek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
                FattyText.text = getString(R.string.SettingTextFatty_text) + ": " + FattySeek.progress + "%"
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                MainActivity.wahrFatty = FattySeek.progress
            }
        })


        oneTime?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                MainActivity.cbOneTime = true
            } else {
                MainActivity.cbOneTime = false
                MainActivity.walker_array.clear()
                MainActivity.runner_array.clear()
                MainActivity.fatty_array.clear()
                MainActivity.walker_array += listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19)
                MainActivity.runner_array += listOf(1,2,3,4,5,6)
                MainActivity.fatty_array += listOf(1,2,3,4,5,6)
            }
        }


    }

     override fun onBackPressed()
    {
        if(isTaskRoot()){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        finish()
    }

}