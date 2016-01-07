import java.awt.List;

import javax.swing.DefaultListModel;


public class Room {
	String RoomName; //The name of the room. Used to display the name of available rooms to the user
	private int XpixLoc; // X and Y pixel coordinates are used to show where the player name is to be displayed
	private int YpixLoc;
	private int RoomID;  // RoomID is used to identify the room within the program. Not visible to user.
	private DefaultListModel PossRoomNames = new DefaultListModel();
	
	public Room(){
		RoomName=" ";
		XpixLoc=0;
		YpixLoc=0;
		RoomID=0;
	}
	public Room(String Name, int x, int y, int ID,int[] possRooms){
		RoomName = Name;
		XpixLoc=x;
		YpixLoc=y;
		RoomID=ID;
		for(int i=0;i<possRooms.length;i++){
			switch(possRooms[i]){
			case 0:
				break;
			case 1:
				PossRoomNames.addElement("George Allen Field");
				break;
			case 2:
				PossRoomNames.addElement("Japanese Gardens");
				break;
			case 3:
				PossRoomNames.addElement("Student Parking");
				break;
			case 4:
				PossRoomNames.addElement("Pyramid");
				break;
			case 5:
				PossRoomNames.addElement("West Walkway");
				break;
			case 6:
				PossRoomNames.addElement("Rec Center");
				break;
			case 7:
				PossRoomNames.addElement("Forbidden Parking");
				break;
			case 8:
				PossRoomNames.addElement("East Walkway");
				break;
			case 9:
				PossRoomNames.addElement("Computer Lab");
				break;
			case 10:
				PossRoomNames.addElement("ECS 302");
				break;
			case 11:
				PossRoomNames.addElement("EAT Club");
				break;
			case 12:
				PossRoomNames.addElement("CECS Conference Room");
				break;
			case 13:
				PossRoomNames.addElement("North Hall");
				break;
			case 14:
				PossRoomNames.addElement("South Hall");
				break;
			case 15:
				PossRoomNames.addElement("Room of Retirement");
				break;
			case 16:
				PossRoomNames.addElement("Elevators");
				break;
			case 17:
				PossRoomNames.addElement("ECS 308");
				break;
			case 18:
				PossRoomNames.addElement("Lactation Lounge");
				break;
			case 19:
				PossRoomNames.addElement("Library");
				break;
			case 20:
				PossRoomNames.addElement("LA 5");
				break;
			case 21:
				PossRoomNames.addElement("Bratwurst Hall");
				break;
			default:
				break;
			}
		}
		
	}
	
	
	public String GetRoomName(){
		return RoomName;		
	}
	
	public int GetYPosition(){
		return YpixLoc;
	}
	
	public int GetXPosition(){
		return XpixLoc;
	}
	
	public int GetRoomID(){
		return RoomID;
	}
	public int GetPossibleRoomSize(){
		return PossRoomNames.size();
	}
	public DefaultListModel GetPossibleRoomsList(){
		return PossRoomNames;
	}
	
	public void SetRoom(Room NewRoom){
		RoomName=NewRoom.GetRoomName();
		XpixLoc=NewRoom.GetXPosition();
		YpixLoc=NewRoom.GetYPosition();
		RoomID=NewRoom.GetRoomID();
		this.PossRoomNames.clear();
		for(int i=0;i<NewRoom.PossRoomNames.getSize();i++){
			if (i < 0 || i >= NewRoom.PossRoomNames.getSize()) {
			    System.out.println("Found it 2");
			}
			PossRoomNames.addElement(NewRoom.PossRoomNames.get(i));
		}
	}
}
