package moe.wazul.fabsound

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import moe.wazul.fabcore.GridSpacingItemDecorator
import moe.wazul.fabsound.databinding.ActivityMainBinding
import moe.wazul.fabsound.soundButton.SoundButtonAdapter
import moe.wazul.fabsound.soundButton.SoundButtonData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var soundButtonAdapter: SoundButtonAdapter
    private var index : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        soundButtonAdapter = SoundButtonAdapter(mutableListOf<SoundButtonData>())
        binding.rvSoundButtons.addItemDecoration(GridSpacingItemDecorator(8f))
        binding.rvSoundButtons.adapter = soundButtonAdapter
        binding.rvSoundButtons.layoutManager = GridLayoutManager(this, 2)

        binding.btnAddSound.setOnClickListener {
            soundButtonAdapter.addSoundButton(SoundButtonData(index.toString()))
            index++
        }
    }
}