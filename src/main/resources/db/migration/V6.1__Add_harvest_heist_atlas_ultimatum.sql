ALTER TABLE currency
  ADD COLUMN league text NULL DEFAULT NULL,
  ADD CONSTRAINT fk_league FOREIGN KEY (league) REFERENCES leagues(name);

ALTER TABLE currency_fragments
  ADD COLUMN league text NULL DEFAULT NULL,
  ADD CONSTRAINT fk_league FOREIGN KEY (league) REFERENCES leagues(name);

ALTER TABLE map_fragments
  ADD COLUMN league text NULL DEFAULT NULL,
  ADD CONSTRAINT fk_league FOREIGN KEY (league) REFERENCES leagues(name);

ALTER TABLE bases
  ADD COLUMN league text NULL DEFAULT NULL,
  ADD CONSTRAINT fk_league FOREIGN KEY (league) REFERENCES leagues(name);

INSERT INTO leagues (name, is_available)
VALUES
  ('Harvest', TRUE),
  ('Heist', TRUE),
  ('Ritual', TRUE),
  ('Ultimatum', TRUE);

INSERT INTO currency (name, stack_size, currency_type)
VALUES
  ('Indigo Oil', 10, 'Oil'),
  ('Tainted Oil', 10, 'Oil'),
  ('Time-light Scroll', 10, 'Harbinger Scroll'),
  ('Fragmentation Scroll', 10, 'Harbinger Scroll'),
  ('Deregulation Scroll', 10, 'Harbinger Scroll'),
  ('Electroshock Scroll', 10, 'Harbinger Scroll'),
  ('Haemocombustion Scroll', 10, 'Harbinger Scroll'),
  ('Specularity Scroll', 10, 'Harbinger Scroll'),
  --Ritual
  ('Orb of Unmaking', 10, 'Orb'),
  ('Maven''s Orb', 10, 'Orb'),
  ('Veiled Chaos Orb', 10, 'Orb'),
  ('Crescent Splinter', 10, 'Orb'),
  ('Noxious Catalyst', 10, 'Catalyst'),
  ('Accelerating Catalyst', 10, 'Catalyst'),
  ('Unstable Catalyst', 10, 'Catalyst');

ALTER TABLE currency
  ALTER COLUMN stack_size SET DATA TYPE integer;

INSERT INTO currency (name, stack_size, currency_type, league)
VALUES
  ('Facetor''s Lens', 1, 'Orb', 'Harvest'),
  ('Prime Regrading Lens', 20, 'Orb', 'Heist'),
  ('Secondary Regrading Lens', 20, 'Orb', 'Heist'),
  ('Tempering Orb', 20, 'Orb', 'Heist'),
  ('Tailoring Orb', 20, 'Orb', 'Heist'),
  ('Rogue''s Marker', 50000, 'Orb', 'Heist'),
  ('Ritual Vessel', 10, 'Orb', 'Ritual');

INSERT INTO currency_fragments (name, fragment_of, stack_size, league)
VALUES
  ('Ritual Splinter', 'Ritual Vessel', 100, 'Ritual');

INSERT INTO map_fragments (name, fragment_type, league)
VALUES
  ('Blood-filled Vessel', 'Misc', 'Ritual'),
  ('Vaal Reliquary Key', 'Misc', 'Ultimatum'),
  ('Inscribed Ultimatum', 'Misc', 'Ultimatum');

INSERT INTO map_fragments (name, fragment_type)
VALUES
  ('Winged Cartography Scarab', 'Scarab'),
  ('Winged Reliquary Scarab', 'Scarab'),
  ('Winged Bestiary Scarab', 'Scarab'),
  ('Winged Shaper Scarab', 'Scarab'),
  ('Winged Elder Scarab', 'Scarab'),
  ('Winged Sulphite Scarab', 'Scarab'),
  ('Winged Divination Scarab', 'Scarab'),
  ('Winged Torment Scarab', 'Scarab'),
  ('Winged Ambush Scarab', 'Scarab'),
  ('Winged Harbinger Scarab', 'Scarab'),
  ('Winged Perandus Scarab', 'Scarab'),
  ('Winged Breach Scarab', 'Scarab'),
  ('Winged Legion Scarab', 'Scarab'),
  ('Winged Metamorph Scarab', 'Scarab'),
  ('Rusted Blight Scarab', 'Scarab'),
  ('Polished Blight Scarab', 'Scarab'),
  ('Gilded Blight Scarab', 'Scarab'),
  ('Winged Blight Scarab', 'Scarab'),
  ('Rusted Abyss Scarab', 'Scarab'),
  ('Polished Abyss Scarab', 'Scarab'),
  ('Gilded Abyss Scarab', 'Scarab'),
  ('Winged Abyss Scarab', 'Scarab'),
  ('Tribute to the Goddess', 'Misc'),
  ('Dedication to the Goddess', 'Misc'),
  ('Gift to the Goddess', 'Misc'),
  ('The Maven''s Writ', 'Misc'),
  ('Sacred Blossom', 'Misc'),
  ('Chronicle of Atzoatl', 'Misc');

