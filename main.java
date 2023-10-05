public class Main{
	public static void main(String[] args) {
		Cat kitty = new Cat("Пася", 10, "Илья");
		kitty.meow();
	}
}

class Cat{
    private String name;
    private int age;
    private String owner;
    
    Cat(String name, int age, String owner){
        this.name = name;
        this.age = age;
        this.owner = owner;
    }
    
    void get_name(String name){
        this.name = name;
    }
    
    void get_age(int age){
        this.age = age;
    }
    
    void meow(){
        if (age <= 1){
            System.out.println("мяу");
        }else {
            System.out.println("МЯУУУ");
        }
    }
    
    void squeeze_milk(){
        System.out.println("облизал молоко");
    }
    
    void jump(){
        System.out.println("Прыг-прыг");
    }
    
}