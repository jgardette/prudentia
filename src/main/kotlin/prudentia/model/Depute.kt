package prudentia.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class Export(
        @JsonProperty("export")
        val export: Acteurs
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Acteurs(
        @JsonProperty("acteurs")
        val acteurs: Acteur
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Acteur(
        @JsonProperty("acteur")
        val acteur: List<InfoActeur>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class InfoActeur(
        @JsonProperty("adresses")
        val adresses: Adresse,

        @JsonProperty("etatCivil")
        val etatCivil: EtatCivil,

        @JsonProperty("mandats")
        val mandats: Mandats

)

@JsonIgnoreProperties(ignoreUnknown = true)
data class EtatCivil(
        @JsonProperty("ident")
        val ident: Identite,

        @JsonProperty("dateDeces")
        val dateDeces: Date?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Mandats(
        @JsonProperty("mandat")
        val infoMandat: List<InfoMandat>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class InfoMandat(
        @JsonProperty("uid")
        val uid: String?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class InfoNaissance(
        @JsonProperty("dateNais")
        val dateNaissance: String?,

        @JsonProperty("depNais")
        val departementNaissance: String?,

        @JsonProperty("villeNais")
        val villeNais: String?,

        @JsonProperty("paysNais")
        val paysNaissance: String?
)


@JsonIgnoreProperties(ignoreUnknown = true)
data class Identite(
        @JsonProperty("civ")
        val civ: String?,

        @JsonProperty("prenom")
        val prenom: String?,

        @JsonProperty("nom")
        val nom: String?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Adresse(
        @JsonProperty("adresse")
        val adresse: List<InfosAdresse>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class InfosAdresse(
        @JsonProperty("codePostal")
        val codePostal: String?,

        @JsonProperty("intitule")
        val intitule: String?,

        @JsonProperty("numeroRue")
        val numeroRue: String?,

        @JsonProperty("nomRue")
        val nomRue: String?,

        @JsonProperty("ville")
        val ville: String?
        )