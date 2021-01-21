public class GrandFather {
    void sotr_child(Ground list_map)
    {
        for (int i=0;i<7;i++)
        {
            for (int j=i+1;j<7;j++)
            {
                if(list_map.brother[i].get_rank()>list_map.brother[j].get_rank())
                {
                    int tmp_rank=list_map.brother[i].get_rank();
                    int tmp_pos=i;
                    list_map.brother[i].rank=list_map.brother[j].rank;
                    list_map.brother[i].pos=list_map.brother[j].pos;
                    list_map.brother[j].pos=tmp_pos;
                    list_map.brother[j].rank=tmp_rank;


                }
            }
        }
    }

}
