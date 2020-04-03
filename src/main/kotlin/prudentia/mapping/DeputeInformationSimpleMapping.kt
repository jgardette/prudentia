package prudentia.mapping

import prudentia.json.InfoActeur
import prudentia.model.DeputeRecherche

class DeputeInformationSimpleMapping {
    fun mapDeputes(acteur: InfoActeur): DeputeRecherche {
        return mapDeputeSimpleInfo(acteur)
    }

    private fun mapDeputeSimpleInfo(acteur: InfoActeur): DeputeRecherche {
        return DeputeRecherche(
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
