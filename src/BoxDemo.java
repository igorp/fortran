import java.awt.*;

public class BoxDemo extends Canvas {
    public static void main(String[] args) {
        
        for(int i = 0; i < 3; i++) {
            System.out.println("Hello World!");            
        }
        Box b = new Box();
        b.setSize(5);
        System.out.println("Side size is "  + b.getSize());
        if(b.getSize() > 10) {
            System.out.println("Box is big");
        }
        else {
            System.out.println("Box is small");
        }
        
    }
}