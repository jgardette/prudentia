package prudentia.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import prudentia.json.Export
import prudentia.mapping.DeputeGetAllInfosMapping
import prudentia.mapping.DeputeGetAllSimpleInfoMapping
import prudentia.model.Depute
import prudentia.model.DeputeSimple
import java.io.File



@RestController
class DeputeController {
    /** Get list of deputes */
    @RequestMapping("/deputes_simple")
    fun getDeputesSimpleInfo() : List<DeputeSimple> {
        val JSON = jacksonObjectMapper()
        val file = File("src/main/files/AMO10_deputes_actifs_mandats_actifs_organes_XIV.json")
        val result = JSON.readValue<Export>(file)
        return DeputeGetAllSimpleInfoMapping().mapDeputes(result.export.acteurs.acteur)
    }

    /** Get list of deputes */
    @RequestMapping("/deputes")
    fun getDeputes() : List<Depute> {
        val JSON = jacksonObjectMapper()
        val file = File("src/main/files/AMO10_deputes_actifs_mandats_actifs_organes_XIV.json")
        val result = JSON.readValue<Export>(file)
        return DeputeGetAllInfosMapping().mapDeputes(result.export.acteurs.acteur)
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


