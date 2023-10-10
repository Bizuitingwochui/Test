package com.tedu;

import com.tedu.entity.*;
import com.tedu.entity.other.*;
import com.tedu.entity.plant.*;
import com.tedu.entity.plantcard.PeashooterCard;
import com.tedu.entity.plantcard.PlantCard;
import com.tedu.entity.plantcard.SunFlowerCard;
import com.tedu.entity.plantcard.*;
import com.tedu.entity.zombie.*;
import com.tedu.img.Images;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.List;
import java.util.Timer;

/**
 * 主界面
 *
 * @author Yoki
 * @create 2023/2/18 9:56
 **/
public class JpanelBuilder extends JPanel {
    /**
     * 默认模式 :收集阳光模式
     */
    public static final int SUNSHINE_MODE = 0;
    /**
     * 种植模式 :选择植物种植
     */
    public static final int PLANT_MODE = 1;
    /**
     * 铲铲模式 :移除不需要的植物
     */
    public static final int REMOVE_MODE = 2;
    /**
     * 游戏结束
     */
    public static final int GAME_OVER = 100;
    /**
     * 游戏准备就绪
     */
    public static final int GAME_READY = 101;
    /**
     * 游戏加载
     */
    public static final int GAME_LOADING = 102;
    public static final int GAME_WIN = 103;
    /**
     * 游戏状态
     */
    public static int state = GAME_READY;
    /**
     * 阳光数
     */
    private static int sunshine = 0;
    /**
     * 界面长度
     */
    public static final int WIDTH = 900;
    /**
     * 界面宽度
     */
    public static final int HEIGHT = 600;
    /**
     * 加载动画
     */
    private static ReadyGif loadGif = new ReadyGif(Images.PrepareGrowPlants);
    /**
     * 一大波僵尸动画
     */
    private static ReadyGif largeWave = new ReadyGif(Images.LargeWave);
    /**
     * 最后一波僵尸动画
     */
    private static ReadyGif finalWave = new ReadyGif(Images.FinalWave);
    /**
     * 进度条
     */
    private static FlagMeter flagMeter = new FlagMeter(50);
    /**
     * 所有植物
     */
    private static Plant[][] plants = new Plant[9][5];
    /**
     * 所有子弹
     */
    private static List<PB00> ammo = new ArrayList<>();
    /**
     * 阳光
     */
    private static List<Sunshine> suns = new ArrayList<>();
    /**
     * 所有僵尸对象
     */
    private static List<Zombie> zombies = new ArrayList<>();
    /**
     * 所有植物卡片
     */
    private static List<PlantCard> plantCards = new ArrayList<>();
    /**
     * 所有小车
     */
    private static LawnMower[] lawnMowers = new LawnMower[5];


    /**
     * 主方法,构建界面并调用运行方法
     *
     * @param args
     */
    public static void main(String[] args) {
        //主界面
        JFrame world = new JFrame();
        JpanelBuilder jpanelBuilder = new JpanelBuilder();
        //jpanel可获得焦点
        jpanelBuilder.setFocusable(true);
        //将panel添加入frame
        world.add(jpanelBuilder);
        //设置关闭状态为退出即关闭
        world.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置界面大小
        world.setSize(WIDTH + 6, HEIGHT + 29);
        //设置相对位置为屏幕中心
        world.setLocationRelativeTo(null);
        //设置界面不可调整大小
        world.setResizable(false);
        //设置界面可见
        world.setVisible(true);
        //调用运行方法
        jpanelBuilder.action();
    }

