package ATM;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class chuyenkhoan extends JFrame {
	private JLabel titJLabel = new JLabel("MỜI QUÝ KHÁCH THỰC HIỆN CHUYỂN KHOẢN");
	private JLabel nganhang = new JLabel(" LỰA CHỌN NGÂN HÀNG : ");
	private JComboBox<String> nganhangjComboBox = new JComboBox<>();
	private JLabel nhan = new JLabel(" STK NHẬN : ");
	private JTextField n1 = new JTextField(20);
	private JLabel chuyen = new JLabel("   SỐ TIỀN :  ");
	private JTextField n2 = new JTextField(20);
	private JButton lam = new JButton("THỰC HIỆN");
	private JButton canner = new JButton("THOÁT");

	public chuyenkhoan() {

		this.setTitle("Chuyển khoản");
		this.setSize(390, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lam.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(chuyenkhoan.class.getResource("dn.png"))));
		canner.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(chuyenkhoan.class.getResource("out.png"))));

		nganhangjComboBox.addItem( null );
		nganhangjComboBox.addItem("SACOMBANK");
		nganhangjComboBox.addItem("AGRIBANK");
		nganhangjComboBox.addItem("MBBANK");
		nganhangjComboBox.addItem("ACB");
		nganhangjComboBox.addItem("HDBANK");
		nganhangjComboBox.addItem("BIDV");

		Container cn = getContentPane();
		cn.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		cn.add(titJLabel);
		titJLabel.setFont(new Font("Times new roman", Font.BOLD, 16));
		titJLabel.setForeground(Color.BLUE);
		cn.add(nganhang);
		cn.add(nganhangjComboBox);
		cn.add(nhan);
		cn.add(n1);
		cn.add(chuyen);
		cn.add(n2);
		cn.add(lam);
		cn.add(canner);

		canner.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				trangchu tr = new trangchu();
			}
		});
		lam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String stknhan = n1.getText();
				String sotien = n2.getText();
				try {
					double tien = Double.parseDouble(sotien);
					if (tien< 10000) {
						JOptionPane.showMessageDialog(null, "Số tiền phải lớn hơn 10000 VNĐ");
					}
						else {
							JOptionPane.showMessageDialog(null, "Chuyển tiền thành công" + tien + "VNĐ");
							
						}
					}
				 catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Không hợp lệ ");
				}
			}
		});
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new chuyenkhoan();
	}
}
