-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: arenadatabase
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.25-MariaDB

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
-- Table structure for table `adstorage`
--

DROP TABLE IF EXISTS `adstorage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adstorage` (
  `adID` int(11) NOT NULL AUTO_INCREMENT,
  `roleToSee` varchar(200) NOT NULL,
  `topBannerName` varchar(200) DEFAULT 'default1.jpg',
  `bottomBannerName` varchar(200) DEFAULT 'default1.jpg',
  `leftBannerName` varchar(200) DEFAULT 'default1.jpg',
  `rightBannerName` varchar(200) DEFAULT 'default1.jpg',
  `bgBannerName` varchar(200) DEFAULT 'domina1.jpg',
  PRIMARY KEY (`adID`),
  UNIQUE KEY `adID_UNIQUE` (`adID`),
  UNIQUE KEY `roleToSee_UNIQUE` (`roleToSee`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adstorage`
--

LOCK TABLES `adstorage` WRITE;
/*!40000 ALTER TABLE `adstorage` DISABLE KEYS */;
INSERT INTO `adstorage` VALUES (1,'Player','testAdOne.jpg','testAdOne.jpg','testAdOne.jpg','testAdOne.jpg','domina1.jpg'),(2,'LeagueOwner','6359619425121062721069548878_Patrick-Star-Meme-I-Have-3-Dollars-01-1.jpg','testAdOne.jpg','testAdOne.jpg','6359619425121062721069548878_Patrick-Star-Meme-I-Have-3-Dollars-01-1.jpg','domina1.jpg'),(3,'Spectator','festa_pokemon.jpg','space_rainbow_by_sanlea-d3bh1fw.jpg','space_rainbow_by_sanlea-d3bh1fw.jpg','space_rainbow_by_sanlea-d3bh1fw.jpg','domina4.jpg');
/*!40000 ALTER TABLE `adstorage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `advertisment`
--

DROP TABLE IF EXISTS `advertisment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advertisment` (
  `AdvertismentID` int(11) NOT NULL AUTO_INCREMENT,
  `users_userID` int(10) NOT NULL,
  `AdvertismentName` varchar(100) NOT NULL,
  `image_blob` longblob,
  PRIMARY KEY (`AdvertismentID`,`users_userID`),
  UNIQUE KEY `AdvertismentName_UNIQUE` (`AdvertismentName`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertisment`
--

LOCK TABLES `advertisment` WRITE;
/*!40000 ALTER TABLE `advertisment` DISABLE KEYS */;
INSERT INTO `advertisment` VALUES (48,900000029,'festa_pokemon.jpg','�\��\�\0JFIF\0\0`\0`\0\0�\�\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342�\�\0C			\r\r2!!22222222222222222222222222222222222222222222222222��\0w�\"\0�\�\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0O\0\0\0!1AQaq\"2��#BR��$34brs�\�%56CS�&c���\�Dd�\�\��t񄔲�\�\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\06\0\0\0\0\0!1\"3AQ�\�#2aq��4BCRS���$�\�\0\0\0?\0�ߓ\�Ѫ��\��\0�Z. ɠ��\Z�\�\�\�\��_�����\�?\�2���N���E,ϐ�0\�\\SM�a\�D\�:6w��p-\�z\�\�T�$s���E��۔b�H\�P���\�O�6\�p\\T���\\)�F�߂eԛ�\�\���B\�\�\��\0I��\"y\r*6\�Y��(�\�F�b�H}��V� ��\��Wˢ/9p9R�(��\��)�<�c\�}P\�P��\0=�>6-9Vl\�zMP���\0�\��ˎ�\�\�m��\raoz\�\�s��\�c�{�[\�d\��J.N7I8\� �_앩����v`���Z{)��?݅�c\�3/�Ac�h��\Z\��;)D\�4g\�h\��n���Hj�\Z�\�Ą\�=�(����O��#)aH��\� �q�XS\�@d$4N\�-�.����@ {����\�(\r�Ƥ~M(#>�]�.�\�T<\�#%#\�/�ӈ�\�\�+��:\��p\�p\��p\�]�\�@\�9�W�0(���g�WA-��\�2o\�!ze���tP\�Ð\�\\kiR��6��h�u\n�\�\�_n���D�	\"�\�\0m\�0�6LѢ�S\0�w��O�dB;���\0�`%� \�#�4O�,`\'\�@\"|\�\'\�#��R\�|$ \'Ɗ@\'@E��D\�l߽j\�cE��E�\�M�֦ˀg��\�NwIWn�O1U����3m�g\��Jz�Ӝy-E\�f\�u��fU�\�ZI~\"Q\�3\�?^�����\�(t�N氆���<�LU��k�|UB>\�^�񳋟#�I%t�c�:�\��%F�p��9�YG\�g�\\`�%�\�i�k\�M+�}$���V\�\� \�	�T�c�\�\rUء�\r;Slq\�D�\�k+�\�\��ix \�M����\�WgC)�9\�\�uW$\�M��\��w�\�~\�\�h��yZ�\��\�N1\�ˎ��\0η��\rK�����T��n��\Z����\�$\n8	\�d\�\�\�J\�Y�\���af:�-�����\�촬yfe�&\�{h��U��5U\��\�t\�\n�ZFa-��\�`�Ԁ16\n�\�,�`��|j�	uO�\�\0�Hl�\�<t�f{Yw$�T7*[�n��a#\ZpNdv%��I$dA\�\�$Ԉ9@\r��O�,{\�4�*[I\����\�j8[\�qrV\�D\�\�@9�棜��$q\���z�zEn|J��E�\��Me�T;�\�\�i��IOd9!d\�>\Z0r��\�K5��y2n\�Ž\�ֹAY\�0���\�co\�\�\�1\�\"�\�\� ���;�UQ��|\n��pm\�Ы�\�\�\'�3�\\�hHN��B\�|\'\�Cܥ�S�\�u,$�	�\Z\'\�\0`�	�O��8\�|h��K	�\�>d\�%$�I��\�|��\0r\��\�V�\Z��\�0\�\��֤�3\�\�$wIWo~O�\0E�����-E\�V���\�O�K\�\���fI\�eo<շ�F�A\'�\Z�(���\\ue/f\�n#4&�bV\�l���n\�+��sڏ\�W%�\�;��\'g3\� z�V�3-#\Z\�H9\�\�Y\�m|\��g\��L�B1$ߴ�S;��pN>�$�D���|���\'#T\�?)_y�h�\�;ȫ���*1\�\�H%\�cUni�|�{K���\�%$5�~[T?U��A�\�\��˭����oT.\\A�\�mw\�\\�\���u�;\�@Zo\�5v;�4\�\��]�\n6iG���H��G\�D\�%�D!�Caа�j\�g�\�XH,\0m\�\nҲ噗\� \�B\��\�tD\�&\n}�B�� �e8\�.��H�\�%�\�@�C.��kcC\\C\�v��w��\�\�\�\��\r�Ui\�!�\�5�԰TN\�jW��|;�;��\�\�\�|RMd\n�\�[/�W��\�V\�=��%{��ڛ�C\�@\�\�p|>�[-19�\�+�\r\�\���GܟNjqR5kB.�M(RT��2\��O�\�� 7*I�,��3#\�k�%#`Q�ܣ�ۤ��p0\���\��C=��\�\�̕\��U\�&���q\�ϣ\�yco\�+Q\�@��ځ�T\� �\��K�i)\�e<\���4aw�L��S B\�|\���\�60|��\�(��\�u\�Ղgs\�\��]ܵ�-}z.\�WW\���ý�Za�[�K(�\�n�%y`5\�;x\���\�\�\�yO_n\�]UU\��upl\�hg\�*��R��\Z�a0\�H� 0�>7 $\��T\0�0�2�\'Ʃ\0��\nr\�Dd\�XRO��C+�?ة�\0zխY?�\�T�\0�bF��wI\'n��a�\�!�$����Z˰Ůe�\�?Ф?\�{��\���)�Y��\�Z\�\�\�\�?\�j�:l��\"�\�L�F\�\�\�]]IL\�f|�UoU*i\�\���\�Z<��g�ZC\�&�\�4\�\�SL�\�\�y�.j\'M��}\�g٬�`���\�[��K�h��\0�V�4-\'.g��,g�d�\��\0\�=���آ��5-�\0Rq\rF\��+�{QN͟N�\���E=ī4L��J�	��\�<\��G%7\��r7\�\�Y\��\�!\0)\�я2�����c̮�\�D\��2�	\�I�\�\"tn�Gc\�c7�g]\�\�д���Z6\\�6��n\�Q\nc=V���\nA��Mȣ >�$鎥#u\�t\n\�vw9��v^t|�\�מ o9����fϘ�����x1� .뜂~*>\�Β���j<ɖl��\�t�����wS洲\�\�K��\�h\�;���\�<|��=��\\��9��\�\0\��@�*\���Ւ\�^��,\�\�JJ\�-T\�\\�{��Ѯ��ҾY\�.{\�22�S\�±\�\�_E�U�\nh\��\�y\�\��Nzg\�^�K��Wip�{vS\n,SW�\��F��CZI \02IF@G\0�\0Ԟ\�\�\�Yľ��\�ѿ\�\�I\�=�O�8�\�\�Pп�����\�.\�yn�2���:&���k\"�Rm\�\nt\�Nu|\�U\�[M�6\�\�\�hEbdQ�601�\0t]p��p��aH\rRƩ� �H � 62��S\�\��I\��\�+\"i�C�h�\�Q�l�hS\�lW��~\�{F�BO,��{ת\�\�D�\��,\��1\�\n&�R��\\ <!\�&\�Q�uk��{�\�\��\�ܣOK��Ф\�ps�\�����I�B:�d\0��4K�> ��I\�\�@t�� �\�E.�,�\�G�*ޱj��S\�#��?\�X�\�g��\�Iۤ�#7���\0}�;ֲ魲|�\�|	���\0\���w-u\�[t\��e\��ko$\�ip������Tmok,\�䝚T�q��v�����9˗���r�\�\�\��\�!q��\�\�\�P\�V\�Sp���>�	բ�le������\�#/Mٗ�Җ\'\�[Z\�}ulSMJ\�Kˑ\��\�%L��\0=�\�];��Ѹ3���\��\�\�\�Ѹ\�꫏-W\'[TE�s�nX8�H��\0l�\n1ިᯕ�2\����B.\�@*\�dPR����|�\�/!)\\7��\�󊢑\�\��\�\�B�K;ei\�\�Pz+\n��6�H\'\� \�e\"R:���#�Z�i���r�e��~�\�\�Z\\�6��\ZhST\�\�ɚ8R�\n������T\�����%�3CZ\�?U�?�Mԃ)I$�4jI\�[\�\�44y0z\���\0�\�����_D�gGM�\�XG7ܸ��:�WCM4dc\rhv�G){�(\�~&\�K4\�6yXQ \�.v�\n\��[䜵�X�Z\�j�\�_\�E4q\�T\���5\�Gr\�\\�\�\�1IFK�\�_.4>KeX!	���\�4��뜯\�\�s�\�(\�A\�RCme\���.�Zr��)�ij7�USIHUP\�$��\�\�^$\�5�Z\�^��@��\Z���\�\�\0F����\��{}5ʆ]\�H\�\�\�_s<�\�\�<T���el4Ξ�@\�4u;�fY\�i��K+�#h\�q\�\���[��KF\�GK�d{R*�\�\"��\�6����D\�\�\�|7�\�-��0IS�Yъ\'-O�9�\�\�\�.l\�ڎ�ĭ�q�45���\0\�6�Eӗ	\�J!�!�\\��	\�lh��,��29NT\�@\'@`l\'N�\0C\Z\�|e\��\�гM捿�[\�\�\�2\�0GzkY��O\�\�m�x\��Ԯ;��i\�^eż6\�U[�iZ}Gg-�\0\r\�E\�<D.4�\�ң�p�cf�j\�A�Rʐ	�\�,$\�\r\��?T���\�|e [�a6\Z��H�\�\��\�-vK\�#��?\�X��\�v\�&;��#7�\n?�_�\0\�u�Z��t\�*\��/�\\���?��ǡ\�\�21�zʸ�M{_(s�\�\�͡}葷\���0��b\�)���m�\�\��F�Q�ZL��q�\�\�4��\�L\�:!T\�\�\�\0:8�mU8$�uF|2��xYe\�8�\�S\�^9A�#h\�\�3OQڂfAr�sݻ�E�&9\���,\�6�V�3�\�\�\�&L\�\�\�]\��P[\�\�4\�\�\�3�u`\�\r���\�^}\r\�Ӏ�5\�B,\�\��\0|[�Ka�{����\�<���/��������\�k\�*\Z{FFp\�\�M\�\�\���&K�OEuܔ���\�A\Z\��it��<Ü�*�n�Yz\�=�$�խtY\��ޭ\�3\'���x�ʴb\�\�w�*�F`���3\�ˇ5A*��\�i*�Vq\n�\\���FÐWP�5�ҖG\�E8H(\�c�\�\�iY\�Ֆ׿tj�\�((\�k\�T\�1?�W\�2f_<,�\n\�胦q\�:5�.CΗGfG�*c��\�y���R\n��j���\�c^_\�Rp\�ҵ��us�\ZuS�s\�\���U�2%)Oh��T����\�w�s8�ʺ\�c\Z�y+o\�ȋs\�\��l\�\�>\r�*\�MX��#���\��\�aQI\��t��rX0�۵�\�*U;mVL�p�����1\�\������$�ff����K\� \�G(\�a>�UIEu�~[G�c�ZY�\r\�\�6�\�\�\\-��j/g�)\�\�\�\��\�t*�\�p��H捘^yG��Xc�OH��T��\�w�Y\�\���W�`w���\�L���%�R�r\�g�\����uZ�kE�|h\�9\�\�\�\�\�\�tZ\���\�;,�61+�I*����M��M}\�Jꊗr���y�\�\�_ķ&\�A8�!�\�B�x��\�yc\�\�\�c��\�p��\�H$�U\�2\�}�3n[#4n\�xm�eJ�Y\�\���k0��=, \�!�[#\"�\�%\�c�\�\�7$�3�^\�鄕r\r\�# y�d�\�.B�RY�\0��9e�6�\�ϯ\���{\Z�`g��=�G�5n1V�\�!�p����-<����NWl\����t��D�>�5\�\�A%<\��A����l�\�\�144�B�\�w/`ƨ?\�[y�IO\��\�d\��=�\�\�Ů:�\�?�⋌/)\�{��Kɧ�-�WrH߲\��\� \�\�2\�jI��Ja8N�\�X�K)�L��K\�$�,�\�O�&ޱkp�)_܉�\0z\�1\�\�t�v\�(\�\��kh�9��[-}i��}3\���?i�\�	.lr˒\�\�F�\�a|��\�\�+\�\�5\�.y*5h\�U5\Z4*�\�IZ\"}\Z��!w�ۀ�U�s=\Z���E*\���\'j#e\�ۤ����K���,x2�p�\�xI�\���F\"�}4�p�G�}?\�*��Ka�%.\�9\�\�ߊ#B�)\'\�\��ְ�dN:F\�\�#��\�z�\�Z{x�f�˸Q�q5��N�\r���9�/.-\�r3L�����~\�D�\�.��9$�<��5�\�\�(\�Ż]\\\� nIieF	#a�����J\�f.�-9�\\0�K]30F�\�\�	R���\�Az\�\�2\�9\0\�P��&��\0�Ϲ\n\�>�G�F2�\�X���Cݜ�\\1�K�Y�\�\�wu$�{\Z\\\��M(\�l�nʅ$\�}u0:�\�\�G�4\�R�k	y\�\�Q]Ṟ-\n���{	\\\�朴�L\�\Z\�\�q٭\'ܳ�\\sX\�\�\�aq�x�\r\�]�U\�L\�KC��Cm�j�\�橅\�\�0��w{��f�\�\�\�6a\0{��zm,��\�FoDK�-D&k\�i$q�\�w�KF:!���:�i؃\�ꊴk�9Mb(^\�>�nm\�\�=3��R\�\�\�B���\�S=[+�\�;#���s�Z\�;`\�I�$ч�L\�|2;\�\�+�Ɗ\�UJ\�?��\��U\�Ί\�[��5�1l��\�j*�\��o��{,W\�\�)d�\�\�\�Oy\�C�\�<���E��\�\�g��\�\�ʘ\�0\�껨(��\'P\�ɢ�\�6^��\�\�~족\�<5F��>Ƥm�_\��H�F[t�M\�\'�\�)jij;	A\�w�~\�R�\�#\�-\�=\�s���W\��\�\�]3r\�\�\�iΩ���VE�\�+�@\�QT���h\�\���m8\�\�\\\�\�\��@��^�э�+]hm\�S3@ƀ|\������:\��4*i�\'\��s����K�(����\�2\'\�ӟ�5.#	(��Ɠqr�5�\�CK�ycr\�\�\�55n\�\�}\�\�&Ѿ\�T#���{*.��\�01�At��S\�\0\���FIS��dg\�\�\�馲ƒ�J��\�\�IS��}V�B\�3e����F\�.\��\�\n}\�\�3�p@\�\�s�\�\�G\�\�1�y�%ii�JEZ�\�}:�\�\�b��\�Dy�tR4\�\�wO#\�F�:�獱K\�\�5s\�	>sou-��\�&{\�xp\\���\�q&i��\0\�c�gy�J�\�H\�tۉON�e6\�jK��mH\�\�J�\�6(�\�\�\�z͆\�3\�BC_�-��m,\rg ���pFWolR	h���A�\�Ϫ|\�b�\r�\�jAeK,\�P\�\�\�Y��7چA\��\�*�\06�۬rD\�/�a�\�:\�t-�$j�jʛtq���m�\�\�ǻk��T�V�%� �}\�8\�l�k\�\�\�PA\�tI\�D7O\�)�=\�\0�>=�\nJ�W\�1�;\Za\�Q\�_�쑗�3C�oVx��W�\�Sq�\�9\�\�X����S�\�2��\�	�ą=D\r�˛N���O|$�@E �\0A$�\� +%��ȟ��Z\�5��J�\�O�\�$b3���I;t��C�5-���F3\�Z۬lmڭŠ�\�BVC\�\�!�w�d~eu�Փ�Z�Q�^���IL\�n�`\\*i�+��8j�p�\�\���\�\�JF�w\�m[T�i&b\���^\0��T9��]��\"��l- �\�m��Uk�\�CR0[ \�\�V�t4�\�E�)���c�pqܺ�\�\�\�!��]iclך�8cDO\�\����,��nZ��s3񻳔=�!\��w7	�\�p\�_T\"�\07S�h\��]\�k�-���\�\�U��B0`JG��\��LQ?��e�p�\�h#��HC��[����\ZK�,,\��\'_V\�?!w�\\���\0��\���\�?\�T\��s2~��)�<��Y\�Cu�h(�c\���)�\�;�NUg�\�N8l\�K\�5�0AW\rD$=�\rp!\\�pĐ\�\�\�$��\0vA+C\�2�,4����X\�Ԃ\�\�9��\�E�\'���\�e�T��\�itc���U��wjz�0ɻ\\\�}\�z4�GQd�a\���{�WHf� C)Ú㷑袝��Q���nF��x煲\�\�\�w�]�C�n4p\�\�\�\�V�\�qenM$�<\�f���fOd�\�Ѹe�iSFyأ8�3X\�L\�s�\'�$\0z��i\�\�b*)�$����\��,�^ݏ�\�A\�W:v�V[�w�O ���\��L�F�k֟��W�*sC&�a�\�\\�Cs�im-\0�\���\�	Mo�Ua�\�\�\�!�w�Ow�6�C�W�[\"��B\�[�:ɍ=�h�7̮\�U�gk=\'g԰%a\�+y\ZK%���4��x\�\�I(�P\�{�۔wW](]A,m����܏M�jE$��\�!Elm\�\�\�1S��\�\�9\�\�\�\�t(��;�T�^��阎|\�\�\�\�Jv\�}��㼣׹;��\rK�o�2\�Xeu-\�\n�r\�\�ψ*W�4�Ԓ�y=��L�\�Ԥ{b�\�<\�%<��3\�\�.��\�ٰ\�!q\�h\�\�\�AD`Y�=K�.�>(\\n��ͫs\�OAޡt�4\�@A��o\�銜\�K��Z���4�H\\.f)E-(��N\�\�J\nf\�\�=\�\�3���J�K���_#�\�}U{�h@lcGN��ê�9ʬ�z\�ڍ�=uy;\�,p��G����.,���~KK4�\�\�+~%��SD\�$�\�M\��\��H04a�\0���\0qJ篼\�2�\�(�\�#�Aq��le\��Z\�~\��`$�T ���R\�oy�\�G\�\�\�\�fw�Lxz�k�1Ք�\�(��XN\�\�؃\�+\�:�KMl@�jYP\�=�ۂ}\��!��>�vM	m�֦��1\��\��x���x\�sC�wb�t�<z�g��E+=\�\nYC���\�1\�!\��\�\��-�N�\�a\�\�\�-D�$��a\�ݎ?\�\�k���};ݙ\�O#�\�6+2\�*��u#F\ns�(=0�Js�!42Dv{KJ�h$6�\�=��\�\�G\��Ke��t��(\�Ȩ�H\�\��!uB\�U�d��r\�QA�\'�:b6N�$�\��O�d\�,�\�W�\"ޱkVK\�\'��Q�\�$�\nwI#�I�fӂj\�OLp4mC\\Nv�-\��S�\�b|nl�Û�ǂ\��[#6*���\�\����Q�\�:Nbꇿ8�\n�\�F3i��\�A9�3O�T\�/�\�ca.Ƅ\�\n�\\\�ᶘf��{^t*�udN�\�ss�ZNV��\�e�Wp��\�\nGw\��\0ԹW\\L�6>Ȍ\�\�s⚂�\�)\�j\�9����{�U����\�7h=����\�֥��\�\�ѩ�6�Tʝ7j7�\�P\�SGx�i\�b�\��s\�@\�\�S\�ER>��)e��\�\�ZpZ��ܲ1tp�����\�\�I�08e�0�4;�\�ፇ:�\\!4��\�s�t\n��c�9��\�C���,pv\"\�A\�T>\�G�;=\�*~\�\��\�>�^4\�L�\��\\\��\�s�\�\�4��g\�����vPg_\�)�\�=\�2b��������\�\�ۮ\�r�\�3Ap�[J:\�\��Q�Vže\�K�CMf^Com?7@\�7{��޹\�D*)������+\��GM;[#$nh�\\2B\�E-��-�\����g\�Y�\�d�27{p��ȏMa=\�d�MW\r\\BH]�էv�\�g�Slk\��g�=H�\�\Z;��\�F�+\�\�JN�\�;ȥB~�2�EY\�\�1��q���[�\�\ZV\�\\]8nCCIǽ\r�M��K��\nx\�y�\�d�*p�pl����G�\�\�!Jjk\�\�%t=��`\�;ޛ��\�\��m\�*{�#j�\�\�\�o�\�^�^on��Z���\�Fɩ�\�8\���\�\���0\�ҿ�d���d*�O&�*&�4�*wJ\�[\��\�\�`��OŴ-\0SGQU!٬��<\�\�	�J��G�W�\��������u0�UEn*\�\�E�s\�/w⳶�\0\�Z\�\�\� �\�\�LUL3�S� �Vv旅B]Vޥ�\�\�\�nQ\�\�\�xdBG�5���Ǧ�#|�\�]d����R����\��7·t�uҵ\�<��%s~�\�Sm,Mte�\0\�0��B]9^\�G�rFy��\�v��7\rj\�2V6�j�e{���Ai�쌫:�TU\�\��js��\�Vh-ϞQYX=o�\�;4w��Q\�\\\�鵇~|�T\�\�.l����\�=]\�\�YcZ\ZѠ\0h��\0���)��f\�]Ը��1�Ω)\n��L�\0�$\�\�t\0�I,$�-!\����\Z�Xm\�H/��cjH���\�\�B���\�E}���ڗ0��(��\�r֦�`44=1ާ\�\r�\�\Z�M<��\�y\�4D@LO&�\�]F���\0j.\����`�_�\'߮2��\�\�Ɋz/�\��\�F���\�c\�zǔ}�ˀ%��\�I\0,\'\�3�\�\��Ԕ��Rd�*��z(�\rC\\GFz߂��\"���L\��p>�\�R+�=S�\�O\�(��b x�k�G�\�c�\�.�\�7\�\���2O6SUh7���\��\�n\�$\�䤤�X\��<2\�*L��\�o\�ܶ-��\0b�c�x��\�:YZ�%\�>B� �\�3\�s�\�:�z\�\r[o,&أF\�\�\�\0賯\�\�f�H\�2\��-\�ԥ�(tȟcO���Z,�\�\�g�\�.�\�\�6��F��\nW��pj�*�[�\�w;�hx�\��O\�*q5�S�=џ\�\n�UԵ짍\�NI\�@\�\�Ƣ�w����\�ٓ�a\�\��,��W\��a#;?�\\\��I�\�\�Ub�c�yEj�T���\��-\�))\�\�#1\�ʧu~-�x\�S���QC!���S\�\�*sܪ=Jj�H�h~*�Y:�\�MB�� 朗y�;.p9�i-9\�u*DY\\*�$�M�]�|8&|�#v\�N��D}�4�댅֖N֚7�\�\n\�\��\�b\��O\rL\�[�,��S��¾\n\�S\��i[#	:����eL\r���vq\�\�\Ze9\���\�h*F\��w�W7\�h\�\�3ߣ\0\��^�z�!%ɼ��\�<�yNټ2eJR����C\�,��\�;�\r�\�;fE���{],�\�\�卻\�/�\������T�e��\�~\�\ZZ@E\�CR\�lc9�.6�{k],�\�c	�\�����\�\�@0��\�\�>�\����.\�5\�\�\0&29%\�(�װ9�-p\�)>6\��x\�0BA#\�\�o�\�\�N=Grn\�z{�ܹ\�(�=\�r���\�\0\r\�z\�s�\��:��$c��F{�^jg:�&�\n�����\�\�dS\�鏆��lbj9L�˄\'`�\�RK�\�t��g�(��2L�l��}�8\�F����u�m�\�-C\�0\�\�W;4���|�Z\�C\�\�5}�\�\n�s.\r,>�nwwL�|\��S\��\�_3c���\�cS\�V�x�\rǆ��� �ZU^\�I$�\'	:I���:@t\�\�YI$\0��|�*�\�\�\�V\�\�r\�\�\�\�RIe��$\�,G-Ɯh\"�v��\�\���/����\��#�\�F�^R)\�k[Ak��q�c<׊��\�u2O\'\�V�\0\�\�\�R\�m�޼���=c�(p\�H����\�8\�\�E\'��\�\�S6��\nq����r�\Z*�\�z\nwMQ cGN�\�=�M�Z����zJ3\�\�9\��Ԭ\�UҺ\�~�����\�p�\�\�N\�[�w��U�t�ȷNս\�~{\�l\�=�[\�\�ʓ�I�g��\�?�K	�)֔�p��h\r�Brs�\�\�YO�\�`���&ґ\�g�\���.?\�j �\�3���5g��\�M�\��\�\�\�%$��:���zwI#�K\\\�4\\9Fj\�f\�1\��o�\��\�\�v>�c�\�p\�>j�?\�G\�gדSf������\�\�\�&�\�\�5�\�Ћ�U�2\�@�a����\0�.O�i\�3\�\�p\�,�S\�\�\��k��\�\�U	�OaȊF���uNH;�\�1p�TuWJ!�\�20}Y+A\�,�A\rK��b�MM���\�Em����}o\�;�T_\"i�\r4���\\k)T��VF�.Y\�J��L\�\Z�g\�\�;�i╓F\�s4\�MiŁ���\�\�9�\�\Z?�G4�ˍ7h\�\�1���A\0-����~�=\�\nH��^\�\�D{9e��9j\�*��\�x\�\�:nU�Z�*&U��ܤ\����6˘�&�\�;\�`ܕR�\�r�R\�HƝ��r�{��\Z�p�\�\�!�\�RU\��\�\�H�\�Wn��8Gyg=J\�r{�ծ\���W[�\��Yс����CP\�f;�Q\���7�\�}D=\�ky\��\n\�5ƒ�Hj#y� \��\\\�j�*KT��\Zq�\�TS\�\�����\�o��\�]�� ���	\Z�\�7c�=�|P\�\�d��5\�T�<����\�\�Jp�\�ܩZ\�3\�<�/3�+T\�<s�r�>+1Ct��\�\rw!� �ԭ=U�\�٘�\�\\!\�@ѿ��e;�g���yd\�2\�\��muN��gշ�8<�+u\�\�\�A\�z6\�\r�\�b�\�n\\\�A3�a�W\�TQL:\�\�3\�t\�\�<>�H\�i\��\�T8�(���6��9\�\Z��QO4�q��\�\��7Ȯoy�\�\����Z�Ӗ\r�#�-�;�t1g�\�@�\�\�\�p\��\�D\�L$=�=B�+E�\Z�K[V\�sy��X;�d���^\�\0c1�U\Z�2\�\npT��w�kMm�W9���Tt\�з\�ax.q}M>}Y\Z\�\� \�M\�.V&O:\'L6IHV$\�\�)�K($�Jl\�QӦ\�nv�\�>)EH�uϴg\��\�\�H&�\�0�\n9���\��	ѣ)�\�f�k�\���\�\0�\0�]n�Y\�S;��\�oRP+mʖ\�`}uc�3H熍\�\�XK��{\�Y�oR��y��[�ׅnW	k\�e��ې���zoY�k�����\�q녎\��}ڭ�\�\r\"�#\�=��Y�1�Z>6+Վ\�p��k�t�odw�oo-\�UԒX�ò\�z�}\�\�\�\�~O�Z;�U�F\�\�\�4`4*w�ѷ���K=A\�Q۪r���2\ZA�\�-\�p�=LT\�.�\���\���ҳN�2J�ت\��?:�(\�5���v�\'���%Ƞg\�_U\�\�@\�\'�&e��]Aq�Z�\�!�ٍ��n\�5��0,S{N�.T8�\�)\�}�Ctv:-�\�q� \�\��c#qޟJm\�\�^yq\Z��\�\�0@\�캟ޏ�k�X�\'暞\�\�u�Z���2\��V\�\�D�\�Q;i\�2?^\�ԜCAq8R�UT\Z�A��\�(R\�z��N���q���pZz+@\��j\�ba�\�Q�Q%��4<I �`���m��:�\�*\�\�EY	\0�n�[e�\�Zh�\'�q�	\�V�!׊?I��`Č\�\�/F7��6Ya\�g׌��V��I�c�\��y�W��\�\�+G�\��ٍ`(\�\�\�N\�uz\�F���=|�\ZVJ\�F\�\rxy��\�_+�o�o�om�����\���:��M����r1�+�\�\�ӝG]W@�܁!��V�\�GV\�\�\���=\�UsUV�F��P=b0\�P�\0%%5i���\Z\�6�3��q\��\�\�PMms�����n�PSz5Q�\�\��\0U�h�\�Zz\�z��%k\�\���7�\�_\�ᴱ�\�aUk��q{�Y/���WxYN(�\�\�\��2Nڈ#<�弯\0����k\"�\�5S`2�9\�!\�8 \�T�Q]�wG2\�M��ҩ��\�Т;�}��\�\�4��;B��9p��0@\n\�=U׊\�I\"�\�A{�3��\�´b��k�j�g�g�#�\�KGe^\"���-d,�>9\�\�:�:�J��؄��>\�J�F�=\r[JJK\'N9�����<�\�9\�ѻ�rɆ\�R3!1Fvh܅n�_O�UW8��\�r\�+\�\"s�@�M\�D\�ܰ��(x��1\�c�\�\�\r�aye5O-\�	3�6\�+y-eʪGIB蹆;I\���n��E�d4	Ѝ;��\�+m4����P\�\�w�s�WB��\�䱔\�%�\�c���C��9;ep��\�H�Wy�\\��F��C�<�8�|J$T\�\�\���]\�U/rU���9:\\($wueK���\0\�\��o#�\�\�$�.w��g��-�\���YN�\�-\�r��J]\�uWn7b\��F\�w��3��X\"57	%v�D1\�\�S&�\�\r)n̋뤨\�􊇼�`\�Z^\�\Z�̱\�U4\�B5\�E\�\�i}��\�pR6��onNl+tWj�8[�[nwJ9`s\��\�WM�\���ŭ\�H����C\Z\�\�0ֵT�\����a�/(���%qkv��\�3�Gj=C\��j<i8����r�\�^�2o�Ov���3W�\�f3O2���^�Բc\�\��a��Q\�l\�lT��e53�w�+=IM-mI���~�\�y\�\�\�7\���m<-`\Z�)�d;\�\�2\0ѯR��\'	��9\�8QO�@\�\0I\�,_Njhdp\'��\0\0V�\�S\�\�ٴ�\�YN �����&>T�JM�c�I;t��̾M�\0eT��t�\�ZѲ\���UO\�G_墭�0�1�\�\�eǘ\�{5�$r��\�\�\�t\�U\0\�D�cBrz�lR��J\ZQG34ݺ�^�a=;Ԍ4/+��N\�w\�vv�M�؎\�YeK��D\�\"� R)��\�1��[\�i\0@\�F�\�\��S\��giK+T\�Qy\��?�Q�\�\��%8F\�z�o\�\���\��\�Ր�\����Vw�\��jH���\�\0V�\�lls\�\�\��*�ĳ<\"���+ۦ\�\��\�\�$�\�������#�?D�����M9��\�W�t�\r,k�̞���\�Б(ea5:jA\�\���\�\�`\�ZI\Z�\�\�e���;\�\'+s�BD�(L\�\�-\�@J�}+覦\�n�j\�\�M\�\��k+�>i�u4\�đ�y�Ê-Գ\�zS\�T3\�?o\����\�SAPƟ�\�\�\�\��	�)�3\�\�JY��\�RW1�\�O!�F�Y?J睴�\�,��ٌ0�~+g\��7P\'�`\�\�Ѿj\�j\�\�\�ܫN��ܿn���T\�Ԁ\�$̧�\�u3IV\�����Jd\'���_��V\�`ytQ�ҹ�;tA-�<n32��,�\�Y�\�\�ga\�XF�%\Z\\�K_8�,=\�\�O�\�U7)�fW�\�dy�\�5P��HK@\���I3y`�����Y��1\�h�\�\0��\�T\�r\�?@�բ\r\�\�xIN��^Sr\�l�uO���\"\���p\�-r�5U\�\Z\0�^*�\ZnF�9�,\�\�T�\�\�\�$�\�\�Kd� 	tI:QF\�q�d�E\�ń5\�\'�=\�t����\�\�\'�F\�W�����l\�\�D\�M�Pc�\�s\�d&\��6��V�ј*\�١p�B\�\\0�\�ggg�!��i[�\�w\�u�i!w3	\n9\�R-Q����5Ԭ}%K\rSO�\���:\�O\�*؃eԔhZ|\�R6\�#�����Z�@�^\�\"�Gu�^\�Q{��*,>H8	/\ra��]\�-\�w:9#xб\�P��Ili&�$�6\�		\'\�\�\�^\�YCnҸG�\�NE�r�P�S<\����!?\�.�1�\��\�w\�j�đz�ThI/cw)$\�h��1�ox�*�Ύ��\�2r����\0�\�q�j?��1,Na\�ew��زx�`f�Qc�\�8RM7 \�Y\�*y�앻�\�*gd�\�5�\�^ɚ�����*4��\Zk��6#*aD7\0\06R\n5�)�&\'�0�@\�\"4L��l�˓|n:1^�weE3\�F<;��;F��c�Z���l\�:�\�.ɚKm��Q�\�4��\�\�G[\�\�\�Q��\�UZM\��Q@\�\�hcoj�\��&Cc���h�\n�E���*��66��k@k@�BjJz��\�r\�4ߢEA��\0=%%\�S)]�\�B\�d\�Wj:8�uP\�4��\�\�\��\�\\� ��\�J3�A�\"1\�\�I�`�\�%?\�SD>\�;~!\\����o42A��Y#MvTj��UnIl�i#%���0>}ʅ}ʹ�EL\�.ѱ�\\x�>����I)kQ\Z�\�\�x�[(㆝�\�Q\�\�5�9\�\�\�.�\�j��>\�<��W;ii\�!o3�c{ʵ�6�v�Eo��\�ٽ\�y))�9�2{G$\���\��\\�^\�;��\�l����2\��[^y��?�U\�;�{-�е\�ip\�:���o�Z\�T\��m9*qQAgh�79p\\��U���\�	\�#�A\�\�\�7Zzh�\nh\�8$\r\�\�#Mwe�\�-,��\�+����9��Bؘ\�lJ\0�2�ڴ\�əթ5<%�h3�Y�/%ޮC��p\n�\�]�\����7m�\�\��c\rD\�y��HT\�5?�H�vٳ\�H�A�\n��\�\�9]\�y�h ��ܓ\�d��ե�f!�I\�t�9\�ruQ=�,V\��H2r�l\��|�N�XO�H%\�9�\�\�	*�\"\�GGF�ةd)O]QLG$�����_���2<F�>���\Z\����\�O>9$\�*\�]��\�#Q�L-M�\�\�l2�\�␊Q�K$7C�\�\�sfu%t��\�<͌�\��\�ۣ\�\�䎒\'\�\'\�,������1�%\rz֐9��\�=�\'�?9w���a�!ԒUܩ�\�Ӳ8��\�4�7M`\�ƭ�Άt,��t\�d(���\�S\n�rϬ5XI\n�L\�\�\�]���\��Pl#�H;)D\���r\�����µE\�H�Vz�K�0\�ܤ����\�8�ɾ\�?욝�ڏ-��l�\\���v\�j<�Z�]Ϙ\�k_-\�rN\�@�_��U��ъ�{jg�o�A\\\�VF�Lx�E\�kP�\�b\rt�3\�w\��\��\�x[zn{\�\n\n^͝���}\��	�dU�jxd�\�9M\�B tM��\�2\0u�I����\�[��]/d�\�S\� �\�\nf\�Y\�p�]\�aE�\�G�*HŹ$��IF-�[f���\�O>Ɍ8��%\0,�+\�VZH�etр\�9�Ei)jc��d\�;���*�v�/F�h\�഑Q\���M}5�3Y��:�r��LU�����-��\�Q6\�l����[+9\�Xַ���\��%���ؤ�]\0\�$}�2FvsHTl�sۘ\�\�DLnE�T�\0�^\�i�\�N;Vy�N\\`�i׊iGF\�<�\�!���,�\�H�\0��f\�f�\"��X�d\�\�軃��u�\�iC�����ǙYî�J��\Z�1b�HS\�GCY\�U4L�c}�\�\'(\�\Z�K��\�\��\�)c���\�\��\r9�]\�L\�a��HQN,�a��ᾩ�\�\�V�jQ\�duz���W h\�\��\�ws�*�{N\�$��\���\�\���c\�+#�\�y��³\n\�bhM\Z�\�U*{=\�\�L��\�Y\���Z\��\�\n�uѿ\�XRoЎX��-\"u\�\'�Y\�-Of*�1�\\\�GGN\�\�w{��\�\�l�;$�0�J \�{�\'	P�Gt�@	>ɓ�HN�:\0K�=mu\�投�8�v��G\�uU��?�\\g\�\��(�<\"z1\�#4\�}\�?\�Y\�[\�ϱ�\�\r����\0\�\�{#AK�\�Cݑk\�\�y-3N\�O={�5#ќ\0��q@�eIA;\�Ӝ��\�\�3U�˰Ѫ�\�@\�\�\�j��̢�\'�\�\�>Bޕv�\�\�S�\�K\��Te����n[�᳜=�k[��(�\n�ť݄x���J⤞\�ӥeJ�\�E�\nv\�\�\�3�d\�Y\�;Y\�\�;��v�-�� 7K\nCH)S��NT�N�Ӷx]��#�Zb�I��\��}���oH\r�ԳL<x��?\Z	T\�	#\�\�\�$�\�-��|���?\�U;�x~`\�p\0����\���,��1�־Xʣ\�\�}Wl]\�\�\�\�uN�-E��$�\�,w�2D�S�RK	\0�aO\Z&!\00M�\�\�E\�\rs��\rR�o\0X%\�d�l\�!\rhܭ���\�<�3ɩ=�\n�P�i����|\�n>��\0-�J)-O��\��Rp�\�C��Gz�K,Uǵw%ڇgF�$EP��\�6ɣ\�Z{���֎�gЬ\�\�%\�UUr?��G�\�L\�\�?\�tV\�m��ǝ�.�\�#\�3��d\��7\�\0���h�\�\�G\"�J\�9�e\�W�\�\�\�\�\�8�\"\�ڙ\���K	ˆ}��S\�ʘ<g\�xϑUa�B�$\�*�4Ͷ\\\r?8�Y�4g>\�Qc#\�aމg�C=2�IY\�\�֍\�8\�jY��(e\�v^�Z\�s�o�\�y8�\"�ոu`\�\�tU*k.��:&\�\�\�ǌy�\��Vug�D��Y�c��suk�ATm���\�\'\Z���\�OYx�\��\�TB��!px\�\�\�Ϊ-\��K�w\�\�]�g:U3\"\�Bq\�L���]F3�L3SP\��Pi�\�5\�R���\�\�D\�7M\�v\�\�&���f�l=|J�\n]ʆ��V�\�	p����\0\�\��\�qMĞ�-�F>h\�3=f;�U�2�fQ\���\�q\�R��R��:6\�#��2O\�ii\�J9z�I�\��\�ښ&\�\�\�Q\����0�n$o⵷\�_\�\�/\0b�}ZF��,��1�Q�ުcL�\�\�\���At\n��ZXe=��\�ʿ\n\�}f*#p�AG�\�\�Q<t8(ND�\��I%�	:`RJ?zI$�Q�d\�(`t�	i\� ���\�`2��H\�k^\�\�/X�Ӿ*v�R�4/^��m5,P3F���W�����-�Bs�&\�9\�@ZFK�\�\�S\��d�>Ae�\�)\�\�v��)�SC\�c�P�|��\�\�U\Z\�Ӷ^�\�Q�\�\�t\�\�є@h\�fK\�\�\�n2\�	�\�\�Qhꜵ N�n�| Q\�:XK	\0Z��\0\Z�bO޵hq\��h?ىx\�-Έ��Fy9\�$�\�-��.\0�ʩ��\�\�ܶ-X�\0���SR\�ýl˸��k\�\�>tQR\n\�\�ǒ[$�P�6ꖨ�5H�#\n\'d\0\�uN�\�s���ژ\�\���\Z�\�\��UO\\�q�H�ܧ���i\�+�\���\"f�h\�ꛧ�Kz+)&\��\�\\�4nҺn�kiass\�`��5��#e@\�I�}\���\�PDsb)�\�w_$.I\ZƗ9\�IR��\�xw3\�b�n\�#\�w��}gN�ϩz\�\�t��4a\�\Z�ΪUa\�\�V;;�\�\r`m5MT��sg\�Wy,WjX�,U��C\�H\�\�|F�}>�^Ƽ/!.J\�M=$}��uK+b?Y�z���[���v�Æ�Ͻd��^j]Qg+\�\�[ZY;Zv?�-;K\nqZ\�3\�/tD\�m���hkF�<&\nKKJ3���U-WXm4U�T;ւRbfupv\�Vz�F\�$�W\�\�\�DFHΡGR$�=,�Ce���K�\�e\�<\�؇N\��hZ4\�=\�[�\�9\�\�hFq�N�V\�ԫ*�v�\\5֪G\��rF\�\��`i\\[O�������׶���B�v\�{�|�)\�2G+Ai\�\�{\�\n\�`�����ȗ�����^�4L��\� \�w>\�\�a5�79\�\"�vq�y*󧗒HK�k��\�C;Iq\�$�W�p.\���\�c�\�l�a\��aýH�\�i���%֦sJ�OG+@9g�>\�(\�d�\�c�p�(E\�\�Y2��=ѣ�\�M\�$&�fy6\�\'�i��j�rJ6=\��\'\'�l\r��S$�A�\�H$�D��\'@�K�\�v19��#{�ݞa\�:\�\�\�\�\�\��\�OU\��\�4L�3��d��P�-\r�F��\�\�\�h8f�\�%�\�O<\',\'�Uiŭ\�v��z\r>S���NS\�B��\'�q̽�9�\�8�U\�\\\";|\r?g(M\�<GX᱔0{��&�B\�\��Y��� �q܅[����O\�\�)#�cq\����$���UBt	$R:&�5O\�,a?/rt���H�g�g�\�щxՠY�5�\�\��Ʃ(�tGW�3\�\�\�$wIm�G����\0eUw���[��\0\'\��\�S�\�\� h��<\�j[?\�\�K���e1�M��4M�\n$�Q{\��=�\'	�\0�v�@e:&8O��\\�.2R�l�\�\�j1K\0����7�\"��ޣ\�雟��:խcO\�\�{�\�nzG\�\�1\�h%:\�\�\�E�}c�Y:\�\�w:i݌\�!zd��.q%�h{�r�FO<q�\�,9q%�\�!���Ri�\��݆��@\�KXV\�6��\Z\0\0Y~��;�c+RѶ��&\�\�z\�i=1;\�02Q\n�\�c�\���\n�\�A\r\'1ٌ\�ܜE:�x�\�_ ؿ�\��\�$/�\0�S���\�\�|�y\\��(\�hˈ���r+)Uy�\\)�4h�\�I\�+\�\'c�^\�<�\�Q��\\�\�S\�e�8\�\�׌�\�GӋ�\�\0\�Q\�\�5ڮh�x\��p��&E5<�\��\��}\��MD\r|\Z\�\�^b���Z8\����m4��|\��\�x�z����	N�Qޏ\��v\�x�\�\�4z��`��5\��\�T������\�o3\�%�^/f2���\�\\Y-�i\�}f�n呼V5�JzXϯ#˜�*\�\�\�C\0sNG2\rT\\�*iI\��!\�6mj\�HA���\�xs^\���\����\�T�\�\�K\�\���\�ۈ\rط\�RN)$\�i=����d�\�1���V\�\�\�8��+\���\�\�\Z\�\�D¼���\�\�\�җ�v��X\�\��a��|��h�;�Vݏ`p\�B\�q,�����:PX\�\��\'\��\'H����t\��2Hu\�x�4��p\�rWt�@	\�]\�\�d޻v\�r1\�+�\rC�0,YC�?j\�E\�\����(�c\�Gƚ=�!H�\�\\v\0�΋�\�^\�\�W.}��G�U�\�Վ\��}.�ͿiP]��������\�,�P\\�\�Y�^\�vI+\\YE3��UkK9h#\�\�\�=\�B\�k�\�8��f���4M\�\�\n,lJ�:aH�\�>DCaK	) r��]:�-@\�\�q��b\\�\Z�x\�gx\���.ߜj��\�C*�Fy1\�$�\�-��_�\�Qg�%\�o\�\rݎ�b]��>N5�eKO5��\�BǞ\�\0\\\�z-��P��,Y���n��6h[\��<��\���\'\�a?�g���m�9ǢC���ڨ��\��B�\�\�YT��\��>\�r�\�N-|\�8c\�In�E\�}$<�i\'\�Y\�-���W\�N\�̻3\Za:5�\�X9>\no�I[%9����gg�k�cQ�p�JI�\�\�\\.Դ�\��$�\�ƶ&\�@\�\�On6\'�9]#p\�2O\�\�[��T�W\�\��\�?ԗ+3�\��K�\�t �\�|M�\�]�K�W��乇���w|\�]N@\'<\��#P\�\�3�#��-\���@����{i�\�,�nK��\\\�T[\'�\�\�h\�]]\�K\�s޵m��4�Y�ua9\�\�9�r\�\nx\�|���#f��\�_7VU\�Ӫ��U>�\�w*\�8z\�F\rz\�z�%^�O8�\�4�l�����\�\�9�!��n\�̮L�(�\�kG���n\��o��\�t<3e8?7C��%]\�ݳN�aEb(\�p�nmt\�sp;0+J\�4�>*�\�CrE���)�ڏ�\r�\�w�R\�\�0X+V�\�\�P�\�\�#A\��\�<UT\�{$\��r��E\�^?D\�?\�gx��\�\rM%-lH����\�O�\�e$��l\���\�7\��\0��9�\�C�6��@�\�\�\�M�\0o޺6���6x\�\�\�Z�k	��{�N�\nb�0	(\�\�,�\�24��uB-7;�4\�\�\�F�N\�(��5V�Ծ�J]���b\�\���tV\�em5��Ѧ6U\�Or\�?P]E}mkC�\���\�P����\�\�\�\�\�\�W]b���\�\�L8~\����\�c\��3t\�|R%�zŤ�S6[w6}�k�E���\�\�ĪӞG�\�\�Io.%��\�v��7+\�n�\�S\�k(	�\��\�V�٨pG��\�PN\"\�\�\'�Q@<Z�߬x^%=\�T�N;n����im\�\�R�<\��@@�0�V��瞅9[*z�2$��)c\�\�X\� ���\�Re�1�v_��\�h\�}c)\��q���\�\Z6!W�Uz]\�8�\�YN2|\�l�i��\�H&\Z���\\�\�c��\\\�ђ@*��\�ǁ\�\�I٣)\�BL��\�X\�����\�\�M�]�O\�~�\0\�\ZV\�y\�K\�;�\�56\ZN\�(>x�w+�\�|J\�\�\�@-�.>��p\�.�9�\n-�Xh\��۪\��} {\�ɀ�O@��0M[qe����s(\�\��[�l�T�&@\�\Z1�\�Q���vE�[v�Lе\�\�\�\�q-P���\�H.{yF\n�m|Ę\�?\�A֊\"0�BJϝ�\�iB�\�G�XE{\�:4G�|V��i\�R���ks\�J��\�\r�\�>*�\�Seā���у��\"Lsp5骉�\�;GS���m���HZ=\�7\�V�\�ox��\�o\��Q6�#�\r?����\rI�\�h�\���\�ߴ>*\�BNE;6�#�;\nO���$^\�g�|Ri�\�\��U?�1O\�\�=?\'bO��1hz��\���\�\�d\�݊\�\�l�:\ZXϘ@��\�I	\�$P1�4�ռԦ��e\�h�I\�\�%�c��\\qd���\�}��A^g�}{��\�\�㪟�\�^`\�Rs�Dr���.B��0B�϶�ɹ��V�qE\�3�c����Q[\�LҎ|h\�\�P�7Cv�u+�t\'�q��N�ܔ��d�\�qܫ�1\n[-�\�C_	\�u(�g\n0�^[N��&����=\�\�XY\�r�\�\\-\\��(	8.bU{�\�[ݝ\\%\�G���d�\Z�im4\��j���\�d�\�Q\�\�G\r5$gf�\�J$��vm�\�HǬ\�b��Y\�ºO�1��\�5���\�m1�q\�\Z5���P;\����ME\�\�\�)\�\�a9N=�Qǻ3�,\�&�	���\��2�\����]#m���ů�\�\�\�\��_� 8��V���4�\�X�-�\�qF�9��<�\�M��ך�_1�\�n~�\0��\��@\�*Ҕ^\�2�\�.�\�u\�?4�{�\�l\\f˦t\\\�\�t;��owȺ&)&:\'6!*�4t���u\�+{�ܫ%0L\�L\\l��\��2r��\�ܿ�\�p��H�f�\r�#ߺ&�v~\�tG\�xt\��ªѮ\"F��\�\��\0Z�WU\�Б\��\"\�MR+��f\�v!�\�8b\��c�g�v>G頎[M\�ct\r��\Z�FM�G8��<���\\�\�K�\0ܝ��1�\�.\n\�Ί�SP\� ݬx%NG�u\n\Z�(tVX�;9\�\�S\�Qc2H\��8RK�=�\��agJ;�����p�|���\�N���.�Ys)�c\rDn�a�1�\�^�\�\�oYއ\�\�l�q�ԁ3S�=�V\�\�jS٬��kxT\�\�\�\�&��\�Ij�\'\reE͞+�(jt�;\�e�\"��ô�[k�i�\�\�q�\�>\�H\��&����\�M&�]���lW�\�\n7Z�\\\�\�\���\'�.gݍWK_QՉ\�<U\\\�\�b\�1\�\�.�IjtM����Ӄ��y�:+�-�<�*��0\���V�j���,Ѷ�㻃�\�rʪ\�yI�\�)3�(��Uc�\�\�\�?魽�\��;sG�Ģ4�\�\�\�Ko�P7\�{?���猲gN����N\��Le=��].�<\�\�H\�tt\�3\�OT��\�\�\�S\��\0��\�9�\�\�	�\�T\�~�?�tUl\�\�k\���\�\�\�?G\�\�\'<w?�\�6�\�q_Bm��⊗O�M�H4�T�L\nh@����\�ז\�f\�E�C\�b\�˜qI\�\�ed�В�\�r�7��\�e4�f�۳[\0\�ȕ\�RSS\�؂1�\�\\�\�ݘѯr�=.��\0ΆW��J>���)�����!\�$\�{��\0�PC\�\�h�>mC\r��\�a4t\�\�&�\0%R\�T�2C\�u\�M\�y\�\'W�Ah��\�n�\'��o�A/\��՚\�]���ǵ=\�\�YϥͼjF���!=<�l\�\�N��q���I�-�\Z�fY�`��=�#\'ܼ\�\�Ǖ��gW\�Rs�X\�|���ӛ�J�}6+8��=�c!֠\�ڃx�M\�pS\�Tf\�[A|�Gp����0�`Ѓ�\�.\�\�\�\��`3gE�K\�j�VUE�2�IJ�\�\�Y\�,�*9ݜ���j�\�$��咽�]�B��!]/5j���x\�\�r�4\�yعV��\reA\Z\�ڻ���\�\�\�\�ɨ�e2	֗���e��z�1�3Fp�\�s\�5+9�3��*�\�\�cOf\�7_�p����\0\"�Y�MK�7���[�?(?\�\�zܬٹW6gYQ���\�\�\\�\�\�Q��}�\�#�i\�$�\�\�u�\0\�H|7V�]G4�\�\�\�:\�9J0\��M/\��I\�A!�\�\�\�\�\�0���\�lQS�Hbp\������=Qx�\�\��ֶP5~\�K\\��\��\�$�q`�wi�?Җ�\�\�ϣ\�$ӎ\��vԒT0h�\�F��\�E2*8\r�Y�\"Q�u\�\'��\�\�p�@A�\0�<<+x��Z6v/;s�>\�Jꌪ4�\�,\�ք��Ͻ@ �F�D�K;ʻm�6����\���\'\0�<rk�(\�s�\�po\���<8�uo�V��8\�h�u�P&���\�0=�H}��4\�j\�\�/ql��\r\�#��4V;ž0 �\�\�\��2��x��sE�\�\��(�՚Z(�!���rS\\�_F�\�\�^X�\��VgUѵ�\\!t�#�9]�\0ui\�7~��\����\�˚>�7\n;�e���\�s�\� 8?Fv�\�\�%��ZfŒH\�d	!�Fm�;]<o�s\�#ip<\�k�V�\�\�\���2JƇ\�>��%X��IF�h�\�@4Zj�p\�\�[�\�\�QB�Ihϊ!��=�������D�\\�E��\Z\�\�9.G�蹳\�\ny\�Y��\�Q:���V�Ju��\�\�HB	I���M	�\�Fv`\�Yfʻ<\�v���ɝ��<lj&����\����k�A>+j\�q\r�\�\�R\�\�с��\Z;Ǌ��L�v��sd������\�!�\�U��ֽ�TUMR\��\0b#\�\�x���z5{)=\"\�[q��\\\�I\�{\�w\\\\ʘ\�s愴\�\0��wP\�H�T\Z\�Wc��(�EAh.`Ňĝ�o饦�Hʋpd\�:2&���=�>\�t�\�\�z+\�c�B0([��@\�\\����=�\�_Ev���\�\Z\�0Z2%�:��E8x�io98\�^ka�\�Z�|1T�(�3\�\�3\�vE\�ܽ2\Z\��	b�Z�@���k\ZoP&���\�,t\�{��qfAW޲\�H\�\�P�\�ڗ��q\�JI`%\�C���\�|S%�\�I\���cf��>*���\0orS\�\�c��\�%\��8�+\�\'Tɩ\��̍��	V\�\�\�v\�}!��d?�i\�*\�\�r���Kq;\0��\�=\��JG{���\Z\�]c�䫲\�vX��&\n�ۆ�!\�x\���}l\�\�I+\�ٌ�r\�U\�;�\����p\�\�K�	��O\�\�\���*�ha��\�]���r��\rݭ\�S\��,okLm\'\�ӹ\r��\�[Qc�ͅ�\�h\�#ϹB{���\�T\�Lj���	�\�M��mį\�Q�Ov���ަ�9h,ƣ.p\�ܺL�ʰ\�j\�L\�\�\�y[L�l��\�o#������cd\�8\����u\�\�\\\�\�Jt>hD\�5K��\�\�\�ІI4O�s�\�K�z�\�\n\�3��p++�T\�\�Պ�s\�)�z���Q��~\�%gB�\�)�\0\r�\0\�=B\�\�]�\�\��Gc�Iq�L\"���s��@u+ʝ�R�\�ꇰ�\�F\�Ü<\�E�\�Z�\�\�\�۵k���F\�;����S�έ֭ko�\0tCh�)x���\0\��_�\���s\�xb�V��\�O�\01���u\�Lea��筹��\�5\��9\��\��kvkP�f�����l�E\�r�!#��q�$��|\�	�\�M\�l���z�j\�\�c \��\nU/%��1���\�J\�\�=Rʊ\�z�\�\�x�Oq�㳒H㣦���\���\�\��j-?\'Vhy>pa���G��2H\�\�2\�ೢ�J��=\�������)���#۠���W����8i�q1�`\rh�Y��&��i%{N\\\�\�A\�\�]\ZA#��Z�R䦔\�+�x.�S�Нz\�\"ݞ���\��\�v�x\0\�\n;��\�\�Jqm?o�6z7F�U�\�ӫ\�p�\�o�\�\�\�\�\�T3\�E��\�\�\�Eo�AC\�\�e\�:�\��\�:&�\�\\1�\�u7\�\ZRq\�)r\��\�W0��ҋo��\�6ϦME�ǰ\�\�F\�r\�y�6ڪ�%\�)�Y��\���3�y�����ӠR\�\�δ\�9%�/\�_\�e^4z�\�)�,\�c�g\�w\���\���ߴ�\\�\�\�7�[�\0�j�D\�q8\��ê\�qw�\'Z\�\��ڊ7����$�Ғi�z�H�Ӯ�BmI7��k<�x\�\�Iۤ��M�\��B?\��\��\0 ~\�\��|�\�Cd��\�\�˙�\�Q��U�oB1\�GZ?\��\�<6&�=\�x��@\�\��h+�N8���u#�C��N�?q;S�\r\�&\r\Z\�_\�E�:�ǜ�IJmx��ǜN�\�~\���\�\Z a2�(���^<\�\�\�q5��\0\�Y�?\�\�{�\�O\�-���Q��\����m\�KI8���\�V��m�&�\�Y+��\�\�jN\�\�[\�)\�#Y lҹ\��;��\�U\�W1\�[\�of\�U\�?op\�Hٮ3�j�Y	9l#���hh\0\0pTn��KE\"�/�H�h��\��s��\�\�z.!v�[��\�\�8X-�`�.q캅n\�#�\�1CD��#�q�A\���tQK]�1\�\�T]�\�c:�uݻ.\r軷e�H�1\�m�\�9P\'E;c\�Z\�\�j�Ҋj�\�z�x�\�r�|��\�i\�͐e������T����2ɣl�#pʋ��^ޢ�\�)c�˟n���f�S�!U\'vG4�\����L�(�)\�m���X�Ȝ\���\�s�̒�\�O���v\�ju�̊T\�?P\�\�d�\�(B��\�}\�q��g)�]�G��$-q���#{Jy#7\�NUr0uV\�F#\�M��\�N�\�7X�#�\��\�\�HM\�d��d5�\�h����w\�D;�3\�Ԑ?�]��\�\�\�\�Q�U�q\�G\�+#�Z��޴=4\'\�\'��R��\�`\no�\�鋌7�5\�B\�\�\�G�v��\�\'y܂��8�\�?\�\�=\��\�ޑ^.\�\�\�۔�w66\�8S �\�\�yN��g\�]Ĳ�\0�����\'ˡ{\�0�u��\�\�ۙ,��6�ӎ\\��sFOQ��U�u\�\�i\�7>��b�1ޠn\�Q�p�\�Q\�\��V�Zaiban[\���E�j��7l���s+&-��7Gl�{��\0Re\�\�b-E\�\����U9\�\�g�o��\0ކ����Q�[��y�;�e\�c�\�gpN<1�\�+\�q���6Z\�`\�F3�\0\��Eyhc��վY���~\�u\�=7�\�ؼ\�5_j\�9\Z�\�ְ}l�\�\�,j�\�k�\�\�B���;iӛ�🅤\�\�����\0|�\�\��\n��ڇs<v�� {��U]5DbH\�\�@\�;\0i\�eʦ��M\rq 5\�\�\�I�kC@�f;>Y\��\�6�\�zt��E$�\�9{\�\���=��Cp�2�#��\0a\�\�〾�\��\�N����d�D9\��\�B�d�M\�5ͷ�\�N�u\��_@|���>�sZ\�5D}��y#.�\�@Aӛ\�Mw�%�*Td\�M�����V��\�\�a��������\�\�2�[J�z\�U�\�\�ϗ�b�鳜�+\�d�\'_�ѥ&�\�\�\����vjyc%�=�\���S݌�.2�)\Z�\��c\\hN�\�\�Tv�@3�5\�_�C\�h�܏\�\����]+u쿄/_���RʥY5�\�-�\�yow���EK��IK1xkI!۷D.\�M%UD\�\�kp0OA�v�(\�\��\��r�o�\Zx\�\�ф<����_Obt�ip�\��\0N�ϽW�P��k\�/\no\r\�d��\�~�\�\��媤\�3|�ă�\0\�B�l\�7.\��\�A_A�\nx\�\�d|�\�\\tπ�ӌ7`\�u{�\�\�d�ip���k��t�	���m�^r\�\��4�\�&��w3�Wd�gB:!���s�`h\0�i\'\0+s9柙\�s�h?\�K\�+(Qt\�$���o�\�v��w\n\�9&��\��NM\�z��9��8\�1\�\�ܠlؠ�Y�\�1�\��&�U�ѳ��\�\0���E\�\�\�\�=�q��i\��Q�R�*WS�JY\�\��i\�Ѵ�ch\�\�R�4�\'.1��\�\��S�I\�T\�l�_�\�\�:�ߍ��\�\�	�]��Y��q��ݝ��}\�^��H\�\�D�5w�\�I��8�qw]\n\��Ȩܙ*�9��Z3��)�uI���҈\�}��K���#\�S�sc�����P\��\�v�uŽh�\�>�˂\�{.��4]U\�pV�#g��*[(����d\�KT\�\�ΪCt\�Ϛp� u]\Z���5MO�9[\�vnˋWV��\�&9Q*D��$���\\ݲ\�\�\�ʭBX���\�$l���hs\���\�\�.d*�xd\�]g���R�)\\z�\�߻eȲ\�\�mK:v�\�w\�i�\"��\�\�\�q\�:75!\�Ҍ�@�\�WE��/{9�p��\0I)[)�H\�\�ݦ2q�G�*�E���\�zx\�\���\�\�\�\��\�\�-lQAm\�R]���][y�?٭��as��\��\0��?\'0�򸻇F«�~�,w�WU�����}�\ZG{50�\'�\�U\�v��\��r%�?�H?�P��\�N���\0\��T��S~�]���2t{O�8��V|p{˹��g�n��\r�ǫ4\r�A�\0�?\�\����\\45A<\�C�\�\�F4\�\�8������8�(dC\rkF���\0�\�\�+��\�|�cs��q���Yb]Tr��\�Q\�6t\�ZE\�8\�Z\�?\���������P���\�\�̖g�B;C��W[W\"\�\r�3$RO?(p\����\�>	k��\�5\�g4�G�#4�[\�4��cx��\">b�h��C�D\�\�\��G��\�\��r��<;c���t�\�m:<5\'���s߀\\zj�ܮ��I\�%ud\�..<\�L�\�h��C)�f�\��H\0�%\�9�M�����\�&�Y{p�\\zmt\��ǔtaŭ���>\�u��\�t,�Y)�Id�0I\�@�d\�I\�i��\�(�$��C)�\���\\u\�c޾��^Y\�=Ksdf1Q1�\�ӱ\�\�8?\n\�=�5;�\�Qxje����\0�:\�\�s�\�\�_����TNw\�\�]�������V[!}O=EDҸ���-+�ZT�T`��|a\rJҹ��\�n�S\��XK\�\�\'AE-+�G��\�Z\�q�YUM�35��}l4\���KO5;X\�k\�s�״��~j\���t\r\�\�4\�T\�u�\�o��5+\�V�R53�K\���նq�?\�\��WT\n\�\Z,`X<\�::�\�\�+N�\�\��\0u�\�	�G�\�\�#���[\�\\)\�`�:\�\0��IkYR�$�\�S��	\�\�\�\�w�\�����	��\��3{G1�$k�MT-���\Z�\�\�\�J�\�n.V\�\�\�Z�gL#S;\�Nz�\���:dj�H�h�\�s��+\�g\�nĮ�C+��D�u?�\�\�җyh�\�\�>n��j?��u?�\�\�[%�{�,wI#�K�7_\'���\�:�\�ۍ��\�XW\�c/\��R\'L�9\�$�̑n\'\'\'tI%4Ng%GT�M$	�RI�\�I���Q�\�]\�\�$�\�\��-ǲ�I+�\�\�1PI$�Q�I$�:p�HHBAt	$��$l\�\�\�$��L�D�\nI)$5+��IV�,$��P�J��\�\�\�RIE!\�\Z(�)$����I$c�0B�\�$�\�4\�\�.\�\�I)\�Lͷ�\�Z\Z\�\�\0\0C�\0\�?�C�\0=�\0��\0\�$��\"j^\�	mS\���\����&<!���\0��$�4D_\�\�C�O�~\�84�ۆ�a�ԃ\���IS(uE\�\�o0%��\�\�\�$�UYS~�\�\�\�\�t֖W��\0XI\�m\�:׶8)\�ɑ��:\�\\I����\�l�H�݉��\�\�s�\�$��{�\�I$o�ӛ�e��حsB�ݼmk�\�/)q�\���\�.\�;\�9s���\\f���܄줒��\��\0�>�\�P�ý5qO\�/�\�	|�\�=�!u6�TJ^*9=\\S8=���G\�/\�Χ\�}�!��\0N�ʧ��\�\�O�xf��u\�{Y�\�����O�q1ݰI\�\��ԒJ��;�u�ؽ��Ɵ�:�.k���s\�r\\\�w�\0�v�\�F�\�9�1�\���II�z�S�/�\�\�mZÏ\��\�\�p\�f�oK\�����\�\�\�\��\0��\�$�]{�.*}#�+ϡ\�OyS���J��=%\��\�_�Y�+7ļ$\�e\�?8�Z`��\�߮y�\��IԺ�\�z�\'��\0E��:ڄsN8�\�\�a\�$�\�3��\�');
/*!40000 ALTER TABLE `advertisment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `advertismentscheme`
--

DROP TABLE IF EXISTS `advertismentscheme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advertismentscheme` (
  `AdvertismentSchemeID` int(11) NOT NULL AUTO_INCREMENT,
  `AdSchemeName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`AdvertismentSchemeID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertismentscheme`
--

LOCK TABLES `advertismentscheme` WRITE;
/*!40000 ALTER TABLE `advertismentscheme` DISABLE KEYS */;
INSERT INTO `advertismentscheme` VALUES (1,'Top Banner'),(2,'Left Side Banner'),(3,'Right Side Banner'),(4,'Bottom Banner'),(5,'Background Banner');
/*!40000 ALTER TABLE `advertismentscheme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arena`
--

DROP TABLE IF EXISTS `arena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arena` (
  `ArenaID` int(11) NOT NULL AUTO_INCREMENT,
  `ArenaName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ArenaID`)
) ENGINE=InnoDB AUTO_INCREMENT=50008 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arena`
--

LOCK TABLES `arena` WRITE;
/*!40000 ALTER TABLE `arena` DISABLE KEYS */;
INSERT INTO `arena` VALUES (50001,'Atlanta'),(50003,'New Orleans'),(50006,'New York'),(50007,'Seaside Cliffs');
/*!40000 ALTER TABLE `arena` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arenamembers`
--

DROP TABLE IF EXISTS `arenamembers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arenamembers` (
  `arena_ArenaID` int(11) NOT NULL,
  `users_userID` int(10) NOT NULL,
  PRIMARY KEY (`arena_ArenaID`,`users_userID`),
  KEY `fk_arenamembers_arena1_idx` (`arena_ArenaID`),
  KEY `fk_arenamembers_users1` (`users_userID`),
  CONSTRAINT `fk_arenamembers_arena1` FOREIGN KEY (`arena_ArenaID`) REFERENCES `arena` (`ArenaID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_arenamembers_users1` FOREIGN KEY (`users_userID`) REFERENCES `users` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arenamembers`
--

LOCK TABLES `arenamembers` WRITE;
/*!40000 ALTER TABLE `arenamembers` DISABLE KEYS */;
/*!40000 ALTER TABLE `arenamembers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expertratingformula`
--

DROP TABLE IF EXISTS `expertratingformula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expertratingformula` (
  `ExpertRatingFormulaID` int(11) NOT NULL AUTO_INCREMENT,
  `ExpertRatingFormulaFormula` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ExpertRatingFormulaID`)
) ENGINE=InnoDB AUTO_INCREMENT=990004 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expertratingformula`
--

LOCK TABLES `expertratingformula` WRITE;
/*!40000 ALTER TABLE `expertratingformula` DISABLE KEYS */;
INSERT INTO `expertratingformula` VALUES (990001,'Something Goes Here'),(990002,'Something Else Goes Here'),(990003,'Something Else');
/*!40000 ALTER TABLE `expertratingformula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `GameID` int(11) NOT NULL AUTO_INCREMENT,
  `GameName` varchar(45) DEFAULT NULL,
  `GameDescription` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`GameID`)
) ENGINE=InnoDB AUTO_INCREMENT=11020 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (11001,'Pokemon','Trading Card Game'),(11002,'Magic','Trading Card Game'),(11004,'Soccer','American Football'),(11014,'Test','Test Desc'),(11016,'TestName1','TestDesc1'),(11017,'TicTacToe','X\'s & O\'s '),(11018,'Halo','First Person Shooter'),(11019,'Arena','The winner will ascend to divinity');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `league`
--

DROP TABLE IF EXISTS `league`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `league` (
  `LeagueID` int(11) NOT NULL AUTO_INCREMENT,
  `LeagueName` varchar(45) DEFAULT NULL,
  `leagueDesc` varchar(45) DEFAULT NULL,
  `ExpertRatingFormula_ExpertRatingFormulaID` int(11) NOT NULL,
  `users_userID_LeagueOwner` int(10) NOT NULL,
  `arena_ArenaID` int(11) NOT NULL,
  PRIMARY KEY (`LeagueID`,`ExpertRatingFormula_ExpertRatingFormulaID`,`users_userID_LeagueOwner`,`arena_ArenaID`),
  KEY `fk_League_ExpertRatingFormula1_idx` (`ExpertRatingFormula_ExpertRatingFormulaID`),
  KEY `fk_league_arena1_idx` (`arena_ArenaID`),
  KEY `fk_league_users1_idx` (`users_userID_LeagueOwner`),
  CONSTRAINT `fk_League_ExpertRatingFormula1` FOREIGN KEY (`ExpertRatingFormula_ExpertRatingFormulaID`) REFERENCES `expertratingformula` (`ExpertRatingFormulaID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_league_arena1` FOREIGN KEY (`arena_ArenaID`) REFERENCES `arena` (`ArenaID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_league_users1` FOREIGN KEY (`users_userID_LeagueOwner`) REFERENCES `users` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=800015 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `league`
--

LOCK TABLES `league` WRITE;
/*!40000 ALTER TABLE `league` DISABLE KEYS */;
INSERT INTO `league` VALUES (800001,'Example League Name',NULL,990001,900000001,50001),(800002,'Example League Test Name',NULL,990001,900000005,50001),(800003,'League Test Name Test1',NULL,990001,900000001,50001),(800004,'asdfqweas','asdf aczeaf asdf',990001,900000005,50001),(800005,'madkemc','asdf acze',990001,900000005,50001),(800006,'Test 5','Now not jibberish',990001,900000005,50001),(800008,'League Prism','Test League Adam One',990001,900000018,50001),(800009,'Tims League One','Tims First League!',990001,900000019,50001),(800010,'League Bob','League o Bob',990001,900000001,50001),(800011,'Rob\'s League','Anything I want we do.',990001,900000005,50001),(800012,'Test Campus','Hello World',990002,900000005,50001),(800014,'League Class ABC','Class League Stuff',990001,900000019,50001);
/*!40000 ALTER TABLE `league` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leaguemembers`
--

DROP TABLE IF EXISTS `leaguemembers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leaguemembers` (
  `League_LeagueID` int(11) NOT NULL AUTO_INCREMENT,
  `MembershipStatusCode_MembershipStatusCodeID` int(11) NOT NULL,
  `users_userID` int(10) NOT NULL,
  PRIMARY KEY (`League_LeagueID`,`MembershipStatusCode_MembershipStatusCodeID`,`users_userID`),
  KEY `fk_LeagueMembers_MembershipStatusCode1_idx` (`MembershipStatusCode_MembershipStatusCodeID`),
  KEY `fk_leaguemembers_users1_idx` (`users_userID`),
  CONSTRAINT `fk_LeagueMembers_League1` FOREIGN KEY (`League_LeagueID`) REFERENCES `league` (`LeagueID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_LeagueMembers_MembershipStatusCode1` FOREIGN KEY (`MembershipStatusCode_MembershipStatusCodeID`) REFERENCES `membershipstatuscode` (`MembershipStatusCodeID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_leaguemembers_users1` FOREIGN KEY (`users_userID`) REFERENCES `users` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=800013 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaguemembers`
--

LOCK TABLES `leaguemembers` WRITE;
/*!40000 ALTER TABLE `leaguemembers` DISABLE KEYS */;
INSERT INTO `leaguemembers` VALUES (800001,1,900000003),(800003,1,900000003),(800004,1,900000003),(800008,0,900000024),(800009,1,900000025),(800010,0,900000020),(800012,1,900000024);
/*!40000 ALTER TABLE `leaguemembers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `match`
--

DROP TABLE IF EXISTS `match`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `match` (
  `MatchID` int(11) NOT NULL AUTO_INCREMENT,
  `OutcomeWin_UserID` varchar(45) DEFAULT NULL,
  `OutcomeLoss_UserID` varchar(45) DEFAULT NULL,
  `MatchStatus_MatchStatusID` int(11) NOT NULL,
  `Game_GameID` int(11) NOT NULL,
  `Tournament_TournamentID` int(11) NOT NULL,
  `matchDate` datetime DEFAULT NULL,
  `teams_TeamID2` int(11) NOT NULL,
  `teams_TeamID1` int(11) NOT NULL,
  PRIMARY KEY (`MatchID`,`MatchStatus_MatchStatusID`,`Game_GameID`,`Tournament_TournamentID`,`teams_TeamID2`,`teams_TeamID1`),
  UNIQUE KEY `MatchID_UNIQUE` (`MatchID`),
  KEY `fk_Match_Tournament1_idx` (`Tournament_TournamentID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `match`
--

LOCK TABLES `match` WRITE;
/*!40000 ALTER TABLE `match` DISABLE KEYS */;
INSERT INTO `match` VALUES (1,NULL,NULL,0,11001,1000007,'2017-11-21 14:48:00',9,2),(2,NULL,NULL,0,11004,1000007,'2017-11-16 14:49:00',9,2),(3,NULL,NULL,0,11001,1000008,'2017-11-16 14:50:00',2,9),(4,NULL,NULL,0,11001,1000006,'2017-11-18 17:55:00',8,2),(5,NULL,NULL,0,11001,1000006,'2017-11-08 16:57:00',2,9);
/*!40000 ALTER TABLE `match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matches`
--

DROP TABLE IF EXISTS `matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matches` (
  `MatchID` int(11) NOT NULL AUTO_INCREMENT,
  `OutcomeWin_UserID` varchar(45) DEFAULT NULL,
  `OutcomeLoss_UserID` varchar(45) DEFAULT NULL,
  `MatchStatus_MatchStatusID` int(11) NOT NULL,
  `Game_GameID` int(11) NOT NULL,
  `Tournament_TournamentID` int(11) NOT NULL,
  `matchDate` datetime DEFAULT NULL,
  `teams_TeamID2` int(11) NOT NULL,
  `teams_TeamID1` int(11) NOT NULL,
  PRIMARY KEY (`MatchID`,`MatchStatus_MatchStatusID`,`Game_GameID`,`Tournament_TournamentID`,`teams_TeamID2`,`teams_TeamID1`),
  UNIQUE KEY `MatchID_UNIQUE` (`MatchID`),
  KEY `fk_Match_MatchStatus1_idx` (`MatchStatus_MatchStatusID`),
  KEY `fk_Match_Game_idx` (`Game_GameID`),
  KEY `fk_Match_Tournament1_idx` (`Tournament_TournamentID`),
  KEY `fk_match_teams1_idx` (`teams_TeamID2`),
  KEY `fk_match_teams2_idx` (`teams_TeamID1`),
  CONSTRAINT `fk_Match_Game` FOREIGN KEY (`Game_GameID`) REFERENCES `game` (`GameID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Match_MatchStatus1` FOREIGN KEY (`MatchStatus_MatchStatusID`) REFERENCES `matchstatus` (`MatchStatusID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_match_teams1` FOREIGN KEY (`teams_TeamID2`) REFERENCES `teams` (`TeamID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_match_teams2` FOREIGN KEY (`teams_TeamID1`) REFERENCES `teams` (`TeamID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matches`
--

LOCK TABLES `matches` WRITE;
/*!40000 ALTER TABLE `matches` DISABLE KEYS */;
INSERT INTO `matches` VALUES (1,NULL,NULL,0,11001,1000007,'2017-11-21 14:48:00',9,2),(2,NULL,NULL,0,11004,1000007,'2017-11-16 14:49:00',9,2),(3,NULL,NULL,0,11001,1000008,'2017-11-16 14:50:00',2,9),(4,'2','8',2,11001,1000006,'2017-11-18 17:55:00',8,2),(5,'9','2',2,11001,1000006,'2017-11-08 16:57:00',2,9),(6,NULL,NULL,1,11004,1000005,'2017-11-26 21:41:00',8,2),(7,'2','8',2,11004,1000005,'2017-11-26 21:45:00',8,2),(8,'9','2',2,11004,1000005,'2017-11-28 19:54:00',9,2),(9,NULL,NULL,0,11014,1000013,'2017-11-28 20:04:00',9,2),(10,'2','9',2,11017,1000005,'2017-11-28 20:06:00',9,2),(11,'9','8',2,11016,1000006,'2017-11-28 20:29:00',9,8);
/*!40000 ALTER TABLE `matches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matchstatus`
--

DROP TABLE IF EXISTS `matchstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matchstatus` (
  `MatchStatusID` int(11) NOT NULL,
  `MatchStatusName` varchar(45) DEFAULT NULL,
  `MatchStatusDesc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MatchStatusID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matchstatus`
--

LOCK TABLES `matchstatus` WRITE;
/*!40000 ALTER TABLE `matchstatus` DISABLE KEYS */;
INSERT INTO `matchstatus` VALUES (0,'Pending','Pending Match'),(1,'Active','Active Match'),(2,'Complete','Complete Match'),(3,'Cancelled','Cancelled Match');
/*!40000 ALTER TABLE `matchstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membershipstatuscode`
--

DROP TABLE IF EXISTS `membershipstatuscode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membershipstatuscode` (
  `MembershipStatusCodeID` int(11) NOT NULL,
  `MembershipStatusCodeName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MembershipStatusCodeID`),
  UNIQUE KEY `MembershipStatusCodeID_UNIQUE` (`MembershipStatusCodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membershipstatuscode`
--

LOCK TABLES `membershipstatuscode` WRITE;
/*!40000 ALTER TABLE `membershipstatuscode` DISABLE KEYS */;
INSERT INTO `membershipstatuscode` VALUES (0,'pending'),(1,'member'),(2,'banned');
/*!40000 ALTER TABLE `membershipstatuscode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pending`
--

DROP TABLE IF EXISTS `pending`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pending` (
  `appID` int(11) NOT NULL AUTO_INCREMENT,
  `appUserID` int(10) NOT NULL,
  `appCurrentRole` int(11) NOT NULL,
  `desired_RoleID` int(11) NOT NULL,
  PRIMARY KEY (`appID`,`appUserID`,`appCurrentRole`,`desired_RoleID`),
  KEY `fk_pending_users1_idx` (`appUserID`,`appCurrentRole`),
  KEY `fk_pending_userroletype1_idx` (`desired_RoleID`),
  CONSTRAINT `fk_pending_userroletype1` FOREIGN KEY (`desired_RoleID`) REFERENCES `userroletype` (`userRoleTypeID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pending_users1` FOREIGN KEY (`appUserID`, `appCurrentRole`) REFERENCES `users` (`userID`, `userRoleID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pending`
--

LOCK TABLES `pending` WRITE;
/*!40000 ALTER TABLE `pending` DISABLE KEYS */;
/*!40000 ALTER TABLE `pending` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playerlose`
--

DROP TABLE IF EXISTS `playerlose`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playerlose` (
  `match_MatchID` int(11) NOT NULL,
  `users_userID` int(11) NOT NULL,
  KEY `MatchID` (`match_MatchID`),
  KEY `userID` (`users_userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playerlose`
--

LOCK TABLES `playerlose` WRITE;
/*!40000 ALTER TABLE `playerlose` DISABLE KEYS */;
INSERT INTO `playerlose` VALUES (7,900000024),(8,900000020),(8,900000025),(11,900000024);
/*!40000 ALTER TABLE `playerlose` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playertournywin`
--

DROP TABLE IF EXISTS `playertournywin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playertournywin` (
  `Tournament_TournamentID` int(11) NOT NULL,
  `users_userID` int(11) NOT NULL,
  KEY `TournamentID` (`Tournament_TournamentID`),
  KEY `userID` (`users_userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playertournywin`
--

LOCK TABLES `playertournywin` WRITE;
/*!40000 ALTER TABLE `playertournywin` DISABLE KEYS */;
/*!40000 ALTER TABLE `playertournywin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playerwin`
--

DROP TABLE IF EXISTS `playerwin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playerwin` (
  `match_MatchID` int(11) NOT NULL,
  `users_userID` int(11) NOT NULL,
  KEY `MatchID` (`match_MatchID`),
  KEY `userID` (`users_userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playerwin`
--

LOCK TABLES `playerwin` WRITE;
/*!40000 ALTER TABLE `playerwin` DISABLE KEYS */;
INSERT INTO `playerwin` VALUES (6,900000020),(6,900000025),(7,900000020),(7,900000025),(10,900000020),(10,900000025);
/*!40000 ALTER TABLE `playerwin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scores`
--

DROP TABLE IF EXISTS `scores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scores` (
  `ScoreID` int(11) NOT NULL AUTO_INCREMENT,
  `match_MatchID` int(11) NOT NULL,
  `game_GameID` int(11) NOT NULL,
  `Team1_Score` varchar(45) DEFAULT NULL,
  `Team2_Score` varchar(45) DEFAULT NULL,
  `teams_TeamID2` int(11) NOT NULL,
  `teams_TeamID1` int(11) NOT NULL,
  `ScoreStatusTable_idScoreStatusTable` int(11) NOT NULL,
  PRIMARY KEY (`ScoreID`,`match_MatchID`,`game_GameID`,`teams_TeamID2`,`teams_TeamID1`,`ScoreStatusTable_idScoreStatusTable`),
  UNIQUE KEY `ScoreID_UNIQUE` (`ScoreID`),
  KEY `fk_MatchScores_game1_idx` (`game_GameID`),
  KEY `fk_MatchScores_match1` (`match_MatchID`),
  KEY `fk_scores_teams1_idx` (`teams_TeamID2`),
  KEY `fk_scores_teams2_idx` (`teams_TeamID1`),
  KEY `fk_scores_ScoreStatusTable1_idx` (`ScoreStatusTable_idScoreStatusTable`),
  CONSTRAINT `fk_MatchScores_game1` FOREIGN KEY (`game_GameID`) REFERENCES `game` (`GameID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_MatchScores_match1` FOREIGN KEY (`match_MatchID`) REFERENCES `matches` (`MatchID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_scores_ScoreStatusTable1` FOREIGN KEY (`ScoreStatusTable_idScoreStatusTable`) REFERENCES `scorestatustable` (`idScoreStatusTable`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_scores_teams1` FOREIGN KEY (`teams_TeamID2`) REFERENCES `teams` (`TeamID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_scores_teams2` FOREIGN KEY (`teams_TeamID1`) REFERENCES `teams` (`TeamID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scores`
--

LOCK TABLES `scores` WRITE;
/*!40000 ALTER TABLE `scores` DISABLE KEYS */;
INSERT INTO `scores` VALUES (11,4,11001,'4000','4000',2,8,2),(12,4,11001,'3800','3700',2,8,2),(13,4,11001,'3600','3500',2,8,2),(14,4,11001,'3700','3000',2,8,2),(15,4,11001,'8000','0',2,8,2),(16,5,11001,'4000','4000',9,2,2),(17,5,11001,'200','0',9,2,2),(18,8,11004,'0','1',2,9,1),(19,8,11004,'1','1',2,9,1),(20,8,11004,'2','1',2,9,1),(21,8,11004,'3','1',2,9,1),(22,10,11017,'5','4',2,9,2),(23,11,11016,'0','1',8,9,2),(24,11,11016,'3','4',8,9,2);
/*!40000 ALTER TABLE `scores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scorestatustable`
--

DROP TABLE IF EXISTS `scorestatustable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scorestatustable` (
  `idScoreStatusTable` int(11) NOT NULL AUTO_INCREMENT,
  `ScoreStatusName` varchar(45) DEFAULT NULL,
  `ScoreStatusDesc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idScoreStatusTable`),
  UNIQUE KEY `idScoreStatusTable_UNIQUE` (`idScoreStatusTable`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scorestatustable`
--

LOCK TABLES `scorestatustable` WRITE;
/*!40000 ALTER TABLE `scorestatustable` DISABLE KEYS */;
INSERT INTO `scorestatustable` VALUES (1,'ongoing','Ongoing Scores'),(2,'pending','Approval Pending'),(3,'rejected','Rejected Scrores'),(4,'approved','Approved Final Scores'),(5,'cancelled','Cancelled Match Scores');
/*!40000 ALTER TABLE `scorestatustable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teams` (
  `TeamID` int(11) NOT NULL AUTO_INCREMENT,
  `TeamName` varchar(45) DEFAULT NULL,
  `users_userID` int(10) NOT NULL,
  `league_LeagueID` int(11) NOT NULL,
  PRIMARY KEY (`TeamID`,`users_userID`,`league_LeagueID`),
  KEY `fk_teams_users1_idx` (`users_userID`),
  KEY `fk_teams_league1_idx` (`league_LeagueID`),
  CONSTRAINT `fk_teams_league1` FOREIGN KEY (`league_LeagueID`) REFERENCES `league` (`LeagueID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_teams_users1` FOREIGN KEY (`users_userID`) REFERENCES `users` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (0,'Not in a Team',900000017,800001),(2,'Team Rocket',900000001,800008),(8,'fist',900000005,800003),(9,'Team Class',900000019,800002);
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teamspending`
--

DROP TABLE IF EXISTS `teamspending`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teamspending` (
  `loAppID` int(11) NOT NULL AUTO_INCREMENT,
  `appUserID` int(11) DEFAULT NULL,
  `appUserName` varchar(45) DEFAULT NULL,
  `desired_teamName` varchar(45) DEFAULT NULL,
  `current_teamName` varchar(45) DEFAULT NULL,
  `desired_teamID` int(11) DEFAULT NULL,
  `leagueOwnerID` int(11) DEFAULT NULL,
  PRIMARY KEY (`loAppID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teamspending`
--

LOCK TABLES `teamspending` WRITE;
/*!40000 ALTER TABLE `teamspending` DISABLE KEYS */;
/*!40000 ALTER TABLE `teamspending` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tournament`
--

DROP TABLE IF EXISTS `tournament`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tournament` (
  `TournamentID` int(11) NOT NULL AUTO_INCREMENT,
  `TournamentName` varchar(45) DEFAULT NULL,
  `TournamentDescription` varchar(45) DEFAULT NULL,
  `League_LeagueID` int(11) NOT NULL,
  `TournamentStyleCode_TournamentStyleCodeID` int(11) NOT NULL,
  `tournamentDate` date DEFAULT NULL,
  `tournamentWinner_TeamID` varchar(45) DEFAULT NULL,
  `tournamentStatus` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TournamentID`,`League_LeagueID`,`TournamentStyleCode_TournamentStyleCodeID`),
  UNIQUE KEY `TournamentID_UNIQUE` (`TournamentID`),
  KEY `fk_Tournament_League1_idx` (`League_LeagueID`),
  KEY `fk_Tournament_TournamentStyleCode1_idx` (`TournamentStyleCode_TournamentStyleCodeID`),
  CONSTRAINT `fk_Tournament_League1` FOREIGN KEY (`League_LeagueID`) REFERENCES `league` (`LeagueID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Tournament_TournamentStyleCode1` FOREIGN KEY (`TournamentStyleCode_TournamentStyleCodeID`) REFERENCES `tournamentstylecode` (`TournamentStyleCodeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1000014 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tournament`
--

LOCK TABLES `tournament` WRITE;
/*!40000 ALTER TABLE `tournament` DISABLE KEYS */;
INSERT INTO `tournament` VALUES (1000002,'Robert Cromer','Server',800004,40001,'2017-11-10',NULL,NULL),(1000003,'Testin Testin','Testerino',800005,40001,'2017-11-30',NULL,NULL),(1000005,'Bren','bren',800005,40003,'2017-11-24',NULL,NULL),(1000006,'Twilight','Sparkle',800004,40003,'2017-12-05','2',NULL),(1000007,'Tournament of Bob','Bob ofc.',800001,40002,'2017-12-11',NULL,NULL),(1000008,'Test Tourn 4','test4',800009,40002,'2017-11-22',NULL,NULL),(1000009,'Thunder FootBall Tournament','FootBall Tournament',800002,40003,'2017-11-20',NULL,NULL),(1000012,'Campus Test','Test',800012,40001,'2017-11-23',NULL,NULL),(1000013,'Team Class','Class Team',800014,40002,'2017-11-17',NULL,NULL);
/*!40000 ALTER TABLE `tournament` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tournamentstylecode`
--

DROP TABLE IF EXISTS `tournamentstylecode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tournamentstylecode` (
  `TournamentStyleCodeID` int(11) NOT NULL,
  `TournamentStyleCodeName` varchar(45) DEFAULT NULL,
  `TournamentStyleCodeDesc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TournamentStyleCodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tournamentstylecode`
--

LOCK TABLES `tournamentstylecode` WRITE;
/*!40000 ALTER TABLE `tournamentstylecode` DISABLE KEYS */;
INSERT INTO `tournamentstylecode` VALUES (40001,'Single Elimination','Single Elimination'),(40002,'Double Elimination','Double Elimination'),(40003,'Round Robin','Round Robin');
/*!40000 ALTER TABLE `tournamentstylecode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userroletype`
--

DROP TABLE IF EXISTS `userroletype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userroletype` (
  `userRoleTypeID` int(11) NOT NULL,
  `userRoleTypeName` varchar(45) NOT NULL,
  PRIMARY KEY (`userRoleTypeID`,`userRoleTypeName`),
  UNIQUE KEY `userRoleTypeID_UNIQUE` (`userRoleTypeID`),
  UNIQUE KEY `userRoleTypeName_UNIQUE` (`userRoleTypeName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userroletype`
--

LOCK TABLES `userroletype` WRITE;
/*!40000 ALTER TABLE `userroletype` DISABLE KEYS */;
INSERT INTO `userroletype` VALUES (0,'Operator'),(1,'LeagueOwner'),(2,'Advertiser'),(3,'Player'),(4,'Spectator');
/*!40000 ALTER TABLE `userroletype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userID` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) DEFAULT NULL,
  `userPassword` varchar(45) DEFAULT NULL,
  `userRoleID` int(11) NOT NULL DEFAULT '4',
  `userTeamID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`userID`,`userRoleID`),
  UNIQUE KEY `userID_UNIQUE` (`userID`),
  UNIQUE KEY `userName_UNIQUE` (`userName`),
  KEY `fk_users_userroletype1_idx` (`userRoleID`)
) ENGINE=InnoDB AUTO_INCREMENT=900000032 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (900000000,'admin','password',0,0),(900000001,'LeagueOwner','LeagueOwnerPassword ',1,0),(900000002,'Advertiser','AvertiserPassword',2,0),(900000003,'Player','PlayerPassword',3,0),(900000004,'Rob','rob',0,0),(900000005,'James','james',1,0),(900000007,'bren','bren',4,0),(900000008,'Mike','mikey',2,0),(900000010,'phily','phil',4,0),(900000012,'sam','sammy',4,0),(900000013,'roboo','robby',1,0),(900000014,'philyd','philyd',3,0),(900000016,'tay','tay',2,0),(900000017,'bob','bob',0,0),(900000018,'Adam','bob',1,0),(900000019,'Tim','bob',1,0),(900000020,'Tina','bob',3,2),(900000022,'Dog','bob',1,0),(900000023,'a','p',0,0),(900000024,'MarkTest','Test',3,8),(900000025,'Jim','bob',3,2),(900000026,'bill','petty',1,0),(900000027,'sample','user',1,0),(900000028,'Class','bob',0,0),(900000029,'Joe','bob',2,0),(900000030,'csquared','kettlecorn',0,0),(900000031,'SpecTest','Test',4,0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'arenadatabase'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-29 17:37:14
