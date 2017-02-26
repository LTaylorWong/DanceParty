import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Rachael on 2/25/2017.
 */
public class PartyRoom {
    private int numPeople;
    private int roomSize;
    private int numBalloons;
    private String food;
    private String music;
    private boolean needInvitation;
    private int guests;

    public PartyRoom(int numPeople, int roomSize, int numBalloons, String food, String music, boolean invitation) {
        this.numPeople = numPeople;
        this.roomSize = roomSize;
        this.numBalloons = numBalloons;
        //this.guests = guests;
    }
    public int getNumPeople(){
        return numPeople;
    }
    public int getRoomSize(){
        return roomSize;
    }
    public int getNumBalloons(){
        return numBalloons;
    }
    public String getFood(){
        return food;
    }
    public String getMusic(){
        return music;
    }
    public boolean getneedInvitation(){
        return needInvitation;
    }
}

