package ru.dmitriibel.myandroidacademyproject.moviescreen.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import ru.dmitriibel.myandroidacademyproject.NavigationListener
import ru.dmitriibel.myandroidacademyproject.R
import ru.dmitriibel.myandroidacademyproject.moviescreen.data.MovieScreenData

private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMovieInfo.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMovieInfo : Fragment() {

    private var navigationListener: NavigationListener? = null
    private var screenData: MovieScreenData? = null
    private lateinit var backButton: AppCompatButton

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigationListener = context as? NavigationListener
    }

    override fun onDetach() {
        super.onDetach()
        navigationListener = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            screenData = it.getSerializable(ARG_PARAM1) as? MovieScreenData
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_info, container, false)
        backButton = view.findViewById(R.id.button_back)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backButton.setOnClickListener { navigationListener?.onBackPressed() }
    }



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