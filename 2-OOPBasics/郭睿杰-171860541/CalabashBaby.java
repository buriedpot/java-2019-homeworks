/*七种颜色的枚举类型Color*/
enum Color {
    red, orange, yellow, green, cyan, blue, purple
}
public class CalabashBaby {
    private Color color;//颜色
    private int range;//排行
    /*构造器*/
    public CalabashBaby(){}
    public CalabashBaby(Color color){
        this.color = color;//获取颜色
        range = this.color.ordinal();//获取排行
    }
    /*按颜色来比较的函数*/
    public boolean cmpcolor(CalabashBaby baby) { //按照颜色排序，赤橙黄绿青蓝紫
        return this.color.ordinal() < baby.color.ordinal();
    }
    /*按排行来比较的函数*/
    public boolean cmprange(CalabashBaby baby) {
        return this.range < baby.range;
    }
    /*更改值*/
    public void set(Color color) {
        this.color = color;
        this.range = this.color.ordinal();//更改颜色别忘了更改排行
    }
    /*获取值*/
    public Color getcolor() {
        return this.color;
    }
    /*report number -> number when changing the location*/
    public void reportchange(int src, int dest) {
        reportrange();//先自报姓名
        System.out.println(": " + src + "->" + dest);//再报变化
    }
    /*自报姓名*/
    public void reportrange() {
        switch (color) {
            case red: System.out.print("老大"); break;
            case orange: System.out.print("老二"); break;
            case yellow: System.out.print("老三"); break;
            case green: System.out.print("老四"); break;
            case cyan: System.out.print("老五"); break;
            case blue: System.out.print("老六"); break;
            case purple: System.out.print("老七"); break;
        }
    }
    /*自报顏色*/
    public void reportcolor() {
        switch (color) {
            case red: System.out.print("红色"); break;
            case orange: System.out.print("橙色"); break;
            case yellow: System.out.print("黄色"); break;
            case green: System.out.print("绿色"); break;
            case cyan: System.out.print("青色"); break;
            case blue: System.out.print("蓝色"); break;
            case purple: System.out.print("紫色"); break;
        }
    }
    /*测试类的正常工作*/
    public static void main(String[] args) {
        CalabashBaby n = new CalabashBaby();
        n.color = Color.red;
        System.out.println(n.color);
    }
}
