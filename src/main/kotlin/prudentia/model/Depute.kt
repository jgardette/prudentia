package prudentia.model

import java.util.*

data class Depute(
        var uid: String,
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
        var adresses: List<Adresse>?,
        var mandats: List<Mandat>?
)