package br.senai.sp.jandira.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import br.senai.sp.jandira.imc20.databinding.ActivityBmiBinding
import br.senai.sp.jandira.imc20.databinding.ActivityResultBmiBinding
import br.senai.sp.jandira.imc20.utils.getBmi

class ResultBmiActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBmiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        binding = ActivityResultBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //recuperar valores que estão na intent
        val weight = intent.getIntExtra("Weight", 0)
        val height =   intent.getFloatExtra("height", 0.0f)

        val resultBmiCalculate = getBmi(weight, height.toDouble()).toString().toFloat()
        val BmiResult = String.format("%.2f", resultBmiCalculate)

        binding.textViewResult.text = "$BmiResult"
    }
}