/*
 * @Author: zb-nju
 * @Date: 2020-09-26 14:29:56
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-09-27 00:04:56
 */

package Human;

public class Grandpa{
    public boolean cmp(CalabashBoy a,CalabashBoy b){
        return a.getID()>b.getID();
    }

    public void swap(CalabashBoy[] calabashBoys,int i,int j){
        CalabashBoy t = calabashBoys[i];
        calabashBoys[i] = calabashBoys[j];
        calabashBoys[j] = t;
    }

    public void sort(CalabashBoy[] calabashBoys){
        for(int i=calabashBoys.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(cmp(calabashBoys[j], calabashBoys[j+1])){
                    swap(calabashBoys,j,j+1);
                    System.out.println(calabashBoys[j].getName()
                                    + "和"
                                    + calabashBoys[j+1].getName()
                                    + "换了位置"
                    );
                }
            }
        }
    }
}