package controllers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehose;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehoseClient;
import com.amazonaws.services.kinesisfirehose.model.PutRecordRequest;
import com.amazonaws.services.kinesisfirehose.model.PutRecordResult;
import com.amazonaws.services.kinesisfirehose.model.Record;
import org.codehaus.jettison.json.JSONObject;

@RestController
@RequestMapping("/api/v1")
public class HomeController {
	@Value("${aws.auth.accessKey}")
	private String awsAccessKey;
	@Value("${aws.auth.secretKey}")
	private String awsSecretKey;

  @GetMapping("/home")
  public void greeting() {
    System.out.println("Hello world");
  }
  
  @GetMapping("/post/values")
  public void postDataToKinesisTool() {
	  BasicAWSCredentials awsCredentials = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
	  AmazonKinesisFirehose firehoseClient = AmazonKinesisFirehoseClient.builder()
	          .withRegion(Regions.US_WEST_2)
	          .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
	          .build();
  }
}