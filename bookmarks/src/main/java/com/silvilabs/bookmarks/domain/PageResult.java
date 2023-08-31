package com.silvilabs.bookmarks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PageResult <T>(
    List<T> data,
    long totalElements,
    long pageNumber,
    long totalPages,
    @JsonProperty("isFirst") boolean isFirst,
    @JsonProperty("isLast") boolean isLast,
    @JsonProperty("hasNext") boolean hasNext,
    @JsonProperty("hasPrevious") boolean hasPrevious){}
