package DFS;

public class Main {
    public static void main(String[] args){
        Graph g=new Graph();
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
        g.addVertex('G');

        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(2,4);
        g.addEdge(3,4);
        g.addEdge(3,6);
        g.addEdge(4,5);

        //g.dfs();
        g.bfs();
    }
}
