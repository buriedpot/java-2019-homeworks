import java.util.Random;
public class Main {
    /*要求各葫芦娃报排行*/
    private void reportrange(CalabashBaby[] babies, int n){
        for (int i = 0; i < n; ++i) {
            babies[i].reportrange();
            System.out.print(" ");
        }
        System.out.println();
    }
    /*要求各葫芦娃报颜色*/
    private void reportcolor(CalabashBaby[] babies, int n){
        for (int i = 0; i < n; ++i) {
            babies[i].reportcolor();
            System.out.print(" ");
        }
        System.out.println();
    }
    /*此函数用于产生一个随机站队方法*/
    public int[] producerand(int n){ //产生乱序的0到6的排列，用于实现随便站队
        int[] rands = new int[n];
        for (int i = 0; i < n; ++i){
            rands[i] = -1;//表示此位置未站人
        }
        Random rand = new Random();
        int count = 0;
        while (count < 7) {
            int index = rand.nextInt(n);
            if (rands[index] == -1) {
                rands[index] = count;//此位置给某颜色葫芦娃
                ++count;
            }
        }
        return rands;
    }
    /*主函数，执行用*/
    public static void main(String[] args) {
        CalabashBaby[] babies = new CalabashBaby[7];
        Main m = new Main();
        Sort s = new Sort();
        /*冒泡排序*/
        int[] rands = m.producerand(7);//产生一个随机排队的队列
        Color[] colors = Color.values();//获取颜色数组
        for (int i = 0; i < 7; ++i) {
            babies[i] = new CalabashBaby();
            babies[i].set(colors[rands[i]]);//设置颜色
            //System.out.println(colors[rands[i]]);
        }
        /*排队前报数*/
        System.out.print("随机站队序列：");
        m.reportrange(babies, 7);
        s.bubblesort(babies, 7);
        /*排序后报数*/
        System.out.print("排序完毕报数：");
        m.reportrange(babies, 7);

        /*二分插入排序*/
        rands = m.producerand(7);//产生一个随机排队的队列
        for (int i = 0; i < 7; ++i) {
            babies[i] = new CalabashBaby();
            babies[i].set(colors[rands[i]]);//设置颜色
            //System.out.println(colors[rands[i]]);
        }
        System.out.print("随机站队序列：");
        m.reportcolor(babies, 7);
        s.binarysort(babies, 7);
        System.out.print("排序完毕报数：");
        m.reportcolor(babies, 7);
    }
}
