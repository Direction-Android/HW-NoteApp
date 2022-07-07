package uz.direction.noteapp.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import uz.direction.noteapp.R
import uz.direction.noteapp.databinding.MainFragmentBinding
import uz.direction.noteapp.databinding.UpdateFragmentBinding
import uz.direction.noteapp.viewModel.NoteViewModel

class NoteListFragment : Fragment(R.layout.main_fragment) {

    private var _binding: MainFragmentBinding? = null
    private val binding: MainFragmentBinding get() = _binding!!

    private lateinit var noteViewModel: NoteViewModel
    private val myAdapter by lazy { NoteAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = MainFragmentBinding.inflate(layoutInflater)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val addBtn = binding.button


        addBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_noteFragment)
        }
        setupRecyclerView()
       setHasOptionsMenu(true)

        noteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]
        noteViewModel.readAllData.observe(viewLifecycleOwner) { note ->
            myAdapter.setData(note)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

            Log.d("TAG", "onOptionsItemSelected: sdasdada")
            deleteAllUsers()

        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllUsers(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            noteViewModel.deleteAllUsers()
            Toast.makeText(
                requireContext(),
                "Successfully removed everything",
                Toast.LENGTH_SHORT).show() }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete everything?")
        builder.setMessage("Are you sure you want to delete every note?")
        builder.create().show()
    }
    private fun setupRecyclerView() {
        binding.rvNotes.apply {
            layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = myAdapter
        }
    }
}
