public class Coordinate {
		int Cx;
		int Cy;

		public Coordinate(int cx, int cy) {
				Cx = cx;
				Cy = cy;
		}

		public int getCx() {
				return Cx;
		}

		public void setCx(int cx) {
				Cx = cx;
		}

		@Override public String toString() {
				return "Location{" + "Cx=" + Cx + ", Cy=" + Cy + '}';
		}

		public int getCy() {
				return Cy;
		}

		public void setCy(int cy) {
				Cy = cy;
		}
}
