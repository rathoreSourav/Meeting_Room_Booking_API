package org.booking.meeting.service;

import java.util.List;

import org.booking.meeting.dao.BookingDAO;
import org.booking.meeting.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

	@Autowired
	private BookingDAO bookingDAO;

	public List<Room> allRooms() {
		return bookingDAO.getRoomByBuildingName();
	}

	public String makeBooking(int roomId, String bookedBy) {
		return bookingDAO.doBooking(roomId, bookedBy);

	}

	public List<Room> getRoomByBuildingName(String bName) {
		return bookingDAO.getRoomByBuildingName(bName);
	}

	public List<Room> getRoomsByBuildingandFloor(String bName, String floor) {
		return bookingDAO.getRoomByBuildingName(bName, floor);
	}

	public String doCancelBooking(String bookingRef) {
		int makeCancelBooking = bookingDAO.makeCancelBooking(bookingRef);
		if (makeCancelBooking==1) {
			return "SUCCESS";
		}
		else
			return "FAILED";
	}
}
