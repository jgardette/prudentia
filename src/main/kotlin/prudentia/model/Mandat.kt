package prudentia.model

import java.util.*

data class Mandat(
        var uid: String?,
        var acteurRef: String?,
        var dateDebut: Date?,
        var dateFin: Date?,
        var causeMandat: String?,
        var numDepartementMandat: String?,
        var departementMandat: String?,
        var regionMandat: String?
)