/**
 * The GUI class.
 * 
 * Created by Sylvia Allain
 * University of Maine
 * COS 226 - Final Project
 * DATE : 12/13/2012
 * 
 * 
 * This class allows the user to interact with the program via a 'pretty' interface.
 * 
 * Methods :
 * 
 * public GUI()
 * public static void addComponentsToPane(Container pane)
 * private static void createAndShowGUI()
 * private static void submitAction()
 * private static void goAction()
 * public void actionPerformed(ActionEvent arg0)
 * public static void main(String[] args)
 * 
 */

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


public class GUI extends JPanel implements ActionListener {

    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    
    private static Mods m = new Mods();
    
    private static int prelimNum = 1;
    
    //Teams that will play in prelim
    // These are overwritten when a new prelim occurs.
    
    private static String team1;
    private static String team2;
    private static String team3;
    private static String team4;
    private static String team5;
    private static String team6;
    private static String team7;
    private static String team8;
    private static String team9;
    private static String team10;
    
    // Labels for ranking column
    
    private static JLabel rank1;
    private static JLabel rank2;
    private static JLabel rank3;
    private static JLabel rank4;
    private static JLabel rank5;
    private static JLabel rank6;
    private static JLabel rank7;
    private static JLabel rank8;
    private static JLabel rank9;
    private static JLabel rank10;
    
    // other labels
    
    private static JLabel title;
    private static JLabel prelimWinners;
    private static JLabel ranking;
    private static JLabel teamHistory;
    private static JLabel team1Label;
    private static JLabel team2Label;
    private static JLabel team3Label;
    private static JLabel team4Label;
    private static JLabel team5Label;
    private static JLabel team6Label;
    private static JLabel team7Label;
    private static JLabel team8Label;
    private static JLabel team9Label;
    private static JLabel team10Label;
    private static JLabel vsLabel;
    private static JLabel rank;
    private static JTextArea team1Score;
    private static JTextArea team2Score;
    private static JTextArea team3Score;
    private static JTextArea team4Score;
    private static JTextArea team5Score;
    private static JTextArea team6Score;
    private static JTextArea team7Score;
    private static JTextArea team8Score;
    private static JTextArea team9Score;
    private static JTextArea team10Score;
    private static JButton submit;
	
    private static JComboBox teams;
    private static JTextArea teamData;
    private static JButton go;
    
    private static JTextArea runningTimes;
    
    private static JLabel authors;
    
	public GUI()
	{
		
	}
	
	/*
     * Purpose stated simply in method name
     */
	public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
		
        Color paneColor = new Color(64,224,208);
        Color titleColor = new Color(74, 250, 230);
        Color titleTextColor = new Color(1, 100, 70);
        Color textBoxColor = new Color(215,255,250);
        
        Font titleFont = new Font("Serif", Font.BOLD, 35);
        Font headingFont = new Font("Serif", Font.PLAIN, 20);

        Border raisedBorder = BorderFactory.createRaisedBevelBorder();
        Border loweredBorder = BorderFactory.createLoweredBevelBorder();
        
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		if (shouldFill) {
		//natural height, maximum width
		c.fill = GridBagConstraints.HORIZONTAL;
		}
		
		pane.setBackground(paneColor);
		
		title = new JLabel("                Heal Point Ranking System");
		title.setFont(titleFont);
		title.setBackground(titleColor);
		title.setForeground(titleTextColor);
		title.setBorder(raisedBorder);
		title.setOpaque(true);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;
		c.weightx = 0.0;
		c.gridwidth = 12;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(title, c);
		
		prelimWinners = new JLabel("Prelim " + prelimNum + " Winners");
		prelimWinners.setFont(headingFont);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.insets = new Insets(0, 50, 0, 50);
		c.gridx = 0;
		c.gridy = 1;
		pane.add(prelimWinners, c);
		
