package sakigake.mzaziconnect.mzaziconnectapplication.model

data class SubjectData (
    var id: Int,
    var subject_name: String,
    var description: String,
    var teacher: String,
)



{
    override fun toString(): String {
        return subject_name
    }
}






