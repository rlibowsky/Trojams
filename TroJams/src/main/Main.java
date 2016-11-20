package main;

import frames.TrojamWelcomeWindow;
import networking.TrojamClient;

public class Main {

    public static void main (String [] args) {
    	
    	new TrojamWelcomeWindow(new TrojamClient("localhost", 1111)).setVisible(true);
    }
}
