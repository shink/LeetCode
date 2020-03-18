package CompressStringLCCI;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/16
 * @desp: 面试题 01.06——字符串压缩, https://leetcode-cn.com/problems/compress-string-lcci/
 */

public class Solution {

    /**
     * 我的方法
     */
    //    public String compressString(String S) {
    //
    //        int i, j;
    //        String res = "";
    //        char[] array = S.toCharArray();
    //
    //        for (i = 0; i < array.length; i++) {
    //            int num = 1;
    //            char item = array[i];
    //
    //            for (j = i + 1; j < array.length; j++) {
    //                if (array[j] == array[i])
    //                    num++;
    //                else
    //                    break;
    //            }
    //            i = j - 1;
    //            res += item + Integer.toString(num);
    //        }
    //
    //        return (S.length() <= res.length()) ? S : res;
    //    }

    /**
     * 官方题解
     */
    public String compressString(String S) {
        if (S.length() == 0) {
            return S;
        }

        int i, j;
        String res = "";
        char[] array = S.toCharArray();
        char item = array[0];
        int num = 1;

        for (i = 1; i < array.length; i++) {

            if (array[i] == item)
                num++;
            else {
                res += item + Integer.toString(num);
                item = array[i];
                num = 1;
            }
        }

        res += item + Integer.toString(num);
        return (S.length() <= res.length()) ? S : res;
    }
}
