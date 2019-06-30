package com.shethabhish.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun buClick(view: View) {
        val selected = view as Button
        var cell = 0

        when(selected.id) {
            R.id.b1 -> cell= 1
            R.id.b2 -> cell= 2
            R.id.b3 -> cell= 3
            R.id.b4 -> cell= 4
            R.id.b5 -> cell= 5
            R.id.b6 -> cell= 6
            R.id.b7 -> cell= 7
            R.id.b8 -> cell= 8
            R.id.b9 -> cell= 9
        }

//        Toast.makeText(this, "ID: $cell"  , Toast.LENGTH_LONG).show()
        play(cell, selected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activeplayer = 1

    fun play(cell:Int, selected:Button) {

        if (activeplayer == 1) {
            selected.text = "X"
            selected.setBackgroundColor(Color.BLUE)
            player1.add(cell)
            activeplayer = 2
            autoplay()
        } else {
            selected.text = "O"
            selected.setBackgroundColor(Color.GREEN)
            player2.add(cell)
            activeplayer = 1
        }
        selected.isEnabled = false
        findwinner()
    }

    fun findwinner() {
        var winner = -1

        //row1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        //row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        //row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        //column 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        //column 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        //column 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        //diagonal 1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        //diagonal 2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 is the winner", Toast.LENGTH_LONG).show()
            }

            else {
                Toast.makeText(this, "Player 2 is the winner", Toast.LENGTH_LONG).show()
            }
         } //else {
//            Toast.makeText(this, "No winner", Toast.LENGTH_LONG).show()
//        }
    }

    fun autoplay() {
        var emptycell = ArrayList<Int>()
        for (cell in 1..9) {
            if (!(player1.contains(cell) || player2.contains(cell))) {
                emptycell.add(cell)
            }
        }
        var r = Random
        val rindex = r.nextInt(emptycell.size)
        val cellid = emptycell[rindex]

        var select: Button?
        when(cellid) {
            1 -> select = b1
            2 -> select = b2
            3 -> select = b3
            4 -> select = b4
            5 -> select = b5
            6 -> select = b6
            7 -> select = b7
            8 -> select = b8
            9 -> select = b9
            else -> {
                select = b1
            }
        }
        play(cellid, select)
    }
}
