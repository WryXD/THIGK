package com.example.navigation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.navigation.viewmodel.PlayerDetailViewModel
import com.example.navigation.R
import com.example.navigation.data.PlayerDetail
import com.example.navigation.databinding.FragmentPlayerDetailBinding

@Suppress("DEPRECATION")
class PlayerDetailFragment : Fragment() {
    // create view model
    private lateinit var viewModel: PlayerDetailViewModel
    private lateinit var binding: FragmentPlayerDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_player_detail, container, false)

        viewModel = ViewModelProvider(requireActivity())[PlayerDetailViewModel::class.java]
        binding = FragmentPlayerDetailBinding.bind(view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backButton = binding.backButton
        val showFavoriteCount = binding.favoriteCount
        val favoriteButton = binding.favoriteButton
        val nickName = binding.nickName
        val playerAvatar = binding.contentImage
        val playerDescription = binding.playerDescription

        val playerDetailMap = mapOf(
            PlayerDetail.Faker.playerName to PlayerDetail.Faker,
            PlayerDetail.Oner.playerName to PlayerDetail.Oner,
            PlayerDetail.Gumayushi.playerName to PlayerDetail.Gumayushi,
            PlayerDetail.Keria.playerName to PlayerDetail.Keria,
            PlayerDetail.Zues.playerName to PlayerDetail.Zues
        )

        showFavoriteCount.text = viewModel.detail.value?.favoriteCount.toString()

        viewModel.detail.observe(viewLifecycleOwner) { detail ->
            detail?.let {
                // Check if the nickname exists in the map
                val matchingPlayer = playerDetailMap[detail.nickName]

                if (matchingPlayer != null) {
                    nickName.text = matchingPlayer.playerName
                    playerAvatar.setImageResource(matchingPlayer.contentImage)
                    playerDescription.text = getString(matchingPlayer.playerDescription)
                }

            }
        }

        favoriteButton.setOnClickListener {
            viewModel.addFavorite()
            viewModel.detail.observe(viewLifecycleOwner) { detail ->
                showFavoriteCount.text = detail.favoriteCount.toString()
            }
        }

        backButton.setOnClickListener {
            requireActivity().onBackPressed()
//            viewModel.resetFavorite()
        }
    }

}