import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;


public class Main {
	public static void main(String[] args) {
		//initialize model
		GameBoard GamePieces=new GameBoard();	
		
		//initialize controller
		GameController Controller = new GameController();
		
		//Initialize GUI
		Main_Window window = new Main_Window();
		window.initialize();
		window.initializeDiscardDialog();
		
		//phase
		boolean SecondYear = false;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.Display.setVisible(true);
					
					window.SetDeckCount(GamePieces.GetDeckSize());
					window.SetDiscardCount(GamePieces.GetDiscardDeckSize());
					window.SetRoomList(GamePieces.GetTurnPlayerPossibleRooms());
					window.SetAllRoomList(GamePieces.GetRoomList());
					window.SetHand(GamePieces.GetHumanPlayerHand());
					window.SetInitialCardImage();
					window.SetPlayer1XYPixel(GamePieces.GetJimPosX(), GamePieces.GetJimPosY());
					window.SetPlayer2XYPixel(GamePieces.GetSusyPosX(), GamePieces.GetSusyPosY());
					window.SetPlayer3XYPixel(GamePieces.GetBobPosX(), GamePieces.GetBobPosY());
					window.SetPlayer1Points(GamePieces.GetJimPoints());
					window.SetPlayer2Points(GamePieces.GetSusyPoints());
					window.SetPlayer3Points(GamePieces.GetBobPoints());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		//Game Flow	
		while(true){
			if((GamePieces.QPTotal()>60)&&!SecondYear){
				GamePieces.DiscardHand();
				GamePieces.Reshuffle();
				GamePieces.RemoveYear1Cards();
				GamePieces.AddYear2Cards();
				SecondYear=true;
				window.SetInitialCardImage();
				
			}
			window.SetDeckCount(GamePieces.GetDeckSize());
			window.SetDiscardCount(GamePieces.GetDiscardDeckSize());
			if(GamePieces.GetDeckSize()==0){
				GamePieces.Reshuffle();
				window.SetDeckCount(GamePieces.GetDeckSize());
				window.SetDiscardCount(GamePieces.GetDiscardDeckSize());
			}
			Controller.ProcessPlayerTurn(GamePieces, window);
			try
	        {Thread.sleep(200);}
			catch (Exception e)
	        {	System.out.println("Sleep Error");
				e.printStackTrace();}
						
		}
	}
	
}


