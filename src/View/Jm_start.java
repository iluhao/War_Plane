package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Jm_start extends JFrame implements MouseListener {
	// 按钮
	private JButton bt_start;
	private JButton bt_end;
	Jm_start() {
		this.setTitle("飞机大战");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		// 按钮栏
		JPanel p_bt = new JPanel();
		bt_start = new JButton("开始游戏");
		bt_end = new JButton("结束游戏");
		p_bt.add(bt_start);
		p_bt.add(bt_end);

		// 监听器
		bt_start.addMouseListener(this);
		bt_end.addMouseListener(this);

		this.add(p_bt);
		this.setBounds((dim.width - 400) / 2, (dim.height - 300) / 2, 400, 300);// 界面居中
		this.setResizable(false);// 大小不可改变
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	// 主函数
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
