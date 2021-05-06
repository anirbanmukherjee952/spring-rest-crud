CREATE DATABASE  IF NOT EXISTS `web_customer_tracker` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `web_customer_tracker`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: web_customer_tracker
-- ------------------------------------------------------
-- Server version	5.6.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;

INSERT INTO `customer` (`first_name`,`last_name`,`email`) VALUES ("Amla","Ismail","natoque@porttitor.net"),("Aafreen","Kumar","aliquet.nec.imperdiet@nonquam.edu"),("Minakshi","Ismail","Quisque@molestietellus.edu"),("Surekha","Singh","mauris.a@Aliquam.edu"),("Ranya","Kumar","Sed.et@arcuVestibulumante.co.uk"),("Kanchan","Kumar","odio.tristique@dictumProineget.co.uk"),("Mandan","Raj","Suspendisse.commodo@rhoncusDonecest.org"),("Tejal","Khan","et@netusetmalesuada.com"),("Jasoda","Ismail","semper@magna.ca"),("Rahman","Ismail","feugiat@nislsem.com");
INSERT INTO `customer` (`first_name`,`last_name`,`email`) VALUES ("Induja","Khan","massa@interdum.edu"),("Ojal","Ismail","scelerisque@Morbisitamet.com"),("Apurva","Singh","vitae.nibh@leoCrasvehicula.co.uk"),("Abhilash","Singh","vel.turpis@vitaesodales.net"),("Rajanikant","Ismail","Curabitur.sed@imperdietullamcorperDuis.org"),("Devadarshan","Raj","quis@Phasellus.edu"),("Dilip","Jain","eget.odio@at.org"),("Jaganmay","Kumar","nascetur@convalliserateget.ca"),("Mahitha","Khan","tincidunt.nunc.ac@Suspendisseacmetus.ca"),("Radhika","Raj","eros@egestasurna.edu");
INSERT INTO `customer` (`first_name`,`last_name`,`email`) VALUES ("Tridib","Raj","Vivamus.nisi@laciniaSed.org"),("Ayog","Patel","Etiam.ligula@ornarefacilisis.org"),("Angada","Kumar","sem@NuncmaurisMorbi.co.uk"),("Poorvi","Jain","magna.malesuada@Pellentesqueut.com"),("Toshan","Jain","Sed.nunc@scelerisque.com"),("Siya","Singh","Sed@aliquet.net"),("Vahini","Kumar","est.Mauris.eu@temporarcu.com"),("Keshini","Ismail","amet@fermentum.com"),("Namrata","Kumar","Sed@semper.com"),("Adinath","Patel","rutrum.non.hendrerit@musAeneaneget.co.uk");
INSERT INTO `customer` (`first_name`,`last_name`,`email`) VALUES ("Sibani","Jain","ante.Vivamus.non@Proinvel.ca"),("Mansukh","Kumar","orci.Ut@odioNam.net"),("Sabita","Khan","justo@NullamnislMaecenas.org"),("Thooyavan","Patel","at@liberoIntegerin.ca"),("Kilimoli","Raj","vestibulum.neque.sed@urna.co.uk"),("Aghat","Raj","ipsum.ac.mi@ametanteVivamus.com"),("Dhriti","Ismail","gravida.nunc.sed@per.com"),("Bandhu","Ismail","Aenean.egestas@magnamalesuada.com"),("Jayalalita","Khan","ipsum.sodales.purus@Craseu.org"),("Tanmaya","Raj","sit.amet@ipsumCurabiturconsequat.ca");
INSERT INTO `customer` (`first_name`,`last_name`,`email`) VALUES ("Kanaka","Patel","pede.Praesent.eu@maurisut.org"),("Sudesh","Kumar","sem.semper@estMauris.org"),("Gathika","Singh","vel@sit.org"),("Ganaka","Kumar","Donec@magnamalesuadavel.com"),("Suhail","Raj","felis.Nulla.tempor@acsem.org"),("Pavitra","Raj","lorem.tristique.aliquet@enim.co.uk"),("DuraiMurugan","Patel","penatibus@primisinfaucibus.org"),("Niyati","Raj","id@rutrumFuscedolor.ca"),("Dakshayani","Jain","enim@at.co.uk"),("Kamini","Patel","tincidunt.nunc@velitduisemper.ca");
INSERT INTO `customer` (`first_name`,`last_name`,`email`) VALUES ("Tapasi","Patel","placerat.Cras.dictum@imperdietdictummagna.edu"),("Mukul","Singh","ut.nulla@dolorsit.edu"),("Krandasi","Singh","sit.amet.faucibus@vestibulumMauris.co.uk"),("Amitabh","Patel","non.enim@orci.ca"),("Dayamayee","Raj","Proin.sed.turpis@ProinultricesDuis.ca"),("Abhrakasin","Kumar","luctus.et@Sedpharetra.net"),("Iha","Kumar","ligula@sagittissemper.org"),("Jyotsna","Kumar","Mauris.vel.turpis@blanditNamnulla.com"),("Ganga","Raj","magna.Sed@condimentumeget.org"),("Kantimoy","Khan","diam@cursusNunc.edu");
INSERT INTO `customer` (`first_name`,`last_name`,`email`) VALUES ("Hiresh","Patel","interdum@egetipsum.edu"),("Tushar","Ismail","quis@eleifend.co.uk"),("Pranay","Raj","Etiam.imperdiet.dictum@Integersem.net"),("Uday","Khan","eget.massa.Suspendisse@veliteu.com"),("Sona","Jain","vel@at.net"),("Syamantak","Kumar","vulputate@lacus.ca"),("Kalpana","Jain","quam.Curabitur.vel@tincidunt.ca"),("Somansh","Ismail","nisl.Nulla@erat.com"),("Trusha","Jain","Integer@ultricesDuis.com"),("Arka","Kumar","arcu.Vestibulum@Donec.ca");
INSERT INTO `customer` (`first_name`,`last_name`,`email`) VALUES ("Rajdulari","Kumar","nec@aliquetliberoInteger.net"),("Balamohan","Ismail","in.faucibus@lectusNullamsuscipit.net"),("Jyotika","Jain","sapien@leo.org"),("Mukul","Jain","a.mi@quamelementum.net"),("Shailaja","Jain","et.ultrices@rhoncus.net"),("Gandhini","Raj","sapien.imperdiet@metus.edu"),("Nahusha","Ismail","Sed.eget.lacus@pedeCumsociis.ca"),("Urmimala","Patel","ipsum@ultriciesornare.net"),("Pranet","Patel","lacus@ligulaeuenim.co.uk"),("Kinshuk","Jain","pharetra.sed.hendrerit@loremauctorquis.com");
INSERT INTO `customer` (`first_name`,`last_name`,`email`) VALUES ("Manoth","Khan","consequat.purus.Maecenas@ante.org"),("Punam","Singh","ipsum@dictumProineget.edu"),("Kanitha","Patel","adipiscing.non.luctus@nisl.org"),("Vaishali","Patel","pulvinar.arcu.et@justo.ca"),("Sashreek","Ismail","Nunc.sed@montesnascetur.com"),("Hemanya","Ismail","pede.blandit.congue@Donecnibh.ca"),("Yajnesh","Ismail","amet.diam@nisiMaurisnulla.edu"),("Kusumakar","Khan","Nunc.mauris@volutpatnuncsit.org"),("Chiranjeev","Kumar","posuere@molestietortor.edu"),("Mehal","Raj","nisi@vehicularisusNulla.com");
INSERT INTO `customer` (`first_name`,`last_name`,`email`) VALUES ("Satyasheel","Ismail","luctus@auctorullamcorpernisl.net"),("Atulya","Ismail","lectus@eutelluseu.co.uk"),("Prachur","Singh","Praesent.luctus@aliquetdiam.org"),("Dharmachandra","Khan","Cum@elementum.com"),("Chandrashekhar","Kumar","eros.Nam.consequat@ullamcorperDuis.net"),("Mannan","Jain","et.magnis.dis@et.com"),("Jaladhi","Singh","faucibus.Morbi@augueporttitor.org"),("Mrinmayi","Kumar","mi.eleifend@purussapiengravida.com"),("Marisa","Raj","aliquet.molestie.tellus@telluslorem.org"),("Meghamala","Khan","non.dapibus.rutrum@lacusEtiambibendum.ca");

/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-24 21:50:59
