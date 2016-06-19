package lorann.game.model.element.motionless;



	public abstract class MotionlessList {
		public static final Motionless	BONE = new Bone();
		public static final Motionless	BONEV = new BoneV();
		public static final Motionless	BONEH = new BoneH();
		

		private static Motionless	motionlessList[]	= { BONE, BONEV, BONEH };

		public static Motionless getFromSymbol(char fileSymbol) {
			for (final Motionless motionless : motionlessList) {
				if (motionless.getC() == fileSymbol) {
					return motionless;
				}
			}
			return null;
		}
	}