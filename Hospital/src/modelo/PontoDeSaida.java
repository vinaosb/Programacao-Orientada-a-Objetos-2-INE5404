package modelo;

import java.util.Calendar;

public class PontoDeSaida extends Ponto {

	private Calendar data;

	public PontoDeSaida() {
		setData(Calendar.getInstance());
	}

	@Override
	public Calendar getData() {
		return data;
	}

	private void setData(Calendar data) {
		this.data = data;
	}

}
