package DataAccess;

import domain.Referee;
import javafx.util.Pair;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameRefereesDBAccessTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); // prints log - for exception
    private final PrintStream originalOut = System.out;

    GameRefereesDBAccess refereeGamesDBAccess;
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    @BeforeEach
    public void insertBeforeTest() throws SQLException {
        System.setOut(new PrintStream(outContent));

        refereeGamesDBAccess = GameRefereesDBAccess.getInstance();
        connection = DBConnector.getConnection();

        // insert the user to DB
        preparedStatement = connection.prepareStatement("insert into [User] values ('Referee_test', 'name_1', 'password_1', 'testMail_1@gmail.com', 'false', 'false')");
        preparedStatement.executeUpdate();
        connection.commit();

        // insert the Referee to DB
        preparedStatement = connection.prepareStatement("insert into [Referee] values ('Referee_test', 'MAIN', '5')");
        preparedStatement.executeUpdate();
        connection.commit();
    }

    @AfterEach
    public void deleteAfterTest() throws SQLException {
        // delete the user from DB if exists
        preparedStatement = connection.prepareStatement("delete from [User] where username = 'Referee_test'");
        preparedStatement.executeUpdate();
        connection.commit();

        // delete the Referee from DB if exists
        preparedStatement = connection.prepareStatement("delete from [Referee] where username = 'Referee_test'");
        preparedStatement.executeUpdate();
        connection.commit();

        System.setOut(originalOut);
        refereeGamesDBAccess = null;
        if(connection != null) {
            connection.close();
            connection = null;
        }

        if(preparedStatement != null) {
            preparedStatement.close();
            preparedStatement = null;
        }

        if(resultSet != null) {
            resultSet.close();
            resultSet = null;
        }
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void selectRefereesOfGame() throws SQLException {
        Pair<String, ArrayList<Referee>> refereesEmpty = refereeGamesDBAccess.select("");
        assertEquals(0, refereesEmpty.getValue().size());

        // delete the user from DB if exists
        preparedStatement = connection.prepareStatement("delete from [RefereesInGames] where username = 'Referee_test'");
        preparedStatement.executeUpdate();
        connection.commit();

        // insert the role to DB
        preparedStatement = connection.prepareStatement("insert into [RefereesInGames] values ('Referee_test', '1000')");
        preparedStatement.executeUpdate();
        connection.commit();

        // check the role exists in DB
        preparedStatement = connection.prepareStatement("select * from [RefereesInGames] where username = 'Referee_test'" );
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        assertEquals("Referee_test", resultSet.getString(1));

        // check select
        ArrayList<Referee> referees = refereeGamesDBAccess.select("1000").getValue();
        assertEquals("Referee_test", referees.get(referees.size() - 1).getUserName());

        // delete the role from DB
        preparedStatement = connection.prepareStatement("delete from [RefereesInGames] where username = 'Referee_test'");
        preparedStatement.executeUpdate();
        connection.commit();
    }


    @Test
    void conditionedSelect() {
    }
}