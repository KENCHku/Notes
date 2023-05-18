package kg.geeks.notes.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kg.geeks.notes.data.model.Notes
import kg.geeks.notes.R
import kg.geeks.notes.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

    private lateinit var binding: FragmentNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnSave.setOnClickListener {
                val result = Notes(etTitle.text.toString(), etSubtitle.text.toString())
                setFragmentResult(REQUEST_RESULT, bundleOf(REQUEST_KEY to result))

                findNavController().navigateUp()
            }
        }
    }

    companion object{
        val REQUEST_RESULT = "request_result.notes"
        val REQUEST_KEY = "request_key.notes"
    }
}