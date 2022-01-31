package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
        String returntype[] = {"boolean", "char","double","float", "int","long","short","void","byte"};

        String bracket2[]={"{","}"};
        String bracket21[]={"(",")"};

        String other1[]={"public", "private", "protected"};

        String other2[]={"abstract","final","static","finally"};

        FileReader  input= new FileReader("F:\\Programming\\420\\LAB04\\src\\com\\company\\input.txt");
        BufferedReader br=new BufferedReader(input);

        LinkedList<String> rettyp=new LinkedList<String>();
        LinkedList<String> method=new LinkedList<String>();

        String s = null;
        while(true){
            try {
                if (!((s=br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] split = s.trim().split("\\s+");
            outerloop:
            for(int i=0;i<other1.length;i++){
                if(split[0].equals(other1[i])){
                    for(int j=0;j<other2.length;j++){
                        if(split[1].equals(other2[j])){
                            for(int k=0;k<returntype.length;k++){
                                if(split[2].equals(returntype[k])){
                                    if(!(split[3].equals("main")|| split[3].equals("main(")|| split[3].equals("main(String"))){
                                        if(split[split.length-1].endsWith("{")){
                                            split[split.length-1]=split[split.length-1].replace("{","");
                                        }
                                        String xS="";
                                        for(int x=3;x<split.length;x++){
                                            xS+=" "+split[x];
                                        }
                                        xS=xS.replaceFirst(" ","");
                                        method.add(xS);
                                        rettyp.add(split[2]);
                                    }
                                }
                            }
                        }
                        else{
                            for(int k=0;k<returntype.length;k++){
                                if(split[1].equals(returntype[k])){
                                    if(split[split.length-1].endsWith("{")){
                                        split[split.length-1]=split[split.length-1].replace("{","");
                                    }
                                    String xS="";
                                    for(int x=2;x<split.length;x++){
                                        xS+=" "+split[x];
                                    }
                                    xS=xS.replaceFirst(" ","");
                                    method.add(xS);
                                    rettyp.add(split[1]);
                                    break outerloop;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Methods:");
        Iterator<String> i = method.iterator();
        Iterator<String> r=rettyp.iterator();
        int j = method.size();
        for (int k = 0 ; k < j; k++){
            System.out.println(i.next() + ", return type: "+r.next());
        }

    }
}