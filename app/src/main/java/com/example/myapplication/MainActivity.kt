package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import java.util.*

//1. Napisz program, który będzie miał dwa tryby; dodwanie do listy zakupów oraz odhaczania zakupów (przełącznik Radiobutton)
//2. Po wybraniu dodwania widoczne stają się Checkbox'y z 10 dowolnymi zakupami (w 3 grupach np.; warzywa wędliny, pieczywo)
//3. Po wybraniu odhaczenia widoczne stają się wyłącznie Chip'y zaznaczone podczas "dodwania" (2)
//4. Checkbox'y powinny być w 3 różnych kolorach, zależnie od grupy, do którje należą.
//5. Chip'y powinny być pogrupowane według kategorii j.w.,
//6.Ocenie podlega również ilość commit'ów.

class MainActivity : AppCompatActivity() {
    private val shoppingItems = mapOf(
        "Ciastka" to listOf("Owsiane"),

        "Kwiaty" to listOf("Róże"),

        "Herbaty" to listOf("Earl Grey")
    )
    private val selectedItems = mutableListOf<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaciastek = findViewById<ChipGroup>(R.id.listaciastek)
        val listakwiatow = findViewById<ChipGroup>(R.id.listakwiatow)
        val listaherbat = findViewById<ChipGroup>(R.id.listaherbat)
        val listazakupow = shoppingItems.values.flatten()

        for (item in listazakupow) {
            val checkbox = Chip(this).apply {
                text = item
                isCheckable = true
                tag = shoppingItems.entries.firstOrNull { it.value.contains(item) }?.key
                setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        selectedItems.add(item)
                    } else {
                        selectedItems.remove(item)
                    }
                }
            }
            checkbox.chipBackgroundColor = resources.getColorStateList(R.color.purple_200)

            when (checkbox.tag) {
                "Ciastka" -> listaciastek.addView(checkbox)
                "Kwiaty" -> listakwiatow.addView(checkbox)
                "Herbaty" -> listaherbat.addView(checkbox)
            }
        }
    }
}