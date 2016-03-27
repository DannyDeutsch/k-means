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
		HashMap<Double, List<Double>> hm = new HashMap<Double, List<Double>>();    //associates distance to centroid
		Set<List<Double>> centroids = new LinkedHashSet<List<Double>>();    //set of current centroids

		int dimensions = db.data.get(0).size();
		double distance;


		// Assigns random records to be initial centroids
		Random rand = new Random();
		int randIdx;

		while (centroids.size() < k) {
			randIdx = rand.nextInt(db.data.size());
			centroids.add( db.data.get(randIdx) );    //retrieves record from random index
		}

		System.out.println("Centroids: " + centroids + "\n");

		for (List<Double> centroid : centroids) {
			clusters.add(new Cluster(centroid));
		}


		// Exit loop once no more re-assigments are necessary
		// while (/* assignments are not yet stable */)
		List<Double> closestCentroid;
		for (int i = 0; i < 1; i++)
		{
			// Re-assign each record to cluster with nearest centroid
			for (List<Double> record : db.data) {
				for (List<Double> centroid : centroids) {
					distance = calcEuclidDist(record, centroid, dimensions);
					hm.put(distance, centroid);
					pq.add(distance);
				}

				closestCentroid = hm.get(pq.peek());    //closest centroid
				
				System.out.println("Record " + record + " is closest to centroid " + closestCentroid);


				// Add record to Cluster identified by 'centroid'
				for (Cluster c : clusters) {
					if (c.centroid == closestCentroid) {
						c.addToCluster(record);
						break;
					}
				}


				// Clear data
				hm.clear();
				pq.clear();
			}

			for (Cluster cluster : clusters) {
				System.out.println("\nCentroid: " + cluster.centroid);
				System.out.println("Records: " + cluster.records);
			}


			// Update centroid location to be mean point of cluster
			for (Cluster c : clusters) {
				c.centroid = calcMean(c.records, dimensions);
				centroids.add(c.centroid);
			}

			for (Cluster c : clusters) {
				System.out.print("\nNew centroid: " + c.centroid);
			}
		}


		return clusters;
	}


	/* Calculates mean point of a given cluster */
	private List<Double> calcMean(List<List<Double>> records, int dimensions)
	{
		// TODO: If no records were assigned to centroid
		if (records.isEmpty()) {
			return null;
		}

		List<Double> mean = new ArrayList<Double>();
		int sum = 0;

		for (int i = 0; i < dimensions; i++) {
			for (List<Double> record : records) {    //add all values in column
				sum += record.get(i);
			}

			mean.add( (double) sum/records.size() );
			sum = 0;
		}

		return mean;
	}


	/* Calculates Euclidean distance between 2 points */
	private double calcEuclidDist(List<Double> p, List<Double> q, int dimensions)
	{
		double distance = 0;

		for (int i = 0; i < dimensions; i++) {
			distance += Math.pow(p.get(i)-q.get(i), 2);
		}

		return Math.sqrt(distance);
	}

}
