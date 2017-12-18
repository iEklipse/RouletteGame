import java.util.Scanner;

/**
 * The dealer class turns the wheel, calculates the winnings and makes announcements 
 * @author Tri-Luong Steven Dien (27415281)
 * @author Hoai An Luu (27187661)
 *
 */
public class Dealer {

	/**
	 * The static method main executes the instructions.
	 * @param args an array of String objects representing the command-line arguments
	 */
	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);

		//Declaration of the variable that will contains the user's choice of roulette
		int rouletteChoice;

		//Declaration of the two objects of type RouletteTable and Wheel
		RouletteTable roulette;
		Wheel wheel;

		//Declaration and initialization of the six objects of type VIP and Regular
		Regular player_1 = new Regular();
		VIP player_2 = new VIP();
		Regular player_3 = new Regular();
		Regular player_4 = new Regular();
		Regular player_5 = new Regular();
		VIP player_6 = new VIP();
		Player[] arrayPlayers = {player_1, player_2, player_3, player_4, player_5, player_6};

		//Declaration and initialization of various variables
		int round = 1;
		final int maxRound = 10;
		String playerBets = "";
		String winningNumber = "";
		boolean[] allTheWinners;
		boolean maybeTwoOrMoreWinners = false;
		int winnings = 0;

		//Displays a welcome message and takes in the choice of roulette
		System.out.println("Welcome to Concordia Roulette Game");
		System.out.print("Which roulette would you like to play? \nEnter 1 for the Europeen roulette or 2 for the American roulette: ");
		rouletteChoice = keyIn.nextInt();
		keyIn.nextLine();

		//Verification if the roulette choice is valid
		if (rouletteChoice < 1 || rouletteChoice > 2)
		{
			System.out.println("\nSorry, " + rouletteChoice + " is not a valid choice.");
			System.out.println("Enter again, 1 for the Europeen roulette or 2 for the American roulette)");
			rouletteChoice = keyIn.nextInt();
			keyIn.nextLine();
		}

		//Creation of the two objects of type RouletteTable and Wheel
		roulette = new RouletteTable(rouletteChoice);
		wheel = new Wheel(rouletteChoice);

		//While loop that will loop for 10 rounds
		while (round <= maxRound)
		{	
			//Displays the numbers on the roulette table
			System.out.println("\n" + roulette.displayRoulette(rouletteChoice) + "\n");
			System.out.println("Dealer…Place your bets (Up to 5 bets, separated with a space key)");

			//VIP players place their bets first
			for (int i = 0; i < arrayPlayers.length; i++)
				if (arrayPlayers[i].getPlayerStatus().equals("VIP"))
				{
					System.out.print("Player " + (i + 1) + " (" + arrayPlayers[i].getPlayerStatus() + ") : ");
					playerBets = keyIn.nextLine();

					//The dealer sets the players' bets
					dealerSetTheBets(keyIn, playerBets, roulette, i, arrayPlayers);

				}

			//Regular player's turn to place their bets
			for (int i = 0; i < arrayPlayers.length; i++)
				if (arrayPlayers[i].getPlayerStatus().equals("Regular"))
				{
					System.out.print("Player " + (i + 1) + " : ");
					playerBets = keyIn.nextLine();

					//The dealer sets the players' bets
					dealerSetTheBets(keyIn, playerBets, roulette, i, arrayPlayers);
				}

			//The dealer spins the wheel
			System.out.println("Dealer...No more bets");
			winningNumber = wheel.spinTheWheel(roulette.getChosenRoulette());

			//The winning number is printed out
			System.out.println("Dealer...The winning number is " + winningNumber);

			//Verifies if there are bets that match the winning number and place the winner player number inside an array
			allTheWinners = roulette.winnersVerification(winningNumber);


			for (int player = 0; player < roulette.getArrayWinners().length; player++)
				if (allTheWinners[player] == true)
				{
					System.out.print("Dealer...");
					break;
				}

			//The dealer calculates the winnings of each winners and prints out the player number with the corresponding winnings
			for (int player = 0; player < roulette.getArrayWinners().length; player++)
				if (allTheWinners[player] == true)
				{
					//The dealer calculates the winnings
					winnings = dealerCalculatesWinnings(arrayPlayers, player, roulette);

					if (maybeTwoOrMoreWinners)
						System.out.print(", player " + (player + 1) + " wins $" + winnings);
					else
					{
						System.out.print("Player " + (player + 1) + " wins $" + winnings);
						maybeTwoOrMoreWinners = true;
					}
				}

			//The dealer resets/erase all the bets and continues with a new round
			System.out.println();
			round++;
			dealerResetsBets(roulette);
			maybeTwoOrMoreWinners = false;
			for (int player = 0; player < allTheWinners.length; player++)
				allTheWinners[player] = false;
		}

		//The game ends and displays a list of statistic (Total winnings, total bets for the table and each player)
		gameOver(roulette, arrayPlayers);
		keyIn.close();
	}

	/**
	 * Method that sets the bets and calculates the amount of money spent on bets for each player
	 * @param keyIn the keyboard that takes in the user's input
	 * @param playerBets a string containing the player's bets
	 * @param roulette the object of type RouletteTable
	 * @param playerNumber the number of the player
	 * @param arrayPlayers the array containing every players on the table
	 */
	public static void dealerSetTheBets(Scanner keyIn, String playerBets, RouletteTable roulette,
			int playerNumber, Player[] arrayPlayers)
	{
		String theBets = "";
		int betIndex = 0;
		int playerTotalBets = 0;
		int numberOfSpace = 0;

		for (int j = 0; j < playerBets.length(); j++)
			if (playerBets.charAt(j) == ' ')
				numberOfSpace++;

		//Verifies if there are more than 5 bets
		if (numberOfSpace >= roulette.getMaxNumberBets())
		{
			System.out.println("You cannot have more than 5 bets");
			playerBets = keyIn.nextLine();
		}

		//Separates each bets inside the string and sends the individual bet to the bets array of the player
		for (int j = 0; j < playerBets.length(); j++)
			if (playerBets.charAt(j) != ' ')
			{	
				theBets += playerBets.charAt(j);
				if (j == playerBets.length()-1)
				{
					roulette.setPlayerBets(playerNumber, betIndex, theBets);
					betIndex++;
				}
			}
			else
			{
				roulette.setPlayerBets(playerNumber, betIndex, theBets);
				theBets = "";
				betIndex++;
			}

		//Adds the amount of money spent on bet to the player total depending of the player status
		if (arrayPlayers[playerNumber].getPlayerStatus().equals("VIP"))
		{
			VIP playerVIP = (VIP) arrayPlayers[playerNumber];
			playerTotalBets = betIndex * playerVIP.getTokenValue();
			arrayPlayers[playerNumber].addTotalPlayerBets(playerTotalBets);
			roulette.addTotalTableBets(playerTotalBets);
		}
		else
		{
			Regular playerRegular = (Regular) arrayPlayers[playerNumber];
			playerTotalBets = betIndex * playerRegular.getTokenValue();
			arrayPlayers[playerNumber].addTotalPlayerBets(playerTotalBets);
			roulette.addTotalTableBets(playerTotalBets);
		}
	}

	/**
	 * Method that calculates the winnings of the winners and adds the amount of money won to the player total
	 * 
	 * @param arrayPlayers the array containing the six players
	 * @param playerNumber the number of the player
	 * @param roulette the object of type RouletteTable
	 * @return winnings the amount of money won by the player depending of the player status
	 */
	public static int dealerCalculatesWinnings(Player[] arrayPlayers, int playerNumber, RouletteTable roulette)
	{
		VIP winnerVIP;
		Regular winnerRegular;
		int winnings = 0;

		//If the winner is a VIP player, the dealer calculates his winnings, if he's a regular player, the dealer calculate a different winnings
		if (arrayPlayers[playerNumber].getPlayerStatus().equals("VIP"))
		{
			winnerVIP = (VIP) arrayPlayers[playerNumber];
			winnings = winnerVIP.calculatesWinnings();
			arrayPlayers[playerNumber].addTotalPlayerWinnings(winnings);
		}
		else
		{
			winnerRegular = (Regular) arrayPlayers[playerNumber];
			winnings = winnerRegular.calculatesWinnings();
			arrayPlayers[playerNumber].addTotalPlayerWinnings(winnings);
		}

		//Adds the amount of money won to the total winnings of the table
		roulette.addTotalTableWinnings(winnings);

		return winnings;
	}

	/**
	 * Method that resets/deletes all the bets of every players
	 * 
	 * @param roulette the object of type RouletteTable
	 */
	public static void dealerResetsBets(RouletteTable roulette)
	{
		for (int player = 0; player < roulette.getMaxNumberPlayers(); player++)
			for(int betIndex = 0; betIndex < roulette.getMaxNumberBets(); betIndex++)
				roulette.setPlayerBets(player, betIndex, "");
	}

	/**
	 * Methods that displays the total winnings and bets of the tables and every players
	 * 
	 * @param roulette the object of type RouletteTable
	 * @param arrayPlayers the array containing all the players
	 */
	public static void gameOver(RouletteTable roulette, Player[] arrayPlayers)
	{
		System.out.println("\nThe table is closing !");
		System.out.println("Table - Total bets: $" + roulette.getTotalTableBets());
		System.out.println("Table - Total winnings: $" + roulette.getTotalTableWinnings());

		for (int player = 0; player < arrayPlayers.length; player++)
		{
			System.out.println();

			if (arrayPlayers[player].getPlayerStatus().equals("VIP"))
			{
				System.out.println("Player #" + (player + 1)
						+ " - Total bets: $" + arrayPlayers[player].getTotalPlayerBets()
						+ " | Bonus! you get as rewards $" + Math.round(roulette.getTotalTableBets() * 0.05) + (" (5% of the total bets)"));
				if (roulette.getTotalTableWinnings() != 0)
					System.out.println("Player #" + (player + 1)
							+ " - Total winning: $" + arrayPlayers[player].getTotalPlayerWinnings()
							+ " | Bonus! you get as rewards $" + Math.round(roulette.getTotalTableWinnings() * 0.10) + (" (10% of the total winnings)"));
				else
					System.out.println("Player #" + (player + 1)
							+ " - Total winning: $" + arrayPlayers[player].getTotalPlayerWinnings());
			}
			else
			{
				System.out.println("Player #" + (player + 1) + " - Total bets: $" + arrayPlayers[player].getTotalPlayerBets());
				System.out.println("Player #" + (player + 1) + " - Total winning: $" + arrayPlayers[player].getTotalPlayerWinnings());
			}
		}
		System.out.println("\nThank you for playing!");
	}
}