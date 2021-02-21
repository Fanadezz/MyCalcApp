package com.example.mycalcapp

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class RemoteService: Service() {




    val binder = object:CalcService.Stub(){
        override fun basicTypes(
            anInt: Int,
            aLong: Long,
            aBoolean: Boolean,
            aFloat: Float,
            aDouble: Double,
            aString: String?
        ) {
            TODO("Not yet implemented")
        }

        override fun add(valOne: Int, valTwo: Int): Int {
            return valOne.plus(valTwo)
        }

        override fun subtract(valOne: Int, valTwo: Int): Int {
           return valOne.minus(valTwo)
        }

        override fun multiply(valOne: Int, valTwo: Int): Int {
          return valOne.times(valTwo)
        }

        override fun divide(valOne: Int, valTwo: Int): Int {
          return valOne/valTwo
        }
    }


    override fun onBind(intent: Intent?): IBinder? {


        return binder
    }

}