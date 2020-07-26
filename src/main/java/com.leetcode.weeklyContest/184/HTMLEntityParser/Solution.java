package HTMLEntityParser;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/12
 * @desp: 周赛184场5382题——HTML实体解析器, https://leetcode-cn.com/contest/weekly-contest-184/problems/html-entity-parser/
 */

public class Solution {
    public String entityParser(String text) {
        text = text.replaceAll("&quot;", "\"");
        text = text.replaceAll("&apos;", "'");
        text = text.replaceAll("&amp;", "&");
        text = text.replaceAll("&gt;", ">");
        text = text.replaceAll("&lt;", "<");
        text = text.replaceAll("&frasl;", "/");
        return text;
    }
}
