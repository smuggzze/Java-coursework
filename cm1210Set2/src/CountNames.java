
public class CountNames {
	public static void main( String args[] ) {
        
        String[] names = {"Tommy Lee Jones", "William Hurt", "Nicole Kidman",
            "Catherine Zeta-Jones", "JAMES EARL JONES", "Tom Hardy", 
            "Judi Dench", "Sean Bean", "Carey Mulligan", "Toby Jones" };
		int count = 0;
		for ( int item = 0; item < names.length; item++ ) {

			if ( names[item].toLowerCase().contains("jones")) {
				count++;
			}
		}
        System.out.println(count);
	}
}

