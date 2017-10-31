package DFS;

public class Queue {
    private final int SIZE=20;
    private int[] queueArray;
    private int front;
    private int rear;

    public Queue() {
        queueArray=new int[SIZE];
        front=0;
        rear=-1;
    }

    public void insert(int a){
        if(rear==SIZE-1){
            rear=-1;
        }
        queueArray[++rear]=a;
    }

    public int remove(){
        int temp=queueArray[front++];
        if(front==SIZE){
            front=0;
        }
        return temp;
    }

    public boolean isEmpty(){
        return (rear+1==front || front+SIZE-1==rear);
    }
}
