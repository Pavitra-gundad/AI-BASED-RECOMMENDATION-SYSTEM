<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>Mention your Group Id here</groupId>
  <artifactId>Mention your Artifact Id here</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>Mention the name of the Project</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <dependencies>
  <dependency>
    <groupId>org.apache.mahout</groupId>
    <artifactId>mahout-mr</artifactId>
    <version>0.10.0</version>
  </dependency>

    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.CityBlockSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;

public class ManhattenDistanceSimilarityExample {

	public static void main(String[] args) {
	try {
		DataModel model = new FileDataModel(new File("D:\\DataScienceCollection\\mahout\\MDist1.csv"));
		CityBlockSimilarity similarity = new CityBlockSimilarity(model);
		UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1,similarity, model);
		UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		  
     		// The First argument is the userID and the Second parameter is 'HOW MANY'
      		List<RecommendedItem> recommendations = recommender.recommend(2, 2);      
			
     		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}
		} catch (Exception e) {
			System.out.println("Exception occured !");
		}

	}

}
