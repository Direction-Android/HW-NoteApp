package uz.direction.noteapp

import android.content.Context
import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import uz.direction.noteapp.databinding.FragmentNoteBinding

class NoteFragment : Fragment() {
    private var binding : FragmentNoteBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFragmentResultListener("requestKey"){ requestKey, bundle ->
            binding?.noteHeader?.text = bundle.getString("header")
            binding?.noteText?.text = bundle.getString("text")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNoteBinding.inflate(layoutInflater)

        val shPref = activity?.getSharedPreferences(getString(R.string.sh_pref_key),
            Context.MODE_PRIVATE) ?: return binding!!.root
        binding?.noteHeader?.text = shPref.getString(getString(R.string.header), "Empty Note")
        binding?.noteText?.text = shPref.getString(getString(R.string.text), "Empty Text")

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.noteText?.setOnClickListener(){
            val text = view.findViewById<TextView>(R.id.note_text).text.toString()
            val header = view.findViewById<TextView>(R.id.note_header).text.toString()
            passValue(text, header) }

        binding?.noteHeader?.setOnClickListener(){
            val text = view.findViewById<TextView>(R.id.note_text).text.toString()
            val header = view.findViewById<TextView>(R.id.note_header).text.toString()
            passValue(text, header) }
    }

    private fun passValue(text : String, header : String){
        // Navigation used
        val action = NoteFragmentDirections.actionNoteFragmentToEditingFragment()
            .setNoteHeader(header)
            .setNoteText(text)
        findNavController().navigate(action)
    }
}

