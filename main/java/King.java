import java.util.ArrayList;
import java.util.List;

public class King extends Pieces {
//TODO: check Kswap
		@Override public List<Square> getPotential(List<Pieces> present) {
				Square currentLocale= loc;
				int x = currentLocale.getL().getCx();
				int y = currentLocale.getL().getCy();
				List<Square> potential = new ArrayList<>();
				int[] x1;
				x1 = new int[] {0,1,1,1,0,-1,-1,-1};
				int[] y1;
				y1 = new int[] {1,1,0,-1,-1,-1,0,1};
				for (int n=0; n<8 ;n++) {
						if(x+x1[n]<9 && x+x1[n]>0 && y+y1[n]>0 && y+y1[n]<9){
								Square potent= null;
								Boolean occupied= false;
								Boolean sameTeam= false;
								for (Pieces cli : present) {
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
										potential.add(new Square(x+x1[n],y+y1[n]));
										//System.out.println(String.valueOf(x+x1[n])+" "+String.valueOf(y+y1[n]));
								}
								else if(!sameTeam)
								{
										potential.add(new Square(x+x1[n],y+y1[n]));//break;
										//System.out.println(String.valueOf(x+x1[n])+" "+String.valueOf(y+y1[n]));
								}
								//else break;
						};// else break;
				}


				return potential;
		}
		public King(boolean team, int id, int Cx, int Cy) {
				super(team, PieceType.K, id, Cx, Cy);
		}
}

