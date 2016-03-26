import java.util.List;
import java.util.ArrayList;


public class Cluster
{
	public List<List<Integer>> records = new ArrayList<List<Integer>>();
	public int centroid;	//TODO: type correct?

	// Constructor
	public Cluster() { }


	// Add record to Cluster
	public void addToCluster(List<Integer> record) {
		records.add(record);
	}

	// Return number of records in Cluster
	public int size() { return records.size(); }
}