document.getElementById('cadastroClienteForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const usuario = {
        nomeUsuario: document.getElementById('nomeUsuario').value,
        cpf: document.getElementById('cpf').value,
        email: document.getElementById('email').value,
        telefone: document.getElementById('telefone').value,
        dataNascimento: document.getElementById('dt_nascimento').value,
        senha: document.getElementById('senha').value,
        tipoUsuario: {
            idTipoUsuario: parseInt(document.getElementById('idTipoUsuario').value)
        }
    };

    fetch('http://localhost:8080/usuarios', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(usuario)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro no cadastro');
        }
        return response.json(); // <- Aqui você pega o objeto com o id
    })
    .then(data => {
        const idUsuario = data.idUsuario; // Pegando o ID retornado pelo backend
        alert('Cadastro realizado com sucesso!');

        // Redirecionando e passando o ID do usuário na URL
        window.location.href = `endereco.html?idUsuario=${idUsuario}`;
    })
    .catch(error => {
        console.error('Erro:', error);
        alert('Erro ao cadastrar: ' + error.message);
    });
});
