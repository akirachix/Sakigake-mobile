package sakigake.mzaziconnect.mzaziconnectapplication.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiClient
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiInterface
import sakigake.mzaziconnect.mzaziconnectapplication.model.ParentLoginRequest
import sakigake.mzaziconnect.mzaziconnectapplication.model.ParentLoginResponse

class ParentLoginRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun loginParent(parentLoginRequest: ParentLoginRequest): Response<ParentLoginResponse> {
        return withContext(Dispatchers.IO){
            apiClient.loginParent(parentLoginRequest)
        }
    }
}