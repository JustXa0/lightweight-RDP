import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

//import org.apache.commons.rdp.*;


public class RDPGUI extends RDPEncrypt implements ActionListener{
	public boolean close = false;
	
	JButton decrypt = new JButton();
	JButton encrypt = new JButton();
	JButton submit = new JButton();
	JButton submitD = new JButton();
	JButton back = new JButton();
	JTextField userInput = new JTextField();
	
	JFrame frameE = new JFrame("Server Client");
	JFrame frame0 = new JFrame("Server Client");
	
	public RDPGUI() throws FileNotFoundException {
		
		
		encrypt.setText("ENCRYPT");
		decrypt.setText("DECRYPT");
		encrypt.addActionListener(this);
		decrypt.addActionListener(this);
		submit.addActionListener(this);
		userInput.addActionListener(this);
		submitD.addActionListener(this);
		back.addActionListener(this);
		
	
		frame0.setVisible(true);
		frame0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame0.setMaximumSize(new Dimension(340,280));
		frame0.setMinimumSize(new Dimension(320,280));
		frame0.setLayout(new GridLayout(4,4));
		frame0.getContentPane().add(encrypt);
		frame0.getContentPane().add(decrypt);
	
	}

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == encrypt) {
			encrypt.setText("Running");
			frame0.getContentPane().remove(decrypt);
			frame0.getContentPane().add(submit);
			submit.setText("SUBMIT");
			frame0.getContentPane().add(userInput);
		}
		
		if(e.getSource() == decrypt) {
			decrypt.setText("Running");
			frame0.getContentPane().remove(encrypt);
			frame0.getContentPane().add(submitD);
			submitD.setText("SUBMIT");
			frame0.getContentPane().add(userInput);
		}
		
		
		
		if(e.getSource() == submit) {
			RDPEncrypt encrypt1 = new RDPEncrypt();
			try {
				RDPFileGenerator fileSaver = new RDPFileGenerator();
				fileSaver.SaveFile(encrypt1.Encrypt(userInput.getText()));
			} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | IOException e2) {
				e2.printStackTrace();
			}
			
		
		}
		
		if(e.getSource() == submitD) {
			RDPEncrypt decrypt1 = new RDPEncrypt();
			try {
				RDPFileGenerator fileSaver = new RDPFileGenerator();
				System.out.print(decrypt1.Decrypt(userInput.getText()));
				fileSaver.SaveFile(decrypt1.Decrypt(userInput.getText()));
			} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | IOException e2) {
				e2.printStackTrace();
			
			}
			
			
		}
			
	}
}