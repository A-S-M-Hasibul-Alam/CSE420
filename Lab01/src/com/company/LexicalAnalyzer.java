package com.company;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.LinkedHashSet;
import java.util.Set;


public class LexicalAnalyzer {

    String kW="if|else|int|float|double|boolean|char|String|else if|for|while|break|continue";
    String id="[A-Za-z][A-Za-z0-9_]*";
    String mO="\\+|-|\\*|/|=";
    String lO=">|<|=>|==|=<";
    String nV="[-+]?[0-9]*\\.?[0-9]+";
    String ot=".*[{|}|;|,|/(|/)].*";

    Set<String> keyWords=new HashSet<String>();
    Set<String> identifiers=new HashSet<String>();
    Set<String> mathOperators=new HashSet<String>();
    Set<String> logicalOperators=new HashSet<String>();
    Set<String> numericalValues=new HashSet<String>();
    Set<String> others=new HashSet<String>();

    public void Analyze(){
        try
        {

            File InputFile= new File("F:\\Programming\\420\\Lab01\\src\\com\\company\\input.txt");
            Scanner sc=new Scanner(InputFile);

            String str0="";
            while(sc.hasNextLine())
            {

                String st0="";
                st0+=sc.nextLine();
                String arr0[]=st0.split("");

                for(int i=0;i<arr0.length;i++)
                {
                    String tn0=""+arr0[i];

                    if(tn0.matches(mO))
                    {
                        mathOperators.add(tn0);
                        str0+=" ";
                    }

                    else if(tn0.equals("\t"))
                        str0+="";

                    else if(tn0.matches(lO))
                    {
                        logicalOperators.add(tn0);
                        str0+=" ";
                    }

                    else if(tn0.matches(ot))
                    {
                        others.add(tn0);
                        str0+=" ";
                    }

                    else
                        str0+=tn0;

                }
            }

            String arr1[]=str0.split(" ");
            for(int i=0;i<arr1.length;i++)
            {
                String tn1=arr1[i];

                if(tn1.matches(kW))
                    keyWords.add(tn1);


                else if(tn1.matches(nV))
                    numericalValues.add(tn1);

                else if(tn1.matches(id))
                    identifiers.add(tn1);

            }

            System.out.print("Keywords:");
            System.out.println(keyWords.toString());

            System.out.print("Identifiers:");
            System.out.println(identifiers.toString());

            System.out.print("Math Operators:");
            System.out.println(mathOperators.toString());

            System.out.print("Logical Operators:");
            System.out.println(logicalOperators.toString());

            System.out.print("Numerical Values:");
            System.out.println(numericalValues.toString());

            System.out.print("Others:");
            System.out.println(others.toString());
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}


