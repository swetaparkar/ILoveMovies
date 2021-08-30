package com.alperozturk.ilovemovies.models.repositories

import androidx.lifecycle.LiveData;
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData;
import androidx.paging.liveData
import com.alperozturk.ilovemovies.core.paging.MoviePagingSource

import com.alperozturk.ilovemovies.models.response.PopularMoviesM;
import com.alperozturk.ilovemovies.networklayer.IRest;

//This repository is bridge between ViewModel and PagingSource. Therefore we don't need to worry about modularity of project.
interface MovieRepository {
    suspend fun getPopularMovieList(): LiveData<PagingData<PopularMoviesM>>
}

class MovieRepositoryImpl(private val service:IRest) : MovieRepository {
    override suspend fun getPopularMovieList(): LiveData<PagingData<PopularMoviesM>>
    {
        return Pager(config = PagingConfig(pageSize = 1,enablePlaceholders = false),
            pagingSourceFactory = { MoviePagingSource(service) }).liveData
    }
}