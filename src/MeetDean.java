import java.util.ArrayList;

public class MeetDean extends Card{
	private Main_Window window=new Main_Window();
	public MeetDean(String Name, String Path, int Version,int[]CR){
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
			if(TempPlayer.GetPlayerRoom().GetRoomID()==CorrectRooms[i]&&TempPlayer.GetIntegrityChips()>=3&&TempPlayer.GetCraftChips()>=3&&TempPlayer.GetLearningChips()>=3)
				Success=true;
		
			if(Success){
				//(LearningChips,IntegrityChips,CraftChips,QualityPoints) MODIFY VALUES
				TempPlayer.IncPoints(0, 0, 0, 5);
				if(TempPlayer.GetHumanControlled())
					TempPlayer.DrawCard(TempDeck);
			}
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
