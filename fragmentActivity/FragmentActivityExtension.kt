import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

enum class TransactionAnimation {
    PUSH_FRAGMENT,
    PUSH_FRAGMENT_AND_FADE,
    PUSH_MODAL
}


inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun AppCompatActivity.addFragment(
    fragment: Fragment,
    frameId: Int,
    tag: String?,
    animation: TransactionAnimation?
) {
    supportFragmentManager.inTransaction {
        if (animation != null) this.getAnimation(animation)
        add(
            frameId,
            fragment,
            tag ?: fragment.javaClass.simpleName
        )
    }
}

fun AppCompatActivity.addFragment(
    fragment: Fragment,
    frameId: Int,
    tag: String?,
    addToStack: Boolean,
    animation: TransactionAnimation?
) {
    supportFragmentManager.inTransaction {
        if (animation != null) this.getAnimation(animation)
        if (addToStack) add(frameId, fragment, tag ?: fragment.javaClass.simpleName)
            .addToBackStack(tag ?: fragment.javaClass.simpleName)
        else add(frameId, fragment)
    }
}


fun AppCompatActivity.replaceFragment(
    fragment: Fragment,
    frameId: Int,
    tag: String?,
    animation: TransactionAnimation?
) {
    supportFragmentManager.inTransaction {
        if (animation != null) this.getAnimation(animation)
        replace(
            frameId,
            fragment,
            tag ?: fragment.javaClass.simpleName
        )
    }
}

fun AppCompatActivity.replaceFragment(
    fragment: Fragment,
    frameId: Int,
    tag: String?,
    addToStack: Boolean,
    animation: TransactionAnimation?
) {
    supportFragmentManager.inTransaction {
        if (animation != null) this.getAnimation(animation)
        if (addToStack) replace(frameId, fragment, tag ?: fragment.javaClass.simpleName)
            .addToBackStack(tag ?: fragment.javaClass.simpleName)
        else
            replace(frameId, fragment, tag ?: fragment.javaClass.simpleName)
    }
}

fun AppCompatActivity.replaceFragment(
    fragment: Fragment,
    frameId: Int,
    tag: String?,
    addToStack: Boolean,
    clearBackStack: Boolean,
    animation: TransactionAnimation?
) {
    supportFragmentManager.inTransaction {
        if (animation != null) this.getAnimation(animation)
        if (clearBackStack && supportFragmentManager.backStackEntryCount > 0) {
            val first = supportFragmentManager.getBackStackEntryAt(0)
            supportFragmentManager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        if (addToStack) replace(frameId, fragment, tag ?: fragment.javaClass.simpleName)
            .addToBackStack(fragment.javaClass.simpleName)
        else
            replace(frameId, fragment, tag ?: fragment.javaClass.simpleName)
    }
}

fun AppCompatActivity.popBackStack() {
    supportFragmentManager.popBackStack()
}

fun AppCompatActivity.popBackStackInclusive() {
    if (supportFragmentManager.backStackEntryCount > 0)
        supportFragmentManager.popBackStack(
            supportFragmentManager.getBackStackEntryAt(0).id,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
}

fun AppCompatActivity.getCurrentFragment(tag: String?): Fragment? {
    val fragmentManager = supportFragmentManager
    var fragmentTag: String = tag ?: ""

    if (fragmentTag.isEmpty() && fragmentManager.backStackEntryCount > 0)
        fragmentTag =
            fragmentManager.getBackStackEntryAt(fragmentManager.backStackEntryCount - 1).name ?: ""

    return fragmentManager.findFragmentByTag(fragmentTag)
}