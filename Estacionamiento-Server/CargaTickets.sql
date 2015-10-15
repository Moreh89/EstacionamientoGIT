/*
montoCobrado
,estado
,fechaLlegada
,fechaSalida
,prepago
,observacion
,patente
,pagotarjeta
,ModeloVehiculo
,CatergoriaVehiculo
,Descuento
,Color
,Cliente
,Usuario
*/
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, GETDATE(), null, 0, null, 'minimo', 0, 2, 1, 1, 2,null,2)
GO
	INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -10,getdate()), null, 0, null, 'minimo', 0, 2, 1, 1, 2,null,2)
GO	
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -20,getdate()), null, 0, null, 'minimo', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -30,getdate()), null, 0, null, 'minimo', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -40,getdate()), null, 0, null, 'minimo', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -50,getdate()), null, 0, null, 'minimo', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -65,getdate()), null, 0, null, 'hora+1Frac', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -90,getdate()), null, 0, null, 'hora+30min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -95,getdate()), null, 0, null, 'hora+45min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -125,getdate()), null, 0, null, '2horas+5min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -150,getdate()), null, 0, null, '2horas+30min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -165,getdate()), null, 0, null, '2horas+45min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -185,getdate()), null, 0, null, '3horas+5min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -225,getdate()), null, 0, null, '3horas+45min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -225,getdate()), null, 0, null, '3horas+45min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -245,getdate()), null, 0, null, '4horas+5min', 0, 2, 1, 1, 2,null,2)
GO

INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -270,getdate()), null, 0, null, '4horas+30min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -305,getdate()), null, 0, null, '5horas+5min', 0, 2, 1, 1, 2,null,2)
GO

INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -330,getdate()), null, 0, null, '5horas+30min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -365,getdate()), null, 0, null, '6horas+5min', 0, 2, 1, 1, 2,null,2)
GO

INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -390,getdate()), null, 0, null, '6horas+30min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -425,getdate()), null, 0, null, '7horas+5min', 0, 2, 1, 1, 2,null,2)
GO

INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -450,getdate()), null, 0, null, '7horas+30min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -485,getdate()), null, 0, null, '8horas+5min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -510,getdate()), null, 0, null, '8horas+30min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -545,getdate()), null, 0, null, '9horas+5min', 0, 2, 1, 1, 2,null,2)
GO

INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -570,getdate()), null, 0, null, '9horas+30min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -605,getdate()), null, 0, null, '10horas+5min', 0, 2, 1, 1, 2,null,2)
GO

INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -630,getdate()), null, 0, null, '10horas+30min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -665,getdate()), null, 0, null, '11horas+5min', 0, 2, 1, 1, 2,null,2)
GO

INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -690,getdate()), null, 0, null, '11horas+30min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -720,getdate()), null, 0, null, '12horas+5min', 0, 2, 1, 1, 2,null,2)
GO

INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -745,getdate()), null, 0, null, '12horas+30min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -780,getdate()), null, 0, null, '13horas+5min', 0, 2, 1, 1, 2,null,2)
GO

INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -805,getdate()), null, 0, null, '13horas+30min', 0, 2, 1, 1, 2,null,2)
GO
INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -840,getdate()), null, 0, null, '14horas+5min', 0, 2, 1, 1, 2,null,2)
GO

INSERT INTO Ticket (montoCobrado,estado,fechaLlegada,fechaSalida,prepago,
	observacion,patente,pagotarjeta,ModeloVehiculo,CatergoriaVehiculo,Descuento,Color,Cliente,Usuario)
	VALUES (0, 0, DATEADD(minute, -865,getdate()), null, 0, null, '14horas+30min', 0, 2, 1, 1, 2,null,2)
GO
