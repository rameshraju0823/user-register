package com.example.userregisteration.repository.util;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JsonUtil {
	
	

	private JsonUtil() {
		super();
	}

	private static RestTemplate restTemplate = new RestTemplate();

	private static Logger logger = LogManager.getLogger(JsonUtil.class);
	
	public static <T extends Object> T postServiceRequest(Object request, Class<T> response, String baseUrl,
			String serviceEndPoint) {
		T resultantObject = null;

		try {

			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.set("originChannel", "WEB");
			
			HttpEntity<Object> entity = new HttpEntity<>(request, headers);
			String contextPath = String.format("url context path jsonutil::  %s", baseUrl + serviceEndPoint);
			logger.info(contextPath);
			String contextPathEntity = String.format("url context path jsonutil::  %s", entity);
			logger.info(contextPathEntity);

			ResponseEntity<T> responseEntity = restTemplate.exchange(baseUrl + serviceEndPoint, HttpMethod.POST, entity,
					response);
			String jsonResponseCode = String.format("Json response code : %s", responseEntity.getStatusCode());
			logger.info(jsonResponseCode);
			
			if (!responseEntity.getStatusCode().equals(HttpStatus.OK)) {
				logger.error("JsonUtil class :: postRequest method :: Exception with HttpErrorCode: {}",
						responseEntity.getStatusCode());
			}
			if (responseEntity.getBody() != null) {
				resultantObject = responseEntity.getBody();
			}

		} catch (Exception e) {
			String info = "JsonUtil class :: postRequest method :: Exception :: " + e.getMessage();
			logger.error(info, e.getMessage());
		}
		return resultantObject;
	}
	
}
