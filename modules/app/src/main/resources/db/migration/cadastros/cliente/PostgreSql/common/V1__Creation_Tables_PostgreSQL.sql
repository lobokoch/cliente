/**************** WARNING WILL DELETE ALL TABLES *********
DROP TABLE IF EXISTS cliente CASCADE;
**********************************************************/

CREATE TABLE cliente /* Cliente */  (
	id UUID NOT NULL,
	tipo_pessoa VARCHAR(255) NOT NULL /* tipoPessoa */,
	nome VARCHAR(255) NOT NULL,
	cnpj_cpf VARCHAR(255) /* cnpjCPF */,
	ie_rg VARCHAR(255) /* ieRG */,
	data_fundacao_nascimento DATE /* dataFundacaoNascimento */,
	nome_contato VARCHAR(255) /* nomeContato */,
	fone VARCHAR(255),
	celular VARCHAR(255),
	email VARCHAR(255),
	site VARCHAR(255),
	cep VARCHAR(255),
	uf VARCHAR(2),
	cidade VARCHAR(255),
	bairro VARCHAR(255),
	endereco VARCHAR(255),
	numero VARCHAR(255),
	complemento VARCHAR(255),
	observacoes VARCHAR(1000),
	ativo BOOLEAN DEFAULT true
);

/* PRIMARY KEYS */
ALTER TABLE cliente ADD CONSTRAINT pk_cliente_id PRIMARY KEY (id);

/* FOREIGN KEYS */

