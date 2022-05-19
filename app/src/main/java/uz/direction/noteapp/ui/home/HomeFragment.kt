package uz.direction.noteapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.direction.noteapp.R
import uz.direction.noteapp.databinding.FragmentHomeBinding
import uz.direction.noteapp.model.Note

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding<FragmentHomeBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("MyLog", "onViewCreated:")
        val notes = arrayListOf(
            Note("title-1", "text-1iankjfgdsnkjnjkvfasfvahjvhjvdfhjvhjdsvahjafd"),
            Note(
                "title-2",
                "text-adfdsfsdff1adfadfasdasjbjkabkjfbjkadbfjkbajkdfbjksadbfjkbadsjkbfjskbdkjfbkjsdbjk"
            ),
            Note("title-3", "text-afdfsdafds1"),
            Note("title-3", "text-afdfsaffsdafdsfadsdafds1"),
            Note("title-3", "text-afdfsdafds1"),
            Note("title-3asdas", "text-afdfsdafds1"),
            Note("title-3asdas", "text-afdafsdfadsfadfsdafds1"),
            Note("title-3", "text-afdfsdafds1"),
            Note("title-3", "text-afdfsdafdsavdnkfankla1"),
            Note("title-3", "text-afdfsdafdsavdasdasnkfankla1"),
            Note("title-3", "text-afdfsdafdsavdnkfanklasadas1"),
            Note("title-3asd", "text-afdafadfdafdadfadfubhjbhcbhcbshjbhjbcsfsdafds1"),
            Note("title-4", "text-1asdjnsdjfnjfsafkjbajkdfbjksdbjkdajfadfadfadsfadfadsfadfasd")
        )

        binding.rvNote.apply {
            adapter = NoteAdapter(notes)
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_editNoteFragment)
        }
    }

}
