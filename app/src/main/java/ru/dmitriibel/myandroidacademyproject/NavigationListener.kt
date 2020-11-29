package ru.dmitriibel.myandroidacademyproject

import ru.dmitriibel.myandroidacademyproject.moviescreen.data.MovieScreenData

interface NavigationListener {

    fun openMovieInfoScreen(data: MovieScreenData)
}