
import java.util.ArrayList;
		import java.util.List;

public class Knight extends Pieces {
		@Override public List<Square> getPotential(List<Pieces> present) {
				Square currentLocale= loc;
				int x = currentLocale.getL().getCx();
				int y = currentLocale.getL().getCy();
				List<Square> potential = new ArrayList<>();
				int a[] = {2,1,-1,-2,-2,-1,1,2};
				int b[] = {1,2,2,1,-1,-2,-2,-1};
				for (int n=0; n<8 ;n++) {
				int x1= x+a[n];
				int y1= y+b[n];
				if(x1<9 && x1>0 && y1<9 && y1>0){
						Square potent= null;
						Boolean occupied= false;
						Boolean sameTeam= false;
						for (Pieces cli : present) {
								if (cli.isHere(x1, y1)) {
										occupied= true;
										if(team == cli.team) sameTeam = true;
										break;
								}
						}
						if (!occupied){potential.add(new Square(x1,y1));}
						else if(!sameTeam){potential.add(new Square(x1,y1));}
				}
				}
				/*for (int n=1; n<8 ;n++) {
						if(x+n<9){
								Locale potent= null;
								Boolean occupied= false;
								Boolean sameTeam= false;
								for (Client cli : present) {
										if (cli.isHere(x +n, y)) {
												occupied= true;
												if(team == cli.team) sameTeam = true;
												break;
										}
								}
								if (!occupied){potential.add(new Locale(x+n,y));}
								else if(!sameTeam){potential.add(new Locale(x+n,y));break;}
								else break;
						} else break;
				}*/
				return potential;
		}
		public Knight(boolean team, int id, int Cx, int Cy) {
				super(team, PieceType.N, id, Cx, Cy);
		}
}

