import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
		static Board board = Board.getInstance();
		static boolean current = true;
		static boolean loss = false;
		public static void main(String[] args) {
				//d.initialize();
				System.out.println("Go team W");
				board.render( board.getPresent());
				while(!loss)
				{
						//d.render( d.getPresent());
				scanAndSelect();}

				return;
		}
		public static void scanAndSelect() {
				try {
						System.out.println("Select piece by inputting coordinates (row-number column-letter)");
						Scanner sc= new Scanner(System.in);
						int i= sc.nextInt();
						int j= toInt(sc.next());
						if (i==0){loss= true;}
						else {
								Pieces c=  board.selectPieces(i,j);
								if (c== null)
								{
										System.out.println("Wrong coordinates provided, No piece there");
										scanAndSelect();
								}
								else if(c.team == current){ // check K swap
										ArrayList<Square> potential= board.selectRender(c,board.getAllLocale(), board.getPresent());
										System.out.println("Input coordinate of square to move selected piece to");
										int x= sc.nextInt();
										int y= toInt(sc.next());
		// we know who to move where, now check for promotion/ resignation
										if (isInBound(x,y) && board.contains(potential,x,y))
										{
												//check P upgrade
												Pieces retired = board.selectPieces(x,y);
												Pieces k= board.getKing(current);
												if(k.canGetHere(board.getPresent()))
												{
														System.out.println("Movement not allowed");
												}
												else {
													if(retired != null)
													{

														//System.out.println("Present count: " +d.getPresent().size());
														retired.move(-1,-1);
														retired.setPresent(false);
														board.getPresent().remove(retired);
														//System.out.println("Present count: " +d.getPresent().size());
													}

													c.move(x,y);
													board.render( board.getPresent());
													current = !current;
													if(current)System.out.println("Go team W");
													else System.out.println("Go team B");
												}

										}
										else {
												System.out.println("Target location invalid");
												scanAndSelect();
										}
								} else {
										System.out.println("Wrong team selected");
										scanAndSelect();
								}
						}
				} catch (Exception e) {
						e.printStackTrace();
				}
		}

		private static int toInt(String next) {
				String A[] = {"A","B","C","D","E","F","G","H"};
				for (int n=0;n<8;n++)
				{
						if(next.toUpperCase().equals(A[n]))
						{
								return n+1;
						}
				}
				return 0;
		}

		public static Boolean isInBound(int cx, int cy)
		{
				return (cx < 9 && cx > 0 && cy > 0 && cy < 9);
		}
}
