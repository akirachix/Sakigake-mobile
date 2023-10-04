package sakigake.mzaziconnect.mzaziconnectapplication.viewmodel

import android.app.Application
import android.content.Context

class MyCommentsApp : Application() {
        companion object{
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext=applicationContext
    }

}

//package com.assignment.contatslist
//
//import android.app.Application
//import android.content.Context
//
//class MyContactsApp :Application() {
//    companion object{
//        lateinit var appContext: Context
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//        appContext=applicationContext
//    }
//
//}