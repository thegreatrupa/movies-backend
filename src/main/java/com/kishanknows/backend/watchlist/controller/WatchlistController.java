package com.kishanknows.backend.watchlist.controller;

import com.kishanknows.backend.user.model.UserEntity;
import com.kishanknows.backend.watchlist.dto.WatchlistRequest;
import com.kishanknows.backend.watchlist.dto.WatchlistResponse;
import com.kishanknows.backend.watchlist.mapper.WatchlistMapper;
import com.kishanknows.backend.watchlist.service.WatchlistService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {
    private final WatchlistService watchlistService;

    public WatchlistController(WatchlistService watchlistService){
        this.watchlistService = watchlistService;
    }

    @GetMapping
    public List<WatchlistResponse> getWatchlist(){
        UserEntity authUser = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = authUser.getId();
        return watchlistService.getWatchlist(userId)
                .stream()
                .map(WatchlistMapper::toResponse)
                .toList();
    }

    @PostMapping
    public WatchlistResponse createWatchlist(@RequestBody WatchlistRequest watchlistRequest){
        UserEntity authUser = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = authUser.getId();
        watchlistRequest.setUserId(userId);
        return WatchlistMapper.toResponse(
                watchlistService.createWatchlist(watchlistRequest)
        );
    }
}
