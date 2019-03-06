/*
Name:
Matric Number:
*/

public class Tournament {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M, N;

        M = sc.nextInt();
        N = sc.nextInt();

        for (int i = 0; i < M; i++) {
            
        }
	}
}

class Participant {
    //define the appropriate attributes and constructor
    private int cardNumber;
    private int seatNumber;
    private int totalPoints;
    private String name;

    public Participant(String name, int number) {
        this.name = name;
        this.cardNumber = number;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int number) {
        cardNumber = number;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int number) {
        seatNumber = number;
    }

    public String getName() {
        return name;
    }

    public void calculatePoints() {
        
    }

}
