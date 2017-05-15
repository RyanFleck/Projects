/**
 * Created by sahil_saroop on 2016-11-27.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import weka.core.*;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Distance {
    public enum Distances {Euclidean,Manhattan};
    public enum FileType {HARTIGAN,SPAETH};
    DistanceFunction df;

    public Distance()
    {
        //setDistanceFunction(d);
    }

    public String[] getVerticesLabel(String TXTFilePath,FileType f)
    {
        String[] temp=null;
        if(f.equals(FileType.SPAETH))
        {

            try {
                String CSVFilePath=TXTtoCSV.Convert(TXTFilePath,f);
                DataSource source = new DataSource(CSVFilePath);
                Instances data = source.getDataSet();
                temp=new String[data.size()];

                for(Integer i=0;i<data.size();i++) {
                temp[i]=i.toString();
                }
                }
                catch(Exception ex)
                {

                }
        }else if(f.equals(FileType.HARTIGAN))
        {
            try {
                String CSVFilePath=TXTtoCSV.Convert(TXTFilePath,f);

                DataSource source = new DataSource(CSVFilePath);
                Instances data = source.getDataSet();
                temp=new String[data.size()];

                //creating File instance to reference text file in Java
                File texte = new File(TXTFilePath);

                //Creating Scanner instnace to read File in Java
                Scanner scnr = new Scanner(texte);
                //Reading each line of file using Scanner class
                String Line=scnr.nextLine();
                while(scnr.hasNextLine() && (Line.contains("#") && !scnr.hasNextInt())){
                    Line = scnr.nextLine();
                }
                Line = scnr.nextLine();    Line = scnr.nextLine();    Line = scnr.nextLine();
                Integer count=0;
                while(scnr.hasNextLine()){
                    Line = scnr.nextLine();
                    String numbers[]=Line.split("\"");
                    temp[count]=numbers[1];
                    count++;
                }

            }catch(Exception ex){}

        }
        return temp;
    }

    public int[][] getVertices(String TXTFilePath,FileType f)
    {
        int temp[][]=new int[2][];
        try {
            String CSVFilePath=TXTFilePath.replace("txt","csv");
            DataSource source = new DataSource(CSVFilePath);
            Instances data = source.getDataSet();
            temp[0]=new int[(data.size()*(data.size()-1))/2];
            temp[1]=new int[(data.size()*(data.size()-1))/2];
            int count=0;

            for(int i=0;i<data.size()-1;i++)
            {
                for(int j=i+1;j<data.size();j++)
                {
                    //temp[count]=i;
                    //temp[count]=j;
                    temp[0][count]=i;
                    temp[1][count]=j;
                    count++;
                }
            }

        }catch(Exception ex) {

        }
        return temp;
    }
    public double[] ComputeDistance(String TXTFilePath, Distances d)
    {
        double temp[]=null;
        String CSVFilePath=TXTFilePath.replace("txt","csv");
        try {

            DataSource source = new DataSource(CSVFilePath);
            Instances data = source.getDataSet();
            df=setDistanceFunction(d,data);
            if(df==null)
            {
                df=new EuclideanDistance(data);
            }

            temp=new double[(data.size()*(data.size()-1))/2];
            int count=0;
            for(int i=0;i<data.size()-1;i++)
            {
                for(int j=i+1;j<data.size();j++)
                {
                    //temp[count]=i;
                    //temp[count]=j;
                    try {
                        temp[count] = df.distance(data.instance(i), data.instance(j));
                    }catch(NullPointerException ex)
                    {
                        temp[count]=0.0;
                    }
                        count++;
                }
            }
        }catch(Exception ex)
        {

        }
        return temp;
    }

    public DistanceFunction setDistanceFunction(Distances d,Instances data)
    {
        if(d.equals(Distances.Euclidean))
        {
            return new EuclideanDistance(data);
        }
        else if(d.equals(Distances.Manhattan)) {
             return new ManhattanDistance(data);
        }
        return null;
    }
}
