package com.tatuas.android.retrofit2sample.structure;

import com.squareup.moshi.Json;

public class Owner {

    @Json(name = "login")
    public String login;

    @Json(name = "id")
    public long id;

    @Json(name = "avatar_url")
    public String avatarUrl;

    @Json(name = "gravatar_id")
    public String gravatarId;

    @Json(name = "url")
    public String url;

    @Json(name = "html_url")
    public String htmlUrl;

    @Json(name = "followers_url")
    public String followersUrl;

    @Json(name = "following_url")
    public String followingUrl;

    @Json(name = "gists_url")
    public String gistsUrl;

    @Json(name = "starred_url")
    public String starredUrl;

    @Json(name = "subscriptions_url")
    public String subscriptionsUrl;

    @Json(name = "organizations_url")
    public String organizationsUrl;

    @Json(name = "repos_url")
    public String reposUrl;

    @Json(name = "events_url")
    public String eventsUrl;

    @Json(name = "received_events_url")
    public String receivedEventsUrl;

    @Json(name = "type")
    public String type;

    @Json(name = "site_admin")
    public boolean siteAdmin;
}

