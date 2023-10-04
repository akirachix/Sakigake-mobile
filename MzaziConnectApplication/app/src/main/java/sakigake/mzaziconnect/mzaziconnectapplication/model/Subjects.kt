package sakigake.mzaziconnect.mzaziconnectapplication.model
import com.google.gson.annotations.SerializedName
data class Subjects (
    @SerializedName("subject_name")val subjectName: String,
    val description: String,
    val teacher: Int,
    val subjectImageUrl: String
    )
