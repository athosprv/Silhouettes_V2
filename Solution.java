   import java.io.*;
   import java.util.LinkedList;
   import java.util.Scanner;
   import java.util.Stack;

    public class Solution
   {
       public static void run(BufferedReader in, PrintWriter out)

        throws IOException
      {
         action(in, out);
      }
        
       public static void action(BufferedReader in, PrintWriter out)throws IOException
      {
         String n = in.readLine();
         Scanner sc = new Scanner(n);

         LinkedList<LinkedList> mainList = new LinkedList<LinkedList>();
         LinkedList<LinkedList> answerList = new LinkedList<LinkedList>();
         int counter = 0;
         
         while(n!=null)
         {
            System.out.println("test: "+ counter + " initiated");
            mainList = insertObj(mainList, in, n, sc);
            System.out.println("objects inserted");
            answerList=DAC(mainList);
            System.out.println("Recursion done");
            printList(answerList, out);
            System.out.println("Info sent");
            mainList.clear();
            answerList.clear();            
            System.out.println("Test passed");
            out.println();
            out.flush();
            n=in.readLine();
            counter ++;
         }
         System.out.println("Operations complete!");
         out.println();
         out.flush();

      }
       public static LinkedList<LinkedList> DAC(LinkedList<LinkedList> mainList)
       {

           if(mainList.size()<=1)
               return mainList;
           
           LinkedList<LinkedList> leftList = new LinkedList<LinkedList>(),
                                 rightList = new LinkedList<LinkedList>(),
                                 answerList = new LinkedList<LinkedList>();
          
           int middle = mainList.size()/2;

           for(int i=0; i<middle;i++)
               leftList.add(mainList.get(i));

           for(int i=middle; i<mainList.size();i++)
               rightList.add(mainList.get(i));

           leftList = DAC(leftList);
           rightList = DAC(rightList);

           if(leftList.size()==1 && rightList.size()==1)
           {
               answerList.add(mergeLists(leftList.getFirst(), rightList.getFirst()));
           }

           return answerList;
       }

       public static void printList(LinkedList<LinkedList> answerList, PrintWriter out)
      {
                for(int i = 0; i<answerList.size(); i++)
                {
                    for(int j = 0; j<answerList.get(i).size(); j++)
                    {
                        listObj x = (listObj)answerList.get(i).get(j);
                        out.println(x.x);
                        out.println(x.y);
                    }
                }
      }

       public static LinkedList<listObj> mergeLists(LinkedList<listObj> sil1, LinkedList<listObj> sil2)
      {

         LinkedList<listObj> finalSil = new LinkedList<listObj>();
         Stack<Integer> st1 = new Stack<Integer>(),
                        st2 = new Stack<Integer>(),
                        finalSt = new Stack<Integer>();
         st1.add(0);
         st2.add(0);
         finalSt.add(0);
         
         while(true)
         {
            try
            {
               if(sil1.size()==0 || sil2.size()==0)
               {
                  if(sil1.size()==0)
                  {
                     for(int i =0;i<sil2.size(); i++)
                        finalSil.add(sil2.get(i));
                  }
                  else if(sil2.size()==0)
                  {
                     for(int i =0;i<sil1.size(); i++)
                        finalSil.add(sil1.get(i));
                  }
                  break;
               }

               listObj a = sil1.getFirst();
               listObj b = sil2.getFirst();

               if(a.x.compareTo(b.x)<0)
               {
                  st1.add(a.y);

                  if(st1.peek()<st2.peek())
                     a.y = st2.peek();

                  if(a.y!=finalSt.peek())
                  {
                     finalSt.add(a.y);
                     finalSil.add(a);
                     sil1.removeFirst();
                  }
                  else
                     sil1.removeFirst();
               }
               else if(a.x.compareTo(b.x)>0)
               {
                  st2.add(b.y);

                  if(st2.peek()<st1.peek())
                     b.y = st1.peek();

                  if(b.y!=finalSt.peek())
                  {
                     finalSt.add(b.y);
                     finalSil.add(b);
                     sil2.removeFirst();
                  }
                  else
                     sil2.removeFirst();
               }
               else if(a.x.compareTo(b.x)==0)
               {
                  listObj c;

                  if(a.y>=b.y)
                     c=a;
                  else
                     c=b;

                  st1.add(a.y);
                  st2.add(b.y);

                  if(c.y!=finalSt.peek())
                  {
                     finalSt.add(c.y);
                     finalSil.add(c);
                     sil1.removeFirst();
                     sil2.removeFirst();
                  }
                  else
                  {
                     sil1.removeFirst();
                     sil2.removeFirst();
                  }
               }
            }
                catch (Exception e)
                {
                  return finalSil;
                }
         }
            return finalSil;
      }
       
       public static LinkedList<LinkedList> insertObj(LinkedList<LinkedList> mainList, BufferedReader in, String n, Scanner sc)throws IOException
      {
            sc = new Scanner(n);
            while(sc.hasNext())
            {
               LinkedList<listObj> buildList = new LinkedList<listObj>();

                listObj obj1 = new listObj((Integer)sc.nextInt(), (Integer)sc.nextInt()),
                        obj2 = new listObj(obj1.x+(Integer)sc.nextInt(), 0);
    
                buildList.add(obj1);
                buildList.add(obj2);
                mainList.add(buildList);

                n = in.readLine();
                sc = new Scanner(n);

                if(n.equals(""))
                {
                    return mainList;
                }
            }
            return mainList;
        
      }
       public static class listObj
      {
          Integer x;
          Integer y;

          public listObj()
         {
            x = 0;
            y = 0;
         }

          public listObj(int a, int b)
         {
            x = a;
            y = b;
         }
          public String toString()
         {
              return "\n" +x + "\n"+ y;
         }
    
      }
   }




