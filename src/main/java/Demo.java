
import java.util.Random;

public class Demo {

    public static class Character {
        int health;
        int power;
        public void kick (Character c) {}
        public boolean isAlive() {
            return health > 0;
        }

        public void setHp(int value) {
            if (value < 0) {
                System.out.println("Can't set negative health to a character!");
                return;
            }
            this.health = value;
        }

        public void setPower(int value) {
            this.power = value;
        }

        public int getHp(){
            return health;
        }
        public int getPower(){
            return power;
        }

        public String toString(){
            return getClass().getSimpleName() + "{hp=" + getHp() + ", power=" + getPower() + "}";
        }
    }

    public static class Hobbit extends Character {
        public Hobbit() {
            setHp(3);
            setPower(0);
        }

        @Override
        public void kick(Character c) {
            System.out.println("Oooooooh :(");
        }
    }

    public static class Elf extends Character {
        public Elf() {
            setHp(10);
            setPower(10);
        }

        @Override
        public void kick(Character c) {
            if (this.power > c.power) {
                c.setHp(0);
            }
            else{
                c.setPower(c.getPower() - 1);
            }
        }
    }

    public static class Human extends Character {

        @Override
        public void kick(Character c) {
            c.setHp(c.getHp() - randInt(0, this.getPower()) );
        }

    }

    public static class King extends Human {
        public King() {
            setHp(randInt(5, 15));
            setPower(randInt(5, 15));
        }
    }
    public static class Knight extends Human {
        public Knight() {
            setHp(randInt(2, 12));
            setPower(randInt(2, 12));
        }
    }

    public static class CharacterFactory {
        public Character CreateCharacter() {
            int c = randInt(0, 3);
            Character res = switch (c) {
                case 0 -> new Hobbit();
                case 1 -> new Elf();
                case 2 -> new King();
                default -> new Knight();
            };


            return res;
        }
    }

    public static class GameManager {
        public void fight(Character c1, Character c2){
            System.out.println("Fighters are getting ready..");
            System.out.println(c1.toString());
            System.out.println(c2.toString());
            System.out.println(" ");

            while (c1.getHp() != 0 && c2.getHp() != 0) {
                System.out.println(c1.getClass().getSimpleName() + "1" + " is attacking");
                c1.kick(c2);


                if (c2.getHp() <= 0) {
                    System.out.print("Fighter 2 has died!");
                    break;
                }

                System.out.println(c2.getClass().getSimpleName() + "2" + " is attacking");
                c2.kick(c1);

                if (c1.getHp() <= 0) {
                    System.out.print("Fighter 1 has died!");
                    break;
                }

            }
        }
    }

    public static int randInt(int a, int b) {
        Random rd = new Random();
        return rd.nextInt((b - a) + 1) + a;
    }
}