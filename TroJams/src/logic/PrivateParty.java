package logic;

import javax.swing.ImageIcon;

public class PrivateParty extends Party{

	private String password;
	
	public PrivateParty(String partyName, String password, User host, ImageIcon partyImage) {
		super(partyName, host,  partyImage);
		this.password = password;
	}
	
	//pass in a string to see if it equals the party password
	public boolean verifyPassword(String pass) {
		System.out.println("");
		return pass.equals(password);
	}

}
