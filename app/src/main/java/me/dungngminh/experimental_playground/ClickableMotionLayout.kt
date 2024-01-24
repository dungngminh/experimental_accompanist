package me.dungngminh.experimental_playground

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlin.math.abs

/**
 * MotionLayout will intercept all touch events and take control over them.
 * That means that View on top of MotionLayout (i.e. children of MotionLayout) will not
 * receive touch events.
 *
 * If the motion scene uses only a onSwipe transition, all click events are intercepted nevertheless.
 * This is why we override onInterceptTouchEvent in this class and only let swipe actions be handled
 * by MotionLayout. All other actions are passed down the View tree so that possible ClickListener can
 * receive the touch/click events.
 */
class ClickableMotionLayout : MotionLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private var mInitX = 0f
    private var mInitY = 0f

    private var mTouchSlop = 10

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {

        when (ev.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                mInitX = ev.x
                mInitY = ev.y
            }

            MotionEvent.ACTION_MOVE -> {
                val moveX = abs(ev.x - mInitX)
                val moveY = abs(ev.y - mInitY)

                if (moveX > mTouchSlop || moveY > mTouchSlop) {

                    val obtain = MotionEvent.obtain(ev)
                    obtain.action = MotionEvent.ACTION_DOWN
                    dispatchTouchEvent(obtain)
                    onTouchEvent(obtain)
                    return true
                }
            }

            MotionEvent.ACTION_UP -> {
            }
        }
        return false
    }

}