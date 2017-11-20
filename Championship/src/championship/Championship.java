package championship;

public class Championship {

    public static void main(String[] args) {
        
        //Δημιουργία ομάδων ποδοσφαίρου
        Team osfp = new FootballTeam("OLYMPIAKOS FC", 4);
        Team aek = new FootballTeam("AEK FC", 4);
        Team pao = new FootballTeam("PAO FC", 4);
        
        //Δημιουργία ομάδων καλαθοσφαίρησης
        Team paoB = new BasketballTeam("PAO BC", 4);
        Team paok = new BasketballTeam("PAOK BC", 4);
        Team aris = new BasketballTeam("ARIS BC", 4);
        
        //Δημιουργία αγώνων ποδοσφαίρου
        Game osfp_pao = new Game(osfp, pao, 3, 0);
        Game osfp_aek = new Game(osfp, aek, 4, 0);
        Game aek_osfp = new Game(aek, osfp, 2, 2);
        Game aek_pao = new Game (aek, pao, 1, 0);
        Game pao_aek = new Game(pao, aek, 0, 0);
        Game pao_osfp = new Game(pao, osfp, 1, 4);
        
        //Δημιουργία αγώνων καλαθοσφαίρησησς
        Game paoB_paok = new Game(paoB, paok, 67, 78);
        Game aris_paok = new Game(aris, paok, 78, 56);
        Game paoB_aris = new Game(paoB, aris, 70, 80);
        
        //Προσθήκη των ποδοσφαιρικών αγώνων στις ομάδες ποδοσφαίρου
        osfp.addGame(osfp_aek);
        osfp.addGame(osfp_pao);
        osfp.addGame(aek_osfp);
        osfp.addGame(pao_osfp);
        pao.addGame(osfp_pao);
        pao.addGame(pao_aek);
        pao.addGame(aek_pao);
        pao.addGame(pao_osfp);
        aek.addGame(pao_aek);
        aek.addGame(aek_osfp);
        aek.addGame(osfp_aek);
        aek.addGame(aek_pao);
        
        //Προσθήκη των αγώνων καλαθοσφαίρησης στις ομάδες καλαθοσφαίρησης
        paoB.addGame(paoB_paok);
        paoB.addGame(paoB_aris);
        paoB.addGame(paoB_aris);
        paok.addGame(aris_paok);
        paok.addGame(aris_paok);
        paok.addGame(paoB_paok);
        aris.addGame(paoB_aris);
        aris.addGame(aris_paok);
        aris.addGame(paoB_aris);
        
        //Εκτύπωση όλων των ομάδων ποδοσφαίρου
        System.out.println("Ομάδες ποδοσφαίρου");
        System.out.println("---------------");
        printTeams(pao, aek, osfp);
        
        //Εκτύπωση των τριών πρώτων ομάδων ποδοσφαίρου
        System.out.println("//////////////////////////");
        System.out.println("Οι πρωτοπόρες ομάδες του ποδοσφαίρου είναι: ");
        calcFootballStanding(pao, aek, osfp);
        
        System.out.println();
         
        //Εκτύπωση όλων των ομάδων καλαθοσφαίρησης
        System.out.println("Ομάδες καλαθσφαίρησης");
        System.out.println("---------------");
        printTeams(paok, aris, paoB);

        //Εκτύπωση των τριών πρώτων ομάδων καλαθοσφαίρησης
        System.out.println("//////////////////////////");
        System.out.println("Οι πρωτοπόρες ομάδες της καλαθοσφαίρησης είναι: ");
        calcBasketballStanding(paok, aris, paoB);
                
    }
    
    /* Οι παρακάτω μέθοδοι δηλώνονται static. Αυτό συμβαίνει για να μπορούμε 
    να τις καλέσουμε χωρίς να χρειάζεται να δημιουργήσουμε αντικέιμενο έτσι
    ώστε να γίνει κλήση της μεθόδου επι των αντικειμένων αυτών*/
 