		team1Label = new JLabel(team1);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 20, 0, 10);
		c.gridx = 0;
		c.gridy = 2;
		pane.add(team1Label, c);	
		
		vsLabel = new JLabel("vs");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 20, 0, 10);
		c.gridx = 1;
		c.gridy = 2;
		pane.add(vsLabel, c);
		
		team2Label = new JLabel(team2);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 20, 0, 10);
		c.gridx = 2;
		c.gridy = 2;
		pane.add(team2Label, c);
		
		
		team1Score = new JTextArea();
		team1Score.setBackground(textBoxColor);
		team1Score.setBorder(loweredBorder);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 35, 0, 25);
		c.gridx = 0;
		c.gridy = 3;
		pane.add(team1Score, c);
		
		team2Score = new JTextArea();
		team2Score.setBackground(textBoxColor);
		team2Score.setBorder(loweredBorder);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 35, 0, 25);
		c.gridx = 2;
		c.gridy = 3;
		pane.add(team2Score, c);
		
		team3Label = new JLabel(team3);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 10;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 20, 0, 10);
		c.gridx = 0;
		c.gridy = 4;
		pane.add(team3Label, c);	
		
		vsLabel = new JLabel("vs");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 10;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 20, 0, 10);
		c.gridx = 1;
		c.gridy = 4;
		pane.add(vsLabel, c);
		
		team4Label = new JLabel(team4);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 10;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 20, 0, 10);
		c.gridx = 2;
		c.gridy = 4;
		pane.add(team4Label, c);
		
		team3Score = new JTextArea();
		team3Score.setBackground(textBoxColor);
		team3Score.setBorder(loweredBorder);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 35, 0, 25);
		c.gridx = 0;
		c.gridy = 5;
		pane.add(team3Score, c);
		
		team4Score = new JTextArea();
		team4Score.setBackground(textBoxColor);
		team4Score.setBorder(loweredBorder);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 35, 0, 25);
		c.gridx = 2;
		c.gridy = 5;
		pane.add(team4Score, c);
		
		team5Label = new JLabel(team5);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 10;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 20, 0, 10);
		c.gridx = 0;
		c.gridy = 6;
		pane.add(team5Label, c);	
		
		vsLabel = new JLabel("vs");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 10;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 20, 0, 10);
		c.gridx = 1;
		c.gridy = 6;
		pane.add(vsLabel, c);
		
		team6Label = new JLabel(team6);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 10;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 20, 0, 10);
		c.gridx = 2;
		c.gridy = 6;
		pane.add(team6Label, c);
		
		team5Score = new JTextArea();
		team5Score.setBackground(textBoxColor);
		team5Score.setBorder(loweredBorder);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 35, 0, 25);
		c.gridx = 0;
		c.gridy = 7;
		pane.add(team5Score, c);
		
		team6Score = new JTextArea();
		team6Score.setBackground(textBoxColor);
		team6Score.setBorder(loweredBorder);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 35, 0, 25);
		c.gridx = 2;
		c.gridy = 7;
		pane.add(team6Score, c);
		
		team7Label = new JLabel(team7);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 10;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 20, 0, 10);
		c.gridx = 0;
		c.gridy = 8;
		pane.add(team7Label, c);	
		
		vsLabel = new JLabel("vs");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 10;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 20, 0, 10);
		c.gridx = 1;
		c.gridy = 8;
		pane.add(vsLabel, c);
		
		team8Label = new JLabel(team8);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 10;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 20, 0, 10);
		c.gridx = 2;
		c.gridy = 8;
		pane.add(team8Label, c);
		
		team7Score = new JTextArea();
		team7Score.setBackground(textBoxColor);
		team7Score.setBorder(loweredBorder);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 35, 0, 25);
		c.gridx = 0;
		c.gridy = 9;
		pane.add(team7Score, c);
		
		team8Score = new JTextArea();
		team8Score.setBackground(textBoxColor);
		team8Score.setBorder(loweredBorder);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 35, 0, 25);
		c.gridx = 2;
		c.gridy = 9;
		pane.add(team8Score, c);

		team9Label = new JLabel(team9);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 10;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 20, 0, 10);
		c.gridx = 0;
		c.gridy = 10;
		pane.add(team9Label, c);	
		
		vsLabel = new JLabel("vs");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 10;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 20, 0, 10);
		c.gridx = 1;
		c.gridy = 10;
		pane.add(vsLabel, c);
		
		team10Label = new JLabel(team10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 10;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 20, 0, 10);
		c.gridx = 2;
		c.gridy = 10;
		pane.add(team10Label, c);
	
		team9Score = new JTextArea();
		team9Score.setBackground(textBoxColor);
		team9Score.setBorder(loweredBorder);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 35, 0, 25);
		c.gridx = 0;
		c.gridy = 11;
		pane.add(team9Score, c);
		
		team10Score = new JTextArea();
		team10Score.setBackground(textBoxColor);
		team10Score.setBorder(loweredBorder);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 35, 0, 25);
		c.gridx = 2;
		c.gridy = 11;
		pane.add(team10Score, c);
		
		submit = new JButton("Submit");
		submit.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						submitAction();
					}
				});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.insets = new Insets(15, 10, 10, 10);
		c.gridx = 0;
		c.gridy = 12;
		pane.add(submit, c);
		
		ranking = new JLabel("Ranking");
		ranking.setFont(headingFont);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.weightx = 0.0;
		c.gridwidth = 2;
		c.insets = new Insets(0, 90, 0, 50);
		c.gridx = 4;
		c.gridy = 1;
		pane.add(ranking, c);
		
		rank = new JLabel("1");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 50, 0, 0);
		c.gridx = 4;
		c.gridy = 2;
		pane.add(rank, c);
		
		rank1 = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 10, 0, 0);
		c.gridx = 5;
		c.gridy = 2;
		pane.add(rank1, c);
		
		rank = new JLabel("2");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 50, 0, 0);
		c.gridx = 4;
		c.gridy = 3;
		pane.add(rank, c);
		
		rank2 = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 10, 0, 0);
		c.gridx = 5;
		c.gridy = 3;
		pane.add(rank2, c);
		
		rank = new JLabel("3");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 50, 0, 0);
		c.gridx = 4;
		c.gridy = 4;
		pane.add(rank, c);
		
		rank3 = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 10, 0, 0);
		c.gridx = 5;
		c.gridy = 4;
		pane.add(rank3, c);
		
		rank = new JLabel("4");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 50, 0, 0);
		c.gridx = 4;
		c.gridy = 5;
		pane.add(rank, c);
		
		rank4 = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 10, 0, 0);
		c.gridx = 5;
		c.gridy = 5;
		pane.add(rank4, c);
		
		rank = new JLabel("5");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 50, 0, 0);
		c.gridx = 4;
		c.gridy = 6;
		pane.add(rank, c);
		
		rank5 = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 10, 0, 0);
		c.gridx = 5;
		c.gridy = 6;
		pane.add(rank5, c);
		
		rank = new JLabel("6");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 50, 0, 0);
		c.gridx = 4;
		c.gridy = 7;
		pane.add(rank, c);
		
		rank6 = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 10, 0, 0);
		c.gridx = 5;
		c.gridy = 7;
		pane.add(rank6, c);
		
		rank = new JLabel("7");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 50, 0, 0);
		c.gridx = 4;
		c.gridy = 8;
		pane.add(rank, c);
		
		rank7 = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 10, 0, 0);
		c.gridx = 5;
		c.gridy = 8;
		pane.add(rank7, c);
		
		rank = new JLabel("8");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 50, 0, 0);
		c.gridx = 4;
		c.gridy = 9;
		pane.add(rank, c);
		
		rank8 = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 10, 0, 0);
		c.gridx = 5;
		c.gridy = 9;
		pane.add(rank8, c);
		
		rank = new JLabel("9");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 50, 0, 0);
		c.gridx = 4;
		c.gridy = 10;
		pane.add(rank, c);
		
		rank9 = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 10, 0, 0);
		c.gridx = 5;
		c.gridy = 10;
		pane.add(rank9, c);
		
		rank = new JLabel("10");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 50, 0, 0);
		c.gridx = 4;
		c.gridy = 11;
		pane.add(rank, c);
		
		rank10 = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 10, 0, 0);
		c.gridx = 5;
		c.gridy = 11;
		pane.add(rank10, c);
		
		teamHistory = new JLabel("Team History");
		teamHistory.setFont(headingFont);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.weightx = 0.0;
		c.gridwidth = 4;
		c.insets = new Insets(0, 50, 0, 50);
		c.gridx = 6;
		c.gridy = 1;
		pane.add(teamHistory, c);
		
		teams = new JComboBox(new String[] {team1, team2, team3, team4, team5, team6, team7, team8, team9, team10});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.insets = new Insets(0, 35, 0, 0);
		c.gridx = 6;
		c.gridy = 2;
		pane.add(teams, c);
		
		go = new JButton("Go");
		go.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						goAction();
					}
				});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.insets = new Insets(0, 10, 0, 10);
		c.gridx = 9;
		c.gridy = 2;
		pane.add(go, c);
		
		teamData = new JTextArea("");
		teamData.setBackground(textBoxColor);
		teamData.setEditable(false);
		teamData.setBorder(loweredBorder);
		teamData.setRows(15);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 4;
		c.gridheight = 15;
		c.insets = new Insets(0, 35, 20, 50);
		c.gridx = 6;
		c.gridy = 3;
		pane.add(teamData, c);
		
		runningTimes = new JTextArea("  Running Times (nanoseconds)" +
				"\n\n  Binary Heap Run Time:     ---" +
				"\n\n  Pairing Heap Run Time:    ---" +
				"\n\n  Skew Heap Run Time:       ---");
		runningTimes.setBackground(textBoxColor);
		runningTimes.setEditable(false);
		runningTimes.setBorder(raisedBorder);
		runningTimes.setRows(8);
		runningTimes.setColumns(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 0.0;
		c.gridwidth = 10;
		c.gridheight = 8;
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 14;
		pane.add(runningTimes, c);
		
		authors = new JLabel("By Willie Stevenson and Sylvia Allain");
		authors.setFont(headingFont);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.weightx = 0.0;
		c.gridwidth = 2;
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 5;
		c.gridy = 22;
		pane.add(authors, c);
	}
	
	/*
     * Creates a frame to display the GUI in.
     * Called in main
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ArrayList<Team> prelimList = (ArrayList<Team>) m.getNextPrelimList();
        team1 = prelimList.get(0).getName();
        team2 = prelimList.get(1).getName(); 
        team3 = prelimList.get(2).getName();
        team4 = prelimList.get(3).getName(); 
        team5 = prelimList.get(4).getName();
        team6 = prelimList.get(5).getName(); 
        team7 = prelimList.get(6).getName();
        team8 = prelimList.get(7).getName(); 
        team9 = prelimList.get(8).getName();
        team10 = prelimList.get(9).getName();
        
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
	private static void submitAction()
	{
		if (prelimNum < 12)
		{
			try{
				ArrayList<Integer> scoreList = new ArrayList<Integer>();
				
				scoreList.add(Integer.parseInt(team1Score.getText()));
				scoreList.add(Integer.parseInt(team2Score.getText()));
				scoreList.add(Integer.parseInt(team3Score.getText()));
				scoreList.add(Integer.parseInt(team4Score.getText()));
				scoreList.add(Integer.parseInt(team5Score.getText()));
				scoreList.add(Integer.parseInt(team6Score.getText()));
				scoreList.add(Integer.parseInt(team7Score.getText()));
				scoreList.add(Integer.parseInt(team8Score.getText()));
				scoreList.add(Integer.parseInt(team9Score.getText()));
				scoreList.add(Integer.parseInt(team10Score.getText()));
				
				m.distributeTeamScores(scoreList);
				
				prelimNum += 1;
				prelimWinners.setText("Prelim " + prelimNum + " Winners");
				
				ArrayList<Team> rankList;
				
				rankList = m.getBinaryRanking();
				rankList = m.getPairingRanking();
				rankList = m.getSkewRanking();
		
				
				//places team name in order of rank
				rank1.setText(rankList.get(0).getName());
				rank2.setText(rankList.get(1).getName());
				rank3.setText(rankList.get(2).getName());
				rank4.setText(rankList.get(3).getName());
				rank5.setText(rankList.get(4).getName());
				rank6.setText(rankList.get(5).getName());
				rank7.setText(rankList.get(6).getName());
				rank8.setText(rankList.get(7).getName());
				rank9.setText(rankList.get(8).getName());
				rank10.setText(rankList.get(9).getName());
				
				//replaces team labels for new prelim
				ArrayList<Team> newTeamList = m.getNextPrelimList();
				team1Label.setText(newTeamList.get(0).getName());
				team2Label.setText(newTeamList.get(1).getName());
				team3Label.setText(newTeamList.get(2).getName());
				team4Label.setText(newTeamList.get(3).getName());
				team5Label.setText(newTeamList.get(4).getName());
				team6Label.setText(newTeamList.get(5).getName());
				team7Label.setText(newTeamList.get(6).getName());
				team8Label.setText(newTeamList.get(7).getName());
				team9Label.setText(newTeamList.get(8).getName());
				team10Label.setText(newTeamList.get(9).getName());
				
				team1Score.setText("");
				team2Score.setText("");
				team3Score.setText("");
				team4Score.setText("");
				team5Score.setText("");
				team6Score.setText("");
				team7Score.setText("");
				team8Score.setText("");
				team9Score.setText("");
				team10Score.setText("");
				
				runningTimes.setText("  Running Times (nanoseconds)" +
						"\n\n  Binary Heap Run Time:     " + m.getBinaryTime() +
						"\n\n  Pairing Heap Run Time:    " + m.getPairingTime() +
						"\n\n  Skew Heap Run Time:       " + m.getSkewTime());
			}
			
			catch (NumberFormatException e) 
			{
				System.out.println("Input all scores");
		    }
			
			
		}
		
		if (prelimNum == 12)
		{
			try{
				ArrayList<Integer> scoreList = new ArrayList<Integer>();
				
				scoreList.add(Integer.parseInt(team1Score.getText()));
				scoreList.add(Integer.parseInt(team2Score.getText()));
				scoreList.add(Integer.parseInt(team3Score.getText()));
				scoreList.add(Integer.parseInt(team4Score.getText()));
				scoreList.add(Integer.parseInt(team5Score.getText()));
				scoreList.add(Integer.parseInt(team6Score.getText()));
				scoreList.add(Integer.parseInt(team7Score.getText()));
				scoreList.add(Integer.parseInt(team8Score.getText()));
				scoreList.add(Integer.parseInt(team9Score.getText()));
				scoreList.add(Integer.parseInt(team10Score.getText()));
				
				m.distributeTeamScores(scoreList);
				
				prelimNum += 1;
				prelimWinners.setText("Tournament Over!");
				
				
				ArrayList<Team> rankList;
				
				rankList = m.getBinaryRanking();
				rankList = m.getPairingRanking();
				rankList = m.getSkewRanking();
		
				
				//places team name in order of rank
				rank1.setText(rankList.get(0).getName());
				rank2.setText(rankList.get(1).getName());
				rank3.setText(rankList.get(2).getName());
				rank4.setText(rankList.get(3).getName());
				rank5.setText(rankList.get(4).getName());
				rank6.setText(rankList.get(5).getName());
				rank7.setText(rankList.get(6).getName());
				rank8.setText(rankList.get(7).getName());
				rank9.setText(rankList.get(8).getName());
				rank10.setText(rankList.get(9).getName());
				
				team1Score.setText("");
				team1Score.setEditable(false);
				team2Score.setText("");
				team2Score.setEditable(false);
				team3Score.setText("");
				team3Score.setEditable(false);
				team4Score.setText("");
				team4Score.setEditable(false);
				team5Score.setText("");
				team5Score.setEditable(false);
				team6Score.setText("");
				team6Score.setEditable(false);
				team7Score.setText("");
				team7Score.setEditable(false);
				team8Score.setText("");
				team8Score.setEditable(false);
				team9Score.setText("");
				team9Score.setEditable(false);
				team10Score.setText("");
				team10Score.setEditable(false);
				
				runningTimes.setText("  Running Times (nanoseconds)" +
						"\n\n  Binary Heap Run Time:     " + m.getBinaryTime() +
						"\n\n  Pairing Heap Run Time:    " + m.getPairingTime() +
						"\n\n  Skew Heap Run Time:       " + m.getSkewTime());
			}
			
			catch (NumberFormatException e) 
			{
				System.out.println("Input all scores");
		    }
		}
		
	}
	
	/*
     * On go button click
     */
	private static void goAction()
	{
		String teamName;
		teamName = (String) teams.getSelectedItem();
		teamData.setText(m.defeatedTeamsToString(teamName));
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
     * Schedule a job for the event-dispatching thread:
     * creating and showing this application's GUI.
     */
	public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
