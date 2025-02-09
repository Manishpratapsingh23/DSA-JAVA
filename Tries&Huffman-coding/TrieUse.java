import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrieUse {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	
	public static void main(String[] args) throws IOException{
		Trie t = new Trie();
		System.out.println("Press \n 1. insert \n 2. search \n 3. delete \n 4. Total Words \n 5. Print Words");
        System.out.println("Enter choice");
        int choice = Integer.parseInt(br.readLine());
		while(choice != -1) {
			switch(choice) {
				case 1 -> {
                                    // insert
                                    String word=br.readLine();
                                    t.add(word);
                        }
				case 2 -> {
                            // search
                            String word = br.readLine();
                            System.out.println(t.search(word));
                        }
				case 3 -> {
					String word = br.readLine();
					t.delete(word);
				}
				case 4 -> {
					System.out.println("Total Words: "+t.countWords());
					break;
				}
				case 5 ->{
					System.out.println("Words are: ");
					t.print();
				}
				default -> {
					break;
                        }
			}
            choice=Integer.parseInt(br.readLine());
		}
	}

}
/*
1 there 1 their 2 the 2 there 2 theres
 */