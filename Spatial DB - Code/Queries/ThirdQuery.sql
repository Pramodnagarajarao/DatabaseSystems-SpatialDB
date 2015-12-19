SELECT  b1.BuildingID as Building_ID
FROM Building b1, Building b2
WHERE SDO_NN(b1.BuildingShape, b2.BuildingShape, 'sdo_num_res =6') = 'TRUE'  and  b2.BuildingID = 'b3' and  b1.BuildingID != 'b3';
