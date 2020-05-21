package mi.primer.tallerandroid.title

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TitleViewModel : ViewModel() {

    //    livedata de navegacion
    private val _navigate = MutableLiveData<Int>()

    val navigate: LiveData<Int>
        get() = _navigate

    fun navigateToFragment(dst: View) {
        _navigate.value = dst.id
    }

    fun navigatedToFragment() {
        _navigate.value = null
    }
}
