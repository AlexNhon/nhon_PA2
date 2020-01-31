package nhon_p1;
// First convert the string to an array
// then go through each value and add seven then divide the number by 10 
// and get the remainder from that result
// then switch the first and third digits with each other
// then the second and fourth digits
public class Encrypter {

	public static int[] Encrypt(String usernum) {
		String[] usernumSplit = usernum.split("");
		int len = usernumSplit.length;
		int[] usernumArr = new int[len];
		for(int i = 0; i < len; i++) {
			usernumArr[i] = Integer.parseInt(usernumSplit[i]);
		}
		for(int i = 0; i < len; i++) {
			usernumArr[i] = (usernumArr[i] + 7) % 10;
			
		}
		int temp = usernumArr[0];
		usernumArr[0] = usernumArr[2];
		usernumArr[2] = temp;
		temp  = usernumArr[1];
		usernumArr[1] = usernumArr[3];
		usernumArr[3] = temp;
		
		return usernumArr;
	}

}