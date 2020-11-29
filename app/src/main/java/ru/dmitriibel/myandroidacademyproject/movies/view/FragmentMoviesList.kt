package ru.dmitriibel.myandroidacademyproject.movies.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.dmitriibel.myandroidacademyproject.NavigationListener
import ru.dmitriibel.myandroidacademyproject.R
import ru.dmitriibel.myandroidacademyproject.moviescreen.data.MovieScreenData

class FragmentMoviesList : Fragment() {

    private var navigationListener: NavigationListener? = null

    private lateinit var recyclerFilms: RecyclerView
    private val listAdapter by lazy(LazyThreadSafetyMode.NONE) { FilmListAdapter { position ->
        navigationListener?.openMovieInfoScreen(MovieScreenData(""))
    } }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigationListener = context as? NavigationListener
    }

    override fun onDetach() {
        super.onDetach()
        navigationListener = null
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)
        recyclerFilms = view.findViewById(R.id.rv_movies_list)
        recyclerFilms.adapter = listAdapter
        return view
    }

    override fun onResume() {
        super.onResume()
        listAdapter.submitList(listOf(FilmData(
                title = "Some Epic film title",
                length = "139 min",
                ageRestriction = "18+",
                liked = true,
                reviewsCount = "125 reviews"
        ), FilmData(
                title = "Some Epic film title",
                length = "139 min",
                ageRestriction = "18+",
                liked = true,
                reviewsCount = "125 reviews"
        )))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment FragmentMoviesList.
         */
        @JvmStatic
        fun newInstance() =
            FragmentMoviesList()
    }
}