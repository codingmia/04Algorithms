
public class test {
	public boolean[][] getPalindromeDict(String s){
        int len = s.length();
        boolean[][] res = new boolean[len][len];
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                res[i][j] = isValidPalindrome(s.substring(i, j+1));// endIndex exclusive
            }
        }
        return res;
    }
	public boolean isValidPalindrome(String s){
	 return true;
	}
}
