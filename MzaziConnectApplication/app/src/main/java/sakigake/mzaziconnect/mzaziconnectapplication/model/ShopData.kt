package sakigake.mzaziconnect.mzaziconnectapplication.model

data class ShopData (
    var id:Int,
    var name:String,
    var location:String,
    var phone_number:String,
    var category: String

)

{

    override fun toString(): String {
        return category
    }
}