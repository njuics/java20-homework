package nju.zjl.cvs.game;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class OperationTest {
    @Test
    public void OperationTest1() throws Exception{
        Operation op = new Operation(3, Instruction.newAttackInst(7));
        try(
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bout)
        ){
            out.writeObject(op);
            out.flush();
            try(ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()))){
                Operation op2 = (Operation)in.readObject();
                assertEquals(op.executor, op2.executor);
                assertEquals(op.inst.action, op2.inst.action);
                assertEquals(op.inst.target, op2.inst.target);
            }
        }
    }
}
