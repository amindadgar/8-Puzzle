package com.example.puzzle

import android.content.res.Resources
import android.util.Log
import kotlinx.coroutines.runBlocking
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.*
import kotlin.collections.ArrayList


fun dpToPx(dp: Int): Float {
    return (dp * Resources.getSystem().getDisplayMetrics().density)
}

fun pxToDp(px: Int): Float {
    return (px / Resources.getSystem().getDisplayMetrics().density)
}

fun Console_randomPosition(node: MutableList<Nodes>){  //changing view positions but not changing in ui
    var i = 0
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
//    Console_PutInPosition(node)
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
fun ReturnAllMovements(node: MutableList<Nodes>):MutableList<Nodes> {
    val availableMove:MutableList<Nodes> = ArrayList()
    for (i in 1 .. 8) {
        if ((node[i].x - 1 == emptyPosition.x && node[i].y == emptyPosition.y) &&
            node[i].x - 1 != -1) {
            availableMove.add(node[i])

        } else if ((node[i].x + 1 == emptyPosition.x && node[i].y == emptyPosition.y) &&
            node[i].x + 1 != 3) {
            availableMove.add(node[i])
        } else if ((node[i].y - 1 == emptyPosition.y && node[i].x == emptyPosition.x) &&
            node[i].y - 1 != -1) {
            availableMove.add(node[i])
        } else if ((node[i].y + 1 == emptyPosition.y && node[i].x == emptyPosition.x) &&
            node[i].y + 1 != 3) {
            availableMove.add(node[i])
        }
    }
    return availableMove
}

fun DFS_Closed(node: MutableList<Nodes>){  // TODO("Read The Algorithm first to undrestand better
//    val closedArray = arrayListOf<MutableList<Nodes>>()
//    closedArray.add(node)  //initial state
    var myStack = Stack<MutableList<Nodes>>()
    val availableMove =arrayListOf<MutableList<Nodes>>()
    myStack.push(node)
    while (node != GoalNodes){
        availableMove.add(ReturnAllMovements(node))
        if (node == myStack.peek())
            DFS_FirstMovements(node)
    }
    Log.d("yes","yes")

}

fun DFS_FirstMovements(node: MutableList<Nodes>):Nodes {
    for (i in 1 .. 8){
        if ((node[i].x - 1 == emptyPosition.x && node[i].y == emptyPosition.y) &&
            node[i].x - 1 != -1) {
            emptyPosition.x = node[i].x
            emptyPosition.y = node[i].y
            node[i].x --
            return node[i]
        } else if ((node[i].x + 1 == emptyPosition.x && node[i].y == emptyPosition.y) &&
            node[i].x + 1 != 3) {
            emptyPosition.x = node[i].x
            emptyPosition.y = node[i].y
            node[i].x ++
            return node[i]
        } else if ((node[i].y - 1 == emptyPosition.y && node[i].x == emptyPosition.x) &&
            node[i].y - 1 != -1) {
            emptyPosition.x = node[i].x
            emptyPosition.y = node[i].y
            node[i].y --
            return node[i]
        } else if ((node[i].y + 1 == emptyPosition.y && node[i].x == emptyPosition.x) &&
            node[i].y + 1 != 3) {
            emptyPosition.x = node[i].x
            emptyPosition.y = node[i].y
            node[i].y++
            return node[i]
        }
    }
    Log.e("Error","ReturnFirstMovements_Function") //we never should reach here
    node[0].x = -1               //if we reach here, it means no move was found
    node[0].y = -1
    return node[0]
}
fun arvin_search(nodes: MutableList<Nodes>){
    val array:MutableList<String> = GetArray(nodes)
    var number:Int=0
    var temp:String?=null
    var index = 0
    if (array[index] == null)
        number = 4
    else
        number = array[index].substring(6).toInt()
    while (array != GoalArray) {
//        Log.d("array[$index]",number.toString())
        if (number == index + 1){
            if (index + 1 < 9) index++
            else index = 0
            if (array[index] == null) number = 9
            else number = array[index].substring(6).toInt()
        }

        while (number < index + 1) {
            println("Stuck in the first")
            
            if (index - 3 >= 0 && number <= index - 1) {  //I don't know

                temp = array[index]
                array[index] = array[index - 3]
                array[index - 3] = temp

            } else if (index - 1 > 0 ) {

                temp = array[index]
                array[index] = array[index - 1]
                array[index - 1] = temp

            }
            if (index + 1 == 9) index = -1
            if (array[index+1] == null){
                number = 9
                index++
            }
            else
                number = array[++index].substring(6).toInt()
        }
        while (number > index + 1 ) {
            println("I'm Stuck here")
            if (index + 3 < 9 && number >= index+4) {  //Check here again

                temp = array[index]
                array[index] = array[index + 3]
                array[index + 3] = temp

            } else if (index + 1 < 9) {

                temp = array[index]
                array[index] = array[index + 1]
                array[index + 1] = temp

            }
            if (index + 1 == 9) index = -1
            if (array[index+1] == null){
                number = 9
                index++
            }
            else
                number = array[++index].substring(6).toInt()
        }
    }
    array.forEach {
        println("Apple "+it)
    }

}
fun GetArray(nodes:MutableList<Nodes>):MutableList<String>{
    val array = arrayOfNulls<String>(9)
        for (i in 0..8){
            if (nodes[i].x == 0 && nodes[i].y == 0){
                array[0] = nodes[i].node.resources.getResourceEntryName(nodes[i].node.id)
            }
            else if (nodes[i].x == 1 && nodes[i].y == 0){
                array[1] = nodes[i].node.resources.getResourceEntryName(nodes[i].node.id)
            }
            else if (nodes[i].x == 2 && nodes[i].y == 0){
                array[2] = nodes[i].node.resources.getResourceEntryName(nodes[i].node.id)
            }
            else if (nodes[i].x == 0 && nodes[i].y == 1){
                array[3] = nodes[i].node.resources.getResourceEntryName(nodes[i].node.id)
            }
            else if (nodes[i].x == 1 && nodes[i].y == 1){
                array[4] = nodes[i].node.resources.getResourceEntryName(nodes[i].node.id)
            }
            else if (nodes[i].x == 2 && nodes[i].y == 1){
                array[5] = nodes[i].node.resources.getResourceEntryName(nodes[i].node.id)
            }
            else if (nodes[i].x == 0 && nodes[i].y == 2){
                array[6] = nodes[i].node.resources.getResourceEntryName(nodes[i].node.id)
            }
            else if (nodes[i].x == 1 && nodes[i].y == 2){
                array[7] = nodes[i].node.resources.getResourceEntryName(nodes[i].node.id)
            }
            else if (nodes[i].x == 2 && nodes[i].y == 2){
                array[8] = nodes[i].node.resources.getResourceEntryName(nodes[i].node.id)
            }
        }
    return array.toMutableList() as MutableList<String>
}
