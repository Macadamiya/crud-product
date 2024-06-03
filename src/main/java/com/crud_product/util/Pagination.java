package com.crud_product.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;


public class Pagination {

    public static <T> Map<String, Object> getPaginationResponse(Page<T> page, String baseUrl, int pageNum, int size) {
        Map<String, Object> pagination = new HashMap<>();
        pagination.put("currentPage", page.getNumber() + 1);
        pagination.put("count", page.getTotalElements());
        pagination.put("next", page.hasNext() ? buildPageUri(baseUrl, pageNum + 1, size) : null);
        pagination.put("previous", page.hasPrevious() ? buildPageUri(baseUrl, pageNum - 1, size) : null);
        pagination.put("totalPages", page.getTotalPages());
        pagination.put("pageSize", page.getSize());
        pagination.put("startIndex", (pageNum - 1) * size + 1);
        pagination.put("endIndex", Math.min(pageNum * size, (int) page.getTotalElements()));
        return pagination;
    }

    private static String buildPageUri(String baseUrl, int page, int size) {
        return UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("page", page)
                .queryParam("size", size)
                .toUriString();
    }
}