import java.util.ArrayList;
import java.util.List;

public class Rook extends Pieces {
		@Override public List<Square> getPotential(List<Pieces> present) {
				Square currentLocale= loc;
				int x = currentLocale.getL().getCx();
				int y = currentLocale.getL().getCy();
				List<Square> potential = new ArrayList<>();
				int[] x1;
				x1 = new int[] {1,0,-1,0};
				int[] y1;
				y1 = new int[] {0,1,0,-1};
				for (int n=0; n<4 ;n++) {
						for (int k = 1; k < 8; k++) {
								if (x + k*x1[n] < 9 && x + k*x1[n] > 0 && y + k*y1[n] > 0 && y + k*y1[n] < 9) {
										Square potent = null;
										Boolean occupied = false;
										Boolean sameTeam = false;
										for (Pieces cli : present) {
												if (cli.isHere(x + k*x1[n], y + k*y1[n])) {
														occupied = true;
														if (team == cli.team) {
																sameTeam = true;
														}
														break;
												}
										}
										if (!occupied) {
												potential.add(new Square(x + k*x1[n], y + k*y1[n]));
												//System.out.println(	String.valueOf(x + k*x1[n]) + " " + String.valueOf(y + k*y1[n]));
										} else if (!sameTeam) {
												potential.add(new Square(x + k*x1[n], y + k*y1[n]));//break;
												//System.out.println(String.valueOf(x + k*x1[n]) + " " + String.valueOf(y + k*y1[n]));
												k=k+8;
										} else {k=k+8;}
										//else break;
								}
								;// else break;
						}
				}


				return potential;
		}
		public Rook(boolean team, int id, int Cx, int Cy) {
				super(team, PieceType.R, id, Cx, Cy);
		}
}
