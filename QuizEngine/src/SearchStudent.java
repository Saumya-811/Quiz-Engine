import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchStudent extends JInternalFrame {
	private JTextField textField;
	private JScrollPane scrollPane;
	JTable table;
	void disp()
	{
		try
		{
Class.forName("com.mysql.cj.jdbc");
Connection connection=DriverManager.getConnection("jdbc://localhost/qe?user=root&password=root");
String query="select * from student where name like '+n+"%'";
PreparedStatement statement=connection.prepareStatement(query);
ResultSet result=statement.executeQuery();

while(result.next())
{
	String row[]= {result.getString(1),result.getString(2),result.getString(3)};
	DefaultTableModel 
	
}
connection.close();
		
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Data Saved");
		}
	}
	public SearchStudent() {
		setBounds(0, 0, 876, 698);
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		 scrollPane = new JScrollPane();
		 scrollPane.addKeyListener(new KeyAdapter() {
		 	@Override
		 	public void keyReleased(KeyEvent e) {
		 		disp(textField.getText());
		 	}
		 });
		getContentPane().add(scrollPane, BorderLayout.CENTER);

	}

}