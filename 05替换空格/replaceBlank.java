
// StringBuilder相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类，
// 它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）
// 需要对字符串进行修改推荐使用 StringBuffer, String 不能修改

class Solution {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}

public class Solution {
    public String replaceSpace(StringBuffer str) {
        int oldLength = str.length();
        int count = 0;
        for (int i = 0; i < oldLength; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int newLength = str.length();
        int j = newLength - 1;
        for (int i = oldLength - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                str.setCharAt(j--, '0');
                str.setCharAt(j--, '2');
                str.setCharAt(j--, '%');
            } else {
                str.setCharAt(j--, str.charAt(i));
            }
        }
        return str.toString();
    }
}

/** 解法时间空间复杂度均不佳
class Solution {
    public String replaceSpace(String s) {
        String ns = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                ns += "%20";     
            } else {
                ns += s.charAt(i);
            }
        }
        return ns;
    }
}
*/