/**************** WARNING WILL DELETE ALL TABLES *********
DROP TABLE IF EXISTS cliente CASCADE;
DROP TABLE IF EXISTS recurso CASCADE;
DROP TABLE IF EXISTS compromisso CASCADE;
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
	uf VARCHAR(255),
	cidade VARCHAR(255),
	bairro VARCHAR(255),
	endereco VARCHAR(255),
	numero VARCHAR(255),
	complemento VARCHAR(255),
	observacoes VARCHAR(1000),
	ativo BOOLEAN DEFAULT true
);

CREATE TABLE recurso (
	id UUID NOT NULL,
	nome VARCHAR(255) NOT NULL,
	email VARCHAR(255),
	ativo BOOLEAN DEFAULT true,
	created_by VARCHAR(255) /* createdBy */,
	created_date TIMESTAMP /* createdDate */,
	last_modified_by VARCHAR(255) /* lastModifiedBy */,
	last_modified_date TIMESTAMP /* lastModifiedDate */
);

CREATE TABLE compromisso (
	id UUID NOT NULL,
	titulo VARCHAR(255) NOT NULL,
	cliente UUID,
	data_ini DATE NOT NULL /* dataIni */,
	hora_ini TIME NOT NULL /* horaIni */,
	data_fim DATE /* dataFim */,
	hora_fim TIME /* horaFim */,
	dia_todo BOOLEAN DEFAULT false /* diaTodo */,
	situacao VARCHAR(255) NOT NULL,
	descricao VARCHAR(1000),
	local VARCHAR(255),
	created_by VARCHAR(255) /* createdBy */,
	created_date TIMESTAMP /* createdDate */,
	last_modified_by VARCHAR(255) /* lastModifiedBy */,
	last_modified_date TIMESTAMP /* lastModifiedDate */
);

CREATE TABLE compromisso_recursos /* compromisso + recursos */ (
	compromisso_id UUID NOT NULL /* id */,
	recurso_id UUID NOT NULL /* id */
);

/* PRIMARY KEYS */
ALTER TABLE cliente ADD CONSTRAINT pk_cliente_id PRIMARY KEY (id);
ALTER TABLE recurso ADD CONSTRAINT pk_recurso_id PRIMARY KEY (id);
ALTER TABLE compromisso ADD CONSTRAINT pk_compromisso_id PRIMARY KEY (id);
ALTER TABLE compromisso_recursos ADD CONSTRAINT pk_compromisso_recursos PRIMARY KEY (compromisso_id, recurso_id);

/* FOREIGN KEYS */
ALTER TABLE compromisso ADD CONSTRAINT fk_compromisso_cliente FOREIGN KEY (cliente) REFERENCES cliente (id);
ALTER TABLE compromisso_recursos ADD CONSTRAINT fk_compromisso_recursos_compromisso_id FOREIGN KEY (compromisso_id) REFERENCES compromisso (id);
ALTER TABLE compromisso_recursos ADD CONSTRAINT fk_compromisso_recursos_recurso_id FOREIGN KEY (recurso_id) REFERENCES recurso (id);


/* INDEXES */
