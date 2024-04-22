package com.example.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmi_calculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()
{

    private  lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.weightPicker.minValue = 30
        binding.weightPicker.maxValue = 150

        binding.heightPicker.minValue = 100
        binding.heightPicker.maxValue = 250

        binding.weightPicker.setOnValueChangedListener{ _,_,_ ->
        calculateBMI()
        }

        binding.heightPicker.setOnValueChangedListener{_,_,_ ->
            calculateBMI()
        }

    }
    private fun  calculateBMI(){
        val height=binding.heightPicker.value
        val doubleHeight=height.toDouble()/100

        val weight=binding.weightPicker.value

        val bmi=weight.toDouble()/(doubleHeight*doubleHeight)

binding.resultsTv.text=String.format("YOUR BMI IS: %.2f",bmi)
        binding.healthyTv.text=String.format("Considered: %s",healthyMessage(bmi))
    }

    private fun healthyMessage(bmi:Double):String{
        if(bmi<18.5)
            return "UnderWeight"
        if(bmi<25.0)
            return "Healthy"
        if(bmi<30.0)
            return "OverWeight"


        return "Obese"
    }
}