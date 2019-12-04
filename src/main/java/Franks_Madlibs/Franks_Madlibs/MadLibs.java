package Franks_Madlibs.Franks_Madlibs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Random;
import java.util.Scanner;

public class MadLibs {

	Scanner scanner = new Scanner(System.in);
	String story;
	String name;
	String adjective1;
	String adjective2;
	String noun1;
	String noun2;
	String noun3;
	String adverb;
	String randomNums;
	Random rand = new Random();
	
	//	GETTERS
	
	public String getStory() {
		return story;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAdjective1() {
		return adjective1;
	}
	
	public String getAdjective2() {
		return adjective2;
	}
	
	public String getNoun1() {
		return noun1;
	}
	
	public String getNoun2() {
		return noun2;
	}
	
	public String getNoun3() {
		return noun3;
	}
	
	public String getAdverb() {
		return adverb;
	}
	
	public String getRandomNums() {
		return randomNums;
	}
	
	//	SETTERS
	
	public void setStory(String story) {
		this.story = story;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAdjective1(String adjective1) {
		this.adjective1 = adjective1;
	}

	public void setAdjective2(String adjective2) {
		this.adjective2 = adjective2;
	}

	public void setNoun1(String noun1) {
		this.noun1 = noun1;
	}

	public void setNoun2(String noun2) {
		this.noun2 = noun2;
	}

	public void setNoun3(String noun3) {
		this.noun3 = noun3;
	}

	public void setAdverb(String adverb) {
		this.adverb = adverb;
	}

	public void setRandomNums() {
		int num = Math.abs(rand.nextInt()) % 100;
		int index = 0;
		int[] numberHolder = new int[3];
		while(index < numberHolder.length) {
			numberHolder[index] = num + index;
			index++;
		}
		randomNums = "not " + numberHolder[0] + ", not " + numberHolder[1] + ", but " + numberHolder[2];
	}


//	Print Instructions to Player
	public void printInstructions() {
		System.out.println("Welcome to the MadLibs game. If you type in words, " 
						   + "we'll give you a story. \n\nStart by typing in a name:" );
	}

//	Get data from Player
	public void enterName() {
		setName(scanner.nextLine());
	}
	
	public void enterNoun1() {
		System.out.println("Give me a noun.");
		setNoun1(scanner.nextLine());
	}
	
	public void enterNoun2() {
		System.out.println("Give me another noun.");
		setNoun2(scanner.nextLine());
	}
	
	public void enterNoun3() {
		System.out.println("Give me the last noun!");
		setNoun3(scanner.nextLine());
	}
	
	public void enterAdjective1() {
		System.out.println("I need an adjective.");
		setAdjective1(scanner.nextLine());
	}
	
	public void enterAdjective2() {
		System.out.println("Give me another adjective.");
		setAdjective2(scanner.nextLine());
	}
	
	public void enterAdverb() {
		System.out.println("Please give me an adverb.");
		setAdverb(scanner.nextLine());
	}
	
	public void putTogetherTheStory() {
		String story;
		int num = Math.abs(rand.nextInt()) % 2;
		if (num == 0) {
			story = "Jesse and her best friend " + getName() + " went to Disney World today! \n"
					+ "They saw a " + getNoun1() + " in a show at the Magic Kingdom \n"
					+ "and ate a " + getAdjective1() + " feast for dinner. The next day I \n"
					+ "ran " + getAdverb() + " to meet Mickey Mouse in his " + getNoun2() + " \n" 
					+ "and then that night I gazed at the " + getRandomNums() + " \n" +
					getAdjective2() + " fireworks shooting from the " + getNoun3() + ".";
		} else {
			story = "Amanda and her frenemy " + getName() + " went to the zoo last summer. \n" +
					"They saw a huge " + getNoun1() + " and a tiny little " + getNoun2() + ". That night \n"
					+ "they decided to climb " + getAdverb()+ " at night, but they didn't care... \n"
					+ "until " + getRandomNums() + " " + getAdjective2() + " apes yelled in their faces, making \n"
					+ "Amanda and " + getName() + " sprint all the way back home.";
		}
		setStory(story);
	}
	
	public void play() {	
		enterName();
		enterNoun1();
		enterNoun2();
		enterNoun3();
		enterAdjective1();
		enterAdjective2();
		enterAdverb();
		setRandomNums();
		putTogetherTheStory();
		System.out.println(getStory());
	}
	
	public static void main(String[] args ) throws FileNotFoundException {
		MadLibs game = new MadLibs();
		Story story = new Story();
		story.storyPrompts();
		story.tellStory();
//		game.printInstructions();
//		game.play();
		
		
		
	}
	
}
