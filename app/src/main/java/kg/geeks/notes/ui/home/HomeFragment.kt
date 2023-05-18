package kg.geeks.notes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import kg.geeks.notes.data.model.Notes
import kg.geeks.notes.R
import kg.geeks.notes.databinding.FragmentHomeBinding
import kg.geeks.notes.ui.home.adapter_rv.NotesAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val arrayList= ArrayList<Notes>()
    private lateinit var homeAdapter: NotesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        onFabClick()
        getDataVisible()

    }

    private fun getDataVisible() {
        setFragmentResultListener(NotesFragment.REQUEST_RESULT){_, bundle ->
            val data = bundle.getSerializable(NotesFragment.REQUEST_KEY) as Notes
            arrayList.add(data)
            homeAdapter.notifyDataSetChanged()

        }
    }

    private fun initRecycler() {
        homeAdapter = NotesAdapter(arrayList/*, this::onFabClick*/)
        binding.recyclerViewHome.adapter = homeAdapter
    }

    private fun onFabClick() {
        binding.fab.setOnClickListener{
            findNavController().navigate(R.id.notesFragment)
        }
    }
}