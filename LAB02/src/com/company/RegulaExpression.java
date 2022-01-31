package com.company;
import java.util.*;
import java.io.File;
public class RegulaExpression {
    public void Start(){
        try{
            File f = new File("F:\\Programming\\420\\LAB02\\src\\com\\company\\input.txt");
            Scanner sc = new Scanner(f);
            int inputSize = sc.nextInt();
            for(int i=1; i<=inputSize; i++){
                String line = sc.next();
                if(line.contains("@")){
                    System.out.println(checkvalidmail(line)+", "+(i));
                }
                else{
                    System.out.println(checkvalidweb(line)+", "+(i));
                }
            }
            sc.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public String checkvalidmail(String s){
        String result = "Email";
        if(Character.isDigit(s.charAt(0))){
            result = "Invalid";
        }
        if(!(s.endsWith(".com") || s.endsWith(".ac.bd"))){
            result = "Invalid";
        }
        String[] lineArray = s.split("@", 2);
        if(lineArray[1].contains("@")){
            result = "Invalid";
        }
        return result;
    }
    public String checkvalidweb(String w){
        String result = "Web";
        if(!(w.startsWith("www.") || w.startsWith("https://www.") || w.startsWith("WWW.") || w.startsWith("HTTPS://WWW."))){
            result  = "Invalid";
        }
        if(!w.contains(".com") || w.contains(".COM")){
            result  = "Invalid";
        }
        String[] lineArray = w.split("www.", 2);
        if(lineArray[1].contains("@")){
            result = "Invalid";
        }
        return result;
    }
}