import java.util.ArrayList;

public class CarPool extends Card{
	public CarPool(String Name, String Path, int Version,int[]CR){
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
		int[] CorrectRooms=new int[]{3,7};
		
		for(int i=0; i<CorrectRooms.length;i++)
			if(TempPlayer.GetPlayerRoom().GetRoomID()==CorrectRooms[i]&&TempPlayer.GetIntegrityChips()>=5)
				Success=true;
		
			if(Success){
				//(LearningChips,IntegrityChips,CraftChips,QualityPoints) MODIFY VALUES
				TempPlayer.IncPoints(0,0,0,3);
				if(TempPlayer.GetHumanControlled())
						TempPlayer.DrawCard(TempDeck);
			}
			else {
				TempPlayer.IncPoints(0,0,0,-4);
			}
	}
}
