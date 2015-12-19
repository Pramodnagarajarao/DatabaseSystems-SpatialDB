
select distinct b.BuildingID AS BuildingID_Value From Building b where SDO_RELATE(b.BuildingShape, (select t.TramStopShape as TramShape from TramStop t where TramStopID = 't2ohe'), 'mask = inside+coveredby+OVERLAPBDYINTERSECT') = 'TRUE'
UNION
select distinct b.BuildingID AS BuildingID_Value From Building b where SDO_RELATE(b.BuildingShape, (select t.TramStopShape as TramShape from TramStop t where TramStopID = 't6ssl'), 'mask = inside+coveredby+OVERLAPBDYINTERSECT') = 'TRUE' 

union

select distinct s.StudentID AS Studend_ID_Value FROM Student s where SDO_RELATE(s.StudentShape,(select t.TramStopShape as TramShape from TramStop t where TramStopID = 't2ohe'), 'mask = inside+coveredby') = 'TRUE'
UNION 
select distinct s.StudentID AS Studend_ID_Value FROM Student s where SDO_RELATE(s.StudentShape,(select t.TramStopShape as TramShape from TramStop t where TramStopID = 't6ssl'), 'mask = inside+coveredby') = 'TRUE' 


;






