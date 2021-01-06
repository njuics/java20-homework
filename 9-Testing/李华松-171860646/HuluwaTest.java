/**
 * Copyright (C), 2015-2020, XXX有限公司
 * <p>
 * FileName: HuluwaTest
 * <p>
 * Author:   nattyfox
 * <p>
 * Date:     2020/11/15 11:19
 * <p>
 * Description: 葫芦娃测试类
 * <p>
 * History:
 *
 * <author>          <time>          <version>          <desc>
 * <p>
 * 作者姓名           修改时间           版本号              描述
 */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

/**
 * 〈一句话功能简述〉<br>
 * 〈葫芦娃测试类〉
 *
 * @author nattyfox

 * @create 2020/11/15

 * @since 1.0.0

 */

public class HuluwaTest {
    public static void display(HuluwaCollection a){
        Iterator<Huluwa> i = a.iterator();
        while(i.hasNext()){
            Huluwa h = i.next();
            System.out.println(h);
        }
        System.out.println();
    }

    HuluwaCollection r = new HuluwaCollection();
    @After
    public void sortByAscTest(){
        System.out.println("降序排列");
        r.sortByAsc();
        display(r);
    }
    @Before
    public void sortByDesTest() {
        System.out.println("升序排列");
        r.sortByDes();
        display(r);
    }
    @Test(timeout = 50)
    public void sortByGenderTest() throws Exception{
        System.out.println("分性别后升序排列");
        r.sortByGender();
        display(r);
    }
    @After
    public void shuffleTest(){
        System.out.println("乱序排列");
        r.shuffle();
        display(r);
    }
}