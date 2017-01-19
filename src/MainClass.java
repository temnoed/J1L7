
//        1) Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды(например, в миске 10 еды, а кот пытается покушать 15-20)
//        2) Каждому коту нужно добавить поле сытость(когда создаем котов, они голодны). Если коту удалось покушать(хватило еды), сытость = true
//        3) Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
//        4) Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainClass {
    static class Cat {
        private String name;
        private int appetite;

        public Cat(String name, int appetite) {
            this.name = name;
            this.appetite = appetite;
        }

        public void eat(Plate p) {
            // Дом зад 1. Проверяем, чтобы небыло отрицательного значения еды в тарелке
            if (p.food >= appetite) p.decreaseFood(appetite);
            else p.food = 0;
        }
    }

    static class Plate {
        private int food;

        public void decreaseFood(int n) {
            food -= n;
        }

        public Plate(int food) {
            this.food = food;
        }

        public void info() {
            System.out.println("plate: " + food);
        }
    }

    <T> void ConvertToArrayList(ArrayList<T> al, T[] AG) {
        Collections.addAll(al, AG);
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik1", 5);
        Cat cat2 = new Cat("Barsik2", 50);
        Plate plate = new Plate(60);

        plate.info();
        cat1.eat(plate);
        cat2.eat(plate);
        plate.info();
    }
}
