package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//1. Napisz program, który będzie miał dwa tryby; dodwanie do listy zakupów oraz odhaczania zakupów (przełącznik Radiobutton)
//2. Po wybraniu dodwania widoczne stają się Checkbox'y z 10 dowolnymi zakupami (w 3 grupach np.; warzywa wędliny, pieczywo)
//3. Po wybraniu odhaczenia widoczne stają się wyłącznie Chip'y zaznaczone podczas "dodwania" (2)
//4. Checkbox'y powinny być w 3 różnych kolorach, zależnie od grupy, do którje należą.
//5. Chip'y powinny być pogrupowane według kategorii j.w.,
//6.Ocenie podlega również ilość commit'ów.

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}