package com.kishanknows.backend.watchHistory.service;

import com.kishanknows.backend.watchHistory.dto.WatchHistoryRequest;
import com.kishanknows.backend.watchHistory.mapper.WatchHistoryMapper;
import com.kishanknows.backend.watchHistory.model.WatchHistory;
import com.kishanknows.backend.watchHistory.model.WatchHistoryEntity;
import com.kishanknows.backend.watchHistory.repository.WatchHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchHistoryService {
    private final WatchHistoryRepository repo;

    public WatchHistoryService(WatchHistoryRepository repo){
        this.repo = repo;
    }

    public List<WatchHistory> getWatchHistory(Long userId){
        return repo.findByUserId(userId)
                .stream()
                .map(WatchHistoryMapper::toDomain)
                .toList();
    }

    public WatchHistory createWatchHistory(WatchHistoryRequest request){
        WatchHistoryEntity entity = WatchHistoryMapper.toEntity(request);
        WatchHistoryEntity saved = repo.save(entity);
        return WatchHistoryMapper.toDomain(entity);
    }

}
