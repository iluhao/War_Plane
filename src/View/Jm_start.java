package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Jm_start extends JFrame implements MouseListener {
	// ��ť
	private JButton bt_start;
	private JButton bt_end;
	Jm_start() {
		this.setTitle("�ɻ���ս");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		// ��ť��
		JPanel p_bt = new JPanel();
		bt_start = new JButton("��ʼ��Ϸ");
		bt_end = new JButton("������Ϸ");
		p_bt.add(bt_start);
		p_bt.add(bt_end);

		// ������
		bt_start.addMouseListener(this);
		bt_end.addMouseListener(this);

		this.add(p_bt);
		this.setBounds((dim.width - 400) / 2, (dim.height - 300) / 2, 400, 300);// �������
		this.setResizable(false);// ��С���ɸı�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	// ������
	public static void main(String[] args) {
		new Jm_start();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

		if (arg0.getSource() == bt_start) {
			this.setVisible(false);
			new Jm_main();
		} else if (arg0.getSource() == bt_end) {
			System.exit(0);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}
}
