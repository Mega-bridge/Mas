package com.example.Mas;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MasApplicationTests {

	@Test
	void contextLoads() throws ParseException, JSONException {
		String object = "{\t\t\t\t\t\t\t\t\t\n" +
				"\t\"fishowl\": {\t\t\t\t\t\t\t\t\n" +
				"\t\t\"code\": 0,\t\t\t\t\t\t\t\n" +
				"\t\t\"water_height\": 50\n" +
				"\t},\n" +
				"\t\"fish_list\" :[\t\t\t\t\t\t\t\n" +
				"\t\t{\t\t\t\t\t\t\t\n" +
				"\t\t\t\"fish_position\" : [300.123, 600.456],\t\t\t\t\t\t\n" +
				"\t\t\t\"fish_code\": 0,\t\t\t\t\t\t\n" +
				"\t\t\t\"path\": \"file:///Users/ruri/Downloads/%E1%84%8B%E1%85%A9%E1%84%87%E1%85%B3%E1%84%8C%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B3/%E1%84%83%E1%85%AE%E1%86%BC%E1%84%80%E1%85%B3%E1%86%AB%E1%84%86%E1%85%AE%E1%86%AF%E1%84%80%E1%85%A9%E1%84%80%E1%85%B5/%E1%84%88%E1%85%B5%E1%84%8C%E1%85%B5%E1%86%AB%E1%84%83%E1%85%AE%E1%86%BC%E1%84%80%E1%85%B3%E1%86%AB%E1%84%86%E1%85%AE%E1%86%AF%E1%84%80%E1%85%A9%E1%84%80%E1%85%B5_%E1%84%87%E1%85%B5%E1%84%82%E1%85%B3%E1%86%AF%E1%84%8B%E1%85%A5%E1%86%B9%E1%84%89%E1%85%B3%E1%86%B7.png\",\n" +
				"\t\t\t\"fish_name\": \"\",\t\t\t\t\t\t\n" +
				"\t\t\t\"fish_angle\": 30,\t\t\t\t\t\t\n" +
				"\t\t\t\"fish_size\": []\n" +
				"\t\t},\t\t\t\t\t\t\t\n" +
				"\t\t{\t\t\t\t\t\t\t\n" +
				"\t\t\t\"fish_position\" : [300.123, 600.456],\t\t\t\t\t\t\n" +
				"\t\t\t\"fish_code\": 0,\t\t\t\t\t\t\n" +
				"\t\t\t\"path\": \"file:///Users/ruri/Downloads/%E1%84%8B%E1%85%A9%E1%84%87%E1%85%B3%E1%84%8C%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B3/%E1%84%83%E1%85%AE%E1%86%BC%E1%84%80%E1%85%B3%E1%86%AB%E1%84%86%E1%85%AE%E1%86%AF%E1%84%80%E1%85%A9%E1%84%80%E1%85%B5/%E1%84%88%E1%85%B5%E1%84%8C%E1%85%B5%E1%86%AB%E1%84%83%E1%85%AE%E1%86%BC%E1%84%80%E1%85%B3%E1%86%AB%E1%84%86%E1%85%AE%E1%86%AF%E1%84%80%E1%85%A9%E1%84%80%E1%85%B5_%E1%84%87%E1%85%B5%E1%84%82%E1%85%B3%E1%86%AF%E1%84%8B%E1%85%A5%E1%86%B9%E1%84%89%E1%85%B3%E1%86%B7.png\",\n" +
				"\t\t\t\"fish_name\": \"\",\t\t\t\t\t\t\n" +
				"\t\t\t\"fish_angle\": 30,\t\t\t\t\t\t\n" +
				"\t\t\t\"fish_size\": []\n" +
				"\t\t}\t\t\t\t\t\n" +
				"\t],\t\t\t\t\t\t\t\n" +
				"\t\"object_list\" :[\t\t\t\t\t\t\t\t\n" +
				"\t\t{\t\t\t\t\t\t\t\n" +
				"\t\t\t\"object_position\" : [300.123, 600.456],\t\t\t\t\t\t\n" +
				"\t\t\t\"object_code\": 0,\t\t\t\t\t\t\n" +
				"\t\t\t\"path\": \"file:///Users/ruri/Downloads/%E1%84%8B%E1%85%A9%E1%84%87%E1%85%B3%E1%84%8C%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B3/%E1%84%83%E1%85%AE%E1%86%BC%E1%84%80%E1%85%B3%E1%86%AB%E1%84%86%E1%85%AE%E1%86%AF%E1%84%80%E1%85%A9%E1%84%80%E1%85%B5/%E1%84%88%E1%85%B5%E1%84%8C%E1%85%B5%E1%86%AB%E1%84%83%E1%85%AE%E1%86%BC%E1%84%80%E1%85%B3%E1%86%AB%E1%84%86%E1%85%AE%E1%86%AF%E1%84%80%E1%85%A9%E1%84%80%E1%85%B5_%E1%84%87%E1%85%B5%E1%84%82%E1%85%B3%E1%86%AF%E1%84%8B%E1%85%A5%E1%86%B9%E1%84%89%E1%85%B3%E1%86%B7.png\",\n" +
				"\t\t\t\"object_angle\": 30,\t\t\t\t\t\t\n" +
				"\t\t\t\"object_size\": []\n" +
				"\t\t},\t\t\t\t\t\t\t\n" +
				"\t\t{\t\t\t\t\t\t\t\n" +
				"\t\t\t\"object_position\" : [300.123, 600.456],\t\t\t\t\t\t\n" +
				"\t\t\t\"object_code\": 0,\t\t\t\t\t\t\n" +
				"\t\t\t\"path\": \"file:///Users/ruri/Downloads/%E1%84%8B%E1%85%A9%E1%84%87%E1%85%B3%E1%84%8C%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B3/%E1%84%83%E1%85%AE%E1%86%BC%E1%84%80%E1%85%B3%E1%86%AB%E1%84%86%E1%85%AE%E1%86%AF%E1%84%80%E1%85%A9%E1%84%80%E1%85%B5/%E1%84%88%E1%85%B5%E1%84%8C%E1%85%B5%E1%86%AB%E1%84%83%E1%85%AE%E1%86%BC%E1%84%80%E1%85%B3%E1%86%AB%E1%84%86%E1%85%AE%E1%86%AF%E1%84%80%E1%85%A9%E1%84%80%E1%85%B5_%E1%84%87%E1%85%B5%E1%84%82%E1%85%B3%E1%86%AF%E1%84%8B%E1%85%A5%E1%86%B9%E1%84%89%E1%85%B3%E1%86%B7.png\",\n" +
				"\t\t\t\"object_angle\": 30,\t\t\t\t\t\t\n" +
				"\t\t\t\"object_size\": []\n" +
				"\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
				"\t]\t\t\t\t\t\t\t\t\n" +
				"}";

		JSONObject jsonObject = new JSONObject(object);
		System.out.println(jsonObject);
	}

}
