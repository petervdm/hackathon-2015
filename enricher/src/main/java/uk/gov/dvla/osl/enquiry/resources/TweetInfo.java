package uk.gov.dvla.osl.enquiry.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class TweetInfo {

    @NotNull
    @JsonProperty
    private String createdOn;

    @NotNull
    @JsonProperty
    private String user;

    @NotNull
    @JsonProperty
    private String tweet;

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}
