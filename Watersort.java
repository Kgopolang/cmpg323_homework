
/**
 * Write a description of class Watersort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class Watersort
{
    private static StackAsMyArrayList <Character> bottlesArr[] = new StackAsMyArrayList[5];

    //static Character green = new Character('g');
    static Character red = new Character('r');
    static Character blue = new Character('b');
    static Character yellow = new Character('y');

    static StackAsMyArrayList<Character> bottle0 = new StackAsMyArrayList<Character>();
    static    StackAsMyArrayList<Character> bottle1 = new StackAsMyArrayList<Character>();
    static    StackAsMyArrayList<Character> bottle2 = new StackAsMyArrayList<Character>();
    static    StackAsMyArrayList<Character> bottle3 = new StackAsMyArrayList<Character>();
    static    StackAsMyArrayList<Character> bottle4 = new StackAsMyArrayList<Character>();

    public static void main(String [] args)
    {
        //filling first 3 bottles with the same colour
        for(int i =1;i<5;i++)
        {
            bottle0.push(red);
            bottle1.push(yellow);
            bottle2.push(blue);
        }

        //mixing up colours
        for(int i = 0; i<20;i++)
        {
            Random num =new Random();
            int randNumber = 1 + num.nextInt(6);

            if(randNumber == 1)
            {
                if(bottle0.getStackSize() != 0 && bottle4.getStackSize()!=4)
                {
                    bottle4.push(bottle0.pop());
                }
                else
                {
                    randNumber = 1 + new Random().nextInt(6);
                }
            }

            if(randNumber == 2)
            {
                if(bottle2.getStackSize() != 0 && bottle4.getStackSize()!=4)
                {
                    bottle4.push(bottle2.pop());
                }
                else
                {
                    randNumber = 1 + new Random().nextInt(6);
                }
            }

            if(randNumber == 3)
            {
                if(bottle3.getStackSize() != 0 && bottle4.getStackSize()!=4)
                {
                    bottle4.push(bottle3.pop());
                }
                else
                {
                    randNumber = 1 + new Random().nextInt(6);
                }
            }

            if(randNumber == 4)
            {
                if(bottle3.getStackSize() != 0 && bottle4.getStackSize()!=4)
                {
                    bottle4.push(bottle3.pop());
                }
                else
                {
                    randNumber = 1 + new Random().nextInt(6);
                }
            }

            if(randNumber == 5)
            {
                if(bottle4.getStackSize() != 0 && bottle1.getStackSize()!=4)
                {
                    bottle1.push(bottle4.pop());
                }
                else
                {
                    randNumber = 1 + new Random().nextInt(6);
                }
            }

            if(randNumber == 6)
            {
                if(bottle1.getStackSize() != 0 && bottle3.getStackSize()!=4)
                {
                    bottle3.push(bottle1.pop());
                }
                else
                {
                    randNumber = 1 + new Random().nextInt(6);
                }
            }
        }     
        //Filling the Bottles array
        bottlesArr[0]=bottle0;
        bottlesArr[1]=bottle1;
        bottlesArr[2]=bottle2;
        bottlesArr[3]=bottle3;
        bottlesArr[4]=bottle4;

        play();
        //showAll();
    }

    public static void showAll()
    {
        for (int i = 0;i < 5;i++)
        {
            System.out.println("Bottle " + i + ": "+ bottlesArr[i].toString());
        }   
    }

    public static void play()
    {

        Scanner input = new Scanner (System.in);

        showAll();

        System.out.println("Enter the source bottle");
        int source = input.nextInt();
        System.out.println("Enter the target bottle");
        int target = input.nextInt();

        while(!solved(bottlesArr))
        {

            if(source <= 4 && target <= 4)
            {
                if( source == 0)
                {

                    if(target==0)
                    {
                        System.out.println("Cannot move into the same bottle.");
                        showAll();
                        System.out.println("Enter the source bottle");
                        source = input.nextInt();

                        System.out.println("Enter the target bottle");
                        target = input.nextInt();
                    }
                    else if(target==1)
                    {
                        if(bottle1.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle1.peek()!= bottle0.peek())
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle1.getStackSize() < 4 && bottle1.peek()== bottle0.peek() || bottle1.getStackSize() == 0)
                        {
                            while(bottle1.peek()== bottle0.peek())
                            {
                                bottle1.push(bottle0.pop());
                            }

                        }
                        showAll();
                    }
                    else if(target==2)
                    {
                        if(bottle2.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle2.peek()!= bottle0.peek())
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle2.getStackSize() < 4 && bottle2.peek()== bottle0.peek() || bottle2.getStackSize() == 0)
                        {
                            bottle2.push(bottle0.pop());
                            while(bottle2.peek()== bottle0.peek())
                            {
                                bottle2.push(bottle0.pop());
                            }

                        }
                        showAll();
                    }
                    else if(target == 3)
                    { 
                        if(bottle3.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle3.peek()!= bottle0.peek())
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle3.getStackSize() < 4 && bottle3.peek()== bottle0.peek() || bottle3.getStackSize() == 0)
                        {
                            bottle3.push(bottle0.pop());
                            while(bottle3.peek()== bottle0.peek())
                            {
                                bottle3.push(bottle0.pop());
                            }

                        }
                        showAll();
                    }
                    else 
                    {
                        if(bottle4.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle4.peek()!= bottle0.peek())
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle4.getStackSize() < 4 && bottle4.peek()== bottle0.peek() || bottle4.getStackSize() == 0)
                        {
                            bottle4.push(bottle0.pop());
                            while(bottle4.peek()== bottle0.peek())
                            {
                                bottle4.push(bottle0.pop());
                            }

                        }
                        showAll();
                    }

                }        

                else if(source == 1)
                {
                    if(target==0)
                    {
                        if(bottle0.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle0.peek()!= bottle1.peek())
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle0.getStackSize() < 4 && bottle0.peek()== bottle1.peek() || bottle0.getStackSize() == 0)
                        {
                            bottle0.push(bottle1.pop());
                            while(bottle0.peek()== bottle1.peek())
                            {
                                bottle0.push(bottle1.pop());
                            }

                        }
                        showAll();

                    }
                    else if(target==1)
                    {
                        System.out.println("Cannot move into the same bottle.");
                        showAll();
                        System.out.println("Enter the source bottle");
                        source = input.nextInt();

                        System.out.println("Enter the target bottle");
                        target = input.nextInt();
                    }
                    else if(target==2)
                    {

                        if(bottle2.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle2.peek()!= bottle1.peek())
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle2.getStackSize() < 4 && bottle2.peek()== bottle1.peek() || bottle2.getStackSize() == 0)
                        {
                            bottle2.push(bottle1.pop());
                            while(bottle2.peek()== bottle1.peek())
                            {
                                bottle2.push(bottle1.pop());
                            }

                        }
                        showAll();
                    }
                    else if(target == 3)
                    {

                        if(bottle3.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle3.peek()!= bottle1.peek())
                        {
                            System.out.println("Colours do not match");
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle3.getStackSize() < 4 && bottle3.peek()== bottle1.peek() || bottle3.getStackSize() == 0)
                        {
                            bottle3.push(bottle1.pop());
                            while(bottle3.peek()== bottle1.peek())
                            {
                                bottle3.push(bottle1.pop());
                            }

                        }
                        showAll();
                    }
                    else
                    {

                        if(bottle4.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle4.peek()!= bottle1.peek())
                        {
                            System.out.println("Colours do not match");
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle4.getStackSize() < 4 && bottle4.peek()== bottle2.peek() || bottle4.getStackSize() == 0)
                        {
                            bottle4.push(bottle1.pop());
                            while(bottle4.peek()== bottle1.peek())
                            {
                                bottle4.push(bottle1.pop());
                            }

                        }
                        showAll();
                    } 

                }
                else if (source == 2)
                {
                    if(target==0)
                    {
                        if(bottle0.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle0.peek()!= bottle2.peek())
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle0.getStackSize() < 4 && bottle0.peek()== bottle2.peek() || bottle0.getStackSize() == 0)
                        {
                            bottle0.push(bottle2.pop());
                            while(bottle0.peek()== bottle2.peek())
                            {
                                bottle0.push(bottle2.pop());
                            }

                        }
                        showAll();

                    }
                    else if(target==1)
                    {
                        if(bottle1.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle1.peek()!= bottle2.peek())
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle1.getStackSize() < 4 && bottle1.peek()== bottle2.peek() || bottle1.getStackSize() == 0)
                        {
                            bottle1.push(bottle2.pop());
                            while(bottle1.peek()== bottle2.peek())
                            {
                                bottle1.push(bottle2.pop());
                            }

                        }
                        showAll();
                    }
                    else if(target==2)
                    {
                        System.out.println("Cannot move into the same bottle.");
                        showAll();
                        System.out.println("Enter the source bottle");
                        source = input.nextInt();

                        System.out.println("Enter the target bottle");
                        target = input.nextInt();
                    }
                    else if(target == 3)
                    {
                        if(bottle3.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle3.peek()!= bottle2.peek())
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle3.getStackSize() < 4 && bottle3.peek()== bottle2.peek() || bottle3.getStackSize() == 0)
                        {
                            bottle3.push(bottle2.pop());
                            while(bottle3.peek()== bottle2.peek())
                            {
                                bottle3.push(bottle2.pop());
                            }

                        }
                        showAll();
                    }
                    else
                    {
                        if(bottle4.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle4.peek()!= bottle2.peek())
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle4.getStackSize() < 4 && bottle4.peek()== bottle2.peek() || bottle4.getStackSize() == 0)
                        {
                            bottle4.push(bottle2.pop());
                            while(bottle4.peek()== bottle2.peek())
                            {
                                bottle4.push(bottle2.pop());
                            }

                        }
                        showAll();
                    } 

                }
                else if (source == 3)
                {
                    if(target==0)
                    {
                        if(bottle3.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle0.peek()!= bottle3.peek())
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle0.getStackSize() < 4 && bottle0.peek()== bottle3.peek() || bottle0.getStackSize() == 0)
                        {
                            bottle0.push(bottle3.pop());
                            while(bottle0.peek()== bottle3.peek())
                            {
                                bottle0.push(bottle3.pop());
                            }

                        }
                        showAll();
                    }
                    else if(target==1)
                    {
                        if(bottle1.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle1.peek()!= bottle3.peek())
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle1.getStackSize() < 4 && bottle1.peek()== bottle3.peek() || bottle1.getStackSize() == 0)
                        {
                            bottle1.push(bottle3.pop());
                            while(bottle1.peek()== bottle3.peek())
                            {
                                bottle1.push(bottle3.pop());
                            }

                        }
                        showAll();
                    }
                    else if(target==2)
                    {
                        if(bottle2.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle2.peek()!= bottle3.peek())
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle2.getStackSize() < 4 && bottle2.peek()== bottle3.peek() || bottle2.getStackSize() == 0)
                        {
                            bottle2.push(bottle3.pop());
                            while(bottle2.peek()== bottle3.peek())
                            {
                                bottle2.push(bottle3.pop());
                            }

                        }
                        showAll();
                    }
                    else if(target == 3)
                    {

                        System.out.println("Cannot move into the same bottle.");
                        showAll();
                        System.out.println("Enter the source bottle");
                        source = input.nextInt();

                        System.out.println("Enter the target bottle");
                        target = input.nextInt();
                    }
                    else
                    {
                        if(bottle4.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle4.peek()!= bottle3.peek())
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle4.getStackSize() < 4 && bottle4.peek()== bottle3.peek() || bottle4.getStackSize() == 0)
                        {
                            bottle4.push(bottle3.pop());
                            while(bottle4.peek()== bottle3.peek())
                            {
                                bottle4.push(bottle3.pop());
                            }

                        }
                        showAll();
                    } 

                }
                else
                {
                    if(target==0)
                    {
                        if(bottle0.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle0.peek()!= bottle4.peek())
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle0.getStackSize() < 4 && bottle0.peek()== bottle4.peek() || bottle0.getStackSize() == 0)
                        {
                            bottle0.push(bottle4.pop());
                            while(bottle0.peek()== bottle4.peek())
                            {
                                bottle0.push(bottle4.pop());
                            }

                        }
                        showAll();
                    }
                    else if(target==1)
                    {

                        if(bottle1.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle1.peek()!= bottle4.peek())
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle1.getStackSize() < 4 && bottle1.peek()== bottle4.peek() || bottle1.getStackSize() == 0)
                        {
                            bottle1.push(bottle4.pop());
                            while(bottle1.peek()== bottle4.peek())
                            {
                                bottle1.push(bottle4.pop());
                            }

                        }
                        showAll();
                    }
                    else if(target==2)
                    {

                        if(bottle2.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle2.peek() != bottle4.peek() )
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle2.getStackSize() < 4 && bottle2.peek()== bottle4.peek() || bottle2.getStackSize() == 0)
                        {
                            bottle2.push(bottle4.pop());
                            while(bottle2.peek()== bottle4.peek())
                            {
                                bottle2.push(bottle4.pop());
                            }

                        }
                        showAll();
                    }
                    else if(target == 3)
                    {

                        if(bottle3.getStackSize()>3)
                        {
                            System.out.println("Target is full!");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }
                        if(bottle3.peek()!= bottle4.peek())
                        {
                            System.out.println("Colours do not match");
                            showAll();
                            System.out.println("Enter the source bottle");
                            source = input.nextInt();

                            System.out.println("Enter the target bottle");
                            target = input.nextInt();
                        }

                        if(bottle3.getStackSize() < 4 && bottle3.peek()== bottle4.peek() || bottle3.getStackSize() == 0)
                        {
                            bottle3.push(bottle4.pop());
                            while(bottle3.peek()== bottle4.peek())
                            {
                                bottle3.push(bottle4.pop());
                            }

                        }
                        showAll();
                    }
                    else
                    {

                        System.out.println("Cannot move into the same bottle.");
                        showAll();
                        System.out.println("Enter the source bottle");
                        source = input.nextInt();

                        System.out.println("Enter the target bottle");
                        target = input.nextInt();
                    } 

                }
            }
            else
            {
                System.out.println("Incorrect Input:please enter numbers from 0-1");
                showAll();
                System.out.println("Enter the source bottle");
                source = input.nextInt();

                System.out.println("Enter the target bottle");
                target = input.nextInt();
            }

            System.out.println("Enter the source bottle");
            source = input.nextInt();

            System.out.println("Enter the target bottle");
            target = input.nextInt();

        }

        System.out.println("Congratulations, you have won!");
        showAll();
    }

    public static boolean solved(StackAsMyArrayList bottlesArr[])
    {
        boolean checker = true;

        for(int i =0;i<bottlesArr.length;i++)
        {
            checker = bottlesArr[i].checkStackUniform();
            if(!checker)
            {
                break;
            }
        }
        return checker;

    }

}

