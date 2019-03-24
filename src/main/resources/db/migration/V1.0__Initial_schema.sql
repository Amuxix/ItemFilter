CREATE TYPE item_type AS ENUM (
  'Amulet',
  'Belt',
  'Quiver',
  'Ring',
  'Talisman',
  'Body Armour',
  'Boots',
  'Gloves',
  'Helmet',
  'Large Shield',
  'Medium Shield',
  'Small Shield',
  'Hybrid Flask',
  'Life Flask',
  'Mana Flask',
  'Utility Flask',
  'Jewel',
  'Abyss Jewel',
  'Bow',
  'Claw',
  'Dagger',
  'One Hand Axe',
  'One Hand Mace',
  'One Hand Sword',
  'Sceptre',
  'Staff',
  'Thrusting One Hand Sword',
  'Two Hand Axe',
  'Two Hand Mace',
  'Two Hand Sword',
  'Wand',
  'Piece'
  );

CREATE TYPE currency_type AS ENUM (
  'Net',
  'Orb',
  'Vial',
  'Fossil'
  );

CREATE TYPE map_fragment_type AS ENUM (
  'Breachstone',
  'Misc',
  'Mortal',
  'Prophecy',
  'Sacrifice',
  'Scarab',
  'Shaper'
  );

CREATE TABLE bases (
  id           serial PRIMARY KEY,
  name         text UNIQUE NOT NULL,
  drop_level   smallint    NOT NULL,
  drop_enabled boolean     NOT NULL DEFAULT true,
  item_type    item_type   NOT NULL,
  height       smallint    NULL,
  width        smallint    NULL,
  created_at   timestamp   NOT NULL DEFAULT now(),
  updated_at   timestamp   NOT NULL DEFAULT now()
);

CREATE TABLE uniques (
  id           serial PRIMARY KEY,
  name         text      NOT NULL,
  base         text      NOT NULL REFERENCES bases(name),
  drop_enabled boolean   NOT NULL DEFAULT true,
  created_at   timestamp NOT NULL DEFAULT now(),
  updated_at   timestamp NOT NULL DEFAULT now()
);

CREATE TABLE maps (
  id           serial PRIMARY KEY,
  name         text UNIQUE NOT NULL,
  tier         smallint    NOT NULL,
  drop_enabled boolean     NOT NULL DEFAULT true,
  created_at   timestamp   NOT NULL DEFAULT now(),
  updated_at   timestamp   NOT NULL DEFAULT now()
);

CREATE TABLE map_fragments (
  id            serial PRIMARY KEY,
  name          text UNIQUE       NOT NULL,
  fragment_type map_fragment_type NOT NULL,
  drop_enabled  boolean           NOT NULL DEFAULT true,
  created_at    timestamp         NOT NULL DEFAULT now(),
  updated_at    timestamp         NOT NULL DEFAULT now()
);

CREATE TABLE currency (
  id            serial PRIMARY KEY,
  name          text UNIQUE   NOT NULL,
  stack_size    smallint      NOT NULL,
  currency_type currency_type NOT NULL,
  drop_enabled  boolean       NOT NULL DEFAULT true,
  created_at    timestamp     NOT NULL DEFAULT now(),
  updated_at    timestamp     NOT NULL DEFAULT now()
);

CREATE TABLE currency_fragments (
  id           serial PRIMARY KEY,
  name         text UNIQUE NOT NULL,
  stack_size   smallint    NOT NULL,
  fragment_of  text        NOT NULL REFERENCES currency(name),
  drop_enabled boolean     NOT NULL DEFAULT true,
  created_at   timestamp   NOT NULL DEFAULT now(),
  updated_at   timestamp   NOT NULL DEFAULT now()
);

CREATE TABLE essences (
  id           serial PRIMARY KEY,
  name         text UNIQUE NOT NULL,
  upgrades_to  text        NULL REFERENCES essences(name),
  drop_enabled boolean     NOT NULL DEFAULT true,
  created_at   timestamp   NOT NULL DEFAULT now(),
  updated_at   timestamp   NOT NULL DEFAULT now()
);

CREATE TABLE divination_cards (
  id           serial PRIMARY KEY,
  name         text UNIQUE NOT NULL,
  drop_enabled boolean     NOT NULL DEFAULT true,
  created_at   timestamp   NOT NULL DEFAULT now(),
  updated_at   timestamp   NOT NULL DEFAULT now()
);

CREATE TABLE incursion_items (
  id           serial PRIMARY KEY,
  name         text UNIQUE NOT NULL,
  drop_enabled boolean     NOT NULL DEFAULT true,
  created_at   timestamp   NOT NULL DEFAULT now(),
  updated_at   timestamp   NOT NULL DEFAULT now()
);

CREATE TABLE resonators (
  id           serial PRIMARY KEY,
  name         text UNIQUE NOT NULL,
  reforges     boolean     NOT NULL,
  drop_enabled boolean     NOT NULL DEFAULT true,
  created_at   timestamp   NOT NULL DEFAULT now(),
  updated_at   timestamp   NOT NULL DEFAULT now()
);

CREATE TABLE prophecies (
  id           serial PRIMARY KEY,
  name         text UNIQUE NOT NULL,
  drop_enabled boolean     NOT NULL DEFAULT true,
  created_at   timestamp   NOT NULL DEFAULT now(),
  updated_at   timestamp   NOT NULL DEFAULT now()
);