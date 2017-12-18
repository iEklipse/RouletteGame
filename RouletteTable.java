/**
 * The class RouletteTable keeps track of the total bets and the total winnings on the two different tables, European and American.
 * @author Tri-Luong Steven Dien (27415281)
 * @author Hoai An Luu (27187661)
 *
 */
public class RouletteTable {
	private final String[] E_ROULETTE = 
		{"0", "32", "15", "19", "4", "21",
			"2", "25", "17", "34", "6", "27",
			"13", "36","11", "30", "8", "23",
			"10", "5", "24","16", "33", "1",
			"20", "14", "31", "9","22", "18",
			"29", "7", "28", "12", "35","3", "26"};
	private final String[] A_ROULETTE =
		{"0", "28", "9", "26", "30", "11",
			"7", "20", "32", "17", "5", "22",
			"34", "15", "3", "24", "36", "13",
			"1", "00", "27", "10", "25", "29",
			"12", "8", "19", "31", "18", "6",
			"21", "33", "16", "4", "23", "35", "14", "2"};
	private String[] chosenRoulette;
	private String[][] playersBets = new String[6][5];
	private final int MAX_NUMBER_PLAYERS = 6;
	private final int MAX_NUMBER_BETS = 5;
	private int totalTableBets = 0;
	private int totalTableWinnings = 0;
	private boolean[] arrayWinners = new boolean[6];

	/**
	 * Constructor that prepares the game with the roulette chosen by the user.
	 * @param whichRoulette the roulette choice.
	 */
	public RouletteTable(int whichRoulette)
	{
		switch (whichRoulette)
		{
		case 1:
			chosenRoulette = E_ROULETTE;
			break;
		case 2:
			chosenRoulette = A_ROULETTE;
			break;
		}

		for (int player = 0; player < MAX_NUMBER_PLAYERS; player++)
		{
			arrayWinners[player] = false;
			for (int bet = 0; bet < MAX_NUMBER_BETS; bet++)
				playersBets[player][bet] = "";
		}

		totalTableBets = 0;
		totalTableWinnings = 0;
	}

	/**
	 * Accessor method that returns the European roulette.
	 * @return E_ROULETTE the European roulette.
	 */
	public String[] getERoulette()
	{
		return E_ROULETTE;
	}

	/**
	 * Accessor method that returns the American roulette.
	 * @return A_ROULETTE the American roulette.
	 */
	public String[] getARoulette()
	{
		return A_ROULETTE;
	}

	/**
	 * Access method that returns the chosen roulette.
	 * @return chosenRoulette the chosen roulette.
	 */
	public String[] getChosenRoulette()
	{
		return chosenRoulette;
	}

	/**
	 * Accessor method that returns the maximum number of players per table.
	 * @return MAX_NUMBER_PLAYERS the maximum number of players.
	 */
	public int getMaxNumberPlayers()
	{
		return MAX_NUMBER_PLAYERS;
	}

	/**
	 * Accessor method that returns the maximum number of bets per player.
	 * @return MAX_NUMBER_BETS the maximum number of bets per player.
	 */
	public int getMaxNumberBets()
	{
		return MAX_NUMBER_BETS;
	}

	/**
	 * Accessor method that returns a player's bets.
	 * @return playersBets the player's bets.
	 */
	public String[][] getPlayerBets()
	{
		return playersBets;
	}

	/**
	 * Accessor method that returns the total bet on the table.
	 * @return totalTableBets the total bet on the table.
	 */
	public int getTotalTableBets()
	{
		return totalTableBets;
	}

	/**
	 * Accessor method that returns the total winning on the table.
	 * @return totalTableWinnings the total winning on the table.
	 */
	public int getTotalTableWinnings()
	{
		return totalTableWinnings;
	}

	/**
	 * Accessor method that returns who the winner(s) of a round is/are.
	 * @return arrayWinners the winner(s) of a round.
	 */
	public boolean[] getArrayWinners()
	{
		return arrayWinners;
	}

	/**
	 * Mutator method that sets the table with the chosen roulette with a string as parameter.
	 * @param rouletteType the chosen roulette.
	 */
	public void setChosenRoulette(String[] rouletteType)
	{
		chosenRoulette = rouletteType;
	}

	/**
	 * Mutator method that sets the bet of each players that takes two integer and a string as parameters.
	 * @param playerNumber the player number.
	 * @param betNumber the index in the array of the bet.
	 * @param theBet the bet number of the player.
	 */
	public void setPlayerBets(int playerNumber, int betNumber, String theBet)
	{
		playersBets[playerNumber][betNumber] = theBet;
	}

	/**
	 * Mutator method that sets the total bets on the table with an integer as parameter.
	 * @param tableBets the total bets on the table.
	 */
	public void setTotalTableBets(int tableBets)
	{
		totalTableBets = tableBets;
	}

	/**
	 * Mutator method that sets the total winnings on the table.
	 * @param tableWinnings the total winnings on the table.
	 */
	public void setTotalTableWinnings(int tableWinnings)
	{
		totalTableWinnings = tableWinnings;
	}

