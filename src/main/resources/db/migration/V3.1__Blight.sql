INSERT INTO bases (name, height, width, item_type, drop_level)
VALUES
('Vermillion Ring', 1, 1, 'Ring', 80),
('Cerulean Ring', 1, 1, 'Ring', 80),
('Convoking Wand', 3, 1, 'Wand', 72);

UPDATE bases SET item_type = 'Rune Dagger'
WHERE name IN (
               'Carving Knife',
               'Boot Knife',
               'Copper Kris',
               'Skean',
               'Imp Dagger',
               'Butcher Knife',
               'Boot Blade',
               'Golden Kris',
               'Royal Skean',
               'Fiend Dagger',
               'Slaughter Knife',
               'Ezomyte Dagger',
               'Platinum Kris',
               'Imperial Skean',
               'Demon Dagger'
  );

UPDATE bases SET item_type = 'Warstaff'
WHERE name IN (
               'Iron Staff',
               'Coiled Staff',
               'Vile Staff',
               'Military Staff',
               'Serpentine Staff',
               'Foul Staff',
               'Ezomyte Staff',
               'Maelström Staff',
               'Judgement Staff'
  );

INSERT INTO currency (name, stack_size, currency_type)
VALUES
('Clear Oil', 10, 'Oil'),
('Sepia Oil', 10, 'Oil'),
('Amber Oil', 10, 'Oil'),
('Verdant Oil', 10, 'Oil'),
('Teal Oil', 10, 'Oil'),
('Azure Oil', 10, 'Oil'),
('Violet Oil', 10, 'Oil'),
('Crimson Oil', 10, 'Oil'),
('Black Oil', 10, 'Oil'),
('Opalescent Oil', 10, 'Oil'),
('Silver Oil', 10, 'Oil'),
('Golden Oil', 10, 'Oil');

INSERT INTO incubators (name)
VALUES
('Feral Incubator');

INSERT INTO map_fragments (name, fragment_type)
VALUES
('Rusted Legion Scarab', 'Scarab'),
('Polished Legion Scarab', 'Scarab'),
('Gilded Legion Scarab', 'Scarab');

INSERT INTO divination_cards(name)
VALUES
('The Old Man'),
('Nook''s Crown'),
('The Side Quest'),
('The Price of Loyalty'),
('The Heroic Shot'),
('Remembrance'),
('More is Never Enough'),
('Vile Power'),
('The Bargain'),
('Azyran''s Reward'),
('The Skeleton'),
('The Eye of Terror'),
('The Demon'),
('Akil''s Prophecy'),
('The Damned'),
('Void of the Elements'),
('The Deal'),
('The Wolf''s Legacy'),
('The Mountain');

