package Control;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.Plane_Bullet;
import Model.Plane_Enemy;
import Model.Plane_Hero;

public class MyJPanel extends JPanel implements MouseMotionListener, Runnable {

	// 背景
	private int bg_num;
	private Image bg_image;// 游戏背景
	private Image bg_gameover;// 游戏结束背景

	// 屏幕大小
	public static int SCR_X;
	public static int SCR_Y;

	// 子弹

	public static Vector<Plane_Bullet> BULLETS;// 子弹集合
	public static Vector<Plane_Enemy> ENEMYS;// 敌机集合
	// 飞机
	private Plane_Hero plane;

	// 重新开始
	private int ans;

	// 图片左边
	private Vector2 A[] = new Vector2[4];
	private Vector2 B[] = new Vector2[4];

	public MyJPanel(Dimension dim) {
		// 初始化背景图片
		this.bg_num = (int) (Math.random() * 5 + 1);
		this.bg_image = new ImageIcon("img/bg" + bg_num + ".jpg").getImage();
		this.bg_gameover = new ImageIcon("img/GameOver.jpg").getImage();
		this.SCR_X = dim.width;
		this.SCR_Y = dim.height;

		// 初始化战机
		this.plane = new Plane_Hero();
		this.plane.setAllBlood(150);
		this.plane.setBlood(150);
		this.plane.setScore(0);
		this.plane.setR(plane.getImg_Wid());
		this.plane.setX((SCR_X - plane.getR() * 2) / 2);
		this.plane.setY((SCR_Y - plane.getR() * 3) / 2);

		// 初始化子弹和敌机集合
		this.BULLETS = new Vector<Plane_Bullet>();
		this.ENEMYS = new Vector<Plane_Enemy>();

		// 重新开始反馈
		this.ans = 4;

		this.addMouseMotionListener(this);
		new Plane_Enemy(1, 0, 0, 100);

		// 初始化子弹坐标
		for (int i = 0; i < 4; i++) {
			A[i] = new Vector2();
			B[i] = new Vector2();
		}

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// 绘制场面背景
		g.drawImage(bg_image, 0, 0, SCR_X, SCR_Y, null);

		// 绘制子弹
		for (int i = 0; i < BULLETS.size(); i++) {
			BULLETS.get(i).paint(g);
		}

		// 绘制敌机
		for (int i = 0; i < ENEMYS.size(); i++) {
			ENEMYS.get(i).paint(g);
		}

		// 绘制战机
		if (plane.isOutScr()) {
			// 超出上界
			if ((plane.getY() - plane.getR() / 2) < 0) {
				plane.setY(plane.getImg_Hei() / 2 + 10);
			}
			// 超出下界
			if ((plane.getY() - plane.getR() / 2 + plane.getImg_Hei()) > MyJPanel.SCR_Y) {
				plane.setY(MyJPanel.SCR_Y - plane.getImg_Hei() / 2);
			}
			// 超出左边
			if ((plane.getX() - plane.r / 2) < 0) {
				plane.setX(plane.getImg_Wid() / 2);
			}
			// 超出右边
			if ((plane.getX() - plane.getR() / 2 + plane.getImg_Wid() > MyJPanel.SCR_X)) {
				plane.setX(MyJPanel.SCR_X - plane.getImg_Wid() / 2);
			}

			plane.paint(g);
		} else {
			plane.paint(g);
		}

		// 绘制游戏结束界面
		if (plane.getBlood() == 0) {
			g.drawImage(bg_gameover, 0, 0, MyJPanel.SCR_X, MyJPanel.SCR_Y, null);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {// 鼠标移动
		plane.setX(e.getX());
		plane.setY(e.getY());
	}

	@Override
	public void run() {

		while (plane.getBlood() > 0) {
			repaint();

			// 碰撞检测
			for (int i = 0; i < MyJPanel.ENEMYS.size(); i++) {
				try {
					Plane_Enemy e = MyJPanel.ENEMYS.get(i);

					// if ((((plane.x - plane.r / 2) >= e.x && (plane.x -
					// plane.r / 2) <= (e.x + e.imgW))
					// || ((plane.x - plane.r / 2 + plane.imgW) <= (e.x +
					// e.imgW)
					// && (plane.x - plane.r / 2 + plane.imgW >= e.x)))
					// && (((plane.y - plane.r / 2) >= e.y && (plane.y - plane.r
					// / 2) <= (e.y + e.imgH))||((plane.y - plane.r /
					// 2+plane.imgH)<=(e.y+e.imgH)&&(plane.y - plane.r /
					// 2+plane.imgH)>=e.y))){
					A[0].X = plane.getX() - plane.getR() / 2 + plane.getImg_Wid() / 2;
					A[0].Y = plane.getY() - plane.getR() / 2;
					A[1].X = plane.getX() - plane.getR() / 2 + plane.getImg_Wid();
					A[1].Y = plane.getY() - plane.getR() / 2 + plane.getImg_Hei() - 20;
					A[2].X = plane.getX() - plane.getR() / 2 + plane.getImg_Wid() / 2;
					A[2].Y = plane.getY() - plane.getR() / 2 + plane.getImg_Hei();
					A[3].X = plane.getX() - plane.getR() / 2;
					A[3].Y = plane.getY() - plane.getR() / 2 + plane.getImg_Hei() - 20;

					B[0].X = e.getX() + e.getImg_Wid() / 2;
					B[0].Y = e.getY();
					B[1].X = e.getX() + e.getImg_Wid();
					B[1].Y = e.getY() + e.getImg_Hei() / 2;
					B[2].X = e.getX() + e.getImg_Wid() / 2;
					B[2].Y = e.getY() + e.getImg_Hei();
					B[3].X = e.getX();
					B[3].Y = e.getY() + e.getImg_Hei() / 2;

					if (Verification.isIntersect(A, B)) {
						MyJPanel.ENEMYS.remove(e);
						MyJPanel.BULLETS.remove(this);
						plane.setScore(plane.getScore() + 10);
						plane.setBlood(plane.getBlood() - 30);
					}
					
					// 血量为0
					if (plane.getBlood() == 0) {
						ans = JOptionPane.showConfirmDialog(this, "当前分数：" + plane.getScore() + "是否重新开始", "游戏结束",
								JOptionPane.YES_NO_OPTION);
						if (ans == 0) {
							plane.setBlood(plane.getAllBlood());
							plane.setScore(0);
						}
					}
					// }
				} catch (Exception e) {

				}
			}

		}
	}
}