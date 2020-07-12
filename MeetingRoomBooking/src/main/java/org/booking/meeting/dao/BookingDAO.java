package org.booking.meeting.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.booking.meeting.model.Building;
import org.booking.meeting.model.Floor;
import org.booking.meeting.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookingDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Room> getRoomByBuildingName() {

		String query = "SELECT room_id, room_name, building_id, is_booked, booked_by, floor_id\r\n"
				+ "	FROM public.\"Rooms\";";

		List<Room> roomsList = jdbcTemplate.query(query,
				(rs, rowNum) -> new Room(rs.getInt("room_id"), rs.getString("room_name"), rs.getInt("building_id"),
						rs.getBoolean("is_booked"), rs.getString("booked_by"), rs.getInt("floor_id")));

		for (Iterator iterator = roomsList.iterator(); iterator.hasNext();) {
			Room room = (Room) iterator.next();
			room.setFloor(getFloorName(room.getFloorId()));
			room.setBuilding(getBuildingName(room.getBuildingID()));
			;
		}
		return roomsList;

	}

	public List<Room> getRoomByBuildingName(String bName) {
		String getBuildingIdQuery = "SELECT building_id FROM  public.\"Building\" WHERE building_name = ?";
		Integer buildinId = jdbcTemplate.queryForObject(getBuildingIdQuery, new Object[] { bName }, Integer.class);

		String query = "SELECT room_id, room_name, building_id, is_booked, booked_by, floor_id\r\n"
				+ "	FROM public.\"Rooms\" WHERE building_id ='" + buildinId + "'";

		return jdbcTemplate.query(query,
				(rs, rowNum) -> new Room(rs.getInt("room_id"), rs.getString("room_name"), rs.getInt("building_id"),
						rs.getBoolean("is_booked"), rs.getString("booked_by"), rs.getInt("floor_id")));
	}

	public String doBooking(int roomId, String bookedBy) {
		String checkBooking = "SELECT is_booked FROM  public.\"Rooms\" WHERE room_id = ?";
		Boolean value = jdbcTemplate.queryForObject(checkBooking, new Object[] { roomId }, Boolean.class);
		System.out.println(value);
		if (!value) {
			String bookingReference = getBookingReference();
			String bookQuery = "UPDATE public.\"Rooms\" SET is_booked='true', booked_by ='" + bookedBy
					+ "', booking_ref ='" + bookingReference + "' WHERE room_id =" + roomId;
			int update = jdbcTemplate.update(bookQuery);
			if (update == 1)
				return bookingReference;
		} else {
			return "Sorry room is already booked!";
		}
		return null;
	}

	public static String getBookingReference() {
		int leftLimit = 65;
		int rightLimit = 90;
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		return buffer.toString();
	}

	public List<Room> getRoomByBuildingName(String bName, String floor) {
		String getBuildingIdQuery = "SELECT building_id FROM  public.\"Building\" WHERE building_name = ?";
		Integer buildinId = jdbcTemplate.queryForObject(getBuildingIdQuery, new Object[] { bName }, Integer.class);

		String getFloorIdQuery = "SELECT floor_id FROM  public.\"Floors\" WHERE floor_name = ? AND building_id = ?";
		Integer floorId = jdbcTemplate.queryForObject(getFloorIdQuery, new Object[] { floor, buildinId },
				Integer.class);
		String query = "SELECT room_id, room_name, building_id, is_booked, booked_by, floor_id\r\n"
				+ "	FROM public.\"Rooms\" WHERE building_id ='" + buildinId + "'AND floor_id = '" + floorId + "'";

		List<Room> roomsList = jdbcTemplate.query(query,
				(rs, rowNum) -> new Room(rs.getInt("room_id"), rs.getString("room_name"), rs.getInt("building_id"),
						rs.getBoolean("is_booked"), rs.getString("booked_by"), rs.getInt("floor_id")));

		for (Iterator iterator = roomsList.iterator(); iterator.hasNext();) {
			Room room = (Room) iterator.next();
			room.setFloor(floor);
			room.setBuilding(bName);
			;
		}
		return roomsList;
	}

	private String getFloorName(int floorID) {
		String getFloorNameQuery = "SELECT floor_name FROM  public.\"Floors\" WHERE floor_id =" + floorID;
		return jdbcTemplate.query(getFloorNameQuery, (rs, rowNum) -> new Floor(rs.getString("floor_name"))).get(0)
				.getFloorName();
	}

	private String getBuildingName(int builingId) {
		String getFloorNameQuery = "SELECT building_name FROM  public.\"Building\" WHERE building_id = " + builingId;
		return jdbcTemplate.query(getFloorNameQuery, (rs, rowNum) -> new Building(rs.getString("building_name"))).get(0)
				.getBuildingName();
	}

	public int makeCancelBooking(String bookingRef) {
		String cancelQuery = "UPDATE public.\"Rooms\"\r\n"
				+ "	SET is_booked='false', booked_by=null, booking_ref=null\r\n" + "	WHERE booking_ref='"
				+ bookingRef + "'";
		return jdbcTemplate.update(cancelQuery);
	}

}
