package com.kishanknows.backend.watchlist.model;

import jakarta.persistence.*;

@Entity
@Table(name = "watchlist")
public class WatchlistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String movieId;

    public WatchlistEntity() {}

    public WatchlistEntity(Long userId, String movieId){
        this.userId = userId;
        this.movieId = movieId;
    }

    public Long getUserId() {return userId;}
    public String getMovieId() {return movieId;}

    public void setUserId(Long userId) {this.userId = userId;}
    public void setMovieId(String movieId) {this.movieId = movieId;}
}
