package com.kishanknows.backend.watchlist.repository;

import com.kishanknows.backend.watchlist.model.WatchlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchlistRepository extends JpaRepository<WatchlistEntity, Long> {
    List<WatchlistEntity> findByUserId(Long userId);
}
