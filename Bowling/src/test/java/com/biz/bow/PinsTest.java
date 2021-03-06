package com.biz.bow;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

import com.biz.bow.service.PinsService;

public class PinsTest {

	@Test
	public void 볼링핀_HIT_TEST() {
		try {
			PinsService pins = new PinsService();
			
			// hitBowpinsService 접근
			Method method = pins.getClass().getDeclaredMethod("hitBowPin", int.class);
			
			// private에 대한 접근 제한 변경
			method.setAccessible(true);
			
			// (호출하려는 객체, 파라메터 값)  
			method.invoke(pins, 5);
			
			// 필드 메서드 가져오기
			Field field = pins.getClass().getDeclaredField("bowPins");
			field.setAccessible(true);
			
			int resultPin = (int) field.get(pins);
			
			assertThat(resultPin, is(7));
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
