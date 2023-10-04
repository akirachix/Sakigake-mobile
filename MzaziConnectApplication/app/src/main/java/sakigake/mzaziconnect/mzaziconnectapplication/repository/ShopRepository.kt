package sakigake.mzaziconnect.mzaziconnectapplication.repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiClient
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiInterface
import sakigake.mzaziconnect.mzaziconnectapplication.model.Shops
class ShopRepository {
    private val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun getShops(): Response<List<Shops>> {
        return withContext(Dispatchers.IO){
            apiClient.getShops()
        }
    }
}


