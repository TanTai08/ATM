package ATM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class doimapin extends JFrame {

	private JLabel titJLabel = new JLabel("THỰC HIỆN ĐỔI MÃ PIN");
	private JLabel cu = new JLabel("MÃ PIN CŨ ");
	private JTextField n1 = new JTextField(13);
	private JLabel moi = new JLabel("MÃ PIN MỚI");
	private JTextField n2 = new JTextField(13);

	private JButton luu = new JButton("THỰC HIỆN");
	private JButton bo = new JButton("THOÁT");

	public doimapin() {

		this.setTitle("Đổi mã PIN");
		this.setSize(345, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bo.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(doimapin.class.getResource("out.png"))));
		luu.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(doimapin.class.getResource("dn.png"))));
		
		titJLabel.setFont(new Font("Times new roman", Font.BOLD, 20));
		titJLabel.setForeground(Color.BLUE);

		Container cn = this.getContentPane();

		cn.setBackground(Color.LIGHT_GRAY);

		cn.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		cn.add(titJLabel);
		cn.add(cu);
		cn.add(n1);
		cn.add(moi);
		cn.add(n2);
		cn.add(luu);
		cn.add(bo);

		bo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				trangchu tr = new trangchu();
			}
		});
		luu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pincu = n1.getText();
				String pinmoi = n2.getText();
				
				String url = "jdbc:mysql://127.0.0.1:3306/atm";
				String username = "root";
				String password = "taihoang2608!";

				try {
					Connection conn = DriverManager.getConnection(url, username, password);
					String selectQuery = "UPDATE khachhang SET MaPin = ? WHERE MaPin = ?";
					PreparedStatement statement = conn.prepareStatement(selectQuery);
					statement.setString(1, pinmoi);
					statement.setString(2, pincu);

					int resultSet = statement.executeUpdate();
					
					if (resultSet > 0) {
						JOptionPane.showInternalMessageDialog(null, "Đổi mã  pin thành công");
					} else {
						JOptionPane.showMessageDialog(null, "Mã pin không chính xác  ");
					}
					statement.close();
					conn.close();
				} catch (SQLException ex) {
					
					ex.printStackTrace();
				}
			}
		});

						
				

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new doimapin();

	}

}
