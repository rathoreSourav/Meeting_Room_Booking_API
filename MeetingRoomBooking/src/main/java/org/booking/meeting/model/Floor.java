package org.booking.meeting.model;

public class Floor {
	private int floorId;
	private int floorNumber;
	private int roomsAvailablity;
	private String floorName;
	private Room room;

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getRoomsAvailablity() {
		return roomsAvailablity;
	}

	public void setRoomsAvailablity(int roomsAvailablity) {
		this.roomsAvailablity = roomsAvailablity;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public Floor(String floorName) {
		super();
		this.floorName = floorName;
	}

	@Override
	public String toString() {
		return "Floor [floorId=" + floorId + ", floorNumber=" + floorNumber + ", roomsAvailablity=" + roomsAvailablity
				+ "]";
	}

}