INSERT INTO map_fragment_fragments (name, fragment_of, stack_size, fragment_type)
VALUES
  ('Crescent Splinter', 'The Maven''s Writ', 10, 'Misc');

INSERT INTO divination_cards(name)
VALUES
  --Harvest
  ('The Tumbleweed'),
  ('The Hive of Knowledge'),
  ('Gift of Asenath'),
  ('A Note in the Wind'),
  ('The Greatest Intentions'),
  ('The White Knight'),
  ('Prometheus'' Armoury'),
  ('The Sustenance'),
  ('Peaceful Moments'),
  ('The Awakened'),
  ('A Familiar Call'),
  ('The Long Con'),
  --Heist
  ('The Gulf'),
  ('The Bitter Blossom'),
  ('Triskaidekaphobia'),
  ('Unrequited Love'),
  ('The Cache'),
  ('The Academic'),
  ('Desecrated Virtue'),
  ('Brother''s Stash'),
  ('Unchained'),
  ('The Unexpected Prize'),
  ('Cursed Words'),
  ('The Journalist'),
  --Ritual
  ('Fateful Meeting'),
  ('Acclimatisation'),
  ('Haunting Shadows'),
  ('The Whiteout'),
  ('Society''s Remorse'),
  ('Dying Light'),
  ('The Astromancer'),
  ('Keeper''s Corruption'),
  ('Reckless Ambition'),
  ('Love Through Ice'),
  ('Draped in Dreams'),
  ('The Patient'),
  ('The Long Watch'),
  ('The Bear Woman'),
  ('Brotherhood in Exile'),
  --Ultimatum
  ('Winter''s Embrace'),
  ('Sambodhi''s Wisdom'),
  ('The Enthusiasts'),
  ('Broken Promises'),
  ('Brush, Paint and Palette'),
  ('Deadly Joy'),
  ('The Adventuring Spirit'),
  ('The Eternal War'),
  ('Prejudice'),
  ('The Shortcut'),
  ('The Card Sharp'),
  ('A Modest Request'),
  ('Luminous Trove'),
  ('The Hook');

INSERT INTO watchstones(name)
VALUES
  ('Chromium Haewark Hamlet Watchstone'),
  ('Chromium Tirn''s End Watchstone'),
  ('Chromium Lex Proxima Watchstone'),
  ('Chromium Lex Ejoris Watchstone'),
  ('Chromium New Vastir Watchstone'),
  ('Chromium Glennach Cairns Watchstone'),
  ('Chromium Valdo''s Rest Watchstone'),
  ('Chromium Lira Arthain Watchstone'),
  ('Platinum Haewark Hamlet Watchstone'),
  ('Platinum Tirn''s End Watchstone'),
  ('Platinum Lex Proxima Watchstone'),
  ('Platinum Lex Ejoris Watchstone'),
  ('Platinum New Vastir Watchstone'),
  ('Platinum Glennach Cairns Watchstone'),
  ('Platinum Valdo''s Rest Watchstone'),
  ('Platinum Lira Arthain Watchstone'),
  ('Titanium Haewark Hamlet Watchstone'),
  ('Titanium Tirn''s End Watchstone'),
  ('Titanium Lex Proxima Watchstone'),
  ('Titanium Lex Ejoris Watchstone'),
  ('Titanium New Vastir Watchstone'),
  ('Titanium Glennach Cairns Watchstone'),
  ('Titanium Valdo''s Rest Watchstone'),
  ('Titanium Lira Arthain Watchstone');

INSERT INTO bases (name, height, width, item_type, drop_level)
VALUES
  ('Grasping Mail', 3, 2, 'Body Armour', 1),
  ('Seaglass Amulet', 1, 1, 'Amulet', 1),
  ('Blessed Boots', 2, 2, 'Boots', 1),
  ('Apothecary''s Gloves', 2, 2, 'Gloves', 1),
  ('Artillery Quiver', 3, 2, 'Quiver', 1),
  ('Iolite Ring', 1, 1, 'Ring', 1);

