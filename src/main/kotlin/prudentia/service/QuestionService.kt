package prudentia.service

import org.springframework.stereotype.Service
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import prudentia.service.QuestionService
import java.io.File
import prudentia.json.ExportQuestionsOralesSansDebat

private val logger = KotlinLogging.logger {}

@Service
class QuestionService {

    val JSON = jacksonObjectMapper()
    val file = File("src/main/files/Questions_orales_sans_debat_XIV.json")
    val rawData = JSON.readValue<ExportQuestionsOralesSansDebat>(file)
    
    fun getNumberOfQuestionByDepute(acteurRef: String): Number {
        logger.info { "getting number of question for depute ${acteurRef} " }
        return rawData.questionsOralesSansDebat.question.filter { it.auteur.identite.acteurRef == acteurRef}.size
    }

}