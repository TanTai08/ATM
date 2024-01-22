package ATM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ruttien extends JFrame {
	private JLabel jLabel_tieude = new JLabel("MỜI QUÝ KHÁCH CHỌN MỆNH GIÁ RÚT TIỀN");
	private JButton tramButton = new JButton("100.000");
	private JButton trieuButton = new JButton("1.000.000");
	private JButton namButton = new JButton("500.000");
	private JButton haiTrButton = new JButton("2.000.000");
	private JButton baTrButton = new JButton("3.000.000");
	private JButton namTrButton = new JButton("5.000.000");
	private JButton khacButton = new JButton("NHẬP SỐ TIỀN KHÁC");
	private JButton outButton = new JButton("THOÁT");

	public ruttien() {

		this.setTitle("Rut Tien");
		this.setSize(420, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		outButton.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ruttien.class.getResource("out.png"))));
		jLabel_tieude.setFont(new Font("Times new roman", Font.BOLD, 18));
		jLabel_tieude.setForeground(Color.BLUE);
		Container cn = getContentPane();
		cn.setBackground(Color.LIGHT_GRAY);

		JPanel jPanel = new JPanel();

		jPanel.setLayout(new GridLayout(4, 2, 20, 20));
		jPanel.setBackground(Color.LIGHT_GRAY);
		jPanel.add(trieuButton);
		jPanel.add(haiTrButton);
		jPanel.add(tramButton);
		jPanel.add(baTrButton);
		jPanel.add(namButton);
		jPanel.add(namTrButton);
		jPanel.add(khacButton);
		jPanel.add(outButton);

		cn.add(jLabel_tieude, BorderLayout.NORTH);
		cn.add(jPanel, BorderLayout.CENTER);

		tramButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				confirmrut(100000);

			}
		});
		trieuButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				confirmrut(1000000);
			}
		});
		baTrButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				confirmrut(3000000);
			}
		});
		namButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				confirmrut(500000);

			}
		});
		namTrButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				confirmrut(5000000);
			}
		});
		haiTrButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				confirmrut(2000000);
			}
		});
		khacButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				sotienkhac stk = new sotienkhac();
			}
		});
		outButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				trangchu tr = new trangchu();

			}
		});

		this.setVisible(true);

	}

	private void confirmrut(int sotienrut) {
		// TODO Auto-generated method stub
		int tien = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn rút tiền không ?", "",
				JOptionPane.YES_NO_OPTION);
		if (tien == JOptionPane.YES_OPTION) {
		rutTien(sotienrut);
		} else {
			JOptionPane.showMessageDialog(null, "Rút tiền không thành công");
			
		}
		
		
	}

	private void rutTien(int sotienrut) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Rút tiền thành công " + sotienrut);
	}

	public static void main(String[] args) {
		new ruttien();

	}

}
