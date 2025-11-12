public class Test {
    public static void main(String[] args) {
        B test = new B(1);
        System.out.println(test);
    }
}

class A{
    private int attr;

    @Override
    public String toString(){
        return "" + attr;
    }
}
class B extends A{


    private int attr;

    public B(int c){
        super();
        this.attr = c;
    }

    @Override
    public String toString() {
        return super.toString() + " " + attr;
    }
}
