package com.userinfo.feign;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.userinfo.dto.CabDto;

//@FeignClient(name = "cab-service", url = "localhost:9020")

@RibbonClient(name = "cab-service")
@FeignClient(name = "cab-service")
public interface ICabServiceProxy {

//	@GetMapping("/cab/search")
//	public ResponseEntity<List<CabDto>> searchCabs(@RequestParam Map<String, String> map);
	
	@GetMapping("/cab/search")
	public List<CabDto> searchCabs(@RequestParam Map<String, String> map);
}