UPDATE maps SET tier = 1 WHERE name = 'Arcade Map';
UPDATE maps SET tier = 1 WHERE name = 'Jungle Valley Map';
UPDATE maps SET tier = 1 WHERE name = 'Wharf Map';
UPDATE maps SET tier = 1 WHERE name = 'Pier Map';
UPDATE maps SET tier = 2 WHERE name = 'Alleyways Map';
UPDATE maps SET tier = 2 WHERE name = 'Cage Map';
UPDATE maps SET tier = 2 WHERE name = 'Excavation Map';
UPDATE maps SET tier = 2 WHERE name = 'Sulphur Vents Map';
UPDATE maps SET tier = 2 WHERE name = 'Armoury Map';
UPDATE maps SET tier = 2 WHERE name = 'Mesa Map';
UPDATE maps SET tier = 3 WHERE name = 'Pen Map';
UPDATE maps SET tier = 3 WHERE name = 'Desert Map';
UPDATE maps SET tier = 3 WHERE name = 'Fungal Hollow Map';
UPDATE maps SET tier = 3 WHERE name = 'Strand Map';
UPDATE maps SET tier = 3 WHERE name = 'Ivory Temple Map';
UPDATE maps SET tier = 3 WHERE name = 'Spider Lair Map';
UPDATE maps SET tier = 3 WHERE name = 'Mausoleum Map';
UPDATE maps SET tier = 3 WHERE name = 'Ashen Wood Map';
UPDATE maps SET tier = 3 WHERE name = 'Ramparts Map';
UPDATE maps SET tier = 3 WHERE name = 'Tropical Island Map';
UPDATE maps SET tier = 4 WHERE name = 'Arid Lake Map';
UPDATE maps SET tier = 4 WHERE name = 'Flooded Mine Map';
UPDATE maps SET tier = 4 WHERE name = 'Leyline Map';
UPDATE maps SET tier = 4 WHERE name = 'Burial Chambers Map';
UPDATE maps SET tier = 4 WHERE name = 'Channel Map';
UPDATE maps SET tier = 4 WHERE name = 'Barrows Map';
UPDATE maps SET tier = 4 WHERE name = 'Fields Map';
UPDATE maps SET tier = 4 WHERE name = 'Crater Map';
UPDATE maps SET tier = 4 WHERE name = 'Arachnid Tomb Map';
UPDATE maps SET tier = 4 WHERE name = 'Cursed Crypt Map';
UPDATE maps SET tier = 5 WHERE name = 'Lookout Map';
UPDATE maps SET tier = 5 WHERE name = 'Beach Map';
UPDATE maps SET tier = 5 WHERE name = 'Marshes Map';
UPDATE maps SET tier = 5 WHERE name = 'Peninsula Map';
UPDATE maps SET tier = 5 WHERE name = 'City Square Map';
UPDATE maps SET tier = 5 WHERE name = 'Relic Chambers Map';
UPDATE maps SET tier = 5 WHERE name = 'Grotto Map';
UPDATE maps SET tier = 5 WHERE name = 'Glacier Map';
UPDATE maps SET tier = 5 WHERE name = 'Haunted Mansion Map';
UPDATE maps SET tier = 5 WHERE name = 'Thicket Map';
UPDATE maps SET tier = 6 WHERE name = 'Lighthouse Map';
UPDATE maps SET tier = 6 WHERE name = 'Maze Map';
UPDATE maps SET tier = 6 WHERE name = 'Residence Map';
UPDATE maps SET tier = 6 WHERE name = 'Bone Crypt Map';
UPDATE maps SET tier = 6 WHERE name = 'Geode Map';
UPDATE maps SET tier = 6 WHERE name = 'Estuary Map';
UPDATE maps SET tier = 6 WHERE name = 'Vault Map';
UPDATE maps SET tier = 6 WHERE name = 'Overgrown Shrine Map';
UPDATE maps SET tier = 6 WHERE name = 'Racecourse Map';
UPDATE maps SET tier = 6 WHERE name = 'Ghetto Map';
UPDATE maps SET tier = 6 WHERE name = 'Arsenal Map';
UPDATE maps SET tier = 7 WHERE name = 'Port Map';
UPDATE maps SET tier = 7 WHERE name = 'Chateau Map';
UPDATE maps SET tier = 7 WHERE name = 'Conservatory Map';
UPDATE maps SET tier = 7 WHERE name = 'Ancient City Map';
UPDATE maps SET tier = 7 WHERE name = 'Underground Sea Map';
UPDATE maps SET tier = 7 WHERE name = 'Bazaar Map';
UPDATE maps SET tier = 7 WHERE name = 'Waste Pool Map';
UPDATE maps SET tier = 7 WHERE name = 'Spider Forest Map';
UPDATE maps SET tier = 7 WHERE name = 'Factory Map';
UPDATE maps SET tier = 7 WHERE name = 'Villa Map';
UPDATE maps SET tier = 7 WHERE name = 'Necropolis Map';
UPDATE maps SET tier = 8 WHERE name = 'Graveyard Map';
UPDATE maps SET tier = 8 WHERE name = 'Cells Map';
UPDATE maps SET tier = 8 WHERE name = 'Volcano Map';
UPDATE maps SET tier = 8 WHERE name = 'Phantasmagoria Map';
UPDATE maps SET tier = 8 WHERE name = 'Atoll Map';
UPDATE maps SET tier = 8 WHERE name = 'Underground River Map';
UPDATE maps SET tier = 8 WHERE name = 'Arachnid Nest Map';
UPDATE maps SET tier = 8 WHERE name = 'Shore Map';
UPDATE maps SET tier = 8 WHERE name = 'Sepulchre Map';
UPDATE maps SET tier = 8 WHERE name = 'Temple Map';
UPDATE maps SET tier = 8 WHERE name = 'Pit Map';
UPDATE maps SET tier = 9 WHERE name = 'Dungeon Map';
UPDATE maps SET tier = 9 WHERE name = 'Coral Ruins Map';
UPDATE maps SET tier = 9 WHERE name = 'Laboratory Map';
UPDATE maps SET tier = 9 WHERE name = 'Courtyard Map';
UPDATE maps SET tier = 9 WHERE name = 'Mud Geyser Map';
UPDATE maps SET tier = 9 WHERE name = 'Mineral Pools Map';
UPDATE maps SET tier = 9 WHERE name = 'Arena Map';
UPDATE maps SET tier = 9 WHERE name = 'Scriptorium Map';
UPDATE maps SET tier = 9 WHERE name = 'Promenade Map';
UPDATE maps SET tier = 9 WHERE name = 'Waterways Map';
UPDATE maps SET tier = 9 WHERE name = 'Castle Ruins Map';
UPDATE maps SET tier = 10 WHERE name = 'Iceberg Map';
UPDATE maps SET tier = 10 WHERE name = 'Toxic Sewer Map';
UPDATE maps SET tier = 10 WHERE name = 'Academy Map';
UPDATE maps SET tier = 10 WHERE name = 'Lava Chamber Map';
UPDATE maps SET tier = 10 WHERE name = 'Dunes Map';
UPDATE maps SET tier = 10 WHERE name = 'Overgrown Ruin Map';
UPDATE maps SET tier = 10 WHERE name = 'Moon Temple Map';
UPDATE maps SET tier = 10 WHERE name = 'Plateau Map';
UPDATE maps SET tier = 10 WHERE name = 'Bog Map';
UPDATE maps SET tier = 10 WHERE name = 'Primordial Pool Map';
UPDATE maps SET tier = 11 WHERE name = 'Gardens Map';
UPDATE maps SET tier = 11 WHERE name = 'Vaal Pyramid Map';
UPDATE maps SET tier = 11 WHERE name = 'Tower Map';
UPDATE maps SET tier = 11 WHERE name = 'Lair Map';
UPDATE maps SET tier = 11 WHERE name = 'Caldera Map';
UPDATE maps SET tier = 11 WHERE name = 'Park Map';
UPDATE maps SET tier = 11 WHERE name = 'Shrine Map';
UPDATE maps SET tier = 11 WHERE name = 'Palace Map';
UPDATE maps SET tier = 11 WHERE name = 'Sunken City Map';
UPDATE maps SET tier = 11 WHERE name = 'Reef Map';
UPDATE maps SET tier = 12 WHERE name = 'Courthouse Map';
UPDATE maps SET tier = 12 WHERE name = 'Cemetery Map';
UPDATE maps SET tier = 12 WHERE name = 'Shipyard Map';
UPDATE maps SET tier = 12 WHERE name = 'Belfry Map';
UPDATE maps SET tier = 12 WHERE name = 'Crystal Ore Map';
UPDATE maps SET tier = 12 WHERE name = 'Malformation Map';
UPDATE maps SET tier = 12 WHERE name = 'Desert Spring Map';
UPDATE maps SET tier = 12 WHERE name = 'Plaza Map';
UPDATE maps SET tier = 12 WHERE name = 'Dig Map';
UPDATE maps SET tier = 13 WHERE name = 'Infested Valley Map';
UPDATE maps SET tier = 13 WHERE name = 'Museum Map';
UPDATE maps SET tier = 13 WHERE name = 'Wasteland Map';
UPDATE maps SET tier = 13 WHERE name = 'Precinct Map';
UPDATE maps SET tier = 13 WHERE name = 'Orchard Map';
UPDATE maps SET tier = 13 WHERE name = 'Acid Caverns Map';
UPDATE maps SET tier = 13 WHERE name = 'Crimson Temple Map';
UPDATE maps SET tier = 13 WHERE name = 'Basilica Map';
UPDATE maps SET tier = 13 WHERE name = 'Carcass Map';
UPDATE maps SET tier = 14 WHERE name = 'Defiled Cathedral Map';
UPDATE maps SET tier = 14 WHERE name = 'Summit Map';
UPDATE maps SET tier = 14 WHERE name = 'Primordial Blocks Map';
UPDATE maps SET tier = 14 WHERE name = 'Terrace Map';
UPDATE maps SET tier = 14 WHERE name = 'Core Map';
UPDATE maps SET tier = 14 WHERE name = 'Colosseum Map';
UPDATE maps SET tier = 14 WHERE name = 'Lava Lake Map';
UPDATE maps SET tier = 15 WHERE name = 'Canyon Map';
UPDATE maps SET tier = 15 WHERE name = 'Siege Map';
UPDATE maps SET tier = 15 WHERE name = 'Colonnade Map';
UPDATE maps SET tier = 15 WHERE name = 'Coves Map';
UPDATE maps SET tier = 15 WHERE name = 'Dark Forest Map';
UPDATE maps SET tier = 16 WHERE name = 'Pit of the Chimera Map';
UPDATE maps SET tier = 16 WHERE name = 'Lair of the Hydra Map';
UPDATE maps SET tier = 16 WHERE name = 'Maze of the Minotaur Map';
UPDATE maps SET tier = 16 WHERE name = 'Forge of the Phoenix Map';
UPDATE maps SET tier = 16 WHERE name = 'Vaal Temple Map';