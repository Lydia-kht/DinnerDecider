package com.example.dinnerdecider

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.Color.BLACK
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.dinnerdecider.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var savedChoice: SharedPreferences
    lateinit var edittor: SharedPreferences.Editor

    var choice: Int =0;
    lateinit var food: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        savedChoice = applicationContext.getSharedPreferences("lastchoice", Context.MODE_PRIVATE)


        binding.button.setOnClickListener {
            choice = Random.nextInt(0, 5)
            when (choice) {
                0 -> {
                    food = "Chips"
                    binding.backgroud.setBackgroundColor(Color.BLUE)
                    binding.backgroud.setBackgroundResource(R.drawable.chips)
                }
                1 -> {
                    food = "Rice"
                    binding.backgroud.setBackgroundColor(Color.GREEN)
                    binding.backgroud.setBackgroundResource(R.drawable.rice)
                }
                2 -> {
                    food = "Ugali"
                    binding.backgroud.setBackgroundColor(Color.RED)
                    binding.backgroud.setBackgroundResource(R.drawable.ugali)
                }

                3 -> {
                    food = "Matoke"
                    binding.backgroud.setBackgroundColor(Color.RED)
                    binding.backgroud.setBackgroundResource(R.drawable.matoke)
        }

                4 -> {
             food = "Chapati"
            binding.backgroud.setBackgroundColor(Color.MAGENTA)
           binding.backgroud.setBackgroundResource(R.drawable.chapati)
        }
                5 -> {
            food = "Pilau"
                    binding.backgroud.setBackgroundColor(Color.LTGRAY)
                    binding.backgroud.setBackgroundResource(R.drawable.pilau)
        }
                else -> food = "We could not decide"

            }
            binding.textView.text = food
        }


    }

    override fun onStop() {
        super.onStop()
        onSave()
    }

    override fun onStart() {
        super.onStart()
        onRetrieve()
    }


    fun onSave(){
        edittor = savedChoice.edit()
        edittor.putInt("lastchoice",choice)
        edittor.commit()
    }

    fun onRetrieve(){
        var retrievedChoice = savedChoice.getInt("lastchoice", 0)

        when (retrievedChoice) {
            0 -> {
                food = "Chips"
                binding.backgroud.setBackgroundColor(Color.BLUE)
                binding.backgroud.setBackgroundResource(R.drawable.chips)
            }
            1 -> {
                food = "Rice"
                binding.backgroud.setBackgroundColor(Color.GREEN)
                binding.backgroud.setBackgroundResource(R.drawable.rice)
            }
            2 -> {
                food = "Ugali"
                binding.backgroud.setBackgroundColor(Color.RED)
                binding.backgroud.setBackgroundResource(R.drawable.ugali)
            }

            3 -> {
                food = "Matoke"
                binding.backgroud.setBackgroundColor(Color.RED)
                binding.backgroud.setBackgroundResource(R.drawable.matoke)
            }

            4 -> {
                food = "Chapati"
                binding.backgroud.setBackgroundColor(Color.MAGENTA)
                binding.backgroud.setBackgroundResource(R.drawable.chapati)
            }
            5 -> {
                food = "Pilau"
                binding.backgroud.setBackgroundColor(Color.LTGRAY)
                binding.backgroud.setBackgroundResource(R.drawable.pilau)
            }
            else -> food = "We could not decide"

        }
        binding.textView.text = food
    }

}