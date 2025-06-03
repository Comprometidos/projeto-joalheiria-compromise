CREATE DATABASE IF NOT EXISTS db_joalheriajoiasjoia;

USE db_joalheriajoiasjoia;

INSERT IGNORE INTO tb_tipo_usuario (id_tipo_usuario, nome_tipo_usuario) VALUES
(1, 'Admin'),
(2, 'Cliente'),
(3, 'Vendedor'),
(4, 'Gerente');

--Inserindo Categorias (se não existirem)
INSERT IGNORE INTO tb_categoria (id_categoria, nome_categoria, descricao_categoria) VALUES
(1, 'Anéis', 'Acesório para os dedos'),
(2, 'Colares', 'Acesório para o pescoço'),
(3, 'Brincos', 'Acesório para as orelhas'),
(4, 'Pulseiras', 'Acessorio para os braços'),
(5, 'Relógios', 'Acesório para não atrasar no SENAI');

-- Inserindo Tipos (se não existirem)
INSERT IGNORE INTO tb_tipo_produto (id_tipo_produto, nome_tipo_produto, descricao_tipo_produto) VALUES
(1, 'Ouro', '18k'),
(2, 'Prata', '750'),
(3, 'Bijuteria', 'É biju mas é de rico'),
(4, 'Ouro Rosê', 'Ouro meio rosado');

-- Inserindo Produtos
INSERT IGNORE INTO tb_produto (id_produto, categoria, nome_produto, ornamentos, preco, tipo_produto) VALUES
(1, 'Aneis', 'Anel de diamante rosa', 'Diamante Rosa', 155.4, 2),
(2, 'Aneis', 'Anel com pérola e ouro branco', 'Ouro Branco', 1928.8, 2),
(3, 'Aneis', 'Anel de prata com pedras de diamante', 'Diamante', 1333.2, 2),
(4, 'Aneis', 'Anel de prata e pedras de diamantes', 'Diamante', 196.1, 2),
(5, 'Aneis', 'Anel florirose', 'Rubi', 150.1, 4),
(6, 'Brinco', 'Brinco Cravejado de Diamante', 'Diamante', 110.1, 2),
(7, 'Brinco', 'Argola Ouro Amarelo', 'Nenhum', 330.1, 1),
(8, 'Relógios', 'Relógio cravejado banhado a ouro branco', 'Nenhum', 1045.1, 2),
(9, 'Pulseira', 'Pulseira de Prata coração', 'Nenhum', 720.1, 2),
(10, 'Pulseira', 'Pulseira Cravejada Ouro-rose', 'Nenhum', 215.1, 4),
(11, 'Pulseira', 'Pulseira-rose banhada a Ouro', 'Nenhum', 135.1, 4),
(12, 'Pulseira', 'Pulseira coração de Ouro', 'Nenhum', 198.1, 1),
(13, 'Pulseira', 'Pulseira em laço Pratas Preciosas', 'Nenhum', 350.1, 1),
(14, 'Pulseira', 'Pulseira Riviera em prata 925', 'Nenhum', 298.1, 1),
(15, 'Colar', 'Colar com pingente de diamante negro', 'Diamante Negro', 980.1, 2),
(16, 'Colar', 'Colar de ouro branco com safira azul', 'Safira', 1250.1, 1),
(17, 'Relógios', 'Relógio automático com pulseira de couro', 'Nenhum', 875.1, 3),
(18, 'Brinco', 'Brinco de esmeralda com ouro rosé', 'Esmeralda', 1150.1, 2),
(19, 'Aneis', 'Anel de ouro amarelo com topázio', 'Topázio', 460.1, 1),
(20, 'Colar', 'Colar minimalista de prata com rubi', 'Rubi', 312.1, 4);

-- Inserindo Usuarios
INSERT IGNORE INTO tb_usuario (id_usuario, cpf, dt_nascimento, email, nome_usuario, senha, telefone, id_tipo_usuario) VALUES
(1, '45519818902', '2007-12-28', 'm36230989@gmail.com', 'Miguel Silva Santos', 'Miguel@2025', '11992827302', 1),
(2, '44455599928', '1900-12-25', 'joao@gmail.com', 'Joao Pedro Aqcuaviva', 'Joao2025', '15988982345', 2),
(3, '98765432109', '1992-08-30', 'carlos.oliveira@empresa.com', 'Carlos Oliveira', 'C@rlos123', '21999887766', 2),
(4, '45678912345', '1978-03-10', 'ana.santos@outlook.com', 'Ana Santos', 'An@2024!', '31988776655', 2),
(5, '78912345678', '1995-11-22', 'pedro.fernandes@gmail.com', 'Pedro Fernandes', 'PedroF95#', '41977665544', 2);

-- Inserindo Endereços dos Usuarios
INSERT IGNORE INTO tb_endereco (id_endereco, bairro, cep, cidade, complemento, estado, numero, rua, id_usuario) VALUES
(1, 'Vila Progresso', '18090380', 'Sorocaba', 'Casa', 'São Paulo', '160', 'Rua Professor Luiz de Vasconcelos', 1),
(2, 'Centro', '01001000', 'São Paulo', 'Apto 32', 'São Paulo', '100', 'Avenida Paulista', 2),
(3, 'Barra da Tijuca', '22790004', 'Rio de Janeiro', 'Bloco B Apto 502', 'Rio de Janeiro', '500', 'Avenida das Américas', 3),
(4, 'Savassi', '30140070', 'Belo Horizonte', 'Sala 304', 'Minas Gerais', '1200', 'Rua Pernambuco', 4),
(5, 'Batel', '80420000', 'Curitiba', 'Casa 2', 'Paraná', '45', 'Avenida do Batel', 5);