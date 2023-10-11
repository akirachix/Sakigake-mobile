package sakigake.mzaziconnect.mzaziconnectapplication.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiClient
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiInterface
import sakigake.mzaziconnect.mzaziconnectapplication.model.AssignmentData
import sakigake.mzaziconnect.mzaziconnectapplication.model.AssignmentsData
import sakigake.mzaziconnect.mzaziconnectapplication.model.TopicsData

class AssignmentRepo {

    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun  getAssignment(): Response<List<AssignmentsData>> {
        return withContext(Dispatchers.IO){
            apiClient.getAssignment()
        }
    }


    suspend fun postAssignment(assignmentData: AssignmentsData): Response<AssignmentsData> {
        return apiClient.postAssignment(assignmentData)
    }
}