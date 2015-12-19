select Tram_ID from (
select t.TramStopID As Tram_ID, count(b.BuildingID) as count_of_buildings
from TramStop t, Building b 
where SDO_WITHIN_DISTANCE(b.BuildingShape, t.TramStopShape, 'distance=250') = 'TRUE' 
group by t.TramStopID
order by count_of_buildings desc) 
where rownum <=1;


