/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BestTradeGUI;

/**
 *
 * @author berkt
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class UIManager extends JFrame{
	
	static JFrame frame;
	static JPanel contentPane;
	static LoginPanel loginPanel;
        static TradeScreen tradeScreen;
        static ActivationCodeScreen activationCodeScreen;
        static SignUpPanel signUpPanel;
        static MyProfilePanel myProfilePanel;
        static SearchItemScreen searchItemScreen;
        static AddItemScreen addItemScreen;
        static ViewItemScreen viewItemScreen;
        static EditProfilePanel editProfilePanel;
        static SendMessageScreen sendMessageScreen;
        
	
        public static void main(String[]args) throws IOException{
        
            frame = new UIManager();
            frame.setVisible(true);
            
        }
	//Main Frame Constructor
	public UIManager() throws IOException{

		setTitle("BestTrade");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		
		//Content Pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(100, 100, 800, 600));
		contentPane.setLayout(null);
		
		//Initialize Panels
		loginPanel = new LoginPanel();
		tradeScreen = new TradeScreen();
		activationCodeScreen = new ActivationCodeScreen();
		signUpPanel = new SignUpPanel();
		myProfilePanel = new MyProfilePanel(); 
		searchItemScreen = new SearchItemScreen();
		addItemScreen = new AddItemScreen();
		viewItemScreen = new ViewItemScreen();
		editProfilePanel = new EditProfilePanel();
		sendMessageScreen = new SendMessageScreen();
		
		//Sets the visibility of panels
		loginPanel.setVisible(true);
		tradeScreen.setVisible(false);
		activationCodeScreen.setVisible(false);
		signUpPanel.setVisible(false);
		myProfilePanel.setVisible(false);
		searchItemScreen.setVisible(false);
		addItemScreen.setVisible(false);
		viewItemScreen.setVisible(false);
		editProfilePanel.setVisible(false);
		sendMessageScreen.setVisible(false);
		
		//Adding panels to the frame
		getContentPane().add(loginPanel);
		/*getContentPane().add(activationCodeScreen);
		getContentPane().add(signUpPanel);
		getContentPane().add(myProfilePanel);
		getContentPane().add(searchItemScreen);
		getContentPane().add(addItemScreen);
		getContentPane().add(viewItemScreen);
		getContentPane().add(editProfilePanel);
		getContentPane().add(sendMessageScreen);
                
		getContentPane().add(tradeScreen);
		setContentPane(contentPane);*/
		//addKeyListener(new KeyPressListener());	//Adds key press listener to the frame
                
                
                /* add(loginPanel);
                
                add(signUpPanel);
               add(tradeScreen);
                add(activationCodeScreen);
                
                add(myProfilePanel);
                add(searchItemScreen);
                add(addItemScreen);
                add(viewItemScreen);
                add(editProfilePanel);
                add(sendMessageScreen);*/
                //
                pack();
	}
        
        


            
}

