/**
 * 
 */

function validarFormulario(){
	let nome = formContato.nome.value
	let fone = formContato.fone.value
	if(nome === ""){
		alert("Preencha o campo nome!")
		formContato.nome.focus()
		return false
	} else if (fone === "" || fone.length != 11){
		alert("Preencha o campo fone!")
		formContato.fone.focus()
		return false
	} else {
		return true
	}
	
}