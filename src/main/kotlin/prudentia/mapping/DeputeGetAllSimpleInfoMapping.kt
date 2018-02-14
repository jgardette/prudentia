package prudentia.mapping

import prudentia.json.Adresse
import prudentia.json.InfoActeur
import prudentia.json.InfoMandat
import prudentia.json.InfosAdresse
import prudentia.model.Depute
import prudentia.model.DeputeSimple
import java.util.*

class DeputeGetAllSimpleInfoMapping {
    fun mapDeputes(acteurs: List<InfoActeur>): List<DeputeSimple> {
        return acteurs.map { mapDeputeSimpleInfo(it) }
    }

    private fun mapDeputeSimpleInfo(acteur: InfoActeur): DeputeSimple {
        return DeputeSimple(
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
                acteur.adresses?.adresse?.size,
                acteur.mandats.infoMandat.size
        )
    }

}
