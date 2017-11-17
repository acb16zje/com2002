package controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import view.Login;

public class LoginListener implements WindowListener {

	private JFrame frame;
	
	public LoginListener(JFrame f){
		this.frame = f;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		frame.dispose();
        Login welcome = new Login();
        welcome.setVisible(true);
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}	
}
