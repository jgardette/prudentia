package prudentia.model

import java.util.*

data class DeputeRecherche(
        val uid: String,
        val civilite: String?,
        val prenom: String?,
        val nom: String?,
        val dateNaissance: Date?,
        val villeNais: String?,
        val departementNaissance: String?,
        val paysNaissance: String?,
        val professionLibelle: String?,
        val catSocPro: String?,
        var numberAdresses: Number?,
        var numberMandats: Number?

)
