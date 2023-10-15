import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.omg.CORBA.Any;
import org.omg.CORBA.Object;
import org.omg.CORBA.TypeCode;
public class BinReader {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int primary = 84, secondary = 72,other = 8,distance = 5000;
		System.out.println("Data Fetching");

		InputStream is = null;
		try {
		    is = new FileInputStream("/home/gaurav/Desktop/DATA_2_18.12.2015_20.32.34.bin");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    DataOutputStream dos = new DataOutputStream(baos);
	    
	    byte dataArray[] = new byte[(primary+secondary+other)*distance];
	    byte[] data = new byte[distance];
		try {
			int count = is.read(data);
			System.out.println(count);
		int itr = primary +secondary +other;
		while(itr > 0)
		{
				dos.write(data, 0, count);
				count = is.read(data);
				itr--;
	    }
		dataArray = baos.toByteArray();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//System.out.println(dataArray.length);
		int k =0;
		int finalDataArray[][] =new int[primary+secondary+other][distance];
	    for(int i =0;i< primary+secondary+other; i++)
	    {
	    	for(int j = 0; j < distance; j++)
	    	{
	    		finalDataArray[i][j] = dataArray[k];
	    		k++;
	    	}
	    }
	    for(int i =0;i< primary+secondary+other; i++)
	    {
	    	for(int j = 0; j < distance; j++)
	    	{
	    		System.out.println(finalDataArray[i][j]);
	    	}
	    }
			
	}
}
