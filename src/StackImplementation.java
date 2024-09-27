import java.util.*;
/*
  //optional code for printing stack
*/
public class StackImplementation {
    //creat stack pointer variable indication the top element
    public int top = -1;
    //create stack variable
    public int stack[];
    //create variable to identify the size of the stack
    public int capacity;
    //function to define properties of the stack
    public void Stack(int size)
    {
        stack = new int[size];
        capacity = size;
        top = -1;
    }
    //functions to check whether the stack is Empty or Full
    public boolean isStackEmpty(){return top == -1;}
    public boolean isStackFull(){return top == capacity-1;}
    //function to add an element into the stack
    public void push(int data)
    {
        if(isStackFull()) { System.out.println(":/CANNOT PUSH! STACK IS FULL"); }
        else
        {
            stack[top+1] = data;
            top = top+1;
            System.out.println(":>ELEMENT PUSHED SUCCESSFULLY");
            display();
        }
    }
    //function to remove an element out of the stack
    public void pop()
    {
        if(isStackEmpty()) { System.out.println(":/CANNOT POP! STACK IS EMPTY"); }
        else
        {
            top = top-1;
            System.out.println(":>ELEMENT POPPED SUCCESSFULLY");
            display();
        }
    }
    //function to either peek the top element or display the stack
    public void display()
    {
        if(isStackEmpty()){ System.out.println(":/NO ELEMENTS FOUND! STACK IS EMPTY."); }
        else
        {
            System.out.print("STACK: [");
            for(int i = 0; i <= top; i++) { System.out.print( " "+stack[i]); }
            System.out.print(" ]");
        }
    }



    public static void main(String[] args) {

        System.out.println("===================\nPROGRAM TO IMPLEMENT STACK.\n===================");
        StackImplementation obj = new StackImplementation();
        int size;
        String choice;
        do {
            Scanner scan = new Scanner(System.in);
            if (obj.isStackEmpty()) {
                System.out.println(":/STACK IS EMPTY!\nCreate Stack-->");
                System.out.print("ENTER STACK SIZE: ");
                size = scan.nextInt();
                obj.Stack(size + 1);
                System.out.print("ENTER ELEMENTS: ");
                for (int i = 0; i < size; i++) {
                    obj.stack[i] = scan.nextInt();
                    obj.top = obj.top + 1;
                }
                System.out.println("\n:>STACK IS CREATED.");
                obj.display();
            }
            System.out.println("\nCHOOSE OPERATION \n1. PEEK\n2. PUSH\n3. POP\n4. DISPLAY");
            byte opt = scan.nextByte();
            switch (opt) {
                case 1:
                    System.out.println("TOP ELEMENT: "+obj.stack[obj.top]);
                    break;
                case 2:
                    System.out.print("ENTER ELEMENT: ");
                    int pushdata = scan.nextInt();
                    obj.push(pushdata);
                    break;
                case 3:
                    obj.pop();
                    break;
                case 4:
                    obj.display();
                    break;
                default:
                    System.out.println(":/CHOICE UNAVAILABLE");
                    break;
            }
            System.out.println("\n:>Do you want to continue");
            choice = scan.next();
        }while (choice.equals("Y")||choice.equals("y"));
    }
}

