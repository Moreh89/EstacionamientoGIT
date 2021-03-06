USE [ESTACIONAMIENTO]
GO
/****** Object:  Table [db_owner].[Usuario]    Script Date: 04/17/2015 16:15:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [db_owner].[Usuario](
	[idUsuario] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[userName] [varchar](255) NULL,
	[password] [varchar](255) NULL,
	[permisos] [int] NULL,
	[nombre] [varchar](255) NULL,
	[apellido] [varchar](255) NULL,
	[tipoDocumento] [varchar](255) NULL,
	[numeroDocumento] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idUsuario] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [db_owner].[ModeloVehiculo]    Script Date: 04/17/2015 16:15:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [db_owner].[ModeloVehiculo](
	[idModelo] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idModelo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [db_owner].[Descuento]    Script Date: 04/17/2015 16:15:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [db_owner].[Descuento](
	[idDescuento] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](255) NULL,
	[descuento] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idDescuento] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [db_owner].[CuentaCorriente]    Script Date: 04/17/2015 16:15:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [db_owner].[CuentaCorriente](
	[idCuentaCorriente] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idCuentaCorriente] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [db_owner].[ColorVehiculo]    Script Date: 04/17/2015 16:15:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [db_owner].[ColorVehiculo](
	[idColor] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idColor] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [db_owner].[CategoriaVehiculo]    Script Date: 04/17/2015 16:15:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [db_owner].[CategoriaVehiculo](
	[idCategoria] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idCategoria] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [db_owner].[Cliente]    Script Date: 04/17/2015 16:15:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [db_owner].[Cliente](
	[idCliente] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[tipoCliente] [int] NULL,
	[nombre] [varchar](255) NULL,
	[apellido] [varchar](255) NULL,
	[tipoDocumento] [int] NULL,
	[numeroDocumento] [varchar](255) NULL,
	[telefono1] [varchar](255) NULL,
	[telefono2] [varchar](255) NULL,
	[direccion] [varchar](255) NULL,
	[direccion2] [varchar](255) NULL,
	[descripcion] [varchar](255) NULL,
	[correoElectronico] [varchar](255) NULL,
	[estado] [int] NULL,
	[razonSocial] [varchar](255) NULL,
	[CuentaCorriente] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[idCliente] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [db_owner].[Tarifa]    Script Date: 04/17/2015 16:15:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [db_owner].[Tarifa](
	[idTarifa] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[costoMinimo] [float] NOT NULL,
	[costoFraccion] [float] NOT NULL,
	[costoHora] [float] NOT NULL,
	[costoMediaEstadia] [float] NOT NULL,
	[costoEstadia] [float] NOT NULL,
	[tiempoMinimo] [float] NOT NULL,
	[tiempoFraccion] [float] NOT NULL,
	[tiempoMediaEstadia_minuto] [float] NOT NULL,
	[tiempoEstadia_minuto] [float] NOT NULL,
	[Categoria] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[idTarifa] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [db_owner].[Cochera]    Script Date: 04/17/2015 16:15:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [db_owner].[Cochera](
	[idCochera] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[costoCochera] [float] NOT NULL,
	[estado] [int] NULL,
	[Cliente] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[idCochera] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [db_owner].[PersonaAutorizada]    Script Date: 04/17/2015 16:15:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [db_owner].[PersonaAutorizada](
	[idPersonaAut] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](255) NULL,
	[PersonaAut] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[idPersonaAut] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [db_owner].[Vehiculo]    Script Date: 04/17/2015 16:15:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [db_owner].[Vehiculo](
	[idVehiculo] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[patente] [varchar](255) NULL,
	[Modelo] [numeric](19, 0) NULL,
	[Color] [numeric](19, 0) NULL,
	[Categoria] [numeric](19, 0) NULL,
	[Cliente] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[idVehiculo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [db_owner].[Ticket]    Script Date: 04/17/2015 16:15:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [db_owner].[Ticket](
	[idTicket] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[montoCobrado] [float] NOT NULL,
	[estado] [varchar](255) NULL,
	[fechaLlegada] [datetime] NULL,
	[fechaSalida] [datetime] NULL,
	[tipoIngreso] [varchar](255) NULL,
	[Descuento] [numeric](19, 0) NULL,
	[Cliente] [numeric](19, 0) NULL,
	[Vehiculo] [numeric](19, 0) NULL,
	[Usuario] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[idTicket] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [db_owner].[MovimientoCC]    Script Date: 04/17/2015 16:15:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [db_owner].[MovimientoCC](
	[idMovimiento] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[fecha] [datetime] NULL,
	[descripcion] [varchar](255) NULL,
	[montoCobrado] [float] NOT NULL,
	[estado] [varchar](255) NULL,
	[Ticket] [numeric](19, 0) NULL,
	[CuentaCorriente] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[idMovimiento] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  ForeignKey [FK96841DDAA0D8D889]    Script Date: 04/17/2015 16:15:23 ******/
