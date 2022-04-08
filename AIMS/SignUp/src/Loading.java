import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class Loading extends JFrame {

	private JPanel contentPane;
	private static JProgressBar progressBar;
	private static JLabel lblNewLabel_1;
	private JFrame window;
	
	
	//	ImageIcon icon = new ImageIcon("img/icon-crop.png");
    //  for jar file
	ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("img/icon-crop.png"));



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        int i;
        Loading frame = new Loading();
        frame.setVisible(true);

        //for loading 
        try {
            for (i = 0; i <= 100; i += 2) {
                Loading.progressBar.setValue(i);
                Thread.sleep(50);
                Loading.lblNewLabel_1.setText(Integer.toString(i)+" %");
                if(i==100) {
                    frame.dispose();
                    MainLogin log = new MainLogin();
                    log.setVisible(true);
                }
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

	/**
	 * Create the frame.
	 */
	public Loading() {
		
		window = new JFrame();
		window.setIconImage(icon.getImage());
		
		//design behind image and height width
		setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(375, 200, 800, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //loading image
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBackground(new Color(255, 255, 255));
        ImageIcon icon = new ImageIcon(this.getClass().getResource("img/loadingg.jpg"));
        lblNewLabel.setIcon(icon);
        lblNewLabel.setBounds(0, 0, 800, 400);
        contentPane.add(lblNewLabel);

        //progress bar
        progressBar = new JProgressBar();
        progressBar.setForeground(Color.ORANGE);
        progressBar.setBackground(Color.PINK);
        progressBar.setBounds(0, 390, 800, 11);
        contentPane.add(progressBar);
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(427, 549, 45, 30);
        contentPane.add(lblNewLabel_1);
		
		
		
	}

}
