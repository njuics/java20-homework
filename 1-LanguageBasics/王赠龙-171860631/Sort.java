import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.io.File;

public class Sort {
    public static void BubbleSort(int[]data){
        int i, j, temp;
        for (j = 0; j < data.length - 1; j++) {
            for (i = 0; i < data.length - 1 - j; i++) {
                if (data[i] > data[i + 1]) {
                    temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                }
            }
        }
        for(i=0;i<data.length-1;i++) System.out.print(data[i]+" ");
        System.out.println(data[data.length-1]);
    }
    public static void main(String args[]) throws Exception{
        int []data={0,-1,-9,5,66,24,12,38};
        BubbleSort(data);
    }
}
