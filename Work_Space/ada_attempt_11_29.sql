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
INSERT INTO `advertisment` VALUES (48,900000029,'festa_pokemon.jpg','ÿ\Øÿ\à\0JFIF\0\0`\0`\0\0ÿ\Û\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342ÿ\Û\0C			\r\r2!!22222222222222222222222222222222222222222222222222ÿÀ\0wô\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0O\0\0\0!1AQaq\"2‘#BR¡±$34brsÁ\Ñ%56CS’&c‚ƒ¢\áDd£\Â\âğtñ„”²ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\06\0\0\0\0\0!1\"3AQ¡\Ñ#2aq‘4BCRS±Áğ$ÿ\Ú\0\0\0?\0óß“\ßÑªµú\ãÿ\0¸Z. É ˆ¼\Z¬\ï\É\ï\èõ_¶–ûı\Í?\Ä2§øƒNŠüE,Ï¸0\ã\\SMŸa\ËD\Ì:6wòÁp-\åz\ê\èTğ$s³­‚EøüÛ”b‚H\îPó±À\íO’6\é™p\\T¥•²\\)†Fœß‚eÔ›¤\Ç\Úù¨B\×\ê\Æÿ\0Iª°\"y\r*6\íYó(œ\ÖFbñH}óüVÁ ƒ”\Ä™WË¢/9p9R’(û€\Öö)©<c\È}P\ÛP«ñ\0=¥>6-9Vl\äzMPª¸ñ\0ô\çÁË½\Ú\åm†ô\raoz\í\Ñs¦ü\ÃcŒ{š[\Êd\é÷J.N7I8\İ ¤_ì•©²şºv`¬»µZ{)ü?İ…§c\Ë3/øAc²h©\Z\Üõ;)D\Ü4g\Íh\á‡n‰ÁÀHj‘\Z¤\ÂÄ„\é´=„(½€O„¸#)aHøÁ\Ù ¤q¢XS\Â@d$4N\á-‚.‰°¤’@ {°–°˜\á(\r…Æ¤~M(#>©]ú.\ÑT<\ì#%#\à/·Óˆ¢\å\ë+—¦:\Ë¢p\Èp\Æp\Ü]¿\Â@\Î9W¦0(©­…g”WA-¢ğ\à2o\ç!ze¶¥•tP\ÌÃ\æ \\kiR¶¾6úñhüu\n§\Ü\Æ_nş´Dş	\"ô\Ë\0m\Æ0¤6LÑ¢˜S\0Àw©øO„dB;¥Œ©\0Ÿ`%… \á#4O,`\'\Â@\"|\à\'\Â#„øR\Â|$ \'ÆŠ@\'@E—ùD\ìlß½j\ÕcE—ùEş\æMûÖ¦Ë€g†\ÒNwIWnşO1U´šú3m¶g\äûJzƒÓœy-E\äf\ÚuúÁfUó\ÍZI~\"Q\ê3\È?^°¹±¸µ\Ø(t’Næ°†ú¡ <”LU¡k°|UB>\Î^»ñ³‹Ÿ#I%t§cı:™\î›%Fòp­¶9™YG\Úg—\\`ø%»\Çi‹k\æ M+‹}$ƒ¥V\Ã\ß \Æ	ÁT¥cŒ\Õ\rUØ¡—\r;Slq\ÚD—\Şk+\â\ìüix \áM¬”¸†\êWgC)Œ9\Í\ĞuW$\ÑM­¦\Õ®wı\é†~\Ò\íh«ªyZ¸\ßó\ÏN1\ÑË¾ÿ\0Î·§ù\rKù–®„®T¿™n‹©\Z¨™¥§\è™$\n8	\Âd\ä\è”\ÎJ\ÓY±\èñ÷af:­-¡Á”ñ§\Ñì´¬yfe÷&\à{hû°U–5U\ØŸ\Ît\î\nÀZFa-”€\Ê`¤Ô€16\n‘\İ,™`¤ª|j€	uO\É\0˜Hl¸\Í<tñf{Yw$®T7*[Œn’–a#\ZpNdv%´¶I$dA\Æ\É$Ôˆ9@\r„ˆO…,{\Ğ4Š*[I\Ãõ›“\Ôj8[\à°qrV\ÇD\Ã\ê@9æ£œ°‡$q\àˆ—z‰zEn|Jô·Eœ\àšMeô‡·T;›\İ\ÑiÀğIOd9!d\Ñ>\Z0r¼®\ãK5‚úy2n\çÅ½\ËÖ¹AY\Î0³·\Òco\Ó\Ó\ê1\Ô\"¢\Î\â ¶º;•UQ‡|\n¼pm\ßĞ«\Ç\è\'ö3õ\\½hHN„“B\à|\'\ÂCÜ¥S„\Âu,$ˆ	ğŸ\Z\'\Â\0`Ÿ	ÀOŒ™8\è¤|h–K	À\Ñ>d\á%$€I¢\Ë|¢ÿ\0r\æı\ëV«\Z¬¯\Ê0\Ç\ÏûÖ¤—3\Ã\é$wIWo~Oÿ\0EŸ¿Ÿ¦û-E\àV¼÷²\ÜO£K\İ\Úª¼fI\æeo<Õ·òFˆA\'®\Z¯(±úˆ\\ue/f\î­n#4&bV\ç—l®¦’n\æ+ùŒsÚ\ÔW%ö\é;óü\'g3\É z¸VŸ3-#\Z\àH9\Ó\ÉY\í±m|\Ä£g\å“øLŠB1$ß´†S;–²pN>—$ôD£‘|¤½¸\'#T\Û?)_y¥hó\Û;È«¢ø*1\Ê\ßH%\ÄcUni£|­{K»²­\Ë%$5¨~[T?Uº®A¤\Ô\ÃÁË­™üõµoT.\\Aù\Êmw\æ\\•\ïø–u½;\È@Zo\Í5v;®4\Ø\ì€ó]ˆ\n6iG‰H¤G\ÎD\ä%¢D!«CaĞ°¸j\ÕgŠ\ÑXH,\0m\È\nÒ²å™—\Ü \ãB\è€\İtD\Ì&\n}”B—¹ £e8\Õ.©ÀH„\é%®\Ø@¢C.—ªkcC\\C\çvˆwø¨\×\Ü\ß\Ûú\r¿Ui\İ!°\Ò5„Ô°TN\ïjWŒ|;•;‹¸\Ò\Û\Ô|RMd\nö\Ï[/¤W¿™\ÇV\Ä=–%{†°Ú›ƒC\Ú@\î\Ñp|>[-19Á\î+¿\r\ë…\Ìş»GÜŸNjqR5kB.œM(RTšğ¦2\åñO„\éğ— 7*Iò£,Š3#\Èk©%#`Q»Ü£´Û¤ª—p0\Æ÷•\åğC=òğ\Ø\ÈÌ•\æƒU\î&¾›µq\äÏ£\Äyco\Ú+Q\Â@¥ôÚùT\Ã ª\ÕñKği)\àe<\Ã‘´4awğL„øS B\Â|\Ò‚€\Ù60|Àò\Î(²¾\Ñu\ç‹Õ‚gs\Ä\áõ]Üµü-}z.\ÊWW\ÃÁúÃ½¼Za¼[ŸK(ø\Ìnû%y`5\Ü;x\É•»\Ö\Õ\äyO_n\Ê]UU\Æ­upl\ïhg\Ù*ğğR§\Z©a0\ÕH  0>7 $\éğ—T\0°0–2œ\'Æ©\0\nr\ãDd\ÂXRO„€C+ò?Ø©ÿ\0zÕ­Y?”\îTÿ\0¾bFöwI\'n’„a»\à!ù$ı§ğZË°Å®e”\à?Ğ¤?\ï{ü®\ëı™)ğY•¼\ãZ\ß\É\È\ì²?\Ãj:l´ø\"š\İL÷F\Ç\Í\È]]IL\Âf|—UoU*i\Å\Ä™ƒ\àZ<‹„gğZC\æ&ª\Õ4\Ğ\ÅSLö\Ç\Êyñ¢.j\'M…²}\ÄgÙ¬õ`˜¥¨\è¯[¡ŠK…h‘£\0õVŒ4-\'.gú“,gød·\ëñ\0\à=”øÀØ¢ı5-ÿ\0Rq\rF\ßõ+®{QNÍŸN¨\ì÷ñŸE=Ä«4L·J	½˜\Î<\×ûG%7\íÁr7\ß\âY\Öô\ï!\0)\ÏÑ2»’¸Á¤cÌ®¤\åD\ÍÁ2	\èI’\è€\"tn‹Gc\Èc7g]\ì­\åĞ´ÀZ6\\³6û„n\ë Q\nc=V‘š‡\nA©§MÈ£ >ƒ$é¥#u\Ót\n\ëvw9£¢v^t|ƒ\êª× o9¥¥•¬fÏ˜ŸÁ¤¨¥x1Á .ëœ‚~*>\êÎ’ı¥´j<É–l®‚\Ût™²¿ ¤wSæ´²\Ô\ÃK¥™\á­h\ß;¬¼°\Ç<|’´=§¡\\®”9¥Á\ï\0\èò@÷*\ìû³Õ’\í^¥,\Å\ìJJ\Ó-T\Õ\\{¥öÑ®±ÁÒ¾Y\î.{\Î22¸S\ÇÂ±\Ø\Ì_E†U\nh\ÍÁ\İy\Ç\àNzg\Û^…KššWip{vS\n,SWŠ\Æ¤F‰œCZI \02IF@G\0\0Ô\å\ç\ÜYÄ¾”÷\ĞÑ¿\ì\ÒI\Ö=ÁOŠ8°\Ï\ÚPĞ¿–¤’­\à.\áyn’2ª­†:&œµ¤k\"†Rm\á\nt\áNu|\í¸U\Æ[Mú6\í\è\ÍhEbdQ¶601­\0t]p¤„p„©aH\rRÆ©À ŸH “ 62³üS\Ã\ÂóI\ÚÀ\Ğ+\"iûC¹h’\ÇQºl’hS\ÈlW™¸~\æ{F¸BO,ñª{×ª\Ó\ÏDš\Äñ–¸,\ßğ¸¸1\×\n&RÁôŒ\\ <!\Ä&\ÛQóukˆ§{°\Â\ïğ\İÜ£OKÀ”Ğ¤\àps‘\Ğ÷®ƒÁIB:’d\0°–4KÁ> ±¢I\Ò\Â@t° ¢\ê’E.ˆ,§\ÊG÷*Ş±jü–S\å#û“?\ïXš\Äg„\ÒIÛ¤£#7œúÿ\0}ü;Ö²é­²|Œ\è²|	ıÿ\0\ß÷øw-u\Ã[t\ãÁe\×óko$\ëipùª˜°®õTmok,\ÔäšTşq‹¨v‹¤ ›‚9Ë—ŠŒ´r©\Ö\Ú\Ó\Î!q…ü\Ø\È\åP\ÇV\ÉSp™Ÿ>ƒ	Õ¢ûleøˆ§ü¦³\Ö#/MÙ—…Ò–\'\Ë[Z\Æ}ulSMJ\ÇKË‘\Ô”\ë%L’ÿ\0=Âˆ\ã ];µªÑ¸3•±€\îõ\È\Ö\ÊÑ¸\ëê«-W\'[TE•s—nX8ƒH©ÿ\0lş\n1Ş¨á¯•õ2\È»€B.\Ü@*\ådPR¸°‡‚|‚\å/!)\\7ƒª\éóŠ¢‘\Æ\Íû\Ê\èB­K;ei\å\ÓPz+\n±§6ÁH\'\Ñ \áe\"R:¥„ #¨Z‹i™õr³e¨±~Œ\Ï\ÙZ\\³6û„\ZhSÂ‹T\Î\ĞÉš8RÀ\n¬õô”Ÿ¤T\Åƒ¦ş%´3CZ\Ò?U®?€MÔƒ)I$œ4jI\è³[\Ë\ê™44y0z\Òı¯\0©\İøšº_D†gGM»\ŞXG7Ü¸ŠŠ:ŠWCM4dc\rhv¥G){­(\Â~&\ÃK4\Ğ6yXQ \æ.v¸\n\Íò’[äœµ¢X†Z\ìj¸\Ñ_\èE4q\ÔT\Å±´5\ÂGr\ìª\\®\Ñ\İ1IFK \Î_.4>KeX!	º¸‰\æ4 ëœ¯\ì\às€\Ï(\ÑA\ÔRCme\Åõ.øZr…±)ªij7¥USIHUP\è$š\è\Ù^$\Ê5ÁZ\Å^şù@û\Z¶²¥\Ü\Ò\0Fş¬·\Õò{}5Ê†]\İH\Ê\ê\Ú_s<š\æ\ì¦<T¶«el4Î¢@\Æ4u;«fY\Öi£‚K+ƒ#h\Éq\è¼\ïˆø¶[ƒKF\çGKœd{R*·\Ş\"ª¾\Ô6š®†D\İ\ß\æ´|7Á\í¤-¬¸0IS»YÑŠ\'-O¼9Á\ï©\ì\ë.l\å‹Ú§Ä­üq†45 €\0\Ğ6³EÓ—	\ÑJ!‚!ª\\©ğŸ	\Ùlh˜…,ü©29NT\Â@\'@`l\'N\0C\Z\è°|e\Âø\ç¹Ğ³Mæ¿ˆ[\ì\Ä\Ò2\Ò0GzkYÁüO\Ï\Ém­x\ÈüÔ®;ø¼i\ï^eÅ¼6\ëU[«iZ}Gg-ÿ\0\r\ËE\Â<D.4Â©\ãÒ£ıp™cf¸j\áA®RÊ	“\á,$\È\r\×Á?T°Ÿ’\Â|e [©a6\Z“ùHş\ä\Ïû\Ö-vK\å#û“?\ïX‘ˆ\Ïv\é&;¤£#7¼\n?«_ÿ\0\äuòZúñ›t\ã¯*\Èğ/ö\\½ş?°«Ç¡\É\Ì21·zÊ¸óM{_(s¨\è\ÙÍ¡}è‘·\Çó”•0š²b\Ä)ºªm³\ç\Ä·FòQ‚ZLŠöq”\Û\Ô4˜\æL\×:!T\Í\Å\Æ\0:8¦mU8$‹uF|2šxYe\Ñ8\àS\ê^9A­#h\Ù\Æ3OQÚ‚fAr­sİ»¶Eı&9\é¤»ª,\Ñ6¦Vš3\Õ\Ø\Õ&L\Ã\ì\Ú]\ã¿òP[\Ü\è†4\ä\æ\Ö3–u`\í\r–¡¬\Å^}\r\ÑÓ€†5\ãB,\Î\Ïÿ\0|[•Ka£{¤°¸\à<•·/ö²¢°‡û€õ\Ík\ëª*\Z{FFp\Ş\ã…M\Ò\Ë\éô®&K†OEuÜ”ô¥¯\ÃA\Z\å¦it­“<Ãœù*“n¦Yz\Ş=¹$‹Õ­tY\è›Ş­\Ã3\'™„x…Ê´b\è\íwŒ*±F`§–®3\ìË‡5A*²§\êi*Vq\n\\¡•³FÃWPª5‚Ò–G\êE8H(\ãc¢\Ô\ØiY\àÕ–×¿tj’\ä((\ãk\ÚT\Ê1?‰W\í2f_<,š\n\ëŒèƒ¦q\æ:5.CÎ—GfGš*c³ù\ÇyŠ§R\nš¾j«Œ¾\Äc^_\äRp\åÒµ½­us©\ZuS´s\â\ãü™UŠ2%)Oh©­Tú¶…\Çw¼s8ûÊº\Øc\ZŒy+o\àÈ‹s\Î\áŸl\Ë\Î>\r’*\ëMX¥¹#ùº˜\Æó\éaQI\à‚t¦–rX0±Ûµ§\Ì*U;mVL´p—¬ƒñ†1\×\àŸª“®§$öff§„¢µK\â \äG(\ça>ıUIEu¸~[GôcüZY¿\r\Â\Øî˜6ô\Î\Ú\\-ú…j/g“)\Ğ\Ô\Å\Íƒ\Øt*¬\Ôp°—Hæ˜^yG¹¸XcOH££T£\Ùw˜Y\ê©\æşWŠ`wú®ò\îL¨¶ñ%ŸR£r\Ôg³\Ö¹‘®uZ¾kE|h\Ñ9\Â\È\Ô\Ú\è³\ÜtZ\î•”\Ü;,ò¸61+œI*¼Œ‹©MºšM}Â\ÙJêŠ—rµ»¥y­\Ê\é_Ä·&\ÅA8!°\åBùx¨¾\Üyc\Ç\Í\Ëc¯Š\İp¿¶\ÓH$”U\È2\ç}Ÿ3n[#4n\áxm‰eJ·Y\ç\êø¥k0­Â˜=, \á!º[#\"ˆ\ê%\ícœ\à\Ğ7$¡3ñ^\èé„•r\r\Ä# y»d™\É.BøRYÿ\0®9eº6\çÏ¯\Ü·‰{\Zú`gùŒ=£G5n1Vƒ\Û!ğp¦«‚®-<¬‘‡«NWl\çœ’t°D™> 5\Ğ\ÕA%<\ìŠA‡¼’õl©\á«\Ğ144óBñ\Ôw/`Æ¨?\Ù[yµIO\æŒõ\Êd\ÖÀ=†\ê\ËÅ®:–\à?²â‹Œ/)\á{¬–KÉ§Ÿ-†WrHß²\îõ\ê \í¨\è–2\ÊjI‚Ja8N \ÂXğK)²L€€K\Í$ş,—\ÊO÷&Ş±kp²)_Ü‰ÿ\0z\Ä1\à\Çt’v\é(\È\Í÷kh—9À¨[-}iü‚}3\êŠù?iª\Í	.lrË’\æ\èF\ëa|‚–\Ş\ã+\Ş\á‡5\Ï.y*5h\ÊU5\Z4*¨\ÃIZ\"}\Z‹û!w»Û€°U¡s=\Z¨ñE*\íş“\'j#e\ĞÛ¤ ²Œ©K¸Á´,x2»p\ÕxIù\Ê®®F\"£}4«pƒGú}?\í©*¨¸Ka”%.\â9\Ü\ë½ßŠ#B÷)\'\ê®\Ôí¨¼Ö°œdN:F\Ò\Ç#ƒ‰\Ëzª\ÖZ{xÁfıË¸Q¦q5‘‚NŠ\r—š®9µ/.-\Ïr3Lö¾±œ½~\ïDø\î.«Š9$Á<À«5£\á\Ù(\ËÅ»]\\\ã nIieF	#a™ÁªòJ\éf.›-9ö\\0“K]30Fš\î©\Æ	R”™µ\ãŠAz\Ç\İ2\×9\0\ÈP‡û&°ÿ\0¼Ï¹\n\í>G‚F2»\ÇXøí¯ˆ€Cİœ¨\\1ıKªY®\ß\èwu$Œ{\Z\\\×ûM(\älnÊ…$\Í}u0:œ\ç\ÉGµ4\ÕR¸k	y\È\îQ]RÌ±-\n˜‹“{	Âƒ\\\Ğæœ´õL\é\Z\Ò\ÉqÙ­\'Ü³ğ\\sX\É\Ñ\ïaq÷x­\r\Û]U\ëL\àKC¾¨Cm–jš\ê˜æ©…\Ğ\Ó0ó»w{–ºfò\Ñ\Ë\Ê6a\0{•ûzm,³¨\İFoDKœ-D&k\î³i$q“\Ğw­KF:!¶µ–:°iØƒ\ïêŠ´kº9Mb(^\ä>õnm\Î\Ó=3½¾R\è\İ\ÜB…²®\ãS=[+¨\Å;#“¸ó·½s¹Z\ç;`\ÒI÷$Ñ‡·L\ê‹|2;\Ú\Ç+¼ÆŠ\×UJ\Ò?«šî‘\îòU\İÎŠ\ä[Á“5‰1l’ª\éªj*ı\ß–o¬÷{,W\á\á)dõ\ê\î\ÕOy\ÜCˆ\Ø<º¤•Eô\è\ÊgŠ¥\Â\İÊ˜\Ã0\×ê»¨(”¼\'P\ÈÉ¢º\Ô6^¨\Ã\Ú~ì¡±\Ï<5FŠ¾>Æ¤mö_\âğHªF[t§M\æ\'Ÿ\Ü)jij;	A\í¢wª~\ĞR\è#\áˆ-\Ñ=\ïs¥¦«W\Åö\Õ\Û]3r\Ù\à\ÉiÎ©¡–¦VEŒ\É+ù@\îQT†—”h\Â\ë½«”m8\Ê\Ù\\\ëœ\í\È¬@ôñ^„Ñ•+]hm\ĞS3@Æ€|\Õö¢°…:\Ä•4Â–*i»\'\Ìüsƒø¡—K(Š¿µ™\Ú2\'\ÄÓŸ†5.#	(ú’Æ“qrô5³\ÔCKšycr\â€\Í\Ä55n\åµ\Ó}\Ó\Ò&Ñ¾\á¹T#¥©ª{*.’‰\ç01Atª¸S\Ñ\0\É™³FIS¥¶dg\Î\á\Éé¦²Æ’ŠJ·ó\×\ÕIS˜}VøB\é3e‚¶ŠœF\ì.\åğ\Ñ\n}\Æ\ë3³p@\Î\és±\î\ÑG\Ò\ï1’y©%iiüJEZš\á}:ò¢\Ô\Ğb¨\ÔDy¢tR4\á\ÌwO#\ÕF®:©ç±K\Ø\Ä5s\Æ	>sou-Àš\Û&{\âxp\\¦²\âq&i©ÿ\0\Ëc½gy”J´\ÎH\étÛ‰ONœe6\èjK¡®mH\İ\ÑJ“\â6(¥\Ò\ì\ÇzÍ†\á3\ÚBC_-¹m,\rg …œ§pFWolR	h¦’–A¨\ìÏª|Âƒ\æbı\r…\ÒjAeK,\İP\İ\è\ëœY…³7Ú†A\Êñ\î*ÿ\06«Û¬rD\Ø/ğaÀ\â:\Øt-ñ$jújÊ›tqš™…mñ\Ù\ÕÇ»kù©TòVœ%‰ ú}\×8\älŒk\Ú\à\æ»PA\İtI\ÃD7O\×)ø=\é\0ó>=³\nJöW\Â1ú;\Za\ËQ\Â_œì‘—»3CôoVxªˆWğ\åSq—\Æ9\Û\îX¯÷·S¹\Ä2¥š\Ö	™Ä…=D\r†Ë›N›®O|$–@E ’\0A$†\É +%ò•ıÈŸ÷¬Z\Ï5“ùJş\äOû\Ö$b3ÁºI;t“Cù5-„­F3\îZÛ¬lmÚ­Å \ËBVC\ä\ç!Œwşd~eu¸Õ“şZ¯Qò^¢¸´IL\á¸nŸ`\\*i÷+¶š8j­p¹\í\Éø«\Æ\ÑJFw\Åm[Ti&b\İÁ÷^\0®¸T9¥¦]‚§\"¶—l- ´\ÓmƒñUk­\ĞCR0[ \ë\âŸV¤t4ˆ\èE÷)’º­cšpqÜºš\éœ\Ò\Ó!Áğ]icl×š¦8cDO\æ\ê³÷¨,¤´nZ¿‹s3ñ»³”=¯!\ÃÁw7	Á\Èp\Ï_T\"ÿ\07S—h\Ãñ]\Ùk¥-õ£û\Õ\ÉU©B0`JGŠú\ÇúLQ?•šep»\Úh#¤ôHC³»[‚Œº’\ZK§,,\å‹\'_V\î?!w˜\\½ôÿ\0ı¨\éñü\Ì?\ÍT\îÀs2~«—)­<Y\ÜCuÁh(¤c\Úı¥)˜\Ü;ÁNUg¶\å·N8l\çK\Â5µ0AW\rD$=¹\rp!\\²pÄ\Ü\åŠ\ë$ˆ\0vA+C\Ã2‰,4¿¨¸£X\çªÔ‚\Õ\â9šõ\êE¸\'±€º\Ùe²TóÀ\àitc¾¯½U¤®wjz–0É»\\\Ì}\áz4ğGQd¬a\Ü±÷{”WHf¢ C)Ãšã·‘è¢¥©Q½“‡nF®xç…²\Ä\ìµ\ßw]ùCn4p\Â\Å\Ó\ÔVğ\İqenM$§<\Çfù¯†fOd\áÑ¸e®iSFyØ£8´Âœ3X\ÃL\ës\'§$\0z·Ái\È\İb*)$¨§™\Ôõ,ö^İ˜\ê®A\ÄW:vòV[»w™O õ¼Á\ÆƒL¹F²kÖŸ½¿W¶*sC&¢a‚\Õ\\¼Cs¨im-\0¦\Ïø“\È	MoóUa\í•\Ó\Ë!’wûOwğ6÷CªWŠ[\"‰°B\È[³:É=’hŒ7Ì®\åU«gk=\'gÔ°%a\ìŠ+y\ZK%µ¶ú4¦x\æ‘\İI(¨P\ê{Û”wW](]A,m¤ü¡®ÜM¶jE$°‚\Ú!Elm\Æ\Ú\é1S¯º\é\Ñ9\è\Ô\à\ìt(­;¹T¶^¨é˜|\Ë\Â\ìª\âJv\È}†—ã¼£×¹;ªˆ\rK£o—2\ÌXeu-\â\n¶r\Ê\ØÏˆ*W™4ŠÔ’‹y=‰ƒL©\ì¢Ô¤{b\Ò<\á%<·“3\Å\Õ.‚²\İÙ°\É!q\åh\ï\Â\åAD`Y=Kõ.û>(\\n¯¸Í«s\ËOAŞ¡t¯4\Í@A¨“o\ÕéŠœ\îK’¥Z³ªû4ıH\\.f)E-(œûN\è\ÅJ\nf\Æ\ç=\Ä\É3½©¹J™K‹—_#\ê}U{¹h@lcGNı½Ãª¯9Ê¬±z\ÖÚ=uy;\Ë,p³šGµƒ¼œ.,©’ ~KK4½\Ï\Ç+~%¦²SD\á$À\ÔM\Õò\ëğH04a \0µÿ\0qJç¯¼\â’2‚\ã(õ\ß#õAqş³le\ÍúZ\ê‡~\Îø`$§T ½šR\æoy£\ÔG\Û\í\ß\âfwóLxzkµ1Õ”Ÿ\Ç(¿ŠXN\í\ÇØƒ\ç+\ç:˜KMl@ˆjYP\Â=‰Û‚}\ãù!”·>švM	m‡Ö¦ó1\ÃÁ\İÀx¨½x\åsCšwb£t¡<z•g´÷E+=\â\nYC¡”º\Ù1\Ç!\ÔÀ\î\ì÷-‹N»\åa\Ã\Ñ\Å-D´$³´a\æ§İ?\Í\ák¨¯¢};İ™\éO#\İ6+2\å*Š¤u#F\nsŒ(=0œJs’!42Dv{KJñh$6«\ë=¤ƒ\å•\íƒG\âüKe¹°t“˜(\çÈ¨öH\Ü\Ğñ³€!uB\ìU•d¢›r\è†QAœ\'ˆ:b6N$–\á€Oºd\è,Ÿ\ÊW÷\"Ş±kVK\å\'û‘Qû\æ$\nwI#ºI¤fÓ‚j\ßOLp4mC\\Nv÷-\ï—S»\Ób|nlÃ›Ç‚\Ãğ[#6*¢ö‚\à\é¦­ô´QÀ\ç:Nbê‡¿8ò\n¤\êF3iš \ÜA9´3O¬T\ê/…\îca.Æ„\ç\n\\\èá¶˜fŒ{^t*¥udN\å™ss»ZNV­¤\á¥e™Wp¦\Ò\nGw\çÿ\0Ô¹W\\L6>ÈŒ\È\İsâš‚ª\Ü)\Çj\Ù9úı¿’{…U¹ô¼°\Ç7h=“»ü“\ëÖ¥¥¤\È\èÑ©©6TÊ7j7¢\ÏP\ÖSGxši\Şb‰\íÀs\Ø@\Ê\ÑS\ÏER>†¢)eÀª\Ö\ÓZpZ¼¦Ü²1tp³´‘Á­\Î\åIµ08e³04;ˆ\Øá‡:ô\\!4¦‚\Ùst\nú†c“9·‚\åC˜û,pv\"\ÆA\ÏT>\êG ;=\á*~\Ë\ç¶\È>^4\×Lú\Î˜\\\İò\Ås¤\é\ï4Œ¼g\Úı¢§¦vPg_\Ú)óª\Ğ=\Â2b’¦Ÿü¹‰õ¥\Ï\í—Û®\ÒrŒ\Ç3Apò[J:\èª\Ø¯QVÅ¾e\ÎK¨CMf^Com?7@\Ö7{²ˆŞ¹\ÔD*)¥„Œ‡´…+\à¥¹GM;[#$nhõ\\2B\İE-œ™-ñ—\Ó—ÁŸg\ÉY³\Êd·27{p“½ÈMa=\Çd­MW\r\\BH]‘Õ§v\â¬gªSlk\åôŠgú=Hú\Í\Z;À…\îFˆ+\Ù\ØJNñ\ê;È¥B~Á2—EY\î\Õ1–˜q¯ı•[\Ş\ZV\Ë\\]8nCCIÇ½\r‚M„òKŒ¢\nx\êy€\ìdø*pÁpl™•–G˜\å\Ã!Jjk\ê\Û%t=“´`\ä;Ş›œ¡\Ë\Âòm\í—*{¥#j©\ß\Ì\Ço¦\Å^ò^on¯¹Z®õ±\ÒFÉ©²\Ø8\àûŠ\Ñ\Óñ…€0\ÕÒ¿«d„Ÿ¼d*²O&”*&·4»*wJ\æ[\íò\Î\ã‡`†ò…OÅ´-\0SGQU!Ù¬ˆ€<\É\Ñ	–J»G¤W‘\êû°ú­÷¥„u0©UEn*\æ‚\ÇE´s\å/wâ³¶ÿ\0\ÑZ\ì\ë\é ı\è\ßLUL3SŒ öVvï¦ƒB]VŞ¥Š\Ä\Ê\ÑnQ\É\ë\ÍxdBG¸5¡ ¹Ç¦‹#|¼\Ô]dŠ€–R½ü®”\îğ7Â·tªuÒµ\Ô<¶’%s~±\îSm,Mte¬\0\Æ0ÁöB]9^\ãG…rFy¢·\Ñv˜‘7\rj\Ï2V6®j¹e{Œ‘‚Ai§ìŒ«:¶TU\á\Çòjs°ú\îVh-ÏQYX=oğ\â;4wŸóQ\é\\\Úéµ‡~|¾T\Ö\é®.lµƒ³¦\Ì=]\æ\ÇYcZ\ZÑ \0h€ÿ\0öŸ¸)¡„f\İ]Ô¸–©1’Î©)\n„’L’\0Á$\Ù\Ât\0’I,$Á-!\àœƒ•\ZŠXm\×H/”ùcjHŠ¥£\Ù\ÏB¥ª°\ÈE}²®…Ú—0¹(¦¶\ÉrÖ¦™`44=1Ş§\Ñ\r²\Õ\Z»M<ö\Ãy\æ4D@LO&²\à]Fñ€ÿ\0j.\Ù‚õü`¼_‰\'ß®2¹\È\äÉŠz/’\î¢\ÏF‘÷­\Æc\áŠzÇ”}©Ë€%¤\ïI\0,\'\ê™3œ\Ö\ä½ÀÔ”¡Rd’*Œ·z(²\rC\\GFzß‚ªş\"¦ú‘L\ïøp>ô\×R+–=S“\áO\å(±½b xˆkŠGû\Üc\ï.«\á7\Å\èü2O6SUh7Œ„¨\ÏÁ\ãn\İ$\Ää¤¤ÁX\Şğ<2\Û*L‘‡\Ôo\åÜ¶-¥§\0b¥cøx ³\Õ:YZÀ%\Ö>Bş ·\Ä3\ÛsŸ\Õ:ºz\Ş\r[o,&Ø£F\Ñ\ä\Î\0è³¯\â\ÚfûH\ï2\âş-\ÓÔ¥÷(tÈŸcO‘¢Z,¨\â\×g¥\ç.¬\â\Ø6’Fø‚\nW±¤pj÷*’[¨\åw; hxú\ÍõO\Ä*q5ºS‡=ÑŸ\Ö\nüUÔµì§\ŞNI\â@\ã\ÉÆ¢Šw½­\ÏÙ“a\å\Ñ¯,€†W\Ñöa#;?˜\\\ÎşIò\×\ËUbµc³yEj–T§¾ó\ÔÁ-\Æ))\Ş\É#1\ÏÊ§u~-³x\áS©´óQC!¦¨ıS\ê»\Ì*sÜª=Jj¸H˜h~*½Y:³\ÔMBš¥ æœ—y§;.p9®i-9\İu*DY\\*$Mö]‚|8&|‰#v\×Nª…D}­4ëŒ…Ö–NÖš7õ\Æ\n\Ö\éó\Îb\Ì¯O\rL\Ú[®,¬S‡Â¾\n\ÄS\Ìúi[#	:…°¤©eL\r‘¾õvq\Æ\æ\Ze9\Í÷\Óh*F\ÜŠwªW7\Äh\İ\Ç3ß£\0\Üõ^’zš!%É¼’‘\ê<‚yNÙ¼2eJR¤‚ªC\Ì,‘¡\ì;‡\r\è;fEÀ²{],’\Û\çå»\Ã/¬\Æøª£ºTÁe’•\Ì~\â\ZZ@E\ëCR\×lc9ø.6¹{k],„\êc	¸\Ë—Œ–š\Â\Ğ@0¥\ä\á>\Éøœ‚.\Ô5\Ñ\Ü\0&29%\Ş(£×°9§-p\È)>6\Ë¢x\Ë0BA#\èª\ßo\Ù\ÔN=Grn\Èz{±Ü¹\Í(†=\Úr„î•‘´¹\Î\0\r\Öz\ësôŒ\Åõ:õ$c‘F{ˆ^jg:‘&ş\nƒ´ôù\Ş\ÆdS\Æé†Šılbj9L…Ë„\'`¸\ÕRK\ét®Œg¼(«­2L¹ló}®8\ŞFó¸÷’¥u­m¾\İ-C\Î0\Ñ\ŞW;4…öª|Z\ŞC\î\Ñ5}¹\×\nús.\r,>±nwwL¥|\äñS\Ä²\Û_3cª«\ÚcS\ŞVŒx¦\rÇ†‘¨¬ ­ZU^\âI$º\'	:I¤™:@t\É\ÂYI$\0•›|‚*ø\É\Ù\ÇV\ê¤\Çr\Ê\Ã\Ü\àRIe¦ñ$\Ë,G-Æœh\"ªv¨\Ø\Ùµ/—†ƒœ\Ì÷#€\è Fô^R)\İk[Ak©©qÀc<×Šú©\Ãu2O\'\âVÿ\0\å\ê\ÖR\Çm‰Ş¼‡™ø=c„(p\âH¢§\î8\ë\ÑE\'—\çª\ĞS6–Š\nq ¿r¸\Z*º\Úz\nwMQ cGN§\É=¼MğZ÷¡õ—zJ3\Ê\é9\äûÔ¬\íUÒº\ê~ˆº–”ô\×pó\è¹\ÅN\È[†w¥U©t–È·NÕ½\Ù~{\İl\î=‹[\Ù\ÕÊ“ûIg•ò\Ö?ÁK	•)Ö”‹p¡‘h\r«Brs\à¸\ÉYOõ\æ`÷¨÷&Ò‘\Ùgø\Ëûµ.?\Ìj û\Õ3‡¸ù5gøª\ïM\ÂÀ\ì¹\à\ä…%$õ¢:¿‘zwI#ºK\\\Â4\\9Fj\éf\Ç1\Ãöo’\ÒÁ\Ã\îv>ˆc½\Åp\à>j©?\ïG\à¶g×“Sf­¯–‡À\Ü\Æ\ß&®\â\Ã5“\àĞ‹ùUõ2\Ê@ƒa¤˜ÿ\0„.O°i\ê¾3\æ\Ôp\Õ,£S\Ì\É\Ãòk˜˜\á\àU	¬OaÈŠFö­¦uNH;¥\î1pŒTuWJ!ˆ\æ20}Y+A\Ä,A\rK§bŒMM£§\ÇEm…²´˜}o\Õ;£T_\"iö\r4‚¹ñ\\k)TÁŸVFû.Y\ÊJú›L\Â\Zg\Ó\ç;µiâ•“F\Çs4\êMiÅ™\à\Ì9§\é\Z?›G4Ë7h\Î\Ş1ô°ûA\0-¿•¿›~­=\Ş\nH¼„^\Ê\áD{9eƒ 9j\ïŒ*³\Âx\ç\ß:nU«Zš*&U¾¥Ü¤\Ò¸¢6Ë˜¢&‚\ç;\Ø`Ü•R–\Ûr¸R\ÒHÆ¥˜r´{¥\Zµpı\Î\Õ!˜\ÓRU\Íö\Ë\ËHò\ÈWnº…8Gyg=J\Îr{ Õ®\ÜğóW[¬\îöYÑ©£†²CP\Îf;¯Q\ä¨¬7ò\Ë}D=\îky\Ûñ\n\í5Æ’¯Hj#yû \ëğ\\\Åjµ*KT™·\ZqŠ\ÂTS\Ö\Ùş©«¢\Úo·ñ\ï]©« «	\Zñ\Ü7c¢=¦|P\Ê\Ëd˜5\ĞTñ¡<®÷÷«\Ö\İJpğ\ÔÜ©Z\Æ3\Ş<ƒ/3º+T\Â<s¼r·>+1Ctª\ß\rw! ‘Ô­=U¦\çÙ˜Ÿ\Ø\\!\Î@Ñ¿ùe;©g¨ğyd\Ò2\ì\à³muN¬±gÕ·•8<š+u\ä\È\áA\İz6\Ë\r±\ãb\Ún\\\àA3½a±W\åTQL:\Û\İ3\æ¡t\Ğ\é<>³H\İi\èŸ \èT8Œ(¬šª6½ò9\Ù\ZŒõQO4‰q«¥\è\Çó7È®oy±\Æ\ÒùŸ£Zñ’Ó–\r¼#­-—;„t1gü\ã‡@…\İ\í\Òp\åù\ÑD\âL$==Bô+Eº\Z´K[V\ï§sy€X;ıd÷Š“^\í\0c1õU\Zõ2\Í\npT£¸w…kMmºW9¡¥³Tt\ÊĞ·\Åax.q}M>}Y\Z\Ñ\â· \èŸM\å.V&O:\'L6IHV$\É\Ğ)·K($–Jl\ìQÓ¦\Ênv\Ü>)EH’uÏ´g\Úü\ã¿\ïH&\Ç0ó\n9ªŒ\Äù	Ñ£)±\ä±f÷k¼\áÀ´\Ì\0÷\0ˆ]n°Y\èS;†ƒ\ÕoRP+mÊ–\É`}ucÀ3Hç†\İ\îXKõú{\åYšoRû÷yª®[ô×…nW	k\ëe«›Ûú£¹zoY¾k³µò§Ÿ\×që…\àş}Ú­µ\Õ\r\"’#\ê‚=²½Y€1½Z>6+Õ\ä«p¸Ák£tó»odw¬oo-\æ UÔ’X¨Ã²\çz«}\î\ë\È\×~O¹Z;üUöF\Ø\Ø\Ö4`4*wŸÑ·£…–K=A\ØQÛªr¹²2\ZA”\ì-\Ùp»=LT\ì.‘\á¡ª¿\Ê÷–Ò³Nò2J¢Øª\îó?:ô(\Å5¡‘°v‡\'¹ºü%È g\Ë_U\í\È@\î\'ù&e²¦]AqòZ˜\é!Ù«¨n\É5ûƒ0,S{Nğ.T8Š\Ö)\ì}³Ctv:-¾\Ïq— \á\×c#qŞŸJm\Í\Õ^yq\Z¤œ\î’\×0@\àìºŸŞÁkõXş\'æš\î\ØuğZö«2\ãó³V\×\ËDó¢\åQ;i\á2?^\áÔœCAq8RƒUT\Z™Aú\Ø(R\ÉzœN’±µq—–pZz+@\è¥ôj\ìbaƒ\àQ Q%€œ4<I ’`Á³¢mº§:\Å*\Ö\ĞEY	\0ünƒ[e’\ÙZh§\'²qõ	\èVŒ!×Š?I‡µ`ÄŒ\Ô\å/F7¾”6Ya\Ğg×Œø¢VúI¤có\ë‡y®Wˆ¹\é\Ù+G­\ßÁÙ`(\İ\Ì\ĞN\ãuz\ÅFú›¥=|€\ZVJ\ÊF\å\rxyÀ\İ_+€o½oŸom»‡ ‰š\É§:¢µM¤¶Àr1¹+°\Â\æÓG]W@³Ü!±•V¢\ÙGV\ì\Í\áõñ‚=\ãUsUV¾F¢–P=b0\ßP›\0%%5iª¨ô\Z\×63†¶q\Úùî®Š\ê\ÚPMmsø´ş¸øn®PSz5Q‘\ë\Ìÿ\0U¬hœ\æZz\êz¡˜%k\È\Ü¨ó7‰\â_\Üá´±ƒ\ïaUk¥«q{˜Y/ù±WxYN(·\×\Ã\èõ2NÚˆ#<¼å¼¯\0÷÷«¶k\"½\Ô5S`2˜9\Í!\Í8 \èTˆQ]œwG2\ÍM²³Ò©Áú\íĞ¢;¬}¶¤\Ò\Ö4“†;Bµ¬9p ©0@\n\Û=U×Š\ÊI\"\èA{3§’\çÂ´bƒŠk¨j¹g¨g³#†\ŞKGe^\"®•£-d,>9\Ê\Í:º:”JŠ§Ø„…>\åJ¥F=\r[JJK\'N9¹··Š€<˜\Ø9\ŞÑ»rÉ†\ÏR3!1FvhÜ…n²_O¼UW8ó¿\Ïr\ç+\Ã\"s@«M\æD\æÜ°€(x–œ1\Ùcò\Ó\à½\r›aye5O-\Ö	36\Í+y-eÊªGIBè¹†;I\Ü÷•n‹ğ•«E¼d4	Ğ;“\Õ+m4”´P\Î\×w’sñWBœª\Öä±”\Û%\êc§C€”9;epš®\ÒH‚Wy–\\ˆ½F÷õC÷<ó8’|J$T\Ã\Õ\Öˆ˜]\âU/rUÁ£¸9:\\($wueK÷™ÿ\0\Ì\È÷o#³\æ¹\å$Á.w¬ïŠ›g•§-•\àù®YN€\Â-\Çr«‹J]\àuWn7b\î’F\ç¶w«€3ª®X\"57	%v°D1\Ë\ŞS&¶\Â\r)nÌ‹ë¤¨\åôŠ‡¼°`\îZ^\á\Z›Ì±\ÔU4\ÃB5\ŞE\Ò\íi}º±\ÕpR6ª–onNl+tWjŠ8[ó[nwJ9`s\ãò\êWM­\Ëô«Å­\ÏH¥¥ŠšC\Z\È\Ø0ÖµT¿\ÔúŠªa¿/(÷ªş%qkv¡š\İ3†Gj=C\ïşj<i8şú¤r½\Ã^…2o»OvŒ…Ÿ3W¹\çf3O2^üÔ²c\Ú\Æ®a…—Q\îl\ÅlT­¨e53¤w+=IM-mI•ú’~½\æy\é\é\Ú7\Õ¥§m<-`\Zõ)«d;\Ó\Ó2\0Ñ¯R¬À\'	Š9\İ8QO²@\Ä\0I\Ø,_Njhdp\'•¯\0\0V–\çS\Ù\ÇÙ´ú\ÎYN ³»öÂ‚ñ&>TóJM˜cºI;t–¹Ì¾Mÿ\0eTşôtğ\ïZÑ²\ÈğöUO\ïG_å¢­©0°1\Û\ÖeÇ˜\Í{5˜$r¯©\í\Ø\Æt\ÑU\0\×DÀcBrz©lRÁµJ\ZQG34İº„^’a=;ÔŒ4/+µ¶N\Êw\Âvv­M’Ø\âYeK¢D\Ê\"‘ R)’Á\Â1ÁŠ[\Şi\0@\ßF¸\Ô\ÓıS\ëµ©giK+T\áQy\Åú?Q\Í\Ùû%8F\ázœo\í•\í”¬\Éó\è·Õö\Öúˆñ«˜Vw\è„©jHõ§•\Ä\0V©\Ïlls\Ş\à\Ö©*­Ä³<\"¤ù+Û¦\í\íô\Ò\ç$°\æÀ³–û“©#’?D©’›œ–M9††\è”W»t®\r,kşÌ©ø‹\ÈĞ‘(ea5:jA\ì³\éüö\Ê\Ç`\àZI\Z¡\Ö\Ğe©«ª;\É\'+söBD°(L\êœ\ì™-\Ó@Jµ}+è¦¦\×nj\Ğ\ïM\â\âò„k+—>i§u4\íÄ‘œy…ÃŠ-Ô³\ÓzS\åT3\Ù?o\Ãø«©\ØSAPÆŸ®\Ø\É\àº\Û¡	Á)¼3\î\ÎJYñº\ÓRW1–\ÆO!öF‰Y?Jç´ğ\Å,³»ÙŒ0‚~+g\Ãü7P\'º`\ê\ÈÑ¾j\İj\Ñ\Ó\áÜ«N„›Ü¿nş§°T\×Ô€\Ù$Ì§ø\åu3IV\çö„ö’Jd\'À­—_£V\Û`ytQúÒ¹£;tA-œ<n32¶«,§\ÆYú\Ã\Åga\ÎXF´%\Z\\›K_8†,=\Í\ßOŠ\åU7)»fW¨\Ïdy•\è¿5P–šHK@\Ğ»ÁI3y`…‘·¹­Y…¹1\İhó\ê\0²ğ\ÌT\Ôr\É?@ªÕ¢\r\Æ\êxIN¢‘^Sr\äl‰uO”’Œ\"\ç´’p\ë-r¬5U\Ô\Z\0Œ^*»\ZnFœ9ú,\É\ÛT¤\Ô\ã\ê$“\á\ÂKd“ 	tI:QF\ÂqºdıE\áÅ„5\Ø\'ª=\Ãtı…¼Œ\ä¹\Ù\'½F\íW™ş¡ôŒl\Û\ÒD\ãM´Pcš\ás\äºd&\à…6‹±VµÑ˜*\ØÙ¡pÁB\ï\\0ú\Ëgggª!€óŠi[Ÿ\Ñw\İuŠi!w3	\n9\ÒR-Qº”—³5Ô¬}%K\rSO­\Æ»½:\èO\å‚*ØƒeÔ”hZ|\ÖR6\İ#¬©¤Zö@ş^\Ş\"Gu“^\ŞQ{­ô*,>H8	/\ra¨ˆ]\İ-\Âw:9#xĞ±\ãP‰Ili&š$6\ç		\'\È\Ø\Ø^\ã€YCnÒ¸G²\ãªNEŒrğPšS<\îû!?\Õ.®1 \Âş\Éw\í…j’Ä‘z¼ThI/cw)$\ïh¤µ1òoxû*§Îõ\Æ2rš€ÿ\0²\êq¿j?«’1,Na\êewøŒØ²x‚`f§Qc‹\í8RM7 \ÓY\ß*yì•»±\Ã*gd©\à5“\ã^Éš¸÷”*4¢ò\Zkƒš6#*aD7\0\06R\n5‹)ú&\'¹0ñ@\İ\"4LŸ˜l€Ë“|n:1^ªweE3\ÏF<;šñ;F§”cÁZº¸‹l\Ø:–\á.ÉšKm¥±Q±\Ä4¹\ï\ÕG[\Ô\Ç\ÚQ¾\ÙUZM\ÉğQ@\â\Úhcojñ³´\Ù†&Cc¼¬hÀ\nE¥¶ù*½‰66µ­k@k@ÀBjJz––\Ïr\ç4ß¢EA—‘\0=%%\ÓS)]Œ\ÊB\Ãd\ÔWj:8„uP\Ô4Œ–\Ì\Â\Óñ\É\\¼ ¥¦\ãJ3¯Aª\"1\î\ÙI¯`ü\ë%?\é´SD>\Û;~!\\§¯¦ªo42Aú¥Y#MvTj¬ôUnIlƒi#%ğ›³÷0>}Ê…}Í´¤EL\Õ.Ñ±·\\x”>ªµ¶I)kQ\Z‰\Û\ë´x¯[(ã†µ\ç–Q\Ì\çŸ5€9\Ò\Û\é½.½\Âjƒ°>\Ë<‚µW;ii\İ!o3¶c{ÊµŒ6 vœEo…ú\ÇÙ½\äy))§9¤2{G$\íöö\Òó\\«^\Ó;›’\çlÀ³÷¾2\íšú[^y¨?ûU\î;¨{-”Ğµ\å¢ip\à:€°¯o¨Z\ÏT\ãÁm9*qQAgh«79p\\µñU©®·\â	\âŸ#šA\Ê\æ“\â7Zzhû\nh\â8$\r\Æ\Ë#Mweº\Õ-,–¨\é+ª¹õó9 ¿BØ˜\ÊlJ\0œ2®Ú´\ãÉ™Õ©5<%„h3¢Yñ/%Ş®C£ƒp\n»\ëª]¼\Ïø«¦7m›\á„\ÜÁc\rD\ÇyŸñHT\Î5?ıHÀvÙ³\ÈHA—\n¦‰\ß\ï9]\Ûy«h –»Ü“\Ûd¯öÕ¥£f!¥I\ït’9\çruQ=‘,V\é’H2r’l\ê²|¦N€XO²H%\Ì9ˆ\È\È	*¸\"\äGGFšØ©d)O]QLG$„·¸¢_ÀÀš2<F¨>ôû¥\Z\à™®†\ãO>9$\î*\Û]°\Ù#Q¿L-M¨\Í\èl2“\ÍâŠQÀK$7Cª\è\çsfu%tô¥\Í<ÍŒ€\æ¯ \×Û£\é\èä’\'\Ï\'\×,†ù‘²Š®1¹%\rzÖ9¢µ\ï=¹\'˜?9w»£aº!Ô’UÜ©¨\åœÓ²8‡©\Ù4—7M`\ÕÆ­Î†t,ˆŠt\Äd(‰„«\ÖS\nšrÏ¬5XI\nL\Ğ\È\Ë]£†…\âıPl#÷H;)D\í«´r\Ïñ¶‡öÂµE\æH¹Vz¨Kö0\îÜ¤“½¢’\Ô8÷É¾\à?ìšñÚ-–¸l²\\šªv\Ïj<öZğ]Ï˜\Ík_-\îrN\Ù@õ_¡óU±ÑŠ¨{jg°o¸A\\\îVF£Lx¦E\ìkP\Øb\rt¯3\Úw\àŒ\ÓÀ\Úx[zn{\×\n\n^Í£½·}\Êğ	’dUªjxd‰\Ñ9M\æšB tM„ù\Õ2\0uªIº ”€\Å[»€]/dü\ÏS\Ó û\×\nf\ëY\Üp»]\êªaE²\ÈGü*HÅ¹$ˆªIF-³[f£Š\ÙO>ÉŒ8»©%\0,+\îVZHšetÑ€\×9Ei)jc«§d\Ñ;™÷*—vó¥/F•h\Ôà´‘Q\ÎªµM}5‘3Y:Ÿr§†LUœ‰¸Š-‚ó\æQ6\í²l¬Š²ù[+9\ÆXÖ·…§\ÍŸ%€Ø¤’]\0\ç$}¤2FvsHTlòsÛ˜\Ã\íDLnE¡Tÿ\0’^\êiñ\êN;VyõN\\`¨i×ŠiGF\Ó<ı\á!°‚ş,\çH©\0ø•f\Ñf¢\"«ùXd\Ì\Öè»ƒœ²u¢\ãiCø†óù¸Ç™YÃ®‹J«ñ\Z1b–HS\ÔGCY\éU4L­c}ˆ\İ\'(\Ë\Z®K«\Ğ\Ôü\Ö)c™ ˆ\Ø\ï¿½\r9º]\ÛL\İaˆóHQN,£a–á¾©™\î\îV¨jQ\Ôduz´ûšW h\î\ÏÀ\çws´*À{N\Ä$°“\Ë­õ\Û\×ª¬c\İ+#‰\å¯yÀÁÂ³\n\ï†bhM\Z”\İU*{=\á\ÕL€ö\íY\ç¸ğZ\Âú\ë\nŒuÑ¿\ÉXRoĞX¨-\"u\Ü\'¸Y\Å-Of*ª1\\\à¸GGN\æ\îw{”\ä\Øl÷;$–0ÁJ \é{“\'	P’Gt@	>É“ôHN™:\0K=mu\ÍæŠ•õ8ıv´€G\ÅuUªù?ˆ\\g\Æ\ïø(ª<\"z1\Õ#4\ë}\Ö?\ÎY\ë[\åÏ±­\Î\rº¹¿ÿ\0\ß\É{#AK¦\åCİ‘k\å\ây-3N\×O={¹5#Ñœ\0ø«q@¨eIA;\İÓœ†¶\â\éŒ3U©Ë°Ñªó\Ë@\Õ\È\îj‚¥Ì¢¶\'£\Ó\á>BŞ•v›\ê\ÓSƒ\ÜK\ÏğTe‚²Š–n[¤á³œ=¬k[Ÿ»(À\nÅ¥İ„xö¨Jâ¤\ìÓ¥eJŸ\åEª\nv\Ó\Ñ\Ç3Œd\åY\Õ;Y\Ê\Ğ;‚–v÷-­¶ 7K\nCH)S”¹NT·NÓ¶x]‡´#ˆZbµIı¦\È«}€²¼oH\r Ô³L<x©¨?\Z	T\Ó	#\Ì\Î\å$\é-“œ|À?\ÙU;şx~`\Èp\0ş«©ı\èüÀ,»Ÿ1šÖ¾XÊ£\í\Ì}Wl]\ê\ï\Ë\â®uN -EµÁ$¥\Õ,w 2DS÷RK	\0†aO\Z&!\00M\Ó\áE\Ø\rs€\rR o\0X%\ìd–l\ã!\rhÜ­¶„À\Ó<£3É©=Á\n°Pºi¥­›ó|\ç³n>õ¦\0-‹J)-O“\êRpˆ\ÃC¶Gz¡K,UÇµw%Ú‡gFŸ$EP»Á\é6É£\êZ{Š½Ö–gĞ¬\é\Ë%\ÑUUr?’ŸG¦\ØL\á\ë?\ÈtV\ém´ôÇ¬.”\ï#\Ï3½d\ì÷7\Ë\0ˆ¼²h´\å\ïG\"ºJ\Ğ9½e\ÊW¤\é\É\Ä\è\éµ8©\"\ÕÚ™\ì¯§K	Ë†} ¯S\ÎÊ˜<g\ÕxÏ‘UaºBı$\Ğ*•4Í¶\\\r?8ôY4g>\ÉQc#\ÚaŞ‰gÁC=2šIY\Ş\àÖ\É8\ÂjYƒ¡(e\Øv^Z\Ğsıo\Õy8†\"óÕ¸u`\Ã\ÔtU*k.õ:&\Ò\Ò\ÄÇŒy\ÜºVugºD¸§Y¢cƒ€suk†ATm§´¿\İ\'\Zµ¡‘\âOYx·\Â±\ÓTBÁ¯!px\İ\á²\é­Îª-\åô‰K†w\î\Õ]¡g:U3\"\ÜBq\ÄL‡œñ]F3¤L3SP\ãôPi \Â5\ÅRøš½\Å\àD\Ü7M\Év\á\ë&­­©føl=|Jµ\n]Ê†‚ºVö\Ù	põ¡¶º\0\Ì\Òú\ÏqMÄ-¦F>h\Ù3=f;«Uõ2¶fQ\Ó§“\Úq\ÈR¦´RÁ—:6\Ë#½¹2O\Åii\ÛJ9zµI¹\Èóª\àÚš&\Ê\İ\ÇQ\Ñ…ü•0—n$oâµ·\Û_\Í\Õ/\0bš}ZFÀ÷,¤¬1»Q«ŞªcL°\Ç\Å\å®ÀAt\n½¢ZXe=€ı\ÊÊ¿\n\ä}f*#p·AG¯\Í\ÌQ<t8(ND°\à‚I%”	:`RJ?zI$Qğ’d\á(`t’	i\Ñ »‘…\Ç`2·¼H\êk^\í\ï/X±Ó¾*vûR¼4/^¡§m5,P3F±¡¡Wªı¶ñõ-Bsœ&\Ù9\Ù@ZFK\æ\ä´S\Ãşd¹>Ae¬\æ)\ä\ïvŸ”)³SC\ÙcPû|¶ğ\ï´\âU\Z\ìÓ¶^›\ÅQ«\Ë\ît\ì\èÑ”@h\ÖfK\Ã\Ï\Øn2\Ú	ó\ä§\æQhêœµ N©n²| Q\Õ:XK	\0Z¬ÿ\0\ZöbOŞµhq\â³üh?Ù‰x\Õ-ÎˆªşFy9\İ$\é-£ô.\0şÊ©ığ\ë\áÜ¶-Xÿ\0“ñıSR\ßÃ½lË¸ó«k\å\Õ>tQR\n\È\ÉÇ’[$Pˆ6ê–¨5H§#\n\'d\0\ãuNµ\Îs¢¤Ú˜\ë\àŸ \Z•\Î\Ñ¤UO\\ğqH³Ü§·§®i\ï+ö\é¶‚Á\"fh\Âê›§ŠKz+)&\äò\Ç\\ª4nÒºnkiass\ë¸`ô²5™›#e@\îIš}\Å¡»\ÇPDsb)ö\åw_$.I\ZÆ—9\ØIR¡µ\Ëxw3\Úb¤n\Î#\Öw’§}gNªÏ©z\Ò\ætöô4a\Ù\Z•ÎªUa\Ñ\ãV;;ğ\ä\r`m5MT½²sg\ÜWy,WjX›,U”õC\ìH\Â\Ç|F‹}>¤^Æ¼/!.J\ÜM=$}„ùuK+b?Yôz›‹»[Œ¤·vÀÃ†·Ï½dˆ˜^j]Qg+\æ\æ[ZY;Zv?¼-;K\nqZ\ä·3\ï/tD\ímŒhkFÀ<&\nKKJ3›™ğU-WXm4U°T;Ö‚Rbfupv\ØVz¡F\Î$†W\Æ\Ó\ÛDFHÎ¡GR$¥=,§Ce’®®K…\Èe\Ò<\ÈØ‡N\ì­ hZ4\É=\ë[œ\Ú9\Ü\ÏhFqğNŒV\ÂÔ«*vµ\\5ÖªG\î÷rF\ã\Ğ¢`i\\[O›£†¾õ®¶×¶ª“ôƒBºv\É{|†)\í2G+Ai\ë\Ü{\Ö\n\ç`­¦ª§§È—·«†øñ^“4L¨Œ\Å \Ëw>\ä\Òa5•79\Î\"„vqøy*ó§—’HKµk·¶\ÛC;Iq\Ö$õWğp.\ß¡¸\Èc‰\îlŸa\ã¢aÃ½H–\Åi§œ°%Ö¦sJöOG+@9g®>\í(\æd­\æcp·(E\Æ\ÃY2Áô=Ñ£¼\ÂM\Ñ$&¸fy6\Å\'‰i§ôj¦rJ6=\äœ÷\'\'’l\r”ıS$”Aü\ÒH$D€˜\'@’Kœ\Òv19ıÁ#{‚İa\î:\×\Ã\Ú\Ò\Ó\èó\ÜOU\ëò\Ç4L–3–¸d€²Pˆ-\rFúó\ç\ç\Åh8f°\Æ%¶\ÌO<\',\'«UiÅ­\Ëvõ“z\r>S‚‹NS\îB…—\'šqÌ½§9¹\Ò8ƒU\Û\\\";|\r?g(M\é<GXá±”0{–&òB\Æ\ì´ŸYš´– „qÜ…[ş’²ªO\Ö\Â)#¹cq\î³ŒÁ$˜öUBt	$R:&‚5O\Õ,a?/rt²ŸªH±gÁg¸\×Ñ‰xÕ Yş5ş\ì\ÉûÆ©(ştGWò3\É\Î\é$wIm˜G¡üŸÿ\0eUwö£ğ[±ÿ\0\'\àü\ÓS¿\ç‡\à¶ h²®<\Æj[?\Ã\ÙK”¥…e1·Mª–4M„\n$‰Q{\Ù²=­\'	÷\0‚vÁ@e:&8O…”\\•.2Rölü\ì\Îj1K\0§¦Œ7ô\"š›Ş£\èé›ŸøŠ:Õ­cO\Ô\Î{©\ÕnzG\è˜\ì1\Ùh%:\Ú\æ\ÒE’}c°Y:\Ú\Şw:iİŒ\íª!zd­¬.q%„h{–rªFO<q³\Ö,9q%”\Ô!¨š…Ri¬\Ñ•İ†¡Ÿ@\ĞKXV\Ú6†€\Z\0\0Y~Á¹;õc+RÑ¶Š”&\ç\â‘z\â”i=1;\Æ02Q\n\Ñcò\Êƒ \nõ\ÂA\r\'1ÙŒ\ÏÜœE:¬x–\ï_ Ø¿—\à\Ù$/¡\0ıS…˜\Å\í|§y\\´¶(\ËhËˆö•r+)Uy\\)4hÁ\âI\Í+\é\'cù^\Ê<‘\åQ´°\\¯\ÑS\ÏeŠ8\Ë\Ş×Œ…\ŞGÓ‹“\Â\0\åQ\Ô\ä¡5Ú®hx\Ã½p•¦&E5<¦\Ëğ\á„}\ÊğMD\r|\Z\È\Ï^bø„õZ8\İü¬Œm4…|\ÑÀ\äx…z¡ô³	N‡QŞ\Ëòv\éx»\Ë\Ú4z¹„`ù 5\Öú\ëT…•´òƒ¤\Ìo3\ï%§^/f2¥´–\æŒ\\Y-²i\Ø}f·nå‘¼V5–JzXÏ¯#Ëœ*\Ø\Ú\ÉC\0sNG2\rT\\ú*iI\æÁ!\Å6mj\ØHA¥¹Á\Îxs^\Ç½¾\É£–û\åT‘\ä\ÌK\Û\í”\è²Ûˆ\rØ·\ÖRN)$\Åi=™·¥¾d†\Î1úÁV\Ê\Ğ\æ8•‰+\Öú÷\Ò\Ê\Z\ã˜\ÏDÂ¼©ú \í\Ò\ÙÒ—³v’·X\ß\Ô“a‘|·–h;üVİ`p\ÔB\Ïq,º¥º:PX\ï\Ş§\'\Ãº\'H§’Œ’t\È2Hu\ÂxŸ4‘€p\ĞrWt‚@	\Ò]\å\ídŞ»v\Ïr1\Â+ı\rC«0,YC²?j\ÍE\Ò\Õı›÷(ªc\éGÆš=‡!H\Ğ\\v\0•Î‹\Â^\Â\ÙW.}˜œGÁU–\ÈÕ\ìò’}.õÍ¿iP]÷­‰¬­\Ö,ıP\\¶\ÙY•^\æ´vI+\\YE3»šUkK9h#\Ï\Ö\Õ=\âB\Ëkñ\í8†…f•4M\Æ\Í\n,lJ¸:aHø\Õ>DCaK	) r¦À]:¦-@\Â\Ïq¯÷b\\ñ\Z´x\Ñgx\Ûû¯.ßœj’\çC*şFy1\İ$\é-£ô_“\ŞQgª%\ío\Ó\rİ‹b]´Œ>N5òeKO5’©\ÓBÇ\Ü\0\\\Ğz-±¶P“ú,Yı€²n¦£6h[\ËÀ<¹€\êö¨\'\æa?œgú‚¶m”9Ç¢Cş˜Ú¨ô\çöB¨\ë¢\ÎYT–®\Ïõ>\ér\ßN-|\Ï8c\ê‹In·E\å}$<¬i\'\ÕY\Û-²„óW\ÍN\ÎÌ»3\Za:5¢\ÖX9>\no´I[%9¯—µšgg³k´cQ‹p¶JI„\á¼\Ç\\.Ô´”\âõ$°\ÂÆ¶&\è@\ê©\ÕOn6\'¶9]#p\í2O\Ö\åº[ûTÀW\è\Èü\ã?Ô—+3ù\ÆûKŸ\Ít ‘\è±|M¦\Ş]“KÁWù¨ä¹‡‚•¢w|\ï]N@\'<\äø#P\Ô\Ã3œ#•¯-\Ü²û@§´¢{iƒ\Ç,˜nK‡\\\â·T[\'“\æ\êh\ä]]\ÚK\ÊsŞµmú•4”Yua9\É\É9‚r\â\nx\å|¤½#f§ş\Ê_7VU\ãÓª¹şU>ƒ\Şw*\Ã8z\ÒF\rz\îz•%^©O8†\ä4ºl¹™©»\Ô\Ş9›!ÀŒn\çÌ®L†(›\ËkGšô¸n\Êƒo„ù\åt<3e8?7C÷¨%]\Ôİ³N”aEb(\Épünmt\Ïsp;0+J\×4’>*À\á»CrE“ˆş)Úş\r¿\êwóR\Æ\ê0X+V¢\ê\ÏPñ\Ì\Ó#A\Æı\ê<UT\Ú{$\ï–rŒ¥E\Ö^?D\ê?\ÍgxŠŠ\Û\rM%-lHü¼—œ\ïO…\Üe$ˆ¥l\ãÁö\Ê7\Ô£\0†€9Š\×CŠ6±£@¸\Ò\Ó\ÃMÀ\0oŞº6ªò6x\Ë\Ç\ÕZk	„›{ôN¢\nbğ0	(\È\İ,Œ\Ó24„´uB-7;…4\Ó\È\ÚF‡N\í(ú½5V®Ô¾•J]œˆ½b\Ã\ì»À£tV\Ûem5ƒ®Ñ¦6U\êOr\í­?P]E}mkC©\ØÀğ\ïP«öŠ€\É\Ş\Â\á\Ê\íµW]bµ \Â\áL8~\Ö¡„ğ\ê¬c\Õ‡3t\Ô|R%¤zÅ¤…S6[w6}™kE€\Ñ\ÇÄªÓG¨\å\İIo.%ôô\Ùv„ò7+\Ënö\ÖS\Ük(	…\Åñ‘\ÜVøÙ¨pG£·\âPN\"\á\è\'¦Q@<Zß¬x^%=\ÇT·N;nöº˜¤im\â¯\ĞRº<\Ìñ‡»@@ˆ0²V‡ç…9[*z’2$±±)c\Õ\ÂX\Ñ ”‚\ËRe¦1»v_‰ˆ\ìh\Æ}c)\ÇÁq±¸Š\Ù\Z6!W½Uz]\Ö8˜\àYN2|\Êl™iøŠ\ÙH&\Z÷¥²\\’\éc””\\\àÑ’@*¼•\ĞÇ\Í\ÌIÙ£)\ÒBL´¢\éX\Ç¹À²«\Ú\ÕM‘]“O\Ö~ÿ\0\Ú\ZV\Æy\ÜK\ä;¹\É56\ZN\é(>x£w+\Ğ|J\æ\ê¸\Ú@-“.>¯¨p\ï.ô9¤\n-ğXh\ÉÁÛª\Öğ} {\æ¸É€©O@²´0M[qe¢’œ¿s(\å\Èğ[¨l”Tñ¶&@\Ğ\Z1¹\ÕQ¹¹ŒvEû[vüLĞµ\í\Æ\ã\â…q-P‡ª\ÃH.{yF\n¨m|Ä˜\ê?\ÍAÖŠ\"0‚BJÏ÷\èiB†\æG‡XE{\ä:4G€|V£µi\ÈRšÁ§ks\ÜJµ\Ñ\r©\Ú>*”\îSeÄ—Ÿ¤Ñƒ¡\"Lsp5éª‰µ\Ñ;GS°ù§mª‰£HZ=\å7\æV“\æoxø§\ço\ÚóQ6º#¼\r?…®‹¬\rIó\çhú\Íø¥\Îß´>*\ÕBNE;6º#½;\nO˜ˆ¸$^\Ìgœ|Riú\Ã\â£óU?£1O\æ\Ú=?\'bO˜ˆ1hzŠ\Ïñ¸…\ä\Ôd\ÈİŠ\Ó\Ãl¡:\ZXÏ˜@¸ö\ßI	\É$P14ªÕ¼Ô¦Šõe\áhñ£ºI\È\Õ%¼c©ò\\qd«ıø\Û}–ğA^gò}{¡¶\Ù\êãªŸ‘\æ^`\ŞRs§Dr£ˆª.Bš—0Bñ£Ï¶’É¹·©V£qE\Ê3Œc¹ ¯¼Q[\ÚLÒ|h\Æ\êP«7Cv®u+ t\'¡qö–N¥Ü”³—dÁ\æqÜ«õ1\n[-\çC_	\äu(¯g\n0^[N³©&—¡­¾=\Â\ÃXY\ír‘\î\\-\\”ö(	8.bU{¥\æ†[İ\\%\ÓG†·œd¸\Zªim4\Öøj÷¼\×d\ÕQ\í\ÉG\r5$gf»\ÖJ$‰’vm‘\çHÇ¬\åbÁY\èÂºO¡1ö³\ë5¨§¶\Ûm1™q\Æ\Z5‘ûüP;\ÇŠˆŸME\ê\Ä\í)\ë\äµa9N=ºQÇ»3¥,\Ë&‚	„ôñ\Ê¶2º\äõœ°]#m·°Å¯ˆ\á \î\á\à¸_ª 8‚V³¬’4\îX•-¥\ÜqF½9§š<ƒ\ÕM…³×š¸_1™\În~°\0‚Œ\Æğ@\×*Ò”^\å2À\Ü.ñª\ãu\Ş?4{‘\Él\\fË¦t\\\ã\Ùt;«ğowÈº&)&:\'6!*õ4tõ‘öu\Ç+{Ü«%0L\ËL\\lş‹\Úó¤2rı\ÙÜ¿®\ÒpıªH„f‚\rˆ#ßº&’v~\ãtG\Øxt\ÃúÂªÑ®\"FŠ\ë\Äÿ\0ZºWU\ÉĞ‘\Ê¸\"\êMR+Šf\Æv!œ\à8b\Ø÷c—g¶v>Gé [M\åct\r“³\Z·FMòG8¥Á<±„ı\\ğ\ĞK\0Ü•¢1Š\ã.\n\åÎŠ¦SP\É İ¬x%NGu\n\Z(tVX¨;9\Ó\àS\ËQc2H\Æ÷8RKµ=ª\ÈüagJ;”—©½p±|¬¶\ÉN¯€û.òYs)c\rDn†a»1ğ\ï^„\ë\å°oYŞ‡\×\Ül•q–Ô3S=øV\í\îjSÙ¬¢µkxT\ß\Ô\Æ\Æ&ª”\ÃIjñ¹\'\reEÍ+ƒ(jtó;\ëe \"¾“Ã´ò—[kªi\í\Äq¹\í>\âH\ë­ñ&­ôš°\á‚M&¹]¶²‘lW¹\Ê\n7Zª\\\Ú\Ê\éõ\'‚.gİWK_QÕ‰\İ<U\\\Ü\ä¶b\ç1\Ï\ä.‘IjtM©†Š¼Óƒ‘‚y»:+Œ-­<¢*¬0\ØóøV½j³ü™,Ñ¶„ã»ƒ¨\ÜrÊª\ÆyIŸ\Ä)3ƒ(¾½Uc¼\ä\Ç\à?é­½¸\Ìƒ;sGÄ¢4·\Ç\Ö\ëKoP7\å{?š­ªçŒ²gN—°©øN\ÑµLe=ò¸»ñ].ü<\Ê\êH\â¤tt\Æ3\êOTü†\Ö\×\äS\Õÿ\0©Ÿ\Í9¹\Õ\Ä	–\ÓT\Ü~³?štUl\å\äk\íğŒ\á\á\Æ?G\ç\ë\'<w?ø\Ê6Ÿ\Øq_Bm¸°âŠ—O÷MşH4´T‚L\nh@ı€¶©\Û×–\Êf\ï¨EşC\Åb\àËœqI\ê\èedĞ’‘\är®7„«\ä£e4÷f˜Û³[\0\ÓÈ•\êRSS\åØ‚1¯\Ù\\ñ\Æİ˜Ñ¯rš=.¼ÿ\0Î†W£òJ>¦¦š)¤©©¨–!\ê™$\Ğ{‘—\0PC\Ş\Şh£>mC\r¾…\Ìa4t\ç\Î&ÿ\0%R\ã¤T2C\éu\ÊM\íy\ã—\'W¯Ahµ¾\ãn£\'¿°oòA/\ÒğÕš\Ë]¾Çµ=\Ø\ÉYÏ¥Í¼jFœº”!=<l\ãº\äN‹¿q¥­Ió-²\ZfY¤`=ø#\'Ü¼\ê\ÏÇ•–gW\ÔRs³X\á|•ş©Ó›¦J‚}6+8¨=“c!Ö \âÚƒxıM\îpS\çTf\Ù[A|²Gp§¤…0À`Ğƒ\ä.\ê\Ö\Æ\Æö`3gE¥K\ájµVUEü2üIJ›\Ï\îY\Õ,”*9İœ—¸÷j¹\Ü$™°å’½§]œB•ü!]/5jøš‹x\í¿\år¤4\İyØ¹VŠ\reA\Z\éÚ»ù­¥\Í\Ê\Ó\ÛÉ¨ûe2	Ö—ú‹øeŠzœ1˜3Fp¤\Õs\Û5+9‡3±©*­\É\ïcOf\ç7_ªp¾¯ÿ\0\"şYüMKş7ü ¤[ ?(?\Ü\é¿zÜ¬Ù¹W6gYQŒô•\ß\Í\\½\Ô\ÉQÀµ}³\ß#€i\î$ƒ\Î\İuÿ\0\îªH|7VŒ]G4ô\ï\ë\è:\í9J0\ĞüM/\äò“ºI\ÒA!®\à·\Ç\Ù\Ô\Ã0“ú\ÄlQSHbp\åš§’¯Àü=Qx´\Ô\ÉšÖ¶P5~\ŞK\\ş¹\Ìø\İ$¬q`Àwi®?Ò–›\í\ÔÏ£\ä$Ó\İÀvÔ’T0hö\âF±\ïE2*8\rùYø\"Qğu\Î\'»‘\í\åpÁ@Aÿ\0¥<<+x‚ŠZ6v/;s>\åJêŒª4£\Â,\ÛÖ„‹“Ï½@ –F´DğK;Ê»m¬6û‹¦\Èö³\'\0£<rk(\Ğs´\ápo\İ´<8uoóV©¨8\âhu–P&¦²®\å0=óH}˜˜4\äj\×\Ã/qlõú\r\Ä#ø¢4V;Å¾0 ·\Â\Õ\ÇŸ2¶øx‹³sEˆ\Ñ\Ãõ(ªÕšZ(¬!™÷ñrS\\©_Fò\É\Ş^XÀ\ÏÁVgUÑµñ\\!tŒ#³9]ÿ\0ui\Ü7~ô¨\ë\æËš>¢7\n;…e¡\ísô\Ï 8?Fvò\Ê\Û%úŒZfÅ’H\ãd	!Fm¼;]<o©s\İ#ip<\ÄküVš\×\Â\Ôöö2JÆ‡\È>§š%XòúIFhŒ\á£@4ZjŠp\à¦\ë½[­\å\ÒQB÷IhÏŠ!…¶=® ƒ”ƒ†¡D£\\µEŠ\Z\é\æ9.G²è¹³\Ù\ny\ÙY‡‘\ÉQ:„ŠŠVÁJu¤\ä’\ÎHB	I©†ªM	ñ\äFv`\ÙYfÊ»<\×v´É°±<lj&¯£¥\ï½¾°kùA>+j\â€q\r´\Ï\ËR\È\ÌÑ‰¢\Z;ÇŠ²øLœv‰¡sd†©°½š\Î!\æU´·Ö½’TUMR\Âÿ\0b#\Ê\Üx‚z5{)=\"\Ü[qƒ£\\\îI\à{\Ğw\\\\Ê˜\İsæ„´\é\0ŒŒwP\âHŸT\Z\ÇWcŠ¹(…EAh.`Å‡Ä•oé¥¦ŒHÊ‹pd\Í:2&µÀ=–>\át•\Õ\Óz+\Ëc“B0([‡¬@\Ï\\©ıœõ=²\Õ_Ev¡®\Ú\Z\í0Z2%¹:ŒÁE8x¬io98\å^ka½\ÖZ§|1Tº(œ3\Ë\Ê3\ävE\ç»Ü½2\Z\ê÷	böZª@ı”®k\ZoP&¦¦\á,t\Í{ƒ¶qfAWŞ²\×H\Æ\ÔP¹\ÅÚ——Œq\×JI`%\âC†¹\Û|S%’\åI\èñöcf“‚>*ş…µ\0orS\Õ\Ûc®¥\Ì%\Ç‹8ù+\Ü\'TÉ©\İ¤Ìú˜	V\Ò\Ó\Ëv\ë}!œ‡d?œi\ï*\Ë\İr±ö™Kq;\0“\ï=\ï¹JG{¥÷\Z\Ø]c¤ä«²\ÑvX©¢&\n˜Û†º!\íx\Õ¯§}l\Â\ãI+\ßÙŒšr\âU\ê;«\Å–¹‚p\Ø\ÆK¾	›¢O\ä\Ó\Øø‚*Šha®\Å]³˜öróˆ\rİ­\ÔS\Õı,okLm\'\ÙÓ¹\r¨¸\É[QcÍ…\Îh\æ#Ï¹B{¬¼\ÔT\ÇLj‹€³	À\ÇM”mÄ¯\ÛQOvùõ±Ş¦¢9h,Æ£.p\ÏÜºLüÊ°\Öj\ßL\â\ë\Îy[L¥l¬\Úo#œÀ­†§·cd\Ó8\×À­ûu\É\È\\\ì\ÉJt>hD\Ç5KŠ¸\Æ\İ\ÃĞ†I4Oªs°\ØKğz\í\n\Ã3‰®p++®T\î‰\çÕŠ¹s\Ó)õz•½«Q¨÷~\Ë%gB¬\ãª)ÿ\0\rÿ\0\Ò=B\Ş\ï]ˆ\Õ\ÂóGc²Iq¸L\"¦…¹sş@u+Ê¹R°\Êê‡°ò\äF\ØÃœ<\ÇE’\âZ«\ß\Õ\ÄÛµk¥­F\Ü;˜Œ·¿SªÎ­Ö­koÿ\0tCh¡)x¥…ÿ\0\Ü_ò\Úûœs\Ûxb†V¼‚\ßO¨\01ƒ«ƒu\ÏLeaªªç­¹ö“\É5\Îó9\Ü½\ÄôkvkPˆfª®‹†lŸE\ér¶!#ôÁqÁ$÷¯|\á	¢\áM\äl··šz—j\â\çc \í¡\nU/%™½1ö÷ı\ÍJ\Ú\İ=RÊŠ\áz¿\ß\ìx½Oq•ã³’Hã£¦”–˜\ä“ \î\áÁj-?\'Vhy>pa®§G¼ò€2H\Ò\ëœ2\ãà³¢¢J•ƒ=\î¢´³·£÷)»Šõ#Û °—ûWı—¤8iŒq1¬`\rhÀY‹¹&Ái%{N\\\×\ÜA\Ê\Ì]\ZA# òZ´Rä¦”\ß+€x.òS¬Ğz\Æ\"İŠ¼²\Ìò\æv­x\0\×\n;ûø\Ù\ÅJqm?oı6z7FŸU¨\éÓ«\Ép¤\Úoö\Ù\ä\Ë\Ì\ìT3\×E¤Œ\æ\Ê\ëEo·AC\É\íe\å:ô\èÀ\ç:&˜\Ë\\1\Òu7\å\ZRq\ç)r\è«\ÆW0ŒòÒ‹o”ñ\Î6Ï¦MEÇ°\Ø\ÙF\âr\×y¡6Úª¹%\ì)ƒY§¬\ã®»¥3¥y•³¹¿«Ó R\Ó\êÎ´\í©9%û/\à©_\á•e^4z\Ì)¹,\í™cŒg\Æw\Ãıœ\îü¡ß´®\\¤\Ï\Ö7õ[ÿ\0ûj…D\Îq8\í¼Ãª\ãqwû\'Z\Ï\×õÚŠ7±¹¶«$°Ò’iòz§H©Ó®¨BmI7¤¸k<x\í\ÒIÛ¤¹óM\ÅòB?\Ùú\ßÿ\0 ~\Ñ\Ú”|˜\İCd«Œ\Ò\ÔË™\ÌQó§U¼oB1\ÍGZ?\ä•ª\Å<6&‰=\Ğxøğ@\Ç\Òıh+œN8‡¬u#şC¿’Nõ?q;Sö\r\à&\r\Z\è_\éE¿:™ÇœşIJmxüóÇœNÁ\ê~\âö§\ì\Z a2ı(´‘ú^<\Ú\ï\äœq5¤ÿ\0\ãYğ?\É\Ø{ \íO\Ø-Œ¡÷Qôø\ÌÁ÷®m\âKI8ôø³\ã•Vº÷mš&ˆ\êY+šğ\à\ÆjN\ê\Ó[\ä)\ç#Y lÒ¹\î­;’€\ÖU\ÕW1\Ñ[\ãof\ïU\Ó?op\êºHÙ®3ºj’Y	9l#ø«¬hh\0\0pTnú¢KE\"õ/óH¥h´ü\İ¡sı\È\Äz.!v[œ²\Ë\î8X-³`º.qìº…n\ß#”\å1CD„Á#ºq¢A\Â÷©tQK]˜1\Æ\ë£T]\äc:³uİ».\rè»·e¡H¯1\Êmµ\Ù9P\'E;c\ÖZ\İ\Îj­ÒŠj¬\äŒz’x¹\Çr§|¢\éi\êÍeı’‹¹ÁT©§†¦2É£lŒ#pÊ‹½¤^Ş¢¤\Ü)c«ËŸnƒ˜ıfS÷!U\'vG4˜\Ìğø¶Lş(ƒ)\ëmøô»X¿Èœ\ç²î‹¨¿\ÒsöÌ’‘\çO¥©òv\Êju©ÌŠT\ç?P\Ò\Èd†\ç(Böµ\Ä}\Êqğg)]ûGŸ­$-qû©™#{Jy#7\ËNUr0uV\ãF#\îM¿£\ÕN\Ì7Xˆ#˜\Í“\ä\äHM\Ødœşd5£\ØhœùŸŠw\ËD;ó3\äÔ?®]‘·\Ñ\í\åª\íQÀU•q\ÇG\Ë+#öZøòŞ´=4\'\â›\'¼üRüº\Ü`\no“\éé‹Œ7·5\ÇB\á\Ï\âºGòv¼ò\Ş\'yÜ‚Áª8‡\Ö?\á\ï=\ß\ÙŞ‘^.\ì\Û\ÈÛ” w66\à¦8S ´\Ü\êyN„°g\î]Ä²ÿ\0˜ïŠ¨›¤…\'Ë¡{\Ò0µu’Á\Ä\ÒÛ™,†š6€Ó\\±¯sFOQ‚´U¼u\é\Çi\á7>ª¿b÷1Ş n\çQ®p°\ÜQ\Ä\â²ùVúZaiban[\Ìü¨E¸j‰ü7lš¹s+&-’7Gl°{¶ÿ\0Re\Å\çb-E\î\Ë¡¾¥U9\Ç\Ãgõo…ÿ\0Ş†¥ö¾²Qº[»›y¿;«e\ícó\ëgpN<1¢\Å+\İq³±Š6Z\Î`\âF3\0\ëñEyhc€òÕ¾YûŸª~\Öu\Ó=7ÂŒ¢\ÛØ¼\Ã5_j\â9\Zø\ÚÖ°}lœ\ë\áŒ,jš\å»kù\É\ŞB…”©;iÓ›ŒğŸ…¤\Ò\Û˜Šıÿ\0|‚\å•\Ôò\nššÚ‡s<v‡´ {‚±U]5DbH\Ò\Î@\ç;\0i\ÓeÊ¦•M\rq 5\Ø\à\åIøkC@«f;>Y\ÇÁ\İ6½\ÏztôÁE$–\Ë9{\í\ê–õ=’÷Cp‚2¢#•ÿ\0a\ä\íã€¾—\á»ù\âN¡º½d“D9\Ú\ÃB¾dºM\é5Í·€\ĞNu\Çğ_@|ğü>¢sZ\á5D}´™y#.¡\Û@AÓ›\ÂMwñ%•*Td\ÚM­ùı¿°V­À\ç\Éa¯¯§¹’½‡\Ù\è2ñ[J·z\ÇU„\â¿\ÑÏ—ñbùé³œ—+\îdü\'_«Ñ¥&ğ\Û\áµ\èı”vjyc%¬=ˆ\Øö‡SİŒù.2ˆ)\Zş\Î´c\\hN\ê\ßTv¶@3—5\Î_ñC\î¯h­Ü\à¥\éööò·]+uì¿„/_¿¿§RÊ¥Y5\Í-ñ\Ãyow³ööEK´òIK1xkI!Û·D.\ÉM%UD\î•\íkp0OA”vš(\í¶\Ù¸\çr¯oŠ\Zx\Ü\îÑ„<œ…—_Obt·ip·\Ûÿ\0N¢Ï½W¨P»–k\Å/\no\r\ãdğö\Ù~ù\ä\Îñ˜åª¤\ä3|£Äƒÿ\0\éBŠl\Ó7.\å‡\ÇA_A·\nx\äŒ\é—d|\ë\\tÏ€öÓŒ7`\×u{§\Ü\â†dšip“úık§¥t¡	¦¤öm¯^r\Ö\ßö4ö\È&€ºw3Wd«gB:!´õs¹`h\0Ài\'\0+s9æŸ™\àsõh?\ÅK\Ò+(Qt\Ü$±—ºo¡\Åv³¯w\n\êµ9&£–\ÏõNM\áz·°9¦Š8\Û1\î\ÅÜ lØ —Yó\Â1 \Óş&¢UóÑ³”±\Ï\0´¨E\Í\Ô\î±\Ö=¯q‘Ài\ÓÁQ¥R´*WSƒJY\Æ\ßöi\ßÑ´­ch\è\ÖRœ4©\'.1’\ã\ã˜SºI\ÒT\Êlõ_’\ï\ì:¿ßü–\í\Ë	ò]ı‡Yûq·’İ–ó}\Æ^¡ùH\ã\ÅD…5w¬\éI–’8½qw]\n\ìõÈ¨Ü™*Š9 Z3°ø)•uI­ûÒˆ\Ğ}‘ğK• û#\à¤S¤sc´¡±ª˜P\ê¤­\ÕvuÅ½hó\Ñ>‘Ë‚\Ü{.‹“4]U\ØpV—#g¢‰*[(•ˆ…¢d\ØKT\Ñ\âÎªCt\ØÏšp u]\Z¹€º5MO’9[\ÑvnË‹WV«ô\È&9Q*D¨•$†£™\\İ²\è\å\ÍÊ­BXœ²\ã$l‘¥¯hs\àŒ…\Ù\Û.d*’xd\É]g¦ˆ—R™)\\zÀ\âß»eÈ²\é\ÇmK:v\äw\Äi÷\"®ğ\Â\æ\àq\Ñ:75!\ÃÒŒ¹@§\ÔWE© /{9üp©ÿ\0I)[)ŠH\ç\íİ¦2qğGˆ*¥E¶’¬\æzx\Ş\áõˆ\×\â­\Ò\ê•ñ\Ê\Î-lQAm\ÎR]¥¿ˆ][y·?Ù­ƒıas“‡\àÿ\0¢¦?\'0ûò¸»‡FÂ«˜~¼,wğWU‡©³—¡}·\ZG{50Ÿ\'…\ĞU\Âv™‡\ÉÁr%¤?µH?Pş‰\ÈN¦ƒÿ\0\ë‘üT‹©S~£]¤š2t{O½8‘½V|p{Ë¹‡¡g÷nû“\r¨Ç«4\rğAÿ\0¹?\ç\é¾ü´Œ\\45A<\ÕCŸ\È\ÒF4\ç\È8õ¨©®šª8£(dC\rkFŸ\0°\Ó\É+¦™\Î|’cs‰õq‘ø”Yb]Tr¨ò\ÏQ\è6t\èZE\Æ8\ÎZ\Ï?\ßû¤¡¯®¨•´P¾§\è\ØÌ–g®B;CÀœW[W\"\×\r–3$RO?(p\ÎÀ½\Ë>	kƒš\ç5\Ãg4G¼#4ü[\Ä4½cxªˆ\">b€h´§CıD\Æ\ß\ÛõGµœ\â—\ëœır‚<;c•µtœ\Æm:<5\'¦„¬sß€\\zj®Ü®µ÷I\İ%ud\Õ..<\çL÷\àh‹…C)¨f‘\ØöH\0õ%\Ñ9¥M«º·¶”\ï&›Y{p’\\zmt\ÆùÇ”taÅ­©‘>\Îuû—\Õt,¶Y)¨Id¶0I\×@¾d\áI\Ùi®§\â(˜$’C)\Íö‡\\u\ÛcŞ¾²^Y\Ä=Ksdf1Q1Œ\îÓ±\Ğ\Ù8?\n\å=ñ5;˜\é¯Qxje§œóÿ\0¥:\Ò\Şs \Ê\Å_¦¤õ™TNw\é²\×]‚öƒ£¢ÀV[!}O=EDÒ¸€‰ø-+·ZT»T`¥Ÿ|a\rJÂÒ¹½®\é¨n”S\ËºXK\ß\Ü\'AE-+ŸG–ó\êZ\çq¢YUM35ı£}l4\äŠ·KO5;X\Èk\ès’×´½­~j\Ü÷t\r\ä\Ú4\ÒT\åu¶\ë±o©õ5+\ÉV£R53œK\×“Õ¶qú?\Ü\ÍñWT\n\è\Z,`X<\Ñ::¸\ê¨\Û+N\Ç\áÿ\0u‚\â	—G’\ì\ã#ş¢Š[\ë\\)\é`‹:\È\0ôÀIkYR«$¸\ÊS¸¥	\Í\î—\Ğ\ïw¤\ã¿ø®¶¹	ˆù\Âõ3{G1¸$k§MT-¸´·\Z\ß\â­\ëJ®\Än.V\æ–\Ô\îZœgL#S;\èNz¬\İœµ:djHşh†\Úsğ˜÷+\Æg\înÄ®øC+õDÀu?ˆ\Ü\ÇÒ—yh„\×\Ê>n•ºj?Š§u?ó\ì\Í[%—{£,wI#ºKŸ7_\'ªü—\ê:¼\íÛü–\ìï„’XW\Şc/\ÛşR\'L¨9\Ú$’Ì‘n\'\'\'tI%4Ng%GT’M$	†RI\ÕI»¤’Q\î]\ã\İ$“\á\Éø-Ç²šI+±\à­\ê1PI$ŒQ’I$¸:p’HHBAt	$¦‡$l\ê\Õ\Ğ$’»L‚D”\nI)$5+“’IV™,$¨»P’Jœ‰\Ñ\Ì\ì¢RIE!\è\Z(õ)$£…„ŠI$c„0B\Ù$“\â4\ê\Ü.\Í\ÂI)\é‘LÍ·ƒ\ÃZ\Z\Ú\Ğ\0\0Cÿ\0\É?ôCÿ\0=ÿ\0£ÿ\0\É$”š\"j^\ê	mS\é°‡\ç¿ô¿ù&<!«ÿ\0ôù$’4D_\ë\İCşO¤~\Ç84òÛ†aœÔƒ\ÔüœIS(uE\í\ïo0%¢Ÿ\Ã\Ö\Ñ$“UYS~¥\Å\í\Å\ÜtÖ–Wñÿ\0XI\Âm\Ì:×¶8)\ÛÉ‘¹:\î\\I÷­’\ìl–H­İ‰›³\Ï\Òsò\ç$°{û\ÒI$o«Ó›œe»ıØ­sBİ¼mk¬\Â/)q¿\î·úœ\ë.\æ ;\è9súùş\\f¥ÁÁÜ„ì¤’‘õ\Ëÿ\0ù>‹\ìP‡Ã½5qO\ë/¹\Ú	|§\Ö=û!u6§TJ^*9=\\S8=û¤’G\×/\ŞÎ§\Ñ}‰!ğÿ\0N‹Ê§õ—\Ü\ÌOòxf›´u\Ğ{Yı\îö“ÁÀO§q1İ°I\Ï\èûÔ’J¿õ;¾uıØ½òøÆŸ«:.k‹®s\Ür\\\èwÿ\0©v£\à£Fò\ïœ9ò1\Ãû’II±z·Sú/°\Ç\ÓmZÃ\Õı\Ë\Ñp\ßfşoK\Ïü¯û«\â\×\ê\ã¶ÿ\0§ş\é$¥]{¨.*}#ö+Ï¡\ØOySú¿¹J£†=%\Çò\Î_ùYş+7Ä¼$\ëe\î?8™Z`‡±\åß®y\à’IÔº­\İzŠ\'”ÿ\0Eöı:Ú„sN8ş\ï\îa\é$’\Ü3™ÿ\Ù');
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
