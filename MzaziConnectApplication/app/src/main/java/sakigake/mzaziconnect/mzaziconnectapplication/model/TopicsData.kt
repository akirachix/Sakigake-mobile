package sakigake.mzaziconnect.mzaziconnectapplication.model
data class TopicsData(
    var id:Int,
    var topic:String,
    var competency:String,
    var task:String,
    var resources:Array<String>,
    var subject:Int,
    var category:Int,
    var due_date:String
)
