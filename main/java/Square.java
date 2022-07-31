public class Square {
		Coordinate l;

		public Coordinate getL() {
				return l;
		}

		@Override public boolean equals(Object o) {
				if (this == o)
						return true;
				if (o == null || getClass() != o.getClass())
						return false;

				Square locale = (Square) o;
				if (this.l.getCx()== locale.getL().getCx() && this.l.getCy()== locale.getL().getCy())
				{
						return true;
				}
				return l != null ? l.equals(locale.l) : locale.l == null;
		}

		@Override public int hashCode() {
				return l != null ? l.hashCode() : 0;
		}

		public void setL(int cx, int cy) {
				this.l = new Coordinate(cx,cy);
		}

		public Square(int cx, int cy) {
				this.l = new Coordinate(cx,cy);
		}

		@Override public String toString() {
				return "Locale:" + "l=" + l.toString() +" ";
		}
}
