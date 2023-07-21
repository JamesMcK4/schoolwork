/**
 * James McKinlay
 * B00867096
 * Assignment 2 - NHL Statistics
 * This is the PlayerRecord class.  It takes in values based on the file provided and builds a PlayerRecord object.
 */
public class PlayerRecord {

    //Set of fields for the PlayerRecord class.  These are derived from the file nhlstats.txt and used to build a PlayerRecord object
    private String name;
    private String position;
    private String teamName;
    private int gamesPlayed;
    private int goalsScored;
    private int assists;
    private int penaltyMinutes;
    private int shotsOnGoal;
    private int gameWinningGoals;

    //constructor for the PlayerRecord class
    public PlayerRecord(String name, String position, String teamName, int gamesPlayed, int goalsScored, int assists, int penaltyMinutes, int shotsOnGoal, int gameWinningGoals) {
        this.name = name;
        this.position = position;
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.goalsScored = goalsScored;
        this.assists = assists;
        this.penaltyMinutes = penaltyMinutes;
        this.shotsOnGoal = shotsOnGoal;
        this.gameWinningGoals = gameWinningGoals;
    }

    /**
     * This method is used to determine the maximum amount of points that is gained by a single player.
     * @return maxPoints: This is the value that is derived by adding the goalsScored variable and the assists variable in order to
     * get the maximum amount of points for a single player.
     */
    public int getMaxPoints(){

        int goalsScored = this.goalsScored;
        int assists = this.assists;
        int maxPoints = goalsScored + assists;
        return maxPoints;
    }

    //Getters and Setters for the PlayerRecord class
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getPenaltyMinutes() {
        return penaltyMinutes;
    }

    public void setPenaltyMinutes(int penaltyMinutes) {
        this.penaltyMinutes = penaltyMinutes;
    }

    public int getShotsOnGoal() {
        return shotsOnGoal;
    }

    public void setShotsOnGoal(int shotsOnGoal) {
        this.shotsOnGoal = shotsOnGoal;
    }

    public int getGameWinningGoals() {
        return gameWinningGoals;
    }

    public void setGameWinningGoals(int gameWinningGoals) {
        this.gameWinningGoals = gameWinningGoals;
    }
}
