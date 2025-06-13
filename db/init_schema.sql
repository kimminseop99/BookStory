/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 10.4.32-MariaDB : Database - bookstory
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstory` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `bookstory`;

/*Table structure for table `answer` */

DROP TABLE IF EXISTS `answer`;

CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_answer_question` (`question_id`),
  CONSTRAINT `fk_answer_question` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `answer` */

insert  into `answer`(`id`,`content`,`create_date`,`question_id`) values
(1,'플랫폼 독립성은 JVM 덕분에 가능합니다.','2025-05-01 00:54:33',1),
(2,'객체지향 설계가 용이하여 유지보수가 좋습니다.','2025-05-01 00:54:33',1),
(3,'스프링 부트는 설정이 간편하고, 빠르게 개발할 수 있어요.','2025-05-01 00:54:33',2),
(4,'dasd','2025-05-02 23:56:27',1),
(5,'sadsa','2025-05-02 23:56:32',1),
(6,'ㄴㄴ','2025-05-03 00:04:07',1),
(7,'암','2025-05-03 00:39:40',1),
(8,'ㅁㅁ','2025-05-03 00:40:20',3);

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `isbn13` varchar(13) DEFAULT NULL,
  `price` varchar(20) DEFAULT NULL,
  `subtitle` varchar(300) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `isbn` varchar(255) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `hashtags` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `is_personal_recommendation` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKdjx0bsw5qtlpa3ertiyf8j0bc` (`isbn13`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `book` */

insert  into `book`(`id`,`title`,`image`,`isbn13`,`price`,`subtitle`,`url`,`isbn`,`author`,`content`,`hashtags`,`image_url`,`category`,`is_personal_recommendation`) values
(8,'비전공자도 이해할 수 있는 AI지식',NULL,NULL,NULL,NULL,NULL,'','홍길동','AI 입문자를 위한 설명입니다.','#AI #입문서','/images/main/AI지식.png','컴퓨터',''),
(9,'허상의 어릿광대',NULL,NULL,NULL,NULL,NULL,'','김작가','허상과 현실을 넘나드는 이야기.','#소설 #환상','/images/main/허상의 어릿광대.png','소설',''),
(10,'죽은 시인의 사회',NULL,NULL,NULL,NULL,NULL,'','N.H. 클라인바움','자유와 시에 대한 고전 명작.','#명작 #감동','/images/main/죽은시인의사회.png','소설',''),
(11,'해리 포터',NULL,NULL,NULL,NULL,NULL,'','J.K. 롤링','마법사의 모험 이야기','#판타지 #명작','/images/main/해리포터.png','소설',NULL),
(12,'1984',NULL,NULL,NULL,NULL,NULL,'','조지 오웰','전체주의에 맞서는 인간의 이야기','#디스토피아 #고전','/images/main/1984.png','소설',NULL),
(13,'아주 작은 습관의 힘',NULL,NULL,NULL,NULL,NULL,'','제임스 클리어','습관이 인생을 바꾸는 원리','#자기계발 #습관','/images/main/아주 작은 습관의 힘.png','자기계발',NULL),
(14,'기억력 천재가 되는 법',NULL,NULL,NULL,NULL,NULL,'','조슈아 포어','기억술 챔피언의 훈련 비법','#두뇌훈련','/images/main/기억력 천재가 되는 법.png','자기계발',NULL),
(15,'코스모스',NULL,NULL,NULL,NULL,NULL,'','칼 세이건','우주의 신비를 탐험하는 여정','#우주 #천문학','/images/main/코스모스.png','과학',NULL),
(16,'시간은 흐르지 않는다',NULL,NULL,NULL,NULL,NULL,'','카를로 로벨리','현대 물리학이 말하는 시간의 본질','#물리학 #시간','/images/main/시간은 흐르지 않는다.png','과학',NULL),
(17,'클린 코드',NULL,NULL,NULL,NULL,NULL,'','로버트 C. 마틴','가독성 좋은 코드의 원칙','#개발 #코딩','/images/main/클린 코드.png','컴퓨터',NULL),
(18,'모두의 딥러닝',NULL,NULL,NULL,NULL,NULL,'','조태호','딥러닝 입문서','#AI #딥러닝','/images/main/모두의 딥러닝.png','컴퓨터',NULL),
(19,'자바의 정석',NULL,NULL,NULL,NULL,NULL,'','남궁성','자바 언어 입문과 심화','#자바 #기초','/images/main/자바의 정석.png','컴퓨터',NULL),
(20,'돈의 심리학',NULL,NULL,NULL,NULL,NULL,'','모건 하우절','부와 투자에 대한 새로운 관점','#경제 #투자','/images/main/돈의 심리학.png','자기계발',NULL),
(21,'미드나잇 라이브러리',NULL,NULL,NULL,NULL,NULL,'','매트 헤이그','인생의 또 다른 가능성을 그리는 소설','#인생 #선택','/images/main/미드나잇 라이브러리.png','소설',NULL),
(22,'팩트풀니스',NULL,NULL,NULL,NULL,NULL,'','한스 로슬링','세상을 올바르게 보는 법','#데이터 #진실','/images/main/팩트풀니스.png','과학',NULL);

/*Table structure for table `book_review` */

DROP TABLE IF EXISTS `book_review`;

CREATE TABLE `book_review` (
  `is_secret` bit(1) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `modified_at` datetime(6) DEFAULT NULL,
  `writer_id` bigint(20) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `content` longtext DEFAULT NULL,
  `hashtags` varchar(255) DEFAULT NULL,
  `view_count` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg28ct9a5b3quyj3g08g310j83` (`writer_id`),
  CONSTRAINT `FKg28ct9a5b3quyj3g08g310j83` FOREIGN KEY (`writer_id`) REFERENCES `site_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `book_review` */

insert  into `book_review`(`is_secret`,`created_at`,`id`,`modified_at`,`writer_id`,`title`,`content`,`hashtags`,`view_count`) values
('','2025-05-29 01:46:15.323003',1,'2025-06-01 01:19:21.981978',1,'비전공자도 이해할 수 있는 AI 지식을 읽고...','인공지능의 역사부터 최근 동향까지 잘 풀어냈고 어려운 용어를 사용하지 않아 가볍게 읽기 좋다.','인공지능, AI, 딥러닝',14),
('\0','2025-06-01 01:15:17.722056',6,NULL,12,'미움받을 용기','이 책은 나 자신을 있는 그대로 받아들이는 법을 알려줍니다.\r\n특히 ‘타인의 과제를 분리하라’는 문장이 가장 인상 깊었습니다.\r\n다른 사람의 시선에 휘둘리지 않고 나의 삶을 살아가겠다는 다짐을 다시 하게 됐습니다.','자기계발,인간관계,철학',15),
('\0','2025-06-01 01:15:35.171420',7,NULL,12,'부의 인문학','단순한 경제서가 아닌, 부에 대한 철학적 고찰이 담긴 책입니다.\r\n돈이 목적이 아니라 수단임을 깨닫게 되었고,\r\n나의 소비 습관과 가치관을 되돌아보게 되었습니다.','경제,돈공부,철학',20),
('','2025-06-01 01:16:18.052813',8,NULL,13,'죽음에 관하여','죽음이라는 주제를 이렇게 평온하게 다룬 책은 처음이었습니다.\r\n삶을 더 소중히 여기기 위해 죽음을 성찰해야 한다는 메시지가 깊이 다가왔습니다.\r\n인생에 대한 시각이 바뀌는 계기가 되었습니다.','삶과죽음,인문학,명상',6),
('\0','2025-06-01 01:16:33.360894',9,NULL,13,'월든','자연 속에서 자급자족하며 살아가는 저자의 일상이 참 인상 깊었습니다.\r\n‘소유하지 않음’의 가치를 몸소 실천한 삶을 보며,\r\n현대 사회의 복잡함 속에서 진짜 필요한 것이 무엇인지 고민하게 되었습니다.','자연,미니멀리즘,철학에세이',45),
('\0','2025-06-01 01:17:00.177222',10,NULL,1,'무례한 사람에게 웃으며 대처하는 법','사람들과의 갈등에서 상처받았던 나에게 위로가 된 책입니다.\r\n나를 지키는 단호함과 예의 사이의 균형을 배우게 됐습니다.\r\n직장생활이나 인간관계로 힘든 분들에게 꼭 추천하고 싶어요.','심리,자존감,인간관계',11),
('\0','2025-06-01 01:34:21.586244',11,NULL,1,'데이터 사이언스 입문','처음 접하는 데이터 사이언스지만 쉬운 설명과 풍부한 예제로 쉽게 이해할 수 있었습니다. 실습 예제도 많아서 바로 따라 해 볼 수 있어 유익했어요.','기술,데이터',10);

/*Table structure for table `book_review_users` */

DROP TABLE IF EXISTS `book_review_users`;

CREATE TABLE `book_review_users` (
  `book_review_id` bigint(20) NOT NULL,
  `users_id` bigint(20) NOT NULL,
  PRIMARY KEY (`book_review_id`,`users_id`),
  KEY `FK7t17186kys6x6wsfyv4o3e3i6` (`users_id`),
  CONSTRAINT `FK7t17186kys6x6wsfyv4o3e3i6` FOREIGN KEY (`users_id`) REFERENCES `site_user` (`id`),
  CONSTRAINT `FKg7f049qx2w6thor2x6ayvyct0` FOREIGN KEY (`book_review_id`) REFERENCES `book_review` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `book_review_users` */

/*Table structure for table `book_review_voter` */

DROP TABLE IF EXISTS `book_review_voter`;

CREATE TABLE `book_review_voter` (
  `book_review_id` bigint(20) NOT NULL,
  `voter_id` bigint(20) NOT NULL,
  PRIMARY KEY (`book_review_id`,`voter_id`),
  KEY `FK7uafft2v9smyf5sew6jxuhl4d` (`voter_id`),
  CONSTRAINT `FK7uafft2v9smyf5sew6jxuhl4d` FOREIGN KEY (`voter_id`) REFERENCES `site_user` (`id`),
  CONSTRAINT `FKaa0ugdxw5216qswp6a7coxd7i` FOREIGN KEY (`book_review_id`) REFERENCES `book_review` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `book_review_voter` */

insert  into `book_review_voter`(`book_review_id`,`voter_id`) values
(6,13),
(7,1),
(7,13),
(9,1),
(9,12),
(10,12),
(10,13);

/*Table structure for table `chat_message` */

DROP TABLE IF EXISTS `chat_message`;

CREATE TABLE `chat_message` (
  `id` bigint(20) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `sender` varchar(255) DEFAULT NULL,
  `sent_at` datetime(6) DEFAULT NULL,
  `room_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfvbc4wvhk51y0qtnjrbminxfu` (`room_id`),
  CONSTRAINT `FKfvbc4wvhk51y0qtnjrbminxfu` FOREIGN KEY (`room_id`) REFERENCES `chat_room` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `chat_message` */

/*Table structure for table `chat_room` */

DROP TABLE IF EXISTS `chat_room`;

CREATE TABLE `chat_room` (
  `id` varchar(255) NOT NULL,
  `active` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpdfun2j80y8bx8sunba2dkomi` (`customer_id`),
  CONSTRAINT `FKpdfun2j80y8bx8sunba2dkomi` FOREIGN KEY (`customer_id`) REFERENCES `site_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `chat_room` */

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `book_review_id` bigint(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `modified_at` datetime(6) DEFAULT NULL,
  `writer_id` bigint(20) NOT NULL,
  `content` tinytext NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKap31wxb9g71o252be4sul0a9l` (`book_review_id`),
  KEY `FKt74t7x9o09e0l2hr1803h3ib0` (`writer_id`),
  CONSTRAINT `FKap31wxb9g71o252be4sul0a9l` FOREIGN KEY (`book_review_id`) REFERENCES `book_review` (`id`),
  CONSTRAINT `FKt74t7x9o09e0l2hr1803h3ib0` FOREIGN KEY (`writer_id`) REFERENCES `site_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `comment` */

insert  into `comment`(`book_review_id`,`created_at`,`id`,`modified_at`,`writer_id`,`content`) values
(9,'2025-06-02 16:28:55.756118',1,NULL,1,'공감합니다.');

/*Table structure for table `faq` */

DROP TABLE IF EXISTS `faq`;

CREATE TABLE `faq` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `answer` longtext DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `faq` */

insert  into `faq`(`id`,`answer`,`category`,`created_at`,`question`) values
(1,'상단의 회원가입 버튼을 클릭한 후, 이메일과 비밀번호를 입력해주세요.','회원','2025-05-31 22:09:11.000000','회원가입은 어떻게 하나요?'),
(2,'로그인 화면에서 \"비밀번호 찾기\"를 클릭하여 재설정하실 수 있습니다.','회원','2025-05-31 22:09:11.000000','비밀번호를 잊어버렸어요.'),
(3,'로그인 후, 원하는 책 상세 페이지에서 \"리뷰 작성\" 버튼을 눌러 입력하시면 됩니다.','리뷰','2025-05-31 22:09:11.000000','책 리뷰는 어떻게 작성하나요?'),
(4,'본인이 작성한 리뷰는 마이페이지에서 수정 및 삭제가 가능합니다.','리뷰','2025-05-31 22:09:11.000000','리뷰는 수정할 수 있나요?'),
(5,'페이지 하단의 고객센터 메뉴를 통해 상담원과 실시간 채팅이 가능합니다.','고객지원','2025-05-31 22:09:11.000000','고객센터는 어떻게 이용하나요?'),
(6,'회원 탈퇴 시 작성한 리뷰 및 댓글은 모두 삭제됩니다.','회원','2025-05-31 22:09:11.000000','탈퇴하면 데이터는 삭제되나요?');

/*Table structure for table `inquiry` */

DROP TABLE IF EXISTS `inquiry`;

CREATE TABLE `inquiry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `is_private` bit(1) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd0vsms37upnbv86pmdybqh60y` (`user_id`),
  CONSTRAINT `FKd0vsms37upnbv86pmdybqh60y` FOREIGN KEY (`user_id`) REFERENCES `site_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `inquiry` */

