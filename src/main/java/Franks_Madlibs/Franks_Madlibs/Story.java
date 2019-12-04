package Franks_Madlibs.Franks_Madlibs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Story {

	private String story = "";
	private List<Prompt> prompts = new ArrayList<>();
	
//	public void getStoryFromUser() {
//		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Please type the name of a story you would like to play: ");
//		File directoryPath = new File("/workspace/FrankPerri-java/Franks-Madlibs");
//		File[] files = directoryPath.listFiles(new FilenameFilter() {
//			
//			public boolean accept(File dir, String name) {
//				return name.endsWith(".txt");
//			}
//		});
//		
//		for (File file : files) {
//			System.out.println(file.getName());
//		}
//		
//		System.out.println();
//		
//		String inputFileName = scanner.nextLine();
//		
//	}
	
	public String getStory() throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(new File("disney_world_story.txt"));
		while(scanner.hasNextLine()) {
			story += scanner.nextLine();
		}
		
		return story;
	}


//	public void setStory(String story) {	
//		this.story = story;
//	}


	public void storyPrompts() throws FileNotFoundException {

		Scanner scanner = new Scanner(System.in);

		int beginPrompt = 0;
		int endPrompt = 0;
		String storyText = getStory();

		while(beginPrompt != -1) {
			beginPrompt = storyText.indexOf("<<", beginPrompt + 1);
			if(beginPrompt == -1) {
				break;
			}
			endPrompt = storyText.indexOf(">>", beginPrompt) + 1;
			String message = storyText.substring(beginPrompt + 2, endPrompt -1);
			Prompt prompt = new Prompt();
			prompt.setMessage(message);
			prompt.setStartOfReplacement(beginPrompt);
			prompt.setEndOfreplacement(endPrompt + 2);
			prompts.add(prompt);
//			System.out.println(beginPrompt + ":" + endPrompt + ":" + message);
		}
		
		for (Prompt prompt : prompts) {
			System.out.println(prompt.getMessage());
			prompt.setResponse(scanner.nextLine());
		}
		scanner.close();
		
	}
	
	public void tellStory() throws FileNotFoundException {
		String toldStory = "";
		int start = 0;
		for(Prompt prompt : prompts) {
			toldStory += story.substring(start, prompt.getStartOfReplacement());
			toldStory += prompt.getResponse();
			start = prompt.getEndOfreplacement();
			
		}
		System.out.println(toldStory);
		
	}
	
}
