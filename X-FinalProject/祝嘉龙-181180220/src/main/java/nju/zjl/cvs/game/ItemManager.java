package nju.zjl.cvs.game;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.IntStream;

public class ItemManager {
    public Creature getCreatureByPos(int pos){
        return ctPosMap.get(pos);
    }

    public Creature getCreatureById(int id){
        return ctIdMap.get(id);    
    }

    public int[] getIntCreatureMap(){
        return IntStream.range(0, Constants.ROWS * Constants.COLUMNS).
                map(i -> ctPosMap.containsKey(i) ? 1 : 0).
                toArray();
    }

    public void addCreature(Creature ct){
        int pos = ct.getPos();
        checkArgument(!ctPosMap.containsKey(pos), "pos %s already has a creature but tried to add another to here", pos);
        ctIdMap.put(ct.getId(), ct);
        ctPosMap.put(pos, ct);
    }

    public void moveCreature(int src, int dest){
        checkArgument(ctPosMap.containsKey(src), "pos %s has no creature but tried to move from it", src);
        checkArgument(!ctPosMap.containsKey(dest), "dest %s already has a creature but tried to move to it", dest);
        ctPosMap.put(dest, ctPosMap.remove(src));
    }

    public void removeCreature(int id){
        checkArgument(ctIdMap.containsKey(id), "creature %s is not existed but tried to remove it", id);
        ctPosMap.remove(ctIdMap.get(id).getPos());
        ctIdMap.remove(id);
    }

    public void addAffector(Affector at){
        atQueue.add(at);
    }

    public void removeAffector(Affector at){
        atQueue.remove(at);
    }

    public Creature[] getCreatures(){
        return ctPosMap.values().toArray(new Creature[0]);
    }

    public Affector[] getAffectors(){
        return atQueue.toArray(new Affector[0]);
    }

    public void initDefaultCreatures(){
        Creature.resetIdentifier();

        addCreature(CreatureFactory.getCalabash(0, 0, "orange"));
        addCreature(CreatureFactory.getCalabash(8, 0, "blue"));

        addCreature(CreatureFactory.getCalabash(3, 4, "purple"));
        addCreature(CreatureFactory.getCalabash(5, 4, "yellow"));

        addCreature(CreatureFactory.getCalabash(2, 2, "green"));
        addCreature(CreatureFactory.getCalabash(4, 2, "red"));
        addCreature(CreatureFactory.getCalabash(6, 2, "cyan"));


        addCreature(CreatureFactory.getMonster(0, 11, "snake"));

        addCreature(CreatureFactory.getMonster(4, 7, "scorpion"));

        addCreature(CreatureFactory.getMonster(2, 9, "toad"));
        addCreature(CreatureFactory.getMonster(6, 9, "toad"));

        addCreature(CreatureFactory.getMonster(3, 8, "centipede"));
        addCreature(CreatureFactory.getMonster(5, 8, "centipede"));
    }

    protected Map<Integer, Creature> ctPosMap = new ConcurrentHashMap<>();
    protected Map<Integer, Creature> ctIdMap = new ConcurrentHashMap<>();

    protected Queue<Affector> atQueue = new ConcurrentLinkedQueue<>();
}
