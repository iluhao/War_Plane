package Model;

import java.awt.Image;

//�����������
public abstract class Fly_Object {
	protected Image img;// ��������ʽ
	protected int x;// ������
	protected int y;// ������
	protected int img_Wid;// ��
	protected int img_Hei;// ��
	protected int img_num;// ͼƬ���
	protected int speed;// �ƶ��ٶ�

	protected abstract boolean isOutScr();// �Ƿ񳬳���Ļ

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
