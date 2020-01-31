package nhon_p1;
import java.util.Scanner;
// First ask the user for a 4 digit number
// if it is not 4 digits keep asking until they enter a valid number
// then prompt if they want to encrypt or decrypt their entered number
// after decrypting/encrypting print the number to the screen
public class Application {
	public static void main(String[] args) {
		int len = 0;
		String usernum = " ";
		Scanner getnum = new Scanner(System.in);
		
		while(len != 4){
			System.out.println("Please enter a 4 digit number:" );
			usernum = getnum.nextLine();
			len = usernum.length();
			
			if (len == 4) {
				break;
			}
			
			else if(len != 4) {
				System.out.println("Invalid Number." );
			}
		}	
		System.out.println("Your Number: " + usernum);
		Scanner getchoice = new Scanner(System.in);
		System.out.println("Press 'e' to Encrypt or 'd' to Decrypt your number:");
		char choice = getchoice.next().charAt(0); 
		while(choice != 'e' || choice != 'd') {
			if(choice == 'e' || choice == 'd') {
				break;
			}
			else {
				System.out.println("Please enter a valid choice.");
				System.out.println("Press 'e' to Encrypt or 'd' to Decrypt your number:");
				choice = getchoice.next().charAt(0); 
			}
		}
		if(choice == 'e') {
			int[] EncryptedNumber = Encrypter.Encrypt(usernum);
			System.out.printf("Encrypted Number is ");
			for(int i = 0; i < len; i++) {
				System.out.printf("" + EncryptedNumber[i]);
			}
		}
		if(choice == 'd') {
			int[] DecryptedNumber = Decrypter.Decrypt(usernum);
			System.out.printf("Decrypted Number is ");
			for(int i = 0; i < len; i++) {
				System.out.printf("" + DecryptedNumber[i]);
			}
		}
		getnum.close();
		getchoice.close();
		
	}

}
