package alfa;

import alfa.modules.CircularList;

public class Task1 {

    public static void main(String[] args) {
        int n= Integer.parseInt(args[0]);
        int m= Integer.parseInt(args[1]);
        CircularList circularList=new CircularList();
        for (int i=1; i<=n;i++)
            circularList.addNode(i);
        circularList.traverseListWithStep(m);
    }
}
