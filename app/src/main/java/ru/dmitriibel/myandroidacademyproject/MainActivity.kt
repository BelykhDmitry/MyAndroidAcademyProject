package ru.dmitriibel.myandroidacademyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.dmitriibel.myandroidacademyproject.moviescreen.view.FragmentMovieInfo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        showMovieInfoFragment()
    }

    private fun showMovieInfoFragment(param1: String = "", param2: String = "") {
        supportFragmentManager.beginTransaction()
                .add(R.id.content_frame, FragmentMovieInfo.newInstance(param1, param2), FragmentMovieInfo::class.simpleName)
                .addToBackStack(null)
                .commit()
    }
}