package uz.direction.noteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
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

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.noteText?.setOnClickListener(){
            val text = binding?.noteText?.text.toString()
            val header = binding?.noteHeader?.text.toString()
            passValue(text, header) }
    }

    private fun passValue(text : String, header : String){
        val bundle = Bundle()
        bundle.putString("text", text)
        bundle.putString("header", header)

        parentFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container_view,
                EditingFragment::class.java,
                bundle,
                "tag")
            .setReorderingAllowed(true)
            .commit()
    }
}

