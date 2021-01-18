import java.util.Scanner;

public class Snake {
    private static int[][] field;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int fieldSizeX ;
    private static int fieldSizeY ;
    private static final int RIGHT = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int UP = 3;
    private static int directoin = 0;
    private static int count=1;
    private static int x=0;
    private static int y=0;
    public static void main(String[] args) {
        Start(5,5);
        move(fieldSizeX*fieldSizeY+1);
        printField();
    }

    private static void Start(int xPosition,int yPosition){
        fieldSizeX =xPosition;
        fieldSizeY =yPosition;
        field = new int[fieldSizeX][fieldSizeY];


    }

    private static void move(int finishCount){
        if(count!=finishCount){ // проверяем конец цикла
            switch(directoin){
                case (0):
                    moveRight();
                    directoin++;
                case (1):
                    moveDown();
                    directoin++;
                case (2):
                    moveLeft();
                    directoin++;
                case (3):
                    moveUp();
                    directoin++;
                case (4):
                    directoin = 0;
            }
            move(finishCount);
        }
    }

    private static void moveRight(){ //движение в право
        for(int i = 0; i<fieldSizeX;i++) {
            if(count!=1)
                y+=1;
            field[x][y]=count;
            count++;
        }
        fieldSizeY-=1;
    }

    private static void moveDown(){ // джвижение вниз;
        for(int i = 0; i<fieldSizeY;i++) {
            x+=1;
            field[x][y]=count;
            count++;
        }
        fieldSizeX-=1;
    }

    private static void moveLeft(){ // движение в лево
        for(int i = fieldSizeX; i>0;i--) {
            y-=1;
            field[x][y]=count;
            count++;
        }
        fieldSizeY-=1;
    }

    private static void moveUp(){ // движение в верх
        for(int i = fieldSizeY; i>0;i--) {
            x-=1;
            field[x][y]=count;
            count++;
        }
        fieldSizeX-=1;
    }

    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < field.length * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        System.out.println();

        for (int i = 0; i < field[0].length; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < field.length ; j++)
                System.out.print(field[i][j] + "|");
            System.out.println();
        }

        for (int i = 0; i <= field.length  * 2 + 1; i++)
            System.out.print("-");
        System.out.println();
    }
}

