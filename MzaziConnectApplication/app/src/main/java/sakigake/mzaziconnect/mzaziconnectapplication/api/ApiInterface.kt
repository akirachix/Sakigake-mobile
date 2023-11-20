package sakigake.mzaziconnect.mzaziconnectapplication.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import sakigake.mzaziconnect.mzaziconnectapplication.model.AssignmentsData
import sakigake.mzaziconnect.mzaziconnectapplication.model.ParentData
import sakigake.mzaziconnect.mzaziconnectapplication.model.ParentLoginRequest
import sakigake.mzaziconnect.mzaziconnectapplication.model.ParentLoginResponse
import sakigake.mzaziconnect.mzaziconnectapplication.model.StudentsData
import sakigake.mzaziconnect.mzaziconnectapplication.model.TeacherLoginRequest
import sakigake.mzaziconnect.mzaziconnectapplication.model.TeacherLoginResponse
import sakigake.mzaziconnect.mzaziconnectapplication.model.Comments
import sakigake.mzaziconnect.mzaziconnectapplication.model.ShopData
import sakigake.mzaziconnect.mzaziconnectapplication.model.Shops
import sakigake.mzaziconnect.mzaziconnectapplication.model.SubjectData
import sakigake.mzaziconnect.mzaziconnectapplication.model.Subjects
import sakigake.mzaziconnect.mzaziconnectapplication.model.TopicsData


interface ApiInterface {
    @POST("account/schools/parents/login/")
    suspend fun loginParent(@Body parentLoginRequest: ParentLoginRequest): Response<ParentLoginResponse>

    @POST("account/schools/teachers/signin/")
    suspend fun loginTeacher(@Body teacherLoginRequest: TeacherLoginRequest): Response<TeacherLoginResponse>

    @GET("account/schools/{schoolId}/parents/")
    suspend fun getParentData(@Path("schoolId") schoolId: Int): Response<ParentData>

    @GET("students/students/")
    suspend fun getStudentData(@Path("studentId") studentId: String): Response<StudentsData>

    @GET("/shop/shops/")
    suspend fun getShops(): Response<List<Shops>>

    @GET("/shop/shops/")
    suspend fun getShop():Response<List<ShopData>>

    @GET("/assignment/assignments/")
    suspend fun getAssignments(): Response<List<TopicsData>>

    @GET("/assignment/assignments/")
    suspend fun getAssignment(): Response<List<AssignmentsData>>

    @GET("/subjects/subjectsList/")
    suspend fun getSubjects(): Response<List<Subjects>>
    @GET("/subjects/subjectsList/")
    suspend fun getSubject(): Response<List<SubjectData>>

    @GET("/assignment/assignments/{assignmentId}")
    suspend fun getAssignmentid(@Path("assignmentId") assignmentId: Int): Response<List<Subjects>>

    @GET("/comments/list/")
    suspend fun getComments(): Response<List<Comments>>

    @POST("/assignment/assignments/")
    suspend fun postAssignment(@Body assignmentData: AssignmentsData):Response<AssignmentsData>
}