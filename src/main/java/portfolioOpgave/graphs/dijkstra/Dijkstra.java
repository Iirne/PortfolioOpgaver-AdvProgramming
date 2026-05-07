package portfolioOpgave.graphs.dijkstra;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        WeightedNode S = new WeightedNode("S");
        WeightedNode A = new WeightedNode("A");
        WeightedNode B = new WeightedNode("B");
        WeightedNode C = new WeightedNode("C");
        WeightedNode D = new WeightedNode("D");
        WeightedNode E = new WeightedNode("E");
        WeightedNode F = new WeightedNode("F");
        WeightedNode G = new WeightedNode("G");
        WeightedNode H = new WeightedNode("H");
        WeightedNode I = new WeightedNode("I");
        WeightedNode J = new WeightedNode("J");
        WeightedNode K = new WeightedNode("K");
        WeightedNode L = new WeightedNode("L");
        WeightedNode M = new WeightedNode("M");

        S.addNeighbor(A, 1);
        S.addNeighbor(B, 3);
        S.addNeighbor(C, 2);
        A.addNeighbor(D, 2);
        B.addNeighbor(D, 5);
        B.addNeighbor(E, 4);
        C.addNeighbor(E, 1);
        C.addNeighbor(F, 3);
        D.addNeighbor(G, 3);
        E.addNeighbor(G, 6);
        E.addNeighbor(H, 3);
        F.addNeighbor(I, 2);
        G.addNeighbor(H, 1);
        G.addNeighbor(J, 7);
        H.addNeighbor(J, 2);
        H.addNeighbor(K, 5);
        I.addNeighbor(K, 3);
        I.addNeighbor(L, 4);
        J.addNeighbor(M, 3);
        K.addNeighbor(M, 4);
        L.addNeighbor(M, 8);

        findShortestPath(S, M);
    }

    private static void findShortestPath(WeightedNode start, WeightedNode end){
        HashMap<WeightedNode, PathCarrier> prev = new HashMap<>();
        HashSet<WeightedNode> visited = new HashSet<>();
        PriorityQueue<PathCarrier> queue = new PriorityQueue<>();
        queue.add(new PathCarrier(0,start));
        prev.put(start,new PathCarrier(0,null));

        while (!queue.isEmpty()){
            PathCarrier current = queue.poll();
            if (visited.contains(current)) break;
            if (current.node == end) break;
            visited.add(current.node);


            for (Map.Entry<WeightedNode, Integer> entry : current.node.getNeighbors().entrySet()){
                WeightedNode next = entry.getKey();
                Integer distance = entry.getValue();
                if (visited.contains(next)) continue;

                Integer newDist = distance + current.pathlength;

                if (newDist < prev.getOrDefault(next, new PathCarrier(Integer.MAX_VALUE,null)).pathlength){
                    prev.put(next, new PathCarrier(newDist, current.node));
                    queue.add(new PathCarrier(newDist, next));
                }
            }
        }
        List<String> path = new ArrayList<>();
        WeightedNode current = end;
        while(prev.get(current).node != null){
            PathCarrier node = prev.get(current);
            path.add(node.node.getName());
            current = node.node;
        }

        System.out.println("Korteste vej: " + path);
        System.out.println("Samlet dist: " + prev.get(end).pathlength);
    }

    private static class PathCarrier implements Comparable<PathCarrier>{
        public Integer pathlength;
        public WeightedNode node;

        public PathCarrier(Integer pathlength, WeightedNode node) {
            this.pathlength = pathlength;
            this.node = node;
        }

        @Override
        public int compareTo(PathCarrier o) {
            return o.pathlength - this.pathlength;
        }
    }
}
