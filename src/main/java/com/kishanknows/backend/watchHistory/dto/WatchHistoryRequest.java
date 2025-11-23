package com.kishanknows.backend.watchHistory.dto;

public class WatchHistoryRequest {
    private Long userId;
    private Long movieId;

    public Long getUserId(){
        return userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}

