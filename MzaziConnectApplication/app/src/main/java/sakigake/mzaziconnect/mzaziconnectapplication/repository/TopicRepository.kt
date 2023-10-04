package sakigake.mzaziconnect.mzaziconnectapplication.repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiClient
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiInterface
import sakigake.mzaziconnect.mzaziconnectapplication.model.TopicsData
class TopicRepository {
    private val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun getAssignments(): Response<List<TopicsData>> {
        return withContext(Dispatchers.IO){
            apiClient.getAssignments()

        }

    }
}
