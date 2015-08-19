package hackathon.twitter

import twitter4j._

object Util {

  val config = new twitter4j.conf.ConfigurationBuilder()
    .setOAuthConsumerKey("GgwTEwaAT9oru78lp6TvLgSt3")
    .setOAuthConsumerSecret("kKn0dQ3u8y4Epd8a8pBYubPnLmSBVFTvNGbR4A4LzP76RceSTp")
    .setOAuthAccessToken("3431134343-dFPkB9f5viyMXjF5KnXiMjCn1ETcDdDXjFDorOK")
    .setOAuthAccessTokenSecret("bVdX2KwM4PRt5DlN5j8ot6rlLkl3xHpvZjjaLPVmAtpuX")
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
