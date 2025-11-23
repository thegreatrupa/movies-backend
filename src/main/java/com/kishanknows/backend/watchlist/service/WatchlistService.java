package com.kishanknows.backend.watchlist.service;

import com.kishanknows.backend.watchlist.dto.WatchlistRequest;
import com.kishanknows.backend.watchlist.mapper.WatchlistMapper;
import com.kishanknows.backend.watchlist.model.Watchlist;
import com.kishanknows.backend.watchlist.model.WatchlistEntity;
import com.kishanknows.backend.watchlist.repository.WatchlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistService {
    private final WatchlistRepository watchlistRepository;

    public WatchlistService(WatchlistRepository watchlistRepository) {
        this.watchlistRepository = watchlistRepository;
    }

    public List<Watchlist> getWatchlist(Long userId){
        return watchlistRepository.findByUserId(userId)
                .stream()
                .map(WatchlistMapper::toDomain)
                .toList();
    }

    public Watchlist createWatchlist(WatchlistRequest watchlistRequest){
        WatchlistEntity entity = WatchlistMapper.toEntity(watchlistRequest);
        WatchlistEntity saved = watchlistRepository.save(entity);
        return WatchlistMapper.toDomain(saved);
    }
}
