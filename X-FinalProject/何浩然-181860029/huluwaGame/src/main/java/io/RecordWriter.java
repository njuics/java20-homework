package io;

import control.Action;
import control.KeyboardAction;
import control.MouseAction;
import control.SkillAction;
import javafx.scene.input.KeyCode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.time.Instant;
import java.util.List;

public class RecordWriter {
    public static void write(List<Action> actions){
        try {
            String fileName = Instant.now().toString()+".xml";
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = document.createElement("game");
            for(Action action:actions){
                Element actionEle = document.createElement("action");

                Element time = document.createElement("time");
                time.appendChild(document.createTextNode(String.valueOf(action.getTime())));
                actionEle.appendChild(time);

                Element type = document.createElement("type");
                type.appendChild(document.createTextNode(action.getType()));
                actionEle.appendChild(type);

                if(action instanceof KeyboardAction){
                    Element keycode = document.createElement("keycode");
                    keycode.appendChild(document.createTextNode(((KeyboardAction) action).getCode().getName()));
                    actionEle.appendChild(keycode);
                }else if(action instanceof MouseAction){
                    Element x = document.createElement("x");
                    x.appendChild(document.createTextNode(String.valueOf(((MouseAction) action).getX())));
                    actionEle.appendChild(x);

                    Element y = document.createElement("y");
                    y.appendChild(document.createTextNode(String.valueOf(((MouseAction) action).getY())));
                    actionEle.appendChild(y);
                }else if(action instanceof SkillAction){
                    //Do noting
                }

                root.appendChild(actionEle);
            }
            document.appendChild(root);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            transformer.setOutputProperty(OutputKeys.METHOD,"xml");
            transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");

            transformer.transform(new DOMSource(document),new StreamResult((new FileOutputStream(fileName))));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
