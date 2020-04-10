package com.example.puzzle

import android.animation.ObjectAnimator
import android.content.res.Resources


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
        ObjectAnimator
            .ofFloat(node.node, "translationX", dpToPx(M))
            .apply {
                duration = 1000
                start()
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

        ObjectAnimator
            .ofFloat(node.node, "translationY", dpToPx(M))
            .apply {
                duration = 1000
                start()
            }

    }
}
fun randomPosition(node: MutableList<Nodes>){
    val a = GetUpDownLeftRight(node)
    val num = (0..3).random()
    if (a[num].x == 1){
        if (a[num].y == 0)
            ChangePosition(a[num],false,96)
        else
            ChangePosition(a[num],false,-96)
    }else{
        if (a[num].x == 2)
            ChangePosition(a[num],true,-96)
        else
            ChangePosition(a[num],true,96)

    }
}
fun GetUpDownLeftRight(node: MutableList<Nodes>):MutableList<Nodes>{
    var array = ArrayList<Nodes>()
    for (i in 1 .. 8)
        if (node[i].x == 1 || node[i].y == 1 && !(node[i].x == 1 && node[i].y == 1))
            array.add(node[i])

    return array

}