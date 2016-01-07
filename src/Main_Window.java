import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.Box;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextArea;




public class Main_Window {

	public JFrame Display;
	private DefaultListModel RoomList = new DefaultListModel();
	private ArrayList<Room> AllRoomList = new ArrayList<Room>();
	private ArrayList<Card> Hand;
	private String PlayerString;
	private int Player1XPixel;
	private int Player1YPixel;
	private int Player2XPixel;
	private int Player2YPixel;
	private int Player3XPixel;
	private int Player3YPixel;
	private int HandIterator=0;
	private int CardPlayed;
	private int DiscardChoice;
	private int MoveCount=3;
	private int ChipSelection;
	private Room NewRoom = new Room();
	private boolean MoveBtnPressed;
	private boolean DrawBtnPressed;
	private boolean PlayBtnPressed;
	private boolean DiscardBtnPressed;
	private boolean ChipSelected;
	private JButton PlayCardBTN;
	private JButton MoveBTN;
	private JButton DrawCardBTN;
	private JButton LearningButton;
	private JButton CraftButton;
	private JButton IntegrityButton;
	private JLabel CardImage;
	private JPanel CardArea;
	private JLabel JimIntegrity;
	private JLabel JimCraft;
	private JLabel JimLearning;
	private JLabel JimQuality;
	private JLabel SusyIntegrity;
	private JLabel SusyCraft;
	private JLabel SusyLearning;
	private JLabel SusyQuality;
	private JLabel BobIntegrity;
	private JLabel BobCraft;
	private JLabel BobLearning;
	private JLabel BobQuality;
	private JLabel DeckCount;
	private JLabel DiscardCount;
	private JLabel lblJimPlayStatus;
	private JLabel lblSusyplaystatus;
	private JLabel lblBobplaystatus;
	private JTextField Player1 = new JTextField();
	private JTextField Player2 = new JTextField();
	private JTextField Player3 = new JTextField();
	private JList PossibleMovesList;
	private JLabel lblJim = new JLabel("Jim");
	private JPanel DiscardSelection;
	private JDialog DiscardDialog;
	private JLabel DiscardImage;
	private JDialog ChipDialog;
	

	/**
	 * Create the application.
	 */
	public Main_Window() {
		
	}
	
