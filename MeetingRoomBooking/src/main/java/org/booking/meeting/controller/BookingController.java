package org.booking.meeting.controller;

import java.util.List;

import org.booking.meeting.exception.CustomBookingException;
import org.booking.meeting.model.Room;
import org.booking.meeting.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookingController {

	@Autowired
	private BookingService service;

	@GetMapping("/room")
	public ResponseEntity<List<Room>> getAvailableRooms() {
		List<Room> allRooms = service.allRooms();
		return new ResponseEntity<List<Room>>(allRooms, HttpStatus.OK);
	}

	@GetMapping("/room/{building}/{floor}")
	public ResponseEntity<List<Room>> getAvailableRoomsByBuilding(@PathVariable("building") String bName,
			@PathVariable("floor") String floor) {
		List<Room> roomsByBuildingandFloor = service.getRoomsByBuildingandFloor(bName, floor);
		return new ResponseEntity<List<Room>>(roomsByBuildingandFloor, HttpStatus.OK);
	}

	@GetMapping("/room/{buildingName}")
	public ResponseEntity<List<Room>> getAvailableRoomsByFloor(@PathVariable("buildingName") String buildName) {
		List<Room> roomByBuildingName = service.getRoomByBuildingName(buildName);
		return new ResponseEntity<List<Room>>(roomByBuildingName, HttpStatus.OK);
	}

	@PostMapping("/room/{roomID}/{bookedBY}")
	public ResponseEntity<String> bookMeetingRoom(@PathVariable("roomID") String roomID,
			@PathVariable("bookedBY") String bookedBY) {
		System.out.println("inside post");
		if (bookedBY != null || roomID != null) {
			int roomId = Integer.parseInt(roomID);
			String bookedBy = bookedBY;
			String makeBooking = service.makeBooking(roomId, bookedBy);
			return new ResponseEntity<String>(makeBooking, HttpStatus.CREATED);
		} else {
			throw new CustomBookingException("ERROR WHILE BOOKING: ALREADY BOOKED");
		}
	}

	@PostMapping("/room/{bookingRef}")
	public ResponseEntity<String> cancelBooking(@PathVariable("bookingRef") String bookingRef) {
		String doCancelBooking = service.doCancelBooking(bookingRef);
		return new ResponseEntity<String>(doCancelBooking, HttpStatus.OK);
	}
}
