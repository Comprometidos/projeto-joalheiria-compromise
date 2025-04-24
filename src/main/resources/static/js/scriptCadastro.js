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
        return response.json();
    })
    .then(data => {
        alert('Cadastro realizado com sucesso!');
        window.location.href = 'endereco.html';
    })
    .catch(error => {
        console.error('Erro:', error);
        alert('Erro ao cadastrar: ' + error.message);
    });
});