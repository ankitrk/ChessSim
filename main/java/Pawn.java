import java.util.ArrayList;
import java.util.List;

public class Pawn extends Pieces {

		@Override public List<Square> getPotential(List<Pieces> present) {
				Square currentLocale= loc;
				int x = currentLocale.getL().getCx();
				int y = currentLocale.getL().getCy();
				List<Square> potential = new ArrayList<>();
				boolean occupied1=false;
				boolean occupied2=false;
				boolean sameTeam1=false;
				int direction=0;
				if(team) { direction =1;} else {direction =-1;}

				for (Pieces cli : present)
				{
								if (cli.isHere(x+direction, y))
								{
										occupied1 = true;
										break;
								}
				}
				if (!occupied1)
				{
						potential.add(new Square(x+direction,y));
						System.out.println(String.valueOf(x)+" "+String.valueOf(y+1));
						if( 2*x == 9 - 5*direction  ) //2 to 16look for 4 if true and 14 if down
						{
								for (Pieces cli : present)
								{
										if (cli.isHere(x+direction*2, y))
										{
												occupied2=true;
												break;
										}
								}
								if(!occupied2){potential.add(new Square(x+direction*2, y));}

						}
				}
				for (Pieces cli : present)
				{
						if (cli.isHere(x+direction, y+1) && team == !cli.team)
						{
								potential.add(new Square(x+direction,y+1));
								break;
						}
				}
				for (Pieces cli : present)
				{
						if (cli.isHere(x+direction, y-1) && team == !cli.team)
						{
								potential.add(new Square(x+direction,y-1));
								break;
						}
				}
								/*Locale potent= null;
								Boolean occupied= false;
								Boolean sameTeam= false;
								for (Client cli : present) {
										if (cli.isHere(x +x1[n], y+y1[n])) {
												occupied= true;
												if(team == cli.team)
												{
														sameTeam = true;
												}
												break;
										}
								}
								if (!occupied)
								{
										potential.add(new Locale(x+x1[n],y+y1[n]));
										System.out.println(String.valueOf(x+x1[n])+" "+String.valueOf(y+y1[n]));
								}
								else if(!sameTeam)
								{
										potential.add(new Locale(x+x1[n],y+y1[n]));//break;
										System.out.println(String.valueOf(x+x1[n])+" "+String.valueOf(y+y1[n]));
								}
								//else break;
						};
				}
		        // else break;*/



				return potential;
		}
		public Pawn(boolean team, int id, int Cx, int Cy) {
				super(team, PieceType.P, id, Cx, Cy);
		}
}

