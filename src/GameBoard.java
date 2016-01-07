import java.util.ArrayList;

import javax.swing.DefaultListModel;


public class GameBoard {
	private boolean Movepressed=false; //Flag to check for move button pressed
	private String HumanPlayer; //String used to display human player name
	private int SelectedHumanPlayer= 1;//(int)(Math.random()*3)+1;//Randomly assign human player
	
	//initialize cards
	private ArrayList<Card> DiscardDeck= new ArrayList<Card>();
	private ArrayList<Card> Deck= new ArrayList<Card>();
	private Card Card1=new CECS105("CECS 105","/CECS105.png",0,new int[]{10,17});
	private Card Card2=new Math122("Math 122","/Math122.png",4,new int[]{19});
	private Card Card3=new LunchBH("Lunch at Bratwurst Hall","/LunchAtBratwurst.png",0,new int[]{21});
	private Card Card4=new ResearchCompilers("Research Compilers","/ResearchCompilers.png",0,new int[]{19});
	private Card Card5=new CECS174("Professor Murgolo's CECS 174 Class","/CECS174.png",0,new int[]{10});
	private Card Card6=new CECS100("CECS 100","/CECS100.png",0,new int[]{17});
	private Card Card7=new MindandBody("Exercising Mind and Body","/ExerciseMindBody.png",0,new int[]{6});
	private Card Card8=new FindingTheLab("Finding the Lab","/FindLab.png",0,new int[]{16});
	private Card Card9=new EnjoyingPeace("Enjoying Peace","/EnjoyPeace.png",4,new int[]{2});
	private Card Card10=new ParkingViolation("Parking Violation","/ParkingViolation.png",0,new int[]{7});
	private Card Card11=new ByeProfessor("GoodBye, Professor","/GoodbyeProfessor.png",0,new int[]{15});
	private Card Card12=new BuddyUp("Buddy Up","/BuddyUp.png",2,new int[]{1,11});
	private Card Card13=new LateForClass("Late for Class","/LateForClass.png",0,new int[]{1,2,3,4,5,6,8,19,20,21});
	private Card Card14=new TheBigGame("The Big Game","/BigGame.png",0,new int[]{4});
	private Card Card15=new Math123("Math 123","/Math123.png",0,new int[]{10,17});
	private Card Card16=new Physics151("Physics 151","/Physics151.png",0,new int[]{17});
	private Card Card17=new Kin253("Kin 253","/KIN253.png",0,new int[]{1});
	private Card Card18=new LearningNetbeans("Learning NetBeans","/LearnNetbeans.png",0,new int[]{18});
	private Card Card19=new ChoosingAMajor("Choosing A Major","/ChooseMajor.png",0,new int[]{12});
	private Card Card20=new ScoreAGoal("Score A Goal","/ScoreGoal.png",0,new int[]{1});
	private Card Card21=new MakeDeanList("Make Dean's List","/DeansList.png",0,new int[]{13,14});
	private Card Card22=new PassSoccer("Pass Soccer Class","/PassSoccerClass.png",0,new int[]{1});
	private Card Card23=new FallinPond("Fall In Pond","/FallinPond.png",0,new int[]{2});
	private Card Card24=new NewLaptop("New Laptop","/NewLaptop.png",1,new int[]{9});
	private Card Card25=new MeetDean("Meet the Dean","/MeetDean.png",0,new int[]{13,14});
	private Card Card26=new ProgramCrashes("Program Crashes","/ProgramCrash.png",1,new int[]{18});
	private Card Card27=new RightFloor("Press the Right Floor","/PressRightFloor.png",0,new int[]{16});
	private Card Card28=new LoudBuzzing("LoudBuzzing","/LoudBuzzing.png",1,new int[]{11});
	private Card Card29=new ProfessorEnglert("Professor Englert","/ProfessorEnglert.png",1,new int[]{12});
	private Card Card30=new SoccerGoalie("Soccer Goalie","/SoccerGoalie.png",0,new int[]{1});
	private Card Card31=new ElectiveClass("Elective Class","/ElectiveClass.png",0,new int[]{19});
	private Card Card32=new ProfessorHoffman("Professor Hoffman","/ProfessorHoffman.png",0,new int[]{9,10,11,12,13,14,15,16,17});
	private Card Card33=new Outpost("The Outpost","/TheOutpost.png",1,new int[]{1,2,3,4,5,6,8,19,20,21});
	private Card Card34=new OralCommunication("Oral Communication","/OralComm.png",1,new int[]{3,6,4,19,20,21});
	private Card Card35=new CHEM111("CHEM 111","/CHEM111.png",0,new int[]{3,6,4,19,20,21});
	private Card Card36=new LearningLinux("Learning Linux","/LearnLinux.png",1,new int[]{9});
	private Card Card37=new MakeAFriend("Make A Friend","/MakeFriend.png",1,new int[]{13,14});
	private Card Card38=new EnjoyingNature("Enjoying Nature","/EnjoyNature.png",0,new int[]{1,2,3,4,5,6,7,8,19,20,21});
	private Card Card39=new StudentParking("Student Parking","/StudentParking.png",0,new int[]{3});
	private Card Card40=new LBSUvsUCI("LBSU Vs. UCI","/LBSUvsUCI.png",0,new int[]{4});
	private Card Card41=new CarPool("LBSU Vs. UCI","/CarPool.png",0,new int[]{3,7});
	private Card Card42=new CECS274("CECS 274","/CECS274.png",0,new int[]{9,10,17});
	private Card Card43=new CECS201("CECS 201","/CECS201.png",0,new int[]{9,10,17});
	private Card Card44=new CECS228("CECS 228","/CECS228.png",0,new int[]{9,10,17});
	private Card Card45=new CECS277("CECS 277","/CECS277.png",0,new int[]{9,10,11,12,13,14,15,16,17,18});
	private Card Card46=new CECS282("CECS 282","/CECS282.png",0,new int[]{9,10,11,12,13,14,15,16,17,18});
	private Card Card47=new CECS285("CECS 285","/CECS285.png",0,new int[]{2,11});
	private Card Card48=new ENGL317("ENGL 317","/ENGL317.png",0,new int[]{20});
	private Card Card49=new PHYS152("PHYS 152","/PHYS152.png",0,new int[]{19,20});
	private Card Card50=new PHIL270("PHIL 270","/PHIL270.png",0,new int[]{19,20});
	private Card Card51=new HaveASwim("Have A Swim","/HaveASwim.png",0,new int[]{6});
	//initialize rooms
	ArrayList<Room> RoomList = new ArrayList<Room>();
	private Room GAField=new Room("George Allen Field",35,83,1,new int[]{2,4,5,6});
	private Room JapaneseGardens=new Room("Japanese Gardens",445,65,2,new int[]{1,3,4});
	private Room StudentParking=new Room("Student Parking",993,83,3,new int[]{2,4,6,7});
	private Room Pyramid =new Room("Pyramid",425,301,4,new int[]{1,2,3,6,0,0,0});
	private Room WestWalkway =new Room("West Walkway",19,671,5,new int[]{1,6,13,19});
	private Room RecCenter =new Room("Rec Center",443,543,6,new int[]{1,3,4,5,7});
	private Room ForbiddenParking=new Room("Forbidden Parking",1037,589,7,new int[]{3,6,8});
	private Room EastWalkway=new Room("East Walkway",1480,980,8,new int[]{7,14,21});
	private Room ComputerLab =new Room("Computer Lab",181,895,9,new int[]{13});
	private Room ECS302 =new Room("ECS 302",600,910,10,new int[]{13,14});
	private Room EATClub =new Room("EAT Club",1035,893,11,new int[]{14});
	private Room ConferenceRoom=new Room("CECS Conference Room",1245,900,12,new int[]{14});
	private Room NorthHall=new Room("North Hall",190,1170,13,new int[]{5,9,10,14,15,16});
	private Room SouthHall=new Room("South Hall",860,1170,14,new int[]{8,10,11,12,13,17,18});
	private Room RoomRetirement=new Room("Room of Retirement",190,1375,15,new int[]{13});
	private Room Elevators=new Room("Elevators",610,1375,16,new int[]{13});
	private Room ECS308=new Room("ECS 308",820,1375,17,new int[]{14});
	private Room LactationLounge=new Room("Lactation Lounge",1230,1410,18,new int[]{14});
	private Room Library=new Room("Library",10,1730,19,new int[]{5,20});
	private Room LA5 =new Room("LA 5",470,1700,20,new int[]{19,21});
	private Room BratwurstHall=new Room("Bratwurst Hall",1020,1680,21,new int[]{20,8});
	
