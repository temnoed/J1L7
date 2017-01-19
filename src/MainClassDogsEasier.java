public class MainClassDogsEasier {
    static class Dog {
        String name;
        int size;
        Ball myBall;

        public Dog(String name, int size) {
            this.name = name;
            this.size = size;
            this.myBall = null;
        }

        public void play(Ball ball) {
            if (!ball.busy) {
                System.out.println(name + " играет с мячом " + ball.color);
                ball.busy = true;
                myBall = ball;
            } else {
                System.out.println("мяч занят");
            }
        }

        public void stop() {
            if (myBall != null) {
                System.out.println(name + " перестал играть с мячом " + myBall.color);
                myBall.busy = false;
                myBall = null;
            } else {
                System.out.println(name + ": ни с чем не играет");
            }
        }
    }

    static class Ball {
        String color;
        boolean busy;
        public Ball(String color) {
            this.color = color;
            this.busy = false;
        }
    }
    public static void main(String[] args) {
        Dog dog1 = new Dog("Bobik", 10);
        Dog dog2 = new Dog("Tuzik", 4);
        Ball ball = new Ball("Red");
        dog1.play(ball);
        dog2.play(ball);
    }
}
