import java.util.*;

/**
 * 拟添加 登录类（包括账号密码登录，积分记录在数据库）
 * 菜单类
 * 其他游戏
 */

public class GamesPrac {
    public static void main(String[] args){
        Menu.choiceGames();
    }

}

/**
 * 创建用户类，储存用户编号成绩与姓名
 * 添加计算成绩的方法
 * 掷骰子游戏
 */
class Users {
    private int no;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    private int grade;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;



    Users(){

    }
    Users(int no,int grade,String name){
        this.no = no;
        this.grade = grade;
        this.name = name;
    }
}

/**
 * 创建游戏类，各类游戏的实现
 */
class Games{
    //游戏继续判断
    private static boolean GameAgain(){
        System.out.println("是否继续,请输入（y（继续）/n（结束））");
        Scanner keyInput = new Scanner(System.in);
        String userInput = keyInput.next();
        return userInput.equals("y");
    }
    static void mora(){
        List<String> moraList = new LinkedList<>();
        moraList.add("rock");
        moraList.add("paper");
        moraList.add("scissors");
        //界面显示
        System.out.println("**********************************");
        System.out.println("**********欢迎来到猜拳游戏**********");

        Scanner userInput = new Scanner(System.in);
        int userMora;
        int robotMora ;
        //创建迭代器
        //Iterator it = moraList.iterator();
        boolean isGoOn = true;
        while(isGoOn){
            //扫描用户输入，随机机器出招
            System.out.println("请输入1.石头；2.布；3.剪刀");
            userMora = userInput.nextInt()-1;
            robotMora = new Random().nextInt(3);
            //判断胜负
            if (userMora==robotMora){
                System.out.println("对方出拳"+moraList.get(robotMora)+"和局");
                isGoOn = GameAgain();
            }
            else if((userMora!=0&&userMora==robotMora+1)||(userMora==0&&robotMora==2)){
                System.out.println("对方出拳"+moraList.get(robotMora)+"你赢了！");
                isGoOn = GameAgain();
            }
            else{System.out.println("对方出拳"+moraList.get(robotMora)+"你输了！");
                isGoOn = GameAgain();
            }

        }
        Menu.choiceGames();
    }
    static void guessBigOrLess(){
        System.out.println("**********************************");
        System.out.println("**********欢迎来到猜大小***********");
        Scanner scanner = new Scanner(System.in);
        System.out.println("本游戏将有系统自动生成一个一百以内" +
                "（不包括）的整数，请以尽量少的步数猜" +
                "出它的大小");
        int stepTimes = 1;
        int userInput = scanner.nextInt();
        int robotInput = new Random().nextInt(100);
        while(userInput != robotInput){
            System.out.println(userInput > robotInput?"输入的数字大了":"输入的数字小了");
            stepTimes++;
            userInput = scanner.nextInt();
        }
        System.out.println("恭喜你，猜对了！一共猜了"+stepTimes+"次");

        Menu.choiceGames();
    }
}
//菜单类
class Menu{
    //游戏选择界面
    static void choiceGames(){
        System.out.println("***********************************");
        System.out.println("********欢迎来到小游戏系统**********");
        System.out.println("*******本系统为haozk练手之用********");
        try{
            Thread.sleep(500);
        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("请选择游戏");
        System.out.println("0 退出游戏");
        System.out.println("1 猜拳游戏");
        System.out.println("2 猜大小");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        switch (userInput){
            //游戏类型选择，可添加
            case 0:
                System.exit(0);
            case 1:
                Games.mora();
                break;
            case 2:
                Games.guessBigOrLess();
                break;
            default:
                System.out.println("输入有误,请重试");
                Menu.choiceGames();

        }
    }
}