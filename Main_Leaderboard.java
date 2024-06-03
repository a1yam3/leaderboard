import java.io.*;
import java.util.Scanner;

class Player//to create player object that has the variables of name and score of the player
{
	int score;
	String name;

	Player(String na, int sc){//constructor to declare name and score
		name=na;
		score=sc;
	}
	
	int getScore(){ //to return name of a particular player
	return score;	
	}

	String getName(){ //to return score of a particular player
	return name;
	}
}

 
class Node// Creates node in linked list
{
	Player player;//player object stored in node 
	Node next;//user defined variable for represnting next node

	Node(Player pl){ //constructor to declare player and next
	player=pl;
	next= null;
	}
}

class Leaderboard //to create leaderboard
{
	Node head;
	Leaderboard()// intialize and declares head to null
	{
	head=null;
	}

	void add_player(Player player) // adds player while taking in the object player through the parameter
	{
    		Node temp = new Node(player);//temporary node 
    		Node t = head; //temporary variable that represents the head
    			if (head == null || player.getScore() > head.player.getScore()) // to insert node if the list empty or when a head node is inserted
			{
        			temp.next = head;
        			head = temp;
    			} 
			else 
			{
        			while (t != null && player.getScore() < t.next.player.getScore()) { // to insert a node if list is filled beyond the first position of list 
            			t = t.next;
        			}
        			temp.next = t.next;
        			t.next = temp;
    			}
	}


	public void delete(String plNa)// uses of the name of the player to be deleted 
	{
    		if (head == null)// checks if the list is empty 
		{
        	System.out.println("Leaderboard is empty.");
        	return;
    		}

    
    		if (head.player.getName().equals(plNa)) // if the first element of list is the same as the input variable
		{
        		head = head.next; //to delete the the node
        		System.out.println("Player '" + plNa + "' deleted from leaderboard.");
    		}

    		Node t = head;
    			while (t.next != null) { // if the name is in the list beyond
        		if (t.next.player.getName().equals(plNa)) 
			{
            		t.next = t.next.next; // deletes the node
            		System.out.println("Player '" + plNa + "' deleted from leaderboard.");
           		return;
        		}
        		t = t.next;
    			}

    		System.out.println("Player '" + plNa + "' not found in the leaderboard.");
	}
	

 	public void update(String plaNa, Player p) { //uses variable for old name and an object with the new name and score 
    		Node t = head;
		
		if (head.player.getName().equals(plaNa)) 
		{
        		t.player= p;
            		System.out.println("Player '" + plaNa + "' updated successfully.");
            		return;
	
    		}

    		while (t != null) 
		{
        		if (t.player.getName().equals(plaNa)) 
			{
            		t.player= p;
            		System.out.println("Player '" + plaNa + "' updated successfully.");
            		return;
        		}
        		t = t.next;
 		}
		
		System.out.println("Player '" + plaNa + "' not found in the leaderboard.");
    		
	}

	public void display() // displays leaderboard
	{
    		System.out.println("Leaderboard:");
    		Node t = head;
    		int rank = 1;
 		while (t != null) {
		System.out.println(rank + ". " + t.player.getName() + " - " + t.player.getScore());
        	t = t.next;
        	rank++;
    		}
	}
	
  	
}


class Main_LeaderBoard
{
	public static void main(String[] args)
	{
		Leaderboard obj=new Leaderboard();//calls object for the Leaderboard class
		Scanner in=new Scanner(System.in);
		
        	
		boolean flag=true; // indicator to end while loop 
		while(flag) {      //while flag is true

            		System.out.println("Leaderboard options");	//Displays leaderboard options
			System.out.println("1. Add Player  2. Delete Player  3. Display Leaderboard  4.Update Name and Score  0. Exit");
            
            		System.out.print("Enter your choice: ");  	
            		int choice = in.nextInt(); // only int values for imput of choice of user
            
			switch (choice) {	// switch case for the each options
			case 1:
                    		System.out.println("Enter Player name: "); // propmt to input name of player
				String plNa = in.next(); // Read the entire line including spaces of the input
				//in.nextLine(); // Consume newline character 
				System.out.println("Enter Player score: ");//prompt to input score
				int plSc = in.nextInt(); // stores and reads input value
				
                    		
                    		Player play = new Player(plNa, plSc); // creates object for class player and inputs name and score of new player
				
                    		obj.add_player(play); //calls add_player function and passes play object through the parameter
                    		System.out.println("Player added successfully.");
				System.out.println("");
                    		break;

			case 2:
				System.out.println("Enter Player name to be deleted from leaderboard: ");
				in.nextLine();//consume newline character
				String pNa = in.nextLine();// stores and reads input 

				obj.delete(pNa);//calls delete function and passes variable through the parameter 
				System.out.println("Name successfully deleted");
				System.out.println("");
				break;
		
                	case 3:
                    		obj.display();//calls display function
				System.out.println("");				
                    		break;
			
			case 4: 
				System.out.println("Enter the name to be updated "); // prompt to input old name
    				String oldname = in.next();// stores and reads input
       				System.out.println("Enter the updated name");// prompt to input updated name
        			String newname = in.nextLine(); //stores and reads new name
        			System.out.println("Enter the new score"); //prompt to input the new score
        			int newscore = in.nextInt();//stores and reads new name

    
        			Player play1 = new Player(newname, newscore);// creates new object for the new name and score
        			obj.update(oldname, play1);// calls update function and passes the variable for the old name and object for the new anme and score
        			System.out.println();
        			obj.display(); //calls display fuction to display updated leaderboard
        			System.out.println();
        			break;
                	case 0:
                   		System.out.println("Exiting the program.");
                    		flag=false;
				break;

                	default:
                    	System.out.println("Invalid choice.");
            		}
        	} 
	}
}


