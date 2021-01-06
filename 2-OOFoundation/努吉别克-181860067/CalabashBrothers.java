enum COLOR{
    Red,Orange,Yellow,Green,Cyan,Blue,Purple

}

public class CalabashBrothers {
        COLOR color;
        int rank;
        int pos;

        CalabashBrothers()
        {
            color=COLOR.Red;
            rank=-1;
            pos=0;
        }
       public void initial(COLOR color1,int RANK,int orinpos)
        {
            color=color1;
            rank=RANK;
            pos=orinpos;
        }
       public  COLOR report_color()
        {
            return color;
        }
        public void Adjust_pos(int newpos)
        {
            pos=newpos;
        }
        public void receive_pos(int pa_pos,int pa_rank,Ground list_map)
        {
            if(pa_rank==this.pos)
            {
                int tmp_rank=list_map.brother[this.pos].get_rank();
                //int tmp_pos=this.pos;
                list_map.brother[this.pos].rank=list_map.brother[pa_pos].rank;
               // list_map.brother[this.pos].pos=list_map.brother[pa_pos].pos;
               // list_map.brother[pa_pos].pos=tmp_pos;
                list_map.brother[pa_pos].rank=tmp_rank;
            }
        }
        public void send_patner(Ground kid_list)
        {
            int r_patner=(pos+1)%7;
            int l_patner=(pos-1)%7;
            if(l_patner<0)
                l_patner=l_patner+1;
            for(int i=0;i<=l_patner&&pos!=rank;i++)
            kid_list.brother[i].receive_pos(pos,rank,kid_list);

            for(int i=r_patner;i<7&&pos!=rank;i++)
            kid_list.brother[i].receive_pos(pos,rank,kid_list);

        }
        int get_rank()
        {
            return rank;
        }
        int get_pos()
        {
            return pos;
        }

}
