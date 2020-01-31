package nhon_p1;
// Turn the string into an array
// switch the first and third numbers
// then the second and fourth 
// after go through and add 3 to each digit and divide each by 10 an getting the remainder 
public class Decrypter {

	public static int[] Decrypt(String usernum) {
		String[] usernumSplit = usernum.split("");
		int len = usernumSplit.length;
		int[] usernumArr = new int[len];
		for(int i = 0; i < len; i++) {
			usernumArr[i] = Integer.parseInt(usernumSplit[i]);
		}
		int temp = usernumArr[0];
		usernumArr[0] = usernumArr[2];
		usernumArr[2] = temp;
		temp  = usernumArr[1];
		usernumArr[1] = usernumArr[3];
		usernumArr[3] = temp;
		for(int i = 0; i < len; i++) {
			usernumArr[i] = (usernumArr[i] + 3) % 10;
		}
		return usernumArr;
	}

}
