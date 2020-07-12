# Meeting_Room_Booking_API
Swagger link: http://localhost:8080/swagger-ui.html#

## Supported API:
### GET, POST

### DESCRIPTION: <br />
GET /api/room : return all the rooms <br />
GET /api/room/building name: returns all the rooms of given building <br />
GET /api/room/buildingname/floor : return all the rooms on the given floor of given building<br />
<br />
POST /api/room/{roomID}/{bookedBY} : make booking room ID and booking name should not be not null, upon succesful booking should return Unique booking reference.<br />
POST /api/room/{bookingRef} : cancel booking with associated booking reference, should return success or failed based on cancellation response<br />
