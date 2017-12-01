package prudentia.json

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
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
        val mandats: Mandats,

        @JsonProperty("profession")
        val profession: Profession
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class EtatCivil(
        @JsonProperty("ident")
        val ident: Identite,

        @JsonProperty("dateDeces")
        val dateDeces: Date?,

        @JsonProperty("infoNaissance")
        val infoNaissance: InfoNaissance?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Mandats(
        @JsonProperty("mandat")
        val infoMandat: List<InfoMandat>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Profession(
        @JsonProperty("libelleCourant")
        val professionLibelle: String?,

        @JsonProperty("socProcINSEE")
        val infoProfessionInsee: InfoProfessionInsee?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class InfoProfessionInsee(
        @JsonProperty("catSocPro")
        val catSocPro: String?,

        @JsonProperty("famSocPro")
        val famSocPro: String?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class InfoMandat(
        @JsonProperty("uid")
        val uid: String?,

        @JsonProperty("acteurRef")
        val acteurRef: String?,

        @JsonProperty("dateDebut")
        val dateDebut: Date?,

        @JsonProperty("dateFin")
        val dateFin: Date?,

        @JsonProperty("election")
        val election: Election?

        //FIX%E : Suppleants ko pour le 418 acteur
        //@JsonProperty("suppleants")
        //val suppleants: Suppleant?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Suppleant(
        @JsonProperty("suppleant")
        val infoSuppleant: InfoSuppleant?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class InfoLieuMandat(
        @JsonProperty("departement")
        val departement: String?,

        @JsonProperty("region")
        val region: String?,

        @JsonProperty("numDepartement")
        val numDepartement: String?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class InfoSuppleant(
        @JsonProperty("dateDebut")
        val dateDebut: Date?,

        @JsonProperty("dateFin")
        val dateFin: Date?,

        @JsonProperty("suppleantRef")
        val suppleantRef: String?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Election(
        @JsonProperty("causeMandat")
        val causeMandat: String?,

        @JsonProperty("lieu")
        val lieu: InfoLieuMandat?
)


@JsonIgnoreProperties(ignoreUnknown = true)
data class InfoNaissance(
        @JsonProperty("dateNais")
        val dateNaissance: Date?,

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
        val civilite: String?,

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
        val ville: String?,

        @JsonProperty("valElec")
        val valeurElectronique: String?,

        @JsonProperty("numeroTelephone")
        val numeroTelephone: String?
)