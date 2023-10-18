//package sakigake.mzaziconnect.mzaziconnectapplication.database
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import sakigake.mzaziconnect.mzaziconnectapplication.model.AssignmentsData
//
//@Database(entities = [AssignmentsData::class], version = 1)
//abstract class AssignmentDb:RoomDatabase() {
//    abstract fun assignmentsDao():AssignmentDao
//
//    companion object{
//        var database:AssignmentDb? = null
//
//        fun  getDatabase(context: Context):AssignmentDb{
//            if (database == null){
//                database = Room
//                    .databaseBuilder(context, AssignmentDb::class.java, "AssignmentsDb")
//                    .fallbackToDestructiveMigration()
//                    .build()
//
//            }
//            return database as AssignmentDb
//        }
//    }
//
//}