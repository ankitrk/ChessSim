import java.util.List;

abstract class Pieces {
		boolean team;
		PieceType type;
		boolean isPresent;
		int id;
		Square loc;
		String signature;
		public String getOut() {
				return signature;
		}
public List<Square> potential;

		//public List<Locale> getPotential() {
			//	return getPotential();
		//}
		public boolean canGetHere(List<Pieces> present) {
				for (Pieces c: present){
						if(c.team != team)
						{
								for(Square l :c.getPotential(present))
								{
										if (l.equals(loc)){return true;}
								}
						}
		}
				return false;
		}

		public abstract List<Square> getPotential( List<Pieces> present);
		public Square getL() {
				return loc;
		}

		public void setL(Square l) {
				this.loc = l;
		}
		public void setPresent(Boolean l) {
				this.isPresent = l;
		}
		public boolean isHere(int Cx, int Cy) {
				if (loc.equals( new Square(Cx,Cy))){return true;} else return false;
		}

		@Override public String toString() {
				return "Client{" + "team=" + team + ", type=" + type + ", present=" + isPresent + ", l=" + loc + '}';
		}

		public Pieces(boolean team, PieceType type, int id, int Cx, int Cy) {
				this.team = team;
				this.id= id;
				this.type = type;
				this.isPresent = true;
				this.loc = new Square(Cx,Cy);
				String teamStr;
				if(team) teamStr="W"; else teamStr="B";
				this.signature= teamStr+type.toString();
		}
		public void move( int cx, int cy){
				this.loc=new Square(cx, cy);
		}
		public Boolean isInBound(int cx, int cy)
		{
				if(cx<9 && cx>0 && cy>0 && cy<9 )
						return true;
				else
						return false;
		}

}
