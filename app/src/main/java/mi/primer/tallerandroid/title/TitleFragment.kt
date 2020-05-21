package mi.primer.tallerandroid.title

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import mi.primer.tallerandroid.R
import mi.primer.tallerandroid.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    private lateinit var viewModel: TitleViewModel

    private lateinit var binding: FragmentTitleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        viewModel = ViewModelProvider(this).get(TitleViewModel::class.java)

        viewModel.navigate.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                when (it) {
                    R.id.naves_button -> findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToNavesFragment())
                    R.id.personajes_button -> findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToPersonajesFragment())
                    R.id.planetas_button -> findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToPlanetasFragment())
                }
                viewModel.navigatedToFragment()
            }
        })

        binding.titleViewModel = viewModel

        binding.lifecycleOwner = this

        return binding.root
    }
}
