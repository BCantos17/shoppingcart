package com.revature.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("overview")
public interface OverviewService {
}
