package DesignTwitter;

import java.util.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/13
 * @desp: 355题——设计推特, https://leetcode-cn.com/problems/design-twitter/
 */

public class Solution {

}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
class Twitter {

    private List<Integer> userIdList = new ArrayList<>();
    private List<Integer> tweetIdList = new ArrayList<>();
    private Map<Integer, Set<Integer>> followMap = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        userIdList.add(userId);
        tweetIdList.add(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        for (int i = tweetIdList.size() - 1; res.size() < 10 && i >= 0; i--) {
            int poster = userIdList.get(i);
            if (userId == poster || (followMap.containsKey(userId) && followMap.get(userId).contains(poster))) {
                res.add(tweetIdList.get(i));
            }
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId))
            followMap.get(followerId).add(followeeId);
        else {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            followMap.put(followerId, set);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && followMap.get(followerId).contains(followeeId))
            followMap.get(followerId).remove(followeeId);
    }
}
