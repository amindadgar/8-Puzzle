package com.example.puzzle

import android.content.res.Resources
import android.util.Log
import kotlinx.coroutines.runBlocking
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


fun dpToPx(dp: Int): Float {
    return (dp * Resources.getSystem().getDisplayMetrics().density)
}

fun pxToDp(px: Int): Float {
    return (px / Resources.getSystem().getDisplayMetrics().density)
}

fun ChangePosition(node: Nodes, X:Boolean, M:Int= 96){
    if (X) {
        if (M>0) node.x++
        else node.x--
        if (node.x > 2){
            node.x--
            return
        }else if (node.x < 0){
            node.x ++
            return
        }
    }
    else {
        if (M>0) node.y ++
        else node.y--
        if (node.y > 2){
            node.y--
            return
        }else if (node.y < 0){
            node.y ++
            return
        }
    }
}
fun changeposition(node:Nodes){  //LR short form of Left or Right
    if (emptyPosition.x == 0)
        node.node.animate().x(20f)
    if (emptyPosition.y == 0)
        node.node.animate().x(20f)
    if (emptyPosition.x == 1)
        node.node.animate().x(261f)
    if (emptyPosition.y == 1)
        node.node.animate().y(261f)
    if (emptyPosition.x == 2)
        node.node.animate().x(522f)
    if (emptyPosition.y == 2)
        node.node.animate().y(522f)
}
fun randomPosition(node: MutableList<Nodes>)= runBlocking{
    var i = 0

    while (true) {
        i = (1..8).random()
        if (node[i].x - 1 == emptyPosition.x && node[i].y == emptyPosition.y) {
            changeposition(node[i])
            emptyPosition.x = node[i].x
            emptyPosition.y = node[i].y
            ChangePosition(node[i], true, -96)
//            delay(10L)
            Log.d("positions","1")
            Log.d("position","x=${emptyPosition.x},y=${emptyPosition.y}")
            Log.d("node[$i]","e")
            break
        }else if (node[i].x + 1 == emptyPosition.x && node[i].y == emptyPosition.y){
            changeposition(node[i])
            emptyPosition.x = node[i].x
            emptyPosition.y = node[i].y
            ChangePosition(node[i],true,96)
//            delay(10L)
            Log.d("positions","2")
            Log.d("position","x=${emptyPosition.x},y=${emptyPosition.y}")
            Log.d("node[$i]","e")
            break
        }
        else if (node[i].y - 1 == emptyPosition.y && node[i].x == emptyPosition.x){
            changeposition(node[i])
            emptyPosition.x = node[i].x
            emptyPosition.y = node[i].y
            ChangePosition(node[i],false,-96)
//            delay(10L)
            Log.d("positions","3")
            Log.d("position","x=${emptyPosition.x},y=${emptyPosition.y}")
            Log.d("node[$i]","e")
            break
        }else if (node[i].y+1 == emptyPosition.y && node[i].x == emptyPosition.x){
            changeposition(node[i])
            emptyPosition.x = node[i].x
            emptyPosition.y = node[i].y
            ChangePosition(node[i],false,96)
//            delay(10L)
            Log.d("positions","4")
            Log.d("position","x=${emptyPosition.x},y=${emptyPosition.y}")
            Log.d("node[$i]","e")
            break
        }

    }
}