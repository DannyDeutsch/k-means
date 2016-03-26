import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.LinkedHashSet;


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
		List<Cluster> clusters = new ArrayList<Cluster>();
		Set<List<Integer>> centroids = new LinkedHashSet<List<Integer>>();
		int dimensions = db.data.get(0).size();


		// Assigns random records to be initial centroids
		Random rand = new Random();
		int randIdx;

		while (centroids.size() < k) {
			randIdx = rand.nextInt(db.data.size());
			System.out.println("randIdx = " + randIdx);
			centroids.add( db.data.get(randIdx) );    //retrieves record from random index
		}


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