	//Initialize Players
	Player Jim= new Player("Jim",false,false,ECS302,5,5,5,0,0);
	Player Susy= new Player("Susy",false,false,ECS302,5,5,5,0,50);
	Player Bob=new Player("Bob",false,false,ECS302,5,5,5,0,100);
	
		
	GameBoard(){
		initialize();
	}
	
	private void initialize(){
		//Add all Cards to Deck
		Deck.add(Card1);
		Deck.add(Card2);
		Deck.add(Card3);
		Deck.add(Card4);
		Deck.add(Card5);
		Deck.add(Card6);
		Deck.add(Card7);
		Deck.add(Card8);
		Deck.add(Card9);
		Deck.add(Card10);
		Deck.add(Card11);
		Deck.add(Card12);
		Deck.add(Card13);
		Deck.add(Card14);
		Deck.add(Card15);
		Deck.add(Card16);
		Deck.add(Card17);
		Deck.add(Card18);
		Deck.add(Card19);
		Deck.add(Card20);
		Deck.add(Card21);
		Deck.add(Card22);
		Deck.add(Card23);
		Deck.add(Card24);
		Deck.add(Card25);
		Deck.add(Card26);
		Deck.add(Card27);
		Deck.add(Card28);
		Deck.add(Card29);
		Deck.add(Card30);
		Deck.add(Card31);
		Deck.add(Card32);
		Deck.add(Card33);
		Deck.add(Card34);
		Deck.add(Card35);
		Deck.add(Card36);
		Deck.add(Card37);
		Deck.add(Card38);
		Deck.add(Card39);
		
		//Add all rooms to master room list
		RoomList.add(GAField);
		RoomList.add(JapaneseGardens);
		RoomList.add(StudentParking);
		RoomList.add(Pyramid);
		RoomList.add(WestWalkway);
		RoomList.add(RecCenter);
		RoomList.add(ForbiddenParking);
		RoomList.add(EastWalkway);
		RoomList.add(ComputerLab);
		RoomList.add(ECS302);
		RoomList.add(EATClub);
		RoomList.add(ConferenceRoom);
		RoomList.add(NorthHall);
		RoomList.add(SouthHall);
		RoomList.add(RoomRetirement);
		RoomList.add(Elevators);
		RoomList.add(ECS308);
		RoomList.add(LactationLounge);
		RoomList.add(Library);
		RoomList.add(LA5);
		RoomList.add(BratwurstHall);
		
		//Set Human Player
		switch(SelectedHumanPlayer){
		case 1:
			Jim.SetHumanControlled(true);
			Jim.SetPlayerTurn(true);
			Jim.initializeHand(Deck);
			HumanPlayer="You are playing as Jim";
			break;
		case 2:
			Susy.SetHumanControlled(true);
			Susy.SetPlayerTurn(true);
			Susy.initializeHand(Deck);
			HumanPlayer="You are playing as Susy";
			break;
		case 3:
			Bob.SetHumanControlled(true);
			Bob.SetPlayerTurn(true);
			Bob.initializeHand(Deck);
			HumanPlayer="You are playing as Bob";
			break;
		default:
			Jim.SetHumanControlled(true);
			Jim.initializeHand(Deck);
			HumanPlayer="You are playing as Jim";
			break;	
		}
	}
	