INSERT INTO bases (name, height, width, item_type, drop_level, league)
VALUES
  ('Assembler Wand', 3, 1, 'Wand', 30, 'Heist'),
  ('Congregator Wand', 3, 1, 'Wand', 50, 'Heist'),
  ('Accumulator Wand', 3, 1, 'Wand', 70, 'Heist'),
  ('Hollowpoint Dagger', 3, 1, 'Dagger', 30, 'Heist'),
  ('Pressurised Dagger', 3, 1, 'Dagger', 50, 'Heist'),
  ('Pneumatic Dagger', 3, 1, 'Dagger', 70, 'Heist'),
  ('Flickerflame Blade', 3, 1, 'Rune Daggers', 30, 'Heist'),
  ('Flashfire Blade', 3, 1, 'Rune Daggers', 50, 'Heist'),
  ('Infernal Blade', 3, 1, 'Rune Daggers', 70, 'Heist'),
  ('Shadow Fangs', 3, 2, 'Claw', 30, 'Heist'),
  ('Malign Fangs', 3, 2, 'Claw', 50, 'Heist'),
  ('Void Fangs', 3, 2, 'Claw', 70, 'Heist'),
  ('Maltreatment Axe', 3, 1, 'One Hand Axe', 30, 'Heist'),
  ('Disapprobation Axe', 3, 1, 'One Hand Axe', 50, 'Heist'),
  ('Psychotic Axe', 3, 1, 'One Hand Axe', 70, 'Heist'),
  ('Fickle Spiritblade', 3, 1, 'One Hand Sword', 30, 'Heist'),
  ('Capricious Spiritblade', 3, 1, 'One Hand Sword', 50, 'Heist'),
  ('Anarchic Spiritblade', 3, 1, 'One Hand Sword', 70, 'Heist'),
  ('Flare Mace', 3, 1, 'One Hand Mace', 30, 'Heist'),
  ('Crack Mace', 3, 1, 'One Hand Mace', 50, 'Heist'),
  ('Boom Mace', 3, 1, 'One Hand Mace', 70, 'Heist'),
  ('Oscillating Sceptre', 3, 2, 'Sceptre', 30, 'Heist'),
  ('Stabilising Sceptre', 3, 2, 'Sceptre', 50, 'Heist'),
  ('Alternating Sceptre', 3, 2, 'Sceptre', 70, 'Heist'),
  ('Hedron Bow', 3, 2, 'Bow', 30, 'Heist'),
  ('Foundry Bow', 3, 2, 'Bow', 50, 'Heist'),
  ('Solarine Bow', 3, 2, 'Bow', 70, 'Heist'),
  ('Transformer Staff', 4, 2, 'Staff', 30, 'Heist'),
  ('Reciprocation Staff', 4, 2, 'Staff', 50, 'Heist'),
  ('Battery Staff', 4, 2, 'Staff', 70, 'Heist'),
  ('Capacity Rod', 4, 2, 'Warstaves', 30, 'Heist'),
  ('Potentiality Rod', 4, 2, 'Warstaves', 50, 'Heist'),
  ('Eventuality Rod', 4, 2, 'Warstaves', 70, 'Heist'),
  ('Prime Cleaver', 4, 2, 'Two Hand Axe', 30, 'Heist'),
  ('Honed Cleaver', 4, 2, 'Two Hand Axe', 50, 'Heist'),
  ('Apex Cleaver', 4, 2, 'Two Hand Axe', 70, 'Heist'),
  ('Rebuking Blade', 4, 2, 'Two Hand Sword', 30, 'Heist'),
  ('Blasting Blade', 4, 2, 'Two Hand Sword', 50, 'Heist'),
  ('Banishing Blade', 4, 2, 'Two Hand Sword', 70, 'Heist'),
  ('Blunt Force Condenser', 4, 2, 'Two Hand Mace', 30, 'Heist'),
  ('Crushing Force Magnifier', 4, 2, 'Two Hand Mace', 50, 'Heist'),
  ('Impact Force Propagator', 4, 2, 'Two Hand Mace', 70, 'Heist'),
  ('Exhausting Spirit Shield', 2, 2, 'Small Shield', 30, 'Heist'),
  ('Subsuming Spirit Shield', 2, 2, 'Small Shield', 50, 'Heist'),
  ('Transfer-attuned Spirit Shield', 2, 2, 'Small Shield', 70, 'Heist'),
  ('Endothermic Buckler', 3, 2, 'Medium Shield', 30, 'Heist'),
  ('Polar Buckler', 3, 2, 'Medium Shield', 50, 'Heist'),
  ('Cold-attuned Buckler', 3, 2, 'Medium Shield', 70, 'Heist'),
  ('Exothermic Tower Shield', 4, 2, 'Large Shield', 30, 'Heist'),
  ('Magmatic Tower Shield', 4, 2, 'Large Shield', 50, 'Heist'),
  ('Heat-attuned Tower Shield', 4, 2, 'Large Shield', 70, 'Heist'),
  ('Micro-Distillery Belt', 1, 2, 'Belt', 30, 'Heist'),
  ('Mechalarm Belt', 1, 2, 'Belt', 50, 'Heist'),
  ('Astrolabe Amulet', 1, 1, 'Amulet', 70, 'Heist'),
  ('Simplex Amulet', 1, 1, 'Amulet', 30, 'Heist'),
  ('Cogwork Ring', 1, 1, 'Ring', 50, 'Heist'),
  ('Geodesic Ring', 1, 1, 'Ring', 70, 'Heist'),
  ('Dreamquest Slippers', 2, 2, 'Boots', 30, 'Ritual'),
  ('Cloudwhisper Boots', 2, 2, 'Boots', 50, 'Ritual'),
  ('Brimstone Treads', 2, 2, 'Boots', 70, 'Ritual'),
  ('Nightwind Slippers', 2, 2, 'Boots', 30, 'Ritual'),
  ('Windbreak Boots', 2, 2, 'Boots', 50, 'Ritual'),
  ('Darksteel Treads', 2, 2, 'Boots', 70, 'Ritual'),
  ('Duskwalk Slippers', 2, 2, 'Boots', 30, 'Ritual'),
  ('Stormrider Boots', 2, 2, 'Boots', 50, 'Ritual'),
  ('Basemetal Treads', 2, 2, 'Boots', 70, 'Ritual'),
  ('Debilitation Gauntlets', 2, 2, 'Gloves', 30, 'Ritual'),
  ('Gruelling Gauntlets', 2, 2, 'Gloves', 50, 'Ritual'),
  ('Taxing Gauntlets', 2, 2, 'Gloves', 70, 'Ritual'),
  ('Sinistral Gloves', 2, 2, 'Gloves', 30, 'Ritual'),
  ('Southswing Gloves', 2, 2, 'Gloves', 50, 'Ritual'),
  ('Gauche Gloves', 2, 2, 'Gloves', 70, 'Ritual'),
  ('Nexus Gloves', 2, 2, 'Gloves', 30, 'Ritual'),
  ('Aetherwind Gloves', 2, 2, 'Gloves', 50, 'Ritual'),
  ('Leyline Gloves', 2, 2, 'Gloves', 70, 'Ritual'),
  ('Blizzard Crown', 2, 2, 'Helmet', 30, 'Ritual'),
  ('Winter Crown', 2, 2, 'Helmet', 50, 'Ritual'),
  ('Gale Crown', 2, 2, 'Helmet', 70, 'Ritual'),
  ('Archdemon Crown', 2, 2, 'Helmet', 30, 'Ritual'),
  ('Demon Crown', 2, 2, 'Helmet', 50, 'Ritual'),
  ('Imp Crown', 2, 2, 'Helmet', 70, 'Ritual'),
  ('Atonement Mask', 2, 2, 'Helmet', 30, 'Ritual'),
  ('Penitent Mask', 2, 2, 'Helmet', 50, 'Ritual'),
  ('Sorrow Mask', 2, 2, 'Helmet', 70, 'Ritual');

