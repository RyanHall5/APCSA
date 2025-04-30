package DownOnTheFarm;
public class Main {
    public static void main(String[] args) {

        Cow alexander = new Cow("Alexander", 425.0, 4, true);
        alexander.haveBirthday();

        Cow jeremy = new Cow();
        jeremy.makeNoise();


        Chicken clucker = new Chicken("Silkie", 14, true, 4);
        clucker.eatFood(10);

        Chicken andrew = new Chicken();
        andrew.makeNoise();


        Pig patty = new Pig("Red", 100, false, 456.0);
        patty.upgradePenSize(100);

        Pig john = new Pig();
        john.makeNoise();


        System.out.println();
        //display all 6 animals
        
        alexander.displayCow();
        System.out.println();

        jeremy.displayCow();
        System.out.println();

        clucker.displayChicken();
        System.out.println();
        
        andrew.displayChicken();
        System.out.println();
        
        patty.displayPig();
        System.out.println();

        john.displayPig();
        System.out.println();

    }
}