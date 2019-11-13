package apps;

import adts.Project3;
import videoGame.VideoGame;

public class SystemTest {
	
	public static void main(String[] args) {
		
		Project3<String> myList = new Project3();
		
		System.out.println("The Test Results:");
		
		//Test the isEmpty
		System.out.println("Is the list empty?: " +myList.isEmpty());
		
		//Test the add
		myList.add("dog");
		myList.add("cat");
		myList.add("bird");
		myList.add("chicken");
		myList.add("dolphin");
		myList.add("ferret");
		myList.add("elephant");
		myList.add("hamster");
		myList.add("lemur");
		myList.add("axolotl");
		
		//Test the resetIterator
		//As expected myList.getNextItem(); does not work when run before resetIterator
		
		//myList.getNextItem();
		myList.resetIterator();
		myList.getNextItem();
		System.out.println();
		
		//Print the list
		System.out.println("The list: "+ myList);
		System.out.println();
		
		//Test the get when it is on the list
		String getTheLemur= myList.get("lemur");
		System.out.println("Grab the lemur when it is there: "+getTheLemur);

		//Test the isEmpty
		System.out.println("Is the list empty?: "+ myList.isEmpty());

		System.out.println();

		//Test the remove
		myList.remove("chicken");
		System.out.println("Is chicken removed from the list?: "+myList);
		myList.remove("axolotl");
		System.out.println("Is axolotl removed from the list?: "+myList);
		myList.remove("lemur");
		System.out.println("Is lemur removed from the list?: "+myList);
		myList.remove("zebra");
		System.out.println("Is zebra removed from the list?: "+myList);
		
		System.out.println();
		
		//Test the get when it is not on the list
		String getTheLemur2= myList.get("lemur");
		System.out.println("Grab the lemur when it is gone: "+getTheLemur2);
		
		System.out.println();
		
		//Test the contains
		System.out.println("Is dog on the list?: "+ myList.contains("dog"));
		System.out.println("Is chicken on the list?: "+ myList.contains("chicken"));
		
		//Test the resetIterator
		System.out.println("Test the resetIterator: ");
		myList.resetIterator();
		int i =0;
		System.out.println(myList.size());
		
		//Can't seem to get a while loop to work here. Am I missing something?
		
		for(i=0; i <  (myList.size()*2); i++) {
			System.out.println(myList.getNextItem());
		}
		
		System.out.println(myList.getNextItem());
		System.out.println(myList.getNextItem());
		System.out.println(myList.getNextItem());
		myList.resetIterator();
		myList.resetBackIterator();
		System.out.println(myList.getNextItem());
		System.out.println(myList.getPrevItem());
		System.out.println(myList.getPrevItem());
		
		System.out.println("The list from tail to head: "+myList.gnirtSot());
		
		System.out.println();
		System.out.println();

		
		//Test the VideoGame
		VideoGame RE2 = new VideoGame("Resident Evil 2", 'M', 37.99f);
		VideoGame RE2v2 = new VideoGame("Resident Evil 2", 'M', 37.99f);
		VideoGame RE21111 = new VideoGame("Resident Evil 2", 'M', 11.11f);
		VideoGame RE25555 = new VideoGame("Resident Evil 2", 'M', 55.55f);
		VideoGame Tetris = new VideoGame("Tetris", 'E', 29.99f);
		VideoGame K0 = new VideoGame("Katana ZERO", 'M', 14.99f);
		VideoGame SuperMarioMaker2 = new VideoGame("Super Mario Maker 2", 'E', 57.25f);
		VideoGame CoD2 = new VideoGame("Call of Duty 2", 'T', 6.43f);
		VideoGame LegoBatman = new VideoGame("Batman",'E', 23.45f);
		

		System.out.println(RE2);
		System.out.println(Tetris);
		
		System.out.println(
				"RE2 vs. LegoBatman: " + RE2.compareTo(LegoBatman));
		System.out.println(
				"RE2 vs. RE25555: " + RE2.compareTo(RE25555));
		System.out.println(
				"RE2 vs. RE2v2: " + RE2.compareTo(RE2v2));
		System.out.println(
				"RE2 vs. RE21111: " + RE2.compareTo(RE21111));
		
	}


}
