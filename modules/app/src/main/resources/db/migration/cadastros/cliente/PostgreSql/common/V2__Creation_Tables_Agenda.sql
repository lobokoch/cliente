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
ALTER TABLE recurso ADD CONSTRAINT pk_recurso_id PRIMARY KEY (id);
ALTER TABLE compromisso ADD CONSTRAINT pk_compromisso_id PRIMARY KEY (id);
ALTER TABLE compromisso_recursos ADD CONSTRAINT pk_compromisso_recursos PRIMARY KEY (compromisso_id, recurso_id);

/* FOREIGN KEYS */
ALTER TABLE compromisso ADD CONSTRAINT fk_compromisso_cliente FOREIGN KEY (cliente) REFERENCES cliente (id);
ALTER TABLE compromisso_recursos ADD CONSTRAINT fk_compromisso_recursos_compromisso_id FOREIGN KEY (compromisso_id) REFERENCES compromisso (id);
ALTER TABLE compromisso_recursos ADD CONSTRAINT fk_compromisso_recursos_recurso_id FOREIGN KEY (recurso_id) REFERENCES recurso (id);


/* INDEXES */
