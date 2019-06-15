CREATE TABLE incubators (
    id           serial PRIMARY KEY,
    name         text UNIQUE NOT NULL,
    drop_enabled boolean     NOT NULL DEFAULT true,
    created_at   timestamp   NOT NULL DEFAULT now(),
    updated_at   timestamp   NOT NULL DEFAULT now()
);

CREATE TABLE map_fragment_fragments (
    id            serial PRIMARY KEY,
    name          text UNIQUE NOT NULL,
    stack_size    smallint    NOT NULL,
    fragment_of   text        NOT NULL REFERENCES map_fragments(name),
    fragment_type map_fragment_type NOT NULL,
    drop_enabled  boolean     NOT NULL DEFAULT true,
    created_at    timestamp   NOT NULL DEFAULT now(),
    updated_at    timestamp   NOT NULL DEFAULT now()
);

DELETE FROM currency_fragments WHERE name LIKE 'Splinter of %';

INSERT INTO map_fragments (name, fragment_type)
VALUES
    ('Timeless Karui Emblem', 'Emblem'),
    ('Timeless Maraketh Emblem', 'Emblem'),
    ('Timeless Eternal Emblem', 'Emblem'),
    ('Timeless Templar Emblem', 'Emblem'),
    ('Timeless Vaal Emblem', 'Emblem');

INSERT INTO map_fragment_fragments (name, fragment_of, stack_size, fragment_type)
VALUES
    ('Splinter of Chayula', 'Chayula''s Breachstone', 100, 'Breachstone'),
    ('Splinter of Esh', 'Esh''s Breachstone', 100, 'Breachstone'),
    ('Splinter of Uul-Netol', 'Uul-Netol''s Breachstone', 100, 'Breachstone'),
    ('Splinter of Xoph', 'Xoph''s Breachstone', 100, 'Breachstone'),
    ('Splinter of Tul', 'Tul''s Breachstone', 100, 'Breachstone'),
    ('Timeless Karui Splinter', 'Timeless Karui Emblem', 50, 'Emblem'),
    ('Timeless Maraketh Splinter', 'Timeless Maraketh Emblem', 50, 'Emblem'),
    ('Timeless Eternal Empire Splinter', 'Timeless Eternal Emblem', 50, 'Emblem'),
    ('Timeless Templar Splinter', 'Timeless Templar Emblem', 50, 'Emblem'),
    ('Timeless Vaal Splinter', 'Timeless Vaal Emblem', 50, 'Emblem');

INSERT INTO incubators (name)
VALUES
    ('Whispering Incubator'),
    ('Fine Incubator'),
    ('Singular Incubator'),
    ('Cartographer''s Incubator'),
    ('Otherworldly Incubator'),
    ('Abyssal Incubator'),
    ('Fragmented Incubator'),
    ('Skittering Incubator'),
    ('Infused Incubator'),
    ('Fossilised Incubator'),
    ('Decadent Incubator'),
    ('Diviner''s Incubator'),
    ('Primal Incubator'),
    ('Enchanted Incubator'),
    ('Geomancer''s Incubator'),
    ('Ornate Incubator'),
    ('Time-Lost Incubator'),
    ('Celestial Armoursmith''s Incubator'),
    ('Celestial Blacksmith''s Incubator'),
    ('Celestial Jeweller''s Incubator'),
    ('Eldritch Incubator'),
    ('Obscured Incubator'),
    ('Foreboding Incubator'),
    ('Thaumaturge''s Incubator'),
    ('Mysterious Incubator'),
    ('Gemcutter''s Incubator');

INSERT INTO bases (name, height, width, item_type, drop_level)
VALUES
    ('Timeless Jewel', 1, 1, 'Jewel', 1);

