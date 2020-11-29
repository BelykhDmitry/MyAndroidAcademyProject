package ru.dmitriibel.myandroidacademyproject.moviescreen.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.dmitriibel.myandroidacademyproject.R
import ru.dmitriibel.myandroidacademyproject.moviescreen.data.MovieScreenData

private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMovieInfo.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMovieInfo : Fragment() {

    private var screenData: MovieScreenData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            screenData = it.getSerializable(ARG_PARAM1) as? MovieScreenData
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movie_info, container, false)

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment FragmentMovieInfo.
         */
        @JvmStatic
        fun newInstance(param1: MovieScreenData) =
            FragmentMovieInfo().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }
}