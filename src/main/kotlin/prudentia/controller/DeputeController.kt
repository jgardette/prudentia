package prudentia.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import prudentia.json.Acteur
import prudentia.mapping.DeputeInformationSimpleMapping
import prudentia.model.DeputeRecherche
import java.io.File

private val logger = KotlinLogging.logger {}

@RestController
class DeputeController {

    var deputesList = setDeputesList()

    fun setDeputesList() : List<Acteur> {
        var result = listOf<Acteur>()
        val JSON = jacksonObjectMapper()

        File("src/main/files/deputes").listFiles().forEach {
            result = result.plus(JSON.readValue<Acteur>(it))
        }
        return result
    }

    fun setOrganesList() {

    }

    /** Get list of deputes */
    @RequestMapping("/deputes")
    fun getDeputesSimpleInfo() : List<DeputeRecherche> {
        logger.info { "Recherche de l'ensemble des deputes" }
        var result = listOf<DeputeRecherche>()
        deputesList.forEach {
            result += DeputeInformationSimpleMapping().mapDeputes(it.infos)
        }
        return result
    }

/*
    /** Get one of deputes by code */
    @RequestMapping("/depute/{id}")
    fun getDepute(@PathVariable id: String) : Depute {
        logger.info { "Récupération d'1 député" }
        return DeputeGetAllInfosMapping().mapDeputes(deputesList).filter { it.uid == id }.get(0)
    }

    /** Get one of deputes by code */
    @RequestMapping("/deputes/search")
    fun getDeputeByMandatOrgane(@RequestParam organeLibelle: String) : List<Depute> {
        logger.info { "Recherche d'un député" }
        return DeputeGetAllInfosMapping().mapDeputes(deputesList).filter {
            it.mandats != null && it.mandats?.filter {
                it.libelleOrgane != null && it.libelleOrgane?.contains(organeLibelle) as Boolean
            }?.any() as Boolean
        }
    }
 */

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