INSERT INTO divination_cards(name)
VALUES
    ('Vanity'),
    ('Imperial Legacy'),
    ('Burning Blood'),
    ('The Primordial'),
    ('Echoes of Love'),
    ('Thirst for Knowledge'),
    ('Alluring Bounty'),
    ('The Fool'),
    ('Pride of the First Ones'),
    ('The Deep Ones'),
    ('The Archmage''s Right Hand'),
    ('Dark Dreams'),
    ('Buried Treasure'),
    ('Demigod''s Wager');

UPDATE uniques SET base = 'Iron Staff' WHERE name = 'Pillar of the Caged God';
UPDATE maps SET tier = 1 WHERE name = 'Sulphur Vents Map';
UPDATE maps SET tier = 1 WHERE name = 'Haunted Mansion Map';
UPDATE maps SET tier = 1 WHERE name = 'Desert Map';
UPDATE maps SET tier = 1 WHERE name = 'Ivory Temple Map';
UPDATE maps SET tier = 2 WHERE name = 'Glacier Map';
UPDATE maps SET tier = 2 WHERE name = 'Thicket Map';
UPDATE maps SET tier = 2 WHERE name = 'Alleyways Map';
UPDATE maps SET tier = 2 WHERE name = 'Lookout Map';
UPDATE maps SET tier = 2 WHERE name = 'Barrows Map';
UPDATE maps SET tier = 2 WHERE name = 'Armoury Map';
UPDATE maps SET tier = 3 WHERE name = 'Leyline Map';
UPDATE maps SET tier = 3 WHERE name = 'Mausoleum Map';
UPDATE maps SET tier = 3 WHERE name = 'Ashen Wood Map';
UPDATE maps SET tier = 3 WHERE name = 'Relic Chambers Map';
UPDATE maps SET tier = 3 WHERE name = 'Pier Map';
UPDATE maps SET tier = 3 WHERE name = 'Arid Lake Map';
UPDATE maps SET tier = 3 WHERE name = 'Arachnid Tomb Map';
UPDATE maps SET tier = 3 WHERE name = 'Flooded Mine Map';
UPDATE maps SET tier = 3 WHERE name = 'Wharf Map';
UPDATE maps SET tier = 3 WHERE name = 'Pen Map';
UPDATE maps SET tier = 4 WHERE name = 'Excavation Map';
UPDATE maps SET tier = 4 WHERE name = 'Crater Map';
UPDATE maps SET tier = 4 WHERE name = 'City Square Map';
UPDATE maps SET tier = 4 WHERE name = 'Fields Map';
UPDATE maps SET tier = 4 WHERE name = 'Cage Map';
UPDATE maps SET tier = 4 WHERE name = 'Grotto Map';
UPDATE maps SET tier = 4 WHERE name = 'Cursed Crypt Map';
UPDATE maps SET tier = 4 WHERE name = 'Strand Map';
UPDATE maps SET tier = 4 WHERE name = 'Channel Map';
UPDATE maps SET tier = 4 WHERE name = 'Beach Map';
UPDATE maps SET tier = 5 WHERE name = 'Marshes Map';
UPDATE maps SET tier = 5 WHERE name = 'Spider Lair Map';
UPDATE maps SET tier = 5 WHERE name = 'Tropical Island Map';
UPDATE maps SET tier = 5 WHERE name = 'Ramparts Map';
UPDATE maps SET tier = 5 WHERE name = 'Burial Chambers Map';
UPDATE maps SET tier = 5 WHERE name = 'Mesa Map';
UPDATE maps SET tier = 5 WHERE name = 'Jungle Valley Map';
UPDATE maps SET tier = 5 WHERE name = 'Peninsula Map';
UPDATE maps SET tier = 5 WHERE name = 'Arcade Map';
UPDATE maps SET tier = 5 WHERE name = 'Fungal Hollow Map';
UPDATE maps SET tier = 6 WHERE name = 'Mud Geyser Map';
UPDATE maps SET tier = 6 WHERE name = 'Courtyard Map';
UPDATE maps SET tier = 6 WHERE name = 'Ancient City Map';
UPDATE maps SET tier = 6 WHERE name = 'Atoll Map';
UPDATE maps SET tier = 6 WHERE name = 'Maze Map';
UPDATE maps SET tier = 6 WHERE name = 'Promenade Map';
UPDATE maps SET tier = 6 WHERE name = 'Cells Map';
UPDATE maps SET tier = 6 WHERE name = 'Phantasmagoria Map';
UPDATE maps SET tier = 6 WHERE name = 'Waste Pool Map';
UPDATE maps SET tier = 6 WHERE name = 'Overgrown Ruin Map';
UPDATE maps SET tier = 6 WHERE name = 'Primordial Pool Map';
UPDATE maps SET tier = 7 WHERE name = 'Residence Map';
UPDATE maps SET tier = 7 WHERE name = 'Spider Forest Map';
UPDATE maps SET tier = 7 WHERE name = 'Arena Map';
UPDATE maps SET tier = 7 WHERE name = 'Dungeon Map';
UPDATE maps SET tier = 7 WHERE name = 'Racecourse Map';
UPDATE maps SET tier = 7 WHERE name = 'Graveyard Map';
UPDATE maps SET tier = 7 WHERE name = 'Vault Map';
UPDATE maps SET tier = 7 WHERE name = 'Waterways Map';
UPDATE maps SET tier = 7 WHERE name = 'Conservatory Map';
UPDATE maps SET tier = 7 WHERE name = 'Laboratory Map';
UPDATE maps SET tier = 7 WHERE name = 'Overgrown Shrine Map';
UPDATE maps SET tier = 8 WHERE name = 'Iceberg Map';
UPDATE maps SET tier = 8 WHERE name = 'Pit Map';
UPDATE maps SET tier = 8 WHERE name = 'Ghetto Map';
UPDATE maps SET tier = 8 WHERE name = 'Bone Crypt Map';
UPDATE maps SET tier = 8 WHERE name = 'Chateau Map';
UPDATE maps SET tier = 8 WHERE name = 'Toxic Sewer Map';
UPDATE maps SET tier = 8 WHERE name = 'Scriptorium Map';
UPDATE maps SET tier = 8 WHERE name = 'Dunes Map';
UPDATE maps SET tier = 8 WHERE name = 'Factory Map';
UPDATE maps SET tier = 8 WHERE name = 'Necropolis Map';
UPDATE maps SET tier = 8 WHERE name = 'Estuary Map';
UPDATE maps SET tier = 9 WHERE name = 'Arachnid Nest Map';
UPDATE maps SET tier = 9 WHERE name = 'Port Map';
UPDATE maps SET tier = 9 WHERE name = 'Villa Map';
UPDATE maps SET tier = 9 WHERE name = 'Mineral Pools Map';
UPDATE maps SET tier = 9 WHERE name = 'Underground River Map';
UPDATE maps SET tier = 9 WHERE name = 'Underground Sea Map';
UPDATE maps SET tier = 9 WHERE name = 'Castle Ruins Map';
UPDATE maps SET tier = 9 WHERE name = 'Shore Map';
UPDATE maps SET tier = 9 WHERE name = 'Moon Temple Map';
UPDATE maps SET tier = 9 WHERE name = 'Arsenal Map';
UPDATE maps SET tier = 9 WHERE name = 'Lighthouse Map';
UPDATE maps SET tier = 10 WHERE name = 'Sepulchre Map';
UPDATE maps SET tier = 10 WHERE name = 'Coral Ruins Map';
UPDATE maps SET tier = 10 WHERE name = 'Volcano Map';
UPDATE maps SET tier = 10 WHERE name = 'Geode Map';
UPDATE maps SET tier = 10 WHERE name = 'Bog Map';
UPDATE maps SET tier = 10 WHERE name = 'Plateau Map';
UPDATE maps SET tier = 10 WHERE name = 'Lava Chamber Map';
UPDATE maps SET tier = 10 WHERE name = 'Bazaar Map';
UPDATE maps SET tier = 10 WHERE name = 'Academy Map';
UPDATE maps SET tier = 10 WHERE name = 'Temple Map';
UPDATE maps SET tier = 11 WHERE name = 'Infested Valley Map';
UPDATE maps SET tier = 11 WHERE name = 'Dig Map';
UPDATE maps SET tier = 11 WHERE name = 'Lair Map';
UPDATE maps SET tier = 11 WHERE name = 'Malformation Map';
UPDATE maps SET tier = 11 WHERE name = 'Siege Map';
UPDATE maps SET tier = 11 WHERE name = 'Gardens Map';
UPDATE maps SET tier = 11 WHERE name = 'Crimson Temple Map';
UPDATE maps SET tier = 11 WHERE name = 'Precinct Map';
UPDATE maps SET tier = 11 WHERE name = 'Colonnade Map';
UPDATE maps SET tier = 11 WHERE name = 'Museum Map';
UPDATE maps SET tier = 12 WHERE name = 'Lava Lake Map';
UPDATE maps SET tier = 12 WHERE name = 'Cemetery Map';
UPDATE maps SET tier = 12 WHERE name = 'Vaal Pyramid Map';
UPDATE maps SET tier = 12 WHERE name = 'Park Map';
UPDATE maps SET tier = 12 WHERE name = 'Shipyard Map';
UPDATE maps SET tier = 12 WHERE name = 'Core Map';
UPDATE maps SET tier = 12 WHERE name = 'Carcass Map';
UPDATE maps SET tier = 12 WHERE name = 'Canyon Map';
UPDATE maps SET tier = 12 WHERE name = 'Colosseum Map';
UPDATE maps SET tier = 13 WHERE name = 'Tower Map';
UPDATE maps SET tier = 13 WHERE name = 'Sunken City Map';
UPDATE maps SET tier = 13 WHERE name = 'Defiled Cathedral Map';
UPDATE maps SET tier = 13 WHERE name = 'Belfry Map';
UPDATE maps SET tier = 13 WHERE name = 'Coves Map';
UPDATE maps SET tier = 13 WHERE name = 'Shrine Map';
UPDATE maps SET tier = 13 WHERE name = 'Plaza Map';
UPDATE maps SET tier = 13 WHERE name = 'Terrace Map';
UPDATE maps SET tier = 13 WHERE name = 'Reef Map';
UPDATE maps SET tier = 14 WHERE name = 'Primordial Blocks Map';
UPDATE maps SET tier = 14 WHERE name = 'Orchard Map';
UPDATE maps SET tier = 14 WHERE name = 'Wasteland Map';
UPDATE maps SET tier = 14 WHERE name = 'Crystal Ore Map';
UPDATE maps SET tier = 14 WHERE name = 'Courthouse Map';
UPDATE maps SET tier = 14 WHERE name = 'Basilica Map';
UPDATE maps SET tier = 14 WHERE name = 'Dark Forest Map';
UPDATE maps SET tier = 15 WHERE name = 'Summit Map';
UPDATE maps SET tier = 15 WHERE name = 'Caldera Map';
UPDATE maps SET tier = 15 WHERE name = 'Acid Caverns Map';
UPDATE maps SET tier = 15 WHERE name = 'Desert Springs Map';
UPDATE maps SET tier = 15 WHERE name = 'Palace Map';
UPDATE maps SET tier = 16 WHERE name = 'Vaal Temple Map';
UPDATE maps SET tier = 16 WHERE name = 'Forge of the Phoenix Map';
UPDATE maps SET tier = 16 WHERE name = 'Maze of the Minotaur Map';
UPDATE maps SET tier = 16 WHERE name = 'Pit of the Chimera Map';
UPDATE maps SET tier = 16 WHERE name = 'Lair of the Hydra Map';