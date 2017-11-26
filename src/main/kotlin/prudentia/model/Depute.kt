package prudentia.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

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
        val acteur: List<Adresses>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Adresses(
        @JsonProperty("adresses")
        val adresses: Adresse,

        @JsonProperty("etatCivil")
        val etatCivil: EtatCivil
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class EtatCivil(
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