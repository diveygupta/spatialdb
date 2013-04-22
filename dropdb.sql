DROP INDEX apindex2;
DROP INDEX apindex;
DROP INDEX buildingindex;
DROP INDEX peopleindex;
DROP TABLE accesspoint;
DROP TABLE people;
DROP TABLE building;
DELETE FROM USER_SDO_GEOM_METADATA;

COMMIT;