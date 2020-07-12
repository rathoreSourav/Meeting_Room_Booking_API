package org.booking.meeting.model;

public class Building {
	private int buildingID;
	private String buildingName;
	private int floorAvalablity;
	private int roomsAvalablity;
	private Floor floor;
	private Room room;

	public Building(String buildingName) {
		this.buildingName = buildingName;
	}

	public int getBuildingID() {
		return buildingID;
	}

	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public int getFloorAvalablity() {
		return floorAvalablity;
	}

	public void setFloorAvalablity(int floorAvalablity) {
		this.floorAvalablity = floorAvalablity;
	}

	public int getRoomsAvalablity() {
		return roomsAvalablity;
	}

	public void setRoomsAvalablity(int roomsAvalablity) {
		this.roomsAvalablity = roomsAvalablity;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Building [buildingID=" + buildingID + ", buildingName=" + buildingName + ", floorAvalablity="
				+ floorAvalablity + ", roomsAvalablity=" + roomsAvalablity + "]";
	}

}
