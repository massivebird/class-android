package edu.wccnet.gadrake.p02_tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.wccnet.gadrake.p02_tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            // textview [numeric] input type guarantees non-empty input is numerically valid
            val userInputtedBill: Double? = binding.billInput.text.toString().toDoubleOrNull()
            if (userInputtedBill == null || userInputtedBill == 0.0) {
                binding.outputView.text = getString(R.string.illegal_input_response)
            }
            else {
                val output = "The tips are as follows:\n" +
                        "\n10% = $" + printTotalPlusTipPercentage(userInputtedBill, 10.0) +
                        "\n15% = $" + printTotalPlusTipPercentage(userInputtedBill, 15.0) +
                        "\n20% = $" + printTotalPlusTipPercentage(userInputtedBill, 20.0)
                binding.outputView.text = output
            }
        }
    }
}

fun printTotalPlusTipPercentage(total: Double, percent: Double): String {
    return "%.02f".format(total + (total * percent / 100))
}