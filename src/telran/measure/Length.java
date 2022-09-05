package telran.measure;

public class Length implements Comparable<Length> {
	private float amount;
	private LengthUnit unit;

	public Length(float amount, LengthUnit unit) {
		this.amount = amount;
		this.unit = unit;
	}

	/**
	 * equals two Length objects according to LengthUnit 10m == 10000mm
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Length) || obj == null)
			return false;
		var current = (Length) obj;
		return amount == current.convert(unit).amount;
	}

	@Override
	public int compareTo(Length o) {
		if (equals(o))
			return 0;
		return getAmount() > o.convert(unit).getAmount() ? 1 : -1;
	}

	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit convert(LengthUnit.M)
	 *         returns Length in meters
	 */
	
	public Length convert(LengthUnit unit) {
		float amountAfterConvert = getAmount() * getUnit().value / unit.getValue();
		return new Length(amountAfterConvert, unit);
	}

	/**
	 * returns string with amount and length unit pinned to amount with no space
	 * Example: 20M (string expression of Length object designed 20 meters)
	 */
	@Override
	public String toString() {
		return String.valueOf(getAmount())
										.replaceAll("\\.?0*$", "") + 
											getUnit();

	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return unit;
	}
}