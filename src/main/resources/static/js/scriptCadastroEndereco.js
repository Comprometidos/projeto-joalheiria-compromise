document.getElementById("cep").addEventListener("input", async function () {
    const cep = this.value.replace(/\D/g, "");
    
    if (cep.length === 8) {
        try {
            const response = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
            
            if (!response.ok) throw new Error("Erro ao buscar CEP");
            
            const dados = await response.json();
            
            if (dados.erro) {
                alert("CEP não encontrado.")
                return;
            }
            document.getElementById("rua").value = dados.logradouro || "";
            document.getElementById("bairro").value = dados.bairro || "";
            document.getElementById("cidade").value = dados.localidade || "";
            document.getElementById("estado").value = dados.uf || "";
        } catch (error) {
            alert("Erro ao buscar endereço: " + error.message);
        }
    }
});

document.addEventListener("DOMContentLoaded", () => {
    const urlParams = new URLSearchParams(window.location.search);
    const idUsuario = urlParams.get("idUsuario");

    if (!idUsuario) {
        alert("ID do usuário não encontrado na URL");
        return;
    }

    const form = document.getElementById("cadastroEnderecoForm");

    form.addEventListener("submit", async (event) => {
        event.preventDefault();

        const cep = document.getElementById("cep").value;
        const rua = document.getElementById("rua").value;
        const bairro = document.getElementById("bairro").value;
        const numero = document.getElementById("numero").value;
        const cidade = document.getElementById("cidade").value;
        const estado = document.getElementById("estado").value;
        const complemento = document.getElementById("complemento").value;

        try {
            const response = await fetch("http://localhost:8080/cadastroendereco", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    cep,
                    rua,
                    bairro,
                    numero,
                    cidade,
                    estado,
                    complemento,
                    usuarios: {
                        idUsuario: idUsuario
                    }
                }),
            });

            if (!response.ok) {
                const errorData = await response.json().catch(() => ({}));
                throw new Error(errorData.message || "Erro ao cadastrar o endereço do cliente");
            } else {
                alert("Endereço cadastrado com sucesso!");
                window.location.href = 'sucessocadastro.html';
            }
        } catch (error) {
            console.error("Erro ao cadastrar o endereço do cliente", error);
            alert("Erro ao cadastrar endereço: " + error.message);
        }
    });
});