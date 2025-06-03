document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('cadastroClienteForm');

    form.addEventListener('submit', function(event) {
        event.preventDefault();
    
        const nomeUsuario = document.getElementById('nomeUsuario').value;
        const cpf = document.getElementById('cpf').value;
        const email = document.getElementById('email').value;
        const telefone = document.getElementById('telefone').value;
        const dataNascimento = document.getElementById('dt_nascimento').value;
        const senha = document.getElementById('senha').value;
        const idTipoUsuario = 1; 
        
        fetch('http://localhost:8080/usuario', {
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
                tipoUsuario: {
                    idTipoUsuario: idTipoUsuario 
                }
            })
        })
        .then(async response => {
            if (!response.ok) {
                const text = await response.text();
                try {
                    const data = text ? JSON.parse(text) : {};
                    throw new Error(data.message || `Erro ${response.status}: ${response.statusText}`);
                } catch {
                    throw new Error(`Erro ${response.status}: ${response.statusText}`);
                }
            }
            
            const contentLength = response.headers.get('Content-Length');
            if (contentLength === '0' || !contentLength) {
                return { nomeUsuario, email, senha };
            }
            return response.json();
        })
        .then(data => {
            // Salva no localStorage
           localStorage.setItem('idUsuario', data.idUsuario); // salva só o ID separadamente
localStorage.setItem('usuario', JSON.stringify({
    idUsuario: data.idUsuario,
    nomeUsuario: data.nomeUsuario,
    email: data.email,
    senha: data.senha
}));


            alert('Usuário cadastrado com sucesso!\nNome: ' + data.nomeUsuario);
            window.location.href = 'endereco.html';
        })
        .catch(error => { 
            console.error('Erro no cadastro:', error);
            alert('Falha no cadastro: ' + error.message);
        });
    });
});