	public DefaultListModel GetTurnPlayerPossibleRooms(){
		if(Jim.GetHumanControlled())
			return Jim.GetPossibleRooms();
		if(Susy.GetHumanControlled())
			return Susy.GetPossibleRooms();
		else 
			return Bob.GetPossibleRooms();
	}
	
	public ArrayList<Room> GetRoomList(){
		return RoomList;
	}
	
	public int GetJimPosX(){
		return Jim.GetPlayerXPosition();
	}
	
	public int GetJimPosY(){
		return Jim.GetPlayerYPosition();
	}
	
	public int GetSusyPosX(){
		return Susy.GetPlayerXPosition();
	}
	
	public int GetSusyPosY(){
		return Susy.GetPlayerYPosition();
	}
	
	public int GetBobPosX(){
		return Bob.GetPlayerXPosition();
	}
	
	public int GetBobPosY(){
		return Bob.GetPlayerYPosition();
	}
	
	public int GetDeckSize(){
		return Deck.size();
	}
	
	public int GetDiscardDeckSize(){
		return DiscardDeck.size();
	}
	
	public int[] GetJimPoints(){
		return new int[]{Jim.GetLearningChips(),Jim.GetIntegrityChips(),Jim.GetCraftChips(),Jim.GetQualityPoints()};
	}
	
