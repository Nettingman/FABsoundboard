package moe.wazul.fabsound.soundButton

import moe.wazul.fabsound.R

enum class SoundButtonColor {
    RED,
    PURPLE,
    BLUE,
    GREEN,
    YELLOW;

    companion object {
        fun getSoundButtonColorResource(soundButtonColor: SoundButtonColor): Int {
            return when (soundButtonColor) {
                SoundButtonColor.RED -> R.color.flu_red
                SoundButtonColor.BLUE -> R.color.flu_blue
                SoundButtonColor.PURPLE -> R.color.flu_purple
                SoundButtonColor.GREEN -> R.color.flu_green
                SoundButtonColor.YELLOW -> R.color.flu_yellow
            }
        }
    }
}

data class SoundButtonData(
    var name : String,
    var soundButtonColor: SoundButtonColor,
    )