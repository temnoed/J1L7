//
import java.util.Random;

public class MainClass {
	static class Cat {
		private String name;
		private int appetite;
		private boolean fullness;

		public Cat(String name, int appetite) {
			this.name = name;
			this.appetite = appetite;
			this.fullness = false; // Дом зад 2. Добавляем сытость и выводим инфо про котов.
		}

		public void info() {
			System.out.println(this.name + " апетит: " + this.appetite + " сытость:" + this.fullness);
		}

		public void eat(Plate p) {
			// Дом зад 1. Проверяем, чтобы не было отрицательного значения еды в тарелке
			if (!this.fullness) { // если кот вообще голодный, то ест
				if (p.food >= appetite) {
					p.decreaseFood(appetite);
					this.fullness = true;
				} else {
					p.food = 0;
					this.fullness = false;
				}
			}
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

		public void addFood(int _food) { // Дом зад 3. Добавляем ещё еды в тарелку.
			this.food += _food;
		}
	}
//    <T> void ConvertToArrayList(ArrayList<T> al, T[] AG) {
//        Collections.addAll(al, AG);
//    }

	public static void main(String[] args) {
		final int NUM_CATS = 10; // Дом зад 3. Всего столько котов. Обрабатываем их циклом и случайным апетитом.
		Random rand = new Random();
		Cat[] cats = new Cat[NUM_CATS];
		Plate plate = new Plate(200);

		for (int i = 0; i < NUM_CATS; i++) { // Заводим всех котов
			cats[i] = new Cat("Barsik" + i, 5 + rand.nextInt(50));
		}

		plate.info();
		plate.addFood(100);
		plate.info();
		for (Cat i : cats) {
			i.info();
			i.eat(plate);
		}
		plate.info();
		for (Cat i : cats) {
			i.info();
		}
	}
}