<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simulador de Caixa Eletrônico</title>
<link rel="stylesheet" type="text/css" href="estilos.css">
<script src="modulos.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js"></script>
<!--Construção de máscaras pelo JQUERY-->
<script type="text/javascript">  
  // a  Representa caracteres alfabéticos (letras) (A-Z,a-z)
  // a  Porém 'a' não permite acentuação nem ç 
  // 9  Representa caracteres numéricos (números) (0-9)
  // *  Representa caracteres alfanuméricos (letras e números) (A-Z,a-z,0-9)
  $(function() {
  $('.mask-agencia').mask('999'); //agencia - 3 carateres numéricos
  $('.mask-conta').mask('99999'); //conta - 5 carateres numéricos
  });
</script>
</head>
<body>
<div>Simulador de Caixa Eletrônico</div>
<div>Extrato de Conta Corrente</div>
<br>
<div>
<form action="ce_004.jsp" method="post">
<table>
<tr><td>Agência</td>
<td><input type="text" name="agencia" size=1 required class="mask-agencia"></td></tr>
<tr><td>Conta Corrente</td> 
<td><input type="text" name="conta" size=2 required class="mask-conta"></td></tr>
<tr><th colspan=2><input type="submit" value="Enviar"></th></tr>
</table>
</form>
</div>
</body>
</html>
