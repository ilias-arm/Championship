package championship;

//Η FootballTeam είναι υποκλάση της Team
public class FootballTeam extends Team{
        
    //Επικάλυψη του costructor της Team
    public FootballTeam(String name, int MaxNumOfGames){
        super(name, MaxNumOfGames);
    }
    
    //Έλεγχος για μη αρνητικό σκόρ
    //Επικάλυψη μεθόδου
    @Override
    public void addGame(Game g){
        super.addGame(g);
        //Αν ο χρήστης δώσει αρνητικό σκόρ
        if(g.getScoreHome() < 0 || g.getScoreGuest() < 0){
            /*Μετέτρεψε τον αριθμό σε θετικό χρησιμοποιόντας την απόλυτη 
            τιμή του, με τη βοήθεια της συνάρτησης Math.abs()*/
            g.setScoreHome(Math.abs(g.getScoreHome()));
            g.setScoreGuest(Math.abs(g.getScoreGuest()));
        }
    }

   //Μέθοδος υπολογισμού των βαθμών της νίκης, της ήττας και της ισοπαλίας
    //Επικάλυψη μεθόδου
    @Override
    public int calcPoints(){
        //Διατρέχουμε τον πίνακα με τα παιχνίδια κάθε ομάδας
        for(int i=0; i<curNumOfGames; i++){
            //Αν είναι γηπεδούχος
            if(this.teamGames[i].getTeamHome() == this){
                //Αν νικήσει
                if(this.teamGames[i].getScoreHome() > this.teamGames[i].getScoreGuest()){
                    //Πρόσθεσε 3 πόντους
                    points += 3;
                }
                //Αν φέρει ισοπαλία
                else if(this.teamGames[i].getScoreHome() == this.teamGames[i].getScoreGuest()){
                    //Πρόσθεσε 1 πόντο
                    points += 1;
                }
            }
            //Αν είναι φιλοξενούμενος
            else if(this.teamGames[i].getTeamGuest() == this){
                //Αν νικήσει
                if(this.teamGames[i].getScoreHome() < this.teamGames[i].getScoreGuest()){
                    //Πρόσθεσε 3 πόντους
                    points += 3;
                }
                //Αν φέρει ισοπαλία
                 else if(this.teamGames[i].getScoreHome() == this.teamGames[i].getScoreGuest()){
                     //Πρόσθεσε 1 πόντο
                    points += 1;
                }
            }
            //Σε περίπτωση ήττας δεν προστίθεται κανένας βαθμός οπότε η μεταβλητή
            //points παραμάνει αμετάβλητη 
        }
        return points;
    }
}