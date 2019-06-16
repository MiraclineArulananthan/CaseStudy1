package Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Main {

	public static void main(String[] args) 
	{	
	List<Employee> records=readFromCSVFile("E:\\us-500\\us-500.csv");
	for(Employee r: records)
	{
		System.out.println(r);
	}	
	System.out.println();
	sortFirstName(records);
	for(Employee r: records)
	{
		System.out.println(r.getFname());
	}
	
	for(Employee r:records)
	{
		if(r.getCity().equals("\"New York\""))
				System.out.println(r.getFname()+" "+r.getLname()+" "+r.getCity());
	}
		}

	
	private static List<Employee> readFromCSVFile(String fileName)
	{
		List<Employee> records=new ArrayList<>();
		try (BufferedReader br =new BufferedReader(new FileReader(fileName))) {
			String line = br.readLine();
			while (line != null) 
			{ 
			String[] name = line.split(",",-1);
	       Employee e=new Employee(name[0],name[1],name[2],name[3],name[4],name[5],name[6],name[7],name[8],name[9],name[10],name[11]);

			records.add(e);
			line=br.readLine();
			}
			br.close();
		} 
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
	    }
return records;
	}
		
    
private static List<Employee> sortFirstName(List<Employee> list)
{
	int i,j;
	 for (i = 1; i < list.size(); i++) 
     {
         for (j = i + 1; j < list.size(); j++) 
         {
             if (list.get(i).getFname().compareTo(list.get(j).getFname())>0) 
             {
            	 Collections.swap(list,i,j);
             }
         }
}
	 return list;
}
}
