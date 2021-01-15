package homework_9;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;


import org.junit.jupiter.api.Test;

class ChoreographyTest {

	public static ArrayList<Calabash_Brothers> start=new ArrayList<Calabash_Brothers>();
	public static ArrayList<Calabash_Brothers> ans = new ArrayList<Calabash_Brothers>();
	
	boolean if_equal(ArrayList<Calabash_Brothers> a,ArrayList<Calabash_Brothers>b) {
		if(a.size()!=b.size())return false;
		for(int i=0;i<a.size();i++) {
			if(a.get(i).getval()!=b.get(i).getval())
				return false;
		}
		
		return true;
	}
	
	public void create_ans() {
		for(int i=1;i<=7;i++) {
			Calabash_Brothers one=new Calabash_Brothers(i);
			ans.add(one);
		}
	}
	public void create_start() {
		boolean[] visited=new boolean[8] ;
		for(int i=0;i<8;i++) {
			visited[i]=false;
		}
		Random rand =new Random();
		int index=0;
		while(index<7) {
			int temp=rand.nextInt(7)+1;
			if(!visited[temp]) {
				Calabash_Brothers one=new Calabash_Brothers(temp);
				start.add(one);
				visited[temp]=true;
				index++;
			}
		}
	}
	@Test
	public void testSort() {		
		create_ans();
		create_start();
		
		new Choreography().sort(start);
		assertEquals(true,if_equal(start,ans));
	}
	

}
