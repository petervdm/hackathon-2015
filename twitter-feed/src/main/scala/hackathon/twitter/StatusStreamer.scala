package hackathon.twitter

import twitter4j._

object StatusStreamer {

  def main(args: Array[String]) {
    val twitterStream = new TwitterStreamFactory(Util.config).getInstance
    twitterStream.addListener(Util.simpleStatusListener)
    twitterStream.filter(new FilterQuery().track("Madison"))
    Thread.sleep(100000)
    twitterStream.cleanUp()
    twitterStream.shutdown()
  }
}
