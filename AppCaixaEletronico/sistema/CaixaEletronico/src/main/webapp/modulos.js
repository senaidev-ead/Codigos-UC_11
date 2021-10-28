/*
 Funções do Simulador de Caixa Eletrônico
 */
function MostraDoc()
{
	if(document.getElementById("op").value == "3")
		{
		document.getElementById("tit").style.display = "";
		document.getElementById("doc").style.display = "";
		document.getElementById("doc").focus();
		}
	else
		{
		document.getElementById("tit").style.display = "none";
		document.getElementById("doc").style.display = "none";
		document.getElementById("doc").value = "";
		}
}

