package domain.controllers;

import domain.*;

import java.util.ArrayList;

public class LeagueController {

    // =================== Guest functions ====================
    // ========================================================

    /**
     * UC 2.4
     * Returns the league instance that matches the league name
     * @param leagueName the league name
     * @return the league instance that matches the league name
     */
    public League getLeagueDetails(String leagueName) {
        return League.getLeagueByName(leagueName);
    }

    /**
     * UC 2.4
     * Returns the leagues instances from a certain season
     * @param year the season
     * @return the leagues instances from the season
     */
    public ArrayList<League> getSeasonDetails(String year) {
        return League.getAllLeaguesPerSeason(Integer.parseInt(year));
    }



    // =================== Association Agent functions ====================
    // ====================================================================

    /**
     * UC 9.1
     * Creates a new league
     * @param leagueName the league name
     * @return an instance of the new league
     */
    public League setLeague(String leagueName) {
        return new League(leagueName);
    }


    /**
     * UC 9.2
     * Updates the season in the league
     * @param leagueName the league name
     * @param season the season
     * @return the updated league
     */
    public League updateSeasonForLeague(String leagueName, String season) {
        return League.getLeagueByName(leagueName).setSeason(Integer.parseInt(season));
    }

    /**
     * UC 9.4
     * Adds a referee to a league in a specific season
     * @param leagueName the league
     * @param userName the referee's username
     */
    public void addRefereeToLeaguePerSeason(String leagueName, String userName) {
        //This method will be shown after the user chose a referee from the list (using getReferees() method)

        // TODO: get league
        // League league = get from DB by leagueName
        // league.addReferee((Referee) User.getUserByID(userName).getRoles().get(Role.REFEREE));

//        Alert alert = new Alert();
//        alert.addToMailSet(User.getUserByID(userName).getRoles().get(Role.REFEREE));
//        alert.sendAlert(new AlertNotification("Invitation","MAZAL TOV! you are a referee!!"));
    }

    /**
     * UC 9.5
     * Sets the ranking method in the league
     * @param winP amount of points given for a win
     * @param drawP amount of points given for a draw
     * @param loseP amount of points given for a loss
     * @param league the league
     */
    public void setRankingMethod(String winP, String drawP, String loseP, String league) {
        // TODO: get league
        // League league = get from DB by leagueName
        // league.getRankingMethod().setRankingMethod(Integer.parseInt(winP), Integer.parseInt(loseP), Integer.parseInt(drawP));
    }

    /**
     * UC 9.6
     * Sets the scheduling method of teams into games in the league
     * @param league the league
     * @param schedulingMethodName the scheduling method
     */
    public void setSchedulingMethod(String league, String schedulingMethodName) {
        SchedulingMethod schedulingMethod;
        switch(schedulingMethodName) {
            case "OneGameSchedulingMethod":
                 schedulingMethod = new OneGameSchedulingMethod();
            case "TwoGameSchedulingMethod":
                schedulingMethod = new TwoGameSchedulingMethod();
            default:
                return;
        }
        // TODO: get league
        // League league = get from DB by leagueName
        // league.setSchedulingMethod(schedulingMethod);
    }

    /**
     * UC 9.7
     * schedules teams into games in a league
     * @param leagueName the league
     */
    public void scheduleGamesInLeagues(String leagueName) {
        // Click this button after you have all the teams in league, Automatic scheduling
        // League league = get from DB by leagueName
        // league.scheduledGames();
    }
}
