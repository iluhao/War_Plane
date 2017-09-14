package Model;

import java.awt.Graphics;
import javax.swing.ImageIcon;

import Control.MyJPanel;

public class Plane_Bullet extends Fly_Object implements Runnable {

	public int r;// ��Ӧ�뾶

	public Plane_Bullet() {
		// �����ӵ�
		
		this.img = new ImageIcon("img/fire.png").getImage();
		this.img_Wid = img.getWidth(null);
		this.img_Hei = img.getHeight(null);
		this.speed = 10;
	}

	public void paint(Graphics g) {
		g.drawImage(img, x - r, y - r - 60, null);
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	@Override
	public void run() {
		// �ӵ��ƶ�
		while (true) {
			y -= speed;
			if (isOutScr()) {// �߽���
				MyJPanel.BULLETS.remove(this);
				break;
			}

			// ��ײ���
			for (int i = 0; i < MyJPanel.ENEMYS.size(); i++) {
				try {
					Plane_Enemy e = MyJPanel.ENEMYS.get(i);
					// ��+��; ��+�� ;���治�ж�
					if (((((x - r) >= e.getX() && (x - r) <= e.getX() + e.getImg_Wid())
							|| (((x - r + img_Wid) >= e.x && (x - r + img_Wid) <= (e.getX() + e.img_Wid)))
							|| ((x - r) <= e.getX() && (x - r + img_Wid) >= e.getX())) && (y - r - 60) >= e.getY()
							&& (y - r - 60) <= (e.getY() + e.getImg_Wid()))) {
						MyJPanel.ENEMYS.remove(e);
						MyJPanel.BULLETS.remove(this);
						Plane_Hero.score += 10;
					}
				} catch (Exception e) {

				}
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// �߽���
	@Override
	public boolean isOutScr() {
		// �����Ͻ�
		return (y - r - 60 + img_Wid) < 0 ? true : false;
	}
}
