CREATE TABLE fossils(
  id											serial					PRIMARY KEY,
  name									  text						UNIQUE NOT NULL,
  created_at							timestamp				NOT NULL 					DEFAULT now(),
	updated_at							timestamp				NOT NULL 					DEFAULT now()
);

CREATE TABLE resonators(
  id											serial					PRIMARY KEY,
  name									  text						UNIQUE NOT NULL,
  reforges                boolean         NOT NULL,
  created_at							timestamp				NOT NULL 					DEFAULT now(),
	updated_at							timestamp				NOT NULL 					DEFAULT now()
);

DELETE FROM currency
  WHERE currency_type = 'Fossil'
     or currency_type = 'Resonator';

INSERT INTO fossils(name)
VALUES
  ('Bloodstained Fossil'),
  ('Fractured Fossil'),
  ('Faceted Fossil'),
  ('Hollow Fossil'),
  ('Glyphic Fossil'),
  ('Sanctified Fossil'),
  ('Dense Fossil'),
  ('Gilded Fossil'),
  ('Tangled Fossil'),
  ('Perfect Fossil'),
  ('Aetheric Fossil'),
  ('Enchanted Fossil'),
  ('Prismatic Fossil'),
  ('Pristine Fossil'),
  ('Metallic Fossil'),
  ('Shuddering Fossil'),
  ('Bound Fossil'),
  ('Aberrant Fossil'),
  ('Corroded Fossil'),
  ('Encrusted Fossil'),
  ('Frigid Fossil'),
  ('Scorched Fossil'),
  ('Serrated Fossil'),
  ('Jagged Fossil'),
  ('Lucent Fossil');

INSERT INTO resonators(name, reforges)
VALUES
  ('Prime Chaotic Resonator', true),
  ('Prime Alchemical Resonator', false),
  ('Potent Alchemical Resonator', false),
  ('Potent Chaotic Resonator', true),
  ('Powerful Chaotic Resonator', true),
  ('Primitive Alchemical Resonator', false),
  ('Primitive Chaotic Resonator', true),
  ('Powerful Alchemical Resonator', false);