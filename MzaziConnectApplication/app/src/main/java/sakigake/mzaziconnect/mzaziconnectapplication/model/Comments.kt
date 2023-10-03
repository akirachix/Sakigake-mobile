package sakigake.mzaziconnect.mzaziconnectapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Comments")
data class Comments(
    @PrimaryKey(autoGenerate = true)

val id :Int,
    val content :String,
    val created_at : String,
    val updated_at :String,
    val assignment :String,
    val commentor : Int,
    var parent_comment :String,
    val nameImageUrl : String

)

