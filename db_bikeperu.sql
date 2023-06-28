-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyecto_uni
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  `Estado` varchar(1) NOT NULL DEFAULT 'S',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `RazonSocial` varchar(250) DEFAULT NULL,
  `Documento` varchar(11) NOT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  `Tipo` varchar(1) DEFAULT '1',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Documento_UNIQUE` (`Documento`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `consultarucdni`
--

DROP TABLE IF EXISTS `consultarucdni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consultarucdni` (
  `tipoConsulta` int NOT NULL,
  `numero` varchar(11) DEFAULT NULL,
  `minChar` int DEFAULT '8',
  `maxChar` int DEFAULT '11',
  PRIMARY KEY (`tipoConsulta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Tabla para consulta de ruc y dni';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `kardexventas`
--

DROP TABLE IF EXISTS `kardexventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kardexventas` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Secuencia` int DEFAULT NULL,
  `IdTipoMov` int DEFAULT NULL,
  `item` int DEFAULT NULL,
  `Codpro` varchar(6) NOT NULL,
  `stkini` decimal(18,3) NOT NULL DEFAULT '0.000',
  `stkmov` decimal(18,3) NOT NULL DEFAULT '0.000',
  `stkfin` decimal(18,3) NOT NULL DEFAULT '0.000',
  `IdUsuario` int DEFAULT NULL,
  `FechaRegistro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `PrecioCompra` decimal(18,3) NOT NULL DEFAULT '0.000',
  `PrecioVenta` decimal(18,3) NOT NULL DEFAULT '0.000',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mantenimiento_precio`
--

DROP TABLE IF EXISTS `mantenimiento_precio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mantenimiento_precio` (
  `secuencia` int NOT NULL AUTO_INCREMENT,
  `porAdministrativo` int NOT NULL DEFAULT '0',
  `porUtilidad` int NOT NULL DEFAULT '0',
  `FecRegistro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `FecActualizado` datetime DEFAULT CURRENT_TIMESTAMP,
  `FlgEstado` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`secuencia`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marca` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) DEFAULT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  `Estado` varchar(1) NOT NULL DEFAULT 'S',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pagina`
--

DROP TABLE IF EXISTS `pagina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagina` (
  `Id` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `url` varchar(100) DEFAULT '#',
  `idPadre` varchar(4) NOT NULL DEFAULT '#',
  `Icono` varchar(45) DEFAULT NULL,
  `Orden` int DEFAULT NULL,
  `Estado` varchar(1) NOT NULL DEFAULT 'S',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `paginausuario`
--

DROP TABLE IF EXISTS `paginausuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paginausuario` (
  `idPaginaUsuario` int NOT NULL AUTO_INCREMENT,
  `IdPagina` int DEFAULT NULL,
  `IdUsuario` int DEFAULT NULL,
  `Estado` varchar(1) NOT NULL DEFAULT 'S',
  PRIMARY KEY (`idPaginaUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `Codpro` varchar(6) NOT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  `IdCategoria` int DEFAULT NULL,
  `IdMarca` int DEFAULT NULL,
  `Especificacion` varchar(500) DEFAULT NULL,
  `PrecioCompra` decimal(18,4) DEFAULT NULL,
  `Imagen` varchar(500) DEFAULT NULL,
  `FechaCreado` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Estado` varchar(1) NOT NULL DEFAULT 'S',
  PRIMARY KEY (`Codpro`),
  KEY `IdCategoriaFk_idx` (`IdCategoria`),
  KEY `IdMarcaFk_idx` (`IdMarca`),
  CONSTRAINT `IdCategoriaFk` FOREIGN KEY (`IdCategoria`) REFERENCES `categoria` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `IdMarcaFk` FOREIGN KEY (`IdMarca`) REFERENCES `marca` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `productoserie`
--

DROP TABLE IF EXISTS `productoserie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productoserie` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Codpro` varchar(6) DEFAULT NULL,
  `NroSerie` varchar(45) DEFAULT NULL,
  `PrecioCompra` decimal(18,4) DEFAULT NULL,
  `FechaCreado` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Disponible` int NOT NULL DEFAULT '1',
  `Estado` varchar(1) NOT NULL DEFAULT 'S',
  PRIMARY KEY (`Id`),
  KEY `CodproFk_idx` (`Codpro`),
  CONSTRAINT `CodproFk` FOREIGN KEY (`Codpro`) REFERENCES `producto` (`Codpro`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `idProveedor` int NOT NULL AUTO_INCREMENT,
  `Rucprv` varchar(11) NOT NULL,
  `RazonSocial` varchar(255) NOT NULL,
  `Estado` varchar(1) NOT NULL DEFAULT 'S',
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `NombreRol` varchar(45) DEFAULT NULL,
  `FlgEstado` varchar(2) NOT NULL DEFAULT 'S',
  `TipRol` varchar(2) NOT NULL DEFAULT 'U',
  `Leer` int NOT NULL DEFAULT '1',
  `Agregar` int NOT NULL DEFAULT '0',
  `Editar` int NOT NULL DEFAULT '0',
  `Eliminar` int NOT NULL DEFAULT '0',
  `Facturar` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipocomprobante`
--

DROP TABLE IF EXISTS `tipocomprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipocomprobante` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `codigo` int NOT NULL,
  `estado` varchar(1) NOT NULL DEFAULT 'S',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Tipo de comprobantes boleta y factura';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipodocumentoidentidad`
--

DROP TABLE IF EXISTS `tipodocumentoidentidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipodocumentoidentidad` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `estado` varchar(1) NOT NULL DEFAULT 'S',
  `codigo` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipomovimiento`
--

DROP TABLE IF EXISTS `tipomovimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipomovimiento` (
  `id` int NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `estado` varchar(1) NOT NULL DEFAULT 'S',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Almacena los tipos de moviento como ventas, compras, ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `IdRol` int DEFAULT NULL,
  `Estado` varchar(1) NOT NULL DEFAULT 'S',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `IdRolFk_idx` (`IdRol`),
  CONSTRAINT `IdRolFk` FOREIGN KEY (`IdRol`) REFERENCES `rol` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuariorole`
--

DROP TABLE IF EXISTS `usuariorole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuariorole` (
  `idUsuarioRole` int NOT NULL AUTO_INCREMENT,
  `IdRol` int DEFAULT NULL,
  `IdUsuario` int DEFAULT NULL,
  `Estado` varchar(1) NOT NULL DEFAULT 'S',
  PRIMARY KEY (`idUsuarioRole`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuarioserie`
--

DROP TABLE IF EXISTS `usuarioserie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarioserie` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `IdUsuario` int DEFAULT NULL,
  `IdTipoComprobante` int NOT NULL,
  `NroSerie` varchar(5) NOT NULL,
  `Estado` varchar(1) NOT NULL DEFAULT 'S',
  PRIMARY KEY (`Id`),
  KEY `Fk_IdUsuario_idx` (`IdUsuario`),
  KEY `Fk_IdTipoComprobante_idx` (`IdTipoComprobante`),
  CONSTRAINT `Fk_IdTipoComprobante` FOREIGN KEY (`IdTipoComprobante`) REFERENCES `tipocomprobante` (`id`),
  CONSTRAINT `Fk_IdUsuario` FOREIGN KEY (`IdUsuario`) REFERENCES `usuario` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `venta_cabecera`
--

DROP TABLE IF EXISTS `venta_cabecera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta_cabecera` (
  `secuencia` int NOT NULL,
  `IdCliente` int DEFAULT NULL,
  `TipoComprobante` int DEFAULT NULL,
  `Serie_doc` varchar(4) DEFAULT NULL,
  `Numero_doc` varchar(8) DEFAULT NULL,
  `ImpTotal` decimal(18,3) DEFAULT NULL,
  `ImgIgv` decimal(18,3) DEFAULT NULL,
  `ImpSubTotal` decimal(18,3) DEFAULT NULL,
  `FlgEstado` varchar(1) NOT NULL DEFAULT 'P',
  `FlgActivo` varchar(2) NOT NULL DEFAULT 'GE',
  `FecRegistro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `FecEntrega` datetime DEFAULT NULL,
  PRIMARY KEY (`secuencia`),
  KEY `IdClienteFk_idx` (`IdCliente`),
  CONSTRAINT `IdClienteFk` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `venta_cabecera_temp`
--

DROP TABLE IF EXISTS `venta_cabecera_temp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta_cabecera_temp` (
  `secuencia` int NOT NULL,
  `IdCliente` int DEFAULT NULL,
  `TipoComprobante` int DEFAULT NULL,
  `Serie_doc` varchar(4) DEFAULT NULL,
  `Numero_doc` varchar(8) DEFAULT NULL,
  `ImpTotal` decimal(18,2) DEFAULT NULL,
  `ImgIgv` decimal(18,2) DEFAULT NULL,
  `ImpSubTotal` decimal(18,2) DEFAULT NULL,
  `FlgEstado` varchar(1) NOT NULL DEFAULT 'P',
  `FlgActivo` varchar(2) NOT NULL DEFAULT 'GE',
  `FecRegistro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `FecEntrega` datetime DEFAULT NULL,
  PRIMARY KEY (`secuencia`),
  KEY `IdClienteTempFk_idx` (`IdCliente`),
  CONSTRAINT `IdClienteTempFk` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `venta_detalle`
--

DROP TABLE IF EXISTS `venta_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta_detalle` (
  `secuencia` int NOT NULL,
  `item` int NOT NULL,
  `IdSerieProducto` int DEFAULT NULL,
  `precio_venta` decimal(18,3) DEFAULT NULL,
  `afecto` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`secuencia`,`item`),
  KEY `SecuenciaCabeceraFk_idx` (`secuencia`),
  KEY `IdSerieProductoFK_idx` (`IdSerieProducto`),
  CONSTRAINT `IdSerieProductoFK` FOREIGN KEY (`IdSerieProducto`) REFERENCES `productoserie` (`Id`),
  CONSTRAINT `SecuenciaCabeceraFk` FOREIGN KEY (`secuencia`) REFERENCES `venta_cabecera` (`secuencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `venta_detalle_temp`
--

DROP TABLE IF EXISTS `venta_detalle_temp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta_detalle_temp` (
  `secuencia` int NOT NULL,
  `item` int NOT NULL,
  `IdSerieProducto` int DEFAULT NULL,
  `precio_venta` decimal(18,3) DEFAULT NULL,
  `afecto` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`secuencia`,`item`),
  KEY `SecuenciaCabeceraTempFk_idx` (`secuencia`),
  KEY `IdSerieProductoFKTemp_idx` (`IdSerieProducto`),
  CONSTRAINT `IdSerieProductoTempFK` FOREIGN KEY (`IdSerieProducto`) REFERENCES `productoserie` (`Id`),
  CONSTRAINT `SecuenciaCabeceraTempFk` FOREIGN KEY (`secuencia`) REFERENCES `venta_cabecera_temp` (`secuencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-28  6:33:04
