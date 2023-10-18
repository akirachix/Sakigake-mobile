package sakigake.mzaziconnect.mzaziconnectapplication.database
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import sakigake.mzaziconnect.mzaziconnectapplication.model.Comments


@Dao
interface CommentsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComments(comment :Comments)
    @Query("SELECT*FROM Comments ORDER BY parent_comment")
    fun getAllComments():LiveData<List<Comments>>

    @Query("SELECT * FROM Comments WHERE id = :id")
    fun getCommentById(id: Int): LiveData<Comments>

}



//@Dao
//interface ContactDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertContact(contact :ContactData)
//    @Query("SELECT*FROM Contacts ORDER BY displayName")
//    fun getAllContacts():LiveData<List<ContactData>>
//
//    @Query("SELECT * FROM Contacts WHERE contactId = :contactId")
//    fun getContactById(contactId: Int): LiveData<ContactData>
//
//}
