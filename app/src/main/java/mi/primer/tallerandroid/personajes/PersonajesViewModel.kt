package mi.primer.tallerandroid.personajes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import mi.primer.tallerandroid.swapi.Swapi

class PersonajesViewModel : ViewModel() {

    //    livedata para guardar el resultado de la llamada a la api
    private val _properties = MutableLiveData<String>()

    val properties: LiveData<String>
        get() = _properties

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        obtenerPersonajes()
    }

    private fun obtenerPersonajes() {
        coroutineScope.launch {
            val getPersonajesDeferred = Swapi.retrofitService.getPeople()
            try {
                val result = getPersonajesDeferred.await()

                _properties.value = result
            } catch (e: Exception) {
                _properties.value = "Error en la obtencion de datos"
            }

        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}