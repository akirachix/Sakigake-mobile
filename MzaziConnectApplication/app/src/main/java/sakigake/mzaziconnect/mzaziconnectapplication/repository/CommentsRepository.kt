package sakigake.mzaziconnect.mzaziconnectapplication.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiClient
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiInterface
import sakigake.mzaziconnect.mzaziconnectapplication.database.CommentsDb
import sakigake.mzaziconnect.mzaziconnectapplication.model.Comments
import sakigake.mzaziconnect.mzaziconnectapplication.model.Subjects
import sakigake.mzaziconnect.mzaziconnectapplication.viewmodel.MyCommentsApp

class CommentsRepository() {
    private val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    val database = CommentsDb.getDataBase(MyCommentsApp.appContext)

    suspend fun saveComment(comment:Comments){
        withContext(Dispatchers.IO){
            database.getCommentsDao().insertComments(comment)
        }
    }
    suspend fun getComments(): Response<List<Comments>> {
        return withContext(Dispatchers.IO) {
            apiClient.getComments()
        }

    }
    fun fetchComments():LiveData<List<Comments>>{
        return database.getCommentsDao().getAllComments()

    }


}
