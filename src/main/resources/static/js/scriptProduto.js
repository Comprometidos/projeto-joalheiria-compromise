document.addEventListener('DOMContentLoaded', function() {
    const formProduto = document.getElementById('formProduto');
    const listaProdutos = document.getElementById('listaProdutos');
    
    // Array para armazenar os produtos (substituir por API real posteriormente)
    let produtos = [];
    
    // Função para carregar produtos (simulando uma API)
    function carregarProdutos() {
		
        // Simulando dados
        produtos = [
            { id: 1, nome: "Anel de Ouro", material: "Ouro 18k", categoria: "Anéis", tipo: "Ouro" },
            { id: 2, nome: "Colar de Prata", material: "Prata 925", categoria: "Colares", tipo: "Prata" }
        ];
        exibirProdutos();
    }
    
    // Função para exibir produtos na lista
    function exibirProdutos() {
        listaProdutos.innerHTML = '';
        
        produtos.forEach(produto => {
            const li = document.createElement('li');
            li.innerHTML = `
                <strong>${produto.nome}</strong> - ${produto.material}
                <br>Categoria: ${produto.categoria} | Tipo: ${produto.tipo}
                <button onclick="editarProduto(${produto.id})">Editar</button>
                <button onclick="excluirProduto(${produto.id})">Excluir</button>
            `;
            listaProdutos.appendChild(li);
        });
    }
    
    // Função para adicionar produto
    formProduto.addEventListener('submit', function(e) {
        e.preventDefault();
        
        const nomeProduto = document.getElementById('nomeProduto').value;
        const material = document.getElementById('material').value;
        
        // Obter texto da categoria e tipo selecionados
        const categoriaTexto = document.querySelector('#categoriaProduto option:checked').text;
        const tipoTexto = document.querySelector('#tipoProduto option:checked').text;
        
        // Criar novo produto
        const novoProduto = {
            id: produtos.length > 0 ? Math.max(...produtos.map(p => p.id)) + 1 : 1,
            nome: nomeProduto,
            material: material,
			categoria: {
				id: categoria
			}, 
			tipo: {
                id: tipo
			}
        };
        
        // Simulando adição
        produtos.push(novoProduto);
        exibirProdutos();
        formProduto.reset();
        
        alert('Produto adicionado com sucesso!');
    });
    
    // Funções para editar e excluir (simplificadas)
    window.editarProduto = function(id) {
        const produto = produtos.find(p => p.id === id);
        if (produto) {
            document.getElementById('nomeProduto').value = produto.nome;
            document.getElementById('material').value = produto.material;
            
            // Aqui você implementaria a lógica para atualizar o produto
            alert(`Editar produto ${produto.nome} (ID: ${id})`);
        }
    };
    
    window.excluirProduto = function(id) {
        if (confirm('Tem certeza que deseja excluir este produto?')) {
            produtos = produtos.filter(p => p.id !== id);
            exibirProdutos();
            alert('Produto excluído com sucesso!');
        }
    };
    
    // Carregar produtos quando a página é carregada
    carregarProdutos();
});