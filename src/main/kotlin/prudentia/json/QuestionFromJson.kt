package prudentia.json

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ExportQuestionsOralesSansDebat(
    @JsonProperty("questionsOralesSansDebat")
    val questionsOralesSansDebat: QuestionsOralesSansDebat
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class QuestionsOralesSansDebat(
    @JsonProperty("question")
    val question: List<Question>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Question(
    @JsonProperty("uid")
    val uid: String,

    val auteur: Auteur
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Auteur(
    val identite: QuestionIdentite
)

data class QuestionIdentite(
    @JsonProperty("acteurRef")
    val acteurRef: String,

    val mandatRef: String
)


