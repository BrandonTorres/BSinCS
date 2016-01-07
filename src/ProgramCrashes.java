import java.util.ArrayList;

public class ProgramCrashes extends Card {
	private Main_Window window = new Main_Window();
	public ProgramCrashes(String Name, String Path, int Version,int[]CR){
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
		int[] CorrectRooms=new int[]{18};
		
		for(int i=0; i<CorrectRooms.length;i++)
			if(TempPlayer.GetPlayerRoom().GetRoomID()==CorrectRooms[i]&&TempPlayer.GetLearningChips()>=2)
				Success=true;
		
			if(Success){
				switch(ChipChoice){
				case 1:
					TempPlayer.IncPoints(1, 0, 0, 5);
					break;
				case 2:
					TempPlayer.IncPoints(0, 0, 1, 5);
					break;
				case 3:
					TempPlayer.IncPoints(0, 1, 0, 5);
					break;
				default:
					break;			
				}
			}
			else{
				TempPlayer.IncPoints(0,0,0,-2);
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
