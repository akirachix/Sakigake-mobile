package sakigake.mzaziconnect.mzaziconnectapplication.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiClient
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiInterface
import sakigake.mzaziconnect.mzaziconnectapplication.model.SubjectData

class SubjectRepo {

    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun  getSubjects(): Response<List<SubjectData>> {
        return withContext(Dispatchers.IO){
            apiClient.getSubject()
        }
    }
}