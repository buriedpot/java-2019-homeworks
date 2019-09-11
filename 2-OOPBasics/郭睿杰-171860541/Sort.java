public class Sort {
    /*二分法查找插入位置*/
    private int binarysearch(CalabashBaby[] babies, int left, int right, CalabashBaby x) {
        if (left > right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (x.cmpcolor(babies[mid])) {
            return binarysearch(babies, left, mid - 1, x);
        }
        else return binarysearch(babies, mid + 1, right, x);
    }
    /*冒泡，根据排行排序*/
    public void bubblesort(CalabashBaby[] babies, int n){

        /*按照排行排序*/
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - i - 1; ++j) {
                if (!babies[j].cmprange(babies[j + 1])) { //比较排行
                    babies[j].reportchange(j, j + 1);
                    babies[j + 1].reportchange(j + 1, j);
                    CalabashBaby temp = babies[j];
                    babies[j] = babies[j + 1];
                    babies[j + 1] = temp;
                }
            }
        }
        /*排队后报数*/

    }
    /*二分排序，理解为插入排序的查找过程使用二分查找，根据颜色排序*/
    public void binarysort(CalabashBaby[] babies, int n)  {
        for(int i = 0;i<babies.length;i++){
            CalabashBaby temp = babies[i];//待插入到前面有序序列的值
            int index = binarysearch(babies, 0, i - 1, temp);
            for(int j = i;j > index; --j){
                babies[j - 1].reportchange(j - 1, j);
                babies[j] = babies[j - 1];
            }
            if(index != i){ //不在原位
                babies[index] = temp;
            }
        }
        /*排队后报数*/

    }
}
