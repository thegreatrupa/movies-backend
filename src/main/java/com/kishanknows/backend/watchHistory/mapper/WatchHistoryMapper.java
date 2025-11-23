package com.kishanknows.backend.watchHistory.mapper;

import com.kishanknows.backend.watchHistory.dto.*;
import com.kishanknows.backend.watchHistory.model.*;

public class WatchHistoryMapper {
    public static WatchHistoryEntity toEntity(WatchHistoryRequest request){
        return new WatchHistoryEntity(null, request.getUserId(), request.getMovieId());
    }

    public static WatchHistory toDomain(WatchHistoryEntity entity){
        return new WatchHistory(
                entity.getId(),
                entity.getUserId(),
                entity.getMovieId()
        );
    }

    public static WatchHistoryResponse toResponse(WatchHistory history){
        return new WatchHistoryResponse(history.id(), history.movieId());
    }
}
