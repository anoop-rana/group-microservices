package com.userinfo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userinfo.dto.CabDto;
import com.userinfo.feign.ICabServiceProxy;


@RestController
@RequestMapping(path = "/search")
public class SearchController {
	
	@Autowired
	private ICabServiceProxy cabProxy;
	
	@GetMapping("/{user}")
	public ResponseEntity<Map<String, Object>> searchCabFromTo(@PathVariable String user, @RequestParam Map<String, String> fromTo) {
		System.out.println("===================" + fromTo);
		List<CabDto> availCabs = cabProxy.searchCabs(fromTo);
		System.out.println("================="+availCabs);
		Map<String, Object> responseMap = Map.of("User",user,"Available Cabs",availCabs);
		return new ResponseEntity<Map<String,Object>>(responseMap, HttpStatus.OK);
	}

}
