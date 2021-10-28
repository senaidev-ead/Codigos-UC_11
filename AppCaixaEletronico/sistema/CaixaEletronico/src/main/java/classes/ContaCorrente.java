package classes;

import java.sql.*;

public class ContaCorrente {
	private Integer numero_doc_cc;
	private Integer agencia_cc;
	private Integer conta_cc;
	private String cliente_cc;
	private Float valor_cc;
	private Integer tipo_cc;
	private String data_ocorrencia_cc;
	private Float saldo_cc;

	public Integer AtualizarSaldo(Integer opcc)
	{
		try {
			// conecta com BD
			ConectaBD cbd = new ConectaBD();
			Connection conn = cbd.Conectar();
	        String Sql = "select saldo, nome from cliente where "
	        		+ "agencia = " + agencia_cc + " and conta = " + conta_cc;
	        Statement st = conn.createStatement();
	        ResultSet rs = st.executeQuery(Sql);
	        if(rs.next()) // se agencia e conta existem
	        {
			        cliente_cc = rs.getString("nome");
			        saldo_cc = rs.getFloat("saldo");
			        rs.close();
			        st.close();        
			        // operação de depósito-1
			        if(tipo_cc == 1)
			        {
			        	// atualiza saldo na tabela cliente
			        	Sql = "update cliente set saldo = "
			        			+ "saldo + " + valor_cc
			        			+ " where agencia = " 
			        			+ agencia_cc + " and " 
			        			+ " conta = " 
			        			+ conta_cc; 
			        	PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
			        	comando.execute();
				        comando.close();
				        // atualiza saldo da classe
				        saldo_cc = saldo_cc + valor_cc;
				        opcc = 1; // saldo atualizado
			        }
			        
			        // operação de saque-2 ou pagamento-3
			        if(tipo_cc == 2 || tipo_cc == 3)
			        {
			        	if(saldo_cc >= valor_cc)
			        	{
			        		// atualiza saldo na tabela cliente
			        		Sql = "update cliente set saldo = "
				        			+ "saldo - " + valor_cc
				        			+ " where agencia = " 
				        			+ agencia_cc + " and " 
				        			+ " conta = " 
				        			+ conta_cc; 	        		
				        	PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
				        	comando.execute();
					        comando.close();
					        conn.close();
				        	// atualiza saldo da classe
					        saldo_cc = saldo_cc - valor_cc;
					        opcc = 1; // saldo atualizado
			        	}
			        	else
			        	{
			        		opcc = 2; // saldo insuficiente
			        	}
			        }      	
	        }
	        else
	        {
	        	opcc = 3; // agência e conta não encontrado
	        }
		} 
		catch (Exception e) {
		System.out.println(e.getMessage());
		}
		return opcc;
	}
	
	public void RegistrarOcorrencia()
	{
		try {
			// conecta com BD
			ConectaBD cbd = new ConectaBD();
			Connection conn = cbd.Conectar();
			
	        /*
	        // inclusão modo concatenação
	        String Sql = "insert into contacorrente values(" + getNumero_doc_cc() + "," 
	                + getAgencia_cc() + "," + getConta_cc() + "," 
	        		+ getValor_cc() + "," + getTipo_cc() + ")"; 
	        */
	        
	        /*
	        // inclusão modo parametrizado (@)
	        String Sql = "insert into "
	        		+ "contacorrente(numero_doc, agencia, conta, valor, tipo) "
	        		+ "values(@numero_doc_cc,@agencia_cc,@conta_cc,@valor_cc,@tipo_cc)";
	       	*/
	        
	        // inclusão modo objeto PreparedStatement
	        String Sql = "insert into "
	        		+ "contacorrente(numero_doc, agencia, conta, valor, tipo) "
	        		+ "values(?,?,?,?,?)";	        
	        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);	        
	        // inclusão modo objeto PreparedStatement - continuação
	        comando.setInt(1, numero_doc_cc);
	        comando.setInt(2, agencia_cc);
	        comando.setInt(3, conta_cc);
	        comando.setFloat(4, valor_cc);
	        comando.setInt(5, tipo_cc);
	        // execução da inclusão
	        comando.execute();
	        comando.close();
	        conn.close();
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}	
	}

	public Integer getNumero_doc_cc() {
		return numero_doc_cc;
	}

	public void setNumero_doc_cc(Integer numero_doc_cc) {
		this.numero_doc_cc = numero_doc_cc;
	}

	public Integer getAgencia_cc() {
		return agencia_cc;
	}

	public void setAgencia_cc(Integer agencia_cc) {
		this.agencia_cc = agencia_cc;
	}

	public Integer getConta_cc() {
		return conta_cc;
	}

	public void setConta_cc(Integer conta_cc) {
		this.conta_cc = conta_cc;
	}
	
	public String getCliente_cc() {
		return cliente_cc;
	}

	public void setCliente_cc(String cliente_cc) {
		this.cliente_cc = cliente_cc;
	}

	public Float getValor_cc() {
		return valor_cc;
	}

	public void setValor_cc(Float valor_cc) {
		this.valor_cc = valor_cc;
	}

	public Integer getTipo_cc() {
		return tipo_cc;
	}

	public void setTipo_cc(Integer tipo_cc) {
		this.tipo_cc = tipo_cc;
	}

	public String getData_ocorrencia_cc() {
		return data_ocorrencia_cc;
	}

	public void setData_ocorrencia_cc(String data_ocorrencia_cc) {
		this.data_ocorrencia_cc = data_ocorrencia_cc;
	}

	public Float getSaldo_cc() {
		return saldo_cc;
	}

	public void setSaldo_cc(Float saldo_cc) {
		this.saldo_cc = saldo_cc;
	}
	
	
}
