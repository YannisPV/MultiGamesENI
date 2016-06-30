CREATE DATABASE MultiGamesENI;

USE [MultiGamesENI]
GO
/****** Object:  Table [dbo].[Jeux]    Script Date: 30/06/2016 16:21:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Jeux](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nom] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Joueurs]    Script Date: 30/06/2016 16:21:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Joueurs](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nom] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Parties]    Script Date: 30/06/2016 16:21:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Parties](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nom] [nvarchar](50) NULL
) ON [PRIMARY]

GO
