package Model;

import javax.swing.*;

import Control.MyJPanel;

import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Plane_Hero extends Fly_Object {

	public int r;// �뾶
	private int allBlood;
	private int blood;// ��Ѫ
	static int score;// ����
	private Plane_Bullet bullet;// �ӵ�
	private Timer timer1;// ��ʱ�����ӵ�
	private Timer timer2;// ��ʱ����ս��
	private Random random;// �������
	private Plane_Enemy enemy;// ս��

	public Plane_Hero() {
		// ��ʼ��
		this.img = new ImageIcon("img/hero.png").getImage();
		this.img_Wid = img.getWidth(null);
		this.img_Hei = img.getHeight(null);
		this.r = img_Wid;
		this.random = new Random();
		this.timer1 = new Timer();// ��ʱ�����������ӵ�
		this.timer1.schedule(new PlayerTask(), 100);
		this.timer2 = new Timer();
		this.timer2.schedule(new EnemyTask(), 100);
		
	}

	// ��ʱ�����ӵ�
	class PlayerTask extends TimerTask {
		@Override
		public void run() {
			while (true) {
				
				if (MyJPanel.BULLETS.size() < 20) {
					bullet = new Plane_Bullet();
					bullet.setX(x - 15);
					bullet.setY(y - 60);
					bullet.setR(35);
					MyJPanel.BULLETS.add(bullet);
					new Thread(bullet).start();
					
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// ��ʱ���ɵл�
	class EnemyTask extends TimerTask {
		@Override
		public void run() {
			while (true) {
				if (MyJPanel.ENEMYS.size() <= 10) { // �л���������
					
					int result = (int) (Math.random() * 5 + 1);// �ٶȵ�ֵ
					enemy = new Plane_Enemy(random.nextInt(16), random.nextInt(MyJPanel.SCR_X), 0, result);
					MyJPanel.ENEMYS.add(enemy);
					new Thread(enemy).start();
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void paint(Graphics g) {
		// ��Ѫ
		g.setColor(Color.ORANGE);
		g.fillRect(20, 20, allBlood, 30);
		// ��Ѫ
		g.setColor(Color.RED);
		g.fillRect(20, 20, blood, 30);
		// ����
		g.setFont(new Font("����", Font.BOLD, 20));
		g.drawString("������" + score, MyJPanel.SCR_X - 150, 50);
		// �ɻ�
		g.drawImage(img, x - r / 2, y - r / 2, null);
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getAllBlood() {
		return allBlood;
	}

	public void setAllBlood(int allBlood) {
		this.allBlood = allBlood;
	}

	public int getBlood() {
		return blood;
	}

	public void setBlood(int blood) {
		this.blood = blood;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public boolean isOutScr() {
		return ((y - r / 2) < 0) || ((y - r / 2 + img_Hei) > MyJPanel.SCR_Y) || ((x - r / 2) < 0)
				|| (((x - r / 2 + img_Wid) > MyJPanel.SCR_X)) ? true : false;
	}
}
