public class Sequence{
    Huluwa red=new Red();
    Huluwa orange=new Orange();
    Huluwa yellow=new Yellow();
    Huluwa green=new Green();
    Huluwa cyan=new Cyan();
    Huluwa blue=new Blue();
    Huluwa purple=new Purple();
    Huluwa[] huluwas=new Huluwa[7];
    Sequence(){
        huluwas[0]=purple;
        huluwas[1]=cyan;
        huluwas[2]=blue;
        huluwas[3]=green;
        huluwas[4]=orange;
        huluwas[5]=yellow;
        huluwas[6]=red;
    }
    public static void main(String[] args) {
        Sequence seq=new Sequence();
        seq.choreography();
        seq.orchestration();
    }
    public void choreography(){
        int min=0;
        while(min<huluwas.length){
            for(int i=min;i<huluwas.length;++i){
                if(huluwas[min].largerThan(huluwas[i])){
                    huluwas[min].changePosition(huluwas, huluwas[i]);
                }
            }
            ++min;
        }
        for(int i=0;i<huluwas.length;++i){
            huluwas[i].call();
        }
    }
    public void orchestration(){
        Grandpa grandpa=new Grandpa();
        grandpa.setChildren(huluwas);
        grandpa.sort(0, 6);
        grandpa.callChildren();
    }
}