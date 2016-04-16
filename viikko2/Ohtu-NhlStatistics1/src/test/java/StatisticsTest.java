/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.Statistics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oskar
 */
public class StatisticsTest {
    
    public StatisticsTest() {
    }
    
    ReaderStub reader;
    Statistics stat;
    Player p1;
    Player p2;
    Player p3;
    
    @Before
    public void setUp() {
        p1 = new Player("p1", "Team A", 8, 3);
        p2 = new Player("p2", "Team B", 4, 4);
        p3 = new Player("p3", "Team A", 2, 4);
        reader = new ReaderStub(p1, p2, p3);
        stat = new Statistics(reader);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void searchReturnCorrectPlayer() {
        assert(stat.search(p1.getName()).equals(p1));
        assert(stat.search(p2.getName()).equals(p2));
        assert(stat.search(p3.getName()).equals(p3));
    }
    
    @Test
    public void searchReturnsNullIfNoneFound() {
        assert(stat.search("a name that does not exist") == null);
    }
    
    @Test
    public void teamReturnsProperPlayers() {
        List<Player> teamA = stat.team(p1.getTeam());
        assert(teamA.contains(p1));
        assert(teamA.contains(p3));
        assert(!teamA.contains(p2));
        List<Player> teamB = stat.team(p2.getTeam());
        assert(!teamB.contains(p1));
        assert(!teamB.contains(p3));
        assert(teamB.contains(p2));
    }
    
    @Test
    public void teamReturnsEmptyListWithUnkownTeam() {
        List<Player> unknown = stat.team("unknown team");
        assert(unknown.isEmpty());
    }
    
    @Test
    public void topScoreReturnCorrectSize() {
        List<Player> topScorers = stat.topScorers(2);
        assertEquals(topScorers.size(), 3);
        
    }
    
     @Test
    public void topScorersReturnsInOrder() {
        List<Player> topScorers = stat.topScorers(2);
        assertEquals(topScorers.get(0), p1);
        assertEquals(topScorers.get(1), p2);
        assertEquals(topScorers.get(2), p3);
    }
}
