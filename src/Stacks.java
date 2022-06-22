//Initialise a stack in the main program.
//Write pop as a function.
//Write push as a procedure.
import java.util.Objects;
import java.util.Scanner;
public class Stacks {
    public static int [] Stack = new int [10];
    public static int BasePointer = 0;
    public static int TopPointer = -1;
    public static int StackFull = 10;
    public static int index;
    public static void main(String[] args) {

        Scanner myObj = new Scanner (System.in);
        String Choice;
        int item;
        boolean Exit = false;

        //Initialising the Stack with zeros.
        for (index = 0; index < 10; index++){
            Stack[index] = 0;
            TopPointer = TopPointer + 1;
        }

        //Getting numbers to fill in the Stack.
        for (index = 0; index < 10; index++){
            System.out.println("Please enter an item into the stack.");
            item = myObj.nextInt();
            if ((item == 0) || (item == -1)){
                TopPointer = index - 1;
                break;
            }
            Stack[index] = item;
        }

        //Viewing the Stack before any operation occurs.
        System.out.println("The items present in the stack are as follows:");
        View();

        while (!Exit){
            System.out.println("Please enter O for pop or U for push.");
            System.out.println("Please enter E to exit the program.");
            System.out.println("Please enter N to see the stack.");
            Choice = myObj.next();
            if (Objects.equals(Choice, "O")) {
                item = Pop();
                System.out.println("The item popped from the stack is " + item);
            } else if (Objects.equals(Choice, "U")){
                System.out.println("Please enter the item you would like to push onto the stack.");
                item = myObj.nextInt();
                Push(item);
            } else if (Objects.equals(Choice, "N")) {
                View();
            } else if (Objects.equals(Choice, "E")) {
                Exit = true;
            }
        }
    }
    //The function for Pop in Stacks. Pop removes items from the stack.
    public static int Pop () {
        int Item = -1;
        if (TopPointer == BasePointer - 1) {
            System.out.println("The stack is empty, so we cannot pop any item.");
        } else {
            Item = Stack[TopPointer];
            Stack[TopPointer] = 0;
            TopPointer = TopPointer - 1;
            System.out.println("The item was successfully popped.");
        }
        return Item;
    }
    //The procedure for Push in Stacks. Push adds items into the stack at the top of it; like a stack.
    public static void Push (int Item) {
        if (TopPointer < StackFull - 1){
            TopPointer = TopPointer + 1;
            Stack[TopPointer] = Item;
            View();
        } else {
            System.out.println("The stack is full, so it cannot push.");
        }
    }
    //Viewing the stack.
    public static void View (){
        System.out.println("The stack is as follows.");
        for (index = 9; index >= 0; index--){
            System.out.println(Stack[index]);
        }
    }
}