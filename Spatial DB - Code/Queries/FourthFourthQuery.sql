select * from
(
select Student_ID, count(Reverse_Nearest_Neighbour) as Reverse_Nearest_Neighbour1
from
(select s.StudentID as Student_ID, b.BuildingID as Reverse_Nearest_Neighbour
from Student s, Building b
where SDO_NN(s.StudentShape, b.BuildingShape, 'sdo_num_res = 1') = 'TRUE')
group by Student_ID
order by  Reverse_Nearest_Neighbour1 desc)
where rownum <= 5;

