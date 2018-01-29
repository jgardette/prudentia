package prudentia.model

import java.util.*

data class Depute(
        val uid: String,
        val civilite: String?,
        val prenom: String?,
        val nom: String?,
        val dateNaissance: Date?,
        val villeNais: String?,
        val departementNaissance: String?,
        val paysNaissance: String?,
        val dateDeces: Date?,
        val professionLibelle: String?,
        val catSocPro: String?,
        val adresses: List<Adresse>?,
        val mandats: List<Mandat>?
)