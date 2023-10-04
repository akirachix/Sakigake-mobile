package sakigake.mzaziconnect.mzaziconnectapplication.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiClient
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiInterface
import sakigake.mzaziconnect.mzaziconnectapplication.model.ParentData
import sakigake.mzaziconnect.mzaziconnectapplication.model.StudentsData

class ParentRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun getParentData(schoolId: Int): Response<ParentData> {
        return withContext(Dispatchers.IO){
            apiClient.getParentData(schoolId)
        }
    }
    suspend fun getStudentData(studentId: String): Response<StudentsData> {
        return withContext(Dispatchers.IO){
            apiClient.getStudentData(studentId)
        }
    }
}
