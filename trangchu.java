package ATM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class trangchu extends JFrame {
	private JLabel tit = new JLabel("MEBANK XIN KÍNH CHÀO QUÝ KHÁCH ");
	private JButton rut = new JButton("RÚT TIỀN");
	private JButton pin = new JButton("PIN");
	private JButton ck = new JButton("CHUYỂN KHOẢN");
	private JButton sodu = new JButton("SỐ DƯ");
	private JButton thongtin = new JButton("THÔNG TIN KHÁCH HÀNG");
	private JButton out = new JButton("THOÁT");

	public trangchu() {
		this.setTitle("TRANG CHỦ");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		out.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(trangchu.class.getResource("out.png"))));
		tit.setFont(new Font("Times new roman", Font.BOLD, 20));
		tit.setForeground(Color.BLUE);

		Container cn = this.getContentPane();

		cn.setLayout(new BorderLayout());
		cn.setBackground(Color.lightGray);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(new GridLayout(3, 2, 30, 30));
		panel.add(rut);
		panel.add(pin);
		panel.add(ck);
		panel.add(sodu);
		panel.add(thongtin);
		panel.add(out);

		cn.add(panel, BorderLayout.CENTER);
		cn.add(tit, BorderLayout.NORTH);

		

		rut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ruttien rt = new ruttien();
			}
		});

		ck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				chuyenkhoan ck = new chuyenkhoan();
			}
		});

		pin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				doimapin mp = new doimapin();
			}
		});

		out.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);

			}
		});
		sodu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String accountName = JOptionPane.showInputDialog("Nhập Mã Pin");
				DatabaseManager.getAccountBalance(accountName);
			}
		});
		thongtin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String accountName = JOptionPane.showInputDialog("Nhập Mã Pin :");
				DatabaseManager.getAccountInfo(accountName);
			}
		});

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new trangchu();
	}
}

class DatabaseManager {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/atm";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456789abcd";

	public static void getAccountInfo(String accountName) {
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "SELECT * FROM khachhang WHERE MaPin = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, accountName);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String tenKH = resultSet.getString("TenKH");
				String stk = resultSet.getString("STK");
				int soDu = resultSet.getInt("SoDu");

				JOptionPane.showMessageDialog(null, "Thông tin khách hàng:\nTên khách hàng: " + tenKH
						+ "\nSố tài khoản: " + stk + "\nSố dư: " + soDu);
			} else {
				JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin khách hàng");
			}

			resultSet.close();
			statement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

    public static void getAccountBalance(String accountName) {
    	try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "SELECT * FROM khachhang WHERE MaPin = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, accountName);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				double soDu = resultSet.getDouble("SoDu");
				
				JOptionPane.showMessageDialog(null, "Số Dư Tài Khoản là : " + soDu);
			} else {
				JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin khách hàng");
			}
         resultSet.close();
         statement.close();
    	}
    	catch (SQLException ex) {
    		ex.printStackTrace();
    	}
    }
}
   	
    