package domain;

/**
 * This class represents a member of a team - player, coach or manager
 */
public abstract class TeamMember extends Subscriber {

    protected String currentTeam;


    /**
     * Constructor
     * @param userName the username of the team member
     * @param mail the mail of the team member
     */
    public TeamMember(String userName, String mail) {
        super(userName, mail);
    }
    public TeamMember(String userName, String mail, String name) {
        super(userName, mail, name);
    }

    /**
     * Returns the team the member belongs to
     * @return the team the member belongs to
     */
    public String getCurrentTeam() {
        return currentTeam;
    }


    /**
     * Updates the team of the team member
     * @param currentTeam the team of the team member
     */
    public void setCurrentTeam(String currentTeam) {
        this.currentTeam = currentTeam;
    }
}
