INSERT INTO map_fragments (name, fragment_type)
VALUES
  ('Simulacrum', 'Simulacrum'),
  ('Rusted Metamorph Scarab', 'Scarab'),
  ('Polished Metamorph Scarab', 'Scarab'),
  ('Gilded Metamorph Scarab', 'Scarab');


INSERT INTO bases (name, height, width, item_type, drop_level)
VALUES
  ('Large Cluster Jewel', 1, 1, 'Cluster Jewel', 1),
  ('Medium Cluster Jewel', 1, 1, 'Cluster Jewel', 1),
  ('Small Cluster Jewel', 1, 1, 'Cluster Jewel', 1);

INSERT INTO currency (name, stack_size, currency_type)
VALUES
  ('Fine Delirium Orb', 10, 'Delirium Orb'),
  ('Singular Delirium Orb', 10, 'Delirium Orb'),
  ('Thaumaturge''s Delirium Orb', 10, 'Delirium Orb'),
  ('Blacksmith''s Delirium Orb', 10, 'Delirium Orb'),
  ('Armoursmith''s Delirium Orb', 10, 'Delirium Orb'),
  ('Cartographer''s Delirium Orb', 10, 'Delirium Orb'),
  ('Jeweller''s Delirium Orb', 10, 'Delirium Orb'),
  ('Abyssal Delirium Orb', 10, 'Delirium Orb'),
  ('Decadent Delirium Orb', 10, 'Delirium Orb'),
  ('Foreboding Delirium Orb', 10, 'Delirium Orb'),
  ('Obscured Delirium Orb', 10, 'Delirium Orb'),
  ('Whispering Delirium Orb', 10, 'Delirium Orb'),
  ('Fragmented Delirium Orb', 10, 'Delirium Orb'),
  ('Skittering Delirium Orb', 10, 'Delirium Orb'),
  ('Fossilised Delirium Orb', 10, 'Delirium Orb'),
  ('Portentous Delirium Orb', 10, 'Delirium Orb'),
  ('Diviner''s Delirium Orb', 10, 'Delirium Orb'),
  ('Delirium Orb', 10, 'Delirium Orb'),
  ('Primal Delirium Orb', 10, 'Delirium Orb'),
  ('Imperial Delirium Orb', 10, 'Delirium Orb'),
  ('Timeless Delirium Orb', 10, 'Delirium Orb'),
  ('Blighted Delirium Orb', 10, 'Delirium Orb'),
  ('Amorphous Delirium Orb', 10, 'Delirium Orb');

INSERT INTO map_fragment_fragments (name, fragment_of, stack_size, fragment_type)
VALUES
  ('Simulacrum Splinter', 'Simulacrum', 100, 'Simulacrum');

INSERT INTO divination_cards(name)
VALUES
  ('The Strategist'),
  ('The Cheater'),
  ('The Tinkerer''s Table'),
  ('The Easy Stroll'),
  ('The Progeny of Lunaris'),
  ('The Eldritch Decay'),
  ('Council of Cats');

