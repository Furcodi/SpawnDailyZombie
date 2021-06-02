package com.example.dailyspawn

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toolbar

class MainActivity : AppCompatActivity() {

    companion object {
        var startUp = true
        var wahrWalker = 0
        var wahrRunner = 0
        var wahrFatty = 0
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

            startUp = false
        }


        val buttonWalkerSpawn = findViewById<View>(R.id.button_walker)
        buttonWalkerSpawn.setOnClickListener {
            run {
                Log.d("Wahrschein", "wahrWalker")
                val imageView1 = findViewById<ImageView>(R.id.imageView)
                val wahrschein = (1..100).random()
                if (wahrschein < wahrWalker) {
                    val rnds = (1..19).random()
                    when (rnds) {
                        1 -> {
                            imageView1.setImageResource(R.drawable.w_ballerina)
                        }
                        2 -> {
                            imageView1.setImageResource(R.drawable.w_bride)
                        }
                        3 -> {
                            imageView1.setImageResource(R.drawable.w_butler)
                        }
                        4 -> {
                            imageView1.setImageResource(R.drawable.w_cat_lady)
                        }
                        5 -> {
                            imageView1.setImageResource(R.drawable.w_cheerleader)
                        }
                        6 -> {
                            imageView1.setImageResource(R.drawable.w_coffin_joe)
                        }
                        7 -> {
                            imageView1.setImageResource(R.drawable.w_executive)
                        }
                        8 -> {
                            imageView1.setImageResource(R.drawable.w_flight_attendant)
                        }
                        9 -> {
                            imageView1.setImageResource(R.drawable.w_judge)
                        }
                        10 -> {
                            imageView1.setImageResource(R.drawable.w_lawnmower_man)
                        }
                        11 -> {
                            imageView1.setImageResource(R.drawable.w_lion_dancer)
                        }
                        12 -> {
                            imageView1.setImageResource(R.drawable.w_lunch_lady)
                        }
                        13 -> {
                            imageView1.setImageResource(R.drawable.w_magician)
                        }
                        14 -> {
                            imageView1.setImageResource(R.drawable.w_nun)
                        }
                        15 -> {
                            imageView1.setImageResource(R.drawable.w_one_man_band)
                        }
                        16 -> {
                            imageView1.setImageResource(R.drawable.w_postman)
                        }
                        17 -> {
                            imageView1.setImageResource(R.drawable.w_ren_faire_man)
                        }
                        18 -> {
                            imageView1.setImageResource(R.drawable.w_swimmer)
                        }
                        19 -> {
                            imageView1.setImageResource(R.drawable.w_waitress)
                        }
                    }
                } else {
                    imageView1.setImageResource(R.drawable.no_daily)
                }
                Log.d("Tsg", "walker")
            }

        }

        val buttonRunnerSpawn = findViewById<View>(R.id.button_runner)
        buttonRunnerSpawn.setOnClickListener {
            run {
                val imageView1 = findViewById<ImageView>(R.id.imageView)
                val wahrschein = (1..100).random()
                if (wahrschein < wahrRunner) {
                    val rnds = (1..6).random()
                    when (rnds) {
                        1 -> {
                            imageView1.setImageResource(R.drawable.r_bullfighter)
                        }
                        2 -> {
                            imageView1.setImageResource(R.drawable.r_olympic_runner)
                        }
                        3 -> {
                            imageView1.setImageResource(R.drawable.r_pizza_boy)
                        }
                        4 -> {
                            imageView1.setImageResource(R.drawable.r_quarterback)
                        }
                        5 -> {
                            imageView1.setImageResource(R.drawable.r_robber)
                        }
                        6 -> {
                            imageView1.setImageResource(R.drawable.r_skateboarder)
                        }
                    }
                } else {
                    imageView1.setImageResource(R.drawable.no_daily)
                }
            }
        }

        val buttonFattySpawn = findViewById<View>(R.id.button_fatty)
        buttonFattySpawn.setOnClickListener {
            run {
                val imageView1 = findViewById<ImageView>(R.id.imageView)
                val wahrschein = (1..100).random()
                if (wahrschein < wahrFatty) {
                    val rnds = (1..6).random()
                    when (rnds) {
                        1 -> {
                            imageView1.setImageResource(R.drawable.f_goth_chick)
                        }
                        2 -> {
                            imageView1.setImageResource(R.drawable.f_luchador)
                        }
                        3 -> {
                            imageView1.setImageResource(R.drawable.f_sports_fan)
                        }
                        4 -> {
                            imageView1.setImageResource(R.drawable.f_sumo_wrestler)
                        }
                        5 -> {
                            imageView1.setImageResource(R.drawable.f_unicorn_girl)
                        }
                        6 -> {
                            imageView1.setImageResource(R.drawable.f_welder)
                        }
                    }
                } else {
                    imageView1.setImageResource(R.drawable.no_daily)
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

            commit()
        }
    }

}