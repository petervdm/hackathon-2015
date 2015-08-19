package hackathon.twitter

import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Date

import twitter4j.{Query, TwitterFactory}

import scala.collection.JavaConversions._
import scala.util.{Failure, Success, Try}

case class TweetInfo(createdOn: Date, user: String, tweet: String)

object HistoricalTweets {

  def main(args: Array[String]) {
    new HistoricalFetcherFetcher().fetchOldTweets("DVLA")
  }

}

class HistoricalFetcherFetcher extends HttpHelpers {

  def fetchOldTweets(search: String): Unit = {

    val twitter = new TwitterFactory(Util.config).getInstance

    val query = new Query(search)
    query.setSince("2015-06-01")

    var results = twitter.search(query)

    while(results.hasNext) {
      results = twitter.search(results.nextQuery)
      val tweets = results.getTweets
      tweets.foreach(x =>
        {

          val format = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss")
          val createdAd = format.format(x.getCreatedAt)

          val t = "{\"createdOn\":\"" + createdAd +
            "\",\"user\":\"" + x.getUser.getName +
            "\",\"tweet\":\"" + x.getText.replaceAll("\"" , "\\\\\"") + "\"}"

//          println(t)
          post("http://localhost:8010/enrich",  t)

//          Try(post("http://localhost/enricher", x.toString) _) match {
//            case Success(s) =>
//            case Failure(f) =>
//              println(f.getMessage)
//          }
//          println(x.getCreatedAt + " " + x.getLang + " " + x.getText)
        })
    }

  }
}

