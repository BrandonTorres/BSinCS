import java.util.ArrayList;


public class GameController {
	GameController(){};
	
	
	public void ProcessPlayerTurn(GameBoard GamePieces,Main_Window window){
		if(GamePieces.GetTurnPlayerHuman()){
			if(window.GetDrawButtonPressed()){
				GamePieces.TurnPlayerDraw();
				window.ResetDrawButtonPressed();
			}
			if(window.GetMoveButtonPressed()&&(GamePieces.TurnPlayerMoveAvailable())){
				window.ResetMoveButtonPressed();
				if((window.GetNewRoom().GetRoomID()!=GamePieces.GetTurnPlayerRoomID()&&(window.GetNewRoom().GetRoomID()!=0))){
					GamePieces.TurnPlayerNewRoom(window.GetNewRoom());
				window.SetRoomList(GamePieces.GetTurnPlayerPossibleRooms());
				TagMover(GamePieces,window);
				}
			}
			if(window.GetPlayButtonPressed()){
				if(GamePieces.GetTurnPlayerChipDialogue(window.GetCardPlayed())!=0){
					window.ChipDialog(GamePieces.GetTurnPlayerChipDialogue(window.GetCardPlayed()));
					while(!window.GetChipSelected())
						try
				        {Thread.sleep(50);}
						catch (Exception e)
				        {	System.out.println("Sleep Error");
							e.printStackTrace();}
					    window.ResetChipSelected();
					}
				StatusUpdater(GamePieces, window,window.GetCardPlayed());
				GamePieces.TurnPlayerPlayCard(window.GetCardPlayed(), window.GetChipSelection());
				window.ResetPlayButtonPressed();
				GamePieces.TurnPlayerResetMoveCount();
				window.SetDiscardCount(GamePieces.GetDiscardDeckSize());
				while(GamePieces.TurnPlayerHandSize()>6){
					window.DiscardDialog();
					while(!window.GetDiscardButtonPressed())
					try
			        {Thread.sleep(50);}
					catch (Exception e)
			        {	System.out.println("Sleep Error");
						e.printStackTrace();}
					window.ResetDiscardButtonPressed();
					GamePieces.TurnPlayerDiscard(window.GetDiscardChoice());
					window.SetDiscardCount(GamePieces.GetDiscardDeckSize());
				}
				window.SetRoomList(GamePieces.GetTurnPlayerPossibleRooms());
				PointUpdater(GamePieces, window);
				TagMover(GamePieces,window);
				GamePieces.NextPlayerTurn();
			}
			
		}
			else{
				int RandomIteration=(int)(Math.random()*3)+1;
				for(int j=0;j<RandomIteration;j++)
					GamePieces.TurnPlayerNewRoom(RandomRoom(GamePieces.GetTurnPlayerRoom(),GamePieces.GetRoomList()));
				TagMover(GamePieces,window);
				
				AICardSelector(GamePieces);
				StatusUpdater(GamePieces, window,0);
				GamePieces.TurnPlayerPlayCard(0,0);
				
				GamePieces.TurnPlayerResetMoveCount();
				window.SetDiscardCount(GamePieces.GetDiscardDeckSize());
				PointUpdater(GamePieces, window);
				TagMover(GamePieces,window);
				GamePieces.NextPlayerTurn();
			}
			
		
		
	}
	/*
	public void SecondYearTransition(GameBoard GamePieces){
			GamePieces.DiscardHand();
			GamePieces.
	}*/
	
	private Room RandomRoom(Room CurrentRoom,ArrayList<Room> RoomList){
		int RandomSelector=(int)(Math.random()*CurrentRoom.GetPossibleRoomSize());
		
		for(int i=0;i<RoomList.size();i++){
			if(RoomList.get(i).GetRoomName().equals(CurrentRoom.GetPossibleRoomsList().get(RandomSelector))){
				return RoomList.get(i);	
			}
		}
		return RoomList.get(0);
	}
	
	private void AICardSelector(GameBoard GamePieces){
		for(int i=0;i<GamePieces.GetDeckSize();i++){
			boolean FoundACard=false;
			for(int j=0;j<GamePieces.AIGetCorrectRooms(i).length;j++)
				if(GamePieces.AIGetCorrectRooms(i)[j]==GamePieces.GetTurnPlayerRoomID()){
					GamePieces.TurnPlayerAddCard(i);
					FoundACard=true;
					return;
				}
			if(i==GamePieces.GetDeckSize()-1&&!FoundACard)
				GamePieces.TurnPlayerDraw();
		}
	}
	
	private void TagMover(GameBoard GamePieces, Main_Window window){
		switch(GamePieces.GetTurnPlayerName()){
		case "Jim":
			window.SetPlayer1XYPixel(GamePieces.GetTurnPlayerPosX(), GamePieces.GetTurnPlayerPosY());
			break;
		case "Susy":
			window.SetPlayer2XYPixel(GamePieces.GetTurnPlayerPosX(), GamePieces.GetTurnPlayerPosY());
			break;
		case "Bob":
			window.SetPlayer3XYPixel(GamePieces.GetTurnPlayerPosX(), GamePieces.GetTurnPlayerPosY());
			break;	
		}
	}
	
	private void PointUpdater(GameBoard GamePieces, Main_Window window){
		switch(GamePieces.GetTurnPlayerName()){
		case "Jim":
			window.SetPlayer1Points(GamePieces.GetJimPoints());
			break;
		case "Susy":
			window.SetPlayer2Points(GamePieces.GetSusyPoints());
			break;
		case "Bob":
			window.SetPlayer3Points(GamePieces.GetBobPoints());
			break;	
		}
		
	}
	
	private void StatusUpdater(GameBoard GamePieces, Main_Window window, int index){
		switch(GamePieces.GetTurnPlayerName()){
		case "Jim":
			window.SetJimPlayStatus(GamePieces.GetTurnPlayerCardPlayedName(index));
			break;
		case "Susy":
			window.SetSusyPlayStatus(GamePieces.GetTurnPlayerCardPlayedName(index));
			break;
		case "Bob":
			window.SetBobPlayStatus(GamePieces.GetTurnPlayerCardPlayedName(index));
			break;	
		}
		
	}
	
}
