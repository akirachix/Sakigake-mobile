package sakigake.mzaziconnect.mzaziconnectapplication.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import sakigake.mzaziconnect.mzaziconnectapplication.model.Comments
import sakigake.mzaziconnect.mzaziconnectapplication.model.Shops
import sakigake.mzaziconnect.mzaziconnectapplication.model.Subjects
import sakigake.mzaziconnect.mzaziconnectapplication.model.TopicsData

interface ApiInterface {
    @GET("/shop/shops/")
    suspend fun getShops(): Response<List<Shops>>

    @GET("/assignment/assignments/")
    suspend fun getAssignments(): Response<List<TopicsData>>
    @GET("/subjects/subjectsList/")
    suspend fun getSubjects(): Response<List<Subjects>>

    @GET("/assignment/assignments/{assignmentId}/")
    suspend fun getAssignmentid(@Path("assignmentId") assignmentId: Int): Response<List<Subjects>>

    @GET("/comments/list/")
    suspend fun getComments(): Response<List<Comments>>


}
