package uz.direction.noteapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import uz.direction.noteapp.databinding.FragmentEditingBinding

class EditingFragment : Fragment(R.layout.fragment_editing) {
    private val args: EditingFragmentArgs by navArgs<EditingFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val editText = view.findViewById<EditText>(R.id.edit_note_text)
        val editHeader = view.findViewById<EditText>(R.id.edit_note_header)
        editText.setText(args.noteText)
        editHeader.setText(args.noteHeader)

        view.findViewById<ImageButton>(R.id.save_button).setOnClickListener(){
            val bundle : Bundle = Bundle()
            bundle.putString("header", editHeader.text.toString())
            bundle.putString("text", editText.text.toString())

            val shPref = activity?.getSharedPreferences("pref", Context.MODE_PRIVATE) ?: return@setOnClickListener
            with(shPref.edit()) {
                putString(getString(R.string.header), editHeader.text.toString())
                putString(getString(R.string.text), editText.text.toString())
                apply()
            }

            setFragmentResult("requestKey", bundle)
            findNavController().navigateUp()
        }
    }
}