package prudentia.model

import java.util.*

data class DeputeSimple(
        var civilite: String?,
        var prenom: String?,
        var nom: String?,
        var dateNaissance: Date?,
        var villeNais: String?,
        var departementNaissance: String?,
        var paysNaissance: String?,
        var dateDeces: Date?,
        var professionLibelle: String?,
        var catSocPro: String?,
        var numberAdresses: Number?,
        var numberMandats: Number?

)