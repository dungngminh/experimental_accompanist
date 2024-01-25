package me.dungngminh.experimental_playground

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import me.dungngminh.experimental_playground.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeAdapter by lazy { HomeAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rcv.run {
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        val layouts = listOf(
            Layout.TopTen(
                listOf(
                    Item(),
                    Item(),
                    Item(),
                    Item(),
                    Item(),
                )
            ),
            Layout.TopTen(
                listOf(
                    Item(),
                    Item(),
                    Item(),
                    Item(), Item()
                )
            ),
            Layout.Others(
                listOf(
                    Item(),
                    Item(),

                ),
            )
        )
        homeAdapter.submitList(layouts)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}