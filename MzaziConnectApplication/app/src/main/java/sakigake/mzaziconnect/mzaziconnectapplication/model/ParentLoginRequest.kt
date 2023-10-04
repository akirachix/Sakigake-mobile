package sakigake.mzaziconnect.mzaziconnectapplication.model

import com.google.gson.annotations.SerializedName

data class ParentLoginRequest(
    @SerializedName("phone_number") var phoneNumber: String,
    var password: String
)
