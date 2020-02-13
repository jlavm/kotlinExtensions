import java.text.SimpleDateFormat
import java.util.*


/**
 * Pattern: yyyy-MM-dd HH:mm:ss
 */
fun Date.formatToServerDateTimeDefaults(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    return sdf.format(this)
}

fun Date.formatToTruncatedDateTime(): String {
    val sdf = SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault())
    return sdf.format(this)
}

/**
 * Pattern: yyyy-MM-dd
 */
fun Date.formatToServerDateDefaults(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return sdf.format(this)
}

/**
 * Pattern: HH:mm:ss
 */
fun Date.formatToServerTimeDefaults(): String {
    val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    return sdf.format(this)
}

/**
 * Pattern: dd/MM/yyyy HH:mm:ss
 */
fun Date.formatToViewDateTimeDefaults(): String =
    SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(this)

/**
 * Pattern: dd/MM/yyyy
 */
fun Date.formatToViewDateDefaults(): String =
    SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(this)

/**
 * Pattern: HH:mm:ss
 */
fun Date.formatToViewTimeDefaults(): String =
    SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(this)

/**
 * Add field date to current date
 */
fun Date.add(field: Int, amount: Int): Date {
    val cal = Calendar.getInstance()
    cal.time = this
    cal.add(field, amount)

    this.time = cal.time.time

    cal.clear()

    return this
}

fun Date.addYears(years: Int): Date = add(Calendar.YEAR, years)

fun Date.addMonths(months: Int): Date = add(Calendar.MONTH, months)

fun Date.addDays(days: Int): Date = add(Calendar.DAY_OF_MONTH, days)

fun Date.addHours(hours: Int): Date = add(Calendar.HOUR_OF_DAY, hours)

fun Date.addMinutes(minutes: Int): Date = add(Calendar.MINUTE, minutes)

fun Date.addSeconds(seconds: Int): Date = add(Calendar.SECOND, seconds)
