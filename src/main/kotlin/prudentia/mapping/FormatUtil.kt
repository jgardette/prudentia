package prudentia.mapping

object FormatUtil{
    fun returnDisplayString(obj : Any?) : String {
        if (!obj.toString().startsWith("{@")) {
            return obj.toString()
        } else {
            return ""
        }
    }
}
