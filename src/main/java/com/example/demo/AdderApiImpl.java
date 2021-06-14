package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.AdderApi;
import com.example.demo.model.InlineResponse200;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class AdderApiImpl implements AdderApi {

	@Autowired
	ObjectMapper objectMapper;

	@Override
	public ResponseEntity<InlineResponse200> getAdditionNumberOneNumberTwo(String numberOne, String numberTwo) {

		try {
			Integer n1 = Integer.parseInt(numberOne);
			Integer n2 = Integer.parseInt(numberTwo);
			return new ResponseEntity<>(
					objectMapper.readValue("{\r\n  \"sum\" : \"" + (n1 + n2) + "\"\r\n}", InlineResponse200.class),
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
