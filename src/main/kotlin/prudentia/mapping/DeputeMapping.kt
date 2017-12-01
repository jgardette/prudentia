package prudentia.mapping

import jdk.nashorn.internal.objects.NativeArray
import prudentia.json.InfoActeur
import prudentia.model.Depute

class DeputeMapping {
    fun mapDeputes(acteurs: List<InfoActeur>): List<Depute> {
        return acteurs.map { mapDeputeInfo(it) }
    }

    private fun mapDeputeInfo(acteur: InfoActeur): Depute {
        return Depute(
                acteur.etatCivil.ident.prenom,
                acteur.etatCivil.ident.nom
        )
    }
}