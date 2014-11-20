import java.util.HashSet;
import java.util.Set;

/**
 * Created by sujeet on 20/11/14.
 */
public class DictionaryWord {
    private static char[][] matrix =new char[][]{{'a','b','c','d'},{'e','f','g','h'},{'i','j','k','l'},{'m','n','o','p'}};
    private static int dim_x = 4;
    private static int dim_y = 4;
    private static Set<String> wordSet = new HashSet<String>();

    public static void main(String[] args)
    {
  /*      for(int i =0 ; i<dim_x;i++)
        {
            for(int j=0;j<dim_y;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }*/

        wordSet.add("i");
        wordSet.add("abfg");
        wordSet.add("mnop");
        wordSet.add("abfeijkhc");

        for(int x =0;x<dim_x;x++)
        {
            for(int y=0;y<dim_y;y++)
            {
                checkAndPrint(matrix[x][y]+"");
                int[][] visitedMap = new int[dim_x][dim_y];
                visitedMap[x][y] = 1;
                recursion(matrix[x][y]+"",visitedMap,x,y);
            }
        }
    }

    private static void checkAndPrint(String word)
    {
        if(wordSet.contains(word))
        {
            System.out.println("YES "+word);
        }else{
            //System.out.println("NOT "+word);
        }
    }

    private static void recursion(String word,int[][] visitedMap,int x,int y)
    {
        if(word.equals("ab"))
        {
            System.out.println("HERE "+x+"*"+y);
            for(int i =0 ; i<dim_x;i++)
            {
                for(int j=0;j<dim_y;j++)
                {
                    System.out.print(visitedMap[i][j]+" ");
                }
                System.out.println();
            }
        }

        for(int i = Math.max(x - 1, 0);i<Math.min(x + 2, dim_x);i++)
        {
            for(int j = Math.max(y - 1, 0);j<Math.min(y + 2, dim_y);j++)
            {        if(word.equals("ab"))
                System.out.println("POSSIBLE WORD "+word+matrix[i][j]);
                if(visitedMap[i][j] == 1)
                {        if(word.equals("ab"))
                    System.out.println("Visited "+i+"*"+j);
                    continue;
                }else{
                    if(word.equals("ab"))
                        System.out.println("visiting "+i+"*"+j);
                    visitedMap[i][j] = 1;
                    checkAndPrint(word+matrix[i][j]);
                    recursion(word+matrix[i][j],visitedMap,i,j);
                }
            }
        }
    }

}
