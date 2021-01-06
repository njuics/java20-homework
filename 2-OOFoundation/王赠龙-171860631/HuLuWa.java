class HuLuWa{
    private int rank=0;//表示葫芦娃的排行，1表示老大，2表示老二，以此类推
    private int position=-1;//表示葫芦娃在当前队列中的位置
    HuLuWa(int tempRank){
        rank=tempRank;
    }
    public void setPosition(int tempPosition){
        position=tempPosition;
    }
    public int getPosition(){
        return position;
    }
    public void swap(HuLuWa tempHuLu){//与tempHuLu交换位置
        int tempPosition1=getPosition();
        int tempPosition2=tempHuLu.getPosition();
        setPosition(tempPosition2);
        tempHuLu.setPosition(tempPosition1);
    }
}
