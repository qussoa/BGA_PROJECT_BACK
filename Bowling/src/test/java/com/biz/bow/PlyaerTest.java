package com.biz.bow;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Field;

import org.junit.Test;

import com.biz.bow.service.PlayerService;

public class PlyaerTest {

	@Test
	public void 플레이어_이름_생성_확인() {
		try {
			PlayerService player = new PlayerService("박지민");
			
			Field field = player.getClass().getDeclaredField("name");
			field.setAccessible(true);
			
			String playerName = (String) field.get(player);
			
			assertThat(playerName, is("민윤기"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
