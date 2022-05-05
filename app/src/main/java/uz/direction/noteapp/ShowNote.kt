package uz.direction.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.direction.noteapp.databinding.ActivityMainBinding
import uz.direction.noteapp.databinding.ActivityShowNoteBinding

class ShowNote : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityShowNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
//
//        binding.headerTitleNote.text = intent.getStringExtra(MainActivity.MAIN_HEADER_MESSAGE)
//        binding.text.text = intent.getStringExtra(MainActivity.MAIN_TEXT_MESSAGE)
    }
}