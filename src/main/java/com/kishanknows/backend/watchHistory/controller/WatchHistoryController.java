package com.kishanknows.backend.watchHistory.controller;

import com.kishanknows.backend.watchHistory.dto.WatchHistoryRequest;
import com.kishanknows.backend.watchHistory.dto.WatchHistoryResponse;
import com.kishanknows.backend.watchHistory.mapper.WatchHistoryMapper;
import com.kishanknows.backend.watchHistory.service.WatchHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watch-history")
public class WatchHistoryController {
    private final WatchHistoryService service;

    public WatchHistoryController(WatchHistoryService service){
        this.service = service;
    }

    @GetMapping("/{userId}")
    public List<WatchHistoryResponse> getWatchHistory(@PathVariable Long userId){
        return service.getWatchHistory(userId)
                .stream()
                .map(WatchHistoryMapper::toResponse)
                .toList();
    }

    @PostMapping("/{userId}")
    public WatchHistoryResponse createWatchHistory(@RequestBody WatchHistoryRequest request, @PathVariable Long userId){
        request.setUserId(userId);
        return WatchHistoryMapper.toResponse(
                service.createWatchHistory(request)
        );
    }
}
