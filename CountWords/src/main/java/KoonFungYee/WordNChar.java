package KoonFungYee;

import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

public class WordNChar extends RecursiveAction {
    private static final AtomicInteger count=new AtomicInteger();
    private static final AtomicInteger countChar=new AtomicInteger();
    private static final AtomicInteger countA=new AtomicInteger();
    private static final AtomicInteger countB=new AtomicInteger();
    private static final AtomicInteger countC=new AtomicInteger();
    private static final AtomicInteger countD=new AtomicInteger();
    private static final AtomicInteger countE=new AtomicInteger();
    private static final AtomicInteger countF=new AtomicInteger();
    private static final AtomicInteger countG=new AtomicInteger();
    private static final AtomicInteger countH=new AtomicInteger();
    private static final AtomicInteger countI=new AtomicInteger();
    private static final AtomicInteger countJ=new AtomicInteger();
    private static final AtomicInteger countK=new AtomicInteger();
    private static final AtomicInteger countL=new AtomicInteger();
    private static final AtomicInteger countM=new AtomicInteger();
    private static final AtomicInteger countN=new AtomicInteger();
    private static final AtomicInteger countO=new AtomicInteger();
    private static final AtomicInteger countP=new AtomicInteger();
    private static final AtomicInteger countQ=new AtomicInteger();
    private static final AtomicInteger countR=new AtomicInteger();
    private static final AtomicInteger countS=new AtomicInteger();
    private static final AtomicInteger countT=new AtomicInteger();
    private static final AtomicInteger countU=new AtomicInteger();
    private static final AtomicInteger countV=new AtomicInteger();
    private static final AtomicInteger countW=new AtomicInteger();
    private static final AtomicInteger countX=new AtomicInteger();
    private static final AtomicInteger countY=new AtomicInteger();
    private static final AtomicInteger countZ=new AtomicInteger();

    private List<Row> list;
    private int first,last;

    public WordNChar(List<Row> list, int first, int last) {
        this.list = list;
        this.first = first;
        this.last = last;
    }

    protected void compute() {
        if (last-first>6){
            int middle=(first+last)/2;
            WordNChar t1=new WordNChar(list,first,middle+1);
            WordNChar t2=new WordNChar(list,middle+1,last);
            t1.fork();
            t2.fork();

        }else {
            System.out.println(Thread.currentThread().getName()+": "+first+" "+last);
            calculateWordNChar();
        }
    }

    private void calculateWordNChar(){
        for (int i=first;i<last;i++){
            Row line= ReadPDF.rows.get(i);
            line.getRow().indexOf(" ");
            count.getAndIncrement();

            for (int j=0;j<line.getRow().length();j++){
                char charecter=line.getRow().charAt(j);

                switch (charecter) {
                    case 'A':
                        countA.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'B':
                        countB.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'C':
                        countC.getAndIncrement();
                        countChar.getAndIncrement();
                        break;
                    case 'D':
                        countD.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'E':
                        countE.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'F':
                        countF.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'G':
                        countG.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'H':
                        countH.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'I':
                        countI.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'J':
                        countJ.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'K':
                        countK.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'L':
                        countL.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'M':
                        countM.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'N':
                        countN.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'O':
                        countO.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'P':
                        countP.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'Q':
                        countQ.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'R':
                        countR.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'S':
                        countS.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'T':
                        countT.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'U':
                        countU.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'V':
                        countV.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'W':
                        countW.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'X':
                        countX.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'Y':
                        countY.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    case 'Z':
                        countZ.getAndIncrement();
                        countChar.getAndIncrement();
                        break;

                    default:
                        break;
                }
            }
        }
    }

    public static void result(){
        System.out.println("Total number of words are:"+count);
        System.out.println("Total number of character are:"+countChar);
        System.out.println("Total number of charecter A or a are:"+countA);
        System.out.println("Total number of charecter B or b are:"+countB);
        System.out.println("Total number of charecter C or c are:"+countC);
        System.out.println("Total number of charecter D or d are:"+countD);
        System.out.println("Total number of charecter E or e are:"+countE);
        System.out.println("Total number of charecter F or f are:"+countF);
        System.out.println("Total number of charecter G or g are:"+countG);
        System.out.println("Total number of charecter H or h are:"+countH);
        System.out.println("Total number of charecter I or i are:"+countI);
        System.out.println("Total number of charecter J or j are:"+countJ);
        System.out.println("Total number of charecter K or k are:"+countK);
        System.out.println("Total number of charecter L or l are:"+countL);
        System.out.println("Total number of charecter M or m are:"+countM);
        System.out.println("Total number of charecter N or n are:"+countN);
        System.out.println("Total number of charecter O or o are:"+countO);
        System.out.println("Total number of charecter P or p are:"+countP);
        System.out.println("Total number of charecter Q or q are:"+countQ);
        System.out.println("Total number of charecter R or r are:"+countR);
        System.out.println("Total number of charecter S or s are:"+countS);
        System.out.println("Total number of charecter T or t are:"+countT);
        System.out.println("Total number of charecter U or u are:"+countU);
        System.out.println("Total number of charecter V or v are:"+countV);
        System.out.println("Total number of charecter W or w are:"+countW);
        System.out.println("Total number of charecter X or x are:"+countX);
        System.out.println("Total number of charecter Y or y are:"+countY);
        System.out.println("Total number of charecter Z or z are:"+countZ);
    }

}
