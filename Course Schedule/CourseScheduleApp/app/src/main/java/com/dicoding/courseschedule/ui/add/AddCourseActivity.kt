package com.dicoding.courseschedule.ui.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.dicoding.courseschedule.R
import com.dicoding.courseschedule.ViewModelFactory
import com.dicoding.courseschedule.util.TimePickerFragment
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

class AddCourseActivity : AppCompatActivity(),View.OnClickListener, TimePickerFragment.DialogTimeListener {

    private lateinit var viewModel: AddCourseViewModel
    private var start: String = ""
    private var end: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_course)

        supportActionBar?.title = getString(R.string.add_course)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(AddCourseViewModel::class.java)

        viewModel.saved.observe(this){
            if (it.getContentIfNotHandled() ==  true){
                onBackPressed()
            } else {
                Toast.makeText(this, "Time must be filled", Toast.LENGTH_SHORT).show()
            }
        }

        val startTime = findViewById<ImageButton>(R.id.btn_startTime)
        val endTime = findViewById<ImageButton>(R.id.btn_endTime)

        startTime.setOnClickListener(this)
        endTime.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_add, menu)
         return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_insert ->{
                val courseName = findViewById<TextInputEditText>(R.id.et_add_course).text.toString().trim()
                val day = findViewById<Spinner>(R.id.sp_day).selectedItemPosition
                val lecturer = findViewById<TextInputEditText>(R.id.edt_lecturer).text.toString().trim()
                val note =  findViewById<TextInputEditText>(R.id.edt_note).text.toString().trim()

                viewModel.insertCourse(courseName, day, start, end, lecturer, note)
                Toast.makeText(this, "Successfully added", Toast.LENGTH_SHORT).show()
                true
            } else ->{
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_startTime ->{
                val timePickerFragment = TimePickerFragment()
                timePickerFragment.show(supportFragmentManager, "start")
            }
            R.id.btn_endTime ->{
                val timePickerFragment = TimePickerFragment()
                timePickerFragment.show(supportFragmentManager, "end")
            }
        }
    }

    override fun onDialogTimeSet(tag: String?, hour: Int, minute: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)
        val format = SimpleDateFormat("HH:mm", Locale.getDefault())
        when(tag){
            "start" ->{
                findViewById<TextView>(R.id.edt_startTime).text = format.format(calendar.time)
                start = format.format(calendar.time)
            }
            "end" ->{
                findViewById<TextView>(R.id.edt_endTime).text = format.format(calendar.time)
                end = format.format(calendar.time)
            }
        }
    }


}