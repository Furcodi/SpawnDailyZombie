package com.example.dailyspawn

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Html.fromHtml
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import java.lang.Integer.parseInt
import java.lang.reflect.Array.getInt
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        var startUp = true
        var wahrWalker = 0
        var wahrRunner = 0
        var wahrFatty = 0
        var cbOneTime = true
        val walker_array = mutableListOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19)
        val runner_array = mutableListOf(1,2,3,4,5,6)
        val fatty_array = mutableListOf(1,2,3,4,5,6)
        var aktpic = R.drawable.w_cheerleader
        var akttext: String? = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        if (startUp) {
            val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
            wahrWalker = sharedPref.getInt("wahrWalker_SharedPref", 50)
            wahrRunner = sharedPref.getInt("wahrRunner_SharedPref", 50)
            wahrFatty = sharedPref.getInt("wahrFatty_SharedPref", 50)
            cbOneTime = sharedPref.getBoolean("cbOneTime_SharedPref", true)
            aktpic = sharedPref.getInt("aktpic_SharedPref", R.drawable.w_cheerleader)
            akttext = sharedPref.getString("akttext_SharedPref", getString(R.string.text_w_cheerleader)).toString()

            startUp = false
        }

        val imageView1 = findViewById<ImageView>(R.id.imageView)
        imageView1.setImageResource(aktpic)

        val rules = findViewById<TextView>(R.id.textView)
        rules.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(akttext, Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(akttext)
        }

        val buttonWalkerSpawn = findViewById<View>(R.id.button_walker)
        buttonWalkerSpawn.setOnClickListener {
            run {
                Log.d("Wahrschein", "wahrWalker")
                akttext = ""
                val wahrschein = (1..100).random()
                if (wahrschein <= wahrWalker) {
                    //val rnds = (1..19).random()
                    if (walker_array.size < 1) {
                        walker_array += listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19)
                    }
                    val rnds = walker_array.random()
                    if (cbOneTime) {walker_array.remove(rnds)}
                    Log.d("walker_array", walker_array.toString())
                    when (rnds) {
                        1 -> {
                            aktpic = R.drawable.w_ballerina
                            akttext = getString(R.string.text_w_ballerina)
                        }
                        2 -> {
                            aktpic = R.drawable.w_bride
                            akttext = getString(R.string.text_w_bride)
                        }
                        3 -> {
                            aktpic = R.drawable.w_butler
                            akttext = getString(R.string.text_w_butler)
                        }
                        4 -> {
                            aktpic = R.drawable.w_cat_lady
                            akttext = getString(R.string.text_w_cat_lady)
                        }
                        5 -> {
                            aktpic = R.drawable.w_cheerleader
                            akttext = getString(R.string.text_w_cheerleader)
                        }
                        6 -> {
                            aktpic = R.drawable.w_coffin_joe
                            akttext = getString(R.string.text_w_coffin_joe)
                        }
                        7 -> {
                            aktpic = R.drawable.w_executive
                            akttext = getString(R.string.text_w_executive)
                        }
                        8 -> {
                            aktpic = R.drawable.w_flight_attendant
                            akttext = getString(R.string.text_w_flight_attendant)
                        }
                        9 -> {
                            aktpic = R.drawable.w_judge
                            akttext = getString(R.string.text_w_judge)
                        }
                        10 -> {
                            aktpic = R.drawable.w_lawnmower_man
                            akttext = getString(R.string.text_w_lawnmower_man)
                        }
                        11 -> {
                            aktpic = R.drawable.w_lion_dancer
                            akttext = getString(R.string.text_w_lion_dancer)
                        }
                        12 -> {
                            aktpic = R.drawable.w_lunch_lady
                            akttext = getString(R.string.text_w_lunch_lady)
                        }
                        13 -> {
                            aktpic = R.drawable.w_magician
                            akttext = getString(R.string.text_w_magician)
                        }
                        14 -> {
                            aktpic = R.drawable.w_nun
                            akttext = getString(R.string.text_w_nun)
                        }
                        15 -> {
                            aktpic = R.drawable.w_one_man_band
                            akttext = getString(R.string.text_w_one_man_band)
                        }
                        16 -> {
                            aktpic = R.drawable.w_postman
                            akttext = getString(R.string.text_w_postman)
                        }
                        17 -> {
                            aktpic = R.drawable.w_ren_faire_man
                            akttext = getString(R.string.text_w_ren_faire_man)
                        }
                        18 -> {
                            aktpic = R.drawable.w_swimmer
                            akttext = getString(R.string.text_w_swimmer)
                        }
                        19 -> {
                            aktpic = R.drawable.w_waitress
                            akttext = getString(R.string.text_w_waitress)
                        }
                    }
                } else {
                    aktpic = R.drawable.no_daily
                }
                val animation = AnimationUtils.loadAnimation(this, R.anim.scale_up)
                imageView1.startAnimation(animation)
                imageView1.setImageResource(aktpic)
                rules.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Html.fromHtml(akttext, Html.FROM_HTML_MODE_COMPACT)
                } else {
                    Html.fromHtml(akttext)
                }
            }

        }

        val buttonRunnerSpawn = findViewById<View>(R.id.button_runner)
        buttonRunnerSpawn.setOnClickListener {
            run {
                akttext = ""
                val wahrschein = (1..100).random()
                if (wahrschein <= wahrRunner) {
                    //val rnds = (1..6).random()
                    if (runner_array.size < 1) {
                        runner_array += listOf(1,2,3,4,5,6)
                    }
                    val rnds = runner_array.random()
                    if (cbOneTime) {runner_array.remove(rnds)}
                    Log.d("runner_array", runner_array.toString())
                    when (rnds) {
                        1 -> {
                            aktpic = R.drawable.r_bullfighter
                            akttext = getString(R.string.text_r_bullfighter)
                        }
                        2 -> {
                            aktpic = R.drawable.r_olympic_runner
                            akttext = getString(R.string.text_r_olympic_runner)
                        }
                        3 -> {
                            aktpic = R.drawable.r_pizza_boy
                            akttext = getString(R.string.text_r_pizza_boy)
                        }
                        4 -> {
                            aktpic = R.drawable.r_quarterback
                            akttext = getString(R.string.text_r_quarterback)
                        }
                        5 -> {
                            aktpic = R.drawable.r_robber
                            akttext = getString(R.string.text_r_robber)
                        }
                        6 -> {
                            aktpic = R.drawable.r_skateboarder
                            akttext = getString(R.string.text_r_skateboarder)
                        }
                    }
                } else {
                    aktpic = R.drawable.no_daily
                }
                val animation = AnimationUtils.loadAnimation(this, R.anim.scale_up)
                imageView1.startAnimation(animation)
                imageView1.setImageResource(aktpic)
                rules.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Html.fromHtml(akttext, Html.FROM_HTML_MODE_COMPACT)
                } else {
                    Html.fromHtml(akttext)
                }
            }
        }

        val buttonFattySpawn = findViewById<View>(R.id.button_fatty)
        buttonFattySpawn.setOnClickListener {
            run {
                akttext = ""
                val wahrschein = (1..100).random()
                if (wahrschein <= wahrFatty) {
                    //val rnds = (1..6).random()
                    if (fatty_array.size < 1) {
                        fatty_array += listOf(1,2,3,4,5,6)
                    }
                    val rnds = fatty_array.random()
                    if (cbOneTime) {fatty_array.remove(rnds)}
                    Log.d("fatty_array", fatty_array.toString())
                    when (rnds) {
                        1 -> {
                            aktpic = R.drawable.f_goth_chick
                            akttext = getString(R.string.text_f_goth_chick)
                        }
                        2 -> {
                            aktpic = R.drawable.f_luchador
                            akttext = getString(R.string.text_f_luchador)
                        }
                        3 -> {
                            aktpic = R.drawable.f_sports_fan
                            akttext = getString(R.string.text_f_sports_fan)
                        }
                        4 -> {
                            aktpic = R.drawable.f_sumo_wrestler
                            akttext = getString(R.string.text_f_sumo_wrestler)
                        }
                        5 -> {
                            aktpic = R.drawable.f_unicorn_girl
                            akttext = getString(R.string.text_f_unicorn_girl)
                        }
                        6 -> {
                            aktpic = R.drawable.f_welder
                            akttext = getString(R.string.text_f_welder)
                        }
                    }
                } else {
                    aktpic = R.drawable.no_daily
                }
                val animation = AnimationUtils.loadAnimation(this, R.anim.scale_up)
                imageView1.startAnimation(animation)
                imageView1.setImageResource(aktpic)
                rules.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Html.fromHtml(akttext, Html.FROM_HTML_MODE_COMPACT)
                } else {
                    Html.fromHtml(akttext)
                }
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                //finish()
                return true
        }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onStop() {
        super.onStop()
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putInt("wahrWalker_SharedPref", wahrWalker)
            putInt("wahrRunner_SharedPref", wahrRunner)
            putInt("wahrFatty_SharedPref", wahrFatty)
            putBoolean("cbOneTime_SharedPref", cbOneTime)
            putInt("aktpic_SharedPref", aktpic)
            putString("akttext_SharedPref", akttext)

            commit()
        }
    }
}