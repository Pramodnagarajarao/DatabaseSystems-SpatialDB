Name: Pramod Nagarajarao
USC ID: 4180319300



Link: http://sqlfiddle.com/#!2/91690/10


create table SpatialTable(
pointid VARCHAR(20) PRIMARY KEY,
location Point,
building Polygon
);


SET @g1 = GeomFromText('POINT(1 1)');
SET @g1 = GeomFromText('POINT(1 1)');
SET @g2 = GeomFromText('POLYGON ((0 0,3 0,0 3,0 0))');
SELECT GeometryType(@g2);
SELECT Within(@g1,@g2);
SELECT Contains(@g2,@g1);
SELECT AsText(Envelope(@g2));
SELECT AsText(Centroid(@g2));


