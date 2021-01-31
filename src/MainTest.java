import main.java.figure.*;

import java.io.InputStream;
import java.util.Scanner;


public class MainTest {

    public static void main(String[] args) {
        Custom custom = new Custom(System.in);
        while (true) {
            custom.intro();
            int choice = (int) custom.readConsole();
            double side = custom.enterSide(choice);
            double option = custom.enterOption(choice);
            double[] params = new double[]{side, option};
            Shape shape = custom.getShape(choice, params);
            custom.calculate(shape);
            custom.outro();
            double check = custom.readConsole();
            if (check == 0) {
                custom.close();
                custom = null;
                System.gc();
                break;
            }
        }
    }


    //nested class for console input/output
    static class Custom {
        //input scanner
        private Scanner input;

        public Custom(InputStream input) {
            this.input = new Scanner(input);
        }

        //introduce text
        public void intro() {
            System.out.println("-----------------------------------------------------------------\n");
            System.out.println("Выберите тип равносторонней фигуры или круг. ВВедите число");
            System.out.println("0 - для круга;\n" +
                    "1 - для любого равностороннего многоугольника;\n" +
                    "2 - для прямоугольника;\n" +
                    "3 - для треугольника;\n" +
                    "4 - для квадрата;\n\n" +
                    "exit - для завершения программы.\n");
        }

        //end text
        public void outro() {
            System.out.println("-----------------------------------------------------------------\n");
            System.out.println("Расчет фигуры завершен. Хотите Выполнить расчет еще раз?");
            System.out.println("Любая клавиша - для продолжения;\n" +
                    "0 - для выхода из подпрограммы;\n" +
                    "exit - для завершения программы.\n");
        }

        //out of subprogram
        public void close() {
            this.input.close();
            System.out.println("ПОДПРОГРАММА ЗАВЕРШЕНА!");
        }

        //read side parameter from input scanner
        public double enterSide(int choice) {
            double res = 0;
            while (res <= 0) {
                if (choice == 0) {
                    System.out.println("Какой радиус круга?");
                } else if (choice == 2) {
                    System.out.println("Какой размер первой стороны прямоугольника?");
                } else {
                    System.out.println("Какой размер стороны выбранной фигуры?");
                }
                res = readConsole();
                if (res <= 0) {
                    System.out.println("Неверный ввод. Введите число больше 0.");
                }
            }
            return res;
        }

        //read second parameter (optional) from input scanner
        public double enterOption(int choice) {
            double res = 0;
            while (res <= 0) {
                if (choice == 1) {
                    System.out.println("Сколько вершин у Вашего многоугольника?");
                    res = readConsole();
                } else if (choice == 2) {
                    System.out.println("Какой размер второй стороны прямоугольника?");
                    res = readConsole();
                } else {
                    break;
                }
                if (res <= 0) {
                    System.out.println("Неверный ввод. Введите число больше 0.");
                }
            }
            return res;
        }

        //create and get object for current figure
        public Shape getShape(int choice, double[] params) {
            Shape[] shape = new Shape[]{
                    new Circle(params[0]),                         //for circles               (0 apexes, index - 0)
                    new EquiPolygon(params[0], (int) params[1]),   //for equilateral polygon   (n apexes, index - 1)
                    new Rectangle(params[0], params[1]),           //for rectangles            (4 apexes, index - 2)
                    new Triangle(params[0]),                       //for triangle              (3 apexes, index - 3)
                    new Square(params[0])                          //for square                (4 apexes, index - 4)
            };
            return (choice >= 0 && choice <= 4) ? shape[choice] : shape[1];
        }

        //read input data from console
        public double readConsole() {
            double num = 0;

            System.out.println("Выполните ввод: >");

            String str = this.input.nextLine();
            if (str.equals("exit")) {
                System.exit(0);                     //exit from program runtime
            } else if (str.matches("[0-9]+")) {
                num = Double.valueOf(str);
            } else {
                num = -1;
            }
            return num;
        }

        //calculate and show results for the figure
        public void calculate(Shape shape) {
            System.out.println("-----------------------\n");
            System.out.println("Параметры выбраной фигуры:");
            System.out.printf("%-28s %s\n", "Название:", shape.name());
            if (shape.num() == 1) {
                System.out.printf("%-28s %d\n", "Количество вершин (углов):", 0);
                System.out.printf("%-28s %.2f градусов\n", "Размер угла:" , shape.getAngle(0));
                System.out.printf("%-28s %.2f ед.\n", "Радиус:", ((Circle) shape).getRadius());
                System.out.printf("%-28s %.2f ед.\n", "Диаметр:", ((Circle) shape).getDiameter());
                System.out.printf("%-28s %.2f ед.\n", "Длина круга:", shape.perimeter());
            } else {
                System.out.printf("%-28s %d\n", "Количество вершин (углов):", shape.num());
                System.out.printf("%-28s %.2f градусов\n", "Размер угла:", shape.getAngle(0));
                System.out.printf("%-28s %.2f ед.\n", "Размер стороны:", shape.getSide(0));
                System.out.printf("%-28s %.2f ед.\n", "Периметр:", shape.perimeter());
            }
            System.out.printf("%-28s %.2f ед.кв.\n", "Площадь:", shape.area());
        }
    }

}