insert  into `inquiry`(`id`,`content`,`created_at`,`is_private`,`status`,`title`,`user_id`) values
(1,'독후감 어떻게 작성하나요???','2025-05-30 21:55:11.621898','\0',NULL,'독후감 어떻게 작성하나요?',NULL),
(2,'독후감 어떻게 쓰는 거에요???','2025-05-30 21:57:47.389884','\0',NULL,'독후감 어떻게 쓰는 거에요?',NULL),
(3,'비밀번호 변경 페이지에서 저장 버튼을 눌러도 아무 반응이 없어요.','2025-05-31 22:30:49.185269','\0',NULL,'비밀번호 변경이 안됩니다',NULL);

/*Table structure for table `inquiry_answer` */

DROP TABLE IF EXISTS `inquiry_answer`;

CREATE TABLE `inquiry_answer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `answered_at` datetime(6) DEFAULT NULL,
  `content` longtext DEFAULT NULL,
  `inquiry_id` bigint(20) DEFAULT NULL,
  `responder_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3irhermk3cm96u0y7oiv3ya4p` (`inquiry_id`),
  KEY `FKa2osvd18k2faljc2b3r7gyvqw` (`responder_id`),
  CONSTRAINT `FK3irhermk3cm96u0y7oiv3ya4p` FOREIGN KEY (`inquiry_id`) REFERENCES `inquiry` (`id`),
  CONSTRAINT `FKa2osvd18k2faljc2b3r7gyvqw` FOREIGN KEY (`responder_id`) REFERENCES `site_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `inquiry_answer` */

