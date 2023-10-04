package sakigake.mzaziconnect.mzaziconnectapplication.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiClient
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiInterface
import sakigake.mzaziconnect.mzaziconnectapplication.model.Comments
import sakigake.mzaziconnect.mzaziconnectapplication.model.Subjects

class CommentsRepository {
    private val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)



//    suspend fun saveComment(comment:Comments){
//        withContext(Dispatchers.IO){
//            database.getContactDao().insertContact(comment)
//        }
//    }
    suspend fun getComments(): Response<List<Comments>> {
        return withContext(Dispatchers.IO) {
            apiClient.getComments()
        }

    }
}
