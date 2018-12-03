
public class StringOperation {
	private String text;
	
	StringOperation(){}
	
	StringOperation(String text){
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void display(){
		System.out.println(text);
	}

	public boolean isDigit(){
		
		char[] c = new char[text.length()];
		
		for (int i = 0; i < c.length; i++) 
		{
			c[i] = text.charAt(i);
			if (c[i] > '0' && c[i] < '9')
			{
				return true;
			}
		}
		
		return false;
	}
	
	public int countWord(){
		
		int count = 0;
		text = text.trim();
		
		for (int i = 0; i < text.length(); i++) 
		{
			if (text.charAt(i) == ' ') count++;
		}
		
		return count + 1;
	}
	
	public int countSentence(){
		
		int count = 0;
		
		for (int i = 0; i < text.length(); i++) 
		{
			if (text.charAt(i) == '.' || text.charAt(i) == '?' || text.charAt(i) == '!') count++;
		}
		
		return count;
	}
	
	public String addString(String searchedWord){
		
		text = text.concat("\n"+searchedWord);
		return text;
	}
	
	public String deleteString(String searchedWord){
		
		text = text.replaceAll(searchedWord, " ");
		return text;
	}
	
	public void updateString(String searchedWord, String replacement){
		
		text = text.replaceAll(searchedWord, replacement);
		
	}
	
	public void searchString(String searchedWord){
		
		String[] textArray = text.split("[.?!]+");
		
		
		for (int i = 0; i < textArray.length; i++) 
		{
			String[] words = textArray[i].split(" ");
			
			for (int j = 0; j < words.length; j++) 
			{
				if (words[j].equals(searchedWord))
					System.out.println("\t" + textArray[i]);
			}
		}
		
	}
	
	public void listString(){
		display();
	}
	
	public String encrypt(int key){
		
		String newText = "";
		
		for (int i = 0; i < text.length(); i++) 
		{
			if (text.charAt(i) != ' ')
			{
				newText += (char)(text.charAt(i) + key);
			}
			else
			{
				newText += (char)text.charAt(i);
			}
		}
		
		return newText;
	}
	
	public String decrypt(int key){
		
		String newText = "";
		
		for (int i = 0; i < text.length(); i++) 
		{
			if (encrypt(key).charAt(i) != ' ')
			{
				newText += (char)(encrypt(key).charAt(i) - key);
			}
			else
			{
				newText += (char)encrypt(key).charAt(i);
			}
		}
		
		return newText;
	}
	
}


