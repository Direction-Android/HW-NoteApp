package uz.direction.noteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.setFragmentResult

class EditingFragment : Fragment(R.layout.fragment_editing) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val editText = view.findViewById<EditText>(R.id.edit_note_text)
        val editHeader = view.findViewById<EditText>(R.id.edit_note_header)
        editText.setText(requireArguments().get("text").toString())
        editHeader.setText(requireArguments().get("header").toString())

        view.findViewById<ImageButton>(R.id.save_button).setOnClickListener(){
            val bundle : Bundle = Bundle()
            bundle.putString("header", editHeader.text.toString())
            bundle.putString("text", editText.text.toString())

            setFragmentResult("requestKey", bundle)

            passValue(bundle)
        }
    }

    private fun passValue(bundle : Bundle){

        parentFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container_view,
                NoteFragment::class.java,
                bundle,
                "tag")
            .setReorderingAllowed(true)
            .commit()
    }

}