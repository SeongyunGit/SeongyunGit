class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int iidx = 0;
        int jidx = 0;
        
        for (String word : goal) {
            if (iidx < cards1.length && cards1[iidx].equals(word)) {
                iidx++;
            } else if (jidx < cards2.length && cards2[jidx].equals(word)) {
                jidx++; 
            } else {
                return "No"; 
            }
        }
        return "Yes";
    }
}