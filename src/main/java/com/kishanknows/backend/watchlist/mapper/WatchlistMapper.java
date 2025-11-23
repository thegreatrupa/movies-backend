package com.kishanknows.backend.watchlist.mapper;

import com.kishanknows.backend.watchlist.dto.WatchlistRequest;
import com.kishanknows.backend.watchlist.dto.WatchlistResponse;
import com.kishanknows.backend.watchlist.model.Watchlist;
import com.kishanknows.backend.watchlist.model.WatchlistEntity;

public class WatchlistMapper {
    public static WatchlistEntity toEntity(WatchlistRequest watchlistRequest) {
        return new WatchlistEntity(watchlistRequest.getUserId(), watchlistRequest.getMovieId());
    }

    public static Watchlist toDomain(WatchlistEntity watchlistEntity){
        return new Watchlist(watchlistEntity.getMovieId());
    }

    public static WatchlistResponse toResponse(Watchlist watchlist){
        return new WatchlistResponse(watchlist.movieId());
    }
}
