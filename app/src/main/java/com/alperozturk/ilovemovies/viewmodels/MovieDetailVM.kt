package com.alperozturk.ilovemovies.viewmodels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alperozturk.ilovemovies.models.response.MovieCreditsBaseM
import com.alperozturk.ilovemovies.models.response.MovieDetailBaseM
import com.alperozturk.ilovemovies.networklayer.IRest
import com.alperozturk.ilovemovies.networklayer.ResultWrapper

import com.alperozturk.ilovemovies.repositories.MovieDetailRepository


class MovieDetailVM(service:IRest) : ViewModel() {

    var movieId = ""
    private val repository = MovieDetailRepository(service)

    fun movieDetail(): MutableLiveData<ResultWrapper<MovieDetailBaseM>> {
        return repository.getMovieDetail(movieId)
    }

    fun movieCredits(): MutableLiveData<ResultWrapper<MovieCreditsBaseM>> {
        return repository.getMovieCredits(movieId)
    }

    fun loadingIndicator():MutableLiveData<Boolean> {
        return repository.isLoading()
    }

    fun disposeAll(){
        repository.finish()
    }

}