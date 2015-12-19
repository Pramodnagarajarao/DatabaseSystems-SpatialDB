SELECT 
b.BuildingID
FROM Building b
WHERE sdo_inside (b.BuildingShape,  SDO_geometry(2003,NULL,NULL,
 SDO_elem_info_array(1,1003,3),
 SDO_ordinate_array(100,100, 300,300))) = 'TRUE';