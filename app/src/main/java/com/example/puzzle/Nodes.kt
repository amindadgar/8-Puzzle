package com.example.puzzle

import android.animation.ObjectAnimator
import android.view.View
import androidx.annotation.UiThread

class Nodes(val node:View,var x:Int=0,var y:Int=0) {

}
class EmptyPosiotion(var x:Int=1,var y:Int=1)
//internal class Animation (view: View,M:Int){
//
//    val animator: Thread
//
//    init {
//        animator = Thread{
//            ObjectAnimator.ofFloat(view, "translationX", dpToPx(M))
//                .apply {
//                    duration = 1000
//
//                }.start()
//        }
//
//    }
//
//    fun startAnimation() {
//        animator.start()
//    }
//
//    @Throws(InterruptedException::class)
//    fun awaitCompletion() {
//        animator.join()
//    }
//}