    /**
     * 重写绘制方法
     *
     * @param g the <code>Graphics</code> context in which to paint
     */
    @Override
    public void paint(Graphics g) {
        //绘制背景
        g.drawImage(Images.background, -150, 0, null);
        if (state == REMOVE_MODE) {
            if (!(numX == null || numY == null || plants[numX][numY] == null)) {
                //当为铲铲模式鼠标在有植物的草块上时生成一个阴影
                g.drawImage(Images.selectPlant, (JpanelBuilder.WIDTH - 150) / 9 * numX + 90, (JpanelBuilder.HEIGHT - 85) / 5 * numY + 110, null);
            }
        }
        //绘制小车
        for (LawnMower lawnMower : lawnMowers) {
            if (lawnMower == null) {
                continue;
            }
            g.drawImage(lawnMower.getImages().image, lawnMower.x + lawnMower.imageX, lawnMower.y + lawnMower.imageY, null);
        }
        //绘制植物
        for (Plant[] plants1 : plants) {
            for (Plant plant : plants1) {
                //如果该格没有植物则直接跳过绘制步骤
                if (plant == null) {
                    continue;
                }
                if (plant instanceof Jalapeno) {
                    Jalapeno jalapeno = (Jalapeno) plant;
                    if (plant.state == Jalapeno.FIRE_MODE) {
                        g.drawImage(jalapeno.fire().image, 85, plant.y + 20, null);
                        continue;
                    }
                }
                GifFrame plantImage = plant.getImages();
                g.drawImage(plantImage.image, plant.x + plant.imageX, plant.y + plant.imageY, null);
            }
        }
        //绘制僵尸
        for (Zombie zombie : zombies) {
            GifFrame zombieImage = zombie.getImages();
            if (zombieImage == null) {
                continue;
            }
            g.drawImage(zombieImage.image, zombie.x + zombie.imageX, zombie.y + zombie.imageY, null);
            if (zombie.isDying() && zombie.deathWalk) {
                g.drawImage(zombie.getHeadImages().image, zombie.headX + zombie.headImageX, zombie.headY + zombie.headImageY, null);
            }
        }
        //绘制子弹
        for (PB00 pb00 : ammo) {
            GifFrame pb00Image = pb00.getImages();
            g.drawImage(pb00Image.image, pb00.x, pb00.y, null);
        }
        //绘制阳光
        for (Sunshine sun : suns) {
            GifFrame sunImage = sun.getImages();
            g.drawImage(sunImage.image, sun.x + sun.imageX, sun.y + sun.imageY, null);
        }
        //绘制植物卡片
        for (PlantCard plantCard : plantCards) {
            g.drawImage(plantCard.getImage(), plantCard.x, plantCard.y, null);
            //绘制需要的阳光数
            g.drawString(String.valueOf(plantCard.sunshine), plantCard.x + plantCard.width - 30, plantCard.y + plantCard.height - 10);
            //绘制覆盖卡片的阴影(作为加载条使用)
            g.drawImage(plantCard.shadow, plantCard.x, plantCard.y, null);
        }

        //绘制种植模式阴影
        if (state == PLANT_MODE) {
            //如果鼠标未处于草地上,则取消绘制
            //如果该草地上有植物,则取消绘制
            if (!(numX == null || numY == null || plants[numX][numY] != null)) {
                //当为种植模式鼠标在没有植物的草块上时生成一个阴影
                g.drawImage(Images.selectPlant, (JpanelBuilder.WIDTH - 150) / 9 * numX + 90, (JpanelBuilder.HEIGHT - 85) / 5 * numY + 110, null);
            }
        }
        //绘制阳光板
        g.drawImage(Images.SunBack, 120, 10, null);
        //绘制阳光数
        g.drawString(String.valueOf(sunshine), 180, 33);
        //绘制进度条
        g.drawImage(flagMeter.getBackImages(), flagMeter.x, flagMeter.y, null);
        if (flagMeter.getLoadImages() != null) {
            g.drawImage(flagMeter.getLoadImages(), flagMeter.x + flagMeter.width - flagMeter.loadWidth, flagMeter.y, null);
        }
        //绘制铲子背景板
        g.drawImage(Images.ShovelBack, 250, 10, null);
        //当不处于铲铲模式时将铲子渲染在背景板前,当处于铲铲模式则渲染在鼠标位置
        if (state != JpanelBuilder.REMOVE_MODE)
            g.drawImage(Images.Shovel, 250, 10, null);
        else
            g.drawImage(Images.Shovel, mouseX, mouseY, null);
        //绘制最后一波动画
        if (!(state == GAME_OVER || state == GAME_READY || state == GAME_LOADING || state == GAME_WIN) && flagMeter.isOver() && lastIndex >= 100) {
            GifFrame image = largeWave.getImages(50);
            if (image == null) {
                image = finalWave.getImages(75);
                if (image == null) {
                    return;
                }
                g.drawImage(image.image, finalWave.x, finalWave.y, null);
                return;
            }
            g.drawImage(image.image, largeWave.x, largeWave.y, null);
        }
        //绘制游戏结束,若当前状态是游戏结束状态
        if (state == GAME_OVER) {
            //画界面阴影
            g.drawImage(Images.backgroundShadow, 0, 0, null);
            //画游戏结束图
            g.drawImage(Images.ZombiesWon, 168, 50, null);
        } else if (state == GAME_READY) {
            //画游戏LOGO
            g.drawImage(Images.logo, 0, 0, null);
        } else if (state == GAME_LOADING) {
            GifFrame image = loadGif.getImages(20);
            if (image == null) {
                state = SUNSHINE_MODE;
                return;
            }
            g.drawImage(image.image, loadGif.x, loadGif.y, null);
        }else if(state == GAME_WIN){
            //画界面阴影
            g.drawImage(Images.backgroundShadow, 0, 0, null);
            //画胜利奖杯
            g.drawImage(Images.trophy,WIDTH/2-Images.trophy.getWidth()/2,HEIGHT/2-Images.trophy.getHeight()/2,null);
        }
    }

