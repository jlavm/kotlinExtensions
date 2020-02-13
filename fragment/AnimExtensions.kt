import androidx.fragment.app.FragmentTransaction

enum class TransactionAnimation {
    PUSH_FRAGMENT,
    PUSH_FRAGMENT_AND_FADE,
    PUSH_MODAL
}

fun FragmentTransaction.getAnimation(animation: TransactionAnimation): FragmentTransaction =
    when (animation) {
        TransactionAnimation.PUSH_FRAGMENT -> {
            this.setCustomAnimations(
                R.anim.fragment_enter,
                R.anim.fragment_exit,
                R.anim.fragment_pop_enter,
                R.anim.fragment_pop_exit
            )
        }
        TransactionAnimation.PUSH_FRAGMENT_AND_FADE -> {
            this.setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
        }
        TransactionAnimation.PUSH_MODAL -> {
            this.setCustomAnimations(
                R.anim.fragment_enter_modal,
                R.anim.fragment_exit_modal,
                R.anim.fragment_pop_enter_modal,
                R.anim.fragment_pop_exit_modal
            )
        }
    }