INSERT INTO incubators (name)
VALUES
  ('Blighted Incubator'),
  ('Morphing Incubator'),
  ('Maddening Incubator');

ALTER TABLE uniques
  DROP CONSTRAINT uniques_base_fkey;
ALTER TABLE uniques
  ADD CONSTRAINT uniques_base_fkey
    FOREIGN KEY (base)
      REFERENCES bases(name)
      ON DELETE CASCADE
      ON UPDATE CASCADE;

UPDATE bases SET name = 'Samnite Helmet' WHERE name = 'Samite Helmet';
UPDATE bases SET name = 'Pernach' WHERE name = 'Pernarch';

CREATE TYPE equipment_type AS ENUM (
  'Cloak',
  'Brooch',
  'Tool',
  'Gear'
  );

CREATE TYPE job_type AS ENUM (
  'Any',
  'Lockpicking',
  'Brute Force',
  'Engineering',
  'Agility',
  'Counter-Thaumaturgy',
  'Perception',
  'Demolition',
  'Trap Disarmament',
  'Deception'
  );

CREATE TABLE heist_equipment (
  id             serial PRIMARY KEY,
  name           text UNIQUE    NOT NULL,
  job_type       job_type       NOT NULL,
  job_level      smallint       NOT NULL,
  equipment_type equipment_type NOT NULL,
  drop_level     smallint       NOT NULL DEFAULT 1,
  drop_enabled   boolean        NOT NULL DEFAULT TRUE,
  created_at     timestamp      NOT NULL DEFAULT NOW(),
  updated_at     timestamp      NOT NULL DEFAULT NOW()
);

