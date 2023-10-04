package sakigake.mzaziconnect.mzaziconnectapplication.repository



import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiClient
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiInterface
import sakigake.mzaziconnect.mzaziconnectapplication.model.ShopData

class ShopRepo {

    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun  getShop(): Response<List<ShopData>> {
        return withContext(Dispatchers.IO){
            apiClient.getShop()
        }
    }
}