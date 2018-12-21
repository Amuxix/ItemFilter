CREATE TABLE bases(
  id											serial					PRIMARY KEY,
  name									  text						UNIQUE NOT NULL,
  height                  smallint        NOT NULL,
  width                   smallint        NOT NULL,
  class                   text            NOT NULL,
  drop_level              smallint        NOT NULL,
	created_at							timestamp				NOT NULL 					DEFAULT now(),
	updated_at							timestamp				NOT NULL 					DEFAULT now()
);

CREATE TABLE uniques(
  id											serial					PRIMARY KEY,
  name									  text						UNIQUE NOT NULL,
  base  							    text					  NOT NULL          REFERENCES bases(name),
	created_at							timestamp				NOT NULL 					DEFAULT now(),
	updated_at							timestamp				NOT NULL 					DEFAULT now()
);

CREATE TABLE maps(
  id											serial					PRIMARY KEY,
  name									  text					  UNIQUE NOT NULL,
  tier                    smallint        NOT NULL,
	created_at							timestamp				NOT NULL 					DEFAULT now(),
	updated_at							timestamp				NOT NULL 					DEFAULT now()
);

CREATE TABLE unique_maps(
  id											serial					PRIMARY KEY,
  name									  text						UNIQUE NOT NULL,
  map       							text					  NOT NULL          REFERENCES maps(name),
	created_at							timestamp				NOT NULL 					DEFAULT now(),
	updated_at							timestamp				NOT NULL 					DEFAULT now()
);

CREATE TABLE map_fragments(
  id											serial					PRIMARY KEY,
  name									  text					  UNIQUE NOT NULL,
  fragment_type						text						NOT NULL,
	created_at							timestamp				NOT NULL 					DEFAULT now(),
	updated_at							timestamp				NOT NULL 					DEFAULT now()
);

CREATE TABLE currency(
  id											serial					PRIMARY KEY,
  name									  text						UNIQUE NOT NULL,
  stack_size							smallint		    NOT NULL,
  currency_type						text		        NOT NULL,
  created_at							timestamp				NOT NULL 					DEFAULT now(),
	updated_at							timestamp				NOT NULL 					DEFAULT now()
);

CREATE TABLE currency_fragments(
  id											serial					PRIMARY KEY,
  name									  text						UNIQUE NOT NULL,
  fragment_of             text					  UNIQUE NOT NULL   REFERENCES currency(name),
  stack_size							smallint		    NOT NULL,
  created_at							timestamp				NOT NULL 					DEFAULT now(),
	updated_at							timestamp				NOT NULL 					DEFAULT now()
);

CREATE TABLE essences(
  id											serial					PRIMARY KEY,
  name									  text						UNIQUE NOT NULL,
  upgrades_to							text 		        NULL              REFERENCES essences(name),
  created_at							timestamp				NOT NULL 					DEFAULT now(),
	updated_at							timestamp				NOT NULL 					DEFAULT now()
);

CREATE TABLE divination_cards(
  id											serial					PRIMARY KEY,
  name									  text						UNIQUE NOT NULL,
  created_at							timestamp				NOT NULL 					DEFAULT now(),
	updated_at							timestamp				NOT NULL 					DEFAULT now()
);

CREATE TABLE incursion_items(
  id											serial					PRIMARY KEY,
  name									  text						UNIQUE NOT NULL,
  created_at							timestamp				NOT NULL 					DEFAULT now(),
	updated_at							timestamp				NOT NULL 					DEFAULT now()
);