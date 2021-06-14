package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.AddTenApi;
import com.example.demo.model.InlineResponse200;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class AddTenApiImpl implements AddTenApi {
	@Autowired
	ObjectMapper objectMapper;

	@Override
	public ResponseEntity<InlineResponse200> getAddTen(String number) {
		try {
			Integer n1 = Integer.parseInt(number);
			return new ResponseEntity<>(
					objectMapper.readValue("{\r\n  \"sum\" : \"" + (n1 + 10) + "\"\r\n}", InlineResponse200.class),
					HttpStatus.OK);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
