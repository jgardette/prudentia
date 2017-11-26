package prudentia.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class DeputeController {
    /** Get list of deputes */
    @RequestMapping("/deputes")
    fun getDeputes() : String {
        return ""
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


