import java.util.ArrayList;

public class ProfessorHoffman extends Card {
	public ProfessorHoffman(String Name, String Path, int Version,int[]CR){
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
	int[] CorrectRooms=new int[]{9,10,11,12,13,14,15,16,17};
		
		for(int i=0; i<CorrectRooms.length;i++)
			if(TempPlayer.GetPlayerRoom().GetRoomID()==CorrectRooms[i]&&TempPlayer.GetLearningChips()>=3)
				Success=true;
		
			if(Success){
				//(LearningChips,IntegrityChips,CraftChips,QualityPoints) MODIFY VALUES
				TempPlayer.IncPoints(0, 0, 0, 5);
				if(TempPlayer.GetHumanControlled()) {
					TempPlayer.DrawCard(TempDeck);
					TempPlayer.DrawCard(TempDeck);
				}
			}
			else {
				TempPlayer.IncPoints(0,0,0,-7);
				TempPlayer.NewRoom(RoomList.get(17));
			}
	
	}
}
