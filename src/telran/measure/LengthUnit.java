package telran.measure;

public enum LengthUnit {
	MM(1f), CM(10f), IN(25.4f), FT(304.8f), M(1000f), KM(1000000f);

	final float value;

	private LengthUnit(float value) {
		this.value = value;
	}

	public float getValue() {
		return value; 
	}

	/**
	 * 
	 * @param l1
	 * @param l2
	 * @return Length object with amount of the LengthUnit LengthUnit.M.between 
	 * (new Length(200f, LengthUnit.CM), 
	 *  new Length(1f, LengthUnit.M)) ->
	 *      Length(1, LengthUnit.M)
	 */
	public Length between(Length l1, Length l2) {
		
		if (l1.getUnit() != this) {
			l1 = l1.convert(this);
		}
		if (l2.getUnit() != this) {
			l2 = l2.convert(this);
		}
		float lengthRes = Math.abs(l1.getAmount() - l2.getAmount());
		return new Length(lengthRes, this);
	}
}
