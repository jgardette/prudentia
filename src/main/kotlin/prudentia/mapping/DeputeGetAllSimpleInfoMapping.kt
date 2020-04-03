package prudentia.mapping

import prudentia.json.Adresse
import prudentia.json.InfoActeur
import prudentia.json.InfoMandat
import prudentia.json.InfosAdresse
import prudentia.model.Depute
import prudentia.model.DeputeSimple
import java.util.*

class DeputeGetAllSimpleInfoMapping {
    fun mapDeputes(acteur: InfoActeur): DeputeSimple {
        return mapDeputeSimpleInfo(acteur)
    }

    private fun mapDeputeSimpleInfo(acteur: InfoActeur): DeputeSimple {
        return DeputeSimple(
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
                acteur.adresses?.adresse?.size,
                acteur.mandats.infoMandat.size
        )
    }

}
