public class Brother {
    private int rank;
    private int pos;
    private String name;
    public Brother(String my_name,int my_rank,int my_pos){
        this.name = my_name;
        this.rank = my_rank;
        this.pos = my_pos;
    }
    public String get_name(){
        return this.name;
    }
    public int get_rank(){
        return this.rank;
    }
    public int get_pos(){
        return this.pos;
    }

    //被重新分配位置
    public void set_pos(int position){
        this.pos = position;
    }

    //和兄弟交换位置
    public void exchange(Brother bro){
        int temp = this.pos;
        this.pos = bro.get_pos();
        bro.set_pos(temp);
    }

    public void yell(){
        System.out.print(this.name+' ');
    }

}
