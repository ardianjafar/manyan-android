package com.example.barvolume

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.barvolume.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
//    private lateinit var edtWidth : EditText
//    private lateinit var edtHeight : EditText
//    private lateinit var edtLength : EditText
//    private lateinit var btnCalculate : Button
//    private lateinit var tvResult : TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)


//        rootrootedtWidth.findViewById<EditText>(R.id.edt_width)
//        edtHeight.findViewById<EditText>(R.id.edt_height)
//        edtLength.findViewById<EditText>(R.id.edt_length)
//        btnCalculate.findViewById<Button>(R.id.btn_calculate)
//        tvResult.findViewById<TextView>(R.id.tv_result)
//        btnCalculate.setOnClickListener(this)

        binding.btnCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if(view?.id == R.id.btn_calculate){
            val inputLength = binding.edtLength.text.toString().trim()
            val inputWidth = binding.edtWidth.text.toString().trim()
            val inputHeight = binding.edtHeight.text.toString().trim()
            var isEmptyFields = false

            if(inputLength.isEmpty()){
                isEmptyFields = true
                binding.edtLength.error = "Field ini tidak boleh kosong"
            }

            if(inputWidth.isEmpty()){
                isEmptyFields = true
                binding.edtWidth.error = "Field ini tidak boleh kosong"
            }

            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                binding.edtHeight.error = "Field ini tidak boleh kosong"
            }

            if(!isEmptyFields){
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputLength.toDouble()
                binding.tvResult.text = volume.toString()
            }
        }
    }
}