package sakigake.mzaziconnect.mzaziconnectapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Comments")
data class Comments(
    @PrimaryKey(autoGenerate = true)

    val id :Int,
    val content :String ?= null ,
    val created_at : String ?= null,
    val updated_at :String ?= null,
    val assignment :String ?= null,
    val commentor : String ?= null,
    var parent_comment :String ?= null,
    val nameImageUrl : String ?= null

)

