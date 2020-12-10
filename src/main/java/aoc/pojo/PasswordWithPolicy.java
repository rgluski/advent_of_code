package aoc.pojo;

public class PasswordWithPolicy {
	public final int firstNum;
	public final int secondNum;
	public final char letter;
	public final String password;
	
	public PasswordWithPolicy(int firstNum, int secondNum, char letter, String password) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		this.letter = letter;
		this.password = password;
	}
}
