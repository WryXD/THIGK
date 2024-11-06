package com.example.navigation.data

import com.example.navigation.R

sealed class Data(
    val nickName: String,
    val avatar: Int,
    val playedName: String,
){
    data object Faker: Data(
        nickName = "Faker",
        avatar = R.drawable.faker,
        playedName = "Lee Sang-hyeok",
    )

    data object Oner: Data(
        nickName = "Oner",
        avatar = R.drawable.oner,
        playedName = "Mun Hyeon-jun",
    )

    data object Gumayushi: Data(
        nickName = "Gumayushi",
        avatar = R.drawable.gumayushi,
        playedName = "Lee Min-hyeong",
    )

    data object Keria: Data(
        nickName = "Keria",
        avatar = R.drawable.keria,
        playedName = "Ryu Min-seok",
    )

    data object Zues: Data(
        nickName = "Zues",
        avatar = R.drawable.zues,
        playedName = "Choi Woo-je",
    )
}
