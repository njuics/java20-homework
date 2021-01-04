package io;

import control.Action;
import control.KeyboardAction;
import control.MouseAction;
import control.SkillAction;
import javafx.scene.input.KeyCode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecordReader {
    public static List<Action> read(File file){
        try {
            List<Action> actions = new ArrayList<>();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);

            NodeList actionNodeList = document.getDocumentElement().getElementsByTagName("action");

            for(int i=0;i<actionNodeList.getLength();i++){
                Element action = (Element) actionNodeList.item(i);

                long time = Long.valueOf(action.getElementsByTagName("time").item(0).getTextContent());
                String type = action.getElementsByTagName("type").item(0).getTextContent();

                switch (type){
                    case "MOUSE":
                        int x = Integer.valueOf(action.getElementsByTagName("x").item(0).getTextContent());
                        int y = Integer.valueOf(action.getElementsByTagName("y").item(0).getTextContent());
                        actions.add(new MouseAction(time,x,y));
                        break;
                    case "KEYBOARD":
                        String code = action.getElementsByTagName("keycode").item(0).getTextContent();
                        actions.add(new KeyboardAction(time, KeyCode.valueOf(code)));
                        break;
                    case "SKILL":
                        actions.add(new SkillAction(time));
                        break;
                }
            }
            return actions;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//        List<Action> actions = read("");
//        for(Action action:actions){
//            if(action instanceof MouseAction){
//                System.out.println(((MouseAction) action).getX()+" "+((MouseAction) action).getY());
//            }else if(action instanceof KeyboardAction){
//                System.out.println(((KeyboardAction) action).getCode().getName());
//            }
//        }
//    }
}
