package de.martinreinhardt.jee.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Electric")
public class ElectricProduct extends JoinSuperProduct {

	private int voltage;

	public int getVoltage() {
		return voltage;
	}

	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ElectricProduct [voltage=");
		builder.append(voltage);
		builder.append(", id=");
		builder.append(getId());
		builder.append(", name=");
		builder.append(getName());
		builder.append("]");
		return builder.toString();
	}

}