    /**
     * 获取草地格中的X位置
     *
     * @param x
     * @return 格子X坐标
     */
    private Integer getGlassX(Integer x) {
        Integer numX = null;
        //将范围框选在草地中(要随背景修改)
        if (x > 100 && x < WIDTH - 55) {
            //将草地划分为9*5的区块
            numX = (x - 100) / ((WIDTH - 150) / 9);
        }
        return numX;
    }

    /**
     * 获取草地格中的Y位置
     *
     * @param y
     * @return 格子Y坐标
     */
    private Integer getGlassY(Integer y) {
        Integer numY = null;
        //将范围框选在草地中(要随背景修改)
        if (y > 60 && y < HEIGHT - 25) {
            //将草地划分为9*5的区块
            numY = (y - 60) / ((HEIGHT - 85) / 5);
        }
        return numY;
    }

    /**
     * 草地X区域坐标
     */
    private Integer numX = null;
    /**
     * 草地Y区域坐标
     */
    private Integer numY = null;

    /**
     * 获取当前鼠标位置(移动)
     */
    private void selectPlant(MouseEvent e) {
        numX = getGlassX(e.getX());
        numY = getGlassY(e.getY());
    }

    /**
     * 选中的卡片
     */
    private PlantCard plantCard = null;

    /**
     * 选择植物
     */
    private void pickCard(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Integer count = null;
        PlantCard plantCard1 = plantCards.get(0);
        //根据卡片的长度将卡片区域框选
        if (x > 0 && y > 0 && x < plantCard1.width && y < plantCards.size() * (plantCard1.height + 10)) {
            //获取当前区域鼠标所在位置,此处10为卡片和卡片直接空白区域
            int width = y % (plantCard1.height + 10);
            //如果当前区域鼠标超出卡片高度,则鼠标不处于卡片上
            if (width > plantCard1.height) {
                return;
            }
            //根据卡片高度区分区域
            count = y / (plantCard1.height + 10);
        }
        //如果鼠标未处于卡片上,则取消此次选择
        //如果选中卡片状态处于加载模式,则取消此次选择
        if (count == null || plantCards.get(count).isLoading() ||
                plantCards.get(count).isNoSunshine() || e.getButton() != 1) {
            state = SUNSHINE_MODE;
            return;
        }
        //根据区域获取卡片信息
        plantCard = plantCards.get(count);
        //将卡片模式设为选中模式
        plantCard.state = PlantCard.SELECTED_MODE;
        //将游戏状态设置为种植模式
        state = PLANT_MODE;
    }