	public int[] GetSusyPoints(){
		return new int[]{Susy.GetLearningChips(),Susy.GetIntegrityChips(),Susy.GetCraftChips(),Susy.GetQualityPoints()};
	}
	
	public int[] GetBobPoints(){
		return new int[]{Bob.GetLearningChips(),Bob.GetIntegrityChips(),Bob.GetCraftChips(),Bob.GetQualityPoints()};
	}
	
	public void Reshuffle(){
		Deck.addAll(DiscardDeck);
		DiscardDeck.clear();
	}
	
	public boolean GetTurnPlayerHuman(){
		if(Jim.getPlayerTurn())
			return Jim.GetHumanControlled();
		else if(Susy.getPlayerTurn())
			return Susy.GetHumanControlled();
		else 
			return Bob.GetHumanControlled();			
	}
	
	public void TurnPlayerDraw(){
		if(Jim.getPlayerTurn())
			Jim.DrawCard(Deck);
		else if(Susy.getPlayerTurn())
			Susy.DrawCard(Deck);
		else 
			Bob.DrawCard(Deck);	
	}
	
	public boolean TurnPlayerMoveAvailable(){
		if(Jim.getPlayerTurn()&&Jim.GetPlayerMoveCount()==0)
				return false;
		else if(Susy.getPlayerTurn()&&Susy.GetPlayerMoveCount()==0)
				return false;
		else if(Bob.getPlayerTurn()&&Bob.GetPlayerMoveCount()==0)
				return false;
		else
			return true;
	}
	
	public int GetTurnPlayerRoomID(){
		if(Jim.getPlayerTurn())
			return Jim.GetPlayerRoom().GetRoomID();
		else if(Susy.getPlayerTurn())
			return Susy.GetPlayerRoom().GetRoomID();
		else 
			return Bob.GetPlayerRoom().GetRoomID();
	}
	
	public void TurnPlayerNewRoom(Room NewRoom){
		if(Jim.getPlayerTurn())
			Jim.NewRoom(NewRoom);
		else if(Susy.getPlayerTurn())
			Susy.NewRoom(NewRoom);
		else 
			Bob.NewRoom(NewRoom);	
	}
	
	public int GetTurnPlayerPosX(){
		if(Jim.getPlayerTurn())
			return Jim.GetPlayerXPosition();
		else if(Susy.getPlayerTurn())
			return Susy.GetPlayerXPosition();
		else 
			return Bob.GetPlayerXPosition();
	}
	
	public int GetTurnPlayerPosY(){
		if(Jim.getPlayerTurn())
			return Jim.GetPlayerYPosition();
		else if(Susy.getPlayerTurn())
			return Susy.GetPlayerYPosition();
		else 
			return Bob.GetPlayerYPosition();
	}
	
	public int GetTurnPlayerChipDialogue(int HandIterator){
		if(Jim.getPlayerTurn())
			return Jim.GetHand().get(HandIterator).GetChipDialogVersion();
		else if(Susy.getPlayerTurn())
			return Susy.GetHand().get(HandIterator).GetChipDialogVersion();
		else 
			return Bob.GetHand().get(HandIterator).GetChipDialogVersion();
		
	}
	
	public String GetTurnPlayerCardPlayedName(int HandIterator){
		if(Jim.getPlayerTurn())
			return Jim.GetHand().get(HandIterator).GetCardName();
		else if(Susy.getPlayerTurn())
			return Susy.GetHand().get(HandIterator).GetCardName();
		else 
			return Bob.GetHand().get(HandIterator).GetCardName();
		
	}
	
	public void TurnPlayerPlayCard(int HandIterator,int ChipSelected){
		if(Jim.getPlayerTurn())
			Jim.PlayCard(HandIterator,ChipSelected,DiscardDeck,Deck,RoomList);
		else if(Susy.getPlayerTurn())
			Susy.PlayCard(HandIterator,ChipSelected,DiscardDeck,Deck,RoomList);
		else 
			Bob.PlayCard(HandIterator,ChipSelected,DiscardDeck,Deck,RoomList);
		
	}
	
