package prudentia.json

import com.fasterxml.jackson.annotation.*
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.exc.MismatchedInputException
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

// @JsonIgnoreProperties(ignoreUnknown = true)
// data class ExportDepute(
//         @JsonProperty("export")
//         val export: Acteurs
// )

// @JsonIgnoreProperties(ignoreUnknown = true)
// data class Acteurs(
//         @JsonProperty("acteurs")
//         @JsonProperty("acteurs")
//         val acteurs: Acteur
// )

@JsonIgnoreProperties(ignoreUnknown = true)
data class Acteur(
        @JsonProperty("acteur")
        val infos: InfoActeur
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class InfoActeur(
        @JsonProperty("adresses")
        val adresses: Adresse?,

        @JsonProperty("etatCivil")
        val etatCivil: EtatCivil,

        @JsonProperty("mandats")
        val mandats: Mandats,

        @JsonProperty("profession")
        val profession: Profession,

        @JsonProperty("uid")
        val uid: UidDepute
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class UidDepute(
        @JsonProperty("#text")
        val id: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class EtatCivil(
        @JsonProperty("ident")
        val ident: Identite,

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
        val professionLibelle: Any?,

        @JsonProperty("socProcINSEE")
        val infoProfessionInsee: InfoProfessionInsee?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class InfoProfessionInsee(
        @JsonProperty("catSocPro")
        val catSocPro: Any?,

        @JsonProperty("famSocPro")
        val famSocPro: Any?
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
        val election: Election?,

        @JsonProperty("organes")
        val organes: Organes?

//FIXME : Suppleants ko pour le 418 acteur
        //@JsonProperty("suppleants")
        //val suppleants: Suppleant?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Organes(
        @JsonProperty("organeRef")
        @JsonFormat(with = arrayOf(JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY))
        val organeRef: List<String>?
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
data class InfoNaissance (
        @JsonProperty("dateNais")
        val dateNaissance: Date?,

        @JsonProperty("villeNais")
        val villeNaissance: Any?,


        @JsonProperty("depNais")
        val departementNaissance: Any?,

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
        @JsonFormat(with = arrayOf(JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY))
        val adresse: List<InfosAdresse>?
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
