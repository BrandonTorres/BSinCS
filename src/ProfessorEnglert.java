import java.util.ArrayList;

public class ProfessorEnglert extends Card{
	private Main_Window window = new Main_Window();
	public ProfessorEnglert(String Name, String Path, int Version,int[]CR){
		CardName=Name;
		imagePath=Path;
		ChipDialogVersion=Version;
		CorrectRooms=CR;
	}
	public void PlayCard(Player currentPlayer,int ChipChoice,ArrayList<Card> Discard,ArrayList<Card> Deck,ArrayList<Room> RoomList){
		//The array holds the RoomID values of where the card must be played MODIFY VALUES
		window.initializeDiscardDialog();
		window.SetHand(currentPlayer.GetHand());
		int[] CorrectRooms=new int[]{12};
		boolean Success=false;
		Player TempPlayer=currentPlayer;
		ArrayList<Card> TempDiscard=Discard;
		ArrayList<Card> TempDeck=Deck;
		
		for(int i=0; i<CorrectRooms.length;i++)
			if(TempPlayer.GetPlayerRoom().GetRoomID()==CorrectRooms[i]&&TempPlayer.GetIntegrityChips()>=3)
				Success=true;
				
				//If statement is used to make sure all requirements are met. The functions are GetCraftChips, GetQualityPoints, and GetIntegrityChips
				if(Success){
					//If the card allows you to pick your chip insert the following switch statement and modify the IncPoints Values as needed
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
					//Statement used to draw card if needed
					/*
					if(TempPlayer.GetHumanControlled())
						TempPlayer.DrawCard(TempDeck);
					*/
					
					//Used to change room when needed. Refer to CSULB Map for room ID number. Use RoomID-1 in place of arg
					//TempPlayer.NewRoom(RoomList.get(arg));
					
					
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
