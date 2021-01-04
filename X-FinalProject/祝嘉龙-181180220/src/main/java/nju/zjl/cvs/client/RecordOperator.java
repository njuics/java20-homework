package nju.zjl.cvs.client;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import nju.zjl.cvs.game.Operation;
import nju.zjl.cvs.game.Operator;

public class RecordOperator implements Operator{
    @Override
    public Operation[] getLogicFrames(int logicFrame){
        return operationList.get(logicFrame);
    }

    public boolean readRecord(File record){
        try(
            FileInputStream fin = new FileInputStream(record);
            ObjectInputStream objin = new ObjectInputStream(new BufferedInputStream(fin));
        ){
            int size = objin.readInt();
            operationList = new ArrayList<>(size);
            for(int i = 0; i < size; i++){
                Object obj = objin.readObject();
                if(obj instanceof Operation[]){
                    operationList.add((Operation[])obj);
                }
                else{
                    return false;
                }
            }
            return true;
        }catch(IOException | ClassNotFoundException exception){
            exception.printStackTrace();
            return false;
        }
    }

    protected ArrayList<Operation[]> operationList;
}
