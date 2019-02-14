package uk.gov.hmrc.InsuranceApp.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import uk.gov.hmrc.InsuranceApp.controller.PolicyController;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class AcmeInsurance {

	private JFrame frame;
	private JTextField nameTxt;
	private JTextField ageTxt;
	private JTextField YearsDrivingTxt;
	private JTextField noClainsTxt;
	private JLabel PremiumLbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcmeInsurance window = new AcmeInsurance();
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
	public AcmeInsurance() {
		initialize();
	}
	
	private void setUpRadioButtons(JRadioButton button1, JRadioButton button2) {
		//TODO add buttons to a radio button group. 
		
		ButtonGroup bt1 = new ButtonGroup(); 
		bt1.add(button1);
		bt1.add(button2);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 550, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		nameTxt = new JTextField();
		nameTxt.setToolTipText("Enter customer name");
		nameTxt.setBounds(90, 41, 156, 20);
		frame.getContentPane().add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(34, 44, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblAcmeInsuranceQuote = new JLabel("Acme Insurance Quote Generator");
		lblAcmeInsuranceQuote.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAcmeInsuranceQuote.setBounds(130, 0, 311, 25);
		frame.getContentPane().add(lblAcmeInsuranceQuote);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(34, 75, 46, 14);
		frame.getContentPane().add(lblAge);
		
		ageTxt = new JTextField();
		ageTxt.setToolTipText("Enter how old the customer is");
		ageTxt.setBounds(90, 72, 156, 20);
		frame.getContentPane().add(ageTxt);
		ageTxt.setColumns(10);
		
		JLabel lblMake = new JLabel("Make:");
		lblMake.setBounds(34, 100, 46, 26);
		frame.getContentPane().add(lblMake);
		
		JLabel lblModel = new JLabel("Model:");
		lblModel.setBounds(210, 106, 46, 14);
		frame.getContentPane().add(lblModel);
		
		JComboBox MakeComboBox = new JComboBox();
		MakeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Make", "Vauxhall", "Ford", "Citroen"}));
		MakeComboBox.setBounds(90, 103, 106, 20);
		frame.getContentPane().add(MakeComboBox);
		
		JComboBox modelComboBox = new JComboBox();
		modelComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Model", "Astra", "Mondeo", "Xsara"}));
		modelComboBox.setBounds(256, 103, 106, 20);
		frame.getContentPane().add(modelComboBox);
		
		JLabel YearsDrivingLbl = new JLabel("Years Driving:");
		YearsDrivingLbl.setBounds(10, 137, 84, 14);
		frame.getContentPane().add(YearsDrivingLbl);
		
		YearsDrivingTxt = new JTextField();
		YearsDrivingTxt.setToolTipText("Enter how many years the customer has been driving");
		YearsDrivingTxt.setBounds(90, 134, 156, 20);
		frame.getContentPane().add(YearsDrivingTxt);
		YearsDrivingTxt.setColumns(10);
		
		JRadioButton MedHistRB1 = new JRadioButton("Yes");
		MedHistRB1.setBounds(202, 161, 54, 23);
		frame.getContentPane().add(MedHistRB1);
	
		
		JRadioButton MedHistRB2 = new JRadioButton("No");
		MedHistRB2.setSelected(true);
		MedHistRB2.setBounds(272, 161, 46, 23);
		frame.getContentPane().add(MedHistRB2);
		setUpRadioButtons(MedHistRB1, MedHistRB2);
		
		
		JLabel lblDoYouHave = new JLabel("Do you have a medical history?");
		lblDoYouHave.setBounds(10, 165, 226, 14);
		frame.getContentPane().add(lblDoYouHave);
		
		JComboBox StorageCB = new JComboBox();
		StorageCB.setModel(new DefaultComboBoxModel(new String[] {"Select Storage", "Drive", "OnStreet", "Garage"}));
		StorageCB.setBounds(202, 191, 156, 20);
		frame.getContentPane().add(StorageCB);
		
		JLabel lblWhereIsThe = new JLabel("Where is the Vehicle kept?");
		lblWhereIsThe.setBounds(10, 196, 169, 14);
		frame.getContentPane().add(lblWhereIsThe);
		
		JRadioButton pointsRB1 = new JRadioButton("Yes");
		pointsRB1.setBounds(242, 220, 54, 23);
		frame.getContentPane().add(pointsRB1);
		
		JRadioButton pointsRB2 = new JRadioButton("No");
		pointsRB2.setSelected(true);
		pointsRB2.setBounds(316, 220, 46, 23);
		frame.getContentPane().add(pointsRB2);
		setUpRadioButtons(pointsRB1, pointsRB2);
		
		JLabel lblDoYouHave_1 = new JLabel("Do you have an points on your licence?");
		lblDoYouHave_1.setBounds(10, 224, 226, 14);
		frame.getContentPane().add(lblDoYouHave_1);
		
		JComboBox addressCB = new JComboBox();
		addressCB.setModel(new DefaultComboBoxModel(new String[] {"Select Address", "A", "B", "C"}));
		addressCB.setBounds(130, 252, 169, 20);
		frame.getContentPane().add(addressCB);
		
		JLabel lblWhereDoYou = new JLabel("Where do you live?");
		lblWhereDoYou.setBounds(10, 255, 110, 14);
		frame.getContentPane().add(lblWhereDoYou);
		
		noClainsTxt = new JTextField();
		noClainsTxt.setColumns(10);
		noClainsTxt.setBounds(256, 280, 156, 20);
		frame.getContentPane().add(noClainsTxt);
		
		JLabel lblHowManyYears = new JLabel("How many years no claims do you have?");
		lblHowManyYears.setBounds(10, 283, 236, 14);
		frame.getContentPane().add(lblHowManyYears);
		
		JButton submitBtn = new JButton("Submit details");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//add form handling logic
				PolicyController controller = new PolicyController();
				String name2 = nameTxt.getText();
				Byte age2 = Byte.valueOf(ageTxt.getText());
				String make = MakeComboBox.getSelectedItem().toString();
				String model = modelComboBox.getSelectedItem().toString();
				Byte yearsDriving2 = Byte.valueOf(YearsDrivingTxt.getText());
				String address = addressCB.getSelectedItem().toString();
				String storage = StorageCB.getSelectedItem().toString();
				Byte noClaims2 = Byte.valueOf(noClainsTxt.getText());
				String hasPoints2 = pointsRB2.isSelected()?"no":"yes";
				String hasMedicalHistory2 = MedHistRB2.isSelected()?"no":"yes";

				
				controller.processRequest(name2, age2, make, model, yearsDriving2, noClaims2, hasMedicalHistory2, storage, address, hasPoints2);
				PremiumLbl.setText(Double.toString(controller.getPremium()));
			}
		});
		submitBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		submitBtn.setBounds(180, 322, 128, 23);
		frame.getContentPane().add(submitBtn);
		
		PremiumLbl = new JLabel(" ");
		PremiumLbl.setBounds(180, 356, 128, 45);
		frame.getContentPane().add(PremiumLbl);
	}
}
