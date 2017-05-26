package modelo;

import java.util.Calendar;

public class PontoDeEntrada extends Ponto {

	private Calendar data;

	public PontoDeEntrada() {
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
