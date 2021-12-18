package xyz.ironwill.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a die and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Do a die roll when the app starts
        rollDice()
    }

    /**
     * Roll the die and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val die = Dice(6)
        val dieRoll = die.roll()

        val die2 = Dice(6)
        val dieRoll2 = die2.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.die1)
        val diceImage2: ImageView = findViewById(R.id.die2)

        // Determine which drawable resource ID to use based on die roll
        val drawableResource = when (dieRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (dieRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)

        // Update the content description
        diceImage.contentDescription = dieRoll.toString()
        diceImage2.contentDescription = dieRoll2.toString()
    }
}

/**
 * Dice class to create a randomly rolled value
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}