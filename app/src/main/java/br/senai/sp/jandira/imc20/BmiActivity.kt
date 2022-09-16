package br.senai.sp.jandira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import br.senai.sp.jandira.imc20.databinding.ActivityBmiBinding
import br.senai.sp.jandira.imc20.databinding.ActivityMainBinding
import br.senai.sp.jandira.imc20.model.User

class BmiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadProfile()
        binding.buttonCalculate.setOnClickListener{
            bmiCalculate()
        }
    }

    private fun bmiCalculate() {
        val openResult = Intent(this, ResultBmiActivity::class.java)


            openResult.putExtra("Weight", binding.editWeight.text.toString().toInt())

        if (binding.editHeight.text.isEmpty()){
            openResult.putExtra("height", 0.0)
        }
        else{
            //enviar resultados de uma activity para outra
            openResult.putExtra("height", binding.editHeight.text.toString().toFloat())
        }
        startActivity(openResult)
    }


    private fun loadProfile() {
        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        binding.textViewUsername.text = dados.getString("name", "")
        binding.textViewHigh.text = "Height: ${dados.getFloat("height", 0.0F)}"
        binding.textViewWeight.text = "Weight: ${dados.getInt("Weight", 0)}"
        binding.textViewEmail.text = dados.getString("email", "")

    }
}