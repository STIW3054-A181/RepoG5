package KoonFungYee;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

public class WordNChar extends RecursiveAction {
    private static final AtomicInteger count=new AtomicInteger();
    public static int countChar = 0;
    private static int countA,countB,countC,countD,countE,countF,countG,countH,countI,countJ,countK,
            countL,countM,countN,countO,countP,countQ,countR,countS,countT,countU,countV,countW,countX,countY,countZ;

    public final static List<Char> characters=new ArrayList<>();

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
                        countA++;
                        countChar++;
                        break;

                    case 'B':
                        countB++;
                        countChar++;
                        break;

                    case 'C':
                        countC++;
                        countChar++;
                        break;
                    case 'D':
                        countD++;
                        countChar++;
                        break;

                    case 'E':
                        countE++;
                        countChar++;
                        break;

                    case 'F':
                        countF++;
                        countChar++;
                        break;

                    case 'G':
                        countG++;
                        countChar++;
                        break;

                    case 'H':
                        countH++;
                        countChar++;
                        break;

                    case 'I':
                        countI++;
                        countChar++;
                        break;

                    case 'J':
                        countJ++;
                        countChar++;
                        break;

                    case 'K':
                        countK++;
                        countChar++;
                        break;

                    case 'L':
                        countL++;
                        countChar++;
                        break;

                    case 'M':
                        countM++;
                        countChar++;
                        break;

                    case 'N':
                        countN++;
                        countChar++;
                        break;

                    case 'O':
                        countO++;
                        countChar++;
                        break;

                    case 'P':
                        countP++;
                        countChar++;
                        break;

                    case 'Q':
                        countQ++;
                        countChar++;
                        break;

                    case 'R':
                        countR++;
                        countChar++;
                        break;

                    case 'S':
                        countS++;
                        countChar++;
                        break;

                    case 'T':
                        countT++;
                        countChar++;
                        break;

                    case 'U':
                        countU++;
                        countChar++;
                        break;

                    case 'V':
                        countV++;
                        countChar++;
                        break;

                    case 'W':
                        countW++;
                        countChar++;
                        break;

                    case 'X':
                        countX++;
                        countChar++;
                        break;

                    case 'Y':
                        countY++;
                        countChar++;
                        break;

                    case 'Z':
                        countZ++;
                        countChar++;
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
        characters.add(new Char("A",countA));
        System.out.println("Total number of charecter B or b are:"+countB);
        characters.add(new Char("B",countB));
        System.out.println("Total number of charecter C or c are:"+countC);
        characters.add(new Char("C",countC));
        System.out.println("Total number of charecter D or d are:"+countD);
        characters.add(new Char("D",countD));
        System.out.println("Total number of charecter E or e are:"+countE);
        characters.add(new Char("E",countE));
        System.out.println("Total number of charecter F or f are:"+countF);
        characters.add(new Char("F",countF));
        System.out.println("Total number of charecter G or g are:"+countG);
        characters.add(new Char("G",countG));
        System.out.println("Total number of charecter H or h are:"+countH);
        characters.add(new Char("H",countH));
        System.out.println("Total number of charecter I or i are:"+countI);
        characters.add(new Char("I",countI));
        System.out.println("Total number of charecter J or j are:"+countJ);
        characters.add(new Char("J",countJ));
        System.out.println("Total number of charecter K or k are:"+countK);
        characters.add(new Char("K",countK));
        System.out.println("Total number of charecter L or l are:"+countL);
        characters.add(new Char("L",countL));
        System.out.println("Total number of charecter M or m are:"+countM);
        characters.add(new Char("M",countM));
        System.out.println("Total number of charecter N or n are:"+countN);
        characters.add(new Char("N",countN));
        System.out.println("Total number of charecter O or o are:"+countO);
        characters.add(new Char("O",countO));
        System.out.println("Total number of charecter P or p are:"+countP);
        characters.add(new Char("P",countP));
        System.out.println("Total number of charecter Q or q are:"+countQ);
        characters.add(new Char("Q",countQ));
        System.out.println("Total number of charecter R or r are:"+countR);
        characters.add(new Char("R",countR));
        System.out.println("Total number of charecter S or s are:"+countS);
        characters.add(new Char("S",countS));
        System.out.println("Total number of charecter T or t are:"+countT);
        characters.add(new Char("T",countT));
        System.out.println("Total number of charecter U or u are:"+countU);
        characters.add(new Char("U",countU));
        System.out.println("Total number of charecter V or v are:"+countV);
        characters.add(new Char("V",countV));
        System.out.println("Total number of charecter W or w are:"+countW);
        characters.add(new Char("W",countW));
        System.out.println("Total number of charecter X or x are:"+countX);
        characters.add(new Char("X",countX));
        System.out.println("Total number of charecter Y or y are:"+countY);
        characters.add(new Char("Y",countY));
        System.out.println("Total number of charecter Z or z are:"+countZ);
        characters.add(new Char("Z",countZ));

    }

}
