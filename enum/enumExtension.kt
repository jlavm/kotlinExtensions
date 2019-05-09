import java.security.SecureRandom

inline fun <reified T: Enum<T>> enumValueOfNullable(name: String?) : T? {
    return try {
        if (name.isNullOrEmpty()) {
            null
        } else {
            enumValueOf<T>(name)
        }
    } catch (e: Exception) {
        null
    }
}

inline fun <reified T: Enum<T>> enumRandom() : T {
    val enumValues = enumValues<T>()
    return enumValues[SecureRandom().nextInt(enumValues.size)]
}