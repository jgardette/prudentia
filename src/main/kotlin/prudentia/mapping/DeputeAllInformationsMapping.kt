package prudentia.mapping

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import prudentia.json.*
import prudentia.model.Depute
import java.io.File
import java.util.*

class DeputeAllInformationsMapping {
    val JSON = jacksonObjectMapper()
    val file = File("src/main/files/AMO10_deputes_actifs_mandats_actifs_organes_XIV.json")
    var result = JSON.readValue<ExportOrgane>(file)

    fun mapDeputes(acteurs: List<InfoActeur>): List<Depute> {
        return acteurs.map { mapDeputeInfo(it) }
    }

    private fun mapDeputeInfo(acteur: InfoActeur): Depute {
        return Depute(
                acteur.uid.id,
                acteur.etatCivil.ident.civilite,
                acteur.etatCivil.ident.prenom,
                acteur.etatCivil.ident.nom,
                acteur.etatCivil.infoNaissance?.dateNaissance,
                FormatUtil.returnDisplayString(acteur.etatCivil.infoNaissance?.villeNaissance),
                FormatUtil.returnDisplayString(acteur.etatCivil.infoNaissance?.departementNaissance),
                acteur.etatCivil.infoNaissance?.paysNaissance,
                FormatUtil.returnDisplayString(acteur.profession.professionLibelle),
                FormatUtil.returnDisplayString(acteur.profession.infoProfessionInsee?.catSocPro),
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
        //val JSON = jacksonObjectMapper()
        //val file = File("src/main/files/AMO10_deputes_actifs_mandats_actifs_organes_XIV.json")
        //val result = JSON.readValue<ExportOrgane>(file)
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
