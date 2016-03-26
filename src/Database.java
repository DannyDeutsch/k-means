import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Database
{
	public List<List<Integer>> data;


	public Database(String fName) throws Exception
	{
		data = new ArrayList<List<Integer>>();


		FileInputStream fin = new FileInputStream(fName);
        InputStreamReader istream = new InputStreamReader(fin);
        BufferedReader stdin = new BufferedReader(istream);


        // Populate 'data' List with each record
        String line;
        while ((line = stdin.readLine()) != null)
        {
            List<Integer> record = new ArrayList<Integer>();
            String[] temp = line.split("\\s+");

            for (String attrVal : temp) record.add(Integer.parseInt(attrVal));

            if (record.isEmpty()) continue;

            data.add(record);
        }


        // Close input stream readers
        fin.close();
        istream.close();
        stdin.close();
	}
}