package gameplay;
/**
 * This class used to get tweeter information by using tweeter api
 */

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Mobile extends Valuables {
	private Twitter twitter;

	public Mobile(String description, int number) {//the constructor of mobile,which return the confidence and description
		super(description, number);
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(" ")
				.setOAuthConsumerSecret(" ")
				.setOAuthAccessToken(" ")
				.setOAuthAccessTokenSecret(" ");

		TwitterFactory tf = new TwitterFactory(cb.build());
		this.twitter = tf.getInstance();
	}

	public String showLatestTweetFrom(String user) {
		try {
			return twitter.showUser(user).getStatus().getText();
		} catch (TwitterException e) {
			e.printStackTrace();
			return "";
		}
	}

	// public static void main(String[] args) {   main class if we want this to get information indivisionly

	// Mobile m = new Mobile(description);
	// String result = m.showLatestTweetFrom("realDonaldTrump");
	// System.out.println(result);
	// }
}
