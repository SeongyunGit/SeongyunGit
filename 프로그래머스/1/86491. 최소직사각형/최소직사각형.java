class Solution {
    public int solution(int[][] sizes) {
        int x = 0;
        int y = 0;
        for (int i=0;i<sizes.length;i++){
            int nowi= Math.max(sizes[i][0], sizes[i][1]);
            int nowj= Math.min(sizes[i][0], sizes[i][1]);
            x = Math.max(nowi, x);
            y = Math.max(nowj, y);
        }        
        int answer = x*y;
        return answer;
    }
}