import java.util.List;
import java.util.ArrayList;


public class Cluster
{
	public List<Double> centroid;
	public List<List<Double>> records = new ArrayList<List<Double>>();

	// Constructor
	public Cluster(List<Double> centroid) {
		this.centroid = centroid;
	}


	// Add record to Cluster
	public void addToCluster(List<Double> record) {
		records.add(record);
	}

	// Return number of records in Cluster
	public int size() { return records.size(); }
}