/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

import weka.core.EuclideanDistance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.*;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
/**
 * Created by sahil_saroop on 2016-11-27.
 */
public class TXTtoCSV {

    public static String Convert(String filepath, Distance.FileType f) throws FileNotFoundException, IOException {
        //creating File instance to reference text file in Java
        File texte = new File(filepath);

        //Creating Scanner instnace to read File in Java
        Scanner scnr = new Scanner(texte);
        FileOutputStream fos=new FileOutputStream(filepath.replace("txt","csv"),false);
        OutputStreamWriter ows=new OutputStreamWriter(fos);

        if(f.equals(Distance.FileType.SPAETH))
        {
        //Reading each line of file using Scanner class
        String Line=scnr.nextLine();
        while(scnr.hasNextLine() && (Line.contains("#") && !scnr.hasNextInt())){
            Line = scnr.nextLine();

            //System.out.println(Line);

        }

            ows.write("X,Y\n");
        while(scnr.hasNextLine()){
            Line = scnr.nextLine();
            String numbers[]=Line.split("\\s+");
            for(int i=0;i<numbers.length-1;i++)
            {
                if(numbers[i].equals("")==false)
                {
                    ows.write(numbers[i].replaceAll("\\s+","") + ",");
                }
            }
            ows.write(numbers[numbers.length-1].replaceAll("\\s+","") + "\n");

        }
        }
        else if (f.equals(Distance.FileType.HARTIGAN))
        {
            String Line=scnr.nextLine();
            while(scnr.hasNextLine() && (Line.contains("#") && !scnr.hasNextInt())){
                Line = scnr.nextLine();
            }
            System.out.println("File description:"+Line);
            Line = scnr.nextLine(); 
            Line = scnr.nextLine();
            Integer count=0;
            while(scnr.hasNextLine()){
                Line = scnr.nextLine();
                if(Line.contains("\""))
                {
                    Line=Line.substring(Line.indexOf("\"",1));
                }
                String numbers[]=Line.split("\\s+");

                for(int i=1;i<numbers.length-1;i++)
                {
                    if(numbers[i].equals("")==false)
                    {
                        ows.write(numbers[i].replaceAll("\\s+","") + ",");
                    }
                }
                ows.write(numbers[numbers.length-1].replaceAll("\\s+","") + "\n");

                count++;
            }

        }
        ows.close();
        return filepath.replace("txt","csv");
    }
}

