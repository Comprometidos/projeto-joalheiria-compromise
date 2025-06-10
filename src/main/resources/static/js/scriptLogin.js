document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('loginForm');

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const email = document.getElementById('email').value;
        const senha = document.getElementById('senha').value;

        fetch('http://localhost:8080/usuarios/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: email,
                senha: senha
            })
        })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else if (response.status === 401) {
                throw new Error('Email ou senha inválidos.');
            } else {
                throw new Error('Erro na autenticação.');
            }
        })
        .then(usuario => {
            alert('Login realizado com sucesso! Bem-vindo, ' + usuario.nomeUsuario);
            // Armazena os dados do aluno e redireciona
            localStorage.setItem('usuarioLogado', JSON.stringify(usuario));
            window.location.href = 'perfil.html';
        })
        .catch(error => {
            alert(error.message);
        });
    });
});
