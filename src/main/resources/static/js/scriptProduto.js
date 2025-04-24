document.addEventListener('DOMContentLoaded', function() {
    carregarProdutos();
    
    const formProduto = document.getElementById('formProduto');
    formProduto.addEventListener('submit', function(e) {
        e.preventDefault();
        
        const produto = {
            nomeProduto: document.getElementById('nomeProduto').value,
            ornamentos: document.getElementById('ornamentos').value,
            categoria: document.getElementById('categoria').value,
            tipo: document.getElementById('tipo').value,
            preco: parseFloat(document.getElementById('preco').value)
        };
        
        fetch('http://localhost:8080/produtos', {
            method: 'POST',
            headers: { 
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(produto)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao salvar produto');
            }
            return response.json();
        })
        .then(data => {
            console.log('Sucesso:', data);
            formProduto.reset();
            carregarProdutos();
        })
        .catch(error => {
            console.error('Erro:', error);
            alert('Erro ao salvar produto: ' + error.message);
        });
    });
});

function carregarProdutos() {
    fetch('http://localhost:8080/produtos')
        .then(res => {
            if (!res.ok) {
                throw new Error('Erro ao carregar produtos');
            }
            return res.json();
        })
        .then(produtos => {
            const tabela = document.getElementById('tabelaProdutos').querySelector('tbody');
            tabela.innerHTML = '';
            
            produtos.forEach(p => {
                const linha = tabela.insertRow();
                linha.insertCell(0).textContent = p.nomeProduto;
                linha.insertCell(1).textContent = p.ornamentos;
                linha.insertCell(2).textContent = p.categoria;
                linha.insertCell(3).textContent = p.tipo;
                linha.insertCell(4).textContent = p.preco.toFixed(2);
            });
        })
        .catch(error => {
            console.error('Erro:', error);
            alert('Erro ao carregar produtos: ' + error.message);
        });
}