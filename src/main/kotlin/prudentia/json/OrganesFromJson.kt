package prudentia.json

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class ExportOrgane(
        @JsonProperty("export")
        val export: ListOrganes
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ListOrganes(
        @JsonProperty("organes")
        val organes: Organe
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Organe(
        @JsonProperty("organe")
        val infoOrgane: List<InfoOrgane>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class InfoOrgane(
        @JsonProperty("uid")
        val uid: String?,

        @JsonProperty("codeType")
        val codeType: String?,

        @JsonProperty("libelle")
        val libelle: String?,

        @JsonProperty("libelleAbrege")
        val libelleAbrege: String?
)
