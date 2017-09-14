package Model;

import javax.swing.*;

import Control.MyJPanel;

import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Plane_Hero extends Fly_Object {

	public int r;// 半径
	private int allBlood;
	private int blood;// 损血
	static int score;// 分数
	private Plane_Bullet bullet;// 子弹
	private Timer timer1;// 定时生成子弹
	private Timer timer2;// 定时生成战机
	private Random random;// 随机函数
	private Plane_Enemy enemy;// 战机

	public Plane_Hero() {
		// 初始化
		this.img = new ImageIcon("img/hero.png").getImage();
		this.img_Wid = img.getWidth(null);
		this.img_Hei = img.getHeight(null);
		this.r = img_Wid;
		this.random = new Random();
		this.timer1 = new Timer();// 定时器不断生成子弹
		this.timer1.schedule(new PlayerTask(), 100);
		this.timer2 = new Timer();
		this.timer2.schedule(new EnemyTask(), 100);
		
	}

	// 定时生成子弹
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

	// 定时生成敌机
	class EnemyTask extends TimerTask {
		@Override
		public void run() {
			while (true) {
				if (MyJPanel.ENEMYS.size() <= 10) { // 敌机数量限制
					
					int result = (int) (Math.random() * 5 + 1);// 速度的值
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
		// 满血
		g.setColor(Color.ORANGE);
		g.fillRect(20, 20, allBlood, 30);
		// 残血
		g.setColor(Color.RED);
		g.fillRect(20, 20, blood, 30);
		// 分数
		g.setFont(new Font("宋体", Font.BOLD, 20));
		g.drawString("分数：" + score, MyJPanel.SCR_X - 150, 50);
		// 飞机
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
