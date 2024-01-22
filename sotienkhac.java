package ATM;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class sotienkhac extends JFrame{
	private JLabel titField = new JLabel("THỰC HIỆN RÚT TIỀN ");
	private JLabel yeucau = new JLabel("SỐ TIỀN PHẢI LỚN HƠN 50.000 VNĐ");
	private JLabel sotien = new JLabel("NHẬP SỐ TIỀN BẠN MUỐN RÚT :");
	private JTextField dong = new JTextField(10);
	private JLabel vnd = new JLabel("VND");
	private JButton yes = new JButton("ĐỒNG Ý");
	private JButton out = new JButton("THOÁT");
	
	public sotienkhac () {
		
		this.setTitle("Rut tien");
		this.setSize(400,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		out.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(sotienkhac.class.getResource("out.png"))));
		yes.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(sotienkhac.class.getResource("dn.png"))));
		
		titField.setFont(new Font("Times new roman", Font.BOLD, 20));
		titField.setForeground(Color.BLUE);
		yeucau.setFont(new Font("Arial", Font.ITALIC, 10));
		yeucau.setForeground(Color.red);
		
		Container cn = getContentPane();
		
		cn.setBackground(Color.LIGHT_GRAY);
		cn.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		cn.add(titField);
		cn.add(yeucau);
		cn.add(sotien);
		cn.add(dong);
		cn.add(vnd);
		cn.add(yes);
		cn.add(out);
	    
	    out.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				trangchu tr = new trangchu();
			}
		});
	    yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String input = dong.getText();
				try {
					int amount = Integer.parseInt(input);
					int rut = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn rút tiền không ?","",JOptionPane.YES_NO_OPTION);
					if (amount >=50000 && amount % 50000 == 0&& rut== JOptionPane.YES_OPTION) {
						
						JOptionPane.showMessageDialog(null, "Rút tiền thành công"  + amount + "VNĐ");
					}
					else {
						JOptionPane.showMessageDialog(null, "số tiền phải là bội só của 50000 VNĐ");
						
					}
					
				} catch (Exception ex) {
					// TODO: handle exception
					
				}
				
			}
		});
		
		this.setVisible(true);
		
		
		
	}
		
	public static void main(String[] args) {
		new sotienkhac();
	}

}

