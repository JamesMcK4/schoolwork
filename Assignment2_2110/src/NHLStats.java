/**
 * James McKinlay
 * B00867096
 * Assignment 2 - NHL Statistics
 * This is the NHL Statistics class (NHLStats).  It has methods that are used to derive and display specific data, such as:
 * who scored the most goals, who had the most penalty minutes, who had the most shots etc.
 */

    //**NOTES**
    //iterate through list and find largest for each method.  Lots of copy/pasting?
    //Use hashmap for team methods
    //need to add an add method?

import java.util.HashMap;


public class NHLStats {

    //List created to store player record statistics
    private List<PlayerRecord> list;

    //constructors for the NHLStats class, one empty, one taking in PlayerRecord object
    public NHLStats(PlayerRecord list) {
        this.list = new List<>();
    }
    public NHLStats(){
        this.list = new List<>();
    }


    //Added an add method
    public void add(PlayerRecord data){
        this.list.add(data);
    }

    /**
     * Method to display the most points for a single player in the NHL.
     */
    public void displayMostPoints(){
        double pointTotal = 0;
        LinkedList<PlayerRecord> playerList = new LinkedList<>();
        PlayerRecord data = list.first();
        while(data != null){
            if(data.getMaxPoints() > pointTotal)
            {
                pointTotal = data.getMaxPoints();
                playerList.clear();
                playerList.add(data);

            }
            else if(data.getMaxPoints() == pointTotal)
            {
                playerList.add(data);

            }
            data = list.next();
        }
        for(int i = 0; i< playerList.size(); i++){
            System.out.println(playerList.getAt(i).getName() + " " + playerList.getAt(i).getTeamName());
        }

    }

    /**
     * Method to display the name and team name of the player with the most penalty minutes
     */
    public void displayPlayerMostPenaltyMinutes(){
        double penaltyMinutes = 0;
        LinkedList<PlayerRecord> playerList = new LinkedList<>();
        PlayerRecord data = list.first();
        while(data != null){
            if(data.getPenaltyMinutes() > penaltyMinutes){
                penaltyMinutes = data.getPenaltyMinutes();
                playerList.clear();
                playerList.add(data);
            }
            else if(data.getPenaltyMinutes() == penaltyMinutes){
                playerList.add(data);
            }
            data = list.next();
        }
        for(int i = 0; i< playerList.size(); i++){
            System.out.println(playerList.getAt(i).getName() + " " + playerList.getAt(i).getTeamName());
        }

    }

    /**
     * Method used to display the name and the team of the player with the most shots on goal
     */
    public void displayMostShots(){
        double shots = 0;
        LinkedList<PlayerRecord> playerList = new LinkedList<>();
        PlayerRecord data = list.first();
        while(data != null){
            if(data.getShotsOnGoal() > shots)
            {
                shots = data.getShotsOnGoal();
                playerList.clear();
                playerList.add(data);
            }
            else if(data.getShotsOnGoal() == shots)
            {
                playerList.add(data);
            }
            data = list.next();
        }
        for(int i = 0; i< playerList.size(); i++){
            System.out.println(playerList.getAt(i).getName() + " " + playerList.getAt(i).getTeamName());
        }
    }

    /**
     * Method used to display the name and the team name of the player with the most game winning goals
     */
    public void displayMostGameWinningGoals(){
        double gameWinningGoals = 0;
        LinkedList<PlayerRecord> playerList = new LinkedList<>();
        PlayerRecord data = list.first();
        while(data != null){
            if(data.getGameWinningGoals() > gameWinningGoals)
            {
                gameWinningGoals = data.getGameWinningGoals();
                playerList.clear();
                playerList.add(data);
            }
            else if(data.getGameWinningGoals() == gameWinningGoals)
            {
                playerList.add(data);
            }
            data = list.next();
        }
        for(int i = 0; i< playerList.size(); i++){
            System.out.println(playerList.getAt(i).getName() + " " + playerList.getAt(i).getTeamName());
        }
    }

    /**
     * Method used to display the team name of the Team with the most penalty minutes accumulated between all their players.
     * Using a hashmap to store the data, using the team name as the key.
     */
    public void displayTeamMostPenaltyMinutes(){

        HashMap<String, Integer> data = new HashMap<>();
        LinkedList<String> players = new LinkedList<>();
        PlayerRecord current = list.first();
        while(current != null)
        {
            if(data.get(current.getTeamName()) == null)
            {
                data.put(current.getTeamName(), 0);
            }
            data.put(current.getTeamName(), data.get(current.getTeamName()) + current.getPenaltyMinutes());
            current = list.next();
        }
        int mostPenalty = 0;
        for(String key: data.keySet())
        {
            if(data.get(key) > mostPenalty)
            {
                players.clear();
                players.add(key);
                mostPenalty = data.get(key);
            }
            else if(data.get(key) == mostPenalty)
            {
                players.add(key);
            }
        }
        for(int i=0; i<players.size(); i++)
        {
            System.out.println(players.getAt(i));
        }
    }

    /**
     * Method used to display the team name of the Team with the most accumulated game winning goals.  Using a hashmap to store
     * the data, with the team name as the key.
     */
    public void displayTeamMostGameWinningGoals(){

        HashMap<String, Integer> data = new HashMap<>();
        LinkedList<String> players = new LinkedList<>();
        PlayerRecord current = list.first();
        while(current != null)
        {
            if(data.get(current.getTeamName()) == null)
            {
                data.put(current.getTeamName(), 0);
            }
            data.put(current.getTeamName(), data.get(current.getTeamName()) + current.getGameWinningGoals());
            current = list.next();
        }
        int mostGoals = 0;
        for(String key: data.keySet())
        {
            if(data.get(key) > mostGoals)
            {
                players.clear();
                players.add(key);
                mostGoals = data.get(key);
            }
            else if(data.get(key) == mostGoals)
            {
                players.add(key);
            }
        }
        for(int i=0; i<players.size(); i++)
        {
            System.out.println(players.getAt(i));
        }
    }
}
