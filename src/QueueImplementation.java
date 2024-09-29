import java.util.Scanner;

//this program is implemented to understand the QUEUE data structure using arrays.
public class QueueImplementation {
    //create stack pointers variable indicating the front and rear element
    public int front = -1;
    public int rear = -1;
    //create queue variable
    public int[] queue;
    //create variable to identify the size of a queue
    public int capacity;
    //function to define properties of a queue
    public void Queue(int size)
    {
        queue = new int[size];
        capacity = size;
        front = -1;
        rear = -1;
    }
    //functions to check whether a queue is Empty or Full
    public boolean isQueueEmpty(){return (front == -1 && rear == -1);}
    public boolean isQueueFull(){return (rear == capacity-1);}
    //function to add an element into the queue
    public void enqueue(int data)
    {
        if(isQueueFull() ){System.out.println(":/QUEUE IS BUSY! CAN'T ADD TO QUEUE");}
        else if(front == -1 && rear == -1)
        {
            queue[rear + 1] = data;
            front = 0;
            rear = 0;
            System.out.println(":>YOUR ELEMENT IS IN QUEUE");
            display();
        } else if (front == 0) {
             queue[rear + 1] = data;
             rear = rear+1;
            System.out.println(":>YOUR ELEMENT IS IN QUEUE");
            display();
        }
    }
    //function to remove an element out of a queue
    public void dequeue()
    {
        if(isQueueEmpty() || front >= capacity) {System.out.println(":/QUEUE IS EMPTY!");}
        else
        {
            front = front +1;
            System.out.println(":>YOUR ELEMENT IS OUT OF QUEUE");
            display();
        }
    }
    //function to display a queue
    public void display()
    {
        if(isQueueEmpty()|| front >= capacity){ System.out.println(":/NO ELEMENTS FOUND! QUEUE IS EMPTY."); }
        else
        {
            System.out.print("QUEUE: << ");
            for (int i = front; i <=rear ; i++) { System.out.print(queue[i]+", "); }
            System.out.print("<<");
        }
    }
    //main function
    public static void main(String[] args) {
        System.out.println("===================\nROLL NO: 124BTAI2002\nNAME: TANISHQ PARMAR \nCOURSE: AI-DS \nSEMESTER: 3");
        System.out.println("===================\nPROGRAM TO IMPLEMENT QUEUE.\n===================");

            QueueImplementation obj = new QueueImplementation();
            Scanner scan = new Scanner(System.in);
                String choice;
                int size;
        do {
            if (obj.isQueueEmpty())
            {
                System.out.println(":/QUEUE IS EMPTY!\nCreate Queue-->");
                System.out.print("ENTER QUEUE SIZE: ");
                size = scan.nextInt();
                    obj.Queue(size+2);
                System.out.println("ENTER ELEMENTS: ");
                for (int i = 0; i < size; i++) {
                    obj.queue[i] = scan.nextInt();
                    obj.rear = obj.rear + 1;
                }
                    obj.front = obj.front + 1;
                System.out.println("\n:>QUEUE IS CREATED.");
                    obj.display();
            }
            System.out.print("\nCHOOSE OPERATION \n1. FRONT\n2. ENQUEUE\n3. DEQUEUE\n4. DISPLAY\n-->>");
            byte opt = scan.nextByte();
            switch (opt)
            {
                case 1: //case used for fetching front element of a queue
                    System.out.println("FRONT ELEMENT: "+obj.queue[obj.front]);
                    break;
                case 2: //case used to add element in a queue
                    System.out.print("ENTER ELEMENT: ");
                    int enqueuedata = scan.nextInt();
                    obj.enqueue(enqueuedata);
                    break;
                case 3: //case used to remove element out of queue
                    obj.dequeue();
                    break;
                case 4: // case used to display a queue
                    obj.display();
                    break;
                default: // case to handle for invalid choice input
                    System.out.println(":/CHOICE UNAVAILABLE");
                    break;
            }
            System.out.print("\n:>Do you want to continue: ");
            choice = scan.next();
        }while(choice.equals("Y") || choice.equals("y"));
        scan.close();//terminating Scanner object
    }
}
