-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 18, 2021 lúc 04:43 AM
-- Phiên bản máy phục vụ: 10.4.16-MariaDB
-- Phiên bản PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlbh`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `code_bill` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `customer_code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `id_user` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `invoice_creation_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `note` varchar(300) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `bill`
--

INSERT INTO `bill` (`code_bill`, `customer_code`, `id_user`, `invoice_creation_date`, `note`) VALUES
('B000000001', 'CM00000001', 'US00000005', '2020-12-31 17:00:00', ''),
('B000000002', 'CM00000001', 'US00000003', '2021-01-01 17:00:00', ''),
('B000000003', 'CM00000001', 'US00000005', '2021-01-02 17:00:00', ''),
('B000000004', 'CM00000004', 'US00000007', '2021-01-03 17:00:00', ''),
('B000000005', 'CM00000004', 'US00000002', '2021-01-04 17:00:00', ''),
('B000000006', 'CM00000005', 'US00000004', '2021-01-06 17:00:00', ''),
('B000000007', 'CM00000005', 'US00000002', '2021-01-08 17:00:00', ''),
('B000000008', 'CM00000001', 'US00000005', '2021-01-10 06:53:08', ''),
('B000000009', 'CM00000001', 'US00000007', '2021-01-10 17:00:00', ''),
('B000000010', 'CM00000001', 'US00000003', '2021-01-11 17:00:00', ''),
('B000000011', 'CM00000001', 'US00000008', '2021-01-12 17:00:00', ''),
('B000000012', 'CM00000001', 'US00000004', '2020-12-30 17:00:00', ''),
('B000000013', 'CM00000005', 'US00000002', '2020-12-29 17:00:00', ''),
('B000000014', 'CM00000001', 'US00000003', '2020-12-27 17:00:00', ''),
('B000000015', 'CM00000001', 'US00000003', '2020-11-26 17:00:00', ''),
('B000000016', 'CM00000001', 'US00000007', '2019-12-30 17:00:00', ''),
('B000000017', 'CM00000001', 'US00000002', '2018-01-12 17:00:00', ''),
('B000000018', 'CM00000001', 'US00000008', '2017-01-12 17:00:00', ''),
('B000000019', 'CM00000005', 'US00000004', '2016-01-12 17:00:00', ''),
('B000000020', 'CM00000004', 'US00000002', '2016-01-13 14:31:54', ''),
('B000000021', 'CM00000001', 'US00000003', '2020-01-13 14:35:10', ''),
('B000000022', 'CM00000001', 'US00000007', '2019-01-14 14:35:19', ''),
('B000000023', 'CM00000001', 'US00000002', '2018-01-16 14:35:36', ''),
('B000000024', 'CM00000005', 'US00000008', '2017-01-30 14:35:45', ''),
('B000000025', 'CM00000004', 'US00000004', '2016-01-14 14:36:12', ''),
('B000000026', 'CM00000006', 'US00000005', '2016-01-15 14:36:22', ''),
('B000000027', 'CM00000004', 'US00000002', '2017-01-14 14:43:01', ''),
('B000000028', 'CM00000001', 'US00000007', '2018-01-14 14:40:28', ''),
('B000000029', 'CM00000005', 'US00000004', '2019-01-14 14:42:29', ''),
('B000000030', 'CM00000001', 'US00000004', '2021-01-04 04:53:47', ''),
('B000000031', 'CM00000006', 'US00000003', '2021-01-12 06:28:10', ''),
('B000000032', 'CM00000001', 'US00000002', '2021-01-08 06:48:02', ''),
('B000000033', 'CM00000004', 'US00000008', '2021-01-12 06:48:20', ''),
('B000000034', 'CM00000005', 'US00000009', '2021-01-08 06:48:35', ''),
('B000000035', 'CM00000005', 'US00000004', '2021-01-08 06:48:50', ''),
('B000000036', 'CM00000006', 'US00000004', '2021-01-12 06:49:15', ''),
('B000000037', 'CM00000006', 'US00000003', '2021-01-14 06:51:20', ''),
('B000000038', 'CM00000005', 'US00000007', '2021-01-14 07:57:35', ''),
('B000000039', 'CM00000001', 'US00000003', '2021-01-14 08:09:46', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `customer_code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `customer_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `trading_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` char(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`customer_code`, `customer_name`, `trading_name`, `address`, `email`, `phone_number`) VALUES
('CM00000001', 'Anh Tài', 'Mua bộ gear', 'Hà Nội', 'anhtai3d2y@gmail.com', '0982326874'),
('CM00000002', 'Anh Tài', 'Build bộ PC', 'Hà Nội', 'anhtai3d2y@gmail.com', '0982326874'),
('CM00000003', 'Anh Tài', 'Mua ghế Gaming', 'Hà Nội', 'anhtai3d2y@gmail.com', '0982326874'),
('CM00000004', 'Bạn Duy', 'Mua chuột', 'Hà Nội', 'anhtai3d2y@gmail.com', '0982326874'),
('CM00000005', 'Bạn Khoa', 'Mua bàn phím', 'Hà Nội', 'anhtai3d2y@gmail.com', '0982326874'),
('CM00000006', 'Bạn Đồng', 'Mua Laptop', 'Hà Nội', 'anhtai3d2y@gmail.com', '0982326874'),
('CM00000007', 'Anh Duy', 'adasd', 'Hà Nội', 'anhduy@gmail.com', '09222');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `goods`
--

CREATE TABLE `goods` (
  `item_code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `item_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `company_code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `type_code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `amount` int(11) NOT NULL,
  `unit` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `import_price` float NOT NULL,
  `price` float NOT NULL,
  `image_item` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `goods`
--

INSERT INTO `goods` (`item_code`, `item_name`, `company_code`, `type_code`, `amount`, `unit`, `import_price`, `price`, `image_item`) VALUES
('BP00000001', 'Bàn phím cơ Corsair K100 RGB', 'CC00000007', 'L000000002', 0, 'Chiếc', 3000000, 5290000, '/ImageProduct/corsair-k100-rgb.jpg'),
('BP00000002', 'Bàn phím Razer BlackWidow Tournament', 'CC00000004', 'L000000002', 1244, 'Chiếc', 2500000, 3999000, '/ImageProduct/ban-phim-razer-blackwidow-chroma-v2-orange-switches-a-500x500.jpg'),
('BP00000003', 'Bàn phím Razer BlackWidow Chroma V2', 'CC00000004', 'L000000002', 1241, 'Chiếc', 2500000, 3789000, '/ImageProduct/ban-phim-co-razer-blackwidow-chroma-v2-a-500x500.jpg'),
('BP00000004', 'Bàn phím Cơ Razer Pokemon Pikachu Limited', 'CC00000004', 'L000000002', 1244, 'Chiếc', 2000000, 2899000, '/ImageProduct/ban-phim-razer-pokemon-pikachu-limited-1-500x500.jpg'),
('BP00000005', 'Bàn phím cơ Razer BlackWidow Tournament', 'CC00000004', 'L000000002', 1245, 'Chiếc', 2000000, 2699000, '/ImageProduct/ban-phim-co-razer-blackwidow-tournament-edition-chroma-v2-quartz-edition-1-500x500.jpg'),
('BP00000006', 'Bàn phím cơ Gaming DAREU DK1280 104KEY', 'CC00000012', 'L000000002', 1247, 'Chiếc', 550000, 999000, '/ImageProduct/1-500x500 (1).jpg'),
('BP00000007', 'Bàn phím cơ Dareu EK810 - Queen Red Switch', 'CC00000012', 'L000000002', 1244, 'Chiếc', 450000, 599000, '/ImageProduct/ban-phim-co-dareu--ek810-queen-blue-switch-1-500x500.jpg'),
('BP00000008', 'Bàn Phím Cơ Cooler Master MK730 TKL Blue Switch', 'CC00000008', 'L000000002', 1247, 'Chiếc', 2000000, 2990000, '/ImageProduct/ban-phim-co-coolermaster-mk730-1-500x500.jpg'),
('BP00000009', 'Bàn Phím Cơ Cooler Master SK 621', 'CC00000008', 'L000000002', 1247, 'Chiếc', 2000000, 2890000, '/ImageProduct/ban-phim-co-cooler-master-sk-621-1-500x500.jpg'),
('BP00000010', 'Bàn phím cơ Corsair K70 RGB MK.2 SE', 'CC00000007', 'L000000002', 1246, 'Chiếc', 2000000, 44390000, '/ImageProduct/1-500x500 (2).jpg'),
('BP00000011', 'Bàn phím cơ Corsair K95 RGB Platinum', 'CC00000007', 'L000000002', 1246, 'Chiếc', 2000000, 44390000, '/ImageProduct/ban-phim-co-corsair-k95-rgb-platinum-gunmetal-speed-switch-tncstore-d-500x500.jpg'),
('BP00000012', 'Bàn Phím Corsair K95 RGB Platinum', 'CC00000007', 'L000000002', 1246, 'Chiếc', 2000000, 4299000, '/ImageProduct/ban-phim-co-corsair-k95-rgb-platinum-xt-1-500x500.jpg'),
('BP00000013', 'Bàn phím cơ Asus ROG Strix Flare - Pink Edition', 'CC00000005', 'L000000002', 1245, 'Chiếc', 2000000, 2990000, '/ImageProduct/ban-phim-co-asus-rog-strix-flare-pink-1-500x500.jpg'),
('BP00000014', 'Bàn Phím Logitech G512 RGB GX', 'CC00000006', 'L000000002', 1247, 'Chiếc', 1800000, 2390000, '/ImageProduct/ban-phim-co-logitech-g512-light-sync-rgb-gx-01-500x500.jpg'),
('CG00000001', 'Chuột Steelseries Rival 650 Wireless', 'CC00000003', 'L000000003', 0, 'Chiếc', 850000, 2789000, '/ImageProduct/chuot-steelseries-rival-650-1-500x500.jpg'),
('CG00000002', 'Chuột ASUS ROG Spatha', 'CC00000005', 'L000000003', 1244, 'Chiếc', 3000000, 3879000, '/ImageProduct/chuot-gaming-asus-rog-spatha---500x500.png'),
('CG00000003', 'Chuột Logitech G502 Hero Light Speed Wireless', 'CC00000006', 'L000000003', 1247, 'Chiếc', 2500000, 3289000, '/ImageProduct/chuot-gaming-logitech-g502-lightspeed-wireless-1-500x500.jpg'),
('CG00000004', 'Chuột Logitech G903 Lightspeed', 'CC00000006', 'L000000003', 1248, 'Chiếc', 2000000, 2990000, '/ImageProduct/chuot-logitech-g903-lighspeed-tncstore-1-500x500.jpg'),
('CG00000005', 'Chuột Logitech G703 Hero Lightspeed Wireless', 'CC00000006', 'L000000003', 1248, 'Chiếc', 1500000, 2279000, '/ImageProduct/chuot-logitech-g703-wireless-1-500x500.jpg'),
('CG00000006', 'Chuột Razer Viper', 'CC00000004', 'L000000003', 1244, 'Chiếc', 1000000, 2190000, '/ImageProduct/chuot-razer-viper-3-500x500.jpg'),
('CG00000007', 'Chuột Asus ROG Gladius II', 'CC00000005', 'L000000003', 1244, 'Chiếc', 700000, 1599000, '/ImageProduct/asus-rog-gladius-ii-o1-500x500.jpg'),
('CG00000008', 'Chuột Steelseries Sensei Ten', 'CC00000003', 'L000000003', 1247, 'Chiếc', 700000, 1549000, '/ImageProduct/chuot-steelseries-sensei-ten-1-500x500.jpg'),
('CG00000009', 'Chuột Logitech G502 Hero', 'CC00000006', 'L000000003', 1245, 'Chiếc', 650000, 1389000, '/ImageProduct/chuot-logitech-g502-hero-1-500x500.jpg'),
('CG00000010', 'Chuột Asus Cerberus Fortus', 'CC00000005', 'L000000003', 1246, 'Chiếc', 650000, 1389000, '/ImageProduct/chuot-asus-cerberus-fortus-1-500x500.jpg'),
('CG00000011', 'Dareu A960s Queen', 'CC00000012', 'L000000003', 1247, 'Chiếc', 320000, 599000, '/ImageProduct/1-500x500.jpg'),
('CG00000012', 'DAREU A960s - ULTRALIGHT', 'CC00000012', 'L000000003', 1245, 'Chiếc', 200000, 399000, '/ImageProduct/chuot-dareu-a960s-ultralight-1-500x500.png'),
('CG00000013', 'DAREU A960 YELLOW - ULTRALIGHT', 'CC00000012', 'L000000003', 1244, 'Chiếc', 650000, 899000, '/ImageProduct/chuot-gaming-dareu-a960-yellow-ultralight-1-500x500.jpg'),
('CG00000014', 'Cooler Master MM711 White Glossy RGB', 'CC00000008', 'L000000003', 1247, 'Chiếc', 720000, 999000, '/ImageProduct/chuot-coolermaster-mm711-white-rgb-1-500x500.jpg'),
('CG00000015', 'Cooler Master MM711 Black Matte RGB', 'CC00000008', 'L000000003', 1246, 'Chiếc', 720000, 999000, '/ImageProduct/chuot-cooler-master-mm711-black-matte-rgb-1-500x500.png'),
('CG00000016', 'Corsair Harpoon RGB Wireless', 'CC00000007', 'L000000003', 1246, 'Chiếc', 100000, 1289000, '/ImageProduct/chuot-corsair-harpoon-rgb-wireless-5-500x500.jpg'),
('CPU0000001', 'CPU Intel core i9-9940X 3.3GHz Turbo Up To 4.4 GHz', 'CC00000009', 'L000000009', 1246, 'Chiếc', 10000000, 19500000, '/ImageProduct/I9 9th-500x500.jpg'),
('CPU0000002', 'CPU Intel Core i9 10900K 3.7Ghz Turbo Up to 5.3Ghz', 'CC00000009', 'L000000009', 1246, 'Chiếc', 6500000, 13500000, '/ImageProduct/I9 10th-500x500.jpg'),
('CPU0000003', 'CPU Intel Xeon W-1270P 3.8 GHz, up to 5.1 GHz', 'CC00000009', 'L000000009', 1246, 'Chiếc', 6500000, 13500000, '/ImageProduct/cpu-intel-xeon-w-1250p-1-500x500.jpg'),
('CPU0000004', 'CPU Intel Core i9-10850K Avengers Edition', 'CC00000009', 'L000000009', 1244, 'Chiếc', 6500000, 12990000, '/ImageProduct/intel-core-i9-avenger-500x500.png'),
('CPU0000005', 'CPU AMD Ryzen 9 5950X 3.4 GHz', 'CC00000010', 'L000000009', 1245, 'Chiếc', 6500000, 20890000, '/ImageProduct/cpu-amd-ryzen-9-5900x-1-500x500.jpg'),
('CPU0000006', 'CPU AMD Ryzen™ 9 3950X 3.5 Ghz', 'CC00000010', 'L000000009', 1246, 'Chiếc', 6500000, 19200000, '/ImageProduct/Ryzen 9 3th-500x500.jpg'),
('CS00000001', 'Vỏ case Cooler Master MasterCase H500M', 'CC00000008', 'L000000013', 1246, 'Chiếc', 2500000, 4790000, '/ImageProduct/vo-case-mastercase-h500m-c-500x500.jpg'),
('CS00000002', 'Vỏ case Coolermaster Masterbox NR200P Mini ITX - ', 'CC00000008', 'L000000013', 1246, 'Chiếc', 2500000, 4790000, '/ImageProduct/vo-case-cooler-masterbox-nr200p-mini-itx-white-1-500x500.jpg'),
('CS00000003', 'Vỏ Case Gigabyte AORUS C300 GLASS', 'CC00000002', 'L000000013', 1249, 'Chiếc', 2500000, 4790000, '/ImageProduct/vo-case-gigabyte-aorus-c300-glass-1-500x500.jpg'),
('CS00000004', 'Vỏ case Asus ROG Strix Helios GX601 White Edition', 'CC00000005', 'L000000013', 1242, 'Chiếc', 2500000, 7990000, '/ImageProduct/vo-case-asus-rog-strix-helios-gx601-white-edition-ad-500x500.jpg'),
('CS00000005', 'Vỏ Case Asus ROG Strix Helios GX601', 'CC00000005', 'L000000013', 1242, 'Chiếc', 2500000, 6990000, '/ImageProduct/vo-case-rog-strix-helios-gx601-ad-500x500.jpg'),
('FAN0000001', 'Bộ 3 Quạt Tản Nhiệt Cooler Master SICKLEFLOW 120 A', 'CC00000008', 'L000000015', 1247, 'Chiếc', 500000, 850000, '/ImageProduct/fan-cooler-master-sickleflow-120-argb-3in1-1-500x500.jpg'),
('FAN0000002', 'Quạt Tản Nhiệt Corsair ML120 PRO RGB Pack 6 Fan', 'CC00000007', 'L000000015', 1247, 'Chiếc', 2000000, 4780000, '/ImageProduct/quat-tan-nhiet-corsair-ml120-pro-rgb-pack-3-fan-1-500x500.jpg'),
('FAN0000003', 'Quạt Tản Nhiệt LL140 RGB 140mm-2', 'CC00000007', 'L000000015', 1245, 'Chiếc', 1300000, 2490000, '/ImageProduct/quat-tan-nhiet-ll140-rgb-dual-light-loop-2fan-pack-with-lighting-node-pro-tncstore-b-500x500.jpg'),
('GHE0000001', 'Ghế Gaming ASUS ROG Chariot RGB', 'CC00000005', 'L000000005', 1244, 'Chiếc', 10000000, 15990000, '/ImageProduct/ghe-gaming-rog-chariot-rgb-1-500x500.jpg'),
('GHE0000002', 'Ghế Gaming MSI MAG CH120 I', 'CC00000001', 'L000000005', 1139, 'Chiếc', 2000000, 5990000, '/ImageProduct/ghe-gaming-msi-mag-ch120-i-1-500x500.jpg'),
('GHE0000003', 'Ghế Gaming MSI MAG CH120X', 'CC00000001', 'L000000005', 1197, 'Chiếc', 2000000, 5990000, '/ImageProduct/ghe-gaming-msi-mag-ch120-x-1-500x500.jpg'),
('GHE0000004', 'Ghế Gaming Cooler Master Caliber X1', 'CC00000008', 'L000000004', 1248, 'Chiếc', 2000000, 5990000, '/ImageProduct/ghe-gaming-cooler-master-caliber-x1-`1-500x500.jpg'),
('GHE0000005', 'Ghế Gaming CoolerMaster Caliber R2 Red', 'CC00000008', 'L000000004', 1246, 'Chiếc', 2000000, 4990000, '/ImageProduct/ghe-coolermaster-caliber-r2-4-red-500x500.png'),
('GHE0000006', 'Ghế Gaming Cooler Master Caliber R2 Purple', 'CC00000008', 'L000000004', 1248, 'Chiếc', 1500000, 3990000, '/ImageProduct/ghe-coolermaster-caliber-r2-1-purple-500x500.png'),
('HDD0000001', 'Ổ cứng HDD SEAGATE BARRACUDA 2TB 256MB', 'CC00000009', 'L000000012', 1245, 'Chiếc', 950000, 1790000, '/ImageProduct/o-cung-hdd-seagate-tncstore-2tb-500x500.jpg'),
('HP00000001', 'Tai nghe Razer Pokemon Pikachu True Wireless', 'CC00000004', 'L000000004', 1243, 'Chiếc', 1500000, 3990000, '/ImageProduct/tai-nghe-razer-pokemon-pikachu-true-wireless-1-500x500.jpg'),
('HP00000002', 'Tai nghe Razer Hammerhead True Wireless Earbuds', 'CC00000004', 'L000000004', 1240, 'Chiếc', 1500000, 2590000, '/ImageProduct/tai-nghe-razer-hammerhead-true-wireless-earbuds-1-500x500.jpg'),
('HP00000003', 'Razer Kraken 7.1 V2 - Digital Gaming Headset', 'CC00000004', 'L000000004', 1243, 'Chiếc', 1500000, 2460000, '/ImageProduct/razer-kraken-7-1-v2-digital-gaming-headset-2-500x500.jpg'),
('HP00000004', 'Tai Nghe Razer Kraken Mercury', 'CC00000004', 'L000000004', 1243, 'Chiếc', 1500000, 2290000, '/ImageProduct/tai-nghe-razer-kraken-mercury-2-500x500.png'),
('HP00000005', 'Razer Kraken Pro V2', 'CC00000004', 'L000000004', 1244, 'Chiếc', 1000000, 1990000, '/ImageProduct/razer-kraken-pro-v2-analog-gaming-headset-white-green-a-500x500.jpg'),
('HP00000006', 'Razer Hammerhead Pro V2', 'CC00000004', 'L000000004', 1245, 'Chiếc', 1000000, 1790000, '/ImageProduct/razer-hammerhead-pro-v2-3-500x500.jpg'),
('HP00000007', 'Tai nghe DareU EH925s Pro', 'CC00000012', 'L000000004', 1246, 'Chiếc', 500000, 999000, '/ImageProduct/tai-nghe-dareu-eh925s-pro-2-500x500.png'),
('HP00000008', 'Tai nghe DAREU EH469 PINK RGB', 'CC00000012', 'L000000004', 1245, 'Chiếc', 200000, 499000, '/ImageProduct/tai-nghe-eh469-pink-rgb-1-500x500.jpg'),
('HP00000009', 'Tai nghe Corsair Virtuoso RGB Wireless - Carbon', 'CC00000007', 'L000000004', 1247, 'Chiếc', 2000000, 3990000, '/ImageProduct/tai-nghe-corsair-virtuoso-rgb-wireless-carbon-1-500x500.jpg'),
('HP00000010', 'Tai Nghe Asus ROG Strix GO 2.4', 'CC00000005', 'L000000004', 1243, 'Chiếc', 2000000, 4499000, '/ImageProduct/tai-nghe-asus-rog-strix-go-24-1-500x500.jpg'),
('HP00000011', 'Tai nghe Logitech G733 LightSpeed Wireless', 'CC00000006', 'L000000004', 1247, 'Chiếc', 1500000, 2990000, '/ImageProduct/tai-nghe-logitech-g733-wireless-7.1-rgb-4-500x500.jpg'),
('HP00000012', 'Tai nghe Logitech G733 LightSpeed Wireless', 'CC00000006', 'L000000004', 1245, 'Chiếc', 1500000, 2990000, '/ImageProduct/tai-nghe-logitech-g733-wireless-7.1-rgb-1-500x500.jpg'),
('HP00000013', 'Tai nghe SteelSeries Arctis Pro + GameDAC', 'CC00000003', 'L000000004', 1250, 'Chiếc', 3000000, 5890000, '/ImageProduct/tai-nghe-steelseries-arctis-pro-gamedac-tncstore-1-500x500.jpg'),
('HP00000014', 'Tai nghe SteelSeries Arctis 7 Wireless Black', 'CC00000003', 'L000000004', 1250, 'Chiếc', 3000000, 3790000, '/ImageProduct/tai-nghe-steelseries-arctis-7-wireless-black-tncstore-a-500x500.jpg'),
('HP00000015', 'Tai nghe SteelSeries Arctis 7 Wireless white', 'CC00000003', 'L000000004', 1247, 'Chiếc', 3000000, 3790000, '/ImageProduct/tai-nghe-steelseries-arctis-7-wireless-white-tncstore-a-500x500.jpg'),
('HP00000016', 'Tai nghe SteelSeries Arctis 5 White', 'CC00000003', 'L000000004', 1249, 'Chiếc', 1500000, 2290000, '/ImageProduct/1-500x500 (3).jpg'),
('LT00000001', 'Laptop ASUS ROG Zephyrus Duo 15', 'CC00000005', 'L000000006', 1243, 'Chiếc', 50000000, 119000000, '/ImageProduct/laptop-asus-zephyrus-duo-15-500x500.png'),
('LT00000002', 'LAPTOP ASUS ROG ZEPHYRUS S', 'CC00000005', 'L000000007', 1243, 'Chiếc', 40000000, 84990000, '/ImageProduct/laptop-asus-zephyrus-s-500x500.png'),
('MH00000001', 'Màn Hình Gaming MSI Optix VA/ 2K/ 144Hz', 'CC00000001', 'L000000006', 1193, 'Chiếc', 7000000, 9589000, '/ImageProduct/man-hinh-msi-optix-mag271cqr-2k-1-1-500x500.jpg'),
('MH00000002', 'Màn Hình Gaming MSI Optix ', 'CC00000001', 'L000000006', 1248, 'Chiếc', 6000000, 8990000, '/ImageProduct/msi-ag32cq-500x500.jpg'),
('MH00000003', 'Màn hình Gaming MSI Optix IPS/ FullHD/ 144Hz', 'CC00000001', 'L000000006', 1249, 'Chiếc', 6000000, 8990000, '/ImageProduct/MSI-G271-500x500.png'),
('MH00000004', 'Màn hình Gaming Gigabyte AORUS IPS/2K/144Hz', 'CC00000002', 'L000000006', 1217, 'Chiếc', 10000000, 14990000, '/ImageProduct/man-hinh-gigabyte-aorus-ad27qd-1-1-500x500.jpg'),
('MH00000005', 'Màn hình Gaming Gigabyte VA/2K/144Hz', 'CC00000002', 'L000000006', 1246, 'Chiếc', 7500000, 11990000, '/ImageProduct/Gigabyte-G34WQC-500x500.png'),
('MH00000006', 'Màn Hình Gaming GIGABYTE IPS/ QHD/ 170Hz', 'CC00000002', 'L000000006', 1242, 'Chiếc', 7500000, 11990000, '/ImageProduct/man-hinh-gigabyte-m27q-01-500x500.png'),
('MH00000007', 'Màn hình Gaming Gigabyte Aorus VA/ FullHD/ 2', 'CC00000002', 'L000000006', 1245, 'Chiếc', 7500000, 11990000, '/ImageProduct/man-hinh-gigabyte-aorus-kd25f-1-500x500.jpg'),
('MH00000008', 'Màn Hình Asus ROG Swift IPS/ 4K/ 144Hz', 'CC00000005', 'L000000004', 1246, 'Chiếc', 50000000, 67890000, '/ImageProduct/asus-PG27UQ-500x500.png'),
('MH00000009', 'Màn Hình Gaming Asus ROG Swift IPS/ 2K/ 120', 'CC00000005', 'L000000004', 1243, 'Chiếc', 20000000, 32489000, '/ImageProduct/man-hinh-asus-rog-swift-pg349q-1-500x500.png'),
('MH00000010', 'Màn Hình Gaming Asus ROG Strix VA/Dual HD/1', 'CC00000005', 'L000000004', 1244, 'Chiếc', 15000000, 26990000, '/ImageProduct/man-hinh-asus-rog-strix-xg49vq-o1-500x500.jpg'),
('MH00000011', 'Màn Hình Gaming Asus ROG Strix VA/ Ultra Wi', 'CC00000005', 'L000000004', 1248, 'Chiếc', 15000000, 21899000, '/ImageProduct/man-hinh-game-cong-asus-rog-strix-xg35vq-1-500x500.jpg'),
('MH00000012', 'Màn hình Gaming Asus ROG Strix VA/2K/144Hz', 'CC00000005', 'L000000004', 1248, 'Chiếc', 15000000, 21899000, '/ImageProduct/asus-xg32vgr-500x500.jpg'),
('MN00000001', 'Bo mạch chủ Asus ROG Crosshair VIII Formula', 'CC00000005', 'L000000008', 1249, 'Chiếc', 15000000, 21000000, '/ImageProduct/bo-mach-chu-rog-crosshair-viii-fomula--500x500.jpg'),
('MN00000002', 'Bo mạch chủ Asus ROG Rampage VI Extreme Encore', 'CC00000005', 'L000000008', 1247, 'Chiếc', 15000000, 21000000, '/ImageProduct/Rampage VI Extreme Encore-500x500.jpg'),
('MN00000003', 'Bo Mạch Chủ MSI MEG X570 GODLIKE', 'CC00000001', 'L000000008', 1227, 'Chiếc', 15000000, 21900000, '/ImageProduct/MEG X570 GODLIKE-500x500.jpg'),
('MN00000004', 'Bo Mạch Chủ MSI Prestige X570 Creation', 'CC00000001', 'L000000008', 1248, 'Chiếc', 10000000, 14990000, '/ImageProduct/X570 Creation-500x500.jpg'),
('MN00000005', 'Bo mạch chủ MSI X399 CREATION', 'CC00000001', 'L000000008', 1249, 'Chiếc', 10000000, 14990000, '/ImageProduct/bo-mach-chu-msi-x399-creation--500x500.jpg'),
('MN00000006', 'Bo mạch chủ Gigabyte X399 Aorus Xtreme', 'CC00000002', 'L000000008', 1240, 'Chiếc', 5000000, 11990000, '/ImageProduct/bo-mach-chu-giga-aorus-x399-xtreme--500x500.jpg'),
('MN00000007', 'Bo mạch chủ GIGABYTE Z490 VISION G', 'CC00000002', 'L000000008', 1243, 'Chiếc', 3000000, 6040000, '/ImageProduct/bo-mach-chu-gigabyte-z490-vision-g-500x500.jpg'),
('PSU0000001', 'Nguồn Gigabyte G750H', 'CC00000002', 'L000000014', 1241, 'Chiếc', 2500000, 6990000, '/ImageProduct/nguon-gigabyte-g750h-tncstore-1-500x500.jpg'),
('PSU0000002', 'Corsair AX1200i 1200W Digital 80 Plus Platinum Mod', 'CC00000002', 'L000000014', 1248, 'Chiếc', 5000000, 7800000, '/ImageProduct/1-500x500 (4).jpg'),
('PSU0000003', 'Nguồn ASUS ROG Thor 1200W - 80 Plus Platinum', 'CC00000005', 'L000000014', 1246, 'Chiếc', 5000000, 9900000, '/ImageProduct/nguon-asus-rog-thor-1200w-80-plus-platinum-ad-500x500.jpg'),
('RAM0000001', 'Ram AORUS RGB 16GB (2x8GB) 3200MHz', 'CC00000002', 'L000000010', 1242, 'Chiếc', 2300000, 4590000, '/ImageProduct/ram-aorus-rgb-16gb-2x8gb-3200mhz-with-demo-kit-1-500x500.jpg'),
('RAM0000002', 'Ram AORUS RGB 16GB (2x8GB) 3200MHz', 'CC00000002', 'L000000010', 1247, 'Chiếc', 1500000, 3890000, '/ImageProduct/ram-aorus-16gb-2x8gb-rgb-1-500x500.jpg'),
('RAM0000003', 'Ram Gigabyte AORUS RGB 16GB DDR4 3600Mhz', 'CC00000002', 'L000000010', 1248, 'Chiếc', 1500000, 2750000, '/ImageProduct/ram-desktop-gigabyte-aorus-rgb-gp-ars16-1-500x500.jpg'),
('RAM0000004', 'RAM Corsair VENGEANCE RGB PRO 64GB', 'CC00000002', 'L000000010', 1246, 'Chiếc', 5000000, 9180000, '/ImageProduct/ram-corsair-vengeance-rgb-pro-32gb-2x16gb-ddr4-3200-black-1-500x500.jpg'),
('RAM0000005', 'Ram Corsair 32GB/3200 Dominator Platinum R', 'CC00000002', 'L000000010', 1246, 'Chiếc', 2500000, 5000000, '/ImageProduct/ram-corsair-16gb3200-2x8g-cmt16gx4m2c3200c16--dominator-rgb-1-500x500.jpg'),
('RAM0000006', 'RAM Corsair Vengeance RGB Pro 16GB ( 8 GB* 2 ) Bus', 'CC00000002', 'L000000010', 1246, 'Chiếc', 1260000, 2790000, '/ImageProduct/01-500x500.jpg'),
('SSD0000001', 'Ổ cứng SSD Gigabyte Aorus RGB M.2 NVMe 512GB', 'CC00000002', 'L000000011', 1246, 'Chiếc', 1260000, 2590000, '/ImageProduct/o-cung-ssd-gigabyte-aorus-rgb-m-2-nvme-512gb-1-500x500.jpg'),
('SSD0000002', 'Ổ cứng SSD Intel 760p 256GB M.2 80mm ', 'CC00000009', 'L000000011', 1245, 'Chiếc', 950000, 1790000, '/ImageProduct/m2ssd-intel-760p-series-256gb-m2-nvme-1-500x500.jpg'),
('VGA0000001', 'MSI GeForce RTX 3090 VENTUS 3X 24G OC', 'CC00000001', 'L000000001', 0, 'Chiếc', 25000000, 45990000, '/ImageProduct/mis-rtx3090ventus3x24goc.png'),
('VGA0000002', 'Gigabyte GeForce RTX 3090 Eagle OC 24G', 'CC00000002', 'L000000001', 9, 'Chiếc', 28000000, 48490000, '/ImageProduct/3090_EAGLE_OC_1_compressed-568x568.jpg'),
('VGA0000003', 'ASUS ROG Strix RTX 3090 O24G Gaming', 'CC00000005', 'L000000001', 1244, 'Chiếc', 30000000, 54990000, '/ImageProduct/card-man-hinh-asus-rog-strix-rtx-3090-o24g-gaming-1-500x500.jpg'),
('VGA0000004', 'ASUS ROG Strix RTX 3080 O10G White', 'CC00000005', 'L000000001', 1245, 'Chiếc', 15000000, 28690000, '/ImageProduct/card-man-hinh-asus-rtx-3080-oc-edition-1-500x500.jpg'),
('VGA0000005', 'ASUS ROG STRIX RTX 3070 O8G WHITE', 'CC00000005', 'L000000001', 1245, 'Chiếc', 10000000, 23590000, '/ImageProduct/card-man-hinh-asus-rog-strix-rtx-3070-o8g-white-1-500x500.jpg'),
('VGA0000006', 'Gigabyte AORUS GeForce RTX 3080 MAST', 'CC00000002', 'L000000001', 1248, 'Chiếc', 22000000, 27490000, '/ImageProduct/card-man-hinh-aorus-georce-rtx-3080-master-10g-1-500x500.jpg'),
('VGA0000007', 'Gigabyte Geforce RTX 3070 VISION OC ', 'CC00000002', 'L000000001', 1250, 'Chiếc', 12000000, 17990000, '/ImageProduct/vga-gigabyte-geforce-rtx-3070-vision-oc-8g-1-500x500.jpg'),
('VGA0000008', 'MSI Geforce RTX 3090 GAMING X TRIO 2', 'CC00000001', 'L000000001', 1248, 'Chiếc', 30000000, 47990000, '/ImageProduct/card-man-hinh-msi-rtx-3090-gaming-x-trio-1-500x500.jpg'),
('VGA0000009', 'MSI RTX 3080 SUPRIM X 10G', 'CC00000001', 'L000000001', 1226, 'Chiếc', 15000000, 27990000, '/ImageProduct/card-man-hinh-msi-rtx-3080-suprim-x-10g-1-500x500.jpg'),
('VGA0000010', 'test', 'CC00000001', 'L000000001', 10, 'Chiếc', 4444, 444, '/ImageProduct/asus-PG27UQ-500x500.png'),
('VGA0000011', 'card vip pro', 'CC00000002', 'L000000001', 30, 'Chiếc', 5000000, 10000000, '/ImageProduct/asus-rog-gladius-ii-o1-500x500.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoicedetails`
--

CREATE TABLE `invoicedetails` (
  `code_bill` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `item_code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `price` float NOT NULL,
  `amount` int(11) NOT NULL,
  `discount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `invoicedetails`
--

INSERT INTO `invoicedetails` (`code_bill`, `item_code`, `price`, `amount`, `discount`) VALUES
('B000000001', 'GHE0000002', 5990000, 1, 5),
('B000000001', 'MH00000001', 9589000, 1, 7),
('B000000001', 'MH00000002', 8990000, 1, 1),
('B000000001', 'MH00000006', 11990000, 1, 2),
('B000000001', 'MN00000003', 21900000, 1, 6),
('B000000001', 'VGA0000008', 47990000, 1, 4),
('B000000001', 'VGA0000009', 27990000, 1, 5),
('B000000002', 'GHE0000002', 5990000, 1, 0),
('B000000002', 'MH00000005', 11990000, 1, 0),
('B000000002', 'MN00000006', 11990000, 1, 0),
('B000000002', 'PSU0000002', 7800000, 1, 0),
('B000000002', 'RAM0000001', 4590000, 1, 0),
('B000000003', 'MH00000004', 14990000, 1, 0),
('B000000003', 'MH00000005', 11990000, 1, 0),
('B000000003', 'MH00000006', 11990000, 1, 0),
('B000000003', 'MH00000007', 11990000, 1, 0),
('B000000003', 'MN00000006', 11990000, 1, 0),
('B000000003', 'MN00000007', 6040000, 1, 0),
('B000000003', 'PSU0000001', 6990000, 1, 0),
('B000000003', 'PSU0000002', 7800000, 1, 0),
('B000000003', 'RAM0000001', 4590000, 1, 0),
('B000000004', 'BP00000006', 999000, 1, 0),
('B000000004', 'BP00000007', 599000, 1, 0),
('B000000004', 'CG00000011', 599000, 1, 0),
('B000000004', 'CG00000012', 399000, 1, 0),
('B000000004', 'CG00000013', 899000, 1, 0),
('B000000004', 'CPU0000004', 12990000, 1, 0),
('B000000004', 'CPU0000005', 20890000, 1, 0),
('B000000004', 'CPU0000006', 19200000, 1, 0),
('B000000004', 'HDD0000001', 1790000, 1, 0),
('B000000004', 'HP00000007', 999000, 1, 0),
('B000000004', 'HP00000008', 499000, 1, 0),
('B000000004', 'MN00000004', 14990000, 1, 0),
('B000000004', 'SSD0000002', 1790000, 1, 0),
('B000000005', 'BP00000009', 2890000, 1, 0),
('B000000005', 'CG00000014', 999000, 1, 0),
('B000000005', 'CG00000015', 999000, 1, 0),
('B000000005', 'CPU0000001', 19500000, 1, 0),
('B000000005', 'CPU0000002', 13500000, 1, 0),
('B000000005', 'CPU0000003', 13500000, 1, 0),
('B000000005', 'CS00000001', 4790000, 1, 0),
('B000000005', 'CS00000002', 4790000, 1, 0),
('B000000005', 'FAN0000001', 850000, 1, 0),
('B000000005', 'GHE0000005', 4990000, 1, 0),
('B000000006', 'BP00000008', 2990000, 1, 0),
('B000000006', 'BP00000010', 44390000, 1, 0),
('B000000006', 'BP00000011', 44390000, 1, 0),
('B000000006', 'BP00000012', 4299000, 1, 0),
('B000000006', 'CG00000009', 1389000, 1, 0),
('B000000006', 'CG00000016', 1289000, 1, 0),
('B000000006', 'FAN0000002', 4780000, 1, 0),
('B000000006', 'FAN0000003', 2490000, 1, 0),
('B000000006', 'HP00000009', 3990000, 1, 0),
('B000000006', 'HP00000011', 2990000, 1, 0),
('B000000006', 'HP00000012', 2990000, 1, 0),
('B000000007', 'BP00000014', 2390000, 1, 0),
('B000000007', 'CG00000003', 3289000, 1, 0),
('B000000007', 'CG00000004', 2990000, 1, 0),
('B000000007', 'CG00000005', 2279000, 1, 0),
('B000000007', 'MH00000011', 21899000, 1, 0),
('B000000007', 'MH00000012', 21899000, 1, 0),
('B000000007', 'MN00000001', 21000000, 1, 0),
('B000000007', 'MN00000002', 21000000, 1, 0),
('B000000007', 'PSU0000003', 9900000, 1, 0),
('B000000007', 'VGA0000003', 54990000, 1, 0),
('B000000007', 'VGA0000004', 28690000, 1, 0),
('B000000007', 'VGA0000005', 23590000, 1, 0),
('B000000008', 'CG00000002', 3879000, 1, 0),
('B000000008', 'CG00000007', 1599000, 1, 0),
('B000000008', 'CG00000010', 1389000, 1, 0),
('B000000008', 'CS00000004', 7990000, 3, 0),
('B000000008', 'CS00000005', 6990000, 1, 0),
('B000000008', 'GHE0000001', 15990000, 1, 0),
('B000000008', 'HP00000010', 4499000, 3, 0),
('B000000008', 'LT00000001', 119000000, 3, 0),
('B000000008', 'LT00000002', 84990000, 2, 0),
('B000000008', 'MH00000008', 67890000, 2, 0),
('B000000008', 'MH00000009', 32489000, 3, 0),
('B000000008', 'MH00000010', 26990000, 2, 0),
('B000000009', 'BP00000002', 3999000, 1, 0),
('B000000009', 'BP00000003', 3789000, 1, 0),
('B000000009', 'BP00000004', 2899000, 1, 0),
('B000000010', 'MH00000004', 14990000, 1, 0),
('B000000010', 'MH00000005', 11990000, 1, 0),
('B000000011', 'MN00000007', 6040000, 1, 0),
('B000000012', 'CG00000008', 1549000, 1, 0),
('B000000012', 'HP00000015', 3790000, 1, 0),
('B000000012', 'RAM0000005', 5000000, 1, 0),
('B000000012', 'RAM0000006', 2790000, 1, 0),
('B000000012', 'VGA0000006', 27490000, 1, 0),
('B000000013', 'BP00000013', 2990000, 1, 0),
('B000000013', 'CG00000006', 2190000, 1, 0),
('B000000013', 'HP00000001', 3990000, 1, 0),
('B000000014', 'BP00000003', 3789000, 1, 0),
('B000000014', 'BP00000005', 2699000, 1, 0),
('B000000014', 'CG00000006', 2190000, 1, 0),
('B000000014', 'HP00000005', 1990000, 1, 0),
('B000000015', 'MN00000006', 11990000, 1, 0),
('B000000015', 'PSU0000001', 6990000, 1, 0),
('B000000016', 'GHE0000002', 5990000, 7, 0),
('B000000016', 'MH00000001', 9589000, 5, 0),
('B000000017', 'MH00000007', 11990000, 3, 0),
('B000000017', 'MN00000006', 11990000, 5, 0),
('B000000017', 'MN00000007', 6040000, 3, 0),
('B000000017', 'PSU0000001', 6990000, 4, 0),
('B000000017', 'RAM0000004', 9180000, 3, 0),
('B000000018', 'CG00000008', 1549000, 2, 0),
('B000000018', 'HP00000015', 3790000, 2, 0),
('B000000018', 'RAM0000005', 5000000, 3, 0),
('B000000018', 'RAM0000006', 2790000, 3, 0),
('B000000018', 'SSD0000001', 2590000, 4, 0),
('B000000019', 'BP00000002', 3999000, 2, 0),
('B000000019', 'BP00000003', 3789000, 3, 0),
('B000000019', 'BP00000004', 2899000, 2, 0),
('B000000019', 'BP00000005', 2699000, 2, 0),
('B000000019', 'CG00000006', 2190000, 2, 0),
('B000000019', 'HP00000001', 3990000, 2, 0),
('B000000019', 'HP00000003', 2460000, 3, 0),
('B000000019', 'HP00000006', 1790000, 2, 0),
('B000000020', 'BP00000007', 599000, 3, 0),
('B000000020', 'CG00000012', 399000, 1, 0),
('B000000020', 'CG00000013', 899000, 3, 0),
('B000000020', 'CPU0000004', 12990000, 2, 0),
('B000000020', 'CPU0000005', 20890000, 1, 0),
('B000000020', 'GHE0000002', 5990000, 1, 0),
('B000000020', 'GHE0000003', 5990000, 1, 0),
('B000000020', 'HDD0000001', 1790000, 2, 0),
('B000000020', 'HP00000007', 999000, 1, 0),
('B000000020', 'HP00000008', 499000, 1, 0),
('B000000020', 'SSD0000002', 1790000, 1, 0),
('B000000021', 'GHE0000002', 5990000, 10, 0),
('B000000022', 'GHE0000003', 5990000, 5, 0),
('B000000023', 'MH00000001', 9589000, 5, 0),
('B000000024', 'MN00000003', 21900000, 12, 0),
('B000000025', 'MH00000004', 14990000, 10, 0),
('B000000026', 'VGA0000009', 27990000, 10, 0),
('B000000027', 'BP00000006', 999000, 2, 0),
('B000000027', 'BP00000007', 599000, 2, 0),
('B000000027', 'BP00000008', 2990000, 2, 0),
('B000000027', 'BP00000009', 2890000, 2, 0),
('B000000027', 'BP00000010', 44390000, 2, 0),
('B000000027', 'BP00000011', 44390000, 2, 0),
('B000000027', 'BP00000012', 4299000, 2, 0),
('B000000027', 'CG00000009', 1389000, 3, 0),
('B000000027', 'CG00000011', 599000, 2, 0),
('B000000027', 'CG00000012', 399000, 3, 0),
('B000000027', 'CG00000013', 899000, 2, 0),
('B000000027', 'CG00000014', 999000, 2, 0),
('B000000027', 'CG00000015', 999000, 3, 0),
('B000000027', 'CG00000016', 1289000, 2, 0),
('B000000027', 'CPU0000001', 19500000, 3, 0),
('B000000027', 'CPU0000002', 13500000, 3, 0),
('B000000027', 'CPU0000003', 13500000, 3, 0),
('B000000027', 'CPU0000004', 12990000, 3, 0),
('B000000027', 'CPU0000005', 20890000, 3, 0),
('B000000027', 'CPU0000006', 19200000, 3, 0),
('B000000027', 'CS00000001', 4790000, 3, 0),
('B000000027', 'CS00000002', 4790000, 3, 0),
('B000000027', 'CS00000003', 4790000, 1, 0),
('B000000027', 'FAN0000001', 850000, 2, 0),
('B000000027', 'FAN0000002', 4780000, 2, 0),
('B000000027', 'FAN0000003', 2490000, 2, 0),
('B000000027', 'GHE0000002', 5990000, 1, 0),
('B000000027', 'GHE0000003', 5990000, 1, 0),
('B000000027', 'GHE0000004', 5990000, 2, 0),
('B000000027', 'GHE0000005', 4990000, 3, 0),
('B000000027', 'GHE0000006', 3990000, 2, 0),
('B000000027', 'HDD0000001', 1790000, 2, 0),
('B000000027', 'HP00000007', 999000, 2, 0),
('B000000027', 'HP00000008', 499000, 3, 0),
('B000000027', 'HP00000009', 3990000, 1, 0),
('B000000027', 'HP00000011', 2990000, 1, 0),
('B000000027', 'HP00000012', 2990000, 3, 0),
('B000000027', 'MH00000001', 9589000, 1, 0),
('B000000027', 'MH00000002', 8990000, 1, 0),
('B000000027', 'MH00000003', 8990000, 1, 0),
('B000000027', 'MH00000004', 14990000, 1, 0),
('B000000027', 'MH00000005', 11990000, 1, 0),
('B000000027', 'MH00000006', 11990000, 1, 0),
('B000000027', 'MH00000007', 11990000, 1, 0),
('B000000027', 'MN00000003', 21900000, 1, 0),
('B000000027', 'MN00000004', 14990000, 1, 0),
('B000000027', 'MN00000005', 14990000, 1, 0),
('B000000027', 'MN00000006', 11990000, 1, 0),
('B000000027', 'MN00000007', 6040000, 1, 0),
('B000000027', 'PSU0000001', 6990000, 3, 0),
('B000000027', 'RAM0000001', 4590000, 3, 0),
('B000000027', 'RAM0000002', 3890000, 3, 0),
('B000000027', 'RAM0000003', 2750000, 2, 0),
('B000000027', 'RAM0000004', 9180000, 1, 0),
('B000000027', 'SSD0000002', 1790000, 3, 0),
('B000000027', 'VGA0000008', 47990000, 1, 0),
('B000000027', 'VGA0000009', 27990000, 1, 0),
('B000000028', 'BP00000002', 3999000, 1, 0),
('B000000028', 'BP00000003', 3789000, 2, 0),
('B000000028', 'BP00000004', 2899000, 1, 0),
('B000000028', 'BP00000013', 2990000, 2, 0),
('B000000028', 'CG00000002', 3879000, 3, 0),
('B000000028', 'CG00000007', 1599000, 4, 0),
('B000000028', 'CG00000010', 1389000, 2, 0),
('B000000028', 'CS00000004', 7990000, 3, 0),
('B000000028', 'CS00000005', 6990000, 5, 0),
('B000000028', 'GHE0000001', 15990000, 3, 0),
('B000000028', 'HP00000001', 3990000, 2, 0),
('B000000028', 'HP00000002', 2590000, 2, 0),
('B000000028', 'HP00000003', 2460000, 1, 0),
('B000000028', 'HP00000004', 2290000, 1, 0),
('B000000028', 'HP00000005', 1990000, 1, 0),
('B000000028', 'HP00000006', 1790000, 1, 0),
('B000000028', 'HP00000010', 4499000, 2, 0),
('B000000028', 'LT00000001', 119000000, 1, 0),
('B000000028', 'LT00000002', 84990000, 3, 0),
('B000000028', 'MH00000009', 32489000, 2, 0),
('B000000028', 'MH00000010', 26990000, 2, 0),
('B000000029', 'BP00000002', 3999000, 1, 0),
('B000000029', 'BP00000003', 3789000, 1, 0),
('B000000029', 'BP00000004', 2899000, 1, 0),
('B000000029', 'BP00000005', 2699000, 1, 0),
('B000000029', 'BP00000013', 2990000, 1, 0),
('B000000029', 'CG00000002', 3879000, 1, 0),
('B000000029', 'CG00000006', 2190000, 1, 0),
('B000000029', 'CS00000004', 7990000, 1, 0),
('B000000029', 'CS00000005', 6990000, 1, 0),
('B000000029', 'GHE0000001', 15990000, 1, 0),
('B000000029', 'HP00000001', 3990000, 1, 0),
('B000000029', 'HP00000002', 2590000, 1, 0),
('B000000029', 'HP00000003', 2460000, 1, 0),
('B000000029', 'HP00000004', 2290000, 1, 0),
('B000000029', 'HP00000005', 1990000, 1, 0),
('B000000029', 'HP00000006', 1790000, 1, 0),
('B000000029', 'HP00000010', 4499000, 1, 0),
('B000000029', 'LT00000001', 119000000, 1, 0),
('B000000029', 'LT00000002', 84990000, 1, 0),
('B000000029', 'MH00000008', 67890000, 1, 0),
('B000000029', 'MH00000009', 32489000, 1, 0),
('B000000029', 'MH00000010', 26990000, 1, 0),
('B000000030', 'MH00000006', 11990000, 5, 0),
('B000000030', 'MN00000006', 11990000, 1, 0),
('B000000030', 'MN00000007', 6040000, 1, 0),
('B000000030', 'RAM0000001', 4590000, 3, 0),
('B000000031', 'GHE0000003', 5990000, 1, 10),
('B000000031', 'MN00000003', 21900000, 1, 0),
('B000000032', 'BP00000002', 3999000, 1, 0),
('B000000032', 'BP00000003', 3789000, 1, 0),
('B000000032', 'BP00000004', 2899000, 1, 0),
('B000000032', 'BP00000005', 2699000, 1, 0),
('B000000032', 'CG00000006', 2190000, 1, 0),
('B000000032', 'HP00000001', 3990000, 1, 0),
('B000000032', 'HP00000002', 2590000, 3, 0),
('B000000032', 'HP00000003', 2460000, 2, 0),
('B000000032', 'HP00000005', 1990000, 2, 0),
('B000000032', 'HP00000006', 1790000, 1, 0),
('B000000032', 'HP00000016', 2290000, 1, 0),
('B000000033', 'BP00000013', 2990000, 1, 0),
('B000000033', 'CG00000002', 3879000, 1, 0),
('B000000033', 'CG00000007', 1599000, 1, 0),
('B000000033', 'CG00000010', 1389000, 1, 0),
('B000000033', 'CS00000004', 7990000, 1, 0),
('B000000033', 'CS00000005', 6990000, 1, 0),
('B000000033', 'LT00000001', 119000000, 1, 0),
('B000000034', 'GHE0000001', 15990000, 1, 0),
('B000000034', 'HP00000010', 4499000, 1, 0),
('B000000034', 'LT00000001', 119000000, 1, 0),
('B000000034', 'LT00000002', 84990000, 1, 0),
('B000000034', 'MH00000008', 67890000, 1, 0),
('B000000034', 'MH00000009', 32489000, 1, 0),
('B000000035', 'CG00000003', 3289000, 1, 0),
('B000000035', 'MH00000010', 26990000, 1, 0),
('B000000035', 'MH00000011', 21899000, 1, 0),
('B000000035', 'MH00000012', 21899000, 1, 0),
('B000000035', 'MN00000002', 21000000, 1, 0),
('B000000035', 'PSU0000003', 9900000, 1, 0),
('B000000036', 'BP00000010', 44390000, 1, 0),
('B000000036', 'BP00000011', 44390000, 1, 0),
('B000000036', 'BP00000012', 4299000, 1, 0),
('B000000036', 'CG00000005', 2279000, 1, 0),
('B000000036', 'CG00000009', 1389000, 1, 0),
('B000000036', 'CG00000016', 1289000, 1, 0),
('B000000036', 'FAN0000003', 2490000, 2, 0),
('B000000036', 'HP00000009', 3990000, 1, 0),
('B000000036', 'HP00000011', 2990000, 1, 0),
('B000000036', 'HP00000012', 2990000, 1, 0),
('B000000037', 'BP00000014', 2390000, 2, 0),
('B000000037', 'CG00000003', 3289000, 1, 0),
('B000000037', 'CG00000004', 2990000, 1, 0),
('B000000037', 'MN00000002', 21000000, 1, 0),
('B000000037', 'PSU0000003', 9900000, 2, 0),
('B000000037', 'VGA0000003', 54990000, 2, 0),
('B000000037', 'VGA0000004', 28690000, 2, 0),
('B000000037', 'VGA0000005', 23590000, 2, 0),
('B000000038', 'HP00000002', 2590000, 4, 0),
('B000000038', 'HP00000004', 2290000, 5, 0),
('B000000038', 'HP00000005', 1990000, 1, 0),
('B000000039', 'VGA0000003', 54990000, 3, 5),
('B000000039', 'VGA0000004', 28690000, 2, 0),
('B000000039', 'VGA0000005', 23590000, 2, 0),
('B000000039', 'VGA0000006', 27490000, 1, 0),
('B000000039', 'VGA0000009', 27990000, 2, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `next_code`
--

CREATE TABLE `next_code` (
  `code_bill` int(11) NOT NULL,
  `code_customer` int(11) NOT NULL,
  `code_type` int(11) NOT NULL,
  `code_company` int(11) NOT NULL,
  `code_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `next_code`
--

INSERT INTO `next_code` (`code_bill`, `code_customer`, `code_type`, `code_company`, `code_user`) VALUES
(40, 8, 16, 13, 13);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `next_code_good`
--

CREATE TABLE `next_code_good` (
  `VGA` int(11) NOT NULL,
  `BP` int(11) NOT NULL,
  `CG` int(11) NOT NULL,
  `HP` int(11) NOT NULL,
  `GHE` int(11) NOT NULL,
  `MH` int(11) NOT NULL,
  `LT` int(11) NOT NULL,
  `MN` int(11) NOT NULL,
  `CPU` int(11) NOT NULL,
  `RAM` int(11) NOT NULL,
  `SSD` int(11) NOT NULL,
  `HHD` int(11) NOT NULL,
  `CS` int(11) NOT NULL,
  `PSU` int(11) NOT NULL,
  `FAN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `next_code_good`
--

INSERT INTO `next_code_good` (`VGA`, `BP`, `CG`, `HP`, `GHE`, `MH`, `LT`, `MN`, `CPU`, `RAM`, `SSD`, `HHD`, `CS`, `PSU`, `FAN`) VALUES
(12, 15, 17, 17, 7, 13, 3, 8, 7, 7, 3, 2, 6, 4, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `supplier`
--

CREATE TABLE `supplier` (
  `company_code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `company_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `trading_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` char(11) COLLATE utf8_unicode_ci NOT NULL,
  `logo_supplier` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `supplier`
--

INSERT INTO `supplier` (`company_code`, `company_name`, `trading_name`, `address`, `email`, `phone_number`, `logo_supplier`) VALUES
('CC00000001', 'MSI', 'Cung cấp VGA thế hệ mới RTX 30 seris', 'Hà Nội', 'msicompany@gmail.com', '0982326874', '/LogoSupplier/msi-gaming-logo-spirit-vertical-black-rgb.png'),
('CC00000002', 'Gigabyte', 'Cung cấp VGA thế hệ mới RTX 30 seris', 'Hồ Chí Minh', 'gigabytecompany@gmail.com', '0982326634', '/LogoSupplier/aorus-logo.png'),
('CC00000003', 'Steelseries', 'Cung cấp Gaming Gear Steelseries', 'Hưng Yên', 'steelseriescompany@gmail.com', '0996326874', '/LogoSupplier/Steelseries-logo.png'),
('CC00000004', 'Razer', 'Cung cấp Gaming Gear Razer', 'Hà Nội', 'razercompany@gmail.com', '23414884888', '/LogoSupplier/Razer_snake_logo.png'),
('CC00000005', 'Asus', 'Cung cấp Gaming Gear Steelseries', 'Hà Nội', 'asuscompany@gmail.com', '0982326874', '/LogoSupplier/asus.png'),
('CC00000006', 'Logitech', 'Cung cấp Gaming Gear Logitech', 'Hà Nội', 'logitechcompany@gmail.com', '0982326874', '/LogoSupplier/logitech.png'),
('CC00000007', 'Corsair', 'Cung cấp Gaming Gear Corsair', 'Hà Nội', 'corsaircompany@gmail.com', '0932066688', '/LogoSupplier/corsair-logo.png'),
('CC00000008', 'Cooler Master', 'Cung cấp Gaming Gear Cooler Master', 'Hà Nội', 'coolermastercompany@gmail.com', '0982326874', '/LogoSupplier/coolmaster.png'),
('CC00000009', 'Intel', 'Cung cấp linh kiện máy tính Intel', 'Hồ Chí Minh', 'intelcompany@gmail.com', '0982326634', '/LogoSupplier/intel.png'),
('CC00000010', 'AMD', 'Cung cấp linh kiện máy tính AMD', 'Hưng Yên', 'amdcompany@gmail.com', '0982226634', '/LogoSupplier/amd.png'),
('CC00000012', 'DareU', 'Cung cấp Gaming Gear DareU', 'Hà Nội', 'dareucompany@gmail.com', '0932066688', '/LogoSupplier/dareu-logo.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `timekeeping`
--

CREATE TABLE `timekeeping` (
  `id_user` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `work_day` date NOT NULL,
  `time_working` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `timekeeping`
--

INSERT INTO `timekeeping` (`id_user`, `work_day`, `time_working`) VALUES
('US00000001', '2021-01-01', 28800),
('US00000001', '2021-01-02', 28800),
('US00000001', '2021-01-03', 62),
('US00000001', '2021-01-04', 28800),
('US00000001', '2021-01-05', 81),
('US00000001', '2021-01-06', 28800),
('US00000001', '2021-01-11', 28800),
('US00000001', '2021-01-12', 13682),
('US00000001', '2021-01-13', 6541),
('US00000001', '2021-01-14', 3471),
('US00000002', '2020-01-01', 28819),
('US00000002', '2020-11-11', 28819),
('US00000002', '2020-11-12', 28819),
('US00000002', '2020-11-13', 28819),
('US00000002', '2020-11-14', 28819),
('US00000002', '2020-11-15', 28819),
('US00000002', '2020-11-16', 28819),
('US00000002', '2020-11-17', 28819),
('US00000002', '2020-11-18', 28819),
('US00000002', '2020-11-19', 28819),
('US00000002', '2020-11-20', 28819),
('US00000002', '2020-11-21', 28819),
('US00000002', '2020-11-22', 28819),
('US00000002', '2020-11-23', 28819),
('US00000002', '2020-11-24', 28819),
('US00000002', '2020-11-25', 28819),
('US00000002', '2020-11-26', 28819),
('US00000002', '2020-11-27', 28819),
('US00000002', '2020-11-28', 28819),
('US00000002', '2020-11-29', 28819),
('US00000002', '2020-11-30', 28819),
('US00000002', '2020-12-01', 28819),
('US00000002', '2020-12-02', 28819),
('US00000002', '2020-12-04', 28819),
('US00000002', '2020-12-06', 28819),
('US00000002', '2021-01-03', 84),
('US00000002', '2021-01-05', 13),
('US00000002', '2021-01-06', 20),
('US00000002', '2021-01-11', 4208),
('US00000002', '2021-01-12', 514),
('US00000002', '2021-01-13', 29157),
('US00000002', '2021-01-14', 535),
('US00000003', '2021-01-07', 28800),
('US00000003', '2021-01-10', 28800),
('US00000003', '2021-01-11', 28800),
('US00000003', '2021-01-12', 28800),
('US00000003', '2021-01-13', 203),
('US00000003', '2021-01-14', 808),
('US00000004', '2021-01-06', 28800),
('US00000004', '2021-01-08', 28800),
('US00000004', '2021-01-09', 28800),
('US00000004', '2021-01-10', 28800),
('US00000004', '2021-01-11', 28800),
('US00000004', '2021-01-12', 28800),
('US00000004', '2021-01-14', 272),
('US00000005', '2021-01-06', 28800),
('US00000005', '2021-01-07', 28800),
('US00000005', '2021-01-13', 887),
('US00000005', '2021-01-14', 29007),
('US00000005', '2021-01-18', 115),
('US00000006', '2021-01-08', 28800),
('US00000006', '2021-01-09', 28800),
('US00000006', '2021-01-13', 6),
('US00000007', '2021-01-10', 28800),
('US00000007', '2021-01-11', 28800),
('US00000007', '2021-01-12', 28800),
('US00000008', '2021-01-10', 28800),
('US00000008', '2021-01-11', 28800),
('US00000008', '2021-01-12', 28800),
('US00000008', '2021-01-13', 28800),
('US00000009', '2021-01-08', 28800),
('US00000009', '2021-01-09', 28800);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `typeofgoods`
--

CREATE TABLE `typeofgoods` (
  `type_code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `type_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `typeofgoods`
--

INSERT INTO `typeofgoods` (`type_code`, `type_name`) VALUES
('L000000001', 'VGA - Card màn hình'),
('L000000002', 'Bàn phím'),
('L000000003', 'Chuột Gaming'),
('L000000004', 'Tai nghe'),
('L000000005', 'Ghế Gaming'),
('L000000006', 'Màn hình'),
('L000000007', 'Laptop'),
('L000000008', 'Mainboard - Bo mạch chủ'),
('L000000009', 'CPU - Bộ vi xử lý'),
('L000000010', 'Ram - Bộ nhớ trong'),
('L000000011', 'SSD - Ổ cứng thể rắn'),
('L000000012', 'HDD - Ổ cứng PC'),
('L000000013', 'Case - Vỏ máy tính'),
('L000000014', 'PSU - Nguồn máy tính'),
('L000000015', 'Tản nhiệt - Fan RGB');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id_user` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `full_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date NOT NULL,
  `start_date` date NOT NULL,
  `address` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` char(11) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `basic_salary` float NOT NULL,
  `allowance` float NOT NULL,
  `image_user` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(15) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id_user`, `user_name`, `password`, `role`, `full_name`, `gender`, `birthday`, `start_date`, `address`, `phone_number`, `email`, `basic_salary`, `allowance`, `image_user`, `status`) VALUES
('US00000001', 'admin', 'admin', 'Quản lý', 'Phạm Duy Tài', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai.jpg', 'Hoạt động'),
('US00000003', 'dong', 'dong1', 'Nhân viên', 'Đoàn Đình Đồng', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/dong.jpg', 'Hoạt động'),
('US00000007', 'dong2', 'dong2', 'Nhân viên', 'Đoàn Đình Đồng 2', 'Nam', '2021-01-06', '2021-01-14', 'Đồng Mai, Hà Đông, Hà Nội', '0982326634', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/dong2.jpg', 'Hoạt động'),
('US00000002', 'duy', 'duy', 'Nhân viên', 'Nguyễn Văn Duy', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/duy.jpg', 'Hoạt động'),
('US00000008', 'duy2', 'duy2', 'Nhân viên', 'Nguyễn Văn Duy 2', 'Nam', '2021-01-06', '2021-01-14', 'Đồng Mai, Hà Đông, Hà Nội', '0982326634', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/duy2.jpg', 'Hoạt động'),
('US00000009', 'duy3', 'duy3', 'Nhân viên', 'Nguyễn Văn Duy 3', 'Nam', '2021-01-06', '2021-01-14', 'Đồng Mai, Hà Đông, Hà Nội', '0982326634', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/duy3.jpg', 'Hoạt động'),
('US00000010', 'duy4', 'duy4', 'Nhân viên', 'Nguyễn Văn Duy 4', 'Nam', '2021-01-06', '2021-01-14', 'Đồng Mai, Hà Đông, Hà Nội', '0982326634', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/duy4.jpg', 'Khóa'),
('US00000004', 'khoa', 'khoa', 'Nhân viên', 'Nguyễn Minh Khoa', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/khoa.jpg', 'Hoạt động'),
('US00000011', 'khoa2', 'khoa2', 'Nhân viên', 'Nguyễn Minh Khoa 2', 'Nam', '2021-01-06', '2021-01-14', 'Đồng Mai, Hà Đông, Hà Nội', '0982326634', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/khoa.jpg', 'Khóa'),
('US00000005', 'tai', 'tai', 'Nhân viên', 'Phạm Duy Tài', 'Nam', '2000-11-27', '2020-12-02', 'Đồng Mai, Hà Đông, Hà Nội', '0932062686', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai.jpg', 'Hoạt động'),
('US00000006', 'tai2', 'tai2', 'Nhân viên', 'Phạm Duy Tài 2', 'Nam', '2021-01-06', '2021-01-14', 'Đồng Mai, Hà Đông, Hà Nội', '0982326634', 'anhtai3d2y@gmail.com', 30000000, 5000000, '/AvatarStaff/taideptrai2.jpg', 'Hoạt động');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`code_bill`),
  ADD KEY `FK_customercode` (`customer_code`),
  ADD KEY `FK_iduser` (`id_user`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_code`);

--
-- Chỉ mục cho bảng `goods`
--
ALTER TABLE `goods`
  ADD PRIMARY KEY (`item_code`),
  ADD KEY `FK_companycode` (`company_code`),
  ADD KEY `FK_typecode` (`type_code`);

--
-- Chỉ mục cho bảng `invoicedetails`
--
ALTER TABLE `invoicedetails`
  ADD PRIMARY KEY (`code_bill`,`item_code`),
  ADD KEY `FK_itemcodeinvoicedetails` (`item_code`);

--
-- Chỉ mục cho bảng `next_code`
--
ALTER TABLE `next_code`
  ADD PRIMARY KEY (`code_bill`);

--
-- Chỉ mục cho bảng `next_code_good`
--
ALTER TABLE `next_code_good`
  ADD PRIMARY KEY (`VGA`);

--
-- Chỉ mục cho bảng `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`company_code`);

--
-- Chỉ mục cho bảng `timekeeping`
--
ALTER TABLE `timekeeping`
  ADD PRIMARY KEY (`id_user`,`work_day`);

--
-- Chỉ mục cho bảng `typeofgoods`
--
ALTER TABLE `typeofgoods`
  ADD PRIMARY KEY (`type_code`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_name`),
  ADD UNIQUE KEY `UNIQUE_idstaff` (`id_user`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `FK_customercode` FOREIGN KEY (`customer_code`) REFERENCES `customer` (`customer_code`),
  ADD CONSTRAINT `FK_iduser` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);

--
-- Các ràng buộc cho bảng `goods`
--
ALTER TABLE `goods`
  ADD CONSTRAINT `FK_companycode` FOREIGN KEY (`company_code`) REFERENCES `supplier` (`company_code`),
  ADD CONSTRAINT `FK_typecode` FOREIGN KEY (`type_code`) REFERENCES `typeofgoods` (`type_code`);

--
-- Các ràng buộc cho bảng `invoicedetails`
--
ALTER TABLE `invoicedetails`
  ADD CONSTRAINT `FK_codebill` FOREIGN KEY (`code_bill`) REFERENCES `bill` (`code_bill`),
  ADD CONSTRAINT `FK_itemcodeinvoicedetails` FOREIGN KEY (`item_code`) REFERENCES `goods` (`item_code`);

--
-- Các ràng buộc cho bảng `timekeeping`
--
ALTER TABLE `timekeeping`
  ADD CONSTRAINT `FK_iduserworkday` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
