package com.example.appcomparaciontextos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.appcomparaciontextos.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mainViewModel.comparar.observe(this) {
            if (it.texto1 == it.texto2) {
                binding.txtComparacion.text = "Son iguales"
            } else {
                binding.txtComparacion.text = "Son diferentes"
            }
        }
        binding.btnComparacion.setOnClickListener {
            val texto1b = binding.edtTexto1.text.toString()
            val texto2b = binding.edtTexto2.text.toString()

            mainViewModel.cargaDatos(texto1b,texto2b)
        }
    }
}
