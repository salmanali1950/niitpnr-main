--------------------------------------------------------
--
-- Table structure for table `pnrdetail`
--

CREATE TABLE `pnrdetail` (
  `pnr_id` bigint NOT NULL,
  `pnr` varchar(8) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `phone` varchar(14) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `execClub` varchar(60) DEFAULT NULL,
  `destination` varchar(60) DEFAULT NULL,
  `alternativeRequired` tinyint(1) DEFAULT NULL,
  `alternativeDestination` varchar(60) DEFAULT NULL,
  `dropDeadDate` date DEFAULT NULL,
  `linkedPNR` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `splitPNR` varchar(50) DEFAULT NULL,
  `bagTagNumber` varchar(50) DEFAULT NULL,
  `bagBack` tinyint(1) DEFAULT NULL,
  `vulnerable` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pnrdetail`
--
ALTER TABLE `pnrdetail`
  ADD PRIMARY KEY (`pnr_id`),
  ADD UNIQUE KEY `pnr` (`pnr`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pnrdetail`
--
ALTER TABLE `pnrdetail`
  MODIFY `pnr_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
