import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JTextField;

public class Generator {

	private JFrame frame;
	private JTextField txtBirthdate;
	private JLabel lblPesel;
	private JComboBox cbSexPicker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Generator window = new Generator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Generator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGenerate.setBounds(155, 31, 116, 43);
		frame.getContentPane().add(btnGenerate);
		
		JLabel lblPeselLabel = new JLabel("Generated pesel:");
		lblPeselLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPeselLabel.setBounds(160, 164, 122, 16);
		frame.getContentPane().add(lblPeselLabel);
		
		cbSexPicker = new JComboBox();
		cbSexPicker.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cbSexPicker.setSelectedIndex(0);
		cbSexPicker.setBounds(155, 129, 116, 22);
		frame.getContentPane().add(cbSexPicker);
		
		lblPesel = new JLabel("");
		lblPesel.setForeground(Color.BLUE);
		lblPesel.setBounds(173, 178, 84, 35);
		frame.getContentPane().add(lblPesel);
		
		txtBirthdate = new JTextField();
		txtBirthdate.setBounds(155, 98, 116, 22);
		frame.getContentPane().add(txtBirthdate);
		txtBirthdate.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Birthdate:");
		lblNewLabel_1.setBounds(155, 82, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
