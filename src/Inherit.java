class Nokia1{
// Parent class

    int x,y;
    Nokia1(int p, int q){
        x = p;
        y = q;
        System.out.println(" parent constructor executed.");
    }
    void f1(){
        System.out.println("parent function 1 executed.");
}
void f2(){
    System.out.println("parent function 2 executed.");
    }
}
class Nokia2 extends Nokia1 {
    int z;
    void f3(){
        System.out.println("child function 1 executed.");
}
Nokia2() {
        super(6,7);
    System.out.println("child constructor executed.");
}
}
public class Inherit {
        public static void main(String[] args) {
    Nokia2 n1 = new Nokia2();
    n1.f1();
    n1.f2();
    n1.f3();


        }
}

