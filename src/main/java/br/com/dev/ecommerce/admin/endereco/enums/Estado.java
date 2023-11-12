package br.com.dev.ecommerce.admin.endereco.enums;

public enum Estado {

	AC(0L, "Acre"), AL(1L, "Alagoas"), AP(2L, "Amapá"), AM(3L, "Amazonas"), BA(4L, "Bahia"), CE(5L, "Ceará"),
	DF(6L, "Distrito Federal"), ES(7L, "Espírito Santo"), GO(8L, "Goiás"), MA(9L, "Maranhão"), MT(10L, "Mato Grosso"),
	MS(11L, "Mato Grosso do Sul"), MG(12L, "Minas Gerais"), PA(13L, "Pará"), PB(14L, "Paraíba"), PR(15L, "Paraná"),
	PE(16L, "Pernambuco"), PI(17L, "Piauí"), RJ(18L, "Rio de Janeiro"), RN(19L, "Rio Grande do Norte"),
	RS(20L, "Rio Grande do Sul"), RO(21L, "Rondônia"), RR(22L, "Roraima"), SC(23L, "Santa Catarina"), SP(24L, "São Paulo"),
	SE(25L, "Sergipe"), TO(26L, "Tocantins");

	private Long id;

	private String estado;

	private Estado(Long id, String estado) {
		this.id = id;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
