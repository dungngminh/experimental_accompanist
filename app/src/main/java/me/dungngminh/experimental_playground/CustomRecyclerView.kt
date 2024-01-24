package me.dungngminh.experimental_playground

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.RecyclerView

class CustomRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    val motionLayouts = HashSet<MotionLayout>()

    override fun onInterceptTouchEvent(e: MotionEvent): Boolean {
        motionLayouts.forEach { motionLayout ->
            Log.d("CustomRecyclerView", "onInterceptTouchEvent: ${motionLayout.progress}")
            if (motionLayout.progress != 0f) {
                return false
            }
        }
        return super.onInterceptTouchEvent(e)
    }

}