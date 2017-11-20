package championship;

//Η BasketballTeam είναι υποκλάση της Team
public class BasketballTeam extends Team{
    
    //Επικάλυψη του costructor της Team
    public BasketballTeam(String name, int MaxNumOfGames){
        super(name, MaxNumOfGames);
    }
    
    //Έλεγχος για μη αρνητικό σκόρ
    @Override
    public void addGame(Game g){
        super.addGame(g);
        //Αν ο χρήστης δώσει αρνητικό σκόρ
        if(g.getScoreHome() < 0 || g.getScoreGuest() < 0){
            /*Μετέτρεψε τον αριθμό σε θετικό χρησιμοποιόντας την απόλυτη 
            τιμή του, Με τη βοήθεια της συνάρτησης Math.abs()*/
            g.setScoreHome(Math.abs(g.getScoreHome()));
            g.setScoreGuest(Math.abs(g.getScoreGuest()));
        }
    }
    //Μέθοδος υπολογισμού των βαθμών της νίκης και της ήττας.
    //Επικάλυψη μεθόδου
    @Override
    public int calcPoints(){
        //Διατρέχουμε τον πίνακα με τα παιχνίδια κάθε ομάδας
        for(int i=0; i<curNumOfGames; i++){
            //Αν είναι γηπεδούχος
            if(this.teamGames[i].getTeamHome() == this){
                //Αν νικήσει
                if(this.teamGames[i].getScoreHome() > this.teamGames[i].getScoreGuest()){
                    //Πρόσθεσε 2 πόντους
                    points += 2;
                }
                //Αν χάσει
                else if(this.teamGames[i].getScoreHome() < this.teamGames[i].getScoreGuest()){
                    //Πρόσθεσε 1 πόντο
                    points += 1;
                }
            }
            //Αν είναι φιλοξενούμενος
            else if(this.teamGames[i].getTeamGuest() == this){
                //Αν νικήσει
                if(this.teamGames[i].getScoreHome() < this.teamGames[i].getScoreGuest()){
                    //Πρόσθεσε 2 πόντους
                    points += 2;
                }
                //Αν χάσει
                 else if(this.teamGames[i].getScoreHome() > this.teamGames[i].getScoreGuest()){
                     //Πρόσθεσε 1 πόντο
                    points += 1;
                }
            }
            //Δεν υπάρχει περίπτωση ισοπαλίας στην καλαθοσφαίρηση
        }
        return points;
    }
}