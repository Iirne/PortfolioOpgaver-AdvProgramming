package portfolioOpgave.graphs.Astar;

import java.util.ArrayList;
import java.util.List;

public class CityNode {
    private String name;
    private int row;
    private int col;
    private List<CityNode> neighbors = new ArrayList<>();
    private int weight;

    public CityNode(int row, int col, String name, int w) {
        this.name = name;
        this.row = row;
        this.col = col;
        this.weight = w;
    }

    public int getWeight() { return weight; }
    public String getName() { return name; }
    public int getRow() { return row; }
    public int getCol() { return col; }
    public List<CityNode> getNeighbors() { return neighbors; }

    public void addNeighbor(CityNode neighbor) {
        neighbors.add(neighbor);
    }

    @Override
    public String toString() {
        return "CityNode{" +
                "name='" + name + '\'' +
                ", row=" + row +
                ", col=" + col +
                ", weight=" + weight +
                '}';
    }
}