    /* Υπολογίζει και τυπώνει την πρωτοπόρο ομάδα ποδοσφαίρου. Αν υπάρχει 
    ισοβαθμία, προηγείται η ομάδα με τη μεγαλύτερη διαφορά τερμάτων. 
    Σε περίπτωση ίδιας διαφοράς τερμάτων, τυπώνονται τα ονόματα των ομάδων
    που ισοβαθμούν στην πρώτη θέση */
    public static String calcFootballChampion(Team a, Team b, Team c){
        //Μεταβλητή για το όνομα της ομάδας με τους περισσότερους βαθμούς
        String winner = "";

        /*Χρησιμοποιούμε μεταβλητές για να αποθηκεύσουμε τους πόντους 
        κάθε ομάδας, για να μην καλούμε συνέχεια τη συνάρτηση calcPoints()*/
        int pointsA = a.calcPoints();
        int pointsB = b.calcPoints();
        int pointsC = c.calcPoints();

        //Αν η a έχει τους περισσότερους πόντους
        if(pointsA > pointsB && pointsA > pointsC){
            winner = a.getName();  
        }

        //Αν η b έχει τους περισσότερους πόντους
        if(pointsB > pointsA && pointsB > pointsC){
            winner = b.getName();
        }
        
        //Αν η c έχει τους περισσότερους πόντους
        if(pointsC > pointsA && pointsC > pointsB){
            winner = c.getName();
        }
        
        /* Οι παρακάτω έλεγχοι γίνονται σε περίπτωση που δύο ομάδες έχουν 
        τον ίδιο αριθμό πόντων (και οι πόντοι τους είναι περισσότεροι απο 
        της τρίτης) έτσι ώστε να ελένξουμε τη διαφορά των μεταξύ τους 
        τερμάτων και να αποφασίσουμε ποια ομάδα απο τις δύο είναι πρωτοπόρος.
        Αν η διαφορά τερμάτων είναι ίδια τότε καταχωρείται στη μεταβλητή
        winner ένα αλφαριθμητικό ("ομάδα x and ομάδα y"), το οποίο θα 
        χρησιμοποιηθεί στη μέθοδο υπολογισμού της κατάταξης των τριών πρώτων 
        ομάδων έτσι ώστε να τυπώσει τις ομάδες x και y στην πρώτη θέση. Σε
        περίπτωση τριπλής ισοβαθμίας στη διαφορά τερμάτων καταχωρείται στη
        winner το αλφαριθμητικό (a and b and c), το οποίο θα χρησιμοποιηθεί
        στη μέθοδο υπολογισμού της κατάταξης των τριών πρώτων ομάδων έτσι  
        ώστε να τυπώσει και τις τρείς ομάδες στην πρώτη θέση */
        
        //Αν η a έχει ίδιους βαθμούς με τη b
        if(pointsA == pointsB && (pointsA > pointsC || pointsB > pointsC)){
            //Αν η α έχει καλύτερη διαφορά τερμάτων
            if(a.calcTotalScore() > b.calcTotalScore()){
                winner = a.getName();
            }
            //Αν η b έχει καλύτερη διαφορά τερμάτων
            else if(a.calcTotalScore() > c.calcTotalScore()){
                winner = b.getName();
            }
            //Αν έχουν την ίδια διαφορά τερμάτων
            else{
                winner = "a and b";
            }
            
        }
        
        //Αν η a έχει ίδιους βαθμούς με τη c
        if(pointsA == pointsC && (pointsA > pointsB || pointsC > pointsB)){
            //Αν η α έχει καλύτερη διαφορά τερμάτων
            if(a.calcTotalScore() > c.calcTotalScore()){
                winner = a.getName();
            }
            //Αν η c έχει καλύτερη διαφορά τερμάτων
            else if(a.calcTotalScore() < c.calcTotalScore()){
                winner = c.getName();
            }
            //Αν έχουν την ίδια διαφορά τερμάτων
            else{
                winner = "a and c";
            }
        }
        
        //Αν η b έχει ίδιους βαθμούς με τη c
        if(pointsB == pointsC && (pointsB > pointsA || pointsC > pointsA)){
            //Αν η b έχει καλύτερη διαφορά τερμάτων
            if(b.calcTotalScore() > c.calcTotalScore()){
                winner = b.getName();
            }
            else if(b.calcTotalScore() < c.calcTotalScore()){
                //Αν η c έχει καλύτερη διαφορά τερμάτων
                winner = c.getName();
            }
            else{
                //Αν έχουν την ίδια διαφορά τερμάτων
                winner = "b and c";
            }
        }
        
        //Αν και οι τρείς ομάδες έχουν τον ίδιο αριθμό πόντων
        if(pointsA == pointsB && pointsA == pointsC && pointsB == pointsC){
            //Αν η a έχει καλύτερη διαφορά τερμάτων απο τις b, c
            if(a.calcTotalScore() > b.calcTotalScore() 
                    && a.calcTotalScore() > c.calcTotalScore()){
                winner = a.getName();
            }
            //Αν η b έχει καλύτερη διαφορά τερμάτων απο τις a, c
            else if(b.calcTotalScore() > a.calcTotalScore() 
                    && b.calcTotalScore() > c.calcTotalScore()){
                winner = b.getName();
            }
            //Αν η c έχει καλύτερη διαφορά τερμάτων απο τις a, b
            else if(c.calcTotalScore() > a.calcTotalScore() 
                    && c.calcTotalScore() > b.calcTotalScore()){
                winner = c.getName();
            }
            //Αν η διαφορά τερμάτων και των τριών ομάδων είναι ίδια
            else if(a.calcTotalScore() == b.calcTotalScore() &&
                    a.calcTotalScore() == c.calcTotalScore() &&
                    b.calcTotalScore() == c.calcTotalScore()){
                winner = "a and b and c";
            }
        }
        return winner;
            
    }

