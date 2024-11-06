package com.example.navigation.data

import com.example.navigation.R

sealed class PlayerDetail(
    val playerName: String,
    val contentImage: Int,
    val playerDescription: Int ,
    val favoriteCount: Int = 0
) {
    data object Faker : PlayerDetail(
        playerName = "Faker",
        contentImage = R.drawable.faker,
        playerDescription = R.string.faker_wiki,
        favoriteCount = 0
    )

    data object Oner : PlayerDetail(
        playerName = "Oner",
        contentImage = R.drawable.oner,
        playerDescription = R.string.oner_wiki,
        favoriteCount = 0
    )

    data object Gumayushi : PlayerDetail(
        playerName = "Gumayushi",
        contentImage = R.drawable.gumayushi,
        playerDescription = R.string.gumayushi_wiki,
        favoriteCount = 0
    )

    data object Keria : PlayerDetail(
        playerName = "Keria",
        contentImage = R.drawable.keria,
        playerDescription = R.string.keria_wiki,
        favoriteCount = 0
    )

    data object Zues : PlayerDetail(
        playerName = "Zues",
        contentImage = R.drawable.zues,
        playerDescription = R.string.zues_wiki,
        favoriteCount = 0
    )
}