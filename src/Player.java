import java.util.ArrayList;

import javax.swing.DefaultListModel;


public class Player {
	private String PlayerName;
	private boolean CurrentTurnPlayer;
	private boolean HumanControlled;
	private Room CurrentRoom= new Room();
	private int QualityPoints;
	private int LearningChips;
	private int CraftChips;
	private int IntegrityChips;
	private int YPixelOffset;
	private ArrayList<Card> Hand = new ArrayList<Card>();
	private int MoveCount;
	
	public Player(){
		PlayerName=" ";
		CurrentTurnPlayer=false;
		HumanControlled=false;
		CurrentRoom=new Room();
		LearningChips=0;
		CraftChips=0;
		IntegrityChips=0;
		QualityPoints=0;
		YPixelOffset=0;	
		MoveCount=3;
	}
	public Player(String Name,boolean TurnPlayer, boolean HumanPlayer, Room StartingRoom, int lc, int cc, int ic, int QP, int YPOffset){
		PlayerName=Name;
		CurrentTurnPlayer=TurnPlayer;
		HumanControlled=HumanPlayer;
		CurrentRoom.SetRoom(StartingRoom);
		LearningChips=lc;
		CraftChips=cc;
		IntegrityChips=ic;
		QualityPoints=QP;
		YPixelOffset=YPOffset;	
		MoveCount=3;
	}
	public void initializeHand(ArrayList<Card> Deck){
		ArrayList<Card> TempDeck=Deck;
		for(int i=0;i<5;i++){
			int RandomValue=(int)(Math.random()*TempDeck.size());
			Hand.add(TempDeck.get(RandomValue));
			TempDeck.remove(RandomValue);
		}
	}
	public void DrawCard(ArrayList<Card> Deck){
		ArrayList<Card> TempDeck=Deck;
		int RandomValue=(int)(Math.random()*TempDeck.size());
		Hand.add(TempDeck.get(RandomValue));
		TempDeck.remove(RandomValue);
	}
	public void AddCard(int index,ArrayList<Card> Deck){
		ArrayList<Card> TempDeck=Deck;
		Hand.add(TempDeck.get(index));
		TempDeck.remove(index);
	}
	public void SetPlayerTurn(boolean isTurn){
		CurrentTurnPlayer=isTurn;
	}
	
	public void SetHumanControlled(boolean isHuman){
		HumanControlled=isHuman;
	}
	public boolean GetHumanControlled(){
		return HumanControlled;
	}
	public void NewRoom(Room NewRoom){
		CurrentRoom.SetRoom(NewRoom);
		MoveCount--;
	}
	
	public void SetPlayerName(String Name){
		PlayerName=Name;
	}
	
	public boolean getPlayerTurn(){
		return CurrentTurnPlayer;
	}
	
	public String GetPlayerName(){
		return PlayerName;
	}
	public int GetPlayerXPosition(){
		return CurrentRoom.GetXPosition();
	}
	public int GetPlayerYPosition(){
		return (CurrentRoom.GetYPosition()+YPixelOffset);
	}
	public ArrayList<Card> GetHand(){
		return Hand;
	}
	public DefaultListModel GetPossibleRooms(){
		return CurrentRoom.GetPossibleRoomsList();
	}
	public Room GetPlayerRoom(){
		return CurrentRoom;
	}
	public int GetLearningChips(){
		return LearningChips;
	}
	public int GetIntegrityChips(){
		return IntegrityChips;
	}
	public int GetCraftChips(){
		return CraftChips;
	}
	public int GetQualityPoints(){
		return QualityPoints;
	}
	public int GetPlayerMoveCount(){
		return MoveCount;
	}
	public void PlayCard(int handCard,int ChipChoice,ArrayList<Card> Discard,ArrayList<Card> Deck,ArrayList<Room> RoomList){
		ArrayList<Card>tempDiscard=Discard;
		ArrayList<Card> tempDeck=Deck;
		System.out.println(Hand.get(handCard).GetCardName());
		tempDiscard.add(Hand.get(handCard));
		Hand.remove(handCard);
		//Hand.get(handCard).PlayCard(this,ChipChoice,tempDiscard,tempDeck,RoomList);
		tempDiscard.get(tempDiscard.size()-1).PlayCard(this,ChipChoice,tempDiscard,tempDeck,RoomList);
		
		
	}
	public void RemoveCard(int handCard,ArrayList<Card> Discard){
		ArrayList<Card>tempDiscard=Discard;
		tempDiscard.add(Hand.get(handCard));
		Hand.remove(handCard);
	}
	public void DiscardHand(ArrayList<Card> Discard){
		int Size=Hand.size();
		for(int i=0;i<Size;i++)
			this.RemoveCard(0, Discard);
	}
	public void IncPoints(int lc,int ic, int cc, int qp){
			LearningChips=LearningChips+lc;
			IntegrityChips=IntegrityChips+ic;
			CraftChips=CraftChips+cc;
			QualityPoints=QualityPoints+qp;
			if(QualityPoints<0)
				QualityPoints=0;
		
	}
	public void ResetMoveCount(){
		MoveCount=3;
		
	}
	
}