	public void initialize() {
		Display = new JFrame();
		Display.setBounds(100, 100, 1204, 1011);
		Display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Display.getContentPane().setLayout(new BoxLayout(Display.getContentPane(), BoxLayout.PAGE_AXIS));
		
		JScrollPane GameBoardScrollPane = new JScrollPane();
		GameBoardScrollPane.setMinimumSize(new Dimension(24, 720));
		Display.getContentPane().add(GameBoardScrollPane);
		
		JLabel GameBoardLabel = new JLabel("");
		Player1.setText("Jim");
		Player1.setBackground(new Color(255, 255, 255));
		Player1.setEditable(false);
		Player1.setFont(new Font("Calibri", Font.BOLD, 40));
		Player1.setBounds(Player1XPixel, Player1YPixel, 70, 50);
		Player2.setText("Susy");
		Player2.setBackground(new Color(255, 255, 255));
		Player2.setEditable(false);
		Player2.setFont(new Font("Calibri", Font.BOLD, 40));
		Player2.setBounds(Player2XPixel, Player2YPixel, 70, 50);
		Player3.setText("Bob");
		Player3.setBackground(new Color(255, 255, 255));
		Player3.setEditable(false);
		Player3.setFont(new Font("Calibri", Font.BOLD, 40));
		Player3.setBounds(Player3XPixel, Player3YPixel, 70, 50);
		GameBoardLabel.setIcon(new ImageIcon(Main_Window.class.getResource("/CSULBMap3.png")));
		GameBoardLabel.add(Player1);
		GameBoardLabel.add(Player2);
		GameBoardLabel.add(Player3);
		GameBoardScrollPane.setViewportView(GameBoardLabel);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
		Display.getContentPane().add(horizontalBox);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		horizontalBox.add(verticalBox);
		
		DrawCardBTN = new JButton("Draw Card");
		DrawCardBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HandIterator=0;
				CardImage.setIcon(new ImageIcon(Main_Window.class.getResource(Hand.get(HandIterator).GetimagePath())));
				DrawCardBTN.setEnabled(false);
				MoveBTN.setEnabled(true);
				PlayCardBTN.setEnabled(true);
				DrawBtnPressed=true;
				
			}
		});
		DrawCardBTN.setPreferredSize(new Dimension(100, 23));
		DrawCardBTN.setMinimumSize(new Dimension(100, 23));
		DrawCardBTN.setMaximumSize(new Dimension(100, 23));
		DrawCardBTN.setAlignmentY(Component.TOP_ALIGNMENT);
		DrawCardBTN.setAlignmentX(Component.CENTER_ALIGNMENT);
		DrawCardBTN.setHorizontalAlignment(SwingConstants.LEFT);
		verticalBox.add(DrawCardBTN);
		
		MoveBTN = new JButton("Move");
		MoveBTN.setEnabled(false);
		MoveBTN.setAlignmentY(Component.TOP_ALIGNMENT);
		MoveBTN.setPreferredSize(new Dimension(100, 23));
		MoveBTN.setMinimumSize(new Dimension(100, 23));
		MoveBTN.setMaximumSize(new Dimension(100, 23));
		MoveBTN.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(MoveBTN);
		MoveBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Count of listeners: " + ((JButton) e.getSource()).getActionListeners().length);
					MoveBtnPressed=true;
					MoveCount--;
					String SelectedValue = (String) PossibleMovesList.getSelectedValue();
					for(int i=0;i<AllRoomList.size();i++){
						if (i < 0 || i >= AllRoomList.size()) {
						    System.out.println("Found it");
						}
						if(AllRoomList.get(i).GetRoomName().equals(SelectedValue)){
							NewRoom.SetRoom(AllRoomList.get(i));
						}
					}
					if(MoveCount==0)
						MoveBTN.setEnabled(false);
			}
		});
		
		PlayCardBTN = new JButton("Play Card");
		PlayCardBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayBtnPressed=true;
				CardPlayed=HandIterator;
				HandIterator=0;
				DrawCardBTN.setEnabled(true);
				PlayCardBTN.setEnabled(false);
				MoveBTN.setEnabled(false);
				MoveCount=3;
				CardImage.setIcon(new ImageIcon(Main_Window.class.getResource(Hand.get(HandIterator).GetimagePath())));
			}
		});
		PlayCardBTN.setEnabled(false);
		PlayCardBTN.setAlignmentY(Component.TOP_ALIGNMENT);
		PlayCardBTN.setMinimumSize(new Dimension(100, 23));
		PlayCardBTN.setMaximumSize(new Dimension(100, 23));
		PlayCardBTN.setPreferredSize(new Dimension(100, 23));
		PlayCardBTN.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(PlayCardBTN);
		
		
		PossibleMovesList = new JList(RoomList);
		PossibleMovesList.setMinimumSize(new Dimension(150, 150));
		PossibleMovesList.setMaximumSize(new Dimension(150, 600));
		verticalBox.add(PossibleMovesList);
		PossibleMovesList.setBackground(Color.WHITE);
		
		CardArea = new JPanel();
		CardArea.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		CardArea.setMaximumSize(new Dimension(400, 400));
		horizontalBox.add(CardArea);
		CardImage = new JLabel("");
		//CardImage.setIcon(new ImageIcon(Main_Window.class.getResource("");
		CardArea.add(CardImage);
		CardArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	if(HandIterator<Hand.size()-1)
            		HandIterator=HandIterator+1;
            	else
            		HandIterator=0;
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            	CardImage.setIcon(new ImageIcon(Main_Window.class.getResource(Hand.get(HandIterator).GetimagePath())));
            }
        });
		
		Box verticalBox_1 = Box.createVerticalBox();
		horizontalBox.add(verticalBox_1);
		
		JPanel Status = new JPanel();
		Status.setForeground(Color.WHITE);
		Status.setMaximumSize(new Dimension(3000, 500));
		Status.setPreferredSize(new Dimension(10, 800));
		verticalBox_1.add(Status);
		Status.setBackground(Color.WHITE);
		Status.setLayout(null);
		
		
		lblJim.setVerticalAlignment(SwingConstants.TOP);
		lblJim.setBounds(10, 28, 29, 13);
		Status.add(lblJim);
		
		JLabel lblSusy = new JLabel("Susy");
		lblSusy.setBounds(10, 52, 46, 14);
		Status.add(lblSusy);
		
		JLabel lblBob = new JLabel("Bob");
		lblBob.setBounds(10, 77, 46, 14);
		Status.add(lblBob);
		
		JLabel lblLearning = new JLabel("Learning");
		lblLearning.setBounds(110, 11, 58, 14);
		Status.add(lblLearning);
		
		JLabel lblCraft = new JLabel("Craft");
		lblCraft.setBounds(178, 11, 46, 14);
		Status.add(lblCraft);
		
		JLabel lblIntegrity = new JLabel("Integrity");
		lblIntegrity.setBounds(234, 11, 46, 14);
		Status.add(lblIntegrity);
		
		JLabel lblQualityPoints = new JLabel("Quality Points");
		lblQualityPoints.setBounds(290, 11, 106, 14);
		Status.add(lblQualityPoints);
		
		JimLearning = new JLabel("0");
		JimLearning.setBounds(110, 28, 29, 14);
		Status.add(JimLearning);
		
		SusyLearning = new JLabel("0");
		SusyLearning.setBounds(110, 52, 46, 14);
		Status.add(SusyLearning);
		
		BobLearning = new JLabel("0");
		BobLearning.setBounds(110, 77, 46, 14);
		Status.add(BobLearning);
		
		JimCraft = new JLabel("0");
		JimCraft.setBounds(178, 28, 29, 14);
		Status.add(JimCraft);
		
		SusyCraft = new JLabel("0");
		SusyCraft.setBounds(178, 52, 29, 14);
		Status.add(SusyCraft);
		
		BobCraft = new JLabel("0");
		BobCraft.setBounds(178, 77, 29, 14);
		Status.add(BobCraft);
		
		JimIntegrity = new JLabel("0");
		JimIntegrity.setBounds(234, 28, 46, 14);
		Status.add(JimIntegrity);
		
		SusyIntegrity = new JLabel("0");
		SusyIntegrity.setBounds(234, 52, 46, 14);
		Status.add(SusyIntegrity);
		
		BobIntegrity = new JLabel("0");
		BobIntegrity.setBounds(234, 77, 46, 14);
		Status.add(BobIntegrity);
		
		JimQuality = new JLabel("0");
		JimQuality.setBounds(290, 28, 46, 14);
		Status.add(JimQuality);
		
		SusyQuality = new JLabel("0");
		SusyQuality.setBounds(290, 52, 46, 14);
		Status.add(SusyQuality);
		
		BobQuality = new JLabel("0");
		BobQuality.setBounds(290, 77, 46, 14);
		Status.add(BobQuality);
		
		JLabel lblCardsInDeck = new JLabel("Cards in Deck:");
		lblCardsInDeck.setBounds(10, 131, 83, 14);
		Status.add(lblCardsInDeck);
		
		JLabel lblCardsDiscarded = new JLabel("Cards Discarded:");
		lblCardsDiscarded.setBounds(290, 131, 106, 14);
		Status.add(lblCardsDiscarded);
		
		DeckCount = new JLabel("0");
		DeckCount.setBounds(122, 131, 46, 14);
		Status.add(DeckCount);
		
		DiscardCount = new JLabel("0");
		DiscardCount.setBounds(403, 131, 46, 14);
		Status.add(DiscardCount);
		
		Component verticalStrut = Box.createVerticalStrut(10);
		verticalBox_1.add(verticalStrut);
		
		JPanel PlayerName = new JPanel();
		PlayerName.setMinimumSize(new Dimension(10, 155));
		PlayerName.setMaximumSize(new Dimension(32767, 55));
		verticalBox_1.add(PlayerName);
		PlayerName.setBackground(Color.WHITE);
		PlayerName.setLayout(null);
		
		lblJimPlayStatus = new JLabel(" ");
		lblJimPlayStatus.setBounds(10, 0, 413, 14);
		PlayerName.add(lblJimPlayStatus);
		
		lblSusyplaystatus = new JLabel("");
		lblSusyplaystatus.setBounds(10, 24, 413, 14);
		PlayerName.add(lblSusyplaystatus);
		
		lblBobplaystatus = new JLabel("");
		lblBobplaystatus.setBounds(10, 49, 398, 14);
		PlayerName.add(lblBobplaystatus);
		
		ChipDialog = new JDialog();
		ChipDialog.getContentPane().setLayout(new BoxLayout(ChipDialog.getContentPane(), BoxLayout.PAGE_AXIS));
		
		LearningButton = new JButton("Learing");
		LearningButton.setMaximumSize(new Dimension(200, 200));
		LearningButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		LearningButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChipSelected=true;
				ChipSelection=1;
				Display.setEnabled(true);
				ChipDialog.setVisible(false);
			}
		});
		
		CraftButton = new JButton("Craft");
		CraftButton.setMaximumSize(new Dimension(200, 200));
		CraftButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		CraftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChipSelected=true;
				ChipSelection=2;
				Display.setEnabled(true);
				ChipDialog.setVisible(false);
			}
		});
		
		IntegrityButton = new JButton("Integrity");
		IntegrityButton.setMaximumSize(new Dimension(200, 200));
		IntegrityButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		IntegrityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChipSelected=true;
				ChipSelection=3;
				Display.setEnabled(true);
				ChipDialog.setVisible(false);
			}
		});
		
		ChipDialog.setMinimumSize(new Dimension(140,340));
		ChipDialog.getContentPane().add(LearningButton);
		ChipDialog.getContentPane().add(CraftButton);
		ChipDialog.getContentPane().add(IntegrityButton);
	}
	
	

	
	public void SetRoomList(DefaultListModel Rooms){
		this.RoomList.clear();
		for(int i=0;i<Rooms.getSize();i++){
			if (i < 0 || i >= Rooms.getSize()) {
			    System.out.println("Found it 4");
			}
			this.RoomList.addElement(Rooms.get(i));
		}
	
	}
	public void initializeDiscardDialog(){
		DiscardSelection = new JPanel();
		DiscardSelection.setMaximumSize(new Dimension(400, 400));
		DiscardImage = new JLabel("");
		DiscardSelection.add(DiscardImage);
		DiscardSelection.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	if(HandIterator<Hand.size()-1)
            		HandIterator=HandIterator+1;
            	else
            		HandIterator=0;
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            	DiscardImage.setIcon(new ImageIcon(Main_Window.class.getResource(Hand.get(HandIterator).GetimagePath())));
            }
        });
		DiscardDialog = new JDialog();
		DiscardDialog.getContentPane().setLayout(new BoxLayout(DiscardDialog.getContentPane(), BoxLayout.PAGE_AXIS));
		
		JButton DiscardBtn = new JButton("Discard");
		DiscardBtn.setMaximumSize(new Dimension(140, 100));
		DiscardBtn.setMinimumSize(new Dimension(130, 100));
		DiscardBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		DiscardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DiscardBtnPressed=true;
				DiscardChoice=HandIterator;
        		HandIterator=0;
        		if(Display!=null)
        			Display.setEnabled(true);
				DiscardDialog.setVisible(false);
				//CardImage.setIcon(new ImageIcon(Main_Window.class.getResource(Hand.get(HandIterator+1).GetimagePath())));
			}
		});
		DiscardDialog.setMinimumSize(new Dimension(140,340));
		DiscardDialog.getContentPane().add(DiscardSelection);
		DiscardDialog.getContentPane().add(DiscardBtn);
	}
	public void DiscardDialog(){
		DiscardImage.setIcon(new ImageIcon(Main_Window.class.getResource(Hand.get(HandIterator).GetimagePath())));
		if(Display!=null)
			Display.setEnabled(false);
		DiscardDialog.setVisible(true);	
	}
	
	public void ChipDialog(int Version){
		switch(Version){
		case 1:
			LearningButton.setEnabled(true);
			CraftButton.setEnabled(true);
			IntegrityButton.setEnabled(true);
			break;
		case 2:
			LearningButton.setEnabled(true);
			CraftButton.setEnabled(true);
			IntegrityButton.setEnabled(false);
			break;
		case 3:
			LearningButton.setEnabled(false);
			CraftButton.setEnabled(true);
			IntegrityButton.setEnabled(true);
			break;
		case 4:
			LearningButton.setEnabled(true);
			CraftButton.setEnabled(false);
			IntegrityButton.setEnabled(true);
			break;
		default:
			LearningButton.setEnabled(true);
			CraftButton.setEnabled(true);
			IntegrityButton.setEnabled(true);
			break;
		}
		Display.setEnabled(false);
		ChipDialog.setVisible(true);	
	}
	
	public void SetAllRoomList(ArrayList<Room> AllRooms){
		this.AllRoomList.clear();
		for(int i=0;i<AllRooms.size();i++){
			if (i < 0 || i >= AllRooms.size()) {
			    System.out.println("Found it 3");
			}
			this.AllRoomList.add(AllRooms.get(i));
		}
	}
	public void SetHumanPlayerString(String HumanPlayer){
		PlayerString=HumanPlayer;
		lblJim.setText(PlayerString);
	}
	public void SetHand(ArrayList<Card> PlayerHand){
		Hand=PlayerHand;
	}
	
	public Room GetNewRoom(){
		return NewRoom;
	}
	
	public boolean GetMoveButtonPressed(){
		 return MoveBtnPressed;
	}
	
	public boolean GetPlayButtonPressed(){
		 return PlayBtnPressed;
	}
	
	public boolean GetDrawButtonPressed(){
		 return DrawBtnPressed;
	}
	public boolean GetDiscardButtonPressed(){
		 return DiscardBtnPressed;
	}
	public boolean GetChipSelected(){
		return ChipSelected;
	}
	public void ResetChipSelected(){
		ChipSelected=false;
	}
	public void ResetMoveButtonPressed(){
		MoveBtnPressed=false;
	}
	public void ResetDiscardButtonPressed(){
		DiscardBtnPressed=false;
	}
	
	public void ResetDrawButtonPressed(){
		DrawBtnPressed=false;
	}
	
	public void ResetPlayButtonPressed(){
		PlayBtnPressed=false;
	}
	
	public void SetPlayer1XYPixel(int x,int y){
		Player1XPixel=x;
		Player1YPixel=y;
		Player1.setBounds(Player1XPixel, Player1YPixel, 70, 50);
	}
	
	public void SetPlayer2XYPixel(int x,int y){
		Player2XPixel=x;
		Player2YPixel=y;
		Player2.setBounds(Player2XPixel, Player2YPixel, 90, 50);
	}
	
	public void SetPlayer3XYPixel(int x,int y){
		Player3XPixel=x;
		Player3YPixel=y;
		Player3.setBounds(Player3XPixel, Player3YPixel, 70, 60);
	}
	
	public void SetPlayer1Points(int[] Points){
		String TempString="";
		JimLearning.setText(TempString.valueOf(Points[0]));
		JimIntegrity.setText(TempString.valueOf(Points[1]));
		JimCraft.setText(TempString.valueOf(Points[2]));
		JimQuality.setText(TempString.valueOf(Points[3]));
		
	}
	public void SetPlayer2Points(int[] Points){
		String TempString="";
		SusyLearning.setText(TempString.valueOf(Points[0]));
		SusyIntegrity.setText(TempString.valueOf(Points[1]));
		SusyCraft.setText(TempString.valueOf(Points[2]));
		SusyQuality.setText(TempString.valueOf(Points[3]));
		
	}
	public void SetPlayer3Points(int[] Points){
		String TempString="";
		BobLearning.setText(TempString.valueOf(Points[0]));
		BobIntegrity.setText(TempString.valueOf(Points[1]));
		BobCraft.setText(TempString.valueOf(Points[2]));
		BobQuality.setText(TempString.valueOf(Points[3]));
		
	}
	public void SetDeckCount(int count){
		String TempString="";
		DeckCount.setText(TempString.valueOf(count));
	}
	public void SetDiscardCount(int count){
		String TempString="";
		DiscardCount.setText(TempString.valueOf(count));
	}
	
	public void SetInitialCardImage(){
		CardImage.setIcon(new ImageIcon(Main_Window.class.getResource(Hand.get(HandIterator).GetimagePath())));
	}
	
	public int GetCardPlayed(){
		return CardPlayed;
	}
	public int GetDiscardChoice(){
		return DiscardChoice;
	}
	public int GetChipSelection(){
		return ChipSelection;
	}
	public void SetJimPlayStatus(String CardName){
		lblJimPlayStatus.setText("Jim Played "+CardName);
	}
	public void SetSusyPlayStatus(String CardName){
		lblSusyplaystatus.setText("Susy Played "+CardName);
	}
	public void SetBobPlayStatus(String CardName){
		lblBobplaystatus.setText("Bob Played "+CardName);
	}
}
