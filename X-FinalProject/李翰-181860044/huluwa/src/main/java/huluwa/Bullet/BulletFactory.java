package huluwa.Bullet;

public class BulletFactory {
    public Bullet getShape(String bulletType){
        if(bulletType == null){
           return null;
        }        
        if(bulletType.equalsIgnoreCase("One")){
           return new BulletOne();
        } else if(bulletType.equalsIgnoreCase("Two")){
           return new BulletTwo();
        } 
        return null;
     }
}
