package championship;

public class Game {
    private Team teamHome; //γηπεδούχος ομάδα
    private Team teamGuest; //φιλοξενούμενη ομάδα
    private int scoreHome; //σκορ γηπεδούχου ομάδας
    private int scoreGuest; //σκορ φιλοξενούμενης ομάδας   
   
    //constructor με τον οποίο εισάγονται οι δύο ομάδες και το μεταξύ τους σκόρ
    public Game(Team teamHome, Team teamGuest, int scoreHome, int scoreGuest){
        this.teamHome = teamHome;
        this.teamGuest = teamGuest;
        this.scoreHome = scoreHome;
        this.scoreGuest = scoreGuest;
    }    
    
    public void setTeamHome(Team teamHome){
        this.teamHome=teamHome;
    }
    
    public Team getTeamHome(){
        return teamHome;
    }    
    
    public void setTeamGuest(Team teamGuest){
        this.teamGuest=teamGuest;
    }
    
    public Team getTeamGuest(){
        return teamGuest;
    }   
    
    public void setScoreHome(int scoreHome){
        this.scoreHome = scoreHome;
    }

    public int getScoreHome(){
        return scoreHome;
    }    
    
    public void setScoreGuest(int scoreGuest){
        this.scoreGuest = scoreGuest;            
    }
    
    public int getScoreGuest(){
        return scoreGuest;
    }        
   
}