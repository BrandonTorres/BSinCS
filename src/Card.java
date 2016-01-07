import java.util.ArrayList;

public class Card {
	protected String CardName;
	protected String imagePath;
	protected int ChipDialogVersion;
	protected int CorrectRooms[];
	
	public Card(){
		CardName="Null";
		imagePath="Null";
		ChipDialogVersion=0;
	}
	
	public Card(String Name, String Path, int Version, int[] CR){
		CardName=Name;
		imagePath=Path;
		ChipDialogVersion=Version;
		CorrectRooms=(int[])CR.clone();
	}
	public int[] GetCorrectRooms(){
		return CorrectRooms;
	}
	public String GetimagePath(){
		return imagePath;
	}
	
	public String GetCardName(){
		return CardName;
	}
	public int GetChipDialogVersion(){
		return ChipDialogVersion;
	}
	
	public void PlayCard(Player currentPlayer,int ChipChoice,ArrayList<Card> Discard,ArrayList<Card> Deck,ArrayList<Room> RoomList){
		int[] CorrectRoomsz=new int[]{13,14};
		Player TempPlayer=currentPlayer;
		ArrayList<Card> TempDiscard=Discard;
		ArrayList<Card> TempDeck=Deck;
		
		for(int i=0; i<CorrectRoomsz.length;i++)
			if(TempPlayer.GetPlayerRoom().GetRoomID()==CorrectRooms[i]){
				TempPlayer.IncPoints(1, 2, 3, 5);
				break;
			}
		TempPlayer.IncPoints(-2,-2,-2,-2);
	}
}
 