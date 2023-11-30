package com.rival.myapplication.presentation.quran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rival.myapplication.adapter.ListSurahAdapter
import com.rival.myapplication.databinding.FragmentQuranBinding


class QuranFragment : Fragment() {

    private lateinit var binding: FragmentQuranBinding

    private val quranViewModel: QuranViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuranBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val mAdapter = ListSurahAdapter()

        if (quranViewModel.listSurah.value == null) {
            quranViewModel.getListSurah()
        }


        quranViewModel.listSurah.observe(viewLifecycleOwner){ surah ->
            mAdapter.setData(surah.listSurah)
            binding.rvQuran.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }

    }

}