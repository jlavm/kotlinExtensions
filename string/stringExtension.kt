fun String?.sameObject(text: String?): Boolean {
    return this.isNullOrEmpty() && text.isNullOrEmpty() ||
            this.equals(text)
}

//Format String in TitleCase
fun String.toTitleCase(): String {
    val titleCase = StringBuilder()
    var nextTitleCase = true
    for (c in this.toCharArray()) {
        var title = c
        if (Character.isSpaceChar(title)) {
            nextTitleCase = true
        } else if (nextTitleCase) {
            title = Character.toTitleCase(title)
            nextTitleCase = false
        }
        titleCase.append(title)
    }
    return titleCase.toString()
}

//Convert a base64 String to Bitmap
fun String?.convertBase64ToBitmap(): Bitmap? {
    if (this != null) {
        val decodedString = Base64.decode(this, Base64.DEFAULT)
        return if (decodedString != null) {
            BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
        } else {
            null
        }
    }
    return null
}

//Convert empty or null strings to null
fun String.normalizeToNull(): String? = if (this.isBlank() || this.isEmpty()) null else this


//Convert string to charsequence
fun String?.fromStringToCharSequence(): CharSequence =
    this?.let { StringBuilder().append(it) } ?: ""

//Remove spaces from given string
fun String?.removeAllWhiteSpaces(): String? = this?.replace("\\s".toRegex(), "")