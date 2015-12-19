DROP INDEX building_spatial_idx ;
DROP INDEX Student_spatial_idx ;
DROP INDEX TramStop_spatial_idx ;

Delete from user_sdo_geom_metadata;
 
drop table Building cascade constraints;
drop table Student cascade constraints;
drop table TramStop cascade constraints; 