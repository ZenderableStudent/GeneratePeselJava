import java.awt.EventQueue;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JTextField;
import datechooser.beans.DateChooserCombo;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;

public class Generator {

	private JFrame frame;
	private JLabel lblPesel;
	@SuppressWarnings("rawtypes")
	private JComboBox cbSexPicker;
	private JDateChooser dateChooser ;

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

	public Generator() {
		initialize();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int[] pesel = new int[11];
				
				
				if(dateChooser.getDate() != null)
				{
					SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
					String pickedDate = sdf.format(dateChooser.getDate().getTime());
					
					String _wholeYear, _year, _day, _month;
					int _checkSum;
					char[] _birthDate = pickedDate.toCharArray();
					 _wholeYear = String.valueOf(_birthDate[6]) + String.valueOf(_birthDate[7]) + String.valueOf(_birthDate[8]) + String.valueOf(_birthDate[9]);
					 char[] _pickedWholeYear = _wholeYear.toCharArray();
					 pesel[0] = Character.getNumericValue(_pickedWholeYear[2]);
					 pesel[1] = Character.getNumericValue(_pickedWholeYear[3]);
					 _year = String.valueOf(pesel[0]) + String.valueOf(pesel[1]);
					 pesel[2] = Character.getNumericValue(_birthDate[3]);
					 pesel[3] = Character.getNumericValue(_birthDate[4]);
					 pesel[4] = Character.getNumericValue(_birthDate[0]);
					 pesel[5] = Character.getNumericValue(_birthDate[1]);
					 _day = String.valueOf(pesel[4]) + String.valueOf(pesel[5]);
					 _month = String.valueOf(pesel[2]) + String.valueOf(pesel[3]);
					   if (Integer.parseInt(_wholeYear) >= 2000 && Integer.parseInt(_wholeYear) <= 2099)
	                    {
	                        pesel[2] += 2;
	                        _month = String.valueOf(pesel[2]) + String.valueOf(pesel[3]);
	                    }
	                    else if (Integer.parseInt(_wholeYear) >= 1800 && Integer.parseInt(_wholeYear) <= 1899)
	                    {
	                        pesel[2] += 8;
	                        _month = String.valueOf(pesel[2]) + String.valueOf(pesel[3]);
	                    }
                        else if (Integer.parseInt(_wholeYear) >= 2100 && Integer.parseInt(_wholeYear) <= 2199)
	                    {
	                        pesel[2] += 4;
	                        _month = String.valueOf(pesel[2]) + String.valueOf(pesel[3]);

	                    }
	                    else if (Integer.parseInt(_wholeYear) >= 2200 && Integer.parseInt(_wholeYear) <= 2299)
	                    {
	                        pesel[2] += 6;
	                        _month = String.valueOf(pesel[2]) + String.valueOf(pesel[3]);
	                    }
					   Random random = new Random();
					   int randCheckDigits = random.nextInt(10);
					   int randSexDigit = random.nextInt(5);
					   pesel[6] = randCheckDigits;
					   randCheckDigits = random.nextInt(10);
					   pesel[7] = randCheckDigits;
					   randCheckDigits = random.nextInt(10);
					   pesel[8] = randCheckDigits;
					   String pickedRandCheckDigits = String.valueOf(pesel[6]) + String.valueOf(pesel[7]) + String.valueOf(pesel[8]);
					   if(cbSexPicker.getSelectedIndex() == 1)
					   {
						   randSexDigit *= 2;
						   pesel[9] = randSexDigit;
						   _checkSum = pesel[0] + pesel[1] * 3 + pesel[2] * 7 + pesel[3] * 9 + pesel[4] + pesel[5] * 3 + pesel[6] * 7 + pesel[7] * 9 + pesel[8] + pesel[9] * 3;
						   _checkSum %= 10;
	                       _checkSum = 10 - _checkSum;
	                       _checkSum %= 10;
	                       lblPesel.setText(_year + _month + _day + pickedRandCheckDigits + String.valueOf(randSexDigit) + _checkSum);
					   }
					   else
					   {
						   randSexDigit = randSexDigit * 2 + 1;
						   pesel[9] = randSexDigit;
						   _checkSum = pesel[0] + pesel[1] * 3 + pesel[2] * 7 + pesel[3] * 9 + pesel[4] + pesel[5] * 3 + pesel[6] * 7 + pesel[7] * 9 + pesel[8] + pesel[9] * 3;
	                       _checkSum %= 10;
	                       _checkSum = 10 - _checkSum;
	                       _checkSum %= 10;
	                       lblPesel.setText(_year + _month + _day + pickedRandCheckDigits + String.valueOf(randSexDigit) + _checkSum);
					   }
					   
				}
				else
				{
					lblPesel.setText("Pick a birth date!");
				}
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
		lblPesel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesel.setForeground(Color.BLUE);
		lblPesel.setBounds(117, 182, 195, 43);
		frame.getContentPane().add(lblPesel);
		
		JLabel lblNewLabel_1 = new JLabel("Birthdate:");
		lblNewLabel_1.setBounds(155, 82, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(155, 104, 116, 22);
		dateChooser.setDateFormatString("dd.MM.yyyy");
		frame.getContentPane().add(dateChooser);
	}
}
