# 7-Collections作业说明  

## Calabash_Brothers.java  
葫芦娃具有姓名和性别两个属性，以及返回和输出姓名，性别的函数；  
private String name;  
private boolean gender;//0-female 1-male  

## Calabash_Brothers_Collection.java  
葫芦娃的集合框架的容器类，包含葫芦娃队列，以及随机生成长度为5的葫芦娃家族，按性别分为两个队列，按三种顺序进行排序，输出排序结果等函数   
ArrayList<Calabash_Brothers> collection=new ArrayList<>();//利用collection对葫芦娃集合进行存储  
Random_Calabash_Brothers(int num)；//随机生成长度为5的葫芦娃家族  
get_two_part(ArrayList<Calabash_Brothers> male_co,ArrayList<Calabash_Brothers> female_co)；//按性别分组   
output(ArrayList<Calabash_Brothers> one)；//输出队列内容  
sort(ArrayList<Calabash_Brothers> one,int index) //0-正序 1-倒序 2-乱序 三种排序方法  

## Calabash_Brothers_Comparator.java    
利用Comparator接口实现了顺序和逆序两种排序方法；  
class Asc_Comparator implements Comparator<Calabash_Brothers>；//顺序  
class Des_Comparator implements Comparator<Calabash_Brothers>；//逆序  

## Main.java  
创建随机葫芦娃初始队列并输出；   
按三种顺序进行排序，并输出结果；  
将原始队列collection按性别分为male_co，female_co两部分，并分别排序输出结果；  
