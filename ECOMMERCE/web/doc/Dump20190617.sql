-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ecommerce
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `id_cli` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_per` varchar(25) NOT NULL,
  `apellido_per` varchar(25) NOT NULL,
  `identificacion_per` varchar(13) NOT NULL,
  `fecha_nac_per` date DEFAULT NULL,
  `direccion_per` varchar(45) NOT NULL,
  `telefono_per` varchar(10) NOT NULL,
  `correo_per` varchar(45) NOT NULL,
  `cuota_ven_cli` decimal(10,2) DEFAULT NULL,
  `id_tipcli` int(11) NOT NULL,
  PRIMARY KEY (`id_cli`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Marco','Toscano','1717845741','1983-11-12','sdf','2455789','mtoscano@matoosfe.com',4500.00,1),(5,'MARLENE','RIVERA','1234567897894','1983-11-12','SAN CARLOS','2455789','mrivera@gmail.com',4000.00,1),(6,'MARIO','VALAREZO','2222222222222','1983-11-12','CINCO ESQUINAS','2455789','mvalarezo@gmail.com',4000.00,2),(7,'DSFSD','SDFSD','1111111111111','1983-11-12','DSFSDFS','2455789','pcerezo@gmail.com',4000.00,2),(9,'SDSDF','SDFS','1231232132131','1991-10-12','DSFSDFS','2568978','kara.viD@algo.com',2800.00,1),(10,'JUANITO','CEREZO','1111111111111','1983-11-12','GUAJALO','2455789','pcerezo@gmail.com',4800.00,2),(11,'JAVIER','ALTURA','1111111111111','1991-10-12','SAN BLAS','2568978','jaltura@yahoo.com',4800.00,1),(12,'JAVIER','RIVERA DOS','2222222222222','1991-10-12','QUITUMBE','2568978','jaltura@yahoo.com',4800.00,1),(14,'ASDF','SDF','1717845741333','1991-10-12','DSFS','2568978','kara.viD@algo.com',2800.00,2),(15,'PRUEBA','RELACIONADA','1111111111111','1991-10-12','SSSSS','2568978','kara.viD@algo.com',2800.00,2),(16,'AAA','BB','2222222222222','1991-10-12','DDD','2568978','kara.viD@algo.com',2800.00,1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_factura`
--

DROP TABLE IF EXISTS `detalle_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `detalle_factura` (
  `id_detfac` int(11) NOT NULL AUTO_INCREMENT,
  `can_detfac` int(11) NOT NULL,
  `obs_detfac` varchar(45) NOT NULL,
  `subtotal_detfac` decimal(10,2) NOT NULL,
  `iva_detfac` decimal(10,2) NOT NULL,
  `total_detfac` decimal(10,2) NOT NULL,
  `id_fac` int(11) NOT NULL,
  `id_pro` int(11) NOT NULL,
  `id_prov` int(11) NOT NULL,
  PRIMARY KEY (`id_detfac`),
  KEY `fk_detalle_factura_factura1_idx` (`id_fac`),
  KEY `fk_detalle_factura_producto_has_proveedor1_idx` (`id_pro`,`id_prov`),
  CONSTRAINT `fk_detalle_factura_factura1` FOREIGN KEY (`id_fac`) REFERENCES `factura` (`id_fac`),
  CONSTRAINT `fk_detalle_factura_producto_has_proveedor1` FOREIGN KEY (`id_pro`, `id_prov`) REFERENCES `producto_has_proveedor` (`id_pro`, `id_prov`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_factura`
--

LOCK TABLES `detalle_factura` WRITE;
/*!40000 ALTER TABLE `detalle_factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `factura` (
  `id_fac` int(11) NOT NULL AUTO_INCREMENT,
  `fac_numero` varchar(16) NOT NULL,
  `fecha_fac` date NOT NULL,
  `subtotal_fac` decimal(10,2) NOT NULL,
  `iva_fac` decimal(10,2) NOT NULL,
  `total_fac` decimal(10,2) NOT NULL,
  `id_cli` int(11) NOT NULL,
  PRIMARY KEY (`id_fac`),
  KEY `fk_factura_cliente1_idx` (`id_cli`),
  CONSTRAINT `fk_factura_cliente1` FOREIGN KEY (`id_cli`) REFERENCES `cliente` (`id_cli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `producto` (
  `id_pro` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_pro` varchar(25) NOT NULL,
  `descripcion_pro` varchar(200) DEFAULT NULL,
  `precio_pro` decimal(10,2) NOT NULL,
  `fecha_cad_pro` date DEFAULT NULL,
  `id_tip_pro` int(11) NOT NULL,
  PRIMARY KEY (`id_pro`),
  KEY `fk_tipo_producto_idx` (`id_tip_pro`),
  CONSTRAINT `fk_tipo_producto` FOREIGN KEY (`id_tip_pro`) REFERENCES `tipo_producto` (`id_tip_pro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_has_proveedor`
--

DROP TABLE IF EXISTS `producto_has_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `producto_has_proveedor` (
  `id_pro` int(11) NOT NULL,
  `id_prov` int(11) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id_pro`,`id_prov`),
  KEY `fk_producto_has_proveedor_proveedor1_idx` (`id_prov`),
  KEY `fk_producto_has_proveedor_producto1_idx` (`id_pro`),
  CONSTRAINT `fk_producto_has_proveedor_producto1` FOREIGN KEY (`id_pro`) REFERENCES `producto` (`id_pro`),
  CONSTRAINT `fk_producto_has_proveedor_proveedor1` FOREIGN KEY (`id_prov`) REFERENCES `proveedor` (`id_prov`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_has_proveedor`
--

LOCK TABLES `producto_has_proveedor` WRITE;
/*!40000 ALTER TABLE `producto_has_proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_has_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `proveedor` (
  `id_prov` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_per` varchar(45) NOT NULL,
  PRIMARY KEY (`id_prov`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(45) NOT NULL,
  `descripcion_rol` varchar(100) NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Admin','Admin');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_cliente`
--

DROP TABLE IF EXISTS `tipo_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo_cliente` (
  `id_tipcli` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tipcli` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipcli`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_cliente`
--

LOCK TABLES `tipo_cliente` WRITE;
/*!40000 ALTER TABLE `tipo_cliente` DISABLE KEYS */;
INSERT INTO `tipo_cliente` VALUES (1,'Natural'),(2,'Juridico');
/*!40000 ALTER TABLE `tipo_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_producto`
--

DROP TABLE IF EXISTS `tipo_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo_producto` (
  `id_tip_pro` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador de tipo de producto',
  `nombre_tip_pro` varchar(25) NOT NULL COMMENT 'Nombre del Tipo Producto',
  `descripcion_tip_pro` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_tip_pro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_producto`
--

LOCK TABLES `tipo_producto` WRITE;
/*!40000 ALTER TABLE `tipo_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `id_usu` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usu` varchar(10) NOT NULL,
  `clave_usu` varchar(10) NOT NULL,
  `id_rol` int(11) NOT NULL,
  PRIMARY KEY (`id_usu`),
  KEY `fk_usuario_rol1_idx` (`id_rol`),
  CONSTRAINT `fk_usuario_rol1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'mtoscano','1234',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-17 21:01:55
