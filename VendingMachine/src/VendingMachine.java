	import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VendingMachine extends JFrame {

	private JPanel contentPane;
	private JTextField txtChange;
	private JTextField txtInsert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendingMachine frame = new VendingMachine();
					frame.setVisible(true);
					frame.setTitle("Vending Machine");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VendingMachine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVendingMachine = new JLabel("Vending Machine");
		lblVendingMachine.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblVendingMachine.setBounds(132, 11, 154, 21);
		contentPane.add(lblVendingMachine);
		
		JLabel lblInsertMoney = new JLabel(" Insert Money:");
		lblInsertMoney.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInsertMoney.setBounds(79, 43, 97, 14);
		contentPane.add(lblInsertMoney);
		
		JLabel lblChange = new JLabel("Change:");
		lblChange.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChange.setBounds(80, 73, 97, 14);
		contentPane.add(lblChange);
		
		txtChange = new JTextField();
		txtChange.setBounds(220, 73, 86, 20);
		contentPane.add(txtChange);
		txtChange.setColumns(10);
		
		txtInsert = new JTextField();
		txtInsert.setColumns(10);
		txtInsert.setBounds(220, 43, 86, 20);
		contentPane.add(txtInsert);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Select an item:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(26, 117, 378, 99);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JCheckBox cbSprite = new JCheckBox("Sprite ($1.50)");
		cbSprite.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbSprite.setSelected(true);
		cbSprite.setBounds(6, 19, 109, 23);
		panel.add(cbSprite);
		
		JCheckBox cbWater = new JCheckBox("Water ($1.00)");
		cbWater.setSelected(true);
		cbWater.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbWater.setBounds(124, 19, 109, 23);
		panel.add(cbWater);
		
		JCheckBox cbLemonade = new JCheckBox("Lemonade ($2.00)");
		cbLemonade.setSelected(true);
		cbLemonade.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbLemonade.setBounds(238, 19, 134, 23);
		panel.add(cbLemonade);
		
		JCheckBox cbCoke = new JCheckBox("Coke ($1.75)");
		cbCoke.setSelected(true);
		cbCoke.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbCoke.setBounds(6, 57, 109, 23);
		panel.add(cbCoke);
		
		JCheckBox cbPepsi = new JCheckBox("Pepsi ($1.50)");
		cbPepsi.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbPepsi.setBounds(124, 57, 109, 23);
		panel.add(cbPepsi);
		
		JCheckBox cbPowerade = new JCheckBox("Powerade ($1.75)");
		cbPowerade.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbPowerade.setBounds(238, 57, 134, 23);
		panel.add(cbPowerade);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double cost= 0;
				if(cbSprite.isSelected())
					cost += 1.50;
				if(cbWater.isSelected())
					cost += 1.00;
				if(cbLemonade.isSelected())
					cost += 2.00;
				if(cbPowerade.isSelected())
					cost += 1.75;
				if(cbCoke.isSelected())
					cost += 1.75;
				if(cbPepsi.isSelected())
					cost += 1.50;
				double insertedMoney= Double.parseDouble(txtInsert.getText());
				double change = insertedMoney - cost;
				txtChange.setText(""+ change);
			}
		});
		btnPurchase.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPurchase.setBounds(26, 227, 89, 23);
		contentPane.add(btnPurchase);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInsert.setText("");
				txtChange.setText("");
				cbSprite.setSelected(false);
				cbCoke.setSelected(false);
				cbWater.setSelected(false);
				cbLemonade.setSelected(false);
				cbPepsi.setSelected(false);
				cbPowerade.setSelected(false);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setBounds(172, 227, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuit.setBounds(315, 227, 89, 23);
		contentPane.add(btnQuit);
	}
}