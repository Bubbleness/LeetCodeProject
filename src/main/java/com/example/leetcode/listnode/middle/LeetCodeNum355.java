package com.example.leetcode.listnode.middle;

import com.alibaba.fastjson.JSON;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author shuiyu
 */
public class LeetCodeNum355 {

    static class Twitter {

        public int time;
        public Map<Integer, User> userMap;

        public Twitter() {
            this.time = 0;
            this.userMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            if (!userMap.containsKey(userId)) {
                userMap.put(userId, User.newInstance(userId));
            }

            userMap.get(userId).postTweet(tweetId, time);
            time++;
        }

        public List<Integer> getNewsFeed(int userId) {
            if (!userMap.containsKey(userId)) {
                return new ArrayList<>();
            }
            Set<Integer> userFollowees = userMap.get(userId).followers;
            if (userFollowees.size() == 0) {
                List<Integer> res = new ArrayList<>();
                for (int i=0; i< userMap.get(userId).tweetList.size(); i++) {
                    res.add(userMap.get(userId).tweetList.get(i).id);
                }
                return res;
            }
            List<LinkedList<Tweet>> lists = new ArrayList<>();
            lists.add(userMap.get(userId).tweetList);
            for (Integer item : userFollowees) {
                if (userMap.containsKey(item)) {
                    lists.add(userMap.get(item).tweetList);
                }
            }
            LinkedList<Integer> res = new LinkedList<>();
            LinkedList<Tweet> tweets = merge(lists, 0, lists.size()-1);
            if (tweets == null) {
                return new ArrayList<>();
            }
            if (tweets.size() < 10) {
                for (int i=0; i<tweets.size(); i++) {
                    res.add(tweets.get(i).id);
                }
            } else {
                for (int i=0; i<10; i++) {
                    res.add(tweets.get(i).id);
                }
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            if (!userMap.containsKey(followerId)) {
                userMap.put(followerId, User.newInstance(followerId));
            }
            userMap.get(followerId).followers.add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            userMap.get(followerId).followers.remove(followeeId);
        }

        public LinkedList<Tweet> merge(List<LinkedList<Tweet>> lists, int start, int end) {

            if (start == end) {
                return lists.get(start);
            }
            if (start > end) {
                return null;
            }
            int mid = (start + end) / 2;
            LinkedList<Tweet> left = merge(lists, start, mid);
            LinkedList<Tweet> right = merge(lists, mid+1, end);
            return mergeTwoList(left, right);
        }

        public LinkedList<Tweet> mergeTwoList(LinkedList<Tweet> l1, LinkedList<Tweet> l2) {
            if (l1 == null && l2 == null) {
                return null;
            }
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            LinkedList<Tweet> tweets = new LinkedList<>();
            int index1 = 0, index2 = 0;
            while (index1 < l1.size() && index2 < l2.size()) {
                if (l1.get(index1).time >= l2.get(index2).time) {
                    tweets.add(l1.get(index1));
                    index1++;
                } else {
                    tweets.add(l2.get(index2));
                    index2++;
                }
            }
            while (index1 < l1.size()) {
                tweets.add(l1.get(index1));
                index1++;
            }

            while (index2 < l2.size()) {
                tweets.add(l2.get(index2));
                index2++;
            }
            return tweets;
        }
    }

    static class Tweet {
        public int id;
        public int time;

