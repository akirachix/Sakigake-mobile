package sakigake.mzaziconnect.mzaziconnectapplication.viewmodel

import android.app.Application
import android.content.Context

class MyCommentsApp : Application(){
    companion object{
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext=applicationContext
    }

}