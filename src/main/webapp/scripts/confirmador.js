/**
 * 
 */

function confirmar(idcont){
	let resposta = confirm("Deseja confirmar a exclusão?")
	if(resposta === true){
		window.location.href = "delete?idcont=" + idcont
	}
}