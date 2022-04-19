--------------------------------------------------------
--
-- Table structure for table `agentsDetail`
--

CREATE TABLE `agentsDetail` (
  `shiftId` bigint NOT NULL,
  `shiftDate` date DEFAULT NULL,
  `shiftNumber` tinyint(1) DEFAULT NULL,
  `agentCount` tinyint(1) DEFAULT NULL  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE `agentsDetail`
  ADD PRIMARY KEY (`shiftId`);
  
  ALTER TABLE `agentsDetail`
  MODIFY `shiftId` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
COMMIT;

