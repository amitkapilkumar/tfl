package com.tfl.buses;

import com.tfl.buses.entity.Schedule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BusesApplicationTests {
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void testForStopG() {
		ResponseEntity<List<Schedule>> response = restTemplate.exchange(
				createURLWithPort("/schedule/greatportlandstreet/G"),
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Schedule>>() {});

		assertEquals(response.getStatusCode().value(), 200);
		List<Schedule> schedules = response.getBody();
		assertNotNull(schedules);
		assertTrue(schedules.size() > 0);
		for(Schedule schedule : schedules) {
			assertNotNull(schedule.getBusNo());
			assertNotNull(schedule.getExpectedArrivalTime());
			assertNotNull(schedule.getDestinationName());
		}
	}

	@Test
	public void testForStopH() {
		ResponseEntity<List<Schedule>> response = restTemplate.exchange(
				createURLWithPort("/schedule/greatportlandstreet/H"),
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Schedule>>() {});

		List<Schedule> schedules = response.getBody();
		assertEquals(response.getStatusCode().value(), 200);
		assertNotNull(schedules);
		assertTrue(schedules.size() > 0);
		for(Schedule schedule : schedules) {
			assertNotNull(schedule.getBusNo());
			assertNotNull(schedule.getExpectedArrivalTime());
			assertNotNull(schedule.getDestinationName());
		}
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
