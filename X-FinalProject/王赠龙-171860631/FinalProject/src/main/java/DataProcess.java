import java.io.*;

public class DataProcess {
    public static void main(String[] args) throws  Exception {
        String path = "D:\\rfidoutput";
        File dir = new File(path);
        if (dir != null) {
            if (dir.isDirectory()) {
                System.out.println("get files success");
                try {
                    File outFile=new File(path+"\\vertical-result.csv");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
                    File[] files = dir.listFiles();
                    for (File file : files) {
                        String fileName=file.getName();
                        /*System.out.println(fileName);
                        String fileNameNum=fileName.split("[-.]")[1];
                        System.out.println(fileNameNum);*/
                        if(fileName.startsWith("vertical")){
                            BufferedReader reader = new BufferedReader(new FileReader(file));
                            String inString;
                            double rssi=0;
                            double phase=0;
                            int lineNum=0;
                            while((inString=reader.readLine())!=null){
                                lineNum++;
                                String []items=inString.split(",");
                                rssi+=Double.parseDouble(items[1]);
                                phase+=Double.parseDouble(items[2]);
                            }
                            String fileNameNum=fileName.split("[-.]")[1];
                            writer.write(fileNameNum+","+rssi/lineNum+","+phase/lineNum);
                            writer.newLine();
                            reader.close();
                        }
                    }
                    writer.close();
                }
                catch (FileNotFoundException ex) {
                    System.out.println("没找到文件！");
                } catch (IOException ex) {
                    System.out.println("读写文件出错！");
                }
            } else {
                System.out.println("not directory");
            }
        }
        else{
            System.out.println("path error");
        }
    }
}
