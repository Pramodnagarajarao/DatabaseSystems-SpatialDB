SELECT TramStopID, BuildingID FROM TramStop t, Building b, Student s WHERE s.StudentID = 'p1'
AND SDO_WITHIN_DISTANCE(t.TramStopshape, s.StudentShape, 'distance=300') = 'TRUE' 
AND SDO_WITHIN_DISTANCE(b.BuildingShape, s.StudentShape, 'distance=300') = 'TRUE';
