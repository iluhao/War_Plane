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
		// 标题
		this.setTitle("飞机大战");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		// 面板
		panel = new MyJPanel(dim);
		this.add(panel);
		Thread th = new Thread(panel);
		th.start();

		// 初始化JF界面
		this.addKeyListener(this);// 键盘监听
		this.setResizable(false);// 不可改变大小
		this.setSize(dim.width, dim.height);
		this.setUndecorated(true);// 无标题
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Jm_main();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 27) {
			int n = JOptionPane.showConfirmDialog(null, "确认退出游戏？", "", JOptionPane.YES_NO_OPTION);
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
