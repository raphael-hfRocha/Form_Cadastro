/**
 * Validação de formulário
 * @author Raphael Henrique
 */

 function validar()
 {
	 let nome = frmCadastro.nome.value
	 let sobrenome = frmCadastro.sobrenome.value
	 
	 if(nome === "")
	 {
		 alert('Preencha o campo Nome')
		 frmCadastro.nome.focus()
		 return false
	 }	else if(sobrenome === "")
	 {
		alert('Preencha o campo Sobrenome')
		frmCadastro.sobrenome.focus()
		return false
	 }	else
	 {
		 documents.forms["frmCadastro"].submit()
	 }
 }