
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.Reader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oskar
 */
public class ReaderStub implements Reader {
    Player[] players;
    
    public ReaderStub(Player... players) {
        this.players = players; 
    }
    
    @Override
    public List<Player> getPlayers() {
        return Arrays.asList(this.players);
    }
    
}
