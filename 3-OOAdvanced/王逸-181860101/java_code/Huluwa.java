package com.company;

public class Huluwa {
    private String name;
    private int status;
    private int pos;
    Huluwa(){
        name = "NULL";
        status = -1;
        pos = -1;
    }
    Huluwa(String a,int b,int c){
        name = a;
        status = b;
        pos = c;
    }
    public String getName(){
        return name;
    }
    public int getStatus(){
        return status;
    }
    public int getPos(){
        return pos;
    }
    protected void exchangeAll(Huluwa a){
        int tmp;
        tmp = a.status;
        a.status = status;
        status = tmp;
        String temp = a.name;
        a.name = name;
        name = temp;
    }
    protected void exchangePos(Huluwa a) {
        int tmp = a.pos;
        a.pos = pos;
        pos = tmp;
    }

}
class HuluwaSort extends Huluwa{
    HuluwaSort(){
        super();
    }
    HuluwaSort(String a,int b,int c){
        super(a,b,c);
    }
    public boolean cmp(Huluwa a){
        if(a.getStatus() > this.getStatus())
            if(this.getPos() < a.getPos())
                return true;
        if(this.getStatus() < a.getStatus())
            if(this.getPos() > a.getPos())
                return true;
        return false;
    }
    public boolean findMyPos(Huluwa a[]){
        int proPos = 0;
        for(int i=0;i<a.length;i++){
            if(a[i].getStatus() < this.getStatus()) proPos++;
        }
        if(this.getPos() == proPos) return true;
        for(int i=0;i<a.length;i++)
            if(a[i].getPos() == proPos) {
                exchangeAll(a[i]);
                break;
            }
        return false;
    }
    public void sortByHuluwa(HuluwaSort[] myBoy){
        int i = 0;
        while(i < myBoy.length){
            HuluwaSort tmp = new HuluwaSort();
            tmp = myBoy[i];
            if(tmp.findMyPos(myBoy))
                i++;
            //myBoy[i] = tmp;
        }
    }
}