package com.meozturk.color.call

import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CallResult: AppCompatActivity() {

    private var messageInput : EditText = findViewById(R.id.messageInput)
    private lateinit var number: String
    private  var timerLabelResult: TextView? = findViewById(R.id.timerLabelResult)

    @RequiresApi(Build.VERSION_CODES.O)
    val current = LocalDateTime.now()
    @RequiresApi(Build.VERSION_CODES.O)
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    @RequiresApi(Build.VERSION_CODES.O)
    val formatted: String? = current.format(formatter)


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_result)

        messageInput = findViewById(R.id.messageInput)

        number = intent.data.schemeSpecificPart

        messageSend.setOnClickListener(){
            var obj = SmsManager.getDefault()
            obj.sendTextMessage (number, null, messageInput.toString(), null, null)
        }

        timerLabelResult?.text = "Call ended $formatted"
    }





}