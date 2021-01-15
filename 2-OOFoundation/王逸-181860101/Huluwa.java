package com.company;

public class Huluwa {
    String name;
    int status;
    int pos;
    public void setHuluwa(String a,int b,int c){
        this.name = a;
        this.status = b;
        this.pos = c;
    }
    public boolean cmp(Huluwa a){
        if(status > a.status)
            if(pos < a.pos)
                return true;
        if(status < a.status)
            if(pos > a.pos)
                return true;
        return false;
    }
    public void exchangeAll(Huluwa a){
        int tmp;
        tmp = a.status;
        a.status = status;
        status = tmp;
        String temp = a.name;
        a.name = name;
        name = temp;
    }
    public void exchangePos(Huluwa a) {
        int tmp = a.pos;
        a.pos = pos;
        pos = tmp;
    }
    public void findMyPos(Huluwa a[]){
        int proPos = 0;
        for(int i=0;i<a.length;i++){
            if(a[i].status < status) proPos++;
        }
        if(pos == proPos) return;
        for(int i=0;i<a.length;i++)
            if(a[i].pos == proPos) {
                exchangeAll(a[i]);
                break;
            }
    }
}