UPDATE maps SET tier = 1 WHERE name = 'Wharf Map';
UPDATE maps SET tier = 1 WHERE name = 'Beach Map';
UPDATE maps SET tier = 1 WHERE name = 'Pier Map';
UPDATE maps SET tier = 1 WHERE name = 'Jungle Valley Map';
UPDATE maps SET tier = 2 WHERE name = 'Villa Map';
UPDATE maps SET tier = 2 WHERE name = 'Underground Sea Map';
UPDATE maps SET tier = 2 WHERE name = 'Sulphur Vents Map';
UPDATE maps SET tier = 2 WHERE name = 'Strand Map';
UPDATE maps SET tier = 2 WHERE name = 'Fungal Hollow Map';
UPDATE maps SET tier = 2 WHERE name = 'Ramparts Map';
UPDATE maps SET tier = 2 WHERE name = 'Peninsula Map';
UPDATE maps SET tier = 2 WHERE name = 'Orchard Map';
UPDATE maps SET tier = 2 WHERE name = 'Mausoleum Map';
UPDATE maps SET tier = 2 WHERE name = 'Lookout Map';
UPDATE maps SET tier = 2 WHERE name = 'Laboratory Map';
UPDATE maps SET tier = 2 WHERE name = 'Haunted Mansion Map';
UPDATE maps SET tier = 2 WHERE name = 'Graveyard Map';
UPDATE maps SET tier = 2 WHERE name = 'Glacier Map';
UPDATE maps SET tier = 2 WHERE name = 'Fields Map';
UPDATE maps SET tier = 2 WHERE name = 'Desert Map';
UPDATE maps SET tier = 2 WHERE name = 'Cursed Crypt Map';
UPDATE maps SET tier = 2 WHERE name = 'Ashen Wood Map';
UPDATE maps SET tier = 2 WHERE name = 'Armoury Map';
UPDATE maps SET tier = 2 WHERE name = 'Alleyways Map';
UPDATE maps SET tier = 3 WHERE name = 'Wasteland Map';
UPDATE maps SET tier = 3 WHERE name = 'Waterways Map';
UPDATE maps SET tier = 3 WHERE name = 'Volcano Map';
UPDATE maps SET tier = 3 WHERE name = 'Toxic Sewer Map';
UPDATE maps SET tier = 3 WHERE name = 'Vault Map';
UPDATE maps SET tier = 3 WHERE name = 'Temple Map';
UPDATE maps SET tier = 3 WHERE name = 'Vaal Pyramid Map';
UPDATE maps SET tier = 3 WHERE name = 'Cemetery Map';
UPDATE maps SET tier = 3 WHERE name = 'Cage Map';
UPDATE maps SET tier = 3 WHERE name = 'Bog Map';
UPDATE maps SET tier = 3 WHERE name = 'Belfry Map';
UPDATE maps SET tier = 3 WHERE name = 'Bazaar Map';
UPDATE maps SET tier = 3 WHERE name = 'Arena Map';
UPDATE maps SET tier = 3 WHERE name = 'Arsenal Map';
UPDATE maps SET tier = 3 WHERE name = 'Arcade Map';
UPDATE maps SET tier = 3 WHERE name = 'Ancient City Map';
UPDATE maps SET tier = 3 WHERE name = 'Relic Chambers Map';
UPDATE maps SET tier = 3 WHERE name = 'Primordial Pool Map';
UPDATE maps SET tier = 3 WHERE name = 'Racecourse Map';
UPDATE maps SET tier = 3 WHERE name = 'Dunes Map';
UPDATE maps SET tier = 3 WHERE name = 'Coves Map';
UPDATE maps SET tier = 3 WHERE name = 'Pen Map';
UPDATE maps SET tier = 3 WHERE name = 'Overgrown Ruin Map';
UPDATE maps SET tier = 3 WHERE name = 'Museum Map';
UPDATE maps SET tier = 3 WHERE name = 'Mud Geyser Map';
UPDATE maps SET tier = 3 WHERE name = 'Moon Temple Map';
UPDATE maps SET tier = 3 WHERE name = 'Mesa Map';
UPDATE maps SET tier = 3 WHERE name = 'Leyline Map';
UPDATE maps SET tier = 4 WHERE name = 'Waste Pool Map';
UPDATE maps SET tier = 4 WHERE name = 'Thicket Map';
UPDATE maps SET tier = 4 WHERE name = 'Shore Map';
UPDATE maps SET tier = 4 WHERE name = 'Conservatory Map';
UPDATE maps SET tier = 4 WHERE name = 'Colonnade Map';
UPDATE maps SET tier = 4 WHERE name = 'Bone Crypt Map';
UPDATE maps SET tier = 4 WHERE name = 'Barrows Map';
UPDATE maps SET tier = 4 WHERE name = 'Arachnid Tomb Map';
UPDATE maps SET tier = 4 WHERE name = 'Academy Map';
UPDATE maps SET tier = 4 WHERE name = 'Plaza Map';
UPDATE maps SET tier = 4 WHERE name = 'Pit Map';
UPDATE maps SET tier = 4 WHERE name = 'Phantasmagoria Map';
UPDATE maps SET tier = 4 WHERE name = 'Park Map';
UPDATE maps SET tier = 4 WHERE name = 'Lava Chamber Map';
UPDATE maps SET tier = 4 WHERE name = 'Defiled Cathedral Map';
UPDATE maps SET tier = 4 WHERE name = 'Crystal Ore Map';
UPDATE maps SET tier = 4 WHERE name = 'Courtyard Map';
UPDATE maps SET tier = 4 WHERE name = 'Estuary Map';
UPDATE maps SET tier = 4 WHERE name = 'Geode Map';
UPDATE maps SET tier = 5 WHERE name = 'Tropical Island Map';
UPDATE maps SET tier = 5 WHERE name = 'Tower Map';
UPDATE maps SET tier = 5 WHERE name = 'Scriptorium Map';
UPDATE maps SET tier = 5 WHERE name = 'Reef Map';
UPDATE maps SET tier = 5 WHERE name = 'Marshes Map';
UPDATE maps SET tier = 5 WHERE name = 'Chateau Map';
UPDATE maps SET tier = 5 WHERE name = 'Castle Ruins Map';
UPDATE maps SET tier = 5 WHERE name = 'Canyon Map';
UPDATE maps SET tier = 5 WHERE name = 'Caldera Map';
UPDATE maps SET tier = 5 WHERE name = 'Basilica Map';
UPDATE maps SET tier = 5 WHERE name = 'Atoll Map';
UPDATE maps SET tier = 5 WHERE name = 'Arid Lake Map';
UPDATE maps SET tier = 6 WHERE name = 'Port Map';
UPDATE maps SET tier = 6 WHERE name = 'Excavation Map';
UPDATE maps SET tier = 7 WHERE name = 'Precinct Map';
UPDATE maps SET tier = 7 WHERE name = 'Burial Chambers Map';
UPDATE maps SET tier = 8 WHERE name = 'Siege Map';
UPDATE maps SET tier = 8 WHERE name = 'Lair Map';
UPDATE maps SET tier = 9 WHERE name = 'Iceberg Map';
UPDATE maps SET tier = 9 WHERE name = 'Gardens Map';
UPDATE maps SET tier = 9 WHERE name = 'Flooded Mine Map';
UPDATE maps SET tier = 9 WHERE name = 'Factory Map';
UPDATE maps SET tier = 9 WHERE name = 'Courthouse Map';
UPDATE maps SET tier = 9 WHERE name = 'Maze Map';
UPDATE maps SET tier = 9 WHERE name = 'Shipyard Map';
UPDATE maps SET tier = 10 WHERE name = 'Residence Map';
UPDATE maps SET tier = 10 WHERE name = 'Lighthouse Map';
UPDATE maps SET tier = 10 WHERE name = 'Cells Map';
UPDATE maps SET tier = 11 WHERE name = 'Crater Map';
UPDATE maps SET tier = 11 WHERE name = 'Sepulchre Map';
UPDATE maps SET tier = 11 WHERE name = 'Dungeon Map';
UPDATE maps SET tier = 11 WHERE name = 'Dig Map';
UPDATE maps SET tier = 11 WHERE name = 'Core Map';
UPDATE maps SET tier = 11 WHERE name = 'City Square Map';
UPDATE maps SET tier = 12 WHERE name = 'Primordial Blocks Map';
UPDATE maps SET tier = 12 WHERE name = 'Ghetto Map';
UPDATE maps SET tier = 12 WHERE name = 'Colosseum Map';
UPDATE maps SET tier = 12 WHERE name = 'Arachnid Nest Map';
UPDATE maps SET tier = 13 WHERE name = 'Underground River Map';
UPDATE maps SET tier = 13 WHERE name = 'Plateau Map';
UPDATE maps SET tier = 13 WHERE name = 'Overgrown Shrine Map';
UPDATE maps SET tier = 13 WHERE name = 'Channel Map';
UPDATE maps SET tier = 14 WHERE name = 'Sunken City Map';
UPDATE maps SET tier = 14 WHERE name = 'Spider Lair Map';
UPDATE maps SET tier = 14 WHERE name = 'Spider Forest Map';
UPDATE maps SET tier = 14 WHERE name = 'Shrine Map';
UPDATE maps SET tier = 14 WHERE name = 'Mineral Pools Map';
UPDATE maps SET tier = 14 WHERE name = 'Malformation Map';
UPDATE maps SET tier = 14 WHERE name = 'Ivory Temple Map';
UPDATE maps SET tier = 14 WHERE name = 'Infested Valley Map';
UPDATE maps SET tier = 14 WHERE name = 'Dark Forest Map';
UPDATE maps SET tier = 14 WHERE name = 'Crimson Temple Map';
UPDATE maps SET tier = 15 WHERE name = 'Terrace Map';
UPDATE maps SET tier = 15 WHERE name = 'Acid Caverns Map';
UPDATE maps SET tier = 15 WHERE name = 'Palace Map';
UPDATE maps SET tier = 15 WHERE name = 'Necropolis Map';
UPDATE maps SET tier = 15 WHERE name = 'Lava Lake Map';
UPDATE maps SET tier = 15 WHERE name = 'Grotto Map';
UPDATE maps SET tier = 15 WHERE name = 'Desert Spring Map';
UPDATE maps SET tier = 15 WHERE name = 'Coral Ruins Map';
UPDATE maps SET tier = 16 WHERE name = 'Summit Map';
UPDATE maps SET tier = 16 WHERE name = 'Vaal Temple Map';
UPDATE maps SET tier = 16 WHERE name = 'Promenade Map';
UPDATE maps SET tier = 16 WHERE name = 'Forge of the Phoenix Map';
UPDATE maps SET tier = 16 WHERE name = 'Maze of the Minotaur Map';
UPDATE maps SET tier = 16 WHERE name = 'Lair of the Hydra Map';
UPDATE maps SET tier = 16 WHERE name = 'Pit of the Chimera Map';
UPDATE maps SET tier = 16 WHERE name = 'Carcass Map';