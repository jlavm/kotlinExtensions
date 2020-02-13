import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


/**
 * Input: milliseconds
 * Pattern: HH:mm
 */
fun Long.simpleTimeFromMilliseconds(): String {
    val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    val date = Calendar.getInstance()
    date.timeInMillis = this
    return dateFormat.format(date.timeInMillis)
}

/**
 * Input: milliseconds
 * Pattern: HH:mm:ss
 */
fun Long.timefromMilliseconds(): String {
    val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    val date = Calendar.getInstance()
    date.timeInMillis = this
    return dateFormat.format(date.timeInMillis)
}

/**
 * Input: milliseconds
 * Pattern: dd/MM/yyyy
 */
fun Long.datefromMilliseconds(): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val date = Calendar.getInstance()
    date.timeInMillis = this
    return dateFormat.format(date.timeInMillis)
}

/**
 * Input: milliseconds
 * Pattern: dd/MM/yyyy HH:mm:ss
 */
fun Long.dateTimefromMilliseconds(): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
    val date = Calendar.getInstance()
    date.timeInMillis = this
    return dateFormat.format(date.timeInMillis)
}

/**
 * Input: hoursToAdd
 */
fun Int.timeInMillisecondsPlusHours(millisecond: Long): String {
    val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    val date = Calendar.getInstance()
    date.timeInMillis = this + millisecond
    date.add(Calendar.HOUR, this)
    return dateFormat.format(date.timeInMillis)
}

/**
 * Input: secondsToAdd
 */
fun Int.todayInMillisecondsPlusSeconds(): Long {
    val today = Date()
    val date = Calendar.getInstance()
    date.timeInMillis = today.time
    date.add(Calendar.SECOND, this)
    return date.timeInMillis
}

/**
 * Input: daysToSubstract
 */
fun Int.todayMinusDays(): Long {
    val today = Date()
    val date = Calendar.getInstance()
    date.timeInMillis = today.time
    date.add(Calendar.DAY_OF_MONTH, -this)
    return date.timeInMillis
}

/**
 * Input: monthsToSubstract
 */
fun Int.todayMinusMonths(): Long {
    val today = Date()
    val date = Calendar.getInstance()
    date.timeInMillis = today.time
    date.add(Calendar.MONTH, -this)
    return date.timeInMillis
}

/**
 * Input: monthsToAdd
 */
fun Int.todayPlusMonths(): Long {
    val today = Date()
    val date = Calendar.getInstance()
    date.timeInMillis = today.time
    date.add(Calendar.MONTH, this)
    return date.timeInMillis
}

/**
 * Input: minutesToAdd
 */
fun Int.timeInSecondsPlusMinutes(date: Date): Long {
    val datePlusMinutes = Calendar.getInstance()
    datePlusMinutes.timeInMillis = date.time
    datePlusMinutes.add(Calendar.MINUTE, this)
    return datePlusMinutes.timeInMillis / 1000
}

/**
 * Input: monthsToAdd
 */
fun Int.todayPlusMonthsDifferenceInDays(date: Long): Long {
    val today = Date()
    val end = Calendar.getInstance()
    end.timeInMillis = date
    end.add(Calendar.MONTH, this)
    val difference = end.timeInMillis - today.time
    return TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS)
}

/**
 * Input: dateToFormat
 */
fun String.millisecondsfromFormatDMY(): Long {
    return try {
        val day = Integer.parseInt(this.substring(0, 2))
        val month = Integer.parseInt(this.substring(3, 5))
        val year = Integer.parseInt(this.substring(6, 10))
        val dateToFormatConverted = GregorianCalendar(year, month - 1, day)
        dateToFormatConverted.timeInMillis
    } catch (e: IndexOutOfBoundsException) {
        0
    }
}