    /* Υπολογίζει και τυπώνει την πρωτοπόρο ομάδα καλαθσφαίρησης. Αν υπάρχει 
    ισοβαθμία, προηγείται η ομάδα με τη μεγαλύτερη διαφορά πόντων. 
    Σε περίπτωση ίδιας διαφοράς πόντων, τυπώνονται τα ονόματα των ομάδων
    που ισοβαθμούν στην πρώτη θέση.
    Η λειτουργία της είναι ακριβώς ίδια με την CalcFootballChampion.
    Δεν χρησιμοποιούμε επικάλυψη μεθόδου γιατί ο υπολογισμός των βαθμών
    γίνεται με διαφορετικό τρόπο. Τα σχόλια σ'αυτή τη μέθοδο είναι κοινά
    με τα σχόλια της μεθόδου CalcFootballChampion */
    
    public static String calcBasketballChampion(Team a, Team b, Team c){
        String winner = "";

        int pointsA = a.calcPoints();
        int pointsB = b.calcPoints();
        int pointsC = c.calcPoints();

        if(pointsA > pointsB && pointsA > pointsC){
            winner = a.getName();  
        }

        if(pointsB > pointsA && pointsB > pointsC){
            winner = b.getName();
        }
        
        if(pointsC > pointsA && pointsC > pointsB){
            winner = c.getName();
        }

        if(pointsA == pointsB && (pointsA > pointsC || pointsB > pointsC)){
            if(a.calcTotalScore() > b.calcTotalScore()){
                winner = a.getName();
            }
            else if(a.calcTotalScore() > c.calcTotalScore()){
                winner = b.getName();
            }
            else{
                winner = "a and b";
            }
            
        }
        
        if(pointsA == pointsC && (pointsA > pointsB || pointsC > pointsB)){
            if(a.calcTotalScore() > c.calcTotalScore()){
                winner = a.getName();
            }
            else if(a.calcTotalScore() < c.calcTotalScore()){
                winner = c.getName();
            }
            else{
                winner = "a and c";
            }
        }
        
        if(pointsB == pointsC && (pointsB > pointsA || pointsC > pointsA)){
            if(b.calcTotalScore() > c.calcTotalScore()){
                winner = b.getName();
            }
            else if(b.calcTotalScore() < c.calcTotalScore()){
                winner = c.getName();
            }
            else{
                winner = "b and c";
            }
        }
        
        if(pointsA == pointsB && pointsA == pointsC && pointsB == pointsC){
            if(a.calcTotalScore() > b.calcTotalScore() 
                    && a.calcTotalScore() > c.calcTotalScore()){
                winner = a.getName();
            }
            else if(b.calcTotalScore() > a.calcTotalScore() 
                    && b.calcTotalScore() > c.calcTotalScore()){
                winner = b.getName();
            }
            else if(c.calcTotalScore() > a.calcTotalScore() 
                    && c.calcTotalScore() > b.calcTotalScore()){
                winner = c.getName();
            }
            else if(a.calcTotalScore() == b.calcTotalScore() &&
                    a.calcTotalScore() == c.calcTotalScore() &&
                    b.calcTotalScore() == c.calcTotalScore()){
                winner = "a and b and c";
            }
        }
        return winner;       
    }
    
