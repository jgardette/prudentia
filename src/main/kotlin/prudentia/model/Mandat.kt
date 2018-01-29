package prudentia.model

import java.util.*

data class Mandat(
        val uid: String?,
        val acteurRef: String?,
        val dateDebut: Date?,
        val dateFin: Date?,
        val causeMandat: String?,
        val numDepartementMandat: String?,
        val departementMandat: String?,
        val regionMandat: String?,
        val uidOrgane: String?,
        val codeTypeOrgane: String?,
        val libelleOrgane: String?,
        val libelleAbregeOrgane: String?
)