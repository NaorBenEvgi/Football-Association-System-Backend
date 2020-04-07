package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Game {

    private static int staticGameId = 0;

    private int gameId;
    private int seasonId;
    private Team hostTeam;
    private Team guestTeam;
    private Field field;
    private LocalDateTime gameDate;
    private ArrayList<Referee> referees;
    private GameEvent gameEvent;
    private int hostTeamScore;
    private int guestTeamScore;

/////////// Constructors ///////////

    // Constructor sets manual date with gameDateStr
    public Game(int seasonId, Team hostTeam, Team guestTeam, Field field, String gameDateStr, ArrayList<Referee> referees) {
        staticGameId++;
        this.gameId = staticGameId;
        this.seasonId = seasonId;
        this.hostTeam = hostTeam;
        this.guestTeam = guestTeam;
        this.field = field;
        this.referees = referees;
        this.gameEvent = new GameEvent();
        this.hostTeamScore = 0;
        this.guestTeamScore = 0;

        // Game date string format: "2016-11-09 11:44"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.gameDate = LocalDateTime.parse(gameDateStr, formatter);
    }

    // Constructor sets manual date with gameDateStr
    public Game(int seasonId, Team hostTeam, Team guestTeam, Field field, ArrayList<Referee> referees) {
        staticGameId++;
        this.gameId = staticGameId;
        this.seasonId = seasonId;
        this.hostTeam = hostTeam;
        this.guestTeam = guestTeam;
        this.field = field;
        this.referees = referees;
        this.gameEvent = new GameEvent();
        this.hostTeamScore = 0;
        this.guestTeamScore = 0;

        // Game date
        this.gameDate = LocalDateTime.now();
    }




/////////// Getters and Setters ///////////
    public int getGameId() {
        return gameId;
    }

    public int getSeason() {
        return seasonId;
    }

    public void setSeason(int season) {
        this.seasonId = season;
    }

    public Team getHostTeam() {
        return hostTeam;
    }

    public void setHostTeam(Team hostTeam) {
        this.hostTeam = hostTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(Team guestTeam) {
        this.guestTeam = guestTeam;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public ArrayList<Referee> getReferees() {
        return referees;
    }

    public void setReferees(ArrayList<Referee> referees) {
        this.referees = referees;
    }

    public GameEvent getGameEvent() {
        return gameEvent;
    }

    public void setGameEvent(GameEvent gameEvent) {
        this.gameEvent = gameEvent;
    }

    public int getHostTeamScore() {
        return hostTeamScore;
    }

    public void setHostTeamScore(int hostTeamScore) {
        this.hostTeamScore = hostTeamScore;
    }

    public int getGuestTeamScore() {
        return guestTeamScore;
    }

    public void setGuestTeamScore(int guestTeamScore) {
        this.guestTeamScore = guestTeamScore;
    }

    /**
     *
     * @return string in format: "0:0"
     */
    public String getGameScore(){
        return this.hostTeamScore + ":" + this.guestTeamScore;
    }

    public LocalDateTime getGameDate() {
        return gameDate;
    }

    /**
     * string format: "2016-11-09 11:44"
     * @param gameDateStr
     */
    public void setGameDate(String gameDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.gameDate = LocalDateTime.parse(gameDateStr, formatter);
    }
}