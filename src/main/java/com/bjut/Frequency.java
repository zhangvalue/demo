/**
 * @ Author zhangsf
 * @CreateTime 2018/10/16 - 6:21 PM
 */
package com.bjut;

/**
 * 请设计一个高效的方法，找出任意指定单词在一篇文章中的出现频数。
 * 给定一个string数组article和数组大小n及一个待统计单词word，请返回该单词在文章中的出现频数。
 * 保证文章的词数小于等于1000
 */
public class Frequency {
    public int getFrequency(String[] article, int n, String word) {
        // write code here
        TrieNode root = new TrieNode();
        for (String str : article) {
            root.insert(str, 0);
        }

        if (word == null || word.length() == 0) {
            return 0;
        }

        TrieNode ans = root.search(word, 0);
        if (ans != null && ans.isWord == true) {
            return ans.cnt;
        }

        return 0;
    }

}



class TrieNode {
    private TrieNode[] children;
    public boolean isWord;
    public int cnt;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
        cnt = 0;
    }

    public void insert(String word, int index) {
        if (index == word.length()) {
            isWord = true;
            ++cnt;
            return;
        }

        int c = word.charAt(index) - 'a';
        if (children[c] == null) {
            children[c] = new TrieNode();
        }

        children[c].insert(word, index + 1);
    }

    public TrieNode search(String word, int index) {
        if (index == word.length()) {
            return this;
        }

        int c = word.charAt(index) - 'a';
        if (children[c] == null) {
            return null;
        }

        return children[c].search(word, index + 1);
    }
}