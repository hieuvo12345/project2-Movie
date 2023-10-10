-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: project2
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id_movie` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `director` varchar(100) NOT NULL,
  `release` date NOT NULL,
  `duration` int NOT NULL,
  `moviecol` varchar(45) NOT NULL,
  `casting` varchar(100) NOT NULL,
  `thumbnail` varchar(100) NOT NULL,
  `movie_form` varchar(20) NOT NULL,
  `movie_type` varchar(50) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_movie`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Oppenheimer','Christopher Nolan','2023-09-06',180,'Christopher Nolan, Emma Thomas, Charles Roven','Cillian Murphy, Robert Downey Jr, Florence Pugh…','Oppenheimer_–_Vietnam_poster.jpeg','2D','Hồi hộp, Lịch Sử, Tâm Lý','Đang chiếu'),(2,'Barbie','Greta Gerwig','2023-09-08',114,'David Heyman, Margot Robbie, Robbie Brenner','Margot Robbie, Ryan Gosling, Will Ferrell, Emma Mackey…','Barbie_2023_poster.jpeg','2D','Hài lãng mạn, Chính Kịch',NULL),(3,'Avengers: End Game','Anthony Russo, Joe Russo','2023-09-16',181,'Kevin Feige','Chris Evans, Robert Downey Jr, Mark Ruffalo, Chris Hemsworth…','Avengers_Endgame_bia_teaser.jpeg','2D,3D,IMAX','Hành động, Khoa học viễn tưởng ',NULL),(4,'Spiderman: Far from home ','Jon Watts','2023-09-04',114,'Kevin Feige, Amy Pascal ','Tom Holland, Zendaya, Jake Gylienhaal, Samuel L. Jackson…','Người_Nhện–Xa_nhà–poster.jpeg','2D,3D,IMAX','Hành động, Phiêu lưu, Khoa học viễn tưởng',NULL),(5,'Chị Chị Em Em','Kathy Uyen','2023-09-15',104,'Will Vũ, Timothy Linh Bùi ','Chi Pu, Thanh Hằng, Lăng Thanh ','Poster_chi_chi_em_em.jpeg','2D','Lãng mãn, Chính kịch',NULL),(6,'Nhà Bà Nữ','Trấn Thành','2023-09-17',102,'Trấn Thành, Đỗ Hoàng Vũ ','Trấn Thành, Lê Giang, NSND Ngọc Giàu, Khả Như, NSND Việt Anh…','Áp_phích_phim_Nhà_bà_Nữ.jpeg','2D','Gia Đình, Hài Hước, Tâm Lý, Tình Cảm',NULL),(7,'Venom','Ruben Fleischer','2023-09-18',112,'Avi Arad, Matt Tolmach, Amy Pascal','Tom Hardy, Michelle Williams, Riz Ahrmed, Reid Scott, Scott Haze','Venom_phim_nam_2018.jpeg','2D,3D,IMAX','Hành động, Phiêu lưu, Khoa học viễn tưởng',NULL),(8,'Dark Kinght','Christopher Nolan','2023-09-18',152,'Christopher Nolan, Emma Thomas, Charles Roven','Cillian Murphy, Christian Bale, Heath Ledger, Gary Oldman, Aaron Eckhart…','Poster_phim_Kỵ_sĩ_bóng_đêm_2008.jpeg','2D','Hành Động, Phiêu lưu, Tâm Lý',NULL),(9,'Thor: Love And Thunder','Taika Waititi','2023-09-02',120,'Kevin Feige','Chris Hemsworth, Christian Bale, Natalie Portman, Elsa Pataky, Taika Waititi…','Thor_Tình_yêu_và_sấm_sét_poster.jpeg','2D,3D,IMAX','Hành động, Khoa học viễn tưởng ',NULL),(10,'The Incredible Hulk','Louis Leterrier ','2023-09-20',112,'Kevin Feige, Avi Arad, Gate Anne Hurd ','Edward Norton, Tim Roth, Liv Tyler, William Hurt, Tim Blake Nelson…','The_Incredible_Hulk_poster.jpeg','2D','Hành động, Khoa học viễn tưởng ',NULL),(11,'Iron Man','Jon Favreau','2023-09-02',126,'Kevin Feige, Avi Arad','Robert Downey Jr, Jon Favreau, Gwyneth Paltrow, Terrence Howard…','Ironmanposter.jpeg','2D','Hành động, Khoa học viễn tưởng',NULL),(12,'John Wick: Chapter 4  ','Chad Stahelski','2023-09-20',169,'Erica Lee, Chad Stahelski','Keanu Reeves, Scott Adkins, Chân Tử Đan, Ian McShane…','John_Wick_4_teaser_poster.jpeg','2D,3D,IMAX','Hành động, Phiêu Lưu, Tâm Lý',NULL),(13,'Fast & Furious X ','Louis Leterrier','2023-09-17',141,'Vin Diesel, Joe Roth, Justin Lin','Vin Diesel, Jason Momoa, Alan Ritchson, Michelle Rodriguez, Sung Kang…','Fast_X_VN_poster.jpeg','2D,3D,IMAX','Hành động, Phiêu Lưu, Gia Đình',NULL),(14,'Avatar 2 ','James Cameron','2023-09-04',192,'Jon Landau, James Cameron','Sam Worthington, Zoe Saldana, Kate Winslet, Stephen Lang, Dương Tử Quỳnh…','Avatar_Dòng_chảy_của_nước_-_Poster_chính_thức.jpeg','3D','Hành động, Khoa học viễn tưởng ',NULL),(15,'IT: CHAPTER TWO ','Andy Muschietti','2023-09-22',169,'Roy Lee, Dan Lin','Bill Hader, Jessica Chastain, James McAvoy, Bill Skarsgård, James Ransone…','ItChapterTwoTeaser.jpeg','2D,3D','Kinh Dị, Siêu Nhiên, Giả Tưởng',NULL),(16,'Annabelle 3 ','Gary Dauberman','2023-09-15',104,'James Wan, Peter Safran','Mckenna Grace, Patrick Wilson, Madison Iseman, Katie Sarife, Vera Farmiga…','Annabelle-_Ác_quỷ_trở_về_poster.jpeg','2D','Kinh Dị, Siêu Nhiên, Giả Tưởng',NULL);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-07  2:12:01
