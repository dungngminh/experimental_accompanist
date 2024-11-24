package me.dungngminh.experimental_playground

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.helper.widget.Carousel
import androidx.fragment.app.Fragment
import coil.load
import com.google.android.material.card.MaterialCardView
import me.dungngminh.experimental_playground.databinding.FragmentTinderCardSwiperShowcaseBinding

class TinderCardSwiperShowcaseFragment : Fragment() {

    private var _binding: FragmentTinderCardSwiperShowcaseBinding? = null
    private val binding: FragmentTinderCardSwiperShowcaseBinding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTinderCardSwiperShowcaseBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView() {
        binding.tinderCardSwiperLayout.tinderRightToLeftSlider.setAdapter(
            object : Carousel.Adapter {
                override fun count(): Int = images.size

                override fun populate(view: View?, index: Int) {
                    val imageView =
                        (view as? MaterialCardView)?.getChildAt(0) as? ImageView
                    Log.d(TAG, "$imageView")
                    val imageAtIndex = images.getOrNull(index) ?: return
                    imageView?.load(imageAtIndex) {
                        crossfade(true)
                        placeholder(R.drawable.ic_launcher_foreground)
                    }

                    Log.d(TAG, "populate: $index")
                }

                override fun onNewItem(index: Int) {
                    // Do nothing
                }
            }
        )
    }

    companion object {
        val images = listOf(
            "https://images.unsplash.com/photo-1492370284958-c20b15c692d2?q=80&w=3374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1509205477838-a534e43a849f?q=80&w=3556&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1502083896352-259ab9e342d7?q=80&w=3540&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1496284575094-d5b92db3890d?q=80&w=3540&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1496284575094-d5b92db3890d?q=80&w=3540&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        )

        const val TAG = "TinderCardSwiperShowcaseFragment"
    }
}