package Model;

import java.awt.Image;

//抽象飞行物类
public abstract class Fly_Object {
	protected Image img;// 飞行物样式
	protected int x;// 横坐标
	protected int y;// 纵坐标
	protected int img_Wid;// 宽
	protected int img_Hei;// 高
	protected int img_num;// 图片编号
	protected int speed;// 移动速度

	protected abstract boolean isOutScr();// 是否超出屏幕

	protected Image getImg() {
		return img;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getImg_Wid() {
		return img_Wid;
	}

	public void setImg_Wid(int img_Wid) {
		this.img_Wid = img_Wid;
	}

	public int getImg_Hei() {
		return img_Hei;
	}

	public void setImg_Hei(int img_Hei) {
		this.img_Hei = img_Hei;
	}

	public int getImg_num() {
		return img_num;
	}

	public void setImg_num(int img_num) {
		this.img_num = img_num;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setImg(Image img) {
		this.img = img;
	}



}
