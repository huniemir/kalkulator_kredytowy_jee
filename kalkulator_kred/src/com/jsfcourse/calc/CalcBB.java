package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class CalcBB {
	private String kwota;
	private String iloscRat;
	private Double result;

	@Inject
	FacesContext ctx;

	public String getKwota() {
		return kwota;
	}

	public void setKwota(String x) {
		this.kwota = x;
	}

	public String getIloscRat() {
		return iloscRat;
	}

	public void setIloscRat(String y) {
		this.iloscRat = y;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public boolean doTheMath() {
		try {
			double kwota = Double.parseDouble(this.kwota);
			double ilosc_rat = Double.parseDouble(this.iloscRat);

			result = kwota/ilosc_rat;

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;
		}
	}

	// Go to "showresult" if ok
	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}
}
