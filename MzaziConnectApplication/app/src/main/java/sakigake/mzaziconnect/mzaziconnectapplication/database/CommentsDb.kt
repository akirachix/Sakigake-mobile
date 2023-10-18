package sakigake.mzaziconnect.mzaziconnectapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import sakigake.mzaziconnect.mzaziconnectapplication.model.Comments

@Database(entities = arrayOf(Comments::class), version = 1)

abstract class CommentsDb : RoomDatabase(){
    abstract fun getCommentsDao (): CommentsDao

    companion object{
        private  var database:CommentsDb? = null

        fun getDataBase(context: Context):CommentsDb{
            if(database == null){
                database= Room
                    .databaseBuilder(context,CommentsDb::class.java, "CommentsDb")
                    .build()
            }
            return database as CommentsDb
        }

    }
}