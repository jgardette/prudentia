package prudentia.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import prudentia.model.Depute
import java.io.File



@RestController
class DeputeController {
    /** Get list of deputes */
    @RequestMapping("/deputes")
    fun getDeputes() : String {
        val JSON = jacksonObjectMapper()
        val file = File("src/main/files/AMO10_deputes_actifs_mandats_actifs_organes_XIV.json")
        val myList = JSON.readValue<List<Depute>>(file)
        return myList.toString()
    }


    /** Cause an error to occur */
    @RequestMapping("/raiseError")
    fun raiseError() {
        throw IllegalArgumentException("This shouldn't have happened")
    }

    /** Handle the error */
    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun handleError(e: IllegalArgumentException) = e.message
}


