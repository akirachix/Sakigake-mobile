package sakigake.mzaziconnect.mzaziconnectapplication

import android.app.Application
import android.content.Context
import org.jetbrains.exposed.sql.Database


class MzaziConnect: Application() {
    companion object{
        lateinit var  appContext: Context
    }
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
}
//        val databaseUrl = "https://sakigake-backend-ecc1b0d1bf4d.herokuapp.com/"
//        val databaseUser = "Lakewood Primary School"
//        val databasePassword = "LLakewood@123"
//
//        Database.connect(databaseUrl, driver = "org.postgresql.Driver", user = databaseUser, password = databasePassword)
//    }
//    }
