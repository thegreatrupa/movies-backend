package com.kishanknows.backend.watchHistory.model;

import jakarta.persistence.*;

@Entity
@Table(name = "watch_history")
public class WatchHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long movieId;

    public WatchHistoryEntity(){}

    public WatchHistoryEntity(Long id, Long userId, Long movieId){
        this.id = id;
        this.userId = userId;
        this.movieId = movieId;
    }

    public Long getId() {
        return id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }
}
