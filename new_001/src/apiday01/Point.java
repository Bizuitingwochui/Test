package apiday01;

public class Point {

    private int x;
    private int y;
    public int getX(){              //getter
        return this.x;
    }

    public void setX(int x){        //setter
        if (x >= 0){
            this.x = x;
        }
    }

    public int getY(){
        return this.y;
    }

    public void setY(int y){
        this.y = y;
    }

}
