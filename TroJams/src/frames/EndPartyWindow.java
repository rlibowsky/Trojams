package frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.User;
import resources.AppearanceConstants;
import resources.AppearanceSettings;

public class EndPartyWindow extends JPanel {

	private static final long serialVersionUID = 1L;
	private User user;
	
	private JLabel thanksLabel;
	private JButton quitButton, joinAnotherPartyButton;
	private JPanel thanksPanel, endPartyButtonPanel;
	private SelectionWindow selectionWindow;
	
	
	public EndPartyWindow (SelectionWindow selectionWindow){
		this.selectionWindow = selectionWindow;
		this.user = selectionWindow.getUser();
		initializeComponents();
		createGUI();
		addListeners();
	}
	
	
	private void initializeComponents(){
		
		if(user.isHost()){
			thanksLabel = new JLabel("Thanks for Hosting, " + user.getFirstName() + "!");
		}
		else{
			if(user.getFirstName() == null){
				thanksLabel = new JLabel("Thanks for Listening!");
			}
			else{
				thanksLabel = new JLabel("Thanks for Listening, " + user.getFirstName() + "!");
			}	
		}
		
		AppearanceSettings.setFont(AppearanceConstants.fontHuge, thanksLabel);
		thanksLabel.setForeground(Color.white);
		quitButton = new JButton("Quit Trojams");
		joinAnotherPartyButton = new JButton("Join another Party");
		AppearanceSettings.setSize(300, 200, quitButton, joinAnotherPartyButton);
		AppearanceSettings.setForeground(AppearanceConstants.trojamPurple, quitButton, joinAnotherPartyButton);
		
		thanksPanel = new JPanel();
		thanksPanel.setOpaque(false);
		thanksPanel.setLayout(new BoxLayout(thanksPanel, BoxLayout.LINE_AXIS));
		
		endPartyButtonPanel = new JPanel();
		endPartyButtonPanel.setOpaque(false);
		endPartyButtonPanel.setLayout(new BoxLayout(endPartyButtonPanel, BoxLayout.LINE_AXIS));
	}
	
	private void createGUI(){
		setSize(AppearanceConstants.GUI_WIDTH, AppearanceConstants.GUI_HEIGHT);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		AppearanceSettings.addGlue(endPartyButtonPanel, BoxLayout.LINE_AXIS, true, quitButton, joinAnotherPartyButton);
		AppearanceSettings.addGlue(thanksPanel, BoxLayout.LINE_AXIS, true, thanksLabel);
		this.add(Box.createVerticalGlue());
		AppearanceSettings.addGlue(this, BoxLayout.PAGE_AXIS, true, thanksPanel, endPartyButtonPanel);
		
	}
	
	private void addListeners(){
		quitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				selectionWindow.dispose();
			}
		});
		
		joinAnotherPartyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				selectionWindow.dispose();
				new SelectionWindow(user, null).setVisible(true);
			}
		});
		
	}
	
	//Paint background image -- needs to be outside of other methods
		@Override
		  protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Image image = new ImageIcon("images/dj.jpg").getImage();
			//backgroundImage = new ImageIcon(image.getScaledInstance(1280, 800, java.awt.Image.SCALE_SMOOTH));
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		};
	

		public static void main(String [] args) {
			JFrame test = new JFrame();
			EndPartyWindow epw = new EndPartyWindow(new SelectionWindow(new User("a", "b"), null));
			test.add(epw);
			test.setSize(1280, 800);
			test.setVisible(true);
		}
}