INSERT INTO heist_equipment (name, job_type, job_level, equipment_type, drop_level)
VALUES
  ('Torn Cloak', 'Any', 2, 'Cloak', 1),
  ('Tattered Cloak', 'Any', 3, 'Cloak', 1),
  ('Hooded Cloak', 'Any', 4, 'Cloak', 1),
  ('Whisper-woven Cloak', 'Any', 5, 'Cloak', 1),
  ('Silver Brooch', 'Any', 2, 'Brooch', 1),
  ('Golden Brooch', 'Any', 3, 'Brooch', 1),
  ('Enamel Brooch', 'Any', 4, 'Brooch', 1),
  ('Foliate Brooch', 'Any', 5, 'Brooch', 1),
  ('Simple Lockpick', 'Lockpicking', 2, 'Tool', 1),
  ('Standard Lockpick', 'Lockpicking', 3, 'Tool', 1),
  ('Fine Lockpick', 'Lockpicking', 4, 'Tool', 1),
  ('Master Lockpick', 'Lockpicking', 5, 'Tool', 1),
  ('Leather Bracers', 'Brute Force', 2, 'Tool', 1),
  ('Studded Bracers', 'Brute Force', 3, 'Tool', 1),
  ('Runed Bracers', 'Brute Force', 4, 'Tool', 1),
  ('Steel Bracers', 'Brute Force', 5, 'Tool', 1),
  ('Crude Sensing Charm', 'Perception', 2, 'Tool', 1),
  ('Fine Sensing Charm', 'Perception', 3, 'Tool', 1),
  ('Polished Sensing Charm', 'Perception', 4, 'Tool', 1),
  ('Thaumaturgical Sensing Charm', 'Perception', 5, 'Tool', 1),
  ('Voltaxic Flashpowder', 'Demolition', 2, 'Tool', 1),
  ('Trarthan Flashpowder', 'Demolition', 3, 'Tool', 1),
  ('Azurite Flashpowder', 'Demolition', 4, 'Tool', 1),
  ('Thaumetic Flashpowder', 'Demolition', 5, 'Tool', 1),
  ('Crude Ward', 'Any', 2, 'Tool', 1),
  ('Lustrous Ward', 'Any', 3, 'Tool', 1),
  ('Shining Ward', 'Any', 4, 'Tool', 1),
  ('Thaumaturgical Ward', 'Any', 5, 'Tool', 1),
  ('Essential Keyring', 'Any', 2, 'Tool', 1),
  ('Versatile Keyring', 'Any', 3, 'Tool', 1),
  ('Skeleton Keyring', 'Any', 4, 'Tool', 1),
  ('Grandmaster Keyring', 'Any', 5, 'Tool', 1),
  ('Eelskin Sole', 'Any', 2, 'Tool', 1),
  ('Foxhide Sole', 'Any', 3, 'Tool', 1),
  ('Winged Sole', 'Any', 4, 'Tool', 1),
  ('Silkweave Sole', 'Any', 5, 'Tool', 1),
  ('Basic Disguise Kit', 'Any', 2, 'Tool', 1),
  ('Theatre Disguise Kit', 'Any', 3, 'Tool', 1),
  ('Espionage Disguise Kit', 'Any', 4, 'Tool', 1),
  ('Regicide Disguise Kit', 'Any', 5, 'Tool', 1),
  ('Steel Drill', 'Any', 2, 'Tool', 1),
  ('Flanged Drill', 'Any', 3, 'Tool', 1),
  ('Sulphur Blowtorch', 'Any', 4, 'Tool', 1),
  ('Thaumetic Blowtorch', 'Any', 5, 'Tool', 1),
  ('Rough Sharpening Stone', 'Any', 2, 'Gear', 1),
  ('Standard Sharpening Stone', 'Any', 3, 'Gear', 1),
  ('Fine Sharpening Stone', 'Any', 4, 'Gear', 1),
  ('Obsidian Sharpening Stone', 'Any', 5, 'Gear', 1),
  ('Flanged Arrowhead', 'Any', 2, 'Gear', 1),
  ('Fragmenting Arrowhead', 'Any', 3, 'Gear', 1),
  ('Hollowpoint Arrowhead', 'Any', 4, 'Gear', 1),
  ('Precise Arrowhead', 'Any', 5, 'Gear', 1),
  ('Focal Stone', 'Any', 2, 'Gear', 1),
  ('Conduit Line', 'Any', 3, 'Gear', 1),
  ('Aggregator Charm', 'Any', 4, 'Gear', 1),
  ('Burst Band', 'Any', 5, 'Gear', 1);

