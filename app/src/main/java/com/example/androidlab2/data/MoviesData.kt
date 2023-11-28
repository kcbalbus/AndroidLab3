package com.example.androidlab2.data

import com.example.androidlab2.Movie

val allMovies: List<Movie> =
    listOf(
        Movie("Wyspa Tajemnic",
            "wyspa_tajemnic_cover",
            "Szeryf federalny Daniels stara się dowiedzieć, jakim sposobem z zamkniętej celi w pilnie strzeżonym szpitalu dla chorych psychicznie przestępców zniknęła pacjentka.",
            listOf("wyspa_tajemnic_scene1", "wyspa_tajemnic_scene2","wyspa_tajemnic_scene3","wyspa_tajemnic_scene4","wyspa_tajemnic_scene5","wyspa_tajemnic_scene6"),
            listOf("Leonardo DiCaprio", "Mark Ruffalo", "Max von Sydow", "Michelle Williams"),
            listOf("wyspa_tajemnic_trailer_1", "wyspa_tajemnic_trailer_2")
        ),
        Movie("Bękarty Wojny",
            "bekarty_wojny_cover",
            "W okupowanej przez nazistów Francji oddział złożony z Amerykanów żydowskiego pochodzenia planuje zamach na Hitlera.",
            listOf("bekarty_wojny_scene1", "bekarty_wojny_scene2","bekarty_wojny_scene3","bekarty_wojny_scene4","bekarty_wojny_scene5","bekarty_wojny_scene6","bekarty_wojny_scene7"),
            listOf("Brad Pitt", "Mélanie Laurent", "Christoph Waltz", "Eli Roth", "Daniel Brühl"),
            listOf("bekarty_wojny_trailer_1", "bekarty_wojny_trailer_2", "bekarty_wojny_trailer_3")),
        Movie("Baby Driver",
            "baby_driver_cover",
            "Chcący zerwać z kryminalną przeszłością młody chłopak, zmuszany do pracy dla bossa mafii, zostaje wrobiony w napad skazany na niepowodzenie.",
            listOf("baby_driver_scene1", "baby_driver_scene2","baby_driver_scene3","baby_driver_scene4","baby_driver_scene5","baby_driver_scene6", "baby_driver_scene7","baby_driver_scene8","baby_driver_scene9"),
            listOf("Ansel Elgort", "Kevin Spacey", "Lily James", "Jon Hamm", "Jamie Foxx", "Eiza González"),
            listOf("baby_driver_trailer_1", "baby_driver_trailer_2")),
    )