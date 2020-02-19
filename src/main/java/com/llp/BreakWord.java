package com.llp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BreakWord {


    /**
     * 不带扩展字典，实现断句
     *
     * @param str
     * @param dict
     * @return
     */
    public ArrayList<String> wordBreak(String str, Set<String> dict) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        return dfs(str, dict, map, null);
    }

    /**
     * 带扩展字典，实现断句
     *
     * @param str
     * @param dict
     * @param flag
     * @return
     */
    public ArrayList<String> wordBreak(String str, Set<String> dict, String flag) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        return dfs(str, dict, map, flag);
    }

    /**
     * 使用递归方法具体实现断句
     *
     * @param s
     * @param inputNewDict
     * @param map
     * @param flag
     * @return
     */
    public ArrayList<String> dfs(String s, Set<String> inputNewDict, HashMap<String, List<String>> map, String flag) {

        Set<String> setAll = new HashSet<String>();
        //初始化Set
        Set dict = new HashSet();
        dict.add("i");
        dict.add("like");
        dict.add("sam");
        dict.add("sung");
        dict.add("samsung");
        dict.add("mobile");
        dict.add("ice");
        dict.add("cream");
        dict.add("man");
        dict.add("go");
        setAll = dict;

        if ("single".equals(flag)) {
            setAll.clear();
            setAll = inputNewDict;
        } else if ("all".equals(flag)) {
            if (!inputNewDict.isEmpty()) {
                setAll.addAll(inputNewDict);
            }
        }

        if (map.containsKey(s)) {
            return (ArrayList<String>) map.get(s);
        }

        ArrayList<String> lists = new ArrayList();
        if (s.equals("")) {
            lists.add("");
        } else {
            int len = s.length();
            for (int i = 1; i <= len; i++) {
                String sub = s.substring(0, i);
                if (setAll.contains(sub)) {
                    ArrayList t = dfs(s.substring(i, len), setAll, map, flag);
                    if (t.size() == 0) {
                        continue;
                    } else {
                        for (int j = 0; j < t.size(); j++) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(sub).append(" ").append(t.get(j));
                            lists.add(sb.toString().trim());
                        }
                    }
                }
            }
        }
        map.put(s, lists);
        return lists;
    }

}