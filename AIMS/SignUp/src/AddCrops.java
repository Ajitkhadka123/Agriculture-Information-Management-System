

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCrops extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCrops;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;      //initializing variables
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JButton btnCancel;
	private JLabel ldlabel;
	private JTextField textFieldid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCrops frame = new AddCrops();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddCrops() {
		
		//creating methods for lables and textfields
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		//setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrops = new JLabel("Crops");
		lblCrops.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCrops.setForeground(Color.WHITE);
		lblCrops.setBounds(63, 69, 71, 25);
		contentPane.add(lblCrops);
		
		textFieldCrops = new JTextField();
		textFieldCrops.setBounds(63, 93, 144, 25);
		contentPane.add(textFieldCrops);
		textFieldCrops.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(63, 132, 144, 25);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(63, 170, 144, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(63, 206, 144, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(63, 243, 144, 25);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(63, 279, 144, 25);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(63, 315, 144, 25);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(63, 351, 144, 25);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(63, 387, 144, 25);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(63, 430, 144, 25);
		contentPane.add(textField_8);
		
		JLabel lblMarketRate = new JLabel("Market Rate");
		lblMarketRate.setForeground(Color.WHITE);
		lblMarketRate.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblMarketRate.setBounds(299, 69, 110, 25);
		contentPane.add(lblMarketRate);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(299, 93, 144, 25);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(299, 134, 144, 25);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(299, 172, 144, 25);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(299, 208, 144, 25);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(299, 245, 144, 25);
		contentPane.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(299, 281, 144, 25);
		contentPane.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(299, 317, 144, 25);
		contentPane.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(299, 353, 144, 25);
		contentPane.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(299, 389, 144, 25);
		contentPane.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(299, 432, 144, 25);
		contentPane.add(textField_18);
		
		JLabel lblFarmersRate = new JLabel("Farmers Rate");
		lblFarmersRate.setForeground(Color.WHITE);
		lblFarmersRate.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblFarmersRate.setBounds(521, 69, 110, 25);
		contentPane.add(lblFarmersRate);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(521, 93, 144, 25);
		contentPane.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(521, 134, 144, 25);
		contentPane.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(521, 172, 144, 25);
		contentPane.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(521, 208, 144, 25);
		contentPane.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(521, 245, 144, 25);
		contentPane.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(521, 281, 144, 25);
		contentPane.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(521, 317, 144, 25);
		contentPane.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(521, 351, 144, 25);
		contentPane.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setBounds(521, 389, 144, 25);
		contentPane.add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setBounds(521, 430, 144, 25);
		contentPane.add(textField_28);
		
		JButton btnNewButton = new JButton("Save");             //creating save button
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnNewButton) {
					if(JOptionPane.showConfirmDialog(null, "Do you want to Save detail")==0) {
						AddCrops.this.dispose();
					}
				}
			}
		});
		btnNewButton.setBounds(454, 522, 89, 23);
		contentPane.add(btnNewButton);
		
		btnCancel = new JButton("Cancel");                      //creating cancel button 
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCancel) {
					System.exit(0);
				}
			}
		});
		btnCancel.setBounds(576, 522, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(111, 35, 89, -4);
		contentPane.add(label);
		
		ldlabel = new JLabel("Insert Id Here to fill forms");
		ldlabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		ldlabel.setForeground(Color.WHITE);
		ldlabel.setBounds(56, 0, 308, 31);
		contentPane.add(ldlabel);
		
		textFieldid = new JTextField();
		textFieldid.setColumns(10);
		textFieldid.setBounds(63, 33, 144, 25);
		contentPane.add(textFieldid);
	}
}
