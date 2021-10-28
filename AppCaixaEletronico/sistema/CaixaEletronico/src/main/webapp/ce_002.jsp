<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- classes Java --%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.Random" %>
<%-- classes da aplicação Caixa Eletrônico --%>
<%@ page import="classes.Cliente" %>
<%@ page import="classes.ContaCorrente" %>

<%
int dc = 0;
int ag = Integer.parseInt(request.getParameter("agencia"));
int cc = Integer.parseInt(request.getParameter("conta"));
int op = Integer.parseInt(request.getParameter("opn"));
String vrx = request.getParameter("valor");
// converte string valor para float
String vx = vrx;
vx = vx.replace(".","");
vx = vx.replace(",",".");
float vr = Float.parseFloat(vx);
// formato de data atual para apresentar na página
SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
//formato monetário
DecimalFormat df = new DecimalFormat("#,##0.00");
// verifica se número de documento é aleatório - 1 ou 2 
if(op == 1 || op == 2)
{
	Random nr = new Random();
	dc = (nr.nextInt(1000) + 1) * 10000;
}
else
{
	dc = Integer.parseInt(request.getParameter("documento"));
}
String msg = "";
//Cria objeto 'cta' com base na classe ContaCorrente - instância
ContaCorrente cta = new ContaCorrente();
// transfere dados para a classe ContaCorrente
cta.setNumero_doc_cc(dc);
cta.setAgencia_cc(ag);
cta.setConta_cc(cc);
cta.setValor_cc(vr);
cta.setTipo_cc(op);
//executa método para atualizar saldo
// e retorna ocorrência
int opr = cta.AtualizarSaldo(0);
if(opr == 1) // Saldo Atualizado e Ocorrência Registrada
{
	// executa método para registrar ocorrência
	// caso saldo seja suficiente
	cta.RegistrarOcorrencia();
	msg = "Saldo Atualizado e Ocorrência Registrada";
}
if(opr == 2) // Operação Inválida - Saldo Insuficiente
{
	msg = "Operação Inválida - Saldo Insuficiente";
}
if(opr == 3) // Operação Cancelada - Agência e Conta não encontrado
{
	cta.setCliente_cc("---------------------------");
	// saldo é zerado para evitar erro na formatação de moeda
	float scc = 0;
	cta.setSaldo_cc(scc);
	msg = "Operação Cancelada - Agência e Conta não encontrado";
}
String descop="";
if(op == 1)
	descop = "Depósito";
if(op == 2)
	descop = "Saque";
if(op == 3)
	descop = "Pagamento";
//data e hora do momento
Date agora = new Date();
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simulador de Caixa Eletrônico</title>
<link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<div>Simulador de Caixa Eletrônico</div>
<div>    
<table>
<tr><td>Agência</td><td><%=ag%></td></tr>
<tr><td>C/C</td><td><%=cc%></td></tr>
<tr><td>Cliente</td><td><%=cta.getCliente_cc()%></td></tr>
<tr><td>Data/Hora</td><td><%=sd.format(agora)%></td></tr>
<tr><td>Documento</td><td><%=dc%></td></tr>
<tr><td>Operação</td><td><%=descop%></td></tr>
<tr><td>Valor</td><td><%=vrx%></td></tr>
<tr><td>Saldo</td><td><%=df.format(cta.getSaldo_cc())%></td></tr>
<tr><td>Mensagem</td><td><%=msg%></td></tr>
</table>
</div>
<div>
<form action="index.jsp" method="get">
	<input type="submit" value="Voltar">
</form>
</div>
</body>
</html>
