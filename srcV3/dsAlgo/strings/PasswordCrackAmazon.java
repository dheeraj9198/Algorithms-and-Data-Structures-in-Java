package dsAlgo.strings;

/**
 *
 Database security and authentication have become vital due to the increasing number of cyberattacks every day. Amazon has created a team for the analysis of various types of cyberattacks. In one such analysis, the team finds a virus that attacks the user passwords. The virus designed has an attacking rule defined by attackOrder, which is a permutation of length n. In the ith second of the attack, the virus attacks at the attackOrder[i]th character of the password, replacing it with the malicious character '*', i.e, password[attackOrder[i]] = '*' after the ith second.



 The password is said to be irrecoverable when the number of substrings of the password containing at least one malicious character '*' becomes greater than or equal to m. In order to estimate the threat posed by the virus, the team wishes to find the minimum time after which the password becomes irrecoverable.



 Note:

 If the password is irrecoverable at the start, report 1 as the answer.
 A substring of a string s is a contiguous segment of that string.


 Example

 There is a password of length n = 5, password = "bcced". The 1-based indices where characters will be replaced, attackOrder = [2, 3, 1, 4, 5], and the recoverability parameter m = 10.



 After the 1st second, the password becomes:







 The 8 substrings that containt at least one malicious character are ["b*", "b*c", "b*ce", "b*ced", "*", "*c", "*ce", "*ced"] and 8 is less than m.



 After the 2nd second, the password becomes:



 The 11 substrings that contain at least one malicious character are ["b*", "b**", "b**e", "b**ed", "*", "**", "**e", "**ed", "*", "*e", "*ed"]. This is greater than or equal to m.



 After the replacement at second 2, the number of substrings is at least m. The answer is 2.

 ​​​​​

 Function Description

 Complete the function findMinimumTime in the editor below.



 findMinimumTime has the following parameters:

 string password: the initial password

 int attackOrder[n]:  permutation array of integers [1, 2, .. , n], the attack order of the virus

 int m: the recoverability parameter



 Returns

 int: the minimum time after which the password becomes irrecoverable.



 Constraints

 1 ≤ n ≤ 8*105
 String password consists of lowercase English characters
 1 ≤ attackOrder[i] ≤ n
 0 ≤ m ≤ n * (n + 1) / 2
 */
public class PasswordCrackAmazon {


}
