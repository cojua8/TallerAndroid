package mi.primer.tallerandroid.personajes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mi.primer.tallerandroid.R
import mi.primer.tallerandroid.databinding.FragmentPersonajesBinding

/**
 * A simple [Fragment] subclass.
 */
class PersonajesFragment : Fragment() {

    private lateinit var viewModel: PersonajesViewModel

    private lateinit var binding: FragmentPersonajesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_personajes, container, false)

        viewModel = ViewModelProvider(this).get(PersonajesViewModel::class.java)

        binding.personajesViewModel = viewModel

        binding.lifecycleOwner = this

        return binding.root
    }

}
