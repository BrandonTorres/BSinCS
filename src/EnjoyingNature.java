import java.util.ArrayList;

public class EnjoyingNature extends Card {
	public EnjoyingNature(String Name, String Path, int Version,int[]CR){
		CardName=Name;
		imagePath=Path;
		ChipDialogVersion=Version;
		CorrectRooms=CR;
	}
	public void PlayCard(Player currentPlayer,int ChipChoice,ArrayList<Card> Discard,ArrayList<Card> Deck,ArrayList<Room> RoomList){
		
		Player TempPlayer=currentPlayer;
		ArrayList<Card> TempDiscard=Discard;
		ArrayList<Card> TempDeck=Deck;
		boolean Success = false;
		//The array holds the RoomID values of where the card must be played MODIFY VALUES
		int[] CorrectRooms=new int[]{1,2,3,4,5,6,7,8,19,20,21};
		
		for(int i=0; i<CorrectRooms.length;i++)
			if(TempPlayer.GetPlayerRoom().GetRoomID()==CorrectRooms[i])
				Success=true;
		
			if(Success){
				//(LearningChips,IntegrityChips,CraftChips,QualityPoints) MODIFY VALUES
				TempPlayer.IncPoints(0, 0, 1, 0);
				//Used to change room when needed. Refer to CSULB Map for room ID number. Use RoomID-1 in place of arg
				TempPlayer.NewRoom(RoomList.get(17));

			}
			else{
				//failure condition modify as needed
				TempPlayer.IncPoints(0,0,0,-2);
			}
	
	}
}
