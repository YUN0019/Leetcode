import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    /*
     * Time Complexity: O(n)
     * 說明：線性掃描字串；每個字元最多進/出棧一次，總操作與字元數成正比。
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if ((c == ')' && open != '(') ||
                    (c == ']' && open != '[') ||
                    (c == '}' && open != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

/*
解題邏輯與思路（堆疊匹配）：
1. 左括號入棧，遇到右括號時需與棧頂左括號成對（()、[]、{}）。
2. 若棧空卻遇到右括號、或型別不匹配，立即返回 false。
3. 掃描結束後，棧必須為空才有效（沒有多餘左括號）。
4. 時間 O(n)，空間 O(n)（最壞情況全部為左括號）。
*/
