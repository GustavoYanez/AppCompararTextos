package com.example.appcomparaciontextos
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//import com.example.appcomparaciontextos.Comparar

class MainViewModel:ViewModel () {
    val comparar: LiveData<Comparar> get() = _comparar
    private var _comparar = MutableLiveData(Comparar("Ingrese primer texto","Ingrese segundo texto"))

    fun cargaDatos(texto1c:String,texto2c:String){
        //viewModelScope.launch {
            _comparar.value = Comparar(texto1c, texto2c)
        //}
    }
}