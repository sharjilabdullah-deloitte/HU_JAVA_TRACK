package Animall;

public class Main {
    public static void main(String[] args) {
        Animal obj = new Animal();
        obj.setType("Dog");
        System.out.println(obj.getType());
        obj.setBreed("German Shephard");
        System.out.println(obj.getBreed());
        obj.setOrigin("Germany");
        System.out.println(obj.getOrigin());

    }
}
