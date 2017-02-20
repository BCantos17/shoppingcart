package com.revature.service;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("overview")
public interface OverviewService {
}
