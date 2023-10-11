package sakigake.mzaziconnect.mzaziconnectapplication.model

import com.google.gson.annotations.SerializedName

data class StudentsData(
   @SerializedName("first_name") var firstName: String,
   @SerializedName("last_name") var lastName: String,
   @SerializedName("admission_number") var admissionNumber: Int,
   @SerializedName("class_grade") var classGrade: Int,
   var parent: Int
)
