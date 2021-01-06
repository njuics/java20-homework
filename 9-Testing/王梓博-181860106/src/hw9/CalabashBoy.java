/*
 * @Author: zb-nju
 * @Date: 2020-11-05 11:49:11
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-11-15 12:35:33
 */
package hw9;
import java.util.Random;

interface People{
    public String getName();
    public Gender getGender();
}

public class CalabashBoy implements People, Comparable<CalabashBoy>{
    private String name;
    private Gender gender;

    CalabashBoy(){
        this.name = genName();
        this.gender = genGender();
    }

    public CalabashBoy(String name, Gender gender){
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public Gender getGender() {
        return this.gender;
    }

    @Override
    public int compareTo(CalabashBoy b){
        return this.name.compareTo(b.getName());
    }

    @Override
    public String toString(){
        return this.name+" "+this.gender.toString();
    }

    private String genName(){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        int length=random.nextInt(10) + 5;
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    private Gender genGender(){
        Random random=new Random();
        return random.nextInt(2)==0?Gender.MALE:Gender.FEMALE;
    }
}