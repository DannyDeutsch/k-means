import java.util.List;
import java.util.ArrayList;


public class KMeans
{
	private Database db;	//input database
	private int k;			//number of clusters

	public KMeans(Database db, int k) {
		this.db = db;
		this.k = k;
	}


	public List<Cluster> runKMeans()
	{
		// Create k clusters, each with a random centroid
		List<Cluster> clusters = new ArrayList<Cluster>();
		List<Integer> centroids = new ArrayList<Integer>();
		int dimensions = db.data.get(0).size();


		/*for (int i=0; i<k; i++)
		{
			clusters.add(new Cluster());

			centroids.add(
				clusters.get(i).centroid = i 	//TODO: random centroid
			);
		}*/



		// Exit loop once no more re-assigments are necessary
		/*while (true)
		{
			// Re-assign each record to cluster with nearest centroid
			for (List<Integer> record : db.data) {

			}

			// Update centroid location to be mean point of cluster
			for (Cluster c : clusters) c.centroid = calcMean(c);
		}*/


		return clusters;
	}


	/* Calculates mean point of a given cluster */
	private int calcMean(Cluster c)
	{
		return 0;
	}


	/* Calculates Euclidean distance between 2 points */
	private double calcEuclidDist(List<Integer> p, List<Integer> q, int dimensions)
	{
		double distance = 0;

		for (int i=0; i<dimensions; i++) {
			distance += Math.pow(p.get(i)-q.get(i), 2);
		}

		return Math.sqrt(distance);
	}

}