    //Μέθοδος που εκτυπώνει τα στοιχεία των τριών ομάδων
    public static void printTeams(Team a, Team b, Team c){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
    
    /* Μέθοδος που εκτυπώνει τον πίνακα με τις τρείς πρώτες ομάδες της  
    καλαθοσφαίρησης σε φθίνουσα σειρά. 
    Η λειτουργία της είναι ακριβώς ίδια με την CalcFootballStanding.
    Δεν χρησιμοποιούμε επικάλυψη μεθόδου γιατί ο υπολογισμός της πρωτοπόρου
    ομάδας γίνεται με διαφορετικό τρόπο (καλούμε τη μέθοδο
    calcBasketaballChampion aντί για την calcFootballChampion).
    Τα σχόλια σ'αυτή τη μέθοδο είναι κοινά με τα σχόλια της μεθόδου 
    CalcFootballStanding*/
    
    public static void calcBasketballStanding(Team a, Team b, Team c){
        String winner;

        winner = calcBasketballChampion(a, b, c);
        
        switch (winner) {
            case "a and b and c":
                System.out.println("1: " + a.getName() + "\n" +
                        "1: " + b.getName() + "\n" + "1: " + c.getName());
                break;
            case "a and b":
                System.out.println("1: " + a.getName() + "\n"
                        + "1: " + b.getName() + "\n" + "2: " + c.getName());
                break;
            case "a and c":
                System.out.println("1: " + a.getName() + "\n"
                        + "1: " + c.getName() + "\n" + "2: " + b.getName());
                break;
            case "b and c":
                System.out.println("1: " + b.getName() + "\n"
                        + "1: " + c.getName() + "\n" + "2: " + a.getName());
                break;
                
            default:
                break;     
        }
        
        if(winner.equals(a.getName())){
            System.out.println("1: " + winner);
            if(b.calcPoints() > c.calcPoints()){
                System.out.println("2: " + b.getName());
                System.out.println("3: " + c.getName());
            }
            else if(b.calcPoints() < c.calcPoints()){
                System.out.println("2: " + c.getName());
                System.out.println("3: " +b.getName());    
            }
            else if(b.calcPoints() == c.calcPoints()){
                if(b.calcTotalScore() > c.calcTotalScore()){
                    System.out.println("2: " + b.getName());
                    System.out.println("3: " + c.getName());
                }
                else if(b.calcTotalScore() < c.calcTotalScore()){
                    System.out.println("2: " + c.getName());
                    System.out.println("3: " + b.getName());
                }
                else if(b.calcPoints() == c.calcPoints()){
                    System.out.println("2: " + b.getName());
                    System.out.println("2: " + c.getName());
                }
            }
        }
        
        if(winner.equals(b.getName())){
            System.out.println("1: " + winner);
            if(a.calcPoints() > c.calcPoints()){
                System.out.println("2: " + a.getName());
                System.out.println("3: " + c.getName());
            }
            else if(a.calcPoints() < c.calcPoints()){
                System.out.println("2: " + c.getName());
                System.out.println("3: " + a.getName());
            }
            else if(a.calcPoints() == c.calcPoints()){
                if(a.calcTotalScore() > c.calcTotalScore()){
                    System.out.println("2: " + a.getName());
                    System.out.println("3: " + c.getName());
                }
                else if(a.calcTotalScore() < c.calcTotalScore()){
                    System.out.println("2: " + c.getName());
                    System.out.println("3: " + a.getName());
                }
                else if(a.calcPoints() == c.calcPoints()){
                    System.out.println("2: " + a.getName());
                    System.out.println("2: " + c.getName());
                }
            }
        }
        
        if(winner.equals(c.getName())){
            System.out.println("1: " + winner);
            if(a.calcPoints() > b.calcPoints()){
                System.out.println("2: " + a.getName());
                System.out.println("3: " + b.getName());
            }
            else if(a.calcPoints() < b.calcPoints()){
                System.out.println("2: " + b.getName());
                System.out.println("3: " + a.getName());
            }
            else if(a.calcPoints() == b.calcPoints()){
                if(a.calcTotalScore() > b.calcTotalScore()){
                    System.out.println("2: " + a.getName());
                    System.out.println("3: " + b.getName());
                }
                else if(a.calcTotalScore() < b.calcTotalScore()){
                    System.out.println("2: " + b.getName());
                    System.out.println("3: " + a.getName());
                }
                else if(a.calcPoints() == b.calcPoints()){
                    System.out.println("2: " + a.getName());
                    System.out.println("2: " + b.getName());
                }
            }
        }
    }
    
    /* Μέθοδος που εκτυπώνει τον πίνακα με τις τρείς πρώτες ομάδες του  
    ποδοσφαίρου σε φθίνουσα σειρά. Αρχικά καλούμε τη μέθοδο 
    calcFootballChampion() για να βρούμε την πρώτη ομάδα 
    (ή τις πρώτες, σε περίπτωση ισοβαθμίας) και στη συνέχεια υπολογίζουμε
    την δεύτερη και την τρίτη ομάδα */
    public static void calcFootballStanding(Team a, Team b, Team c){
        String winner;
        
        /* Καλούμε τη μέθοδο CalcFootballChampion() για να μας επιστρέψει την 
        πρώτη/ες ομάδα/ες */
        winner = calcFootballChampion(a, b, c);
        
        //Ελέγχουμε αν υπάρχει περίπτωση ισοβαθμίας στην πρώτη θέση
        switch (winner) {
            //Και οι τρείς ομάδες ισοβαθμούν
            case "a and b and c":
                System.out.println("1: " + a.getName() + "\n" +
                        "1: " + b.getName() + "\n" + "1: " + c.getName());
                break;
            //Οι a και η b ισοβαθμούν    
            case "a and b":
                System.out.println("1: " + a.getName() + "\n"
                        + "1: " + b.getName() + "\n" + "2: " + c.getName());
                break;
            //Οι a και η c ισοβαθμούν    
            case "a and c":
                System.out.println("1: " + a.getName() + "\n"
                        + "1: " + c.getName() + "\n" + "2: " + b.getName());
                break;
            //Οι b και η c ισοβαθμούν
            case "b and c":
                System.out.println("1: " + b.getName() + "\n"
                        + "1: " + c.getName() + "\n" + "2: " + a.getName());
                break;
                
            default:
                break;     
        }
        
        //Αν η a είναι πρωτοπόρος
        if(winner.equals(a.getName())){
            System.out.println("1: " + winner);
            //Αν η b είναι δεύτερη
            if(b.calcPoints() > c.calcPoints()){
                System.out.println("2: " + b.getName());
                System.out.println("3: " + c.getName());
            }
            //Αν η c είναι δεύτερη
            else if(b.calcPoints() < c.calcPoints()){
                System.out.println("2: " + c.getName());
                System.out.println("3: " +b.getName());    
            }
            //Αν η b και η c ισοβαθμούν στη δεύτερη θέση
            else if(b.calcPoints() == c.calcPoints()){
                //Η b έχει καλύτερη διαφορά τερμάτων απ'τη c
                if(b.calcTotalScore() > c.calcTotalScore()){
                    System.out.println("2: " + b.getName());
                    System.out.println("3: " + c.getName());
                }
                //Η b έχει καλύτερη διαφορά τερμάτων απ'τη b
                else if(b.calcTotalScore() < c.calcTotalScore()){
                    System.out.println("2: " + c.getName());
                    System.out.println("3: " + b.getName());
                }
                //Έχουν την ίδια διαφορά τερμάτων
                else if(b.calcPoints() == c.calcPoints()){
                    System.out.println("2: " + b.getName());
                    System.out.println("2: " + c.getName());
                }
            }
        }
        
        //Αν η b είναι πρωτοπόρος
        if(winner.equals(b.getName())){
            System.out.println("1: " + winner);
            //Αν η a είναι δεύτερη
            if(a.calcPoints() > c.calcPoints()){
                System.out.println("2: " + a.getName());
                System.out.println("3: " + c.getName());
            }
            //Αν η c είναι δεύτερη
            else if(a.calcPoints() < c.calcPoints()){
                System.out.println("2: " + c.getName());
                System.out.println("3: " + a.getName());
            }
            //Αν η a και η c ισοβαθμούν στη δεύτερη θέση
            else if(a.calcPoints() == c.calcPoints()){
                //Η a έχει καλύτερη διαφορά τερμάτων απ'τη c
                if(a.calcTotalScore() > c.calcTotalScore()){
                    System.out.println("2: " + a.getName());
                    System.out.println("3: " + c.getName());
                }
                //Η c έχει καλύτερη διαφορά τερμάτων απ'τη a
                else if(a.calcTotalScore() < c.calcTotalScore()){
                    System.out.println("2: " + c.getName());
                    System.out.println("3: " + a.getName());
                }
                //Έχουν την ίδια διαφορά τερμάτων
                else if(a.calcPoints() == c.calcPoints()){
                    System.out.println("2: " + a.getName());
                    System.out.println("2: " + c.getName());
                }
            }
        }
        
        //Αν η c είναι πρωτοπόρος
        if(winner.equals(c.getName())){
            System.out.println("1: " + winner);
            //Αν η a είναι δεύτερη
            if(a.calcPoints() > b.calcPoints()){
                System.out.println("2: " + a.getName());
                System.out.println("3: " + b.getName());
            }
            //Αν η b είναι δεύτερη
            else if(a.calcPoints() < b.calcPoints()){
                System.out.println("2: " + b.getName());
                System.out.println("3: " + a.getName());
            }
            //Αν η a και η b ισοβαθμούν στη δεύτερη θέση
            else if(a.calcPoints() == b.calcPoints()){
                //Η a έχει καλύτερη διαφορά τερμάτων απ'τη b
                if(a.calcTotalScore() > b.calcTotalScore()){
                    System.out.println("2: " + a.getName());
                    System.out.println("3: " + b.getName());
                }
                //Η b έχει καλύτερη διαφορά τερμάτων απ'τη a
                else if(a.calcTotalScore() < b.calcTotalScore()){
                    System.out.println("2: " + b.getName());
                    System.out.println("3: " + a.getName());
                }
                //Έχουν την ίδια διαφορά τερμάτων
                else if(a.calcPoints() == b.calcPoints()){
                    System.out.println("2: " + a.getName());
                    System.out.println("2: " + b.getName());
                }
            }
        }
    }
}