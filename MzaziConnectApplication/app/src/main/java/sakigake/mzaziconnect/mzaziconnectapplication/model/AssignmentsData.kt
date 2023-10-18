package sakigake.mzaziconnect.mzaziconnectapplication.model

import android.support.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

data class AssignmentsData (
    var topic:String,
    var competency:String,
    var task:String,
    var resources:Array<String>,
    var subject:Int,
    var category:Int,
    var due_date:String
    )