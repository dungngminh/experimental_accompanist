package me.dungngminh.experimental_playground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import me.dungngminh.experimental_playground.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding: FragmentMenuBinding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnHome.setOnClickListener {
            replaceWith<HomeFragment>()
        }

        binding.btnTinderCardSwiper.setOnClickListener {
            replaceWith<TinderCardSwiperShowcaseFragment>()
        }
    }

    private inline fun <reified T : Fragment> replaceWith(tag: String? = null) {
        parentFragmentManager.beginTransaction()
            .apply {
                replace(
                    R.id.fragment_container_view,
                    T::class.java.getDeclaredConstructor().newInstance()
                )
                addToBackStack(tag ?: T::class.java.simpleName)
                setReorderingAllowed(true)
                commit()
            }
    }
}