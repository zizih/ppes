package math;
import Jama.*;
/**
 * @Title ��������
 * @Distription ��������������� B=A*R ����AΪָ��Ȩ��һά����ת��Ϊ����RΪ�������жϾ���
 *
 */
public class MatrixOperation {
	public static Matrix matrixMul(int n, Matrix R){
		double[] a = new double[n];  //n����ָ�����
		Matrix weight = new Matrix(a,n);		
		return weight.times(R);
	}
	

}
