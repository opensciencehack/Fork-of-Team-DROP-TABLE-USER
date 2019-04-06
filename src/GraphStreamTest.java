import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.graphstream.algorithm.TarjanStronglyConnectedComponents;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;

public class GraphStreamTest {

	
	public static void main(String[] args) {
		Graph graph = new MultiGraph("g");
		
		String[] tweets = {
		"Min systers pojkvän är diabetiker, och när han tog insulin skämtade jag om att det var heroin. Min syster blev jättearg o…",
		"Tack alla ssk som kom till @ssdf12diabetes utbildningskväll om diabetes. Ni är våra vardagshjältar! #diabetesdebatt",
		"Tack Linda Kjerr och gänget från  \"Akademiskt specialistcentrum för diabetes\" för en inspirerande beskrivning av er…",
		"Usch, tungt! :( Att tvingas tänka om är jobbigt. Men for what its worth, det behöver inte vara så dr…",
		"Typ 1-diabetes: Flera fördelar med tidig diagnos",
		"\"Från vård på piedestal till vård med delaktighet.\", säger @aknergardh Viktigt och självklart tycker vi på…",
		"Hälso- och sjukvårdspersonal kan hjälpa sina patienter med #diabetes som väljer att fasta genom att dela denna video https:…",
		"Vet du hur du ska råda dina patienter med diabetes som väljer att fasta? Klicka på länken nedan för att dela med en… ",
		"Det finns intressanta förslag i delbetänkandet som @aknergardh lämna idag. Vi vill specifikt lyfta fram förslagen om sy…",
		"Primärvården navet i en personcentrerad vård - om @aknergardh delbetänkande",
		"Långsiktig viktuppgång kan i vissa fall förklaras av nedsatt förmåga att omsätta fett, visar en ny studie från Karo",
		"När läkaren en träffat en gång tidigare talar till en som om man haft diabetes i mindre än ett halvår, fast man har",
		"Primärvården navet i en personcentrerad vård - om @aknergardh delbetänkande",
		"Det finns intressanta förslag i delbetänkandet som @aknergardh lämna idag. Vi vill specifikt lyfta fram förslagen om sy",
		"Pa Dibba ger pengar till Barndiabetesfonden" };
		
		ArrayList<String> allWords = new ArrayList<>();
		ArrayList<Node> tweetNodes = new ArrayList<>();
		
		for(int tweetId = 0; tweetId < tweets.length; tweetId ++) {
		ArrayList<String> uniqueTweetWords = new ArrayList<>();
		
			Node tweetNode  = graph.addNode("" + tweetId);
			tweetNodes.add(tweetNode);
			tweetNode.addAttribute("ui.label", tweetId);
			String[] words = tweets[tweetId].split(" ");
			for(String word : words) {
				if(!allWords.contains(word)) {
					allWords.add(word);
					Node wordNode = graph.addNode(word);
					wordNode.addAttribute("ui.label", word);
				}
				if(!uniqueTweetWords.contains(word)) {
					uniqueTweetWords.add(word);
					graph.addEdge(tweetId + word, "" + tweetId, word);
				}
			}
		}
		

		graph.display();
		
		TarjanStronglyConnectedComponents tscc = new TarjanStronglyConnectedComponents();
		tscc.init(graph);
		tscc.compute();
	
	}
}
