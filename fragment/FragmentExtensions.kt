import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

enum class AnimationsActivities {
    NONE,
    FADE,
    SLIDE_HORIZONTAL,
    SLIDE_HORIZONTAL_INVERTED,
    SLIDE_VERTICAL,
    SLIDE_VERTICAL_INVERTED,
    ZOOM,
    SCALE
}

inline fun FragmentManager.inTransaction(
    type: Int,
    func: FragmentTransaction.() -> FragmentTransaction
) {
    when (type) {
        0 -> beginTransaction().func().commit()
        else -> beginTransaction().func().commitNow()
    }
}
fun Fragment.addFragment(type: Int, frameId: Int, fragment: Fragment, tag: String?) {
    childFragmentManager.inTransaction(type) {
        add(
            frameId,
            fragment,
            tag ?: fragment.javaClass.simpleName
        )
    }
}
fun Fragment.replaceFragment(type: Int, frameId: Int, fragment: Fragment, tag: String?) {
    childFragmentManager.inTransaction(type) {
        replace(
            frameId,
            fragment,
            tag ?: fragment.javaClass.simpleName
        )
    }
}
inline fun <reified T : Activity> Fragment.goToActivity(
    clear: Boolean = true,
    animation: AnimationsActivities = AnimationsActivities.SLIDE_HORIZONTAL,
    init: Intent.() -> Unit = {}
) {
    val intent = Intent(this.context, T::class.java)
    if (clear) {
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    intent.init()
    startActivity(intent)
    when (animation) {
        AnimationsActivities.FADE -> this.activity?.overridePendingTransition(
            android.R.anim.fade_in,
            android.R.anim.fade_out
        )
        AnimationsActivities.SLIDE_HORIZONTAL -> this.activity?.overridePendingTransition(
            R.anim.right_in,
            R.anim.left_out
        )
        AnimationsActivities.SLIDE_HORIZONTAL_INVERTED -> this.activity?.overridePendingTransition(
            R.anim.left_in,
            R.anim.right_out
        )
        AnimationsActivities.SLIDE_VERTICAL -> this.activity?.overridePendingTransition(
            R.anim.slide_down_in,
            R.anim.slide_up_out
        )
        AnimationsActivities.SLIDE_VERTICAL_INVERTED -> this.activity?.overridePendingTransition(
            R.anim.slide_up_in,
            R.anim.slide_down_out
        )
        AnimationsActivities.ZOOM -> this.activity?.overridePendingTransition(
            R.anim.zoom_in,
            R.anim.zoom_out
        )
        AnimationsActivities.SCALE -> this.activity?.overridePendingTransition(
            R.anim.scale_in,
            R.anim.scale_out
        )
        AnimationsActivities.NONE -> {
            // Nothing to implement.
        }
    }
}
inline fun <reified T : Activity> Fragment.goToActivityResult(
    requestCode: Int,
    animation: AnimationsActivities = AnimationsActivities.SLIDE_HORIZONTAL,
    init: Intent.() -> Unit = {}
) {
    val intent = Intent(this.context, T::class.java)
    intent.init()
    startActivityForResult(intent, requestCode)
    when (animation) {
        AnimationsActivities.FADE -> this.activity?.overridePendingTransition(
            android.R.anim.fade_in, android.R.anim.fade_out
        )
        AnimationsActivities.SLIDE_HORIZONTAL -> this.activity?.overridePendingTransition(
            R.anim.right_in,
            R.anim.left_out
        )
        AnimationsActivities.SLIDE_HORIZONTAL_INVERTED -> this.activity?.overridePendingTransition(
            R.anim.left_in,
            R.anim.right_out
        )
        AnimationsActivities.SLIDE_VERTICAL -> this.activity?.overridePendingTransition(
            R.anim.slide_down_in,
            R.anim.slide_up_out
        )
        AnimationsActivities.SLIDE_VERTICAL_INVERTED -> this.activity?.overridePendingTransition(
            R.anim.slide_up_in,
            R.anim.slide_down_out
        )
        AnimationsActivities.ZOOM -> this.activity?.overridePendingTransition(
            R.anim.zoom_in,
            R.anim.zoom_out
        )
        AnimationsActivities.SCALE -> this.activity?.overridePendingTransition(
            R.anim.scale_in,
            R.anim.scale_out
        )
        AnimationsActivities.NONE -> {
            // Nothing to implement.
        }
    }
}