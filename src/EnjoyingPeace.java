import java.util.ArrayList;

public class EnjoyingPeace extends Card{
	public EnjoyingPeace(String Name, String Path, int Version,int[]CR){
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
		int[] CorrectRooms=new int[]{2};
		
		for(int i=0; i<CorrectRooms.length;i++)
			if(TempPlayer.GetPlayerRoom().GetRoomID()==CorrectRooms[i])
				Success=true;
		
			if(Success){
				switch(ChipChoice){
				case 1:
					TempPlayer.IncPoints(1, 0, 0, 0);
					break;
				case 2:
					TempPlayer.IncPoints(0, 0, 1, 0);
					break;
				case 3:
					TempPlayer.IncPoints(0, 1, 0, 0);
					break;
				default:
					break;			
				}
			}
			else
				TempPlayer.IncPoints(0,0,0,-2);
	
	}
}
