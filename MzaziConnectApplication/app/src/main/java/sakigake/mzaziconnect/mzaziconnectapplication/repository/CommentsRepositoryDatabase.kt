package sakigake.mzaziconnect.mzaziconnectapplication.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sakigake.mzaziconnect.mzaziconnectapplication.database.CommentsDb
import sakigake.mzaziconnect.mzaziconnectapplication.model.Comments
import sakigake.mzaziconnect.mzaziconnectapplication.viewmodel.MyCommentsApp

class CommentsRepositoryDatabase {
    val database = CommentsDb.getDataBase(MyCommentsApp.appContext)
    suspend fun saveComment(comment:Comments){
        withContext(Dispatchers.IO){
            database.getCommentsDao().insertComments(comment)
        }
    }

    fun getAllComments(): LiveData<List<Comments>> {
        return database.getCommentsDao().getAllComments()
    }

    fun getCommentById(id: Int): LiveData<Comments> {
        return database.getCommentsDao().getCommentById(id)
    }

}



