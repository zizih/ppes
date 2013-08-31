package math;

/**
 * @Title �����Ⱥ���
 * @Distription �Զ���ֵ��Ϊ�������������Ⱥ���������� 
 *
 */
public class MembershipFunction { 
	/**
	 * @param x��[0,1]
	 * @return v һά����,4��Ԫ��
	 */
	public static double[] mf(double x){
		double[] v = {0,0,0,0};
		if (x==1 || x==0.9) {
			v[0]=1;
			v[1]=0;
			v[2]=0;
			v[3]=0;
		} 
		else if (x>0.9 && x<1) {
			v[0]=(1-x)/0.1;
			v[1]=(x-0.9)/0.1;
			v[2]=0;
			v[3]=0;
		}
		else if (x>0.8 && x<0.9){
			v[0]=0;
			v[1]=(0.9-x)/0.1;
			v[2]=(0.9-x)/0.1;
			v[3]=0;			
		}
		else if(x==0.8){
			v[0]=0;
			v[1]=1;
			v[2]=0;
			v[3]=0;
		}
		else if (x>0.7 && x<0.8){
			v[0]=0;
			v[1]=0;
			v[2]=(0.8-x)/0.1;
			v[3]=(0.8-x)/0.1;			
		}
		
		else if(x==0.7){
			v[0]=0;
			v[1]=0;
			v[2]=1;
			v[3]=0;
		}		
		else if((x>=0 && x<0.7)){
			v[0]=0;
			v[1]=0;
			v[2]=0;
			v[3]=1;
		}
		return v;		
	}
}
