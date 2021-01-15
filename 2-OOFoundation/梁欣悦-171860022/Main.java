import java.util.ArrayList;

public class Main {
	static public void main(String[] args) throws Exception {
		/*创建第一种排序方法，选择sortMethod中的0号方法*/
		sortMethod orchestrationMethod = new sortMethod();
		orchestrationMethod.methodNumber=0;
		
		/*创建爷爷，告诉他指挥葫芦娃排序的方法*/
		Grandpa grandpa=new Grandpa(orchestrationMethod);
		
		/*创建第一种排序方法，选择sortMethod中的1号方法*/
		sortMethod choreographyMethod = new sortMethod();
		choreographyMethod.methodNumber=1;
		
		/*创建各种娃，告诉它们相互协作时的排序方法*/
		Kid hong=new Kid("老大",7,choreographyMethod);
		Kid cheng=new Kid("老二",6,choreographyMethod);
		Kid huang=new Kid("老三",5,choreographyMethod);
		Kid lv=new Kid("老四",4,choreographyMethod);
		Kid qing=new Kid("老五",3,choreographyMethod);
		Kid lan=new Kid("老六",2,choreographyMethod);
		Kid zi=new Kid("老七",1,choreographyMethod);
		
		/*创建排队的队列，让它们打乱站一个位置*/
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
		
		/*爷爷来指挥葫芦娃们行动*/
		System.out.println("爷爷指挥:");
		grandpa.orchestrationSort(kidArray);
		for(Kid k:kidArray) {
			k.baoshu();
		}
		
		/*葫芦娃相互协作,每个人在队列中和别人交换，找到自己的位置*/
		System.out.println("\n相互协作:");
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
