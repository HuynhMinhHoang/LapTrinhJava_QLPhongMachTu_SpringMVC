-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: hospitaldb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `bac_si`
--

DROP TABLE IF EXISTS `bac_si`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bac_si` (
  `id_bs` int NOT NULL AUTO_INCREMENT,
  `ho_ten` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `gioi_tinh` tinyint NOT NULL,
  `nam_sinh` datetime NOT NULL,
  `id_tk` int NOT NULL,
  PRIMARY KEY (`id_bs`),
  KEY `BacSi_TaiKhoan_idx` (`id_tk`),
  CONSTRAINT `BacSi_TaiKhoan` FOREIGN KEY (`id_tk`) REFERENCES `tai_khoan` (`id_tk`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bac_si`
--

LOCK TABLES `bac_si` WRITE;
/*!40000 ALTER TABLE `bac_si` DISABLE KEYS */;
INSERT INTO `bac_si` VALUES (1,'minhhoang',1,'2001-09-23 00:00:00',2),(2,'my',0,'2001-09-23 00:00:00',2),(3,'thuyen',1,'2001-09-23 00:00:00',2);
/*!40000 ALTER TABLE `bac_si` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `benh_nhan`
--

DROP TABLE IF EXISTS `benh_nhan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benh_nhan` (
  `id_bn` int NOT NULL AUTO_INCREMENT,
  `ho_ten` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `nam_sinh` datetime NOT NULL,
  `gioi_tinh` tinyint NOT NULL,
  `dia_chi` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `email` varchar(45) NOT NULL,
  `id_tk` int NOT NULL,
  PRIMARY KEY (`id_bn`),
  KEY `BenhNhan_TaiKhoan_idx` (`id_tk`),
  CONSTRAINT `BenhNhan_TaiKhoan` FOREIGN KEY (`id_tk`) REFERENCES `tai_khoan` (`id_tk`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benh_nhan`
--

LOCK TABLES `benh_nhan` WRITE;
/*!40000 ALTER TABLE `benh_nhan` DISABLE KEYS */;
INSERT INTO `benh_nhan` VALUES (1,'nam','2001-09-23 00:00:00',1,'hcm','hmhm@gmail.com',4),(2,'thanh','2001-09-23 00:00:00',0,'tp','sdf@gmail.com',4);
/*!40000 ALTER TABLE `benh_nhan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chi_tiet_thuoc`
--

DROP TABLE IF EXISTS `chi_tiet_thuoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chi_tiet_thuoc` (
  `id_chitiet_thuoc` int NOT NULL AUTO_INCREMENT,
  `id_thuoc` int NOT NULL,
  `id_phieukham` int NOT NULL,
  `so_luong` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id_chitiet_thuoc`),
  KEY `ChiTietThuoc_Thuoc_idx` (`id_thuoc`),
  KEY `ChiTietThuoc_PhieuKhamBenh_idx` (`id_phieukham`),
  CONSTRAINT `ChiTietThuoc_PhieuKhamBenh` FOREIGN KEY (`id_phieukham`) REFERENCES `phieu_kham_benh` (`id_phieukham`),
  CONSTRAINT `ChiTietThuoc_Thuoc` FOREIGN KEY (`id_thuoc`) REFERENCES `thuoc` (`id_thuoc`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chi_tiet_thuoc`
--

LOCK TABLES `chi_tiet_thuoc` WRITE;
/*!40000 ALTER TABLE `chi_tiet_thuoc` DISABLE KEYS */;
INSERT INTO `chi_tiet_thuoc` VALUES (1,1,1,3);
/*!40000 ALTER TABLE `chi_tiet_thuoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoa_don`
--

DROP TABLE IF EXISTS `hoa_don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoa_don` (
  `id_hoadon` int NOT NULL AUTO_INCREMENT,
  `id_yta` int NOT NULL,
  `id_phieukham` int NOT NULL,
  `ngay_thanh_toan` datetime NOT NULL,
  `tien_kham` decimal(10,0) NOT NULL,
  `tien_thuoc` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id_hoadon`),
  KEY `HoaDon_YTa_idx` (`id_yta`),
  KEY `HoaDon_PhieuKham_idx` (`id_phieukham`),
  CONSTRAINT `HoaDon_PhieuKham` FOREIGN KEY (`id_phieukham`) REFERENCES `phieu_kham_benh` (`id_phieukham`),
  CONSTRAINT `HoaDon_YTa` FOREIGN KEY (`id_yta`) REFERENCES `y_ta` (`id_yt`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoa_don`
--

LOCK TABLES `hoa_don` WRITE;
/*!40000 ALTER TABLE `hoa_don` DISABLE KEYS */;
INSERT INTO `hoa_don` VALUES (1,1,1,'2023-07-25 00:00:00',100000,200000);
/*!40000 ALTER TABLE `hoa_don` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_dang_ky`
--

DROP TABLE IF EXISTS `phieu_dang_ky`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieu_dang_ky` (
  `id_phieudk` int NOT NULL AUTO_INCREMENT,
  `id_bn` int NOT NULL,
  `id_yta` int NOT NULL,
  `ngay_dky` datetime NOT NULL,
  `ngay_hkham` datetime NOT NULL,
  PRIMARY KEY (`id_phieudk`),
  KEY `PhieuDangKy_BenhNhan_idx` (`id_bn`),
  KEY `PhieuDangKy_YTa_idx` (`id_yta`),
  CONSTRAINT `PhieuDangKy_BenhNhan` FOREIGN KEY (`id_bn`) REFERENCES `benh_nhan` (`id_bn`),
  CONSTRAINT `PhieuDangKy_YTa` FOREIGN KEY (`id_yta`) REFERENCES `y_ta` (`id_yt`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_dang_ky`
--

LOCK TABLES `phieu_dang_ky` WRITE;
/*!40000 ALTER TABLE `phieu_dang_ky` DISABLE KEYS */;
INSERT INTO `phieu_dang_ky` VALUES (1,1,1,'2023-08-05 00:00:00','2023-09-05 00:00:00');
/*!40000 ALTER TABLE `phieu_dang_ky` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_kham_benh`
--

DROP TABLE IF EXISTS `phieu_kham_benh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieu_kham_benh` (
  `id_phieukham` int NOT NULL AUTO_INCREMENT,
  `id_bs` int NOT NULL,
  `id_bn` int NOT NULL,
  `trieu_chung` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `ket_luan` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id_phieukham`),
  KEY `PhieuKhamBenh_BacSi_idx` (`id_bs`),
  KEY `PhieuKhamBenh_BenhNhan_idx` (`id_bn`),
  CONSTRAINT `PhieuKhamBenh_BacSi` FOREIGN KEY (`id_bs`) REFERENCES `bac_si` (`id_bs`),
  CONSTRAINT `PhieuKhamBenh_BenhNhan` FOREIGN KEY (`id_bn`) REFERENCES `benh_nhan` (`id_bn`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_kham_benh`
--

LOCK TABLES `phieu_kham_benh` WRITE;
/*!40000 ALTER TABLE `phieu_kham_benh` DISABLE KEYS */;
INSERT INTO `phieu_kham_benh` VALUES (1,1,1,'ho','ho nang');
/*!40000 ALTER TABLE `phieu_kham_benh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tai_khoan`
--

DROP TABLE IF EXISTS `tai_khoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tai_khoan` (
  `id_tk` int NOT NULL AUTO_INCREMENT,
  `user_role` varchar(45) NOT NULL,
  `tai_khoan` varchar(45) NOT NULL,
  `mat_khau` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `avt` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tk`),
  UNIQUE KEY `tai_khoan_UNIQUE` (`tai_khoan`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tai_khoan`
--

LOCK TABLES `tai_khoan` WRITE;
/*!40000 ALTER TABLE `tai_khoan` DISABLE KEYS */;
INSERT INTO `tai_khoan` VALUES (1,'ROLE_ADMIN','admin','$2a$12$DI.LBue1IlviMivalkSoT.Ni7tomVrl.FyRSyUqG3qHRVtBvsNSXa','khongco'),(2,'bacsi','bacsi','$2a$12$P66aiJnF8915xCY/mNSHLOb/.b7/1aMmkUfKvj4RtdPr4MNpa8wSC','khongco'),(3,'yta','yta','$2a$12$cHqq9XpbHP5hRPKPrXtvmuTXp3StdoKcPGXyDcsfTt.bXoqibsdae','khongco'),(4,'benhnhan','benhnhan','$2a$12$ft9fcwYbsuY/T0HlJnWxdOf7ao6ENTlaBuiWWJpvYfKEs8EW/nOoO','khongco'),(5,'ROLE_ADMIN','hoang','$2a$10$KmeIgdihxf3yCshSc5dCMO4Qsg79eM.vIqem.PdtP09sABB4PEJHa',NULL),(7,'benhnhan','hoang1','$2a$10$.3A6wB7B6ZkSoqwL2iQGuOT6uEUKBQC03RrqqxbW1te19VNp7HlBm',NULL),(8,'benhnhan','gdfg','$2a$10$ivNgsKnqL8ON2R3ka9Pqd.z3wksD70r0VirNsTJ8dciQ.6PV3kLze',NULL),(10,'benhnhan','my','$2a$10$2a3pyZVIsiHhXFCH3OcQ9uceo6xKF1k9jo2P.O11DwVoPSRuTP/iK',NULL),(13,'benhnhan','myy','$2a$10$eMaA3cjDjSdeXZZ863ftO.uil2J7X18W8GJ78DVIQy.zHcqHqht/6',NULL),(14,'benhnhan','hoangg','$2a$10$NNeLHsce/O7MpaXddOyb2.fTvT5gfPZ.rgDzCfxLCK8QxEgski5o6',NULL),(15,'benhnhan','hoanggggg','$2a$10$7vHf1dPNxpBAXNPCHE/5veIFJDqL.pKLCczYU8FbNVU46Ho60H59m',NULL);
/*!40000 ALTER TABLE `tai_khoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thuoc`
--

DROP TABLE IF EXISTS `thuoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thuoc` (
  `id_thuoc` int NOT NULL AUTO_INCREMENT,
  `ten_thuoc` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `xuat_xu` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `ngay_nhap` datetime NOT NULL,
  `han_sd` datetime NOT NULL,
  `gia_thuoc` decimal(10,0) NOT NULL,
  `don_vi` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id_thuoc`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thuoc`
--

LOCK TABLES `thuoc` WRITE;
/*!40000 ALTER TABLE `thuoc` DISABLE KEYS */;
INSERT INTO `thuoc` VALUES (1,'vitaminA','việt nam','2023-01-01 00:00:00','2025-01-01 00:00:00',25000,'tuýp');
/*!40000 ALTER TABLE `thuoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `y_ta`
--

DROP TABLE IF EXISTS `y_ta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `y_ta` (
  `id_yt` int NOT NULL AUTO_INCREMENT,
  `ho_ten` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `nam_sinh` datetime NOT NULL,
  `gioi_tinh` tinyint NOT NULL,
  `id_tk` int NOT NULL,
  PRIMARY KEY (`id_yt`),
  KEY `YTa_TaiKhoan_idx` (`id_tk`),
  CONSTRAINT `YTa_TaiKhoan` FOREIGN KEY (`id_tk`) REFERENCES `tai_khoan` (`id_tk`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `y_ta`
--

LOCK TABLES `y_ta` WRITE;
/*!40000 ALTER TABLE `y_ta` DISABLE KEYS */;
INSERT INTO `y_ta` VALUES (1,'vi','2001-09-23 00:00:00',0,3);
/*!40000 ALTER TABLE `y_ta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-28 11:20:03
