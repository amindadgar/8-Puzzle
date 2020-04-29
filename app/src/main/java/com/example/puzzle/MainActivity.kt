package com.example.puzzle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


var emptyPosition = EmptyPosiotion(1,1)
val GoalNodes :MutableList<Nodes> = ArrayList()
var GoalArray:MutableList<String> = arrayListOf()
var dropDownItem:Int = -1
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val nodes :MutableList<Nodes> = ArrayList()
        val ToastLayout = layoutInflater.inflate(R.layout.toast_layout,findViewById(R.id.custom_toast_container))
        val Toast = Toast(this)
        val DropDown = findViewById<Spinner>(R.id.spinner1)
        val spinnerItems = arrayListOf<String>("Random","A* algorithm")
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,spinnerItems)
        DropDown.adapter = adapter


        DropDown.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //do nothing
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                dropDownItem = position
            }

        }

        initialPositions(nodes)
        initialPositions(GoalNodes)
        GoalArray = mutableListOf("number1","number2","number3","number4","number5","number6","number7","number8"
            ,null) as MutableList<String>
     //   Toast.makeText(this,nodes[1].node.resources.getResourceEntryName(nodes[1].node.id),Toast.LENGTH_LONG).show()



        button.setOnClickListener {
            if (dropDownItem == 0){
                for (i in 0..16)
                    Console_randomPosition(nodes)
                Console_PutInPosition(nodes)
                textView.text = "You will notice the items are positioning at the same time!\n" +
                        "It's because Random algorithm has done its job and now positioning the items"

            }else if (dropDownItem == 1){
                Toast.setGravity(Gravity.BOTTOM, 0, 40)
                Toast.view = ToastLayout
                Toast.duration = android.widget.Toast.LENGTH_LONG
                Toast.show()
                arvin_search(nodes)
                textView.text = "A* algorithm done with no freezing !"
            }
        }

    }
    fun initialPositions(nodes:MutableList<Nodes>){
        val number = arrayListOf<View>(findViewById<View>(R.id.number1),
            findViewById<View>(R.id.number1),findViewById<View>(R.id.number2),
            findViewById<View>(R.id.number3),findViewById<View>(R.id.number4),
            findViewById<View>(R.id.number5),findViewById<View>(R.id.number6),
            findViewById<View>(R.id.number7),findViewById<View>(R.id.number8),
            findViewById<View>(R.id.number9))

        for (i in 0 .. 9)
            nodes.add(i,Nodes(number[i]))
        nodes[2].x = 1; nodes[2].y = 0; nodes[3].x = 2; nodes[3].y = 0; nodes[4].x = 2; nodes[4].y = 1
        nodes[5].x = 2; nodes[5].y = 2; nodes[6].x = 1; nodes[6].y = 2
        nodes[7].x = 0; nodes[7].y = 2; nodes[8].x = 0; nodes[8].y = 1
        nodes[9].x = 1; nodes[9].y = 1

    }

}



