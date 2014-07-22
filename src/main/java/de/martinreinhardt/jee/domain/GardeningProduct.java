package de.martinreinhardt.jee.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Electric")
public class GardeningProduct extends JoinSuperProduct {

	private int weight;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GardeningProduct [weight=");
		builder.append(weight);
		builder.append(", id=");
		builder.append(getId());
		builder.append(", name=");
		builder.append(getName());
		builder.append("]");
		return builder.toString();
	}

}
