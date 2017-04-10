package com.tatuas.android.retrofit2sample.structure;

import com.squareup.moshi.Json;

public class Repo {

    @Json(name = "id")
    public long id;

    @Json(name = "name")
    public String name;

    @Json(name = "full_name")
    public String fullName;

    @Json(name = "owner")
    public Owner owner;

    @Json(name = "public")
    public boolean isPrivate;

    @Json(name = "html_url")
    public String htmlUrl;

    @Json(name = "description")
    public String description;

    @Json(name = "fork")
    public boolean fork;

    @Json(name = "url")
    public String url;

    @Json(name = "forks_url")
    public String forksUrl;

    @Json(name = "keys_url")
    public String keysUrl;

    @Json(name = "collaborators_url")
    public String collaboratorsUrl;

    @Json(name = "teams_url")
    public String teamsUrl;

    @Json(name = "hooks_url")
    public String hooksUrl;

    @Json(name = "issue_events_url")
    public String issueEventsUrl;

    @Json(name = "events_url")
    public String eventsUrl;

    @Json(name = "assignees_url")
    public String assigneesUrl;

    @Json(name = "branches_url")
    public String branchesUrl;

    @Json(name = "tags_url")
    public String tagsUrl;

    @Json(name = "blobs_url")
    public String blobsUrl;

    @Json(name = "git_tags_url")
    public String gitTagsUrl;

    @Json(name = "git_refs_url")
    public String gitRefsUrl;

    @Json(name = "trees_url")
    public String treesUrl;

    @Json(name = "statuses_url")
    public String statusesUrl;

    @Json(name = "languages_url")
    public String languagesUrl;

    @Json(name = "stargazers_url")
    public String stargazersUrl;

    @Json(name = "contributors_url")
    public String contributorsUrl;

    @Json(name = "subscribers_url")
    public String subscribersUrl;

    @Json(name = "subscription_url")
    public String subscriptionUrl;

    @Json(name = "commits_url")
    public String commitsUrl;

    @Json(name = "git_commits_url")
    public String gitCommitsUrl;

    @Json(name = "comments_url")
    public String commentsUrl;

    @Json(name = "issue_comment_url")
    public String issueCommentUrl;

    @Json(name = "contents_url")
    public String contentsUrl;

    @Json(name = "compare_url")
    public String compareUrl;

    @Json(name = "merges_url")
    public String mergesUrl;

    @Json(name = "archive_url")
    public String archiveUrl;

    @Json(name = "downloads_url")
    public String downloadsUrl;

    @Json(name = "issues_url")
    public String issuesUrl;

    @Json(name = "pulls_url")
    public String pullsUrl;

    @Json(name = "milestones_url")
    public String milestonesUrl;

    @Json(name = "notifications_url")
    public String notificationsUrl;

    @Json(name = "labels_url")
    public String labelsUrl;

    @Json(name = "releases_url")
    public String releasesUrl;

    @Json(name = "deployments_url")
    public String deploymentsUrl;

    @Json(name = "created_at")
    public String createdAt;

    @Json(name = "updated_at")
    public String updatedAt;

    @Json(name = "pushed_at")
    public String pushedAt;

    @Json(name = "git_url")
    public String gitUrl;

    @Json(name = "ssh_url")
    public String sshUrl;

    @Json(name = "clone_url")
    public String cloneUrl;

    @Json(name = "svn_url")
    public String svnUrl;

    @Json(name = "homepage")
    public Object homepage;

    @Json(name = "size")
    public long size;

    @Json(name = "stargazers_count")
    public long stargazersCount;

    @Json(name = "watchers_count")
    public long watchersCount;

    @Json(name = "language")
    public String language;

    @Json(name = "has_issues")
    public boolean hasIssues;

    @Json(name = "has_projects")
    public boolean hasProjects;

    @Json(name = "has_downloads")
    public boolean hasDownloads;

    @Json(name = "has_wiki")
    public boolean hasWiki;

    @Json(name = "has_pages")
    public boolean hasPages;

    @Json(name = "forks_count")
    public long forksCount;

    @Json(name = "mirror_url")
    public Object mirrorUrl;

    @Json(name = "open_issues_count")
    public long openIssuesCount;

    @Json(name = "forks")
    public long forks;

    @Json(name = "open_issues")
    public long openIssues;

    @Json(name = "watchers")
    public long watchers;

    @Json(name = "default_branch")
    public String defaultBranch;
}
