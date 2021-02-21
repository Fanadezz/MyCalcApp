package com.example.mycalcapp

import android.app.PendingIntent.getService
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.text.Editable
import android.util.Log
import com.example.mycalcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   var calcService: CalcService? = null


private val connection = object: ServiceConnection {
    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        calcService = CalcService.Stub.asInterface(service)

    }

    override fun onServiceDisconnected(name: ComponentName?) {



    }


}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAdd.setOnClickListener {
          val a: Int =   binding.val1.text.toString().toInt()
          val b: Int =   binding.val2.text.toString().toInt()


            val sum = calcService?.add(a,b)

            binding.resultEdText.text = sum.toString().toEditableString()

        }

        binding.btnSubstract.setOnClickListener{

            val a: Int =   binding.val1.text.toString().toInt()
            val b: Int =   binding.val2.text.toString().toInt()

            val res =  calcService?.subtract(a,b)
            binding.resultEdText.text = res.toString().toEditableString()
        }

        binding.btnDivide.setOnClickListener{

            val a: Int =   binding.val1.text.toString().toInt()
            val b: Int =   binding.val2.text.toString().toInt()

            val res=  calcService?.divide(a,b)
            binding.resultEdText.text = res.toString().toEditableString()
        }

        binding.btnMultiply.setOnClickListener{

            val a: Int =   binding.val1.text.toString().toInt()
            val b: Int =   binding.val2.text.toString().toInt()
            val res =  calcService?.multiply(a,b)
            binding.resultEdText.text = res.toString().toEditableString()
        }
    }




    override fun onStart() {
        super.onStart()
        
        val intent = Intent(this, RemoteService::class.java)

bindService(intent, connection, Context.BIND_AUTO_CREATE)



    }

    override fun onStop() {
        super.onStop()

        unbindService(connection)
    }


    fun String.toEditableString(): Editable = Editable.Factory.getInstance().newEditable(this)
}