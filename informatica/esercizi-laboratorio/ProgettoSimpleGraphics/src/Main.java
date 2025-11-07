import graphics.*; //equivalente di using namespace std; --> * significa che tutte le classi avranno l'import
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            //Line l = new Line(0,0,300,300);
            //l.draw();
            //Ellipse e = new Ellipse (100,100,100,100);
            //e.draw();
            Scanner in = new Scanner(System.in);
            System.out.println("vuoi disegnare un cerchio (1) o un rettanglo (2)");
            int scelta = in.nextInt();
            if (scelta ==1){
                Ellipse e = new Ellipse(100,100,100,100);
                e.fill();
                e.draw();
            }
            else{
                Rectangle r = new Rectangle (50,100,250,400);
                r.setColor(new Color(255,0,0));
                r.fill();
                r.draw();
            }
        }
    }
