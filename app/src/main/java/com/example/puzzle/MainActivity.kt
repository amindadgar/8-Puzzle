package com.example.puzzle

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



var emptyPosition = EmptyPosiotion(1,1)
class MainActivity : AppCompatActivity() {
    val nodes :MutableList<Nodes> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number = arrayListOf<View>(findViewById<View>(R.id.ImageNumber1),
            findViewById<View>(R.id.ImageNumber1),findViewById<View>(R.id.ImageNumber2),
            findViewById<View>(R.id.ImageNumber3),findViewById<View>(R.id.ImageNumber4),
            findViewById<View>(R.id.ImageNumber5),findViewById<View>(R.id.ImageNumber6),
            findViewById<View>(R.id.ImageNumber7),findViewById<View>(R.id.ImageNumber8),
            findViewById<View>(R.id.ImageNumber9))


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
//            ChangePosition(nodes[4],false,-96)
//            randomPosition(nodes)
            Console_randomPosition(nodes)
//            nodes[8].node.animate().x(dpToPx(7))
//            nodes[8].node.animate().y(dpToPx(103))
        }

    }
//    fun yes(input:Int){
//        val f = dpToPx(input)
//        nodes[4].node.getViewTreeObserver().addOnGlobalLayoutListener(
//            object : ViewTreeObserver.OnGlobalLayoutListener {
//                override fun onGlobalLayout() {
//                    // Layout has happened here.
//                    ChangePosition(nodes[4],true,(nodes[4].node.x - f).toInt())
//                    // Don't forget to remove your listener when you are done with it.
//                    nodes[4].node.getViewTreeObserver().removeOnGlobalLayoutListener(this)
//                }
//            })
//    }
}