/*Table structure for table `question` */

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(200) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `question` */

insert  into `question`(`id`,`subject`,`content`,`create_date`) values
(1,'자바의 장점은 무엇인가요?','객체지향과 플랫폼 독립성이 강점이라 들었습니다.','2025-05-01 00:54:33'),
(2,'스프링 부트의 장점은?','설정이 간단하고 생산성이 높다고 하던데...','2025-05-01 00:54:33'),
(3,'안녕하세요','안녕','2025-05-03 00:40:12');

/*Table structure for table `review` */

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `reviewer` varchar(255) DEFAULT NULL,
  `book_isbn` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5brgc1wlabwtwih70y790vqlh` (`book_isbn`),
  CONSTRAINT `FK5brgc1wlabwtwih70y790vqlh` FOREIGN KEY (`book_isbn`) REFERENCES `book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `review` */

/*Table structure for table `site_user` */

DROP TABLE IF EXISTS `site_user`;

CREATE TABLE `site_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK8vlkw482t3gpnebxcm03ywk9p` (`email`),
  UNIQUE KEY `UKjerlw3g2urnh55wcrm2b5kqnj` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `site_user` */

insert  into `site_user`(`id`,`email`,`password`,`username`) values
(1,'bok06023@naver.com','$2a$10$BlcG0fUYYMVX1mJlkrL2v.Vdxwk80Gqr64AIiR5pGs5G1iLWlayI6','user1'),
(12,'minseop1217@gmail.com','$2a$10$qyVXzsF9ySRWPbcB71e4hO1Tn7UdR5LqJ7Jym4MrbewZAOUp6qHhK','user2'),
(13,'wl5144@naver.com','$2a$10$sDcedfx.Ctryv6GVLaK1J.7hK/SaQFqNvUlfl9KQTTShrpg26/mZW','user4');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
