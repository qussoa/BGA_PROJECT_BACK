package com.biz.bow.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bow.domain.FrameVO;
import com.biz.bow.sevice.GameService;
import com.biz.bow.sevice.PlayerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController
public class BwgController {

	@RequestMapping(value = "/start", method = RequestMethod.POST)
	public String bowling(@RequestBody Map<String, Object> params) {

		List<Object> inputScore = (List<Object>) params.get("list");
//		List<Integer> inner = (List<Integer>) result.get(0);
	

		PlayerService player = new PlayerService("TEST");
		GameService game = new GameService(player);
		game.startGame(inputScore);

		return "ok";
	}
}
