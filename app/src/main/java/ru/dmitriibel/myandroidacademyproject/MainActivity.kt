package ru.dmitriibel.myandroidacademyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.dmitriibel.myandroidacademyproject.movies.view.FragmentMoviesList
import ru.dmitriibel.myandroidacademyproject.moviescreen.data.MovieScreenData
import ru.dmitriibel.myandroidacademyproject.moviescreen.view.FragmentMovieInfo

class MainActivity : AppCompatActivity(), NavigationListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState ?: let {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.content_frame, FragmentMoviesList.newInstance(), FragmentMoviesList::class.simpleName)
                    .commit()
        }
    }

    override fun openMovieInfoScreen(data: MovieScreenData) {
        Log.i("FM", "Fragments count is: ${supportFragmentManager.fragments.size}")
        supportFragmentManager.beginTransaction()
                .add(R.id.content_frame, FragmentMovieInfo.newInstance(data), FragmentMovieInfo::class.simpleName)
                .addToBackStack(null)
                .commit()
    }
}