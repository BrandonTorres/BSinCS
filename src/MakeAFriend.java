import java.util.ArrayList;

public class MakeAFriend extends Card{
	private Main_Window window = new Main_Window();
	public MakeAFriend(String Name, String Path, int Version,int[]CR){
		CardName=Name;
		imagePath=Path;
		ChipDialogVersion=Version;
		CorrectRooms=CR;
	}
	public void PlayCard(Player currentPlayer,int ChipChoice,ArrayList<Card> Discard,ArrayList<Card> Deck,ArrayList<Room> RoomList){
		window.initializeDiscardDialog();
		window.SetHand(currentPlayer.GetHand());
		Player TempPlayer=currentPlayer;
		ArrayList<Card> TempDiscard=Discard;
		ArrayList<Card> TempDeck=Deck;
		boolean Success = false;
		//The array holds the RoomID values of where the card must be played MODIFY VALUES
		int[] CorrectRooms=new int[]{13,14};
		
		for(int i=0; i<CorrectRooms.length;i++)
			if(TempPlayer.GetPlayerRoom().GetRoomID()==CorrectRooms[i]&&TempPlayer.GetIntegrityChips()>=2)
				Success=true;
		
			if(Success){
				//(LearningChips,IntegrityChips,CraftChips,QualityPoints) MODIFY VALUES
				TempPlayer.IncPoints(0, 0, 0, 3);
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
			else{
				//failure condition modify as needed
				TempPlayer.IncPoints(0,0,0,-2);
				//If discard is needed then add the following statement
				if(TempPlayer.GetHumanControlled()){
					window.DiscardDialog();
					while(!window.GetDiscardButtonPressed())
					try
			        {Thread.sleep(50);}
					catch (Exception e)
			        {	System.out.println("Sleep Error");
						e.printStackTrace();}
					window.ResetDiscardButtonPressed();
					TempPlayer.RemoveCard(window.GetDiscardChoice(), TempDiscard);
					}
			}
	
	}
}
