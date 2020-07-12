package org.booking.meeting.model;

public class Room {
	
	private int roomID;
	private String roomName;
	private int buildingID;
	private boolean isBooked;
	private String bookedBy;
	private int floorId;
	private String floor;
	private String building;
	
	
	public Room(int roomID, String roomName, int buildingID, boolean isBooked, String bookedBy, int floorId) {
		super();
		this.roomID = roomID;
		this.roomName = roomName;
		this.buildingID = buildingID;
		this.isBooked = isBooked;
		this.bookedBy = bookedBy;
		this.floorId = floorId;
	}
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getBuildingID() {
		return buildingID;
	}
	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}
	public boolean isBooked() {
		return isBooked;
	}
	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	public String getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}
	public int getFloorId() {
		return floorId;
	}
	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}
	
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	@Override
	public String toString() {
		return "Room [roomID=" + roomID + ", roomName=" + roomName + ", buildingID=" + buildingID + ", isBooked="
				+ isBooked + ", bookedBy=" + bookedBy + ", floorId=" + floorId + "]";
	}
	public Room() {
		super();
	}
	
	
}
