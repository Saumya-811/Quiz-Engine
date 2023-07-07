import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddStudent extends JInternalFrame {
	private JTextField Txtpno;
	private JTextField txtName;
	private JTextField txtPass;

	
	public AddStudent() {
		setBounds(0, 0, 876, 698);
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		getContentPane().setLayout(null);
		
		Txtpno = new JTextField();
		Txtpno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Txtpno.setBounds(240, 73, 486, 19);
		getContentPane().add(Txtpno);
		Txtpno.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(240, 174, 486, 19);
		getContentPane().add(txtName);
		
		txtPass = new JTextField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPass.setBounds(240, 122, 486, 19);
		getContentPane().add(txtPass);
		txtPass.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try
				{
Class.forName("com.mysql.cj.jdbc");
Connection connection=DriverManager.getConnection("jdbc://localhost/qe?user=root&password=root");
String query="insert into student values(?,?,?)";
PreparedStatement statement=connection.prepareStatement(query);
statement.setString(1,Txtpno.getText());
statement.setString(2,txtName.getText());
statement.setString(3,txtPass.getText());
statement.executeUpdate();
connection.close();
				
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Data Saved");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(439, 311, 85, 21);
		getContentPane().add(btnNewButton);

	}
}
