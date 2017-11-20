package championship;

public abstract class Team {
    private String name; //όνομα της ομάδας
    /*μέγιστο πλήθος αγώνων. Την ορίζουμε ως σταθερά (χρησιμοποιόντας 
    τη λέξη final) γιατί η τιμή της παραμένει σταθερή*/
    private final int maxNumOfGames; 
    protected int curNumOfGames = 0; //τρέχον πλήθος αγώνων
    /*οι αγώνες της ομάδας. Δηλώνουμε πίνακα 4 θέσεων γιατί
    οι αγώνες που δίνει κάθε ομάδα είναι 4 (2 εντός έδρας και 2 εκτός)*/
    protected Game[] teamGames = new Game[4]; 
    protected int points = 0; //πόντοι ομάδων
    
    //constructor με τον οποίο εισάγονται το όνομα της ομάδας και ο μέγιστος αριθμός παιχνιδιών
    public Team(String name, int maxNumOfGames){   
      this.name = name;
      this.maxNumOfGames = maxNumOfGames;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getName(){
        return name;
    }
    
    /* Δεν ελέγχουμε για αρνητικό σκόρ στην κλάση Team αλλά ελέγχουμε στις 
    υποκλάσεις FootballTeam και BasketballTeam. Το σκεπτικό της συγκεκριμένης
    ενέργειας είναι οτι μπορεί κάποια στιγμή να θέλουμε να δημιουργήσουμε ένα
    νέο είδος ομάδων (πχ AnotherSportTeam) όπου να επιτρέπονται και τα 
    αρνητικά σκόρ */
    public void addGame(Game g){ 

        //Έλεγχος αν μία απ'τις ομάδες, είναι αυτή που αγωνίζεται στον συγκεκριμένο αγώνα
        if(g.getTeamHome() != this && g.getTeamGuest() != this){
            //Εμφάνισε μήνυμα λάθους
            System.out.println("Λάθος, η ομάδα δεν συμμετέχει στο παιχνίδι");
        }
        //Προσθήκη των παιχνιδιών στον πίνακα teamGames
        if(curNumOfGames < maxNumOfGames){
            teamGames[curNumOfGames] = g;
            curNumOfGames++;
        }
        //Μύνημα οτι ξερπεράστηκαν τα μέγιστα παιχνίδια που μπορεί να δώσει μια ομάδα
        else{
            System.out.println("Λάθος, το μέγιστα παιχνίδια είναι: " + maxNumOfGames);
        }
    }
    
    //Μέθοδος για την εκτύπωση των στοιχείων της ομάδας
    //Επικάλυψη μεθόδου
    @Override
    public String toString(){
        String s;
        s = ("Όνομα: " + name + ", Μέγιστος αριθμός αγώνων: " + maxNumOfGames 
                + ", Βαθμοί: " + this.calcPoints());
        /* Μηδενίζουμε τη μεταβλητή points για να μην αποθηκεύεται στην points 
        η τιμή που επέστρεψε η μέθοδος this.calcPoints().Αυτό γίνεται γιατί ενδέχεται 
        να ξαναχρησιμοποιήσουμε τη μεταβλητή σε άλλο σημείο του κώδικα */
        points = 0;
        return s;
    }
    
    /* Αφηρημένη μέθοδος. Υπολογίζει τους βαθμούς που έχει συγκεντρώσει 
    η ομάδα. */ 
    public abstract int calcPoints();
    
    /*Υπολογίζει με τη συνολική διαφορά τερμάτων της ομάδας (γκόλ που έχει 
    σκοράρει - γκόλ που έχει δεχτεί) βάσει των αγώνων που έχει δώσει */
    public int calcTotalScore(){
        
        int scoreDiff = 0;
        
        for(int i=0; i<curNumOfGames; i++){
            //Αν είσαι γηπεδούχος
            if(this.teamGames[i].getTeamHome() == this){
                //Πρόσθεσε στη scoreDiff τη διαφορά (γκόλ που πέτυχες - γκόλ που δέχτηκες)
                scoreDiff += (this.teamGames[i].getScoreHome() - this.teamGames[i].getScoreGuest());
            }
            //Αν είσαι φιλοξενούμενος
            if(this.teamGames[i].getTeamGuest() == this){
                //Πρόσθεσε στη scoreDiff τη διαφορά (γκόλ που πέτυχες - γκόλ που δέχτηκες)
                scoreDiff += (this.teamGames[i].getScoreGuest() - this.teamGames[i].getScoreHome());
            }    
        }
        return scoreDiff;
    }
 
}