	public void TurnPlayerResetMoveCount(){
		if(Jim.getPlayerTurn())
			Jim.ResetMoveCount();
		else if(Susy.getPlayerTurn())
			Susy.ResetMoveCount();
		else 
			Bob.ResetMoveCount();
	}
	
	public int TurnPlayerHandSize(){
		if(Jim.getPlayerTurn())
			return Jim.GetHand().size();
		else if(Susy.getPlayerTurn())
			return Susy.GetHand().size();
		else 
			return Bob.GetHand().size();
	}
	
	public void TurnPlayerDiscard(int HandIterator){
		if(Jim.getPlayerTurn())
			Jim.RemoveCard(HandIterator, DiscardDeck);
		else if(Susy.getPlayerTurn())
			Susy.RemoveCard(HandIterator, DiscardDeck);
		else 
			Bob.RemoveCard(HandIterator, DiscardDeck);
	}
	
	public void NextPlayerTurn(){
		if(Jim.getPlayerTurn()){
			Jim.SetPlayerTurn(false);
			Susy.SetPlayerTurn(true);
		}
		else if(Susy.getPlayerTurn()){
			Susy.SetPlayerTurn(false);
			Bob.SetPlayerTurn(true);
		}
		else {
			Bob.SetPlayerTurn(false);
			Jim.SetPlayerTurn(true);
		}
	}
	
	public Room GetTurnPlayerRoom(){
		if(Jim.getPlayerTurn())
			return Jim.GetPlayerRoom();
		else if(Susy.getPlayerTurn())
			return Susy.GetPlayerRoom();
		else 
			return Bob.GetPlayerRoom();
	}
	
	public int[] AIGetCorrectRooms(int i){
		return Deck.get(i).GetCorrectRooms();
	}
	
	public void TurnPlayerAddCard(int i){
		if(Jim.getPlayerTurn())
			Jim.AddCard(i,Deck);
		else if(Susy.getPlayerTurn())
			Susy.AddCard(i,Deck);
		else 
			Bob.AddCard(i,Deck);
	}
	
	public ArrayList<Card> GetHumanPlayerHand(){
		if(Jim.GetHumanControlled())
			return Jim.GetHand();
		else if(Susy.GetHumanControlled())
			return Susy.GetHand();
		else 
			return Bob.GetHand();
	}
	
	public String GetTurnPlayerName(){
		if(Jim.getPlayerTurn())
			return Jim.GetPlayerName();
		else if(Susy.getPlayerTurn())
			return Susy.GetPlayerName();
		else 
			return Bob.GetPlayerName();
		
	}
	
	public int QPTotal(){
		return (Jim.GetQualityPoints()+Susy.GetQualityPoints()+Bob.GetQualityPoints());
	}
	
	public void DiscardHand(){
		if(Jim.GetHumanControlled())
			Jim.DiscardHand(DiscardDeck);
		else if(Susy.GetHumanControlled())
			Susy.DiscardHand(DiscardDeck);
		else 
			Bob.DiscardHand(DiscardDeck);
	}
	
	public void RemoveYear1Cards(){
		ArrayList<Card> RemovedCards = new ArrayList<Card>();
		RemovedCards.add(Card6);
		RemovedCards.add(Card5);
		RemovedCards.add(Card1);
		RemovedCards.add(Card15);
		RemovedCards.add(Card16);
		RemovedCards.add(Card17);
		RemovedCards.add(Card22);
		RemovedCards.add(Card31);
		RemovedCards.add(Card34);
		RemovedCards.add(Card35);
		Deck.removeAll(RemovedCards);
	}
	
	public void AddYear2Cards(){
		ArrayList<Card> Year2Cards = new ArrayList<Card>();
		Year2Cards.add(Card40);
		Year2Cards.add(Card41);
		Year2Cards.add(Card42);
		Year2Cards.add(Card43);
		Year2Cards.add(Card44);
		Year2Cards.add(Card45);
		Year2Cards.add(Card46);
		Year2Cards.add(Card47);
		Year2Cards.add(Card48);
		Year2Cards.add(Card49);
		Year2Cards.add(Card50);
		Year2Cards.add(Card51);
		Deck.addAll(Year2Cards);
		if(Jim.GetHumanControlled())
			Jim.initializeHand(Deck);
		else if(Susy.GetHumanControlled())
			Susy.initializeHand(Deck);
		else 
			Bob.initializeHand(Deck);
	}
	
	public void ClearDeck(){
		Deck.clear();
	}
}
