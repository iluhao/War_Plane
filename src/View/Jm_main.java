package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Control.MyJPanel;

public class Jm_main extends JFrame implements KeyListener {
	private MyJPanel panel;

	Jm_main() {
		// ����
		this.setTitle("�ɻ���ս");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		// ���
		panel = new MyJPanel(dim);
		this.add(panel);
		Thread th = new Thread(panel);
		th.start();

		// ��ʼ��JF����
		this.addKeyListener(this);// ���̼���
		this.setResizable(false);// ���ɸı��С
		this.setSize(dim.width, dim.height);
		this.setUndecorated(true);// �ޱ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Jm_main();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 27) {
			int n = JOptionPane.showConfirmDialog(null, "ȷ���˳���Ϸ��", "", JOptionPane.YES_NO_OPTION);
			if (n == 0) {
				System.exit(0);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
