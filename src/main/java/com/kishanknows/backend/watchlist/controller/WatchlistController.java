package com.kishanknows.backend.watchlist.controller;

import com.kishanknows.backend.watchlist.dto.WatchlistRequest;
import com.kishanknows.backend.watchlist.dto.WatchlistResponse;
import com.kishanknows.backend.watchlist.mapper.WatchlistMapper;
import com.kishanknows.backend.watchlist.service.WatchlistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {
    private final WatchlistService watchlistService;

    public WatchlistController(WatchlistService watchlistService){
        this.watchlistService = watchlistService;
    }

    @GetMapping("/{userId}")
    public List<WatchlistResponse> getWatchlist(@PathVariable Long userId){
        return watchlistService.getWatchlist(userId)
                .stream()
                .map(WatchlistMapper::toResponse)
                .toList();
    }

    @PostMapping("/{userId}")
    public WatchlistResponse createWatchlist(@PathVariable Long userId, @RequestBody WatchlistRequest watchlistRequest){
        watchlistRequest.setUserId(userId);
        return WatchlistMapper.toResponse(
                watchlistService.createWatchlist(watchlistRequest)
        );
    }
}
