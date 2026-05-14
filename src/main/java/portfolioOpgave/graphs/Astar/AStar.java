package portfolioOpgave.graphs.Astar;
import java.util.*;

public class AStar {

    // "" = ingen vej, "1" = vej, "2" = motorvej, "3" = snejlvej, resterende = by
    static String[][] grid = {
            {"2","2","2","2","2","2","",""},
            {"Vejby","1","1","","1","2","2",""},
            {"2","","1","3","3","3","Hjemby",""},
            {"2","","Midtby","","1","","3","2"},
            {"1","1","1","1","","","3","2"},
            {"1","","1","","1","1","Byby","2"},
            {"1","1","Bundby","1","1","","2","2"},
            {"","","","2","2","2","2",""},
    };

    static final int ROWS = 8, COLS = 8;


    public static void main(String[] args) {
        // Byg alle noder
        CityNode[][] nodes = new CityNode[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c].isBlank()) { continue; }

                switch (grid[r][c]){
                    case "1":
                        System.out.println("1");
                        nodes[r][c] = new CityNode(r, c, "vej", 2);
                        break;
                    case "2":
                        System.out.println("2");
                        nodes[r][c] = new CityNode(r, c, "Motorvej",  1);
                        break;
                    case "3":
                        System.out.println("3");
                        nodes[r][c] = new CityNode(r, c, "snejlvej", 4);
                        break;
                    default:
                        System.out.println("default");
                        nodes[r][c] = new CityNode(r, c, grid[r][c], 3);
                        break;
                }
            }
        }

        // Forbind naboer — urettede kanter i alle 4 retninger
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (nodes[r][c] == null) continue;
                for (int[] d : directions) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && nodes[nr][nc] != null) {
                        nodes[r][c].addNeighbor(nodes[nr][nc]);
                    }
                }
            }
        }

        CityNode start = nodes[1][0];

        CityNode End = nodes[5][6];

        findShortestPath(start, End, 0);

        findShortestPath(start, End, 1);

        findShortestPath(start, End, 3);
    }

    private static void findShortestPath(CityNode start, CityNode end, float heuristicMultiplier){
        HashMap<CityNode, PathCarrier> prev = new HashMap<>();
        HashSet<CityNode> visited = new HashSet<>();
        PriorityQueue<PathCarrier> queue = new PriorityQueue<>();
        queue.add(new PathCarrier(0,start));
        prev.put(start,new PathCarrier(0,null));

        while (!queue.isEmpty()){
            PathCarrier current = queue.poll();
            if (visited.contains(current.node)) break;
            if (current.node == end) break;
            visited.add(current.node);


            for (CityNode node: current.node.getNeighbors()){
                int distance = node.getWeight();
                if (visited.contains(node)) continue;

                float newDist = distance + current.pathlength;
                double heuristic = Math.sqrt(current.node.getCol()*current.node.getCol() + current.node.getRow()*current.node.getRow()); // squared distance

                if (newDist < prev.getOrDefault(node, new PathCarrier(Integer.MAX_VALUE,null)).pathlength){
                    prev.put(node, new PathCarrier(newDist + (float) (heuristicMultiplier * heuristic), current.node));
                    queue.add(new PathCarrier(newDist, node));
                }
            }
        }
        List<String> path = new ArrayList<>();
        String[][] grid = new String[ROWS][COLS];
        CityNode current = end;
        while(prev.get(current).node != null){
            PathCarrier node = prev.get(current);
            grid[node.node.getRow()][node.node.getCol()] = node.node.getName();
            path.add(node.node.getName());
            current = node.node;
        }

        System.out.println("undersøgt: " + visited.size());
        System.out.println("Korteste vej: " + path);
        for (String[] row : grid){
            System.out.println(Arrays.toString(row));
        }
        System.out.println(Arrays.deepToString(grid));
        System.out.println("Samlet dist: " + prev.get(end).pathlength);
    }

    private static class PathCarrier implements Comparable<PathCarrier>{
        public float pathlength;
        public CityNode node;

        public PathCarrier(float pathlength, CityNode node) {
            this.pathlength = pathlength;
            this.node = node;
        }

        @Override
        public int compareTo(PathCarrier o) {
            return Double.compare(this.pathlength, o.pathlength);
        }
    }
}