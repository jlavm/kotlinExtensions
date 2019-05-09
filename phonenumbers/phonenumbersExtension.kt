//Format a mobile number
fun String?.formatMobileLinePrefix(): String? {
    if (this == null) {
        return null
    }
    val f = this.replace(" ", "")
    return try {
        this.toLong()//check if number

        val f1 = if (f.length > 3) f.substring(f.length - 3, f.length) else f
        val f2 = if (f.length > 6) f.substring(f.length - 6, f.length - 3) else f.substring(0, f.length - 3)
        val f3 = if (f.length > 9) f.substring(f.length - 9, f.length - 6) else f.substring(0, f.length - 6)
        val f4 = if (f.length > 9) "+" + f.substring(0, f.length - 9) else ""
        "$f4 $f3 $f2 $f1".trim { it <= ' ' }
    } catch (e: Exception) {
        this
    }
}

//Format a phone number
fun String?.formatPhoneLinePrefix(): String? {
    if (this == null) {
        return null
    }
    val f = this.replace(" ", "")
    return try {
        this.toLong()//check if number
        val f1 = if (f.length > 2) f.substring(f.length - 2, f.length) else f
        val f2 = if (f.length > 4) f.substring(f.length - 4, f.length - 2) else f.substring(0, f.length - 2)
        val f3 = if (f.length > 6) f.substring(f.length - 6, f.length - 4) else f.substring(0, f.length - 4)
        val f4 = if (f.length > 6) f.substring(0, f.length - 6) else ""
        "$f4 $f3 $f2 $f1".trim { it <= ' ' }
    } catch (e: Exception) {
        this
    }
}