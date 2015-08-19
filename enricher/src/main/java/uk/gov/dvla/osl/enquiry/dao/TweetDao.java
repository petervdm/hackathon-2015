package uk.gov.dvla.osl.enquiry.dao;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface TweetDao {

    @SqlUpdate("insert into tweets (tweettime, user, tweet, sent) values (:tweettime, :user, :tweet, :sent)")
    void insert(@Bind("tweettime") String tweetTime, @Bind("user") String name, @Bind("tweet") String tweet, @Bind("sent") String sentiment);

}

