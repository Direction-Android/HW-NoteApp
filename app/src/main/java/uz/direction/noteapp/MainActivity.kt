package uz.direction.noteapp

import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.direction.noteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val viewBinding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)
}
