package prudentia.mapping

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import prudentia.json.*
import prudentia.model.Depute
import prudentia.model.DeputeList
import java.io.File
import java.util.*

class DeputeGetListMapping {
    val JSON = jacksonObjectMapper()
    val file = File("src/main/files/AMO10_deputes_actifs_mandats_actifs_organes_XIV.json")
    var result = JSON.readValue<ExportOrgane>(file)

    fun mapDeputes(acteurs: List<InfoActeur>): List<DeputeList> {
        return acteurs.map { mapDeputeInfo(it) }
    }

    private fun mapDeputeInfo(acteur: InfoActeur): DeputeList {
        return DeputeList(
                acteur.uid.id,
                acteur.etatCivil.ident.civilite,
                acteur.etatCivil.ident.prenom,
                acteur.etatCivil.ident.nom,
                acteur.etatCivil.infoNaissance?.dateNaissance,
                acteur.profession.professionLibelle,
                acteur.profession.infoProfessionInsee?.catSocPro,
                mapDeputeAdresses(acteur.adresses?.adresse),
                mapDeputeMandats(acteur.mandats.infoMandat)
        )
    }

    private fun mapDeputeAdresses(adresses: List<InfosAdresse>?): List<prudentia.model.Adresse>? {
        return adresses?.map { mapAdresse(it) }
    }

    private fun mapAdresse(infoAdresse: InfosAdresse): prudentia.model.Adresse {
        return prudentia.model.Adresse(
                infoAdresse.intitule,
                infoAdresse.numeroRue,
                infoAdresse.nomRue,
                infoAdresse.codePostal,
                infoAdresse.ville,
                infoAdresse.valeurElectronique,
                infoAdresse.numeroTelephone
        )
    }

    private fun mapDeputeMandats(mdts: List<InfoMandat>): List<prudentia.model.Mandat> {
        return mdts.map { mapMandat(it) }
    }

    private fun mapMandat(infoMandat: InfoMandat): prudentia.model.Mandat {
        var infoOrgane: InfoOrgane = result.export.organes.infoOrgane.filter { it.uid == infoMandat.organes?.organeRef?.get(0) }.get(0)

        return prudentia.model.Mandat(
                infoMandat.uid,
                infoMandat.acteurRef,
                infoMandat.dateDebut,
                infoMandat.dateFin,
                infoMandat.election?.causeMandat,
                infoMandat.election?.lieu?.numDepartement,
                infoMandat.election?.lieu?.departement,
                infoMandat.election?.lieu?.region,
                infoOrgane.uid,
                infoOrgane.codeType,
                infoOrgane.libelle,
                infoOrgane.libelleAbrege
        )
    }
}
