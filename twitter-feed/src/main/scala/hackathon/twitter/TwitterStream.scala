package hackathon.twitter

import twitter4j._

object Util {

  val config = new twitter4j.conf.ConfigurationBuilder()
    .setOAuthConsumerKey("yLipAFkUdrBLI1kLZKC54tH33")
    .setOAuthConsumerSecret("OgFyrMPJEnMUwwKHM8UbCf9niWkbIyqQFIKvdDTI9mqkoXdAuF")
    .setOAuthAccessToken("18387758-NMm8UGXsGlC2G8UCwFikdFxfRpHAiDMUI2XpuzKyQ")
    .setOAuthAccessTokenSecret("HEapn5wIofjvgS3hQ7VCvmAfhulEl7PDwXhEg2qTD1qiI")
    .build

  def simpleStatusListener = new StatusListener() {
    def onStatus(status: Status) {
      println(status.toString + "\n")
//      println("Text" + status.getText)
//      println(status.getLang)
//      println(status.getCreatedAt)
//      println(status.getGeoLocation.toString)
//      println(status.getRetweetCount)
//      println(status.getGeoLocation.toString)
//      println("\n")
    }

    def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) {}
    def onTrackLimitationNotice(numberOfLimitedStatuses: Int) {}
    def onException(ex: Exception) { ex.printStackTrace }
    def onScrubGeo(arg0: Long, arg1: Long) {}
    def onStallWarning(warning: StallWarning) {}
  }
}
