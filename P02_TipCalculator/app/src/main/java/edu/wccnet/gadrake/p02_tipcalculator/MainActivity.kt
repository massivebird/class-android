package edu.wccnet.gadrake.p02_tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.isDigitsOnly
import edu.wccnet.gadrake.p02_tipcalculator.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            // TODO: exclude decimal points only and/or n > 1 decimals too ??
            if (binding.billInput.text == null) {
                binding.outputView.text = "Please enter a nonzero bill amount."
            }
            else {
                val BILL_INPUT: Double = binding.billInput.text.toString().toDouble()
//            binding.outputView.text = "The tips are as follows:\n" +
                binding.outputView.text = "The tips are as follows:\n" +
                "\n10% = $" + printTotalPlusTipPercentage(BILL_INPUT, 10.0) +
                "\n15% = $" + printTotalPlusTipPercentage(BILL_INPUT, 15.0) +
                "\n20% = $" + printTotalPlusTipPercentage(BILL_INPUT, 20.0)
            }
        }
    }
}

fun printTotalPlusTipPercentage(total: Double, percent: Double): String {
    return "%.02f".format(total + (total * percent / 100))
}