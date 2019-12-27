ALTER TYPE item_type RENAME VALUE 'Rune Dagger' TO 'Rune Daggers';
ALTER TYPE item_type RENAME VALUE 'Warstaff' TO 'Warstaves';

CREATE TABLE metamorph_samples (
  id           serial PRIMARY KEY,
  name         text UNIQUE NOT NULL,
  drop_enabled boolean     NOT NULL DEFAULT TRUE,
  created_at   timestamp   NOT NULL DEFAULT now(),
  updated_at   timestamp   NOT NULL DEFAULT now()
);

INSERT INTO metamorph_samples(name)
VALUES
  ('Metamorph Brain'),
  ('Metamorph Eye'),
  ('Metamorph Liver'),
  ('Metamorph Lung'),
  ('Metamorph Heart');

CREATE TABLE watchstones (
  id           serial PRIMARY KEY,
  name         text UNIQUE NOT NULL,
  drop_enabled boolean     NOT NULL DEFAULT TRUE,
  created_at   timestamp   NOT NULL DEFAULT now(),
  updated_at   timestamp   NOT NULL DEFAULT now()
);

INSERT INTO watchstones(name)
VALUES
  ('Ivory Watchstone');

INSERT INTO divination_cards(name)
VALUES
  ('Baited Expectations'),
  ('Succor of the Sinless'),
  ('Underground Forest'),
  ('The Escape'),
  ('Deathly Designs'),
  ('The Chosen'),
  ('Cameria''s Cut'),
  ('Divine Justice'),
  ('The Fishmonger'),
  ('The Bones'),
  ('Friendship'),
  ('The Craving'),
  ('Etched in Blood'),
  ('Squandered Prosperity');

INSERT INTO currency (name, stack_size, currency_type)
VALUES
  ('Turbulent Catalyst', 10, 'Catalyst'),
  ('Imbued Catalyst', 10, 'Catalyst'),
  ('Abrasive Catalyst', 10, 'Catalyst'),
  ('Tempering Catalyst', 10, 'Catalyst'),
  ('Fertile Catalyst', 10, 'Catalyst'),
  ('Prismatic Catalyst', 10, 'Catalyst'),
  ('Intrinsic Catalyst', 10, 'Catalyst'),
  ('Crusader''s Exalted Orb', 10, 'Orb'),
  ('Redeemer''s Exalted Orb', 10, 'Orb'),
  ('Hunter''s Exalted Orb', 10, 'Orb'),
  ('Warlord''s Exalted Orb', 10, 'Orb'),
  ('Awakener''s Orb', 10, 'Orb');

INSERT INTO map_fragments (name, fragment_type)
VALUES
  ('Fragment of Enslavement', 'Metamorph'),
  ('Fragment of Eradication', 'Metamorph'),
  ('Fragment of Constriction', 'Metamorph'),
  ('Fragment of Purification', 'Metamorph'),
  ('Fragment of Shape', 'Metamorph'),
  ('Fragment of Knowledge', 'Metamorph'),
  ('Fragment of Terror', 'Metamorph'),
  ('Fragment of Emptiness', 'Metamorph');