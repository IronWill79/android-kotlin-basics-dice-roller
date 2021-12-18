package xyz.ironwill.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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
    }

    /**
     * Roll the die and update the screen with the result.
     */
    private fun rollDice() {
        // Create two new Dice objects with 6 sides and roll them
        val die1 = Dice(6)
        val die2 = Dice(6)
        val diceRoll1 = die1.roll()
        val diceRoll2 = die2.roll()

        // Update the screen with the die rolls
        val die1Result: TextView = findViewById(R.id.die_1)
        die1Result.text = diceRoll1.toString()
        val die2Result: TextView = findViewById(R.id.die_2)
        die2Result.text = diceRoll2.toString()
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