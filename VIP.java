/**
 * The class VIP is a child class of the class Player which keeps track the total bets and the total winnings of VIP player(s)
 * @author Hoai An Luu (27187661)
 * @author Tri-Luong Steven Dien (27415281)
 *
 */
public class VIP extends Player{
	private final int TOKEN_VALUE = 10;
	
	/**
	 * Constructor that sets the player status to VIP and takes its parameters from the parent class using the method super()
	 */
	public VIP()
	{
		super();
		setPlayerStatus("VIP");
	}
	
	/**
	 * Accessor method that returns the value of tokens used by VIP
	 * @return TOKEN_VALUE value of tokens
	 */
	public int getTokenValue()
	{
		return TOKEN_VALUE;
	}
	
	/**
	 * Accessor method that returns the total bets of VIP player(s)
	 * @return totalPlayerBets the total bets of VIP player(s)
	 */
	public int getTotalPlayerBets()
	{
		return totalPlayerBets;
	}
	
	/**
	 * Accessor method that returns the total winnings of VIP player(s)
	 * @return totalPlayerWinnings the total winnings of VIP player(s)
	 */
	public int getTotalPlayerWinnings()
	{
		return totalPlayerWinnings;
	}
	
	/**
	 * Mutator method that sets the total winnings of VIP that takes an integer as parameter.
	 * @param playerWinnings the set VIP player's total winnings
	 */
	public void setTotalPlayerWinnings(int playerWinnings)
	{
		totalPlayerWinnings += playerWinnings;
	}
	
	/**
	 * Mutator method that sets the total bets of VIP that takes an integer as parameter.
	 * @param playerBets the set VIP player's total bets.
	 */
	public void setTotalPlayerBets(int playerBets)
	{
		totalPlayerBets += playerBets; 
	}
	
	/**
	 * Redefinition of the method toString() to allow the printing of the token value of VIPs.
	 * @return the token value of VIP player(s)
	 */
	public String toString()
	{
		return ("Token value for a VIP player: " + TOKEN_VALUE);
	}
	
	/**
	 * Redefinition of the method equals() to allow the comparison of two object of the given class (VIP).
	 * @param otherVIP the second object of type VIP that we compare with.
	 * @return true if the token value are the same, otherwise false if they are not the same.
	 */
	public boolean equals(VIP otherVIP)
	{
		return (TOKEN_VALUE == otherVIP.TOKEN_VALUE);
	}
	
	/**
	 * Method that calculates the winnings of VIP player(s)
	 * @return the winning of VIP
	 */
	public int calculatesWinnings()
	{
		int winnings = 0;
		
		winnings = TOKEN_VALUE * getWinningTokenPayment();
		
		return winnings;
	}
}