	/**
	 * Mutator method that sets the winner(s) of a round that takes an integer and a boolean as parameter.
	 * @param index the player index in the array.
	 * @param isWinners a boolean, true if the player is a winner, false otherwise
	 */
	public void setArrayWinners(int index, boolean isWinners)
	{
		arrayWinners[index] = isWinners;
	}

	/**
	 * Redefinition of the method toString() to allow the printing of all the variables of the class.
	 * @return a string containing all the variables of the class
	 */
	public String toString()
	{
		String dataMembers = "\nData members: ";

		dataMembers += "\nEuropeen roulette: " + displayRoulette(1);
		dataMembers += "\nAmerican roulette: " + displayRoulette(2);
		dataMembers += "\nChosen roulette: "  + displayRoulette(0);
		dataMembers += "\nPlayers' bets: " + displayPlayersBets();
		dataMembers += "\nArray of winners: " + displayArrayWinners();
		dataMembers += "\nMax number of players: " + MAX_NUMBER_PLAYERS;
		dataMembers += "\nMax number of bets allowed: " + MAX_NUMBER_BETS;
		dataMembers += "\nTotal of bets for this table: " + totalTableBets;
		dataMembers += "\nTotal of winnings for this table: " + totalTableWinnings;

		return dataMembers;
	}

	/**
	 * Redefinition of the method equals() to allow the comparison of two roulette table contents.
	 * @param otherRoulette the second object of class Roulette that we compare with.
	 * @return true if the content of two table roulette are the same, otherwise false if not.
	 */
	public boolean equals(RouletteTable otherRoulette)
	{
		boolean isEqual = false;

		for (int slot = 0; slot < chosenRoulette.length; slot++)
			if (!chosenRoulette[slot].equals(otherRoulette.chosenRoulette[slot]))
				return false;

		for (int player = 0; player < MAX_NUMBER_PLAYERS; player++)
		{
			if (arrayWinners[player] != otherRoulette.arrayWinners[player])
				return false;

			for(int bet = 0; bet < MAX_NUMBER_BETS; bet++)
				if (!playersBets[player][bet].equals(otherRoulette.playersBets[player][bet]))
					return false;
		}

		if (totalTableBets == otherRoulette.totalTableBets && totalTableWinnings == otherRoulette.totalTableWinnings)
			isEqual = true;

		return isEqual;
	}

	/**
	 * Method that allows the user to increase the total bets on the table.
	 * @param totalBets the added bets.
	 */
	public void addTotalTableBets(int totalBets)
	{
		totalTableBets += totalBets;
	}

	/**
	 * Method that allows the user to increase the total winning on the table.
	 * @param totalWinnings the added winnings.
	 */
	public void addTotalTableWinnings(int totalWinnings)
	{
		totalTableWinnings += totalWinnings;
	}

	/**
	 * Method that displays the chosen roulette.
	 * @param rouletteChoice the choice of roulette.
	 * @return the layout of the chosen roulette.
	 */
	public String displayRoulette(int rouletteChoice)
	{
		String rouletteNumbers = "Wheel : ";
		String[] roulette = null;

		switch (rouletteChoice)
		{
		case 1:
			roulette = E_ROULETTE;
			break;
		case 2:
			roulette = A_ROULETTE;
			break;
		default:
			roulette = chosenRoulette;
		}

		for (int i = 0; i < roulette.length; i++)
		{
			if (i == roulette.length - 1)
				rouletteNumbers += roulette[i];
			else
				rouletteNumbers += roulette[i] + "-";

			if (i == roulette.length / 2)
				rouletteNumbers += "\n";
		}
		return rouletteNumbers;
	}

	/**
	 * Method that displays each player's bets.
	 * @return the bets of each player.
	 */
	public String displayPlayersBets()
	{
		String string = "\n";

		for (int player = 0; player < MAX_NUMBER_PLAYERS; player++)
			for (int betIndex = 0; betIndex < MAX_NUMBER_BETS; betIndex++)
			{
				if (player == MAX_NUMBER_PLAYERS - 1 && betIndex == MAX_NUMBER_BETS -1)
					string += "Player " + (player + 1) + " Bet #" + (betIndex + 1) + " " + playersBets[player][betIndex];
				else
					string += "Player " + (player + 1) + " Bet #" + (betIndex + 1) + " " + playersBets[player][betIndex] + "\n";

			}
		return string;
	}

	/**
	 * Method that display the winner(s).
	 * @return a string containing the number of the winner players
	 */
	public String displayArrayWinners()
	{
		String string = "\n";

		for (int player = 0; player < MAX_NUMBER_PLAYERS; player++)
			string += arrayWinners[player] + " ";

		return string;
	}

	/**
	 * Method that verifies the winning status of each player that takes a string as parameter.
	 * @param winningNumber the winning number of a round.
	 * @return true if the player has the winning number, else false if not.
	 */
	public boolean[] winnersVerification(String winningNumber)
	{	
		for (int player = 0; player < MAX_NUMBER_PLAYERS; player++)
			for (int betIndex = 0; betIndex < MAX_NUMBER_BETS; betIndex++)
				if (playersBets[player][betIndex].equals(winningNumber))
					setArrayWinners(player, true);

		return arrayWinners;
	}
}

