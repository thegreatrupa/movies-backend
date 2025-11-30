package com.kishanknows.backend.watchHistory.controller;

import com.kishanknows.backend.user.model.UserEntity;
import com.kishanknows.backend.watchHistory.dto.WatchHistoryRequest;
import com.kishanknows.backend.watchHistory.dto.WatchHistoryResponse;
import com.kishanknows.backend.watchHistory.mapper.WatchHistoryMapper;
import com.kishanknows.backend.watchHistory.service.WatchHistoryService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watch-history")
public class WatchHistoryController {
    private final WatchHistoryService service;

    public WatchHistoryController(WatchHistoryService service){
        this.service = service;
    }

    @GetMapping
    public List<WatchHistoryResponse> getWatchHistory(){
        UserEntity authUser = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = authUser.getId();
        return service.getWatchHistory(userId)
                .stream()
                .map(WatchHistoryMapper::toResponse)
                .toList();
    }

    @PostMapping
    public WatchHistoryResponse createWatchHistory(@RequestBody WatchHistoryRequest request){
        UserEntity authUser = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = authUser.getId();
        request.setUserId(userId);
        return WatchHistoryMapper.toResponse(
                service.createWatchHistory(request)
        );
    }
}
