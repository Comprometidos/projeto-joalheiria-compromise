document.addEventListener('DOMContentLoaded', function() {
    const formProduto = document.getElementById('formProduto');
    const listaProdutos = document.getElementById('listaProdutos');
    
    // Carrega produtos do localStorage ou inicia array vazio
    let produtos = JSON.parse(localStorage.getItem('produtos')) || [];

    // Exibe os produtos na lista
    function exibirProdutos() {
        listaProdutos.innerHTML = '';
        
        produtos.forEach(produto => {
            const li = document.createElement('li');
            li.innerHTML = `
                <strong>${produto.nome}</strong> - ${produto.ornamento}
                <br>Categoria: ${this.getCategoriaTexto(produto.categoria)} | Tipo: ${this.getTipoTexto(produto.tipo)}
                <button onclick="editarProduto(${produto.id})">Editar</button>
                <button onclick="excluirProduto(${produto.id})">Excluir</button>
            `;
            listaProdutos.appendChild(li);
        });
    }

    // Retorna o texto da categoria
    function getCategoriaTexto(valor) {
        const categorias = {
            '1': 'Anéis',
            '2': 'Colares',
            '3': 'Brincos',
            '4': 'Pulseiras',
            '5': 'Relógios'
        };
        return categorias[valor] || valor;
    }

    // Retorna o texto do tipo
    function getTipoTexto(valor) {
        const tipos = {
            '1': 'Ouro',
            '2': 'Prata',
            '3': 'Bijuteria'
        };
        return tipos[valor] || valor;
    }

    // Adiciona novo produto
    formProduto.addEventListener('submit', function(e) {
        e.preventDefault();
        
        const novoProduto = {
            id: produtos.length > 0 ? Math.max(...produtos.map(p => p.id)) + 1 : 1,
            nome: document.getElementById('idProduto').value,
            ornamento: document.getElementById('idOrnamentos').value,
            categoria: document.getElementById('idCategoria').value,
            tipo: document.getElementById('idTipoProduto').value
        };
        
        produtos.push(novoProduto);
        localStorage.setItem('produtos', JSON.stringify(produtos));
        exibirProdutos();
        formProduto.reset();
        
        alert('Produto adicionado com sucesso!');
    });

    // Função para editar produto
    window.editarProduto = function(id) {
        const produto = produtos.find(p => p.id === id);
        if (produto) {
            document.getElementById('idProduto').value = produto.nome;
            document.getElementById('idOrnamentos').value = produto.ornamento;
            document.getElementById('idCategoria').value = produto.categoria;
            document.getElementById('idTipoProduto').value = produto.tipo;
            
            // Remove o produto da lista
            produtos = produtos.filter(p => p.id !== id);
            localStorage.setItem('produtos', JSON.stringify(produtos));
            exibirProdutos();
        }
    };

    // Função para excluir produto
    window.excluirProduto = function(id) {
        if (confirm('Tem certeza que deseja excluir este produto?')) {
            produtos = produtos.filter(p => p.id !== id);
            localStorage.setItem('produtos', JSON.stringify(produtos));
            exibirProdutos();
            alert('Produto excluído com sucesso!');
        }
    };

    // Carrega os produtos ao iniciar
    exibirProdutos();
});