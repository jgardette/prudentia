package prudentia.mapping

import prudentia.json.Adresse
import prudentia.json.InfoActeur
import prudentia.json.InfoMandat
import prudentia.json.InfosAdresse
import prudentia.model.Depute
import java.util.*

class DeputeGetAllInfosMapping {
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
                acteur.etatCivil.infoNaissance?.villeNais,
                acteur.etatCivil.infoNaissance?.departementNaissance,
                acteur.etatCivil.infoNaissance?.paysNaissance,
                acteur.etatCivil.dateDeces,
                acteur.profession.professionLibelle,
                acteur.profession.infoProfessionInsee?.catSocPro,
                mapDeputeAdresses(acteur.adresses.adresse),
                mapDeputeMandats(acteur.mandats.infoMandat)
        )
    }

    private fun mapDeputeAdresses(adresses: List<InfosAdresse>): List<prudentia.model.Adresse> {
        return adresses.map { mapAdresse(it) }
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
        return prudentia.model.Mandat(
                infoMandat.uid,
                infoMandat.acteurRef,
                infoMandat.dateDebut,
                infoMandat.dateFin,
                infoMandat.election?.causeMandat,
                infoMandat.election?.lieu?.numDepartement,
                infoMandat.election?.lieu?.departement,
                infoMandat.election?.lieu?.region
        )
    }
}
