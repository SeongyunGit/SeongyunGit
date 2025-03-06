class Solution {
    public int[] solution(String[] park, String[] routes) {
        int x = 0, y = 0;

        // 'S'의 위치 찾기
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        }

        // 명령 수행
        for (String s : routes) {
            char dir = s.charAt(0);
            int num = Integer.parseInt(s.substring(2)); // 올바른 숫자 변환

            int nx = x, ny = y;
            boolean canMove = true;

            for (int k = 1; k <= num; k++) {
                if (dir == 'N') nx = x - k;
                if (dir == 'S') nx = x + k;
                if (dir == 'W') ny = y - k;
                if (dir == 'E') ny = y + k;

                // 범위 체크
                if (nx < 0 || nx >= park.length || ny < 0 || ny >= park[0].length()) {
                    canMove = false;
                    break;
                }

                // 장애물('X') 체크
                if (park[nx].charAt(ny) == 'X') {
                    canMove = false;
                    break;
                }
            }

            if (canMove) {
                x = nx;
                y = ny;
            }
        }

        return new int[]{x, y};
    }
}
