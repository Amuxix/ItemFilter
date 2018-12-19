CREATE TABLE items(
  id											serial					PRIMARY KEY,
  "name"									text						NOT NULL,
  height                  smallint        NOT NULL,
  weight                  smallint        NOT NULL,
  class                   text            NOT NULL,
  drop_level              smallint        NULL,
	created_at							timestamp				NOT NULL 					DEFAULT now(),
	updated_at							timestamp				NOT NULL 					DEFAULT now()
);

CREATE TABLE uniques(
  id											serial					PRIMARY KEY,
  "name"									text						NOT NULL,
  base  									integer					NOT NULL          REFERENCES items(id),
	created_at							timestamp				NOT NULL 					DEFAULT now(),
	updated_at							timestamp				NOT NULL 					DEFAULT now()
);