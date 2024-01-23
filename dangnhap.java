
package ATM;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URL;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Driver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ketnoi.KetNoicsdl;
public class dangnhap extends JFrame {
	protected static final String AccountName = null;
	private JLabel jLabel = new JLabel("NGÂN HÀNG MEBANK XIN KÍNH CHÀO QUÝ KHÁCH");
	private JLabel soTaiKhoanLabel = new JLabel("SỐ TÀI KHOẢN :");
	private JTextField soTaiKhoanField = new JTextField(20);
	private JLabel matKhauLabel = new JLabel("    MẬT KHẢU :   ");
	private JPasswordField matKhauField = new JPasswordField(20);	
	private JButton dangNhapButton = new JButton("ĐĂNG NHẬP");
	private JButton thoatButton = new JButton("THOÁT");

	
	public dangnhap() {
		URL urlmb = dangnhap.class.getResource("icon_mebank.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlmb);
		this.setIconImage(img);

		thoatButton
				.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(dangnhap.class.getResource("out.png"))));
		dangNhapButton
				.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(dangnhap.class.getResource("dn.png"))));

		jLabel.setFont(new Font("Times new roman", Font.BOLD, 20));
		jLabel.setForeground(Color.BLUE);

		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 40, 20);
		this.setLayout(flowLayout);
		Container container = this.getContentPane();
		container.setBackground(Color.LIGHT_GRAY);
		container.add(jLabel);
		container.add(soTaiKhoanLabel);
		container.add(soTaiKhoanField);
		container.add(matKhauLabel);
		container.add(matKhauField);
		container.add(dangNhapButton);
		container.add(thoatButton);

		dangNhapButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String soTaiKhoan = soTaiKhoanField.getText();
				String matKhau = new String(matKhauField.getPassword());

				
				String url = "jdbc:mysql://127.0.0.1:3306/atm";
				String username = "root";
				String password = "taihoang2608!";

				try {
					Connection conn = DriverManager.getConnection(url, username, password);
					String selectQuery = "SELECT * FROM khachhang WHERE STK = ? AND MaPin = ? ";
					PreparedStatement statement = conn.prepareStatement(selectQuery);
					statement.setString(1, soTaiKhoan);
					statement.setString(2, matKhau);

					ResultSet resultSet = statement.executeQuery();

					if (resultSet.next()) {
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
						setVisible(false);
						trangchu tr = new trangchu();
					} else {
						JOptionPane.showMessageDialog(null, "Đăng nhập không thành công");
					}

					resultSet.close();
					statement.close();
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		thoatButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		;

		this.setTitle("Đăng Nhập");
		this.setSize(520, 250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	

	public static void main(String[] args) {
		new dangnhap();
	}

}