package brick;
import javax.swing.JFrame;
/**
 * 
 * @author somas
 *
 */
public class Break {

	public static void main(String[] args) {
		JFrame object = new JFrame();
		Play playGame = new Play();
		object.setBounds(10,10,700,600);
		object.setTitle("Break the ball");
		object.setResizable(false);
		object.setVisible(true);
		object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		object.add(playGame);
		

	}

}