        public Tweet() {
        }

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    static class User {
        public int userId;
        // 用户的推文
        public LinkedList<Tweet> tweetList;
        public Set<Integer> followers;

        public User(int userId, LinkedList<Tweet> tweetList) {
            this.userId = userId;
            this.tweetList = tweetList;
        }

        public User(int userId, LinkedList<Tweet> tweetList, Set<Integer> followers) {
            this.userId = userId;
            this.tweetList = tweetList;
            this.followers = followers;
        }

        public static User newInstance(Integer id) {
            return new User(id, new LinkedList<>(), new HashSet<>());
        }

        // 关注别人
        public void concern(int followeeId) {
            if (followeeId == userId) {
                return;
            }
            followers.add(followeeId);
        }

        // 取消关注别人
        public void unConcern(int followeeId) {
            if (followeeId == userId
                    || !followers.contains(followeeId)) {
                return;
            }
            followers.remove((Integer) followeeId);
        }

        // 用户发送推文（只保留10条）
        public void postTweet(int tweetId, int time) {
            if (this.tweetList.size() == 10) {
                this.tweetList.remove(this.tweetList.size() -1);
                this.tweetList.addFirst(new Tweet(tweetId, time));
            } else {
                this.tweetList.addFirst(new Tweet(tweetId, time));
            }
        }
    }


//    static class Twitter {
//
//        // 用户关注的人
//        Map<Integer, List<Integer>> followMap;
//        Map<Integer, LinkedList<Integer>> userTwitter;
//        // 用户被别人关注的人
//        Map<Integer, List<Integer>> beFollowedMap;
//
//        public Twitter() {
//
//            this.followMap = new HashMap<>();
//            this.userTwitter = new HashMap<>();
//            this.beFollowedMap = new HashMap<>();
//
//        }
//
//        public void postTweet(int userId, int tweetId) {
//
//            // 用户发送自己的推文
//            if (userTwitter.containsKey(userId)) {
//                LinkedList<Integer> userTwitterList = userTwitter.get(userId);
//                userTwitterList.addFirst(tweetId);
//            } else {
//                LinkedList<Integer> newUserTwitterList = new LinkedList<>();
//                newUserTwitterList.addFirst(tweetId);
//                userTwitter.put(userId, newUserTwitterList);
//            }
//
//            // 用户如果被别人关注了，也需要把自己的推文写到别人的推文列表
//            if (!beFollowedMap.containsKey(userId)) {
//                return;
//            }
//            List<Integer> userFollower = beFollowedMap.get(userId);
//            for (Integer followee : userFollower) {
//                LinkedList<Integer> followeeTwitter;
//                if (userTwitter.containsKey(followee)) {
//                    followeeTwitter = userTwitter.get(followee);
//                    followeeTwitter.addFirst(tweetId);
//                } else {
//                    followeeTwitter = new LinkedList<>();
//                    followeeTwitter.addFirst(tweetId);
//                    userTwitter.put(followee, followeeTwitter);
//                }
//            }
//
//        }
//
//        public List<Integer> getNewsFeed(int userId) {
//
//            if (!userTwitter.containsKey(userId)) {
//                return new LinkedList<>();
//            }
//            LinkedList<Integer> userTwitterContent = userTwitter.get(userId);
//            if (userTwitterContent.size() == 0) {
//                return new LinkedList<>();
//            }
//            if (userTwitterContent.size() <= 10) {
//                return userTwitterContent;
//            }
//            List<Integer> lastest = new LinkedList<>();
//            for (int i = 0; i < 10; i++) {
//                lastest.add(userTwitterContent.get(i));
//            }
//            return lastest;
//        }
//
//        public void follow(int followerId, int followeeId) {
//
//            // 用户关注的人列表添加新关注的人， 比如： 1 关注了 2 -> （1, [2]）
//            Set<Integer> keySet = followMap.keySet();
//            if (keySet.contains(followerId)) {
//                if (!followMap.get(followerId).contains(followeeId)) {
//                    followMap.get(followerId).add(followeeId);
//                }
//            } else {
//                List<Integer> value = new ArrayList<>();
//                value.add(followeeId);
//                followMap.put(followerId, value);
//            }
//
//            // 被关注的人列表添加关注他的人，比如：2 被 1 关注了 -> (2, [1])
//            Set<Integer> beFollowedKeySet = beFollowedMap.keySet();
//            if (beFollowedKeySet.contains(followeeId)) {
//                if (!beFollowedMap.get(followeeId).contains(followerId)) {
//                    beFollowedMap.get(followeeId).add(followerId);
//                }
//            } else {
//                List<Integer> value = new ArrayList<>();
//                value.add(followerId);
//                beFollowedMap.put(followeeId, value);
//            }
//
//            // 把被关注人的twitter列表拷贝过来 比如 1 关注 2， 2 的列表要添加1的内容
//            if (!userTwitter.containsKey(followeeId)) {
//                return;
//            }
//            if (userTwitter.containsKey(followerId)) {
//                LinkedList<Integer> userContent = userTwitter.get(followerId);
//                userContent.addAll(userTwitter.get(followeeId));
//            } else {
//                LinkedList<Integer> temp = userTwitter.get(followeeId);
//                userTwitter.put(followerId, temp);
//            }
//
//        }
//
//        public void unfollow(int followerId, int followeeId) {
//
//            // 用户取消关注人
//            Set<Integer> keySet = followMap.keySet();
//            if (keySet.contains(followerId)) {
//                List<Integer> value = followMap.get(followerId);
//                if (value.contains(followeeId)) {
//                    value.remove((Integer) followeeId);
//                }
//            }
//
//            // 被关注人的被关注列表提出改用户
//            keySet = beFollowedMap.keySet();
//            if (keySet.contains(followeeId)) {
//                List<Integer> value = beFollowedMap.get(followeeId);
//                if (value.contains(followerId)) {
//                    value.remove((Integer) followerId);
//                }
//            }
//
//            // 清除被关注的用户在用户twitter列表中的记录
//            if (!userTwitter.containsKey(followerId)) {
//                return;
//            }
//            LinkedList<Integer> userContext = userTwitter.get(followerId);
//            if (userTwitter.containsKey(followeeId)) {
//                LinkedList<Integer> temp = userTwitter.get(followeeId);
//                for (Integer item : temp) {
//                    userContext.remove((Integer) item);
//                }
//            }
//        }
//
//        public static void main(String[] args) {
//            Twitter obj = new Twitter();
//            obj.postTweet(1, 1);
////            obj.postTweet(1, 8);
////            obj.postTweet(1, 3);
//            List<Integer> param_1 = obj.getNewsFeed(1);
//            System.out.println("param_1 = " + JSON.toJSONString(param_1));
//
//            obj.follow(2, 1);
////            obj.postTweet(2, 6);
////            obj.postTweet(2, 7);
////            obj.postTweet(2, 19);
//            List<Integer> param_2 = obj.getNewsFeed(2);
//            System.out.println("param_2 = " + JSON.toJSONString(param_2));
//
//            obj.unfollow(2, 1);
//            List<Integer> param_3 = obj.getNewsFeed(2);
//            System.out.println("param_3 = " + JSON.toJSONString(param_3));
//        }
//    }
}
