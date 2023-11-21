package sakigake.mzaziconnect.mzaziconnectapplication.model
import com.google.gson.annotations.SerializedName
data class Shops(
    val id :Int,
    val name: String,
    val location: String,
    @SerializedName("phone_number")val phoneNumber : String,
    val category : String,
    val shopImgUrl: String

)
