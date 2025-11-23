package com.kishanknows.backend.watchHistory.model;

public record WatchHistory(
        Long id,
        Long userId,
        Long movieId
) {}
