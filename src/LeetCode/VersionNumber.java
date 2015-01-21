package LeetCode;

/**
 * Created by dheeraj on 20/1/15.
 */
public class VersionNumber {

    public int compareVersion(String version1, String version2) {

        String[] one = version1.split("\\.");
        String[] two = version2.split("\\.");

        int max = Math.max(one.length, two.length);

        int[] o = new int[max];
        int[] t = new int[max];

        int x;
        for (x = 0; x < max; x++) {
            try {
                o[x] = Integer.parseInt(one[x]);
            } catch (Exception e) {
                o[x] = 0;
            }
            try {
                t[x] = Integer.parseInt(two[x]);
            } catch (Exception e) {
                t[x] = 0;
            }
        }

        for (x = 0; x < max; x++) {
            if (o[x] == t[x]) {
                continue;
            } else {
                if (o[x] > t[x]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        VersionNumber versionNumber = new VersionNumber();
        System.out.print(versionNumber.compareVersion("0.1", "0.0.1"));

    }

}
