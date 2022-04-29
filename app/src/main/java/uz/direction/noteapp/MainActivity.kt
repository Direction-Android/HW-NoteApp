package uz.direction.noteapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.direction.noteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        const val MAIN_HEADER_MESSAGE = "header"
        const val MAIN_TEXT_MESSAGE = "text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val sharedPref = getSharedPreferences(getString(R.string.shared_preference_key),
            Context.MODE_PRIVATE)

        setContentView(binding.root)

        binding.headerTitle.setText(sharedPref.getString(getString(R.string.header_key), ""))
        binding.textValue.setText(sharedPref.getString(getString(R.string.text_key), ""))

        binding.saveButton.setOnClickListener{
            val intent = Intent(this, ShowNote::class.java)
            val header = binding.headerTitle.text.toString()
            val text = binding.textValue.text.toString()

            if ((header == "") || (text == "")){
                Toast.makeText(baseContext, "Header or text missing", Toast.LENGTH_SHORT).show()
            } else{
                with(sharedPref.edit()){
                    putString(getString(R.string.header_key), header)
                    putString(getString(R.string.text_key), text)
                    apply()
                }

                intent.putExtra(MAIN_HEADER_MESSAGE, header)
                intent.putExtra(MAIN_TEXT_MESSAGE, text)
                startActivity(intent)
            }
        }
    }
}