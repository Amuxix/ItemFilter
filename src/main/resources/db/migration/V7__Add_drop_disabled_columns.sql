ALTER TABLE bases ADD COLUMN drop_enabled BOOLEAN DEFAULT TRUE;
ALTER TABLE uniques ADD COLUMN drop_enabled BOOLEAN DEFAULT TRUE;
ALTER TABLE maps ADD COLUMN drop_enabled BOOLEAN DEFAULT TRUE;
ALTER TABLE unique_maps ADD COLUMN drop_enabled BOOLEAN DEFAULT TRUE;
ALTER TABLE map_fragments ADD COLUMN drop_enabled BOOLEAN DEFAULT TRUE;
ALTER TABLE currency ADD COLUMN drop_enabled BOOLEAN DEFAULT TRUE;
ALTER TABLE currency_fragments ADD COLUMN drop_enabled BOOLEAN DEFAULT TRUE;
ALTER TABLE essences ADD COLUMN drop_enabled BOOLEAN DEFAULT TRUE;
ALTER TABLE divination_cards ADD COLUMN drop_enabled BOOLEAN DEFAULT TRUE;
ALTER TABLE incursion_items ADD COLUMN drop_enabled BOOLEAN DEFAULT TRUE;
ALTER TABLE fossils ADD COLUMN drop_enabled BOOLEAN DEFAULT TRUE;
ALTER TABLE resonators ADD COLUMN drop_enabled BOOLEAN DEFAULT TRUE;

UPDATE divination_cards
SET drop_enabled = false
where name = 'Birth of the Three';

UPDATE map_fragments
SET drop_enabled = false
where name = 'Timeworn Reliquary Key';

UPDATE currency
SET drop_enabled = false
where name = 'Eternal Orb'
   or name = 'Bestiary Orb'
   or name = 'Master Cartographer''s Seal'
   or name = 'Journeyman Cartographer''s Seal'
   or name = 'Apprentice Cartographer''s Seal'
   or name = 'Unshaping Orb';