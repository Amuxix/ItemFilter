UPDATE bases
  SET name = REGEXP_REPLACE(name, '(\w+''\w)(\w+)', '\1 \2')
  WHERE name SIMILAR TO '(\w+''\w)(\w+)'