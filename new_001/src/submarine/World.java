package submarine;

public class World {    //游戏窗口
    public static void main(String[] args) {



        BattleShip s = new BattleShip();
        ObserveSubmarine os1 = new ObserveSubmarine();
        ObserveSubmarine os2 = new ObserveSubmarine();
        ObserveSubmarine os3 = new ObserveSubmarine();
        ObserveSubmarine os4 = new ObserveSubmarine();
        TorpedoSubmarine ts1 = new TorpedoSubmarine();
        TorpedoSubmarine ts2 = new TorpedoSubmarine();
        MineSubmarine ms1 = new MineSubmarine();
        MineSubmarine ms2 = new MineSubmarine();
        Mine m1 = new Mine(123,321);
        Mine m2 = new Mine(456,645);
        Bomb b1 = new Bomb(789,987);
        Bomb b2 = new Bomb(147,741);

        System.out.println("这是第一个素材的数据");
        System.out.println(s.x+","+s.y+","+s.height+","+s.width+","+s.speed+","+s.life);

        System.out.println("这是第二个素材的数据");
        System.out.println(os1.x+","+os1.y+","+os1.height+","+os1.width+","+os1.speed);
        System.out.println(os2.x+","+os2.y+","+os2.height+","+os2.width+","+os2.speed);
        System.out.println(os3.x+","+os3.y+","+os3.height+","+os3.width+","+os3.speed);
        System.out.println(os4.x+","+os4.y+","+os4.height+","+os4.width+","+os4.speed);

        System.out.println("这是第三个素材的数据");
        System.out.println(ts1.x+","+ts1.y+","+ts1.height+","+ts1.width+","+ts1.speed);
        System.out.println(ts2.x+","+ts2.y+","+ts2.height+","+ts2.width+","+ts2.speed);

        System.out.println("这是第四个素材的数据");
        System.out.println(ms1.x+","+ms1.y+","+ms1.height+","+ms1.width+","+ms1.speed);
        System.out.println(ms2.x+","+ms2.y+","+ms2.height+","+ms2.width+","+ms2.speed);

        System.out.println("这是第五个素材的数据");
        System.out.println(m1.x+","+m1.y+","+m1.height+","+m1.width+","+m1.speed);
        System.out.println(m2.x+","+m2.y+","+m2.height+","+m2.width+","+m2.speed);

        System.out.println("这是第六个素材的数据");
        System.out.println(b1.x+","+b1.y+","+b1.height+","+b1.width+","+b1.speed);
        System.out.println(b2.x+","+b2.y+","+b2.height+","+b2.width+","+b2.speed);




    }
}
