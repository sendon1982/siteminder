--# tushare DB
CREATE SCHEMA `tushare` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;


CREATE TABLE `dragon_tiger_stock`
(
	id					bigint primary key AUTO_INCREMENT,
    code   				varchar(20),
    name   				varchar(100),
    pchange    			decimal(30,4),
    amount       		decimal(30,2),
    buy      			decimal(30,2),
    sell                decimal(30,2),
    reason 				varchar(500),
    bratio 				decimal(15,2),
    sratio        		decimal(15,2),
    ts_date				date,
    broker				varchar(200),
    count 				bigint,
	probability       	decimal(15,2),
	broker_buy   		decimal(30,2),
	broker_buy_prop    	decimal(15,2),
	broker_sell 		decimal(30,2),
	broker_sell_prop    decimal(15,2),
	net					decimal(30,2)
);

ALTER TABLE `dragon_tiger_stock` ADD UNIQUE `unique_index`(`code`, `ts_date`, `broker`, `reason`);

CREATE TABLE `broker_buy_summary`
(
    id					bigint primary key AUTO_INCREMENT,
    broker_code   		varchar(20),
    broker_name      	varchar(100),
    s_money    			decimal(30,4),
    b_money       		decimal(30,2),
    jm_money      		decimal(30,2),
    b_count 		    bigint,
    s_Count         	bigint,
    ts_date				date
);

ALTER TABLE `broker_buy_summary` ADD UNIQUE `broker_buy_summary_uni_index`(`broker_code`, `ts_date`);

CREATE TABLE `broker_buy_stock_info`
(
    id					    bigint primary key AUTO_INCREMENT,
    broker_buy_summary_id   bigint,
    stock_code  		    varchar(20),
    stock_name				varchar(100)
);

CREATE TABLE `stock_trade_history_info`
(
    id					    bigint primary key AUTO_INCREMENT,
    stock_code              varchar(20),
    ts_date				    date,
    open_price              decimal(15,2),
    close_price             decimal(15,2),
    high_price              decimal(15,2),
    low_price               decimal(15,2),
    volume                  decimal(30,2)
);

ALTER TABLE `stock_trade_history_info` ADD UNIQUE `stock_trade_history_uni_index`(`stock_code`, `ts_date`);

CREATE TABLE `public_holiday`
(
        id					bigint primary key AUTO_INCREMENT,
        ts_date             date,
        is_public_holiday   boolean,
        name                varchar(100),
        description         varchar(500),
        create_ts           timestamp
);


CREATE TABLE `stock_info_no` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `stock_code` VARCHAR(45) NOT NULL,
  `ts_date` date NOT NULL,
  `open` DECIMAL(30,12) NULL,
  `high` DECIMAL(30,12) NULL,
  `low` DECIMAL(30,12) NULL,
  `close` DECIMAL(30,12) NULL,
  `volume` DECIMAL(30,12) NULL,
  `amount` DECIMAL(30,12) NULL,
  `ccl` VARCHAR(45) NULL,
  `preClose` DECIMAL(30,12) NULL,
  `netChangeRatio` DECIMAL(30,12) NULL,
  `ma5_volume` DECIMAL(30,12) NULL,
  `ma5_avgPrice` DECIMAL(30,12) NULL,
  `ma5_ccl` VARCHAR(45) NULL,
  `ma10_volume` DECIMAL(30,12) NULL,
  `ma10_avgPrice` DECIMAL(30,12) NULL,
  `ma10_ccl` VARCHAR(45) NULL,
  `ma20_volume` DECIMAL(30,12) NULL,
  `ma20_avgPrice` DECIMAL(30,12) NULL,
  `ma20_ccl` VARCHAR(45) NULL,
  `macd_diff` DECIMAL(30,12) NULL,
  `macd_dea` DECIMAL(30,12) NULL,
  `macd` DECIMAL(30,12) NULL,
  `kdj_k` DECIMAL(30,12) NULL,
  `kdj_d` DECIMAL(30,12) NULL,
  `kdj_j` DECIMAL(30,12) NULL,
  `rsi1` DECIMAL(30,12) NULL,
  `rsi2` DECIMAL(30,12) NULL,
  `rsi3` DECIMAL(30,12) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `stock_info_no_CODE_DATE_UNIQUE` (`stock_code` ASC, `ts_date` ASC) );

