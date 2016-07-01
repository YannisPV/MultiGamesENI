CREATE DATABASE MultiGamesENI;

USE [MultiGamesENI]
GO

DROP TABLE Parties;
DROP TABLE Jeux;
DROP TABLE Joueurs;



GO
/****** Object:  Table [dbo].[Jeux]    Script Date: 30/06/2016 16:21:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Jeux](
	[id] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[nom] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Joueurs]    Script Date: 30/06/2016 16:21:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Joueurs](
	[id] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[nom] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Parties]    Script Date: 30/06/2016 16:21:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Parties](
	[id] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[JoueurId] [int] NOT NULL,
	[JeuId] [int] NOT NULL,
	[gagner] [bit] not null,
) ON [PRIMARY]

ALTER TABLE Parties WITH CHECK ADD CONSTRAINT [FK_Joueurs_Parties] FOREIGN KEY (JoueurId)
REFERENCES Joueurs(id)
ALTER TABLE Parties WITH CHECK ADD CONSTRAINT [FK_Jeux_Parties] FOREIGN KEY (JeuId)
REFERENCES Jeux(id)
GO


INSERT INTO Jeux VALUES('Guess');
INSERT INTO Joueurs VALUES('Jeremy');
INSERT INTO Joueurs VALUES('Clement');
INSERT INTO Joueurs VALUES('Yannis');
INSERT INTO Parties VALUES(1, 1, 0);
INSERT INTO Parties VALUES(2, 1, 1);