package uk.gov.hmrc.InsuranceApp.home.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import uk.gov.hmrc.InsuranceApp.domain.HomeInsurancePolicy;
import uk.gov.hmrc.InsuranceApp.domain.HomeInsurancePolicy.ConstructionType;
import uk.gov.hmrc.InsuranceApp.domain.HomeInsurancePolicy.Ownership;
import uk.gov.hmrc.InsuranceApp.domain.HomeInsurancePolicy.PropertyType;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AcmeHomeInsurance {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcmeHomeInsurance window = new AcmeHomeInsurance();
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
	public AcmeHomeInsurance() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Acme Home Insurance");
		lblNewLabel.setBounds(136, 11, 172, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("name:");
		lblName.setBounds(86, 38, 46, 14);
		frame.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(144, 35, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnCalculateHomePremium = new JButton("Calculate home premium");
		btnCalculateHomePremium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO add code to calculate the premium
				//resolve how to get the address, age, name
				HomeInsurancePolicy homeInsurance = new HomeInsurancePolicy(address, age, name);
				homeInsurance.setOwnership(propertyType);
				homeInsurance.setConstructiontype(ownership);
				homeInsurance.setPropertyType(propertyType);
				double premium = homeInsurance.getPremium();
				//set the value in the ui
			}
		});
		btnCalculateHomePremium.setBounds(144, 227, 149, 23);
		frame.getContentPane().add(btnCalculateHomePremium);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(PropertyType.values()));
		comboBox.setBounds(144, 78, 120, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(ConstructionType.values()));
		comboBox_1.setBounds(144, 119, 120, 20);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(Ownership.values()));
		comboBox_2.setBounds(144, 159, 120, 20);
		frame.getContentPane().add(comboBox_2);
	}

}
