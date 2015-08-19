package hackathon.twitter

import scalaj.http.Http

trait HttpHelpers {

  def post(url: String, data: String) = {

    try {
      val response = Http(url).postData(data).header("content-type", "application/json").asString

      if (response.isError) {
        throw new Exception("An error occurred when posting to " + url + " - code: " + response.code)
      }
      else
        println("posted " + data)
    }
    catch {
      case e: Throwable =>
        println(s"Error posting data to " + url + " - " + e.getMessage + " " + e.getStackTrace.toString)
    }

  }

}