CREATE TABLE `stock_info_front` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `stock_code` VARCHAR(45) NOT NULL,
  `ts_date` date NOT NULL,
  `open` DECIMAL(30,12) NULL,
  `high` DECIMAL(30,12) NULL,
  `low` DECIMAL(30,12) NULL,
  `close` DECIMAL(30,12) NULL,
  `volume` DECIMAL(30,12) NULL,
  `amount` DECIMAL(30,12) NULL,
  `ccl` VARCHAR(45) NULL,
  `preClose` DECIMAL(30,12) NULL,
  `netChangeRatio` DECIMAL(30,12) NULL,
  `ma5_volume` DECIMAL(30,12) NULL,
  `ma5_avgPrice` DECIMAL(30,12) NULL,
  `ma5_ccl` VARCHAR(45) NULL,
  `ma10_volume` DECIMAL(30,12) NULL,
  `ma10_avgPrice` DECIMAL(30,12) NULL,
  `ma10_ccl` VARCHAR(45) NULL,
  `ma20_volume` DECIMAL(30,12) NULL,
  `ma20_avgPrice` DECIMAL(30,12) NULL,
  `ma20_ccl` VARCHAR(45) NULL,
  `macd_diff` DECIMAL(30,12) NULL,
  `macd_dea` DECIMAL(30,12) NULL,
  `macd` DECIMAL(30,12) NULL,
  `kdj_k` DECIMAL(30,12) NULL,
  `kdj_d` DECIMAL(30,12) NULL,
  `kdj_j` DECIMAL(30,12) NULL,
  `rsi1` DECIMAL(30,12) NULL,
  `rsi2` DECIMAL(30,12) NULL,
  `rsi3` DECIMAL(30,12) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `stock_info_front_CODE_DATE_UNIQUE` (`stock_code` ASC, `ts_date` ASC) );

CREATE TABLE `stock_info_back` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `stock_code` VARCHAR(45) NOT NULL,
  `ts_date` date NOT NULL,
  `open` DECIMAL(30,12) NULL,
  `high` DECIMAL(30,12) NULL,
  `low` DECIMAL(30,12) NULL,
  `close` DECIMAL(30,12) NULL,
  `volume` DECIMAL(30,12) NULL,
  `amount` DECIMAL(30,12) NULL,
  `ccl` VARCHAR(45) NULL,
  `preClose` DECIMAL(30,12) NULL,
  `netChangeRatio` DECIMAL(30,12) NULL,
  `ma5_volume` DECIMAL(30,12) NULL,
  `ma5_avgPrice` DECIMAL(30,12) NULL,
  `ma5_ccl` VARCHAR(45) NULL,
  `ma10_volume` DECIMAL(30,12) NULL,
  `ma10_avgPrice` DECIMAL(30,12) NULL,
  `ma10_ccl` VARCHAR(45) NULL,
  `ma20_volume` DECIMAL(30,12) NULL,
  `ma20_avgPrice` DECIMAL(30,12) NULL,
  `ma20_ccl` VARCHAR(45) NULL,
  `macd_diff` DECIMAL(30,12) NULL,
  `macd_dea` DECIMAL(30,12) NULL,
  `macd` DECIMAL(30,12) NULL,
  `kdj_k` DECIMAL(30,12) NULL,
  `kdj_d` DECIMAL(30,12) NULL,
  `kdj_j` DECIMAL(30,12) NULL,
  `rsi1` DECIMAL(30,12) NULL,
  `rsi2` DECIMAL(30,12) NULL,
  `rsi3` DECIMAL(30,12) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `stock_info_back_CODE_DATE_UNIQUE` (`stock_code` ASC, `ts_date` ASC) );