package com.example.puzzle

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.runBlocking

var emptyPosition = EmptyPosiotion(1,1)
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number = arrayListOf<View>(findViewById<View>(R.id.ImageNumber1),
            findViewById<View>(R.id.ImageNumber1),findViewById<View>(R.id.ImageNumber2),
            findViewById<View>(R.id.ImageNumber3),findViewById<View>(R.id.ImageNumber4),
            findViewById<View>(R.id.ImageNumber5),findViewById<View>(R.id.ImageNumber6),
            findViewById<View>(R.id.ImageNumber7),findViewById<View>(R.id.ImageNumber8),
            findViewById<View>(R.id.ImageNumber9))

        val nodes :MutableList<Nodes> = ArrayList()
        for (i in 0 .. 9)
            nodes.add(i,Nodes(number[i]))
        nodes[2].x = 1; nodes[2].y = 0; nodes[3].x = 2; nodes[3].y = 0; nodes[4].x = 2; nodes[4].y = 1
        nodes[5].x = 2; nodes[5].y = 2; nodes[6].x = 1; nodes[6].y = 2
        nodes[7].x = 0; nodes[7].y = 2; nodes[8].x = 0; nodes[8].y = 1
        nodes[9].x = 1; nodes[9].y = 1

//        ChangePosition(nodes[4],true,-96)
//        ChangePosition(nodes[4],true,96)
//        Toast.makeText(this,"x=${emptyPosition.x},y=${emptyPosition.y}",Toast.LENGTH_LONG).show()
//        randomPosition(nodes)
//        randomPosition(nodes)
//        randomPosition(nodes)
//        randomPosition(nodes)
        var j =0
        randomButton.setOnClickListener {
//            randomPosition(nodes)
            if (j==0){
                ChangePosition(nodes[4],true,-96)
                j++
            }else
                ChangePosition(nodes[4],true,96)
        }

    }
}



