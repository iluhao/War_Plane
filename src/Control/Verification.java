package Control;


class Vector2 {
	double X;
	double Y;

	Vector2() {

	}

	Vector2(double x, double y) {
		this.X = x;
		this.Y = y;
	}
}

public class Verification {
	public static boolean isIntersect(Vector2[] A, Vector2[] B) {
		Vector2 A1, A2, A3, A4, B1, B2, B3, B4;
		A1 = new Vector2();
		A2 = new Vector2();
		A3 = new Vector2();
		A4 = new Vector2();
		B1 = new Vector2();
		B2 = new Vector2();
		B3 = new Vector2();
		B4 = new Vector2();
		// 凸边形A第一条边法向量
		A1.X = A[1].Y - A[0].Y;
		A1.Y = A[0].X - A[1].X;
		// 凸边形A第二条边法向量
		A2.X = A[0].Y - A[3].Y;
		A2.Y = A[3].X - A[0].X;
		// 凸边形A第三条法向量
		A3.X = A[2].Y - A[1].Y;
		A3.Y = A[1].X - A[2].X;
		// 凸边形A第四条法向量
		A4.X = A[2].Y - A[3].Y;
		A4.Y = A[3].X - A[2].X;

		// 凸边形B第一条法向量
		B1.X = B[0].Y - B[1].Y;
		B1.Y = B[1].X - B[0].X;

		B2.X = B[0].Y - B[3].Y;
		B2.Y = B[3].X - B[0].X;

		B3.X = B[2].Y - B[1].Y;
		B3.Y = B[1].X - B[2].X;

		B4.X = B[2].Y - B[3].Y;
		B4.Y = B[3].X - B[2].X;

		// 对于AX上：
		if (Tmp(A1, A, B)) {
			return false;
		}
		if (Tmp(A2, A, B)) {
			return false;
		}
		if (Tmp(A3, A, B)) {
			return false;
		}
		if (Tmp(A4, A, B)) {
			return false;
		}
		if (Tmp(B1, A, B)) {
			return false;
		}
		if (Tmp(B2, A, B)) {
			return false;
		}
		if (Tmp(B3, A, B)) {
			return false;
		}
		if (Tmp(B4, A, B)) {
			return false;
		}
		return true;
	}

	private static boolean Tmp(Vector2 IS, Vector2[] A, Vector2[] B) {
		//求出4边形A在法向量IS上的投影
		double[] v = new double[4];
		for (int i = 0; i < 4; i++) {
			double tmp = (IS.X * A[i].X + IS.Y * A[i].Y) / (IS.X * IS.X + IS.Y * IS.Y);
			v[i] = tmp * IS.X * IS.X + tmp * IS.Y * IS.Y;
		}
		//求出4边形B在法向量IS上的投影
		double[] vv = new double[4];
		for (int i = 0; i < 4; i++) {
			double tmp = (IS.X * B[i].X + IS.Y * B[i].Y) / (IS.X * IS.X + IS.Y * IS.Y);
			vv[i] = tmp * IS.X * IS.X + tmp * IS.Y * IS.Y;
		}
		//判断最大值和最小值是否有交集
		if (Math.max(Math.max(v[0], v[1]), Math.max(v[2], v[3])) >= Math.min(Math.min(vv[0], vv[1]),
				Math.min(vv[2], vv[3]))
				&& Math.min(Math.min(v[0], v[1]), Math.min(v[2], v[3])) <= Math.max(Math.max(vv[0], vv[1]),
						Math.max(vv[2], vv[3]))) {
			return false;//在这条法向量上的投影有交集
		} 

		return true;// 表示知道未碰撞

	}
}

