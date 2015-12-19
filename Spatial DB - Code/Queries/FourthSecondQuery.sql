SELECT  s.StudentID, t.TramStopID 
   FROM Student  s,  TramStop  t
      WHERE SDO_NN(t.TramStopShape, s.StudentShape, 'sdo_num_res=2')='TRUE';