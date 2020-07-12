package org.booking.meeting.controller.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.booking.meeting.controller.BookingController;
import org.booking.meeting.model.Room;
import org.booking.meeting.service.BookingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Jdbc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookingController.class)
public class BookingControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private JdbcTemplate Jdbc;
	
	@MockBean
	private BookingService mockBookingService;
	

	@Test
	public void should_return_list_of_rooms() throws Exception {
		String uri = "/api/room";
		Room firstRoom = new Room(1, "firstRoom", 1, false, null, 2);
		Room secondRoom = new Room(2, "secondRoom", 2, true, "Sourav", 1);

		when(mockBookingService.allRooms()).thenReturn(Arrays.asList(firstRoom, secondRoom));

		RequestBuilder requestBuilder1 = get(uri).accept(org.springframework.http.MediaType.APPLICATION_JSON);
		RequestBuilder requestBuilder2 = get(uri).accept(org.springframework.http.MediaType.APPLICATION_XML);

		mockMvc.perform(requestBuilder1).andExpect(status().isOk());

		mockMvc.perform(requestBuilder2).andExpect(status().isOk());
		verify(mockBookingService, times(2)).allRooms();
	}
}
