package prudentia.model

import java.util.*

data class DeputeList(
        val uid: String,
        val civilite: String?,
        val prenom: String?,
        val nom: String?,
        val dateNaissance: Date?,
        val professionLibelle: String?,
        val catSocPro: String?,
        val adresses: List<Adresse>?,
        val mandats: List<Mandat>?
)