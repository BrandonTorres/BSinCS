import java.util.ArrayList;

public class PHIL270 extends Card{
	public PHIL270(String Name, String Path, int Version,int[]CR){
		CardName=Name;
		imagePath=Path;
		ChipDialogVersion=Version;
	}
	public void PlayCard(Player currentPlayer,int ChipChoice,ArrayList<Card> Discard,ArrayList<Card> Deck,ArrayList<Room> RoomList){
		//The array holds the RoomID values of where the card must be played MODIFY VALUES
		int[] CorrectRooms=new int[]{19,20};
		boolean Success=false;
		Player TempPlayer=currentPlayer;
		ArrayList<Card> TempDiscard=Discard;
		ArrayList<Card> TempDeck=Deck;
		
		for(int i=0; i<CorrectRooms.length;i++)
			if(TempPlayer.GetPlayerRoom().GetRoomID()==CorrectRooms[i]&&TempPlayer.GetIntegrityChips()>=7)
				Success=true;
				
				//If statement is used to make sure all requirements are met. The functions are GetCraftChips, GetQualityPoints, and GetIntegrityChips
				if(Success){
					//(LearningChips,IntegrityChips,CraftChips,QualityPoints) MODIFY VALUES
					TempPlayer.IncPoints(1, 0, 0, 3);			
				}
				else{
					//failure condition modify as needed
					TempPlayer.IncPoints(0,0,0,-5);
				}
			
	
	}

}