ALTER TABLE [db_owner].[Cliente]  WITH CHECK ADD  CONSTRAINT [FK96841DDAA0D8D889] FOREIGN KEY([CuentaCorriente])
REFERENCES [db_owner].[CuentaCorriente] ([idCuentaCorriente])
GO
ALTER TABLE [db_owner].[Cliente] CHECK CONSTRAINT [FK96841DDAA0D8D889]
GO
/****** Object:  ForeignKey [FK9B4F55C32111A4FF]    Script Date: 04/17/2015 16:15:23 ******/
ALTER TABLE [db_owner].[Cochera]  WITH CHECK ADD  CONSTRAINT [FK9B4F55C32111A4FF] FOREIGN KEY([Cliente])
REFERENCES [db_owner].[Cliente] ([idCliente])
GO
ALTER TABLE [db_owner].[Cochera] CHECK CONSTRAINT [FK9B4F55C32111A4FF]
GO
/****** Object:  ForeignKey [FKE97047D5A0D8D889]    Script Date: 04/17/2015 16:15:23 ******/
ALTER TABLE [db_owner].[MovimientoCC]  WITH CHECK ADD  CONSTRAINT [FKE97047D5A0D8D889] FOREIGN KEY([CuentaCorriente])
REFERENCES [db_owner].[CuentaCorriente] ([idCuentaCorriente])
GO
ALTER TABLE [db_owner].[MovimientoCC] CHECK CONSTRAINT [FKE97047D5A0D8D889]
GO
/****** Object:  ForeignKey [FKE97047D5F0696FAD]    Script Date: 04/17/2015 16:15:23 ******/
ALTER TABLE [db_owner].[MovimientoCC]  WITH CHECK ADD  CONSTRAINT [FKE97047D5F0696FAD] FOREIGN KEY([Ticket])
REFERENCES [db_owner].[Ticket] ([idTicket])
GO
ALTER TABLE [db_owner].[MovimientoCC] CHECK CONSTRAINT [FKE97047D5F0696FAD]
GO
/****** Object:  ForeignKey [FK6616EBB6163F9A99]    Script Date: 04/17/2015 16:15:23 ******/
ALTER TABLE [db_owner].[PersonaAutorizada]  WITH CHECK ADD  CONSTRAINT [FK6616EBB6163F9A99] FOREIGN KEY([PersonaAut])
REFERENCES [db_owner].[Cliente] ([idCliente])
GO
ALTER TABLE [db_owner].[PersonaAutorizada] CHECK CONSTRAINT [FK6616EBB6163F9A99]
GO
/****** Object:  ForeignKey [FK94E3653FD066C436]    Script Date: 04/17/2015 16:15:23 ******/
ALTER TABLE [db_owner].[Tarifa]  WITH CHECK ADD  CONSTRAINT [FK94E3653FD066C436] FOREIGN KEY([Categoria])
REFERENCES [db_owner].[CategoriaVehiculo] ([idCategoria])
GO
ALTER TABLE [db_owner].[Tarifa] CHECK CONSTRAINT [FK94E3653FD066C436]
GO
/****** Object:  ForeignKey [FK954D572C2111A4FF]    Script Date: 04/17/2015 16:15:23 ******/
ALTER TABLE [db_owner].[Ticket]  WITH CHECK ADD  CONSTRAINT [FK954D572C2111A4FF] FOREIGN KEY([Cliente])
REFERENCES [db_owner].[Cliente] ([idCliente])
GO
ALTER TABLE [db_owner].[Ticket] CHECK CONSTRAINT [FK954D572C2111A4FF]
GO
/****** Object:  ForeignKey [FK954D572C84F57B1F]    Script Date: 04/17/2015 16:15:23 ******/
ALTER TABLE [db_owner].[Ticket]  WITH CHECK ADD  CONSTRAINT [FK954D572C84F57B1F] FOREIGN KEY([Vehiculo])
REFERENCES [db_owner].[Vehiculo] ([idVehiculo])
GO
ALTER TABLE [db_owner].[Ticket] CHECK CONSTRAINT [FK954D572C84F57B1F]
GO
/****** Object:  ForeignKey [FK954D572CAAA47F67]    Script Date: 04/17/2015 16:15:23 ******/
ALTER TABLE [db_owner].[Ticket]  WITH CHECK ADD  CONSTRAINT [FK954D572CAAA47F67] FOREIGN KEY([Usuario])
REFERENCES [db_owner].[Usuario] ([idUsuario])
GO
ALTER TABLE [db_owner].[Ticket] CHECK CONSTRAINT [FK954D572CAAA47F67]
GO
/****** Object:  ForeignKey [FK954D572CB956101B]    Script Date: 04/17/2015 16:15:23 ******/
ALTER TABLE [db_owner].[Ticket]  WITH CHECK ADD  CONSTRAINT [FK954D572CB956101B] FOREIGN KEY([Descuento])
REFERENCES [db_owner].[Descuento] ([idDescuento])
GO
ALTER TABLE [db_owner].[Ticket] CHECK CONSTRAINT [FK954D572CB956101B]
GO
/****** Object:  ForeignKey [FK7BE8DD852111A4FF]    Script Date: 04/17/2015 16:15:23 ******/
ALTER TABLE [db_owner].[Vehiculo]  WITH CHECK ADD  CONSTRAINT [FK7BE8DD852111A4FF] FOREIGN KEY([Cliente])
REFERENCES [db_owner].[Cliente] ([idCliente])
GO
ALTER TABLE [db_owner].[Vehiculo] CHECK CONSTRAINT [FK7BE8DD852111A4FF]
GO
/****** Object:  ForeignKey [FK7BE8DD852D578E16]    Script Date: 04/17/2015 16:15:23 ******/
ALTER TABLE [db_owner].[Vehiculo]  WITH CHECK ADD  CONSTRAINT [FK7BE8DD852D578E16] FOREIGN KEY([Color])
REFERENCES [db_owner].[ColorVehiculo] ([idColor])
GO
ALTER TABLE [db_owner].[Vehiculo] CHECK CONSTRAINT [FK7BE8DD852D578E16]
GO
/****** Object:  ForeignKey [FK7BE8DD855D7E20E6]    Script Date: 04/17/2015 16:15:23 ******/
ALTER TABLE [db_owner].[Vehiculo]  WITH CHECK ADD  CONSTRAINT [FK7BE8DD855D7E20E6] FOREIGN KEY([Modelo])
REFERENCES [db_owner].[ModeloVehiculo] ([idModelo])
GO
ALTER TABLE [db_owner].[Vehiculo] CHECK CONSTRAINT [FK7BE8DD855D7E20E6]
GO
/****** Object:  ForeignKey [FK7BE8DD85D066C436]    Script Date: 04/17/2015 16:15:23 ******/
ALTER TABLE [db_owner].[Vehiculo]  WITH CHECK ADD  CONSTRAINT [FK7BE8DD85D066C436] FOREIGN KEY([Categoria])
REFERENCES [db_owner].[CategoriaVehiculo] ([idCategoria])
GO
ALTER TABLE [db_owner].[Vehiculo] CHECK CONSTRAINT [FK7BE8DD85D066C436]
GO
GO

CREATE USER [admsql] FOR LOGIN [admsql] WITH PASSWORD = '1234', DEFAULT_SCHEMA=[db_owner] AND
GO