public class StringPercentage {

	public static void main(String[] args) {
		String s1 = "I am dheeraj sachan coding day and night like morons";
		String s2 = "I am a retard";

		System.out.println("s1/s2 % = " + getPercentMatch(s1, s2) + "%");
	}

	static float getPercentMatch(String main, String sub) {
		int original = 0;
		int matched = 0;

		String[] mainWords = main.split(" ");
		String[] subWords = sub.split(" ");

		original = mainWords.length;

		for (int x = 0; x < mainWords.length; x++) {
			mainWords[x] = mainWords[x].trim();
		}

		for (int x = 0; x < subWords.length; x++) {
			for (int y = 0; y < mainWords.length; y++) {
				if (mainWords[y].trim().equals(subWords[x].trim()))
				{
					matched++;
				}
			}

		}
		return (float) matched * 100 / (float) original;
	}

	static boolean isEqual(String a, String b) {

		if (a.length() != b.length()) {
			return false;
		} else {
			for (int x = 0; x < a.length(); x++) {
				if (a.charAt(x) != b.charAt(x))
					return false;
			}
		}
		return true;
	}
}
