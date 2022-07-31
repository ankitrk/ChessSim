import java.util.ArrayList;


public class Board {
		private static Board uniqueInstance;
		private Pieces whiteKing;
		private Pieces blackKing;
		private ArrayList<Square> allSquares;
		private ArrayList<Pieces> allPieces;

		private Board() {
				whiteKing=  new King(true,1,1,5);
				blackKing= new King(false,1,8,5);
				Pieces q1 = new Queen(true,1,1,4);
				Pieces q2 = new Queen(false,1,8,4);
				Pieces n1 = new Knight(true,1,1,2);
				Pieces n2 = new Knight(true,1,1,7);
				Pieces n3 = new Knight(false,1,8,2);
				Pieces n4 = new Knight(false,1,8,7);
				Pieces b1 = new Bishop(true,2,1,3);
				Pieces b2 = new Bishop(true,2,1,6);
				Pieces b3 = new Bishop(false,2,8,3);
				Pieces b4 = new Bishop(false,2,8,6);
				Pieces r1 = new Rook(true,2,1,1);
				Pieces r2 = new Rook(true,2,1,8);
				Pieces r3 = new Rook(false,2,8,1);
				Pieces r4 = new Rook(false,2,8,8);

				this.allPieces= new ArrayList<>();
				this.allPieces.add(whiteKing);
				this.allPieces.add(blackKing);
				this.allPieces.add(q1);this.allPieces.add(q2);
				this.allPieces.add(n1);this.allPieces.add(n2);this.allPieces.add(n3);this.allPieces.add(n4);
				this.allPieces.add(b1);this.allPieces.add(b2);this.allPieces.add(b3);this.allPieces.add(b4);
				this.allPieces.add(r1);this.allPieces.add(r2);this.allPieces.add(r3);this.allPieces.add(r4);
				for (int i=1;i<9;i++)
				{
					Pieces p1=  new Pawn(true,1,2,i);
					Pieces p2= new Pawn(false,2,7,i);
					this.allPieces.add(p1);this.allPieces.add(p2);
				}
				this.allSquares= new ArrayList<>();
				for (int i=1; i<9;i++){
						for (int j=1; j<9;j++){
								Square l= new Square(i,j);
								this.allSquares.add(l);
						}
				}
				return;
		}
		public static Board getInstance(){
				if(uniqueInstance== null){
						uniqueInstance= new Board();
				}
				return uniqueInstance;
		}

		public Pieces getKing(boolean team) {
				if(team) return whiteKing; else return blackKing;
		}
		public ArrayList<Pieces> getPresent() {
				return allPieces;
		}

		public ArrayList<Square> getAllLocale() {
				return allSquares;
		}

		public void setAllLocale(ArrayList<Square> allLocale) {
				this.allSquares = allLocale;
		}

		public void render (ArrayList<Pieces> present)
		{
				System.out.println();
				System.out.print( "    A   B   C   D   E   F   G   H");
				System.out.println();
				for (int i=1; i<9;i++)
				{
						System.out.print( i+"  ");
						for (int j=1; j<9;j++)
						{

								Pieces here = null;
								for (Pieces piece : present){
										if(piece.isHere(i,j))
										{
												here= piece;
												break;
										}
								}
								if (here == null)
								{
										System.out.print( " OO ");
								}
								else {
										System.out.print(" "+here.getOut()+" ");
								}
						}
						System.out.println();
				}
		}
		public ArrayList<Square> selectRender( Pieces c,ArrayList<Square> allLocale, ArrayList<Pieces> present) {
				System.out.println();
				ArrayList<Square> potential = (ArrayList<Square>) c.getPotential(present);
				//System.out.println("Size =" +potential.size());
				Square origin=c.getL();
				System.out.print( "    A   B   C   D   E   F   G   H");
				System.out.println();
				for (int i=1; i<9;i++){
						System.out.print( i+"  ");
						for (int j=1; j<9;j++){
							
								if(origin.equals(new Square(i,j)))
								{
										System.out.print("<"+ c.getOut()+">");

								}
								else
								{
										if (contains(potential,i,j))
										{
												Pieces here = null;
												for (Pieces piece : present) {
														if (piece.isHere(i,j)) {
																here= piece;
																break;
														}
												}
												if (here == null)
												{
														System.out.print("[00]");
												}
												else
												{
														System.out.print("[" + here.getOut() + "]");
												}
										}
										else
										{
												Pieces here = null;
												for (Pieces piece : present) {
														if (piece.isHere(i, j)) {
																here= piece;
																break;
														}
												}
												if (here == null) System.out.print(" OO ");
												else System.out.print(" " + here.getOut() + " ");
										}
								}
						}
						System.out.println();
				}
				return potential;
		}

		public boolean contains(ArrayList<Square> potential, int i, int j) {
				for (Square pot:potential) {
						if (pot.equals (new Square(i,j)))
								return true;
				}
				return false;
		}

		public Pieces selectPieces(int cx, int cy) {
				if(cx>9 ||cy>9||cx<0||cy<0){return null;}
				for (Pieces piece : allPieces){
						if(piece.isHere(cx,cy))
						{
								return piece;
						}
				}
				return null;
		}
}
