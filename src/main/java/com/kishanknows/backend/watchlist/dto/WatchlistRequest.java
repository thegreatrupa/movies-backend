package com.kishanknows.backend.watchlist.dto;

public class WatchlistRequest {
    private Long userId;
    private String movieId;

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getMovieId() { return movieId; }
    public void setMovieId(String movieId) { this.movieId = movieId; }
}
