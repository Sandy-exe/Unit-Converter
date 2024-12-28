package com.example.first_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//        val edt: EditText = findViewById(R.id.kilo_edt)
//        val btn: Button = findViewById(R.id.btn)
//        val resultText : TextView = findViewById(R.id.result_text)
//
//        btn.setOnClickListener(){
//
//            val kilos = edt.text.toString().toDouble()
//
//            resultText.setText(""+convertToPounds(kilos))
//
//
//
//
//
//        }
//
//
//    }
//
//    fun convertToPounds(kilos: Double):Double{
//        var pounds = kilos*2.20462
//        return pounds
//    }
//}


import LanguageManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.rajkishorbgp.unitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var languageManager: LanguageManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = "Unit Converter"
        binding.toolbar.subtitle = "Home"
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        languageManager = LanguageManager(this)

        binding.areaCardView.setOnClickListener {
            val intent = Intent(this, AreaActivity::class.java)
            startActivity(intent)
        }

        binding.speedCardView.setOnClickListener {
            startActivity(Intent(this, SpeedActivity::class.java))
        }
        binding.lengthCardView.setOnClickListener {
            startActivity(Intent(this, LengthActivity::class.java))
        }
        binding.temperatureCardView.setOnClickListener {
            startActivity(Intent(this, TemperatureActivity::class.java))
        }
        binding.frequencyCardView.setOnClickListener {
            startActivity(Intent(this, FrequencyActivity::class.java))
        }
        binding.massCardView.setOnClickListener {
            startActivity(Intent(this, MassActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.setting) {
            startActivity(Intent(this@MainActivity, SettingActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
