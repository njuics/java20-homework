package nattyfox;
import java.util.Random;
class sortByChoreography {
    Huluwa huluwa[] =new Huluwa[7];
    
    
    public void randInitial(){
        boolean used[]=new boolean[7];
        for(int i=0;i<7;i++)used[i]=false;
        for(int i = 0;i < 7; i++){
            huluwa[i] = new Huluwa();
        }
        Random r=new Random();
        int count=0;
        
        while(count<7){
            int pos=r.nextInt(7);
           
            if(!used[pos]){
                used[pos]=true;
                huluwa[pos].setPos(pos);
                //System.out.print(pos + " ");
                huluwa[pos].setRank(count);
                huluwa[pos].setName();
                count++;
            }
        }
        for(int i = 0 ;i < 7; i++){
            huluwa[i].countOff();
        }
        System.out.println();  
            
          
    }
    public void sort_By_Choreography(){
        for(int i = 0; i < 7; i++){
            //int index = i;
            for(int j = 0; j < 7 - 1 - i; j++){
               
                if(huluwa[j].getRank() > huluwa[j + 1].getRank()) huluwa[j].exchangePosition(huluwa[j + 1]);
            }
           
        }
        //System.out.println();
        for(int i = 0; i < 7; i++){
           huluwa[i].countOff();
        }
        System.out.println();
    }
    
}
