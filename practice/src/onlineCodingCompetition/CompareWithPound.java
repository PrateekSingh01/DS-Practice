package onlineCodingCompetition;

public class CompareWithPound {

	static boolean compare(String txt, String pat) {
		boolean ans = false;

		int txtIdx = txt.length() - 1;
		int patIdx = pat.length() - 1;
		int txtCounter = 0, patCounter = 0;

		while (patIdx >= 0 && txtIdx >= 0) {
			while (txt.charAt(txtIdx) == '#') {
				txtCounter++;
				txtIdx--;
			}
			while (txtCounter > 0) {
				txtIdx--;
				txtCounter--;
			}

			while (pat.charAt(patIdx) == '#') {
				patCounter++;
				patIdx--;
			}
			while (patCounter > 0) {
				patIdx--;
				patCounter--;
			}
			if (patIdx < 0 && txtIdx < 0) {
				ans = true;
			}
			if (patIdx > 0 && txtIdx > 0 && txt.charAt(txtIdx) == pat.charAt(patIdx)) {
				patIdx--;
				txtIdx--;
			} else {
				break;
			}
		}

		System.out.println(ans);
		return ans;
	}

	public static void main(String[] args) {
		compare("AA##BCAS#", "B#BCA");
	}

}
