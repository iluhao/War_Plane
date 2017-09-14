package Model;

import java.awt.Graphics;
import javax.swing.ImageIcon;

import Control.MyJPanel;

public class Plane_Enemy extends Fly_Object implements Runnable {

	public Plane_Enemy(int imgnum, int x, int y, int speed) {
		// 初始化
		this.img = new ImageIcon("img/ep" + imgnum + ".png").getImage();
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.img_Wid = img.getWidth(null);
		this.img_Hei = img.getHeight(null);

	}

	public void paint(Graphics g) {
		g.drawImage(img, x, y, null);
	}

	@Override
	public void run() {
		while (true) {
			// 战机下落
			y += speed;
			// 边界检测
			if (isOutScr()) {
				MyJPanel.ENEMYS.remove(this);
				break;
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean isOutScr() {
		//超出屏幕下方 或 屏幕右方 ，左方不考虑
		return y>MyJPanel.SCR_Y || x>(MyJPanel.SCR_X-img_Wid)  ? true : false;
	}
}