    /**
     * 种植植物
     */
    private void plant(MouseEvent e) {
        Integer numX = getGlassX(e.getX());
        Integer numY = getGlassY(e.getY());
        //若鼠标未处于草地上,则取消这次种植
        //若当前没有选中卡片,则取消这次种植
        //若当前草地上有植物,则取消这次种植
        if (plantCard == null) {
            state = SUNSHINE_MODE;
            return;
        }
        if (numX == null || numY == null || plants[numX][numY] != null || e.getButton() != 1) {
            //重置所有参数
            plantCard.state = PlantCard.NORMAL_MODE;
            plantCard = null;
            state = SUNSHINE_MODE;
            return;
        }
        try {
            //获取有参类
            Constructor constructor = plantCard.plant.getDeclaredConstructor(int.class, int.class);
            //创造有参对象
            plants[numX][numY] = (Plant) constructor.newInstance(numX, numY);
            //将卡片状态修改为加载状态
            plantCard.state = PlantCard.LOADING_MODE;
            //消耗阳光
            sunshine -= plantCard.sunshine;
            //重置参数
            plantCard = null;
            state = SUNSHINE_MODE;
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 收获阳光
     */
    public void getSunshine(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        //遍历所有阳光
        for (Sunshine sun : suns) {
            //判断到鼠标放置在阳光上时移除该阳光并给予阳光数量
            if (x >= sun.x && y >= sun.y && x <= sun.x + sun.width && y <= sun.y + sun.height) {
                suns.remove(sun);
                sunshine += sun.sunshine;
                break;
            }
        }
    }

    /**
     * 切换铲铲模式
     */
    private void removeMode(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        //判断到鼠标放置在铲子区域时切换为铲铲模式,此时上面的铲子将跟随鼠标渲染
        if (x >= 250 && y >= 10 && x <= 250 + Images.ShovelBack.getWidth() && y <= 10 + Images.ShovelBack.getHeight()) {
            state = JpanelBuilder.REMOVE_MODE;
        }
    }

    /**
     * 移除植物
     */
    private void removePlant(MouseEvent e) {
        Integer numX = getGlassX(e.getX());
        Integer numY = getGlassY(e.getY());
        if (numX == null || numY == null || plants[numX][numY] == null || e.getButton() != 1) {
            //重置所有参数
            state = SUNSHINE_MODE;
            return;
        }
        plants[numX][numY] = null;
        state = SUNSHINE_MODE;
    }

    /**
     * 重置游戏
     */
    private void resetGame() {
        plants = new Plant[9][5];
        zombies = new ArrayList<>();
        sunshine = 0;
        ammo = new ArrayList<>();
        suns = new ArrayList<>();
        createIndex = 0;
        startCreateZombie = false;
        loadGif = new ReadyGif(Images.PrepareGrowPlants);
        largeWave = new ReadyGif(Images.LargeWave);
        finalWave = new ReadyGif(Images.FinalWave);
        flagMeter = new FlagMeter(50);
        lastZombies = null;
        lastIndex = 0;
        //添加小车
        for (int i = 0; i < 5; i++) {
            lawnMowers[i] = new LawnMower(i);
        }
    }

    int mouseX;
    int mouseY;


    /**
     * 运行方法 主要执行timer和事件
     */
    private void action() {
        //添加植物卡片
        plantCards.add(new SunFlowerCard(plantCards.size()));
        plantCards.add(new PeashooterCard(plantCards.size()));
        plantCards.add(new ChomperCard(plantCards.size()));
        plantCards.add(new CherryBombCard(plantCards.size()));
        plantCards.add(new WallNutCard(plantCards.size()));
        plantCards.add(new JalapenoCard(plantCards.size()));
        //添加小车
        for (int i = 0; i < 5; i++) {
            lawnMowers[i] = new LawnMower(i);
        }
        //timer(毫秒)
        //从xx秒开始隔xx秒执行一次
        int interval = 40;
        Timer timer = new Timer();
        //timer
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (state == GAME_OVER || state == GAME_READY||state == GAME_WIN) {
                    return;
                }
                if (state == GAME_LOADING) {
                    moveAction();
                    repaint();
                    return;
                }
                winAction();
                isPlantCanPlantAction();
                plantAction();
                outsideRemoveAction();
                moveAction();
                createAction();
                hurtAction();
                deadAction();
                loadingAction();
                repaint();
            }
        }, interval, interval);
        //点击事件
        MouseAdapter mouseAdapter = new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                //如果状态为种植模式则获取草地区域,如果状态为收集阳光模式则获取卡片区域
                if (state == GAME_LOADING) {
                } else if (state == GAME_OVER||state == GAME_WIN) {
                    state = GAME_READY;
                    resetGame();
                    repaint();
                } else if (state == GAME_READY) {
                    state = GAME_LOADING;
                } else if (state == PLANT_MODE) {
                    plant(e);
                } else if (state == SUNSHINE_MODE) {
                    getSunshine(e);
                    pickCard(e);
                    removeMode(e);
                } else if (state == REMOVE_MODE) {
                    removePlant(e);
                }
            }
        };
        this.addMouseListener(mouseAdapter);
        //移动事件
        MouseMotionAdapter mouseMotionAdapter = new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (state == GAME_OVER || state == GAME_READY || state == GAME_LOADING || state == GAME_WIN) {
                    return;
                }
                mouseX = e.getX();
                mouseY = e.getY();
                //如果状态为种植模式则获取草地区域,如果状态为收集阳光模式则获取卡片区域
                if (state == PLANT_MODE || state == REMOVE_MODE) {
                    selectPlant(e);
                }
            }

        };
        this.addMouseMotionListener(mouseMotionAdapter);
    }

    /**
     * 卡片加载方法
     */
    private void loadingAction() {
        for (PlantCard plantCard : plantCards) {
            plantCard.loading();
        }
    }

    /**
     * 移动方法
     */
    private void moveAction() {
        if (state == GAME_LOADING) {
            for (LawnMower lawnMower : lawnMowers) {
                if (lawnMower == null) {
                    continue;
                }
                lawnMower.move();
            }
            return;
        }
        //僵尸移动
        for (Zombie zombie : zombies) {
            zombie.move();
        }
        //子弹移动
        for (PB00 pb00 : ammo) {
            pb00.move();
        }
        //阳光移动
        for (Sunshine sun : suns) {
            sun.move();
        }
        for (LawnMower lawnMower : lawnMowers) {
            if (lawnMower == null) {
                continue;
            }
            if (lawnMower.isRush()) {
                lawnMower.move();
            }
        }
    }

    private int createIndex = 0;
    private Boolean startCreateZombie = false;
    private List<Zombie> lastZombies = null;
    private int lastIndex = 0;

    /**
     * 创建对象
     */
    private void createAction() {
        Random random = new Random();
        if (!startCreateZombie && createIndex / 900 == 1) {
            startCreateZombie = true;
        }
        if (createIndex % 150 == 0) {
            suns.add(new Sunshine());
        }
        if (flagMeter.isOver()) {
            lastIndex++;
        }
        //根据时间创建一只僵尸并放入僵尸数组中
        if (createIndex++ % (flagMeter.width - flagMeter.loadWidth + 30) == 0 && startCreateZombie && !flagMeter.isOver()) {
            zombies.add(flagMeter.randomZombie());
        } else if (flagMeter.isOver() && lastZombies == null) {
            lastZombies = flagMeter.finalWaveZombies();
        } else if (flagMeter.isOver() && lastZombies.size() != 0 && lastIndex == 200) {
            zombies.add(new FlagZombie());
        } else if (flagMeter.isOver() && lastZombies.size() != 0 && lastIndex >= 275) {
            int zombieNum = random.nextInt(lastZombies.size());
            zombies.add(lastZombies.get(zombieNum));
            lastZombies.remove(zombieNum);
        }

    }

    /**
     * 碰撞方法
     */
    private void hurtAction() {
        for (Zombie zombie : zombies) {
            if (zombie.health <= 0 && !(zombie.isDying() || zombie.isDead() || zombie.isBoomDie())) {
                zombie.state = Zombie.DYING_MODE;
                zombie.headX += zombie.x;
                zombie.headY += zombie.y;
                zombie.resetGif();
                continue;
            }
            int num = 0;
            for (int y : zombie.roadY) {
                if (zombie.y == y) {
                    break;
                }
                num++;
            }
            int plantCount = 0;
            for (int i = 0; i < 9; i++) {
                Plant plant = plants[i][num];
                if (plant == null) {
                    continue;
                }
                if (plant.width / 2 + plant.x >= zombie.x && plant.x - zombie.width / 2 <= zombie.x) {
                    if (zombie.state == PoleVaultingZombie.JUMP_MODE) {
                        zombie.resetGif();
                        zombie.state = PoleVaultingZombie.JUMPING_MODE;
                        continue;
                    } else if (zombie.state == Zombie.NORMAL_MODE) {
                        zombie.state = Zombie.EATING_MODE;
                        plant.injuring = true;
                    } else if (zombie.state == Zombie.DYING_MODE) {
                        plant.injuring = false;
                    }
                    if (plant.isInjuring()) {
                        plant.hurt();
                    }
                    if (plant.health <= 0) {
                        zombie.state = Zombie.NORMAL_MODE;
                        plant.state = Plant.DEAD_MODE;
                    }
                    plantCount++;
                }
            }
            if (plantCount == 0 && zombie.isEating()) {
                zombie.state = Zombie.NORMAL_MODE;
            }
            for (PB00 pb00 : ammo) {
                int pbY = pb00.y / 100;
                if (pb00.width + pb00.x >= zombie.x && pb00.x <= zombie.x + zombie.width && pbY == num
                        && zombie.state != Zombie.DYING_MODE && zombie.state != Zombie.DEAD_MODE) {
                    ammo.remove(pb00);
                    zombie.hurt();
                    break;
                }
            }
            int row = 0;
            for (LawnMower lawnMower : lawnMowers) {
                if (lawnMower == null) {
                    row++;
                    continue;
                }
                if (lawnMower.x + lawnMower.width >= zombie.x && lawnMower.x <= zombie.x + zombie.width && row == num) {
                    lawnMower.state = LawnMower.RUSH_MODE;
                    zombie.health = 0;
                }
                row++;
            }
        }
    }

    /**
     * 判断死亡方法
     */
    private void deadAction() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                Plant plant = plants[i][j];
                if (plant == null) {
                } else if (plant.isDead()) {
                    plants[i][j] = null;
                }
            }
        }
        List<Sunshine> removeSun = new ArrayList<>();
        List<Zombie> removeZombie = new ArrayList<>();
        for (Sunshine sun : suns) {
            if (sun.isRemove()) {
                removeSun.add(sun);
            }
        }
        for (Zombie zombie : zombies) {
            if (zombie.isDead()) {
                removeZombie.add(zombie);
            }
        }
        suns.removeAll(removeSun);
        zombies.removeAll(removeZombie);
    }

    /**
     * 植物独立技能方法
     */
    private void plantAction() {
        for (Plant[] plant : plants) {
            int row = 0;
            for (Plant plant1 : plant) {
                if (plant1 instanceof Peashooter) {
                    shoot(plant1, row);
                } else if (plant1 instanceof Chomper) {
                    ChomperEating(plant1, row);
                } else if (plant1 instanceof SunFlower) {
                    sunshine(plant1);
                } else if (plant1 instanceof CherryBomb) {
                    Boom(plant1, row);
                }
                if (plant1 instanceof Jalapeno) {
                    fire(plant1, row);
                }
                row++;
            }
        }
    }

    /**
     * 对象出界方法
     */
    private void outsideRemoveAction() {
        for (Zombie zombie : zombies) {
            if ((zombie.x + zombie.width / 2) <= 0 && !zombie.isDying()) {
                //当僵尸出界时则结束游戏
                state = GAME_OVER;
                break;
            }
        }
        for (PB00 pb00 : ammo) {
            if (pb00.x >= JpanelBuilder.WIDTH) {
                ammo.remove(pb00);
                break;
            }
        }
        int row = 0;
        for (LawnMower lawnMower : lawnMowers) {
            if (lawnMower == null) {
                row++;
                continue;
            }
            if (lawnMower.x >= JpanelBuilder.WIDTH) {
                lawnMowers[row] = null;
            }
            row++;
        }
    }

    /**
     * 卡片阳光充足判断
     */
    private void isPlantCanPlantAction() {
        for (PlantCard card : plantCards) {
            if (card.isLoading() || card.isSelected()) {
            } else if (card.sunshine > sunshine) {
                card.state = PlantCard.NOSUNSHINE_MODE;
            } else {
                card.state = PlantCard.NORMAL_MODE;
            }
        }
    }

    /**
     * 胜利判断
     */
    private void winAction() {
        if (flagMeter.isOver() && lastZombies != null && lastZombies.size() == 0 && zombies.size() == 0&&!(state==GAME_WIN)) {
            state = GAME_WIN;
        }
    }

    /**
     * 大嘴花吃人方法
     */
    private void ChomperEating(Plant plant, int row) {
        Chomper chomper = (Chomper) plant;
        for (Zombie zombie : zombies) {
            int i = zombie.y / 100;
            if (!(zombie.isDead() || zombie.isDying()) && plant.x - zombie.width / 2 < zombie.x && (plant.x + plant.width + 50) > zombie.x && i == row) {
                if (chomper.isNormal()) {
                    plant.resetGif();
                    plant.state = Chomper.ATTACKING_MODE;
                    break;
                } else if (chomper.isEating() && !chomper.kill) {
                    chomper.kill = true;
                    zombies.remove(zombie);
                    break;
                }
            }
        }
    }

    /**
     * 樱桃炸弹爆炸方法
     */
    private void Boom(Plant plant, int row) {
        CherryBomb cherryBomb = (CherryBomb) plant;
        for (Zombie zombie : zombies) {
            int i = zombie.y / 100;
            if (!(zombie.isDead() || zombie.isDying()) &&
                    plant.x - 60 < zombie.x + zombie.width &&
                    (plant.x + plant.width + 60) > zombie.x &&
                    (i == row || i == row + 1 || i == row - 1)) {
                if (cherryBomb.isDead()) {
                    zombie.state = Zombie.BOOM_DIE_MODE;
                    zombie.resetGif();
                }
            }
        }

    }

    /**
     * 豌豆射击方法
     */
    private void shoot(Plant plant, int row) {
        Peashooter peashooter = (Peashooter) plant;
        int bigX = 0;
        for (Zombie zombie : zombies) {
            int i = zombie.y / 100;
            if (i == row && zombie.x >= bigX) {
                bigX = zombie.x;
            }
        }
        if (peashooter.getCreateIndex() % 40 == 0 && plant.x <= bigX) {
            ammo.add(peashooter.shoot());
        }
    }

    /**
     * 向日葵产生阳光方法
     */
    private void sunshine(Plant plant) {
        SunFlower sunFlower = (SunFlower) plant;
        if (sunFlower.getCreateIndex() % 200 == 0) {
            suns.add(sunFlower.createSunshine());
        }
    }

    /**
     * 火爆辣椒爆炸方法
     */
    private void fire(Plant plant, int row) {
        Jalapeno jalapeno = (Jalapeno) plant;
        for (Zombie zombie : zombies) {
            int i = zombie.y / 100;
            if (!(zombie.isDead() || zombie.isDying()) && (i == row)) {
                if (jalapeno.isFire() && !zombie.isBoomDie()) {
                    zombie.state = Zombie.BOOM_DIE_MODE;
                    zombie.resetGif();
                }
            }
        }
    }
}
