public class LC1613MaximumDepthParentheses {
    public int maxDepth(String s) {
        int len = s.length();
        int curDepth = 0;
        int cur = 0;

        for (int i = 0; i < len; i++){
            if (s.charAt(i) == '(') cur++;
            if (s.charAt(i) == ')') cur--;
            curDepth = Math.max(curDepth, cur);
        }
        return curDepth;
    }
}
