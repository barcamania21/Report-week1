package DFS;

import sun.security.provider.certpath.Vertex;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private final int SIZE=20;
    private DFS.Vertex vertexList[];
    private int adjMatrix[][];
    private int currentVertices;
    private Stack stack=new Stack();
    private DFS.Queue queue=new DFS.Queue();

    //Sử dụng ma trận kề
    public Graph() {
        vertexList=new DFS.Vertex[SIZE];
        adjMatrix=new int[SIZE][SIZE];
        currentVertices=0;
        for(int i=0;i<SIZE;i++){
            for (int j=0;j<SIZE;j++){
                adjMatrix[i][j]=0;
            }
        }
    }

    //Thêm đỉnh
    public void addVertex(char v){
        vertexList[currentVertices++]=new DFS.Vertex(v);
    }

    //In ra đỉnh
    public void displayVertex(int v){
        System.out.print(vertexList[v].name);
    }

    //Thêm cạnh
    public void addEdge(int a, int b){
        adjMatrix[a][b]=1;
        adjMatrix[b][a]=1;
    }

    //Trả về đỉnh kề với đỉnh đang xét
    public int getAdjUnvisitedVertex(int v){
        for(int i=0;i<currentVertices;i++){
            if(adjMatrix[v][i]==1 && vertexList[i].isVisited==false) {
                return i;
            }
        }
        return -1;
    }

    //Depth-first search
    public void dfs(){
        vertexList[0].isVisited=true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()){
            int v=getAdjUnvisitedVertex((int)stack.peek());
            if(v==-1){
                stack.pop();
            }
            else{
                vertexList[v].isVisited=true;
                displayVertex(v);
                stack.push(v);
            }
        }
        for (int i=0;i<currentVertices;i++){
            vertexList[i].isVisited=false;
        }
    }

    //Breadth-First Search
    public void bfs(){
       vertexList[0].isVisited=true;
       displayVertex(0);
       queue.insert(0);
       int v2;
       while (!queue.isEmpty()){
           int v1=(int)queue.remove();

           while ((v2=getAdjUnvisitedVertex((int )v1))!=-1){
               vertexList[v2].isVisited=true;
               displayVertex(v2);
               queue.insert(v2);
           }
       }
       for(int i=0;i<currentVertices;i++){
           vertexList[i].isVisited=false;
       }
    }
}
