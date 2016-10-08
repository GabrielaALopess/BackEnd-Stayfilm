package br.com.senai.stayFilm.enumeration;

public enum Estado {

	AC("Acre"), AL("Alagoas"), AP("Amapá"), AM("Amazonas"), BA("Bahia"), CE("Ceará"), DF("DistritoFederal"), EF(
			"Espírito Santo"), GO("Goiás"), MA("Maranhão"), MT("Mato Grosso"), MS("Mato Grosso do Sul"), MG(
					"Minas Gerais"), PA("Pará"), PB("Paraíba"), PR("Paraná"), PE("Pernambuco"), PI("Piauí"), RJ(
							"Rio de Janeiro"), RN("Rio Grande do Norte"), RS("Rio Grande do Sul"), RO("Rondônia"), RR(
									"Roraima"), SC("Santa Catarina"), SP("São Paulo"), SE("Sergipe"), TO("Tocantins");

	private String estado;

	Estado(String estado) {
		this.setEstado(estado);
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}