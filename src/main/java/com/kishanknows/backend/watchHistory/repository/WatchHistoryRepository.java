package com.kishanknows.backend.watchHistory.repository;

import com.kishanknows.backend.watchHistory.model.WatchHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchHistoryRepository extends JpaRepository<WatchHistoryEntity, Long> {
    List<WatchHistoryEntity> findByUserId(Long userId);
}
