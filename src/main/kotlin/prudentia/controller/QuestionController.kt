package prudentia.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired
import prudentia.service.QuestionService
import java.io.File
import prudentia.json.ExportQuestionsOralesSansDebat

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/question")
class QuestionController {
    
    @Autowired
    lateinit var questionService: QuestionService

    /** Get list of qustion*/
    @GetMapping("/numberByDepute")
    fun getNumberOfQuestionByDepute(@RequestParam("acteurRef") acteurRef: String) : Number {
        logger.info { "Recherche le nombre de questions pour un depute" }
        return  questionService.getNumberOfQuestionByDepute(acteurRef)
    }
}


