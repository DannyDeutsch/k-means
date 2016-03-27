import java.util.*;


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
		PriorityQueue<Double> pq = new PriorityQueue<Double>();    //sorted distances to centroid
		HashMap<Double, List<Integer>> hm = new HashMap<Double, List<Integer>>();    //associates distance to centroid
		Set<List<Integer>> centroids = new LinkedHashSet<List<Integer>>();    //set of current centroids

		int dimensions = db.data.get(0).size();
		double distance;


		// Assigns random records to be initial centroids
		Random rand = new Random();
		int randIdx;

		while (centroids.size() < k) {
			randIdx = rand.nextInt(db.data.size());
			centroids.add( db.data.get(randIdx) );    //retrieves record from random index
		}

		// System.out.println("Centroids: " + centroids + "\n");

		for (List<Integer> centroid : centroids) {
			clusters.add(new Cluster(centroid));
		}


		// Exit loop once no more re-assigments are necessary
		// while (/* assignments are not yet stable */)
		List<Integer> closestCentroid;
		for (int i=0; i<1; i++)
		{
			// Re-assign each record to cluster with nearest centroid
			for (List<Integer> record : db.data) {
				for (List<Integer> centroid : centroids) {
					distance = calcEuclidDist(record, centroid, dimensions);
					hm.put(distance, centroid);
					pq.add(distance);
				}

				closestCentroid = hm.get(pq.peek());    //closest centroid
				
				// System.out.println("Record " + record + " is closest to centroid " + closestCentroid);


				// Add record to Cluster identified by 'centroid'
				for (Cluster cluster : clusters) {
					if (cluster.centroid == closestCentroid) {
						cluster.addToCluster(record);
						break;
					}
				}


				// Clear data
				hm.clear();
				pq.clear();
			}

			// for (Cluster cluster : clusters) {
			// 	System.out.println("Centroid: " + cluster.centroid);
			// 	System.out.println("Records: " + cluster.records + "\n");
			// }


			// Update centroid location to be mean point of cluster
			for (Cluster c : clusters) c.centroid = calcMean(c);
		}


		return clusters;
	}


	/* Calculates mean point of a given cluster */
	private List<Integer> calcMean(Cluster c)
	{
		return null;
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
