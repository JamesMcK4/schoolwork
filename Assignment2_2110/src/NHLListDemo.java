/**
 * James McKinlay
 * B00867096
 * Assignment 2 - NHL Stats
 * This is the demo class that drives the program.  It uses the file NHLStats.txt (provided) and uses that file to derive
 * statistics from.  Each column in the file is broken up using a string tokenizer that seperates values based on (in this case)
 * a tab.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class NHLListDemo {

    public static void main(String[] args) throws FileNotFoundException {


        Scanner in = new Scanner(System.in);
        System.out.println("Please input the file pathway");
        NHLStats stats = new NHLStats();
        String fileName = in.nextLine();
        File nhlstats = new File(fileName);
        Scanner fileScanner = new Scanner(nhlstats);
        StringTokenizer token;
        while(fileScanner.hasNext()){
            String inputLine = fileScanner.nextLine();
            token = new StringTokenizer(inputLine, "\t");

            //Read in the values for each from the file and assign them to a field
            String name = token.nextToken();
            String position = token.nextToken();
            String teamName = token.nextToken();
            String gamesPlayedString = token.nextToken();
            String goalsScoredString = token.nextToken();
            String assistsString = token.nextToken();
            String penaltyMinutesString = token.nextToken();
            String shotsOnGoalString = token.nextToken();
            String gameWinningGoalsString = token.nextToken();

            //Change the values of the fields that should be integers instead of strings, according to the constructor of the
            //PlayerRecord class
            int gamesPlayed = Integer.parseInt(gamesPlayedString);
            int goalsScored = Integer.parseInt(goalsScoredString);
            int assists = Integer.parseInt(assistsString);
            int penaltyMinutes = Integer.parseInt(penaltyMinutesString);
            int shotsOnGoal = Integer.parseInt(shotsOnGoalString);
            int gameWinningGoals = Integer.parseInt(gameWinningGoalsString);

            //Need to create a playerRecord now to input all the data into

            PlayerRecord record = new PlayerRecord(name, position, teamName, gamesPlayed, goalsScored, assists, penaltyMinutes, shotsOnGoal, gameWinningGoals);
            stats.add(record);
        }
        System.out.println("Player(s) with the most penalty minutes:");
        stats.displayPlayerMostPenaltyMinutes();
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();
        System.out.println("Team(s) with the most penalty minutes:");
        stats.displayTeamMostPenaltyMinutes();
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();
        System.out.println("Team(s) with the most game winning goals:");
        stats.displayTeamMostGameWinningGoals();
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();
        System.out.println("Player(s) with the most game winning goals:");
        stats.displayMostGameWinningGoals();
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();
        System.out.println("Player(s) with the most points:");
        stats.displayMostPoints();
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();
        System.out.println("Player(s) with the most shots on goal:");
        stats.displayMostShots();



    }
}
