import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;

import org.graphstream.algorithm.TarjanStronglyConnectedComponents;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;

public class GraphStream {

	public static void main(String[] args) throws IOException {

		GraphStream gs = new GraphStream();
		File file = new File("TweetData/tweetsWithoutStopwords_partial50.txt");
		
		ArrayList<String> tweets = new JsonParser().parseTextFile(file);

		gs.drawGraph(tweets);
	}

	public void drawGraph(ArrayList<String> tweets) {
		Graph graph = new MultiGraph("g");
		
		// String[] tweets = { };
		// "Min systers pojkv�n �r diabetiker, och n�r han tog insulin sk�mtade jag om att det var heroin. Min syster blev j�ttearg o�",
		// "Tack alla ssk som kom till @ssdf12diabetes utbildningskv�ll om diabetes. Ni �r v�ra vardagshj�ltar! #diabetesdebatt",
		// "Tack Linda Kjerr och g�nget fr�n  \"Akademiskt specialistcentrum f�r diabetes\" f�r en inspirerande beskrivning av er�",
		// "Usch, tungt! :( Att tvingas t�nka om �r jobbigt. Men for what its worth, det beh�ver inte vara s� dr�",
		// "Typ 1-diabetes: Flera f�rdelar med tidig diagnos",
		// "\"Fr�n v�rd p� piedestal till v�rd med delaktighet.\", s�ger @aknergardh Viktigt och sj�lvklart tycker vi p�",
		// "H�lso- och sjukv�rdspersonal kan hj�lpa sina patienter med #diabetes som v�ljer att fasta genom att dela denna video https:�",
		// "Vet du hur du ska r�da dina patienter med diabetes som v�ljer att fasta? Klicka p� l�nken nedan f�r att dela med en� ",
		// "Det finns intressanta f�rslag i delbet�nkandet som @aknergardh l�mna idag. Vi vill specifikt lyfta fram f�rslagen om sy�",
		// "Prim�rv�rden navet i en personcentrerad v�rd - om @aknergardh delbet�nkande",
		// "L�ngsiktig viktuppg�ng kan i vissa fall f�rklaras av nedsatt f�rm�ga att oms�tta fett, visar en ny studie fr�n Karo",
		// "N�r l�karen en tr�ffat en g�ng tidigare talar till en som om man haft diabetes i mindre �n ett halv�r, fast man har",
		// "Prim�rv�rden navet i en personcentrerad v�rd - om @aknergardh delbet�nkande",
		// "Det finns intressanta f�rslag i delbet�nkandet som @aknergardh l�mna idag. Vi vill specifikt lyfta fram f�rslagen om sy",
		// "Pa Dibba ger pengar till Barndiabetesfonden" };
		
		ArrayList<String> allWords = new ArrayList<>();
		ArrayList<Node> tweetNodes = new ArrayList<>();
		
		for(int tweetId = 0; tweetId < tweets.size(); tweetId ++) {
			ArrayList<String> uniqueTweetWords = new ArrayList<>();
			
//			Node tweetNode  = graph.addNode("tId" + tweetId);
//			tweetNodes.add(tweetNode);
			// tweetNode.addAttribute("ui.style", "shape:circle;fill-color: red;size: 5px;");
			// tweetNode.addAttribute("ui.label", tweetId);
			String[] words = tweets.get(tweetId).split(" ");
			for(String word : words) {
				
				
				for(String word2 : words) {
					if(!allWords.contains(word2)) {
						allWords.add(word2);
						Node wordNode = graph.addNode(word2);
//						 wordNode.addAttribute("ui.label", word2);
						 wordNode.addAttribute("ui.style", "shape:circle;fill-color: blue;size: 5px;");
					}
					if(graph.getEdge(word + word2) == null) {
						graph.addEdge(word + word2, word, word2);
					}
				}		
				
//				if(!uniqueTweetWords.contains(word)) {
//					uniqueTweetWords.add(word);
//					}
//				}
			}
		}

		TarjanStronglyConnectedComponents tscc = new TarjanStronglyConnectedComponents();
		tscc.init(graph);
		tscc.compute();
	
		graph.display();
	}
}
