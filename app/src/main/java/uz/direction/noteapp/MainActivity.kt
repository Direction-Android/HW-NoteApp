package uz.direction.noteapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.direction.noteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
