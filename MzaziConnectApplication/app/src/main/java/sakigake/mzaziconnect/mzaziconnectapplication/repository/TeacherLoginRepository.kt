package sakigake.mzaziconnect.mzaziconnectapplication.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiClient
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiInterface
import sakigake.mzaziconnect.mzaziconnectapplication.model.TeacherLoginRequest

class TeacherLoginRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun login (teacherLoginRequest: TeacherLoginRequest)
            = withContext(Dispatchers.IO) {
        return@withContext apiClient.loginTeacher(teacherLoginRequest)
    }
}