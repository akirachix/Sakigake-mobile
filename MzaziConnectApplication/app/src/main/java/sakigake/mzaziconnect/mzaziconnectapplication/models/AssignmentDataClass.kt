package sakigake.mzaziconnect.mzaziconnectapplication.models

import java.util.Date

data class AssignmentDataClass(
    var subjectName: String?,
    var dueDate: Date,
    var topicName: String,
    var resourcesRequirement: String,
    var updatedAt: String,
)
