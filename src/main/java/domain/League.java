package domain;


import java.util.HashSet;
import java.util.Set;

public class League {
    private Set<LeaguePerSeason> leaguePerSeasons;
    private String leagueName;
    private int leagueQualification; // From 1 to 5 (5 is the best league....)
    //TODO: referees?

    // Constructor
    public League( String leagueName, int leagueQualification) {
        this.leagueName = leagueName;
        this.leaguePerSeasons = new HashSet<LeaguePerSeason>();
        this.leagueQualification = leagueQualification;

    }



    //Setters
    public void setLeaguePerSeasons(Set<LeaguePerSeason> leaguePerSeasons) {
        this.leaguePerSeasons = leaguePerSeasons;
    }

    //add league per season
    public void addLeaguePerSeason(LeaguePerSeason leaguePerSeason) {
        this.leaguePerSeasons.add(leaguePerSeason);
    }

    public void setLeagueQualification(int leagueQualification) {
        if(leagueQualification >= 1 && leagueQualification <=5){
            this.leagueQualification = leagueQualification;
        }

    }

    //Getters

    public Set<LeaguePerSeason> getLeagueSeasons() {
        return leaguePerSeasons;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public int getLeagueQualification() {
        return leagueQualification;
    }
}
