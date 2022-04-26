package no.hvl.dat102.oppg3;

import java.util.HashSet;
import java.util.Random;
import java.util.Arrays;

public class Tidsbruk {

	public static void main(String[] args) {
		Integer[] tabell = new Integer[1_000_000];
        HashSet<Integer> hashSet = new HashSet<Integer>();

		int antElement = 100_000;
		
		
		int tall = 376;  // Her kan vi bruke eit vilkårleg tal 
		for (int i = 0; i < antElement; i++) { 
			hashSet.add(tall);
			tabell[i] = tall;
			tall = (tall + 45713) % 1_000_000; // Sjå nedanfor om 45713
		}
		
		Arrays.stream(tabell).sorted();
		
		
		Random random = new Random();
		int funnet = 0;
		
        double start = System.nanoTime();
		
		for(int i = 0; i<10_000; i++) {
			Integer n = random.nextInt(999_999);
			if(find(tabell, n)) {
				funnet+=1;
			}
			//if(hashSet.contains(n)) {
			//	funnet+=1;
			//}
		}
		System.out.println("Antall element funnet: " + funnet);
		
        double slutt = System.nanoTime();
        double tidSek = (slutt - start) / 1_000_000_000;

        System.out.println(String.format("%.2f", tidSek) + " sekunder");
	}
	
	public static boolean find(Integer[] tabell, Integer sok) {
		for(int i = 0; i < tabell.length; i++) {
			if(sok.equals(tabell[i])) {
				return true;
			}
		}
		return false;
	}
}
