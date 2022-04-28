import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AdminSection {
	

	private Image img_logo = new ImageIcon(AdminSection.class.getResource("img/corpslogo.png")).getImage().getScaledInstance(90,90, Image.SCALE_SMOOTH);

	private JFrame frame;
	private JTextField mun;
	private JTextField prov;
	private JTextField crop;
	private JTextField mkrate;
	private JTextField fmrate;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSection window = new AdminSection();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminSection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setResizable(false);
		getFrame().setBounds(100, 100, 811, 599);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(85, 107, 47));
		panel.setBounds(0, 0, 805, 571);
		getFrame().getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel province = new JLabel("Province");
		province.setFont(new Font("Tahoma", Font.PLAIN, 18));
		province.setForeground(new Color(255, 255, 255));
		province.setBounds(20, 120, 102, 27);
		panel.add(province);
		
		JLabel municipality = new JLabel("Municipality");
		municipality.setForeground(Color.WHITE);
		municipality.setFont(new Font("Tahoma", Font.PLAIN, 18));
		municipality.setBounds(20, 153, 102, 27);
		panel.add(municipality);
		
		JLabel crops = new JLabel("Crops");
		crops.setForeground(Color.WHITE);
		crops.setFont(new Font("Tahoma", Font.PLAIN, 18));
		crops.setBounds(20, 185, 102, 33);
		panel.add(crops);
		
		JLabel marketrate = new JLabel("Market Rate");
		marketrate.setForeground(Color.WHITE);
		marketrate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		marketrate.setBounds(20, 221, 102, 27);
		panel.add(marketrate);
		
		JLabel Farmersrate = new JLabel("Farmer's Rate");
		Farmersrate.setForeground(Color.WHITE);
		Farmersrate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Farmersrate.setBounds(20, 256, 132, 27);
		panel.add(Farmersrate);
		
		mun = new JTextField();
		mun.setBounds(143, 153, 137, 29);
		panel.add(mun);
		mun.setColumns(10);
		
		prov = new JTextField();
		prov.setColumns(10);
		prov.setBounds(143, 120, 137, 27);
		panel.add(prov);
		
		crop = new JTextField();
		crop.setColumns(10);
		crop.setBounds(143, 187, 137, 27);
		panel.add(crop);
		
		mkrate = new JTextField();
		mkrate.setColumns(10);
		mkrate.setBounds(143, 221, 137, 27);
		panel.add(mkrate);
		
		fmrate = new JTextField();
		fmrate.setColumns(10);
		fmrate.setBounds(143, 256, 137, 27);
		panel.add(fmrate);
		
		JLabel IbllconLogo = new JLabel("");
		IbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		IbllconLogo.setBounds(-58, -22, 238, 143);
		panel.add(IbllconLogo);
		IbllconLogo.setIcon(new ImageIcon(img_logo));

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(290, 120, 495, 406);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				prov.setText(model.getValueAt(i, 0).toString());
				mun.setText(model.getValueAt(i, 1).toString());
				crop.setText(model.getValueAt(i, 2).toString());
				mkrate.setText(model.getValueAt(i, 3).toString());
				fmrate.setText(model.getValueAt(i, 4).toString());
				
				
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"Province","Municipality","Crops","Market Rate","Farmers rate"};
		final Object[] row = new Object[5];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				row[0]= prov.getText();
				row[1]= mun.getText();
				row[2]= crop.getText();
				row[3]= mkrate.getText();
				row[4]= fmrate.getText();
				model.addRow(row);
				
				prov.setText("");
				mun.setText("");
				crop.setText("");
				mkrate.setText("");
				fmrate.setText("");
				JOptionPane.showMessageDialog(null,"Saved");
				}catch(Exception E) {
					System.out.println(E);
				}
			}
		});
		btnNewButton.setBounds(39, 398, 83, 38);
		panel.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.setValueAt(prov.getText(), i ,0);
				model.setValueAt(mun.getText(), i ,1);
				model.setValueAt(crop.getText(), i ,2);
				model.setValueAt(mkrate.getText(), i ,3);
				model.setValueAt(fmrate.getText(), i ,4);
				JOptionPane.showMessageDialog(null,"Updated");
				
				
				
			}
		});
		btnUpdate.setBounds(154, 398, 83, 38);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
				JOptionPane.showMessageDialog(null,"Deleted");
			}
		});
		btnDelete.setBounds(39, 453, 83, 38);
		panel.add(btnDelete);
		
		JButton btnClearl = new JButton("Clear");
		btnClearl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prov.setText("");
				mun.setText("");
				crop.setText("");
				mkrate.setText("");
				fmrate.setText("");
				JOptionPane.showMessageDialog(null,"Cleared");
			}
		});
		btnClearl.setBounds(154, 453, 83, 38);
		panel.add(btnClearl);
		
		JLabel AIMS = new JLabel("Agriculture Information Management System");
		AIMS.setFont(new Font("Serif", Font.BOLD, 27));
		AIMS.setForeground(new Color(255, 255, 0));
		AIMS.setBounds(141, 27, 627, 46);
		panel.add(AIMS);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
