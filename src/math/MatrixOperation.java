package math;
import Jama.*;
/**
 * @Title 矩阵运算
 * @Distription 计算两个矩阵相乘 B=A*R 其中A为指标权重一维数组转化为矩阵，R为隶属度判断矩阵
 *
 */
public class MatrixOperation {
	public static Matrix matrixMul(int n, Matrix R){
		double[] a = new double[n];  //n代表指标个数
		Matrix weight = new Matrix(a,n);		
		return weight.times(R);
	}
	

}
