CREATE TABLE building
(
bid varchar2(5) primary key,
bname varchar2(30),
bpoints number,
bcoord MDSYS.SDO_GEOMETRY	
);

CREATE TABLE people
(
	pid varchar2(5) primary key,
pcoord MDSYS.SDO_GEOMETRY
);

CREATE TABLE accesspoint
(
apid varchar2(10) primary key,
apcoord MDSYS.SDO_GEOMETRY,
apradius number,
apcoord2 MDSYS.SDO_GEOMETRY
);

INSERT INTO USER_SDO_GEOM_METADATA VALUES('building','bcoord',
SDO_DIM_ARRAY(SDO_DIM_ELEMENT('X',0,820,0.005),SDO_DIM_ELEMENT('Y',0,580,0.005)),NULL);

INSERT INTO USER_SDO_GEOM_METADATA VALUES('people','pcoord',
	SDO_DIM_ARRAY(SDO_DIM_ELEMENT('X',0,820,0.005),SDO_DIM_ELEMENT('Y',0,580,0.005)),NULL);

INSERT INTO USER_SDO_GEOM_METADATA VALUES('accesspoint','apcoord2',
SDO_DIM_ARRAY(SDO_DIM_ELEMENT('X',0,820,0.005),SDO_DIM_ELEMENT('Y',0,580,0.005)),NULL);

INSERT INTO USER_SDO_GEOM_METADATA VALUES('accesspoint','apcoord',
	SDO_DIM_ARRAY(SDO_DIM_ELEMENT('X',0,820,0.005),SDO_DIM_ELEMENT('Y',0,580,0.005)),NULL);

CREATE index buildingindex on building(bcoord) indextype is MDSYS.SPATIAL_INDEX;

CREATE index peopleindex on people(pcoord) indextype is MDSYS.SPATIAL_INDEX;

CREATE index apindex on accesspoint(apcoord2) indextype is MDSYS.SPATIAL_INDEX;

CREATE index apindex2 on accesspoint(apcoord) indextype is MDSYS.SPATIAL_INDEX;

COMMIT;