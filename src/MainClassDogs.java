public class MainClassDogs {
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
            if (ball.owner == this) {
                System.out.println(name + ": я уже играю с этим мячом");
                return;
            }
            if (ball.owner == null) {
                System.out.println(name + " играет с мячом " + ball.color);
                ball.owner = this;
                myBall = ball;
            } else {
                if(size > ball.owner.size) {
                    System.out.println(name + " отобрал мяч у " + ball.owner.name);
                    ball.owner.myBall = null;
                    myBall = ball;
                    ball.owner = this;
                } else
                System.out.println(name + ": не могу отобрать");
            }
        }

        public void stop() {
            if (myBall != null) {
                System.out.println(name + " перестал играть с мячом " + myBall.color);
                myBall.owner = null;
                myBall = null;
            } else {
                System.out.println(name + ": ни с чем не играет");
            }
        }
    }

    static class Ball {
        String color;
        Dog owner;
        public Ball(String color) {
            this.color = color;
            this.owner = null;
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
