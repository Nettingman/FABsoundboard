package moe.wazul.fabsound.soundButton

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import moe.wazul.fabsound.R
import moe.wazul.fabsound.databinding.SoundButtonBinding

class SoundButtonAdapter(private val soundButtonDatas: MutableList<SoundButtonData>) : RecyclerView.Adapter<SoundButtonAdapter.SoundButtonViewHolder>()
{
    class SoundButtonViewHolder(val binding : SoundButtonBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SoundButtonViewHolder (
        SoundButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: SoundButtonViewHolder, position: Int) {
        val soundButtonData = soundButtonDatas[position]
        holder.binding.apply {
            btnSound.text = soundButtonData.name
        }
    }

    override fun getItemCount(): Int {
        return soundButtonDatas.size
    }

    fun addSoundButton(soundButtonData: SoundButtonData)
    {
        soundButtonDatas.add(soundButtonData)
        notifyItemInserted(soundButtonDatas.size - 1)
    }
}