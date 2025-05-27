document.getElementById('cadastroClienteForm').addEventListener('submit', async function(event) {
    event.preventDefault();
    
        nomeUsuario = document.getElementById('nomeUsuario').value,
        cpf = document.getElementById('cpf').value,
        email = document.getElementById('email').value,
        telefone = document.getElementById('telefone').value,
        dataNascimento = document.getElementById('dt_nascimento').value,
        senha = document.getElementById('senha').value,
        
    try {
        const response = await fetch('http://localhost:8080/usuarios', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
            },
            body: JSON.stringify({
				nomeUsuario,
				cpf,
				email,
				telefone,
				dataNascimento,
				senha,
				tipoUsuario:{
					id: idUsuario
				}
			})
        })
		
		.then(async response =>{
			if (!response.ok){
				const text = await response.text();
				try {
					const data = text ? JSON.parse(text) : {};
					throw new Error(data.message || `Erro ${response.status}: ${response.statusText}`);
				} catch {
					throw new Error(`Erro ${response.status}: ${response.statusText}`);
				}
			}
			
			const contentLength = response.headers.get ('Content-Length');
			if(contentLength === '0' || !contentLength){
				return {nomeUsuario, email, senha};
			}
			return response.json();
		})
		
		.then(data => {
			alert('Usuario cadastrado com sucesso!\n Nome: ' + data.nomeUsuario);
			window.location.href = 'loginCliente.html';
		})
		.cath(error => {
			console.error('Erro no cadastro:', error);
			alert('Falha no cadastro: ' + error.message);
		});