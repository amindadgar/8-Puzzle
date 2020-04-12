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

fun Console_randomPosition(node: MutableList<Nodes>){  //changing view positions but not changing in ui
    var i = 0
    for (j in 0..9)
    while (true) {
        i = (1..8).random()
        if ((node[i].x - 1 == emptyPosition.x && node[i].y == emptyPosition.y) &&
                node[i].x -1 != -1) {
            emptyPosition.x = node[i].x
            emptyPosition.y = node[i].y
            node[i].x --
            break
        }else if ((node[i].x + 1 == emptyPosition.x && node[i].y == emptyPosition.y) &&
                node[i].x+1 != 3){
            emptyPosition.x = node[i].x
            emptyPosition.y = node[i].y
            node[i].x ++
            break
        }
        else if ((node[i].y - 1 == emptyPosition.y && node[i].x == emptyPosition.x) &&
            node[i].y -1 != -1){
            emptyPosition.x = node[i].x
            emptyPosition.y = node[i].y
            node[i].y --
            break
        }else if ((node[i].y+1 == emptyPosition.y && node[i].x == emptyPosition.x) &&
            node[i].y +1 != 3){
            emptyPosition.x = node[i].x
            emptyPosition.y = node[i].y
            node[i].y ++
            break
        }

    }
    Console_PutInPosition(node)
}
fun Console_PutInPosition(node: MutableList<Nodes>){
    for (i in 1..8){
        if (node[i].x == 0)
            node[i].node.animate().x(dpToPx(7))
        if (node[i].y == 0)
            node[i].node.animate().y(dpToPx(7))
        if (node[i].x == 1)
            node[i].node.animate().x(dpToPx(103))
        if (node[i].y == 1)
            node[i].node.animate().y(dpToPx(103))
        if (node[i].x == 2)
            node[i].node.animate().x(dpToPx(198))
        if (node[i].y == 2)
            node[i].node.animate().y(dpToPx(198))
    }
}