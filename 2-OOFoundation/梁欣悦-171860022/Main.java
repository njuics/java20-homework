import java.util.ArrayList;

public class Main {
	static public void main(String[] args) throws Exception {
		/*������һ�����򷽷���ѡ��sortMethod�е�0�ŷ���*/
		sortMethod orchestrationMethod = new sortMethod();
		orchestrationMethod.methodNumber=0;
		
		/*����үү��������ָ�Ӻ�«������ķ���*/
		Grandpa grandpa=new Grandpa(orchestrationMethod);
		
		/*������һ�����򷽷���ѡ��sortMethod�е�1�ŷ���*/
		sortMethod choreographyMethod = new sortMethod();
		choreographyMethod.methodNumber=1;
		
		/*���������ޣ����������໥Э��ʱ�����򷽷�*/
		Kid hong=new Kid("�ϴ�",7,choreographyMethod);
		Kid cheng=new Kid("�϶�",6,choreographyMethod);
		Kid huang=new Kid("����",5,choreographyMethod);
		Kid lv=new Kid("����",4,choreographyMethod);
		Kid qing=new Kid("����",3,choreographyMethod);
		Kid lan=new Kid("����",2,choreographyMethod);
		Kid zi=new Kid("����",1,choreographyMethod);
		
		/*�����ŶӵĶ��У������Ǵ���վһ��λ��*/
		ArrayList<Kid> kidArray=new ArrayList<Kid>();
		for(int i=0;i<7;i++) {
			kidArray.add(new Kid());
		}
		hong.setMyPosition(kidArray, 5);
		cheng.setMyPosition(kidArray, 0);
		huang.setMyPosition(kidArray, 3);
		lv.setMyPosition(kidArray, 2);
		qing.setMyPosition(kidArray, 6);
		lan.setMyPosition(kidArray, 4);
		zi.setMyPosition(kidArray, 1);
		
		/*үү��ָ�Ӻ�«�����ж�*/
		System.out.println("үүָ��:");
		grandpa.orchestrationSort(kidArray);
		for(Kid k:kidArray) {
			k.baoshu();
		}
		
		/*��«���໥Э��,ÿ�����ڶ����кͱ��˽������ҵ��Լ���λ��*/
		System.out.println("\n�໥Э��:");
		hong.findMyPosition(kidArray);
		cheng.findMyPosition(kidArray);
		huang.findMyPosition(kidArray);
		lv.findMyPosition(kidArray);
		qing.findMyPosition(kidArray);
		lan.findMyPosition(kidArray);
		zi.findMyPosition(kidArray);
		for(Kid k:kidArray) {
			k.baoshu();
		}
		
    }

	
}
