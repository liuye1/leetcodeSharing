public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int n = image.length;
        int m = image[0].length;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int[] dirX = new int[]{-1, 1, 0, 0};
        int[] dirY = new int[]{0, 0, -1, 1};
        Queue<Coordinate> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        q.offer(new Coordinate(x, y));
        visited[x][y] = 1;
        while (!q.isEmpty()){
            Coordinate current = q.poll();
             if (current.x <= minX){
                minX = current.x;
             }
             if (current.x > maxX){
                maxX = current.x;
             }
             if (current.y <= minY){
                minY = current.y;
            }
            if (current.y > maxY){
                maxY = current.y;
            }
            System.out.println(minX + "-" + maxX + "-" + minY + "-" + maxY);
            for (int i = 0; i < 4; i++){
                int nx = current.x + dirX[i];
                int ny = current.y + dirY[i];
                Coordinate neighbor = new Coordinate(nx, ny);
               
                if(!isValid(neighbor, image, visited)){
                    continue;
                }
                System.out.println("*" + nx + "," + ny);
                q.offer(neighbor);
                visited[nx][ny] = 1;
            }
        }
        if (minX <= maxX && minY <= maxY){
            return (maxX - minX + 1) * (maxY - minY + 1);
        }
        else{
            return 0;
        }
    }
    private boolean isValid(Coordinate cor, char[][] image, int[][] visited){
        int n = image.length;
        int m = image[0].length;
        return cor.x >= 0 && cor.x < n && cor.y >= 0 && cor.y < m && image[cor.x][cor.y] == '1' && visited[cor.x][cor.y] != 1;
    }   
}