UPDATE maps SET tier = 1 WHERE name = 'Pen Map';
UPDATE maps SET tier = 1 WHERE name = 'Arcade Map';
UPDATE maps SET tier = 1 WHERE name = 'Jungle Valley Map';
UPDATE maps SET tier = 1 WHERE name = 'Coves Map';
UPDATE maps SET tier = 2 WHERE name = 'Peninsula Map';
UPDATE maps SET tier = 2 WHERE name = 'Grotto Map';
UPDATE maps SET tier = 2 WHERE name = 'Volcano Map';
UPDATE maps SET tier = 2 WHERE name = 'Frozen Cabins Map';
UPDATE maps SET tier = 2 WHERE name = 'Fields Map';
UPDATE maps SET tier = 2 WHERE name = 'Wharf Map';
UPDATE maps SET tier = 2 WHERE name = 'Underground Sea Map';
UPDATE maps SET tier = 2 WHERE name = 'Crater Map';
UPDATE maps SET tier = 2 WHERE name = 'Underground River Map';
UPDATE maps SET tier = 2 WHERE name = 'Gardens Map';
UPDATE maps SET tier = 2 WHERE name = 'Infested Valley Map';
UPDATE maps SET tier = 2 WHERE name = 'Tropical Island Map';
UPDATE maps SET tier = 2 WHERE name = 'Moon Temple Map';
UPDATE maps SET tier = 2 WHERE name = 'Tower Map';
UPDATE maps SET tier = 2 WHERE name = 'Arena Map';
UPDATE maps SET tier = 2 WHERE name = 'Promenade Map';
UPDATE maps SET tier = 2 WHERE name = 'Lair Map';
UPDATE maps SET tier = 2 WHERE name = 'Spider Forest Map';
UPDATE maps SET tier = 2 WHERE name = 'Defiled Cathedral Map';
UPDATE maps SET tier = 2 WHERE name = 'Sunken City Map';
UPDATE maps SET tier = 3 WHERE name = 'Graveyard Map';
UPDATE maps SET tier = 3 WHERE name = 'Arid Lake Map';
UPDATE maps SET tier = 3 WHERE name = 'Strand Map';
UPDATE maps SET tier = 3 WHERE name = 'Glacier Map';
UPDATE maps SET tier = 3 WHERE name = 'Canyon Map';
UPDATE maps SET tier = 3 WHERE name = 'Forking River Map';
UPDATE maps SET tier = 3 WHERE name = 'Sulphur Vents Map';
UPDATE maps SET tier = 3 WHERE name = 'Toxic Sewer Map';
UPDATE maps SET tier = 3 WHERE name = 'Ancient City Map';
UPDATE maps SET tier = 3 WHERE name = 'Ashen Wood Map';
UPDATE maps SET tier = 3 WHERE name = 'Cemetery Map';
UPDATE maps SET tier = 3 WHERE name = 'Lava Chamber Map';
UPDATE maps SET tier = 3 WHERE name = 'Laboratory Map';
UPDATE maps SET tier = 3 WHERE name = 'Overgrown Ruin Map';
UPDATE maps SET tier = 3 WHERE name = 'Vaal Pyramid Map';
UPDATE maps SET tier = 3 WHERE name = 'Geode Map';
UPDATE maps SET tier = 3 WHERE name = 'Courtyard Map';
UPDATE maps SET tier = 3 WHERE name = 'Mud Geyser Map';
UPDATE maps SET tier = 3 WHERE name = 'Shore Map';
UPDATE maps SET tier = 3 WHERE name = 'Temple Map';
UPDATE maps SET tier = 3 WHERE name = 'Belfry Map';
UPDATE maps SET tier = 3 WHERE name = 'Pier Map';
UPDATE maps SET tier = 3 WHERE name = 'Orchard Map';
UPDATE maps SET tier = 3 WHERE name = 'Factory Map';
UPDATE maps SET tier = 3 WHERE name = 'Primordial Blocks Map';
UPDATE maps SET tier = 3 WHERE name = 'Plaza Map';
UPDATE maps SET tier = 3 WHERE name = 'Basilica Map';
UPDATE maps SET tier = 3 WHERE name = 'Reef Map';
UPDATE maps SET tier = 4 WHERE name = 'Lookout Map';
UPDATE maps SET tier = 4 WHERE name = 'Desert Map';
UPDATE maps SET tier = 4 WHERE name = 'Marshes Map';
UPDATE maps SET tier = 4 WHERE name = 'Iceberg Map';
UPDATE maps SET tier = 4 WHERE name = 'Cage Map';
UPDATE maps SET tier = 4 WHERE name = 'Leyline Map';
UPDATE maps SET tier = 4 WHERE name = 'Courthouse Map';
UPDATE maps SET tier = 4 WHERE name = 'Channel Map';
UPDATE maps SET tier = 4 WHERE name = 'Academy Map';
UPDATE maps SET tier = 4 WHERE name = 'Ramparts Map';
UPDATE maps SET tier = 4 WHERE name = 'Dunes Map';
UPDATE maps SET tier = 4 WHERE name = 'Bone Crypt Map';
UPDATE maps SET tier = 4 WHERE name = 'Museum Map';
UPDATE maps SET tier = 4 WHERE name = 'Wasteland Map';
UPDATE maps SET tier = 4 WHERE name = 'Precinct Map';
UPDATE maps SET tier = 4 WHERE name = 'Primordial Pool Map';
UPDATE maps SET tier = 4 WHERE name = 'Crystal Ore Map';
UPDATE maps SET tier = 4 WHERE name = 'Arsenal Map';
UPDATE maps SET tier = 4 WHERE name = 'Crimson Temple Map';
UPDATE maps SET tier = 5 WHERE name = 'Cells Map';
UPDATE maps SET tier = 5 WHERE name = 'Chateau Map';
UPDATE maps SET tier = 5 WHERE name = 'Lighthouse Map';
UPDATE maps SET tier = 5 WHERE name = 'Haunted Mansion Map';
UPDATE maps SET tier = 5 WHERE name = 'Atoll Map';
UPDATE maps SET tier = 5 WHERE name = 'Armoury Map';
UPDATE maps SET tier = 5 WHERE name = 'Waste Pool Map';
UPDATE maps SET tier = 5 WHERE name = 'Shrine Map';
UPDATE maps SET tier = 5 WHERE name = 'Desert Spring Map';
UPDATE maps SET tier = 5 WHERE name = 'Palace Map';
UPDATE maps SET tier = 5 WHERE name = 'Carcass Map';
UPDATE maps SET tier = 6 WHERE name = 'Malformation Map';
UPDATE maps SET tier = 6 WHERE name = 'Silo Map';
UPDATE maps SET tier = 7 WHERE name = 'Waterways Map';
UPDATE maps SET tier = 7 WHERE name = 'Dark Forest Map';
UPDATE maps SET tier = 8 WHERE name = 'Alleyways Map';
UPDATE maps SET tier = 8 WHERE name = 'Dry Sea Map';
UPDATE maps SET tier = 8 WHERE name = 'Racecourse Map';
UPDATE maps SET tier = 9 WHERE name = 'Dungeon Map';
UPDATE maps SET tier = 9 WHERE name = 'Relic Chambers Map';
UPDATE maps SET tier = 9 WHERE name = 'Spider Lair Map';
UPDATE maps SET tier = 9 WHERE name = 'Mausoleum Map';
UPDATE maps SET tier = 9 WHERE name = 'Mineral Pools Map';
UPDATE maps SET tier = 9 WHERE name = 'Overgrown Shrine Map';
UPDATE maps SET tier = 9 WHERE name = 'Stagnation Map';
UPDATE maps SET tier = 10 WHERE name = 'Forbidden Woods Map';
UPDATE maps SET tier = 10 WHERE name = 'Phantasmagoria Map';
UPDATE maps SET tier = 10 WHERE name = 'Scriptorium Map';
UPDATE maps SET tier = 10 WHERE name = 'Ghetto Map';
UPDATE maps SET tier = 11 WHERE name = 'Flooded Mine Map';
UPDATE maps SET tier = 11 WHERE name = 'Fungal Hollow Map';
UPDATE maps SET tier = 11 WHERE name = 'Port Map';
UPDATE maps SET tier = 11 WHERE name = 'Grave Trough Map';
UPDATE maps SET tier = 11 WHERE name = 'Cold River Map';
UPDATE maps SET tier = 11 WHERE name = 'Conservatory Map';
UPDATE maps SET tier = 11 WHERE name = 'Ivory Temple Map';
UPDATE maps SET tier = 12 WHERE name = 'Crimson Township Map';
UPDATE maps SET tier = 12 WHERE name = 'Coral Ruins Map';
UPDATE maps SET tier = 12 WHERE name = 'Siege Map';
UPDATE maps SET tier = 12 WHERE name = 'Shipyard Map';
UPDATE maps SET tier = 12 WHERE name = 'Dig Map';
UPDATE maps SET tier = 13 WHERE name = 'Maze Map';
UPDATE maps SET tier = 13 WHERE name = 'Plateau Map';
UPDATE maps SET tier = 13 WHERE name = 'Cursed Crypt Map';
UPDATE maps SET tier = 13 WHERE name = 'Park Map';
UPDATE maps SET tier = 14 WHERE name = 'Beach Map';
UPDATE maps SET tier = 14 WHERE name = 'Excavation Map';
UPDATE maps SET tier = 14 WHERE name = 'City Square Map';
UPDATE maps SET tier = 14 WHERE name = 'Barrows Map';
UPDATE maps SET tier = 14 WHERE name = 'Thicket Map';
UPDATE maps SET tier = 14 WHERE name = 'Residence Map';
UPDATE maps SET tier = 14 WHERE name = 'Sepulchre Map';
UPDATE maps SET tier = 14 WHERE name = 'Mesa Map';
UPDATE maps SET tier = 14 WHERE name = 'Caldera Map';
UPDATE maps SET tier = 14 WHERE name = 'Core Map';
UPDATE maps SET tier = 14 WHERE name = 'Colosseum Map';
UPDATE maps SET tier = 14 WHERE name = 'Acid Caverns Map';
UPDATE maps SET tier = 14 WHERE name = 'Bramble Valley Map';
UPDATE maps SET tier = 15 WHERE name = 'Foundry Map';
UPDATE maps SET tier = 15 WHERE name = 'Bazaar Map';
UPDATE maps SET tier = 15 WHERE name = 'Estuary Map';
UPDATE maps SET tier = 15 WHERE name = 'Vault Map';
UPDATE maps SET tier = 15 WHERE name = 'Arachnid Tomb Map';
UPDATE maps SET tier = 15 WHERE name = 'Bog Map';
UPDATE maps SET tier = 15 WHERE name = 'Colonnade Map';
UPDATE maps SET tier = 15 WHERE name = 'Summit Map';
UPDATE maps SET tier = 15 WHERE name = 'Castle Ruins Map';
UPDATE maps SET tier = 15 WHERE name = 'Villa Map';
UPDATE maps SET tier = 15 WHERE name = 'Terrace Map';
UPDATE maps SET tier = 15 WHERE name = 'Lava Lake Map';
UPDATE maps SET tier = 16 WHERE name = 'Burial Chambers Map';
UPDATE maps SET tier = 16 WHERE name = 'Arachnid Nest Map';
UPDATE maps SET tier = 16 WHERE name = 'Pit Map';
UPDATE maps SET tier = 16 WHERE name = 'Necropolis Map';
UPDATE maps SET tier = 16 WHERE name = 'Pit of the Chimera Map';
UPDATE maps SET tier = 16 WHERE name = 'Lair of the Hydra Map';
UPDATE maps SET tier = 16 WHERE name = 'Maze of the Minotaur Map';
UPDATE maps SET tier = 16 WHERE name = 'Forge of the Phoenix Map';
UPDATE maps SET tier = 16 WHERE name = 'Vaal Temple Map';