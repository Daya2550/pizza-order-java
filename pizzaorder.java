import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pizzaorder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField no;
	JTextArea address;
	JList list;
	JComboBox base;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pizzaorder frame = new pizzaorder();
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
	public pizzaorder() {
		setTitle("Pizza order ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 711);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(193, 252, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(10, 66, 169, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 25));
		lblAddress.setBounds(10, 144, 118, 39);
		contentPane.add(lblAddress);
		
		JLabel lblMobailNo = new JLabel("Mobail No. ");
		lblMobailNo.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 25));
		lblMobailNo.setBounds(10, 293, 143, 27);
		contentPane.add(lblMobailNo);
		
		JLabel lblToppings = new JLabel("Toppings :");
		lblToppings.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 25));
		lblToppings.setBounds(10, 500, 118, 27);
		contentPane.add(lblToppings);
		
		JLabel lblBase = new JLabel("Base :");
		lblBase.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 25));
		lblBase.setBounds(10, 397, 118, 27);
		contentPane.add(lblBase);
		
		JButton place = new JButton("Place Order");
		place.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg ="Thanks " +name.getText()+"\n Your Details are:\n";
				msg +="Addres:"+address.getText()+"\n";
				msg +="Mobail No:"+no.getText()+"\n";
				msg +="Base:"+base.getSelectedItem()+"\n";
				msg +="Toppings :";
				String str="";
				Object[] tops=list.getSelectedValues();
				for (int i=0; i<tops.length;i++) 
					str+=tops[i]+",";
					msg+=str+"\n Your order will reach soon .....!!";
					JOptionPane.showMessageDialog(place,msg);	
			}
		});
		place.setForeground(new Color(0, 0, 0));
		place.setBackground(new Color(255, 128, 0));
		place.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		place.setBounds(15, 610, 164, 39);
		contentPane.add(place);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				no.setText("");
				address.setText("");
				base.setSelectedIndex(-1);
				list.clearSelection();
				
			}
		});
		reset.setBackground(new Color(255, 128, 0));
		reset.setForeground(new Color(0, 0, 0));
		reset.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		reset.setBounds(369, 610, 118, 39);
		contentPane.add(reset);
		
		JLabel lblNewLabel_1 = new JLabel("Pizza order ");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(172, 10, 188, 46);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		name.setBounds(142, 66, 367, 39);
		contentPane.add(name);
		name.setColumns(10);
		
		address = new JTextArea();
		address.setRows(5);
		address.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		address.setBounds(142, 144, 367, 93);
		contentPane.add(address);
		
		no = new JTextField();
		no.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		no.setBounds(142, 281, 367, 39);
		contentPane.add(no);
		no.setColumns(10);
		
		base = new JComboBox();
		base.setModel(new DefaultComboBoxModel(new String[] {"Basic", "Thick and Chewy", "Thin & Cripsy", "Chicago Deep Dish"}));
		base.setFont(new Font("Tahoma", Font.PLAIN, 20));
		base.setBounds(138, 379, 371, 45);
		contentPane.add(base);
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Pepporoni", "Sausage", "", "Black Olive", "Mushroom "};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setFont(new Font("Tahoma", Font.PLAIN, 20));
		list.setBounds(172, 454, 188, 122);
		contentPane.add(list);
	}
}
