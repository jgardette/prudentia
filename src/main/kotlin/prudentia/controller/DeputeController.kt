package prudentia.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import prudentia.json.ExportDepute
import prudentia.mapping.DeputeGetAllInfosMapping
import prudentia.mapping.DeputeGetAllSimpleInfoMapping
import prudentia.mapping.DeputeGetListMapping
import prudentia.model.Depute
import prudentia.model.DeputeList
import prudentia.model.DeputeSimple
import java.io.File

private val logger = KotlinLogging.logger {}

@RestController
class DeputeController {

    val JSON = jacksonObjectMapper()
    val file = File("src/main/files/AMO10_deputes_actifs_mandats_actifs_organes_XIV.json")
    val result = JSON.readValue<ExportDepute>(file)

    /** Get list of deputes */
    @RequestMapping("/deputes_simple")
    fun getDeputesSimpleInfo() : List<DeputeSimple> {
        logger.info { "Recherche députés simple" }
        return DeputeGetAllSimpleInfoMapping().mapDeputes(result.export.acteurs.acteur)
    }

    /** Get list of deputes */
    @RequestMapping("/deputes")
    fun getDeputes() : List<DeputeList> {
        logger.info { "Recherche list députés" }
        return DeputeGetListMapping().mapDeputes(result.export.acteurs.acteur)
    }

    /** Get one of deputes by code */
    @RequestMapping("/depute/{id}")
    fun getDepute(@PathVariable id: String) : Depute {
        logger.info { "Récupération d'1 député" }
        return DeputeGetAllInfosMapping().mapDeputes(result.export.acteurs.acteur).filter { it.uid == id }.get(0)
    }

    /** Get one of deputes by code */
    @RequestMapping("/deputes/search")
    fun getDeputeByMandatOrgane(@RequestParam organeLibelle: String) : List<Depute> {
        logger.info { "Recherche d'un député" }
        return DeputeGetAllInfosMapping().mapDeputes(result.export.acteurs.acteur).filter {
            it.mandats != null && it.mandats?.filter {
                it.libelleOrgane != null && it.libelleOrgane?.contains(organeLibelle) as Boolean
            }?.any() as Boolean
        }
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


