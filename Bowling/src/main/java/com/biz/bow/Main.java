package com.biz.bow;

import com.biz.bow.sevice.GameService;
import com.biz.bow.sevice.PlayerService;

public class Main {
	
	public static void main(String[] args) {
		PlayerService player = new PlayerService("TEST");
		GameService game = new GameService(player);
		game.startGame();
		
		PlayerService player2 = new PlayerService("제원");
		GameService game2 = new GameService(player2);
		game2.startGame();
	}

}
