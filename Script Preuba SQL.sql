    CREATE TABLE Cajeros (
Cajero INT NOT NULL, 
NomApels NVARCHAR(255) NOT NULL,
PRIMARY KEY (Cajero)
);

CREATE TABLE Productos (
Producto INT NOT NULL, 
Nombre NVARCHAR(100) NOT NULL,
Precio FLOAT(15) NOT NULL,
PRIMARY KEY (Producto)
);

CREATE TABLE Maquinas_Registradoras (
Maquina INT NOT NULL, 
Piso INT NOT NULL,
PRIMARY KEY (Maquina)
);
                
CREATE TABLE Venta (
Cajero INT NOT NULL, 
Maquina INT NOT NULL, 
Producto INT NOT NULL,
foreign key (Cajero) references cajeros(Cajero),
foreign key (Maquina) references maquinas_registradoras(Maquina),
foreign key (Producto) references productos(Producto)
);
    
    insert into productos (Producto, Nombre, Precio)
    values
    (1,"Gorra",675.99),
    (2,"Sudadera",825.85),
    (3,"Playera",250.00),
    (4,"Calcetas",29.99),
    (5,"Guantes",35.85),
    (6,"Tenis",1200.99),
    (7,"Jeans",1500.85),
    (8,"Sombrero",2400.35),
    (9,"Cinturon", 888.88),
    (10,"Botas", 3899.99);
    
    insert into cajeros (Cajero, NomApels)
    values
    (1,"Armando Martinez"),
    (2,"José Altamira"),
    (3,"Hayley Williams"),
    (4,"Alex Turner"),
    (5,"Gerard Way"),
    (6,"Ricardo Salinas");
		
	insert into maquinas_registradoras (Maquina,Piso)
    values
    (1,1),
    (2,1),
    (3,1),
    (4,2),
    (5,2),
    (6,3),
    (7,4);
    
    insert into venta (Cajero, Producto, Maquina)
values
	(1,4,6),
    (1,2,2),
    (1,3,5),
    (1,2,3),
    (1,5,2),
    (1,6,1),
    (1,5,4),
    (1,8,1),
    (1,9,2),
    (1,10,4),
    (2,2,2),
    (2,9,1),
    (2,1,3),
    (2,3,5),
    (2,3,3),
    (2,3,6),
    (2,8,1),
    (2,4,4),
    (2,4,4),
    (2,10,1),
    (2,1,4),
	(3,1,6),
    (3,5,2),
    (3,4,1),
    (3,10,5),
    (3,3,6),
    (3,2,3),
    (3,3,4),
    (3,2,4),
    (3,1,3),
    (3,2,1),
    (4,4,1),
    (4,6,2),
    (4,5,3),
    (4,2,6),
    (4,9,6),
    (4,10,6),
    (4,10,3),
    (4,8,1),
    (4,8,1),
    (4,7,5),
    (4,7,2),
	(5,10,6),
    (5,10,5),
    (5,10,2),
    (5,6,5),
    (5,6,2),
    (5,4,1),
    (5,3,3),
    (5,2,2),
    (5,1,5),
    (5,5,5),
    (5,8,1),
    (5,9,1),
    (6,4,6),
    (6,2,2);
    
   /*Mostrar el número de ventas de cada producto, ordenado de más a menos ventas.*/
    SElECT COUNT(venta.Producto), productos.nombre
    FROM venta
    INNER JOIN productos
    ON venta.Producto = productos.Producto
    GROUP BY venta.Producto
    ORDER BY COUNT(venta.Producto) DESC;
    
	/*Obtener un informe completo de ventas, indicando el nombre del cajero que realizo la venta, nombre y precios de los productos vendidos, y el piso en el que se encuentra la máquina registradora donde se realizó la venta.*/
    SELECT * FROM venta 
    INNER JOIN cajeros
    ON venta.Cajero =  cajeros.Cajero 
    INNER JOIN productos 
    ON venta.Producto = productos.Producto
    INNER JOIN maquinas_registradoras 
    ON venta.Maquina = maquinas_registradoras.Maquina;
    
   /*Obtener las ventas totales realizadas en cada piso.*/
	SElECT venta.Maquina, maquinas_registradoras.piso, Sum(productos.Precio)
    FROM venta
    INNER JOIN productos
    ON venta.Producto = productos.Producto
    INNER JOIN maquinas_registradoras
    On venta.Maquina = maquinas_registradoras.Maquina
    GROUP BY maquinas_registradoras.Piso
    ORDER BY COUNT(maquinas_registradoras.Piso) DESC;
    
   /*Obtener el código y nombre de cada cajero junto con el importe total de sus ventas.*/
    SElECT venta.Cajero, cajeros.NomApels, Sum(productos.Precio)
    FROM venta
    INNER JOIN productos
    ON venta.Producto = productos.Producto
    INNER JOIN cajeros
    On venta.Cajero = cajeros.Cajero
    GROUP BY cajeros.Cajero
    ORDER BY COUNT(cajeros.Cajero) DESC;
    
    /*Obtener el código y nombre de aquellos cajeros que hayan realizado ventas en pisos cuyas ventas totales sean inferiores a los 5000 pesos.*/
    /*solo pude obtner el nombre de uno de los dos cajeros, ya que no supe iterar el resulto*/
    SElECT if(Sum(productos.Precio) <= 5000 ,(cajeros.NomApels) , 0)
    FROM venta
    INNER JOIN productos
    ON venta.Producto = productos.Producto
    INNER JOIN maquinas_registradoras
    On venta.Maquina = maquinas_registradoras.Maquina   
    INNER JOIN cajeros
    On venta.Cajero = cajeros.Cajero
    GROUP BY maquinas_registradoras